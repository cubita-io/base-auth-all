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
package io.cubita.base.commons;

/**
 * <p>
 *     常量
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public interface Constants {
    /**
     * 过滤表无租户信息约束.
     */
    String[] TABLE_WITHOUT_TENANT         = "t_role,t_authorized_uri,t_tenant".split(",");
    /**
     * 过滤自定义查询此时无租户信息约束.
     */
    String[] MAPPER_METHOD_WITHOUT_TENANT = "".split(",");
    String   TENANT_COLUMN_NAME           = "tenant_name";
}
