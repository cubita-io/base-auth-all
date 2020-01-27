package io.cubita.base.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cubita.base.auth.dao.service.IUserService;
import io.cubita.commons.RequestContext;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @Autowired
    private IUserService userService;

    @GetMapping("/hello")
    public String hello() {
        try {
            RequestContext.getCurrentContext().setTenant("test");
            return userService.getById(1).getName();
        } finally {
            RequestContext.getCurrentContext().unset();
        }

    }

}
