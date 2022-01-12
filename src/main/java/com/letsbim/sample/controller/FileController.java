package com.letsbim.sample.controller;

import com.letsbim.sample.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 获取文件状态
     * @return
     */
    @GetMapping("/getFileState")
    public String getFile(@RequestParam("fileId")Long fileId){
        fileService.getFileState(fileId);
        return "getFile";
    }

    /**
     * 获取文件状态
     * @return
     */
    @GetMapping("/getFileViewToken")
    public String getFileViewToken(@RequestParam("fileId")Long fileId){
        fileService.getFileViewToken(fileId);
        return "getFile";
    }

    /**
     * 上传文件
     */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()) {
            return "view1";//是到error.html页面
        }
        fileService.upload(file);

//        String fileName = file.getOriginalFilename();
//        String filePath = "L:\\file\\";
//        File dest = new File(filePath + fileName);
//        try {
//            if (!dest.exists()){
//                dest.createNewFile();
//            }
//            file.transferTo(dest);
//            return "uploadFile";
//        } catch (IOException e) {
//        }
//        // 将src路径发送至html页面
//        model.addAttribute("filename", filename);
////        return "Page";
        return "view";
    }
}
