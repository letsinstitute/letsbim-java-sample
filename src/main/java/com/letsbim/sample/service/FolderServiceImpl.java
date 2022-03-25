package com.letsbim.sample.service;

import com.lets.bim.sdk.client.LetsBimClient;
import com.lets.bim.sdk.client.Result;
import com.lets.bim.sdk.entity.Folder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lichunlan
 * @description 文件夹
 * @since 2022-01-14
 */
@Service
public class FolderServiceImpl implements IFolderService{
    @Value(value = "${letsbim.sdk.endPoint}")
    private String endPoint;

    @Value(value = "${letsim.sdk.appKey}")
    private String appKey;

    @Value(value = "${letsbim.sdk.appSecret}")
    private String appSecret;
    private LetsBimClient letsBimClient = null;
    @Override
    public List<Folder> getFolderList() {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        Result<List<Folder>> folderList = letsBimClient.queryFolderList();
        if(null != folderList.getResult()){
            return folderList.getResult();
        }
        return null;
    }

    @Override
    public Result<Long> addFolder(String folderName, Long parentId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        Result<Long> folderResult;
        if(null == parentId){
            folderResult = letsBimClient.createFolder(folderName);
        }else{
            folderResult =  letsBimClient.createFolder(folderName,parentId);
        }
        return folderResult;

    }

    @Override
    public void deleteFolder(Long folderId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        letsBimClient.deleteFolder(folderId);
    }

    @Override
    public void updateFolder(String folderName, Long folderId) {
        if(null == letsBimClient){
            letsBimClient = new LetsBimClient(endPoint,appKey,appSecret);
        }
        letsBimClient.updateFolder(folderId,folderName);
    }
}
