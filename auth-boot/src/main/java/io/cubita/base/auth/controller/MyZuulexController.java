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
