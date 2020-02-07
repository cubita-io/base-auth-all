/*
 * Copyright 2017-2019 Lemonframework Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.cubita.base.auth.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import io.cubita.autoconfigure.zuulex.context.RequestContext;
import io.cubita.autoconfigure.zuulex.filters.ZuulexProperties;
import io.cubita.autoconfigure.zuulex.filters.pre.TenantFilter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.mybatis.spring.annotation.MapperScan;

import static io.cubita.base.auth.commons.Constants.MAPPER_METHOD_WITHOUT_TENANT;
import static io.cubita.base.auth.commons.Constants.TABLE_WITHOUT_TENANT;
import static io.cubita.base.auth.commons.Constants.TENANT_COLUMN_NAME;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Configuration
@MapperScan({ "io.cubita.base.auth.dao.mapper", "io.cubita.base.auth.mydao.mapper" })
public class GlobalConfiguration {

    @Autowired(required = false)
    private ZuulexProperties zuulexProperties;


    @Bean
    public TenantFilter tenantFilter() {
        return new TenantFilter(zuulexProperties);
    }

    @Bean
    public SimpleMeterRegistry meterRegistry() {
        return new SimpleMeterRegistry();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));

        /*
         *  SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(buildTenantSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(metaObject -> {
            MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
            // 过滤自定义查询此时无租户信息约束
            if (Arrays.asList(MAPPER_METHOD_WITHOUT_TENANT).contains(ms.getId())) {
                return true;
            }
            return false;
        });

        return paginationInterceptor;
    }

    private TenantSqlParser buildTenantSqlParser() {
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(buildTenantHandler());
        return tenantSqlParser;
    }

    private TenantHandler buildTenantHandler() {
        return new TenantHandler() {
            @Override
            public Expression getTenantId(boolean where) {
                // 该 where 条件 3.2.0 版本开始添加的，用于区分是否为在 where 条件中使用
                // 如果是in/between之类的多个tenantId的情况，参考下方示例
                String tenantName = RequestContext.getCurrentContext().getTenant();
                if (!StringUtils.hasText(tenantName)) {
                    return new StringValue("");
                }
                return new StringValue(tenantName);
            }

            @Override
            public String getTenantIdColumn() {
                return TENANT_COLUMN_NAME;
            }

            @Override
            public boolean doTableFilter(String tableName) {
                // 这里可以判断是否过滤表
                if (Arrays.asList(TABLE_WITHOUT_TENANT).contains(tableName)) {
                    return true;
                }
                if (GlobalConfiguration.this.zuulexProperties == null) {
                    return false;
                }
                String tenantName = RequestContext.getCurrentContext().getTenant();
                String admin = zuulexProperties.getTenant().getAdmin();
                if (admin.equals(tenantName)) {
                    return true;
                }
                if (!admin.endsWith("/")) {
                    admin += "/";
                }
                if (tenantName != null && tenantName.startsWith(admin)) {
                    return true;
                }
                return false;
            }
        };
    }

}
