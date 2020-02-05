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
package io.cubita.base.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.cubita.base.auth.dao.service.IUserService;

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

    @GetMapping("/{tenant}/hello")
    public String hello(@PathVariable String tenant) {
        int o = 1/0;
        return userService.getById(1).getName();
    }

    @GetMapping("/zuulex/{tenant}/hello")
    public String hello3() {
        System.out.println("333333333");
        return userService.getById(1).getName();
    }

    @GetMapping("/hello2")
    public String hello2() {
        System.out.println("2222222");
        return userService.getById(1).getName();
    }

    @GetMapping("/hello4")
    public ModelAndView hello4() {
        return new ModelAndView("hello");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> mediaTypeNotAcceptable(HttpServletRequest request) {
//        HttpStatus status = getStatus(request);
        return ResponseEntity.status(503).build();
    }

}
