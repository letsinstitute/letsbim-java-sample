package com.letsbim.sample.service;

import com.lets.bim.sdk.client.LetsBimClient;
import com.lets.bim.sdk.client.Result;
import com.lets.bim.sdk.entity.TranslateInfo;
import com.lets.bim.sdk.entity.TranslateResult;
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
    public Result<Long> upload(MultipartFile file,Long folderId){
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        //第一步 调用服务端API上传文件接口
        Result<Long> result = null;
        try {
            if(null == folderId){
                result = letsBimClient.upload(file.getInputStream(), file.getSize(), file.getOriginalFilename());
            } else {
                result = letsBimClient.upload(file.getInputStream(), file.getSize(), file.getOriginalFilename(), folderId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return result;
    }

    @Override
    public String getFileState(Long fileId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
       //调用SDK获取文件转换状态
        Result<TranslateResult> translateResult = letsBimClient.getTranslateResult(fileId);
        String result  = null;
        if(null != translateResult.getResult()){
            Integer status = translateResult.getResult().getStatus();
            switch (status){
                case 0  :
                    result = "上传完成";
                    break;
                case 1  :
                    result = "未转换";
                    break;
                case 2 :
                    result = "转换中";
                    break;
                case 3  :
                    result = "转换完成";
                    break;
                case 4  :
                    result = "转换失败";
                    break;
                case 5  :
                    result = "等待转化";
                    break;
                case 6  :
                    result = "取消转换";
                    break;
            }
        }else{
            result = translateResult.getMessage();
        }
        return  result;
    }

    @Override
    public String getFileViewToken(Long fileId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        Result<String> result = letsBimClient.getViewToken(fileId);
        if(null != result.getResult()){
            return  result.getResult();
        }
        return null;
    }

    @Override
    public  Result<Boolean> translateFile(Long fileId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        TranslateInfo translateInfo = new TranslateInfo();
        translateInfo.setFileId(fileId);
        Result<Boolean> result = letsBimClient.translate(translateInfo);
        return  result;
    }
}
