package com.letsbim.sample.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    /**
     * 上传文件
     * @param file
     */
    void upload(MultipartFile file);

    /**
     * 获取文件的状态
     * @param fileId
     */
    void getFileState(Long fileId);

    /**
     * 获取文件的viewToken
     * @param fileId
     * @return
     */
    String getFileViewToken(Long fileId);
}
