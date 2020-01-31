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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Controller
public class MyZuulexController {

    @RequestMapping("/zuulex")
    public String zuulex() {
        System.out.println("zuulex");
        return "zuulex";
    }

    /**
     * 请求转发过来的.
     * @param
     * @return
     */
    @RequestMapping("/bb/ac")
    public String zuulex2() {
        System.out.println("zuulex2");
        return "zuulex2";
    }

    /**
     * 请求转发过来的.
     * @param
     * @return
     */
    @RequestMapping("/ac")
    public String zuulex4() {
        System.out.println("zuulex4");
        return "zuulex4";
    }

    @RequestMapping("/re")
    @ResponseBody
    public String zuulex3() {
        System.out.println("zuulex3");
        return "zuulex3";
    }

}
