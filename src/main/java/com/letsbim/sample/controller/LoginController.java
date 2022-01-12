package com.letsbim.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lichunlan
 * @description 登录
 * @since 2022-01-10
 */
@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(String name,String password){
        return "upload";
    }
}
