package io.cubita.base.auth.configuration;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */

import org.springframework.context.annotation.Configuration;

import org.mybatis.spring.annotation.MapperScan;


@Configuration(proxyBeanMethods = false)
@MapperScan({ "io.cubita.base.auth.dao.mapper" })
public class GlobalConfiguration {
}
