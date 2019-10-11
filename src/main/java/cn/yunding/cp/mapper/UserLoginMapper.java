package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.UserLogin;

/**
 * @author haoyuli
 */
public interface UserLoginMapper {
    /**
     * 登录
     * @param userLogin
     * @return
     */
    UserLogin selectByUsernamePassword(UserLogin userLogin);

    /**
     *根据用户名查询用户ID
     * @param username
     * @return
     */
    int selectByUseranmeUserId(String username);
}
