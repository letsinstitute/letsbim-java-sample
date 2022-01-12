package com.letsbim.sample.service;

import com.lets.bim.sdk.client.LetsBimClient;
import com.lets.bim.sdk.entity.Result;
import com.lets.bim.sdk.entity.TranslateInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author lichunlan
 * @description 文件
 * @since 2022-01-11
 */
@Service
public class FileServiceImpl implements IFileService {
    @Value(value = "${letsbim.sdk.endPoint}")
    private String endPoint;

    @Value(value = "${letsim.sdk.appKey}")
    private String appKey;

    @Value(value = "${letsbim.sdk.appSecret}")
    private String appSecret;
    private LetsBimClient letsBimClient = null;

    @Override
    public void upload(MultipartFile file){
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        //todo 第一步 调用服务端API上传文件接口
        Long fileId = null;
        try {
            Result<Long> result = letsBimClient.upload(file.getInputStream(), file.getOriginalFilename());
            if(null != result.getResult()){
                fileId = result.getResult().longValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //todo 第二步 发起转换接口
        if(null != fileId){
            TranslateInfo translateInfo = new TranslateInfo();
            translateInfo.setFileId(fileId);
            letsBimClient.translate(translateInfo);
        }

    }

    @Override
    public void getFileState(Long fileId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
      //todo  调用SDK获取文件转换状态
    }

    @Override
    public String getFileViewToken(Long fileId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        return null;
    }
}
