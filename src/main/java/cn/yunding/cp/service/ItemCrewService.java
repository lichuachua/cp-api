package cn.yunding.cp.service;

import cn.yunding.cp.dto.CrewDetail;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ItemCrew;

public interface ItemCrewService {
    ServiceResult addCrew(ItemCrew itemCrew);

    ServiceResult deleteCrew(int itemId);


    ServiceResult detailCrew(int itemId);

    ServiceResult selectMyItem(int userId);
}
