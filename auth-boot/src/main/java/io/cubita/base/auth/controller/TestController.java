package io.cubita.base.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import io.cubita.base.auth.mock.v1x0x0.MockService;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private MockService mockService;

    @GetMapping("/test")
    public String tests() {
        return JSONArray.toJSONString(mockService.exec(0));
    }

    @GetMapping("/test/{level}")
    public String tests(@PathVariable int level) {
        return JSONArray.toJSONString(mockService.exec(level));
    }

}
