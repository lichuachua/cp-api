package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.CrewDetail;
import cn.yunding.cp.dto.ItemDetail;
import cn.yunding.cp.dto.ItemList;
import cn.yunding.cp.dto.ItemUploads;
import cn.yunding.cp.entity.Item;
import cn.yunding.cp.entity.ItemCrew;
import cn.yunding.cp.entity.ItemUpload;

import java.util.Date;
import java.util.List;

public interface ItemMapper {
    int addItem(Item item);

    int updateItem(Item item);

    int deleteItem(int itemId);

    int addCrew(ItemCrew itemCrew);

    int deleteCrew(int crewId);

//    ItemCrew selectitemByPassword(int itemId);

    void deleteCrewByItemId(int itemId);

    List<ItemList> selectAllItem();

    ItemDetail detailItem(int itemId);


    List<CrewDetail> detailCrew(int itemId);

    String selectUserNickByUserId(int userId);

    int selectUserIdByitemId(int itemId);

    ItemDetail detailItemNoPassword(int itemId);

    int addUpload(ItemUpload itemUpload);

    int selectItemIdByCrewId(int crewId);

    String selectItemnameByCrewId(int crewId);

    String selectCrewnameByCrewId(int crewId);

    int addUploads(ItemUploads itemUploads);


    int upUploads(ItemUploads itemUploads);

    Date selectDatelineByUploadIp(int uploadId);




    List<ItemList> selectMyItem(int itemId);

    Item selectitemByPassword(int itemId);

//    List<ItemUploads> getStuList(int itemId, String itemPassword);

    String selectitemPasswordByItemId(int itemId);

    List<ItemUploads> getStuList(int itemId);


    List<ItemUploads> getStuListnull();
}
