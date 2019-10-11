package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.*;
import cn.yunding.cp.entity.User;
import cn.yunding.cp.entity.UserIdentity;
import cn.yunding.cp.enums.UserStateEnum;
import cn.yunding.cp.mapper.UserIdentityMapper;
import cn.yunding.cp.mapper.UserLoginMapper;
import cn.yunding.cp.mapper.UserMapper;
import cn.yunding.cp.service.UserService;
import cn.yunding.cp.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author haoyuli
 */
@Service
public class  UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserIdentityMapper userIdentityMapper;
    @Autowired
    UserLoginMapper userLoginMapper;


    @Transactional
    @Override
    /**
     * 用户注册
     */
    public ServiceResult register(UserIdentity userIdentity) {

        try {

            //判断用户名是否存在
            UserIdentity userIdentityInDb = userIdentityMapper.selectByUsername(userIdentity.getUsername());
            if (userIdentityInDb != null) {
                return ServiceResult.failure("注册失败，已经有相同的用户名");
            }

            // 1.创建User对象并插入数据库
            User user = new User();
            user.setAvatar("adsds");
            String filename= RandomStringUtils.randomAlphanumeric(6);
            user.setUserNick(filename);
            user.setGender(1);
            user.setSignature("暂无签名");
            user.setStatus(1);
            user.setCreateAt(new Date());
            user.setUpdateAt(new Date());
            int effectedNum = userMapper.insert(user);
            // 2.给userIdentity设置userId属性，并插入userIdentity到数据库
            if (effectedNum > 0) {
                userIdentity.setUserId(user.getUserId());
                userIdentity.setCreateAt(new Date());
                userIdentity.setUpdateAt(new Date());
                effectedNum = userIdentityMapper.insert(userIdentity);
                // 3.返回结果
                if (effectedNum > 0) {
                    return ServiceResult.success(user);
                } else {
                    throw new RuntimeException("注册失败");
                }
            }
           else {
                throw new RuntimeException("注册失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("注册失败");
        }
    }

    /**
     * 用户登录
     * @param userLogin
     * @return
     */
    @Transactional
    @Override
    public UserExecutor login(UserLogin userLogin) {
        try {

            UserLogin u = userLoginMapper.selectByUsernamePassword(userLogin);
            if (u.getUsername().equals(userLogin.getUsername())) {
                if (u.getPassword().equals(userLogin.getPassword())) {
                    int userId = userLoginMapper.selectByUseranmeUserId(userLogin.getUsername());
                    if (userId >= 0) {
                        Claims claims = new DefaultClaims();
                        claims.setId(Long.toString(userId));
                        claims.put("userId", userId);
                        JwtResult jwt = JwtUtil.ctreateJwt(claims, 120 * 60);
                        return new UserExecutor(UserStateEnum.SUCCESS, jwt);
                    }
                } else {
                    return UserExecutor.failure("用户名或密码错误");
                }
            } else {
                return UserExecutor.failure("用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("登录失败");
        }
        return null;
    }
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public ServiceResult query(int userId){
        try{
            User a=userMapper.query(userId);
            if (a!=null) {
                return ServiceResult.success(a);
            }else {
                return ServiceResult.failure("没有该id="+userId+"的用户");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("获取用户信息失败");
        }
    }

    /**
     * 修改用户密码
     * @param userPassword
     * @return
     */
    public ServiceResult password(UserPassword userPassword){
        try{
            //取得数据库中保存的用户名和密码
            UserIdentity userIdentityInNP= userIdentityMapper.selectByUseranmePassword(userPassword.getUsername());
            //比较用户名密码是否相等
            if (userPassword.getUsername().equals(userIdentityInNP.getUsername())) {
                if (userPassword.getPassword().equals(userIdentityInNP.getPassword())) {
                    //新旧密码不能相等
                    if (userIdentityInNP.getPassword().equals(userPassword.getNewPassword())){
                        return ServiceResult.failure("新旧密码不能相等，请重新输入");
                    }else {
                        userPassword.setUpdateAt(new Date());
                        int a=userIdentityMapper.password(userPassword);
                        if (a>=0) {
                            return ServiceResult.success("密码修改成功");
                        }else {
                            return ServiceResult.failure("修改密码失败了");
                        }
                    }
                }else{
                    return ServiceResult.failure("用户名或密码错误");
                }
            }else {
                return ServiceResult.failure("用户名或密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 修改用户信息
     */
    public ServiceResult update(UserUpdate userUpdate){
        try {
            userUpdate.setUpdateAt(new Date());
            int u=userMapper.update(userUpdate);
            if (u>0){
                return ServiceResult.success(userUpdate);
            }else {
                return ServiceResult.failure("xiugai weiwancheng");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("修改信息错误");
        }
    }
    /**
     * 更换头像
     */
    public ServiceResult avatar(UserAvatar userAvatar, MultipartFile pic, String realPath){
        try{
            String picture=saveFile(pic, realPath);
            userAvatar.setPictures(picture);
            userMapper.avatar(userAvatar);
            return ServiceResult.success(userAvatar);

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("换头像失败了");
        }
    }

    /**
     * 更换头像——先上传文件
     * @param pic
     * @param realPath
     * @return
     */
    public String saveFile(MultipartFile pic, String realPath) {
        //获取文件的后缀名
        String originalFilename=pic.getOriginalFilename();
        String suffix=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        //生成随机文件名
        String uuid=UUID
                .randomUUID().toString().toLowerCase().replace("-","");
        String filename=uuid+"."+suffix;
        String fileSaveName=realPath+"/"+filename;
        try {
            pic.transferTo(new File(fileSaveName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://127.0.0.1:8080/upload/"+filename;
    }

}
