package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.*;
import cn.yunding.cp.entity.User;
import cn.yunding.cp.entity.UserIdentity;

/**
 * @author haoyuli
 */
public interface UserMapper {

    /**
     * 插入用户到用户表
     * @param user
     * @return
     */
    int insert(User user);


    /**
     * 获取用户信息
     * @param userid
     * @return
     */
    User query(int userid);


    /**
     * 修改用户信息
     * @param userUpdate
     * @return
     */
    int update(UserUpdate userUpdate);

    /**
     * 更换头像
     * @param userAvatar
     */
    void avatar(UserAvatar userAvatar);
}

