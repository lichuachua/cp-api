package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.ItemDetail;
import cn.yunding.cp.dto.ItemDetailBy;
import cn.yunding.cp.dto.ItemList;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Item;
import cn.yunding.cp.entity.ItemCrew;
import cn.yunding.cp.mapper.ItemMapper;
import cn.yunding.cp.service.ItemService;
import cn.yunding.cp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author  haoyuli
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    UserService userService;


    /**
     * 添加项目
     * @param item
     * @return
     */
    @Override
    public ServiceResult addItem(Item item){
        try{


            String uNick =itemMapper.selectUserNickByUserId(item.getUserId());
            item.setLeader(uNick);
            item.setCreateAt(new Date());
            item.setUpdateAt(new Date());
            int result=itemMapper.addItem(item);
            if (result==1){
                //创建项目时  先将组长插入到crew表中以便于以后的提交项目进度（提交项目进度时候用crew表）
//                ItemCrew itemCrew=new ItemCrew();
//                itemCrew.setUserId(item.getUserId());
//                //获取当前创建的itemId
//
//
//
//                itemCrew.setItemId(item.getItemId());
//
//
//
//                itemCrew.setCrewName(uNick);
//                itemCrew.setCreateAt(new Date());
//                itemCrew.setUpdateAt(new Date());
//                int result1=itemMapper.addCrew(itemCrew);
//                if (result1==1){

                    return ServiceResult.success(item);
                }else {
                    return ServiceResult.failure("创建项目失败");
                }

//            }else {
//                return ServiceResult.failure("操作失败");
//            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("创建项目失败");
        }
    }
    /**
     * 更改项目
     */
    public ServiceResult updateItem(Item item){
        try{
            //根据项目id查找组长，修改人为组长时才能够修改，组员不能修改
            int i=itemMapper.selectUserIdByitemId(item.getItemId());
            if (i==item.getUserId()){
                item.setUpdateAt(new Date());
                int result=itemMapper.updateItem(item);
                if (result==1){
                    return ServiceResult.success(item);
                }else {
                    return ServiceResult.failure("操作失败");
                }
            }else {
                return ServiceResult.failure("非组长，不能修改");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("创建项目失败");
        }
    }


    /**
     * 查询项目列表
     */
    public ServiceResult selectAllItem(){
        try{
            List<ItemList> result=itemMapper.selectAllItem();
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


    /**
     *查询项目详情
     */
    public ServiceResult detailItem(ItemDetailBy itemDetailBy){
        try{
            int userId=itemMapper.selectUserIdByitemId(itemDetailBy.getItemId());
            //组长查看  可见密码
            if (userId==itemDetailBy.getUserId()){
                ItemDetail itemDetail=itemMapper.detailItem(itemDetailBy.getItemId());
                if (itemDetail!=null){
                    return ServiceResult.success(itemDetail);
                }else {
                    return ServiceResult.failure("查询项目详情失败");
                }
                //非组长查看  不可见密码
            }else {
                ItemDetail itemDetail=itemMapper.detailItemNoPassword(itemDetailBy.getItemId());
                if (itemDetail!=null){
                    return ServiceResult.success(itemDetail);
                }else {
                    return ServiceResult.failure("查询项目详情失败");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询项目详情失败");
        }
    }

    /**
     * 项目完成，删除项目
     */
    public  ServiceResult deleteItem(int itemId){
        try{
            //将crew表的有关数据也删除
            itemMapper.deleteCrewByItemId(itemId);
            int result=itemMapper.deleteItem(itemId);
            if (result!=0){
                return ServiceResult.success(itemId);

            }else {
                return ServiceResult.failure("删除项目失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new  RuntimeException("删除项目错误");
        }
    }

}
