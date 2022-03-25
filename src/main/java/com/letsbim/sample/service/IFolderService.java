package com.letsbim.sample.service;

import com.lets.bim.sdk.client.Result;
import com.lets.bim.sdk.entity.Folder;

import java.util.List;

/**
 * 文件夹的接口
 */
public interface IFolderService {

    /**
     * 获取文件夹列表
     * @return
     */
    List<Folder> getFolderList();

    /**
     * 添加文件夹
     * @param folderName
     * @param parentId
     */
    Result<Long> addFolder(String folderName, Long parentId);

    /**
     * 删除文件夹
     * @param folderId
     */
    void deleteFolder(Long folderId);

    /**
     * 编辑文件夹信息
     * @param folderName
     * @param folderId
     */
    void updateFolder(String folderName,Long folderId);
}
