package cn.yunding.cp.web.item;

import cn.yunding.cp.dto.CrewDetail;
import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ItemCrew;
import cn.yunding.cp.service.ItemCrewService;
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
public class ItemCrewController {
    @Autowired
    ItemCrewService itemCrewService;
    /**
     * 加入项目
     */
    @ResponseBody
    @RequestMapping(value = "/addCrew",method = RequestMethod.POST)
    public RequestResult addCrew(ItemCrew itemCrew){
        try{
        ServiceResult result=itemCrewService.addCrew(itemCrew);
        if (result.isSuccess()){
            return RequestResult.success(result.getData());
        }else {
            return RequestResult.failure(result.getMessage());
        }
    }catch (Exception e){
        e.printStackTrace();
        throw new RuntimeException("密码错误，加入失败");
    }

    }
    /**
     * 查询出项目详情后，查看此项目下的全部组员
     */
    @ResponseBody
    @RequestMapping("/detailCrew")
    public RequestResult detailCrew(int itemId){
        try{
            ServiceResult result=itemCrewService.detailCrew(itemId);
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
     * 退出项目
     */
    @ResponseBody
    @RequestMapping(value = "/deleteCrew",method = RequestMethod.POST)
    public RequestResult deleteCrew(int crewId){
        try{
            ServiceResult result=itemCrewService.deleteCrew(crewId);
            if (result.isSuccess()){
                return RequestResult.success("退出成功");

            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("退出失败");
        }
    }


    //查询我的所有项目
    @ResponseBody
    @RequestMapping("/selectMyItem")
    public RequestResult selectMyItem(int userId){
        try{
            ServiceResult result=itemCrewService.selectMyItem(userId);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());

            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询我的所有项目失败");
        }
    }





}
