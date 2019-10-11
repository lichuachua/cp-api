package cn.yunding.cp.dto;

import cn.yunding.cp.entity.UserIdentity;
import cn.yunding.cp.mapper.UserIdentityMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserId {
    @Autowired
    UserIdentityMapper userIdentityMapper;

    public int gainUserId() {
        UserIdentity userIdentity = new UserIdentity();
        int uId = userIdentityMapper.selectByUserId(userIdentity.getUserId());
        return uId;
    }
}
