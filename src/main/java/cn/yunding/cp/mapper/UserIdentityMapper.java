package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.UserPassword;
import cn.yunding.cp.entity.UserIdentity;
import org.apache.ibatis.annotations.Param;
/**
 * @author haoyuli
 */
public interface UserIdentityMapper {
    int insert(UserIdentity userIdentity);

    /**
     *查询用户是否存在
     * @param username
     * @return
     */
    UserIdentity selectByUsername(@Param("username") String username);

    /**
     * 找到用户名对应的密码
     * @param username
     * @return
     */
    UserIdentity selectByUseranmePassword(@Param("username") String username);

    /**
     * 修改用户密码
     * @param userPassword
     */
    int password(UserPassword userPassword);

    /**
     * 获取当前登陆的用户Id
     * @param userId
     * @return
     */
    int selectByUserId(Long userId);

    /**
     * 用户名到用户id
     */
    Long selectByUsername1(@Param("username") String username);
}
