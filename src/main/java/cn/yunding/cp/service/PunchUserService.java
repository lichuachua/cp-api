package cn.yunding.cp.service;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.UserCreateAt;
import cn.yunding.cp.entity.PunchUser;
import cn.yunding.cp.entity.Punchs;

public interface PunchUserService {
    ServiceResult insert(Punchs punchs);

    ServiceResult amStartP(PunchUser punchUser);

//    ServiceResult amEndP(UserCreateAt userCreateAt);
//
//    ServiceResult pmStartP(UserCreateAt userCreateAt);
//
//    ServiceResult pmEndP(UserCreateAt userCreateAt);
//
//    ServiceResult nightStartP(UserCreateAt userCreateAt);
//
//    ServiceResult nightEndP(UserCreateAt userCreateAt);
}
