package cn.yunding.cp.service;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.UserFindPassword;
import cn.yunding.cp.dto.UserPassword;
import cn.yunding.cp.entity.UserEmail;

public interface UserEmailService {
    ServiceResult findPassword(String email);

    ServiceResult verifycaptcha(UserFindPassword userFindPassword);



    ServiceResult updatePassword(UserPassword userPassword);
    /**
     * 获取用户email
     * @param email
     * @return
     */

//    ServiceResult findPassword(String email);

//    ServiceResult verifycaptcha(String captcha);
}
