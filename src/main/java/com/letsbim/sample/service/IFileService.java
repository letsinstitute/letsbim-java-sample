package com.letsbim.sample.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    /**
     * 上传文件
     * @param file
     */
    Long upload(MultipartFile file,Long folderId);

    /**
     * 获取文件的状态
     * @param fileId
     */
    String getFileState(Long fileId);

    /**
     * 获取文件的viewToken
     * @param fileId
     * @return
     */
    String getFileViewToken(Long fileId);

    /**
     * 转换文件
     * @param fileId
     * @return true:操作成功  false：操作失败
     */
    boolean translateFile(Long fileId);
}
