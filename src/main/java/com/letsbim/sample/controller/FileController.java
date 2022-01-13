package com.letsbim.sample.controller;

import com.letsbim.sample.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lichunlan
 * @description 文件处理
 * @since 2022-01-10
 */
@Controller
public class FileController {
    @Autowired
    private IFileService fileService;
    /**
     * 第一步：上传文件
     */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()) {
            return "upload";
        }
        Long fileId = fileService.upload(file);
        model.addAttribute("fileId", fileId);
        return "upload";
    }


    /**
     * 第二步：转换文件
     * @return
     */
    @GetMapping("/translateFile")
    public String translateFile(@RequestParam("fileId")Long fileId, Model model){
        boolean result = fileService.translateFile(fileId);
        model.addAttribute("translateResult", result);
        model.addAttribute("fileId", fileId);
        return "upload";
    }
    /**
     * 第三步：获取文件状态
     * @return
     */
    @GetMapping("/getFileState")
    public String getFileState(@RequestParam("fileId")Long fileId,Model model){
        String fileState = fileService.getFileState(fileId);
        model.addAttribute("fileState", fileState);
        model.addAttribute("fileId", fileId);
        return "upload";
    }

    /**
     * 第四步：获取文件ViewToken
     * @return
     */
    @GetMapping("/getFileViewToken")
    public String getFileViewToken(@RequestParam("fileId")Long fileId, Model model){
        String fileViewToken = fileService.getFileViewToken(fileId);
        model.addAttribute("viewToken", fileViewToken);
        model.addAttribute("fileId", fileId);
        return "view";
    }


}
