package cn.yunding.cp.service;

import cn.yunding.cp.dto.ItemDetailBy;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Item;
import cn.yunding.cp.entity.ItemUpload;

public interface ItemService {
    ServiceResult addItem(Item item);

    ServiceResult updateItem(Item item);

    ServiceResult deleteItem(int itemId);


    ServiceResult selectAllItem();

    ServiceResult detailItem(ItemDetailBy itemDetailBy);

}
