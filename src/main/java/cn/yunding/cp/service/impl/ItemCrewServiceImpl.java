package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.CrewDetail;
import cn.yunding.cp.dto.ItemList;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Item;
import cn.yunding.cp.entity.ItemCrew;
import cn.yunding.cp.mapper.ItemMapper;
import cn.yunding.cp.service.ItemCrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author haoyuli
 */
@Service
public class ItemCrewServiceImpl implements ItemCrewService {
    @Autowired
    ItemMapper itemMapper;



    /**
     * 加入项目
     */
    @Override
    public ServiceResult addCrew(ItemCrew itemCrew){
        try{
            Item itemPassword=itemMapper.selectitemByPassword(itemCrew.getItemId());
            if (itemPassword.getItemPassword().equals(itemCrew.getItemPassword())){
                String uNick =itemMapper.selectUserNickByUserId(itemCrew.getUserId());
                itemCrew.setItemName(itemPassword.getItemName());
                itemCrew.setCrewName(uNick);
                itemCrew.setCreateAt(new Date());
                itemCrew.setUpdateAt(new Date());
                int result=itemMapper.addCrew(itemCrew);
                if (result==1){
                    return ServiceResult.success(itemCrew);
                }else {
                    return ServiceResult.failure("操作失败");
                }
            }else {
                return ServiceResult.failure("密码错误");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("创建项目失败");
        }
    }

    /**
     *查询项目成员详情
     */
    public ServiceResult detailCrew(int itemId){
        try{
            List<CrewDetail> result=itemMapper.detailCrew(itemId);
            if (result!=null){
                return ServiceResult.success(result);
            }else {
                return ServiceResult.failure("查询项目详情失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询项目详情失败");
        }
    }





    /**
     * 退出项目
     */
    public  ServiceResult deleteCrew(int crewId){
        try{
            int result=itemMapper.deleteCrew(crewId);
            if (result==1){
                return ServiceResult.success(crewId);

            }else {
                return ServiceResult.failure("删除项目失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new  RuntimeException("删除项目错误");
        }
    }


    /**
     * 查询我的所有项目列表
     */
    /**
     * 查询项目列表
     */
    public ServiceResult selectMyItem(int userId){
        try{
            //根据userId查出itemId，再由itemId查出详情
//            ItemCrew itemCrew=itemMapper.selectMyItemId(userId);


//            try{
                //根据userId查出itemId，再由itemId查出详情
//            List<ItemCrew> itemCrew;
//            itemCrew = itemMapper.selectMyItemId(userId);
                //查询出list数组中每一条数据的itemId
//            for (int i=1;i<itemCrew.size();i++){
//                itemCrew.get(i);
//            }
//            for ( ItemCrew i:itemCrew){
//
//            }
//                List<ItemList> result=itemMapper.selectMyItem(userId);
//                if (result.size()>0){
//                    return ServiceResult.success(result);
//                }else {
//                    return ServiceResult.failure("查询项目列表失败");
//                }
            List<ItemList> result=itemMapper.selectMyItem(userId);
            if (result.size()>0){
                return ServiceResult.success(result);
            }else {
                return ServiceResult.failure("查询项目列表失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询项目列表失败");
        }
    }

}
