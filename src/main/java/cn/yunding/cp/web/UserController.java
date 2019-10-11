package cn.yunding.cp.web;

import cn.yunding.cp.dto.*;
import cn.yunding.cp.entity.UserIdentity;
import cn.yunding.cp.enums.UserStateEnum;
import cn.yunding.cp.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author haoyuli
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 注册用户
     * @param userIdentity
     * @param confirmPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RequestResult registerUser(UserIdentity userIdentity, String confirmPassword) {
        try {

            //判断用户名是否合格
            if (userIdentity.getUsername() != null ){//userIdentity.getUsername() != null  为检验提交的表单是否有username，并不是看username是否为空
                if (userIdentity.getUsername().length()==0){//userIdentity.getUsername().length()==0  看调教的username是否为空；
                    return RequestResult.failure("用户名不能为空,请输入你的用户名");
                }
            }
            //判断密码是否合格
            if (userIdentity.getPassword()!=null){
                if (userIdentity.getPassword().length()<8){//密码需要大于八位
                    return RequestResult.failure("密码小于八位数，请重新 输入密码");
                }
            }
            //判断两次密码是否相同
            if (confirmPassword.equals(userIdentity.getPassword())) {
                ServiceResult result = userService.register(userIdentity);
                if (result.isSuccess()) {
                    return RequestResult.success(result.getData());
                } else {
                    return RequestResult.failure(result.getMessage());
                }
            }else {
                return RequestResult.failure("请确认两次输入的密码是相同的");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequestResult.failure("注册失败了");
        }
    }
    /**
     * 用户登录
     * @param userLogin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)

    public SysResult loginUser(UserLogin userLogin) {

        try {
            UserExecutor userExecutor = userService.login(userLogin);

            if (userExecutor.getState() == UserStateEnum.SUCCESS.getState()) {
                return SysResult.success(userExecutor.getJwt());
            } else {
                return SysResult.fail(userExecutor.getMessage());

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public RequestResult queryUer(int userId){
        try{
            ServiceResult result=userService.query(userId);
            if (result.isSuccess()) {
                return RequestResult.success(result.getData());
            } else {
                return RequestResult.failure(result.getMessage());
            }

        }catch (Exception e){
            e.printStackTrace();
            return RequestResult.failure("没有找到id号为"+userId+"的用户");
        }

    }

    /**
     * 修改用户密码
     * @param userPassword
     * @param confirmPassword
     * @return
     */
    @ResponseBody
    @RequestMapping("/password")
    public RequestResult passwordUser(UserPassword userPassword,
                                      String confirmPassword){
        try{
                    if (userPassword.getNewPassword().length()<8){
                        return RequestResult.failure("密码不能小于8位");
                    }else {
                        if (confirmPassword.equals(userPassword.getNewPassword())) {
                            ServiceResult result = userService.password(userPassword);
                            if (result.isSuccess()) {
                                return RequestResult.success(result.getData());
                            } else {
                                return RequestResult.failure(result.getMessage());
                            }
                        } else {
                            return RequestResult.failure("两次密码不同 ");
                        }
                    }


        }catch (Exception e){
            e.printStackTrace();
            return RequestResult.failure("修改密码失败 ");
        }
    }

    /**
     * 更改用户信息
     * @param userUpdate
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RequestResult updateUser(UserUpdate userUpdate){
        try{
            ServiceResult result=userService.update(userUpdate);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            return RequestResult.failure("用户信息修改失败 ");

        }
    }
    /**
     * 更换头像
     * @param userAvatar
     * @param pic
     * @param request
     * @return
     */
        @ResponseBody
        @RequestMapping("/avatar")
        public RequestResult avatarUser(UserAvatar userAvatar,
                                        MultipartFile pic,
                                        HttpServletRequest request){
            try{
                String realPath=request.getServletContext().getRealPath("/upload");
                ServiceResult result=userService.avatar(userAvatar,pic,realPath);
                if (result.isSuccess()){
                    return RequestResult.success(result.getData());
                }else {
                    return RequestResult.failure(result.getMessage());
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("更换头像失败");
            }
        }
}