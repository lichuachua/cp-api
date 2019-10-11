package cn.yunding.cp.web.user;

import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Apply;
import cn.yunding.cp.exception.ServiceException;
import cn.yunding.cp.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * @author chentingDu
 */
@Controller
@RequestMapping("/api/apply")

public class ApplyController {

    @Autowired
    ApplyService applyService;
    /*
    *查询申请详情
     */
    @ResponseBody
    @RequestMapping("detial")
    public RequestResult selectDetial(int applyId){
            ServiceResult result = applyService.selectDetial(applyId);
            if(result.isSuccess()){
                return RequestResult.success(result.getData());
            }else
                return RequestResult.failure(result.getMessage());
    }
    /*
     * 查询我的所有申请
     */
    @ResponseBody
    @RequestMapping("findMyApply")
    public RequestResult findMyApply(int userId) {
        ServiceResult list =
               applyService.findMyApply(userId);
            return RequestResult.success(list.getData());
    }
    /*
    * 查询申请类型
    */
    @ResponseBody
    @RequestMapping("alltypes")
    public RequestResult findAllTypes(){
        ServiceResult result =
                applyService.findAllTypes();
            return RequestResult.success(result.getData());
    }
    /**
     * 发起申请
     */
    @ResponseBody
    @RequestMapping("/add")
    public RequestResult insert(Apply apply){
        try {
            ServiceResult result = applyService.insert(apply);
            if (result.isSuccess()) {
                return RequestResult.success(result.getData());
            } else
                return RequestResult.failure(result.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return RequestResult.failure(e.getMessage());
        }
    }
}
