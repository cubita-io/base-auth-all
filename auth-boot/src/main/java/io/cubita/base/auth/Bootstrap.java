package io.cubita.base.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("io.cubita.base.auth.dao.mapper")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
