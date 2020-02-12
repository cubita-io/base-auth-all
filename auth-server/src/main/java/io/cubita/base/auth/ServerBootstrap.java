package io.cubita.base.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@SpringBootApplication
//@EnableZuulexServer
public class ServerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ServerBootstrap.class, args);
    }
}
