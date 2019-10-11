package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.*;
import cn.yunding.cp.entity.User;
import cn.yunding.cp.entity.UserEmail;
import cn.yunding.cp.mapper.UserEmailMapper;
import cn.yunding.cp.mapper.UserIdentityMapper;
import cn.yunding.cp.service.UserEmailService;
import cn.yunding.cp.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class UserEmailServiceImpl implements UserEmailService{


    @Autowired
    UserEmailMapper userEmailMapper;
    @Autowired
    UserIdentityMapper userIdentityMapper;
    @Autowired
    UserService userService;

    /**
     * 找用户email
     * @param email
     * @return
     */
    public ServiceResult findPassword(String email){

        try{
            User a=userEmailMapper.findPassword(email);
            if (a!=null) {
//                Email em=new Email();
//                Mail.send(em.getReceive(email),em.getTitle(),em.getBody());
                //根据用户邮箱找到用户名

                Long userId=userEmailMapper.selectUserIdByEmail(email);
                String username=userEmailMapper.selectUsernameByUserId(userId);
                String filename= RandomStringUtils.randomAlphanumeric(6);

                Mail.send(email,"云极寻找密码","尊贵的"+username+"用户："+"您的验证码为"+filename+"请在5分钟内完成操作！");
                UserEmail a1=userEmailMapper.selectByEmail(email);

                UserEmail userEmail = new UserEmail();

//              userEmail.setUserId(userEmail.getUserId());
                Date d=new Date();
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                System.out.println("今天的日期："+df.format(d));
//                System.out.println("两天前的日期：" + df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000)));
//                System.out.println("三天后的日期：" + df.format(new Date(d.getTime() + 3 * 24 * 60 * 60 * 1000)));

                userEmail.setEmail(email);
                userEmail.setCaptcha(filename);
                userEmail.setUpdateAt(new Date());
                userEmail.setCreateAt(new Date());
                userEmail.setDateline(df.format(new Date(d.getTime()+5 * 60 * 1000)));

                if (a1==null) {
                    int aa = userEmailMapper.savecaptcha(userEmail);
                    if (aa != 1) {
                        return ServiceResult.failure("shujuku baocun shibai了");
                    }
                }else {
                    int a2=userEmailMapper.updatecaptcha(userEmail);
                    if (a2==1){
                        return ServiceResult.success("数据库保存成功");
                    }
                }
                return ServiceResult.success("验证码发送成功");


            }else {
                return ServiceResult.failure("没有该email的用户");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("获取用户email失败");
        }
    }
    /**
     * 验证码是否过期  邮箱  验证是否正确
     */
    public ServiceResult verifycaptcha(UserFindPassword userFindPassword){

        try{
            //根据email取出用户截止时间与当前时间相比较
            String date=userEmailMapper.selectDateline(userFindPassword.getEmail());
            Date d=new Date();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String a=df.format(d);
            int res=date.compareTo(a);
            //res小于0则date<a
            if (res<0){
                return ServiceResult.failure("验证码过期");
            }else{
                UserFindPassword u=userEmailMapper.verifycaptchaByEmail(userFindPassword);
                if (u.getEmail().equals(userFindPassword.getEmail())){
                    if(u.getCaptcha().equals(userFindPassword.getCaptcha())){
                        return ServiceResult.success("验证码和email正确，可以更改密码");
                    }else {
                        return ServiceResult.failure("验证码或email错误");
                    }
                }else {
                    return ServiceResult.failure("验证码或email错误");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("密码修改失败");
        }
    }
    /**
     * 改密码
     */
    public ServiceResult updatePassword(UserPassword userPassword){
        try{
                userPassword.setUpdateAt(new Date());
                int a=userIdentityMapper.password(userPassword);
                if (a==1){
                    return ServiceResult.success("密码更新成功");
                }
                else {
                    return ServiceResult.failure("密码修改错误");
                }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("密码修改错误");
        }
    }

}
