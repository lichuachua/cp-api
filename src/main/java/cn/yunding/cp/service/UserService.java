package cn.yunding.cp.service;

import cn.yunding.cp.dto.*;
import cn.yunding.cp.entity.UserIdentity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author haoyuli
 */
public interface UserService {
    /**
     * 注册
     * @param userIdentity
     * @return
     */
    ServiceResult register(UserIdentity userIdentity);

    /**
     * 登录
     * @param userLogin
     * @return
     */
    UserExecutor login(UserLogin userLogin);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    ServiceResult query(int userId);

    /**
     * 修改密码
     * @param userPassword
     * @return
     */
    ServiceResult password(UserPassword userPassword);

    /**
     * 修改用户信息
     * @param userUpdate
     * @return
     */
    ServiceResult update(UserUpdate userUpdate);

    /**
     * 更换头像
     * @param userAvatar
     * @param pic
     * @param realPath
     * @return
     */
    ServiceResult avatar(UserAvatar userAvatar, MultipartFile pic, String realPath);


}
