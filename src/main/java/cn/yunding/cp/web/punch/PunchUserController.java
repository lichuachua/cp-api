package cn.yunding.cp.web.punch;

import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.UserCreateAt;
import cn.yunding.cp.entity.PunchUser;
import cn.yunding.cp.entity.Punchs;
import cn.yunding.cp.service.PunchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haoyuli
 */
@Controller
@RequestMapping("api/punch")
public class PunchUserController {
    @Autowired
    PunchUserService punchUserService;
    /**
     * charu
     */
    @ResponseBody
    @RequestMapping("/insert")
    public RequestResult insert(Punchs punchs){
        try{
            ServiceResult result=punchUserService.insert(punchs);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("未添加");
        }
    }
    /**
     * 上午上班打卡
     */
    @ResponseBody
    @RequestMapping("/amStartP")
    public RequestResult amStartP(PunchUser punchUser){
        try{
            ServiceResult result=punchUserService.amStartP(punchUser);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("dakasb");
        }
    }
//    /**
//     * 上午下班打卡
//     */
//    @ResponseBody
//    @RequestMapping("/amEndP")
//    public RequestResult amEndP(UserCreateAt userCreateAt){
//        try{
//            ServiceResult result=punchUserService.amEndP(userCreateAt);
//            if (result.isSuccess()){
//                return RequestResult.success(result.getData());
//            }else {
//                return RequestResult.failure(result.getMessage());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("dakasb");
//        }
//    }
//
//    /**
//     * 下午上班打卡
//     */
//    @ResponseBody
//    @RequestMapping("/pmStartP")
//    public RequestResult pmStartP(UserCreateAt userCreateAt){
//        try{
//            ServiceResult result=punchUserService.pmStartP(userCreateAt);
//            if (result.isSuccess()){
//                return RequestResult.success(result.getData());
//            }else {
//                return RequestResult.failure(result.getMessage());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("dakasb");
//        }
//    }
//    /**
//     * 下午下班打卡
//     */
//    @ResponseBody
//    @RequestMapping("/pmEndP")
//    public RequestResult pmEndP(UserCreateAt userCreateAt){
//        try{
//            ServiceResult result=punchUserService.pmEndP(userCreateAt);
//            if (result.isSuccess()){
//                return RequestResult.success(result.getData());
//            }else {
//                return RequestResult.failure(result.getMessage());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("dakasb");
//        }
//    }
//    /**
//     * 下午上班打卡
//     */
//    @ResponseBody
//    @RequestMapping("/nightStartP")
//    public RequestResult nightStartP(UserCreateAt userCreateAt){
//        try{
//            ServiceResult result=punchUserService.nightStartP(userCreateAt);
//            if (result.isSuccess()){
//                return RequestResult.success(result.getData());
//            }else {
//                return RequestResult.failure(result.getMessage());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("dakasb");
//        }
//    }
//    /**
//     * 晚上下班打卡
//     */
//    @ResponseBody
//    @RequestMapping("/nightEndP")
//    public RequestResult nightEndP(UserCreateAt userCreateAt){
//        try{
//            ServiceResult result=punchUserService.nightEndP(userCreateAt);
//            if (result.isSuccess()){
//                return RequestResult.success(result.getData());
//            }else {
//                return RequestResult.failure(result.getMessage());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("dakasb");
//        }
//    }
}
