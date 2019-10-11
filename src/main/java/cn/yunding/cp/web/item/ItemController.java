package cn.yunding.cp.web.item;

import cn.yunding.cp.dto.ItemDetailBy;
import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Item;
import cn.yunding.cp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haoyuli
 */
@Controller
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    /**
     * 创建项目
     */
    @ResponseBody
    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public RequestResult addItem(Item item){
        try{
            //创建项目，先将组长的名字加到crew表中以便与crew为主   确定上传进度表

            if (item.getItemPassword().length()>4){
                ServiceResult result=itemService.addItem(item);
                if (result.isSuccess()){
                    return RequestResult.success(result.getData());

                }else {
                    return RequestResult.failure(result.getMessage());
                }
            }else {
                return RequestResult.failure("请输入大于四位的密码");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("创建失败");
        }
    }


    /**
     * 修改项目
     */
    @ResponseBody
    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    public RequestResult updateItem(Item item){
        try{
            //判断修改人是否为组长
            ServiceResult result=itemService.updateItem(item);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());

            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("修改失败");
        }
    }



    /**
     * 查看项目列表
     */
    @ResponseBody
    @RequestMapping("/selectAllItem")
    public RequestResult selectAllItem() {
        try{
            ServiceResult result=itemService.selectAllItem();
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询项目");
        }
    }


    /**
     * 查询项目详情
     */
    @ResponseBody
    @RequestMapping("/detailItem")
    public RequestResult detailItem(ItemDetailBy itemDetailBy){
       try{
           ServiceResult result=itemService.detailItem(itemDetailBy);
           if (result.isSuccess()){
               return RequestResult.success(result.getData());
           }else {
               return RequestResult.failure(result.getMessage());
           }
       }catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException("查询项目详情失败");
       }
    }

    /**
     * 项目完成 删除项目
     */
    @ResponseBody
    @RequestMapping(value = "/deleteItem",method = RequestMethod.POST)
    public RequestResult deleteItem(int itemId){
        try{
            ServiceResult result=itemService.deleteItem(itemId);
            if (result.isSuccess()){
                return RequestResult.success("删除成功");

            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("创建失败");
        }
    }
}
