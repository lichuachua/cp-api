package cn.yunding.cp.web;

import cn.yunding.cp.dto.*;
import cn.yunding.cp.entity.UserEmail;
import cn.yunding.cp.service.UserEmailService;
import cn.yunding.cp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api/user")
public class UserEmailController extends UserBaseEmailController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserEmailService userEmailService;

    /**
     * 发送验证码
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findPassword",method = RequestMethod.POST)
    public RequestResult findPasswordByEmail(String email){
        try{
            ServiceResult result=userEmailService.findPassword(email);
            if (result.isSuccess()) {
                return RequestResult.success(result.getData());
            } else {
                return RequestResult.failure(result.getMessage());
            }

        }catch (Exception e){
            e.printStackTrace();
            return RequestResult.failure("该用户不存在");
        }
    }



/**
 * 判断验证码是否正确，正确则改密码，不正确则返回验证码错误
 */
    @ResponseBody
    @RequestMapping(value = "/verifycaptcha",method = RequestMethod.POST)
    public RequestResult verifycaptcha(UserFindPassword userFindPassword){
        try{
            ServiceResult result=userEmailService.verifycaptcha(userFindPassword);
            if (result.isSuccess()) {
                return RequestResult.success(result.getData());
            } else {
                return RequestResult.failure(result.getMessage());
            }

        }catch (Exception e){
            e.printStackTrace();
            return RequestResult.failure("验证码错误");
        }
    }
    /**
     * 验证成功，更改密码
     */
    @ResponseBody
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public RequestResult passwordUser(UserPassword userPassword,
                                      String confirmPassword){
        try{

            if (confirmPassword.equals(userPassword.getNewPassword())) {
                ServiceResult result = userEmailService.updatePassword(userPassword);
                if (result.isSuccess()) {
                    return RequestResult.success(result.getData());
                } else {
                    return RequestResult.failure(result.getMessage());
                }
            } else {
                return RequestResult.failure("两次密码不同 ");
            }
        }catch (Exception e){
            e.printStackTrace();
            return RequestResult.failure("修改密码失败 ");
        }
    }


}

