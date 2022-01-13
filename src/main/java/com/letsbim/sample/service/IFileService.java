package com.letsbim.sample.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    /**
     * 上传文件
     * @param file
     */
    Long upload(MultipartFile file);

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
     * @return true:转成成功  false：转换失败
     */
    boolean translateFile(Long fileId);
}
