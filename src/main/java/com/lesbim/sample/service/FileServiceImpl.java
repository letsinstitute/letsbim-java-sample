package com.lesbim.sample.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lichunlan
 * @description 文件
 * @since 2022-01-11
 */
@Service
public class FileServiceImpl implements IFileService {
    //todo 注解加入sdk的client
    @Override
    public void upload(MultipartFile file) {
        //todo 第一步 调用服务端API上传文件接口
        //todo 第二步 发起转换接口
    }

    @Override
    public void getFileState(Long fileId) {
      //todo  调用SDK获取文件转换状态
    }

    @Override
    public String getFileViewToken(Long fileId) {
        return null;
    }
}
