package com.lesbim.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lichunlan
 * @description 文件处理
 * @since 2022-01-10
 */
@Controller
public class FileController {
    /**
     * 获取文件
     * @return
     */
    @GetMapping("/getFile")
    public String getFile(){
        return "getFile";
    }

    /**
     * 上传文件
     */
    @PostMapping("/uploadFile")
    public String uploadFile(){
        return "uploadFile";
    }
}
