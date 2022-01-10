package com.lesbim.sample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichunlan
 * @description 登录
 * @since 2022-01-10
 */
@RestController
public class LoginController {
    @PostMapping("/login")
    public String login(String name,String password){
        return "测试login接口";
    }
}
