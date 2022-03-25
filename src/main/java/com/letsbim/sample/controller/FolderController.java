package com.letsbim.sample.controller;

import com.lets.bim.sdk.entity.Folder;
import com.lets.bim.sdk.client.Result;
import com.letsbim.sample.service.IFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author lichunlan
 * @description 文件夹的
 * @since 2022-01-14
 */
@Controller
public class FolderController {
    @Autowired
    private IFolderService folderService;
    /**
     * 获取文件夹列表
     * @return
     */
    @GetMapping("/getFolderList")
    public String getFolderList(Model model){
        List<Folder> folderList = folderService.getFolderList();
        model.addAttribute("folders",folderList);
        return "upload";
    }

    @PostMapping("/addFolder")
    public String addFolder(Model model,String folderName){
        Result<Long> result = folderService.addFolder(folderName, null);
        if(null != result.getResult()){
            model.addAttribute("folderId",result.getResult());
        }else{
            model.addAttribute("folderNameIsNull",result.getMessage());
        }

        return "upload";
    }
}
