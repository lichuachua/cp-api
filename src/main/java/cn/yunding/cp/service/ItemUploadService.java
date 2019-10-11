package cn.yunding.cp.service;

import cn.yunding.cp.dto.ItemUploads;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ItemUpload;

import java.io.InputStream;

public interface ItemUploadService {
    ServiceResult addUpload(ItemUpload upload);

    ServiceResult addUploads(ItemUploads itemUploads);



    ServiceResult upUploads(ItemUploads itemUploads);

    InputStream getInputStream(int itemId, String itemPassword) throws Exception;

    InputStream getInputStreamnull() throws Exception;


//    InputStream getInputStream(int itemId) throws Exception;
}
