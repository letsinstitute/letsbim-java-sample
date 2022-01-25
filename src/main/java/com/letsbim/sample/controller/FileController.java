package com.letsbim.sample.controller;

import com.lets.bim.sdk.entity.Result;
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
    public String uploadFile(@RequestParam("file") MultipartFile file,Long folderId, Model model){
        if (file.isEmpty()) {
            return "upload";
        }
        Result<Long> uploadResult = fileService.upload(file, folderId);
        if(null != uploadResult.getResult()){
            model.addAttribute("fileId",  uploadResult.getResult().longValue());
        }else{
            model.addAttribute("exceptionMessage",  uploadResult.getMessage());
        }

        return "upload";
    }


    /**
     * 第二步：转换文件
     * @return
     */
    @GetMapping("/translateFile")
    public String translateFile(Long fileId, Model model){
        Result<Boolean> translateFileResult = fileService.translateFile(fileId);
        String showResult = null;
        if(null != translateFileResult.getResult()){
            showResult = "操作成功";
        }else{
            showResult = translateFileResult.getMessage();
        }
        model.addAttribute("translateResult", showResult);
        model.addAttribute("fileId", fileId);
        return "upload";
    }
    /**
     * 第三步：获取文件状态
     * @return
     */
    @GetMapping("/getFileState")
    public String getFileState(Long fileId,Model model){
        String fileState = fileService.getFileState(fileId);
        model.addAttribute("fileState", fileState);
//        model.addAttribute("translateResult", "操作成功");
        model.addAttribute("fileId", fileId);
        return "upload";
    }

    /**
     * 第四步：获取文件ViewToken
     * @return
     */
    @GetMapping("/getFileViewToken")
    public String getFileViewToken(Long fileId, Model model){
        String fileViewToken = fileService.getFileViewToken(fileId);
        model.addAttribute("viewToken", fileViewToken);
        model.addAttribute("fileId", fileId);
        return "view";
    }


}
