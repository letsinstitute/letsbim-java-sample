package com.letsbim.sample.service;

import com.lets.bim.sdk.entity.Result;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    /**
     * 上传文件
     * @param file
     */
    Result<Long> upload(MultipartFile file,Long folderId);

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
     * @return 转换结果
     */
    Result<Boolean> translateFile(Long fileId);
}
