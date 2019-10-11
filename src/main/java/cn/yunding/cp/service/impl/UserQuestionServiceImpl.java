package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.UserIdentity;
import cn.yunding.cp.entity.UserQuestion;
import cn.yunding.cp.mapper.UserIdentityMapper;
import cn.yunding.cp.mapper.UserQuestionMapper;
import cn.yunding.cp.service.UserQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author haoyuli
 */
@Service
public class UserQuestionServiceImpl implements UserQuestionService{
    @Autowired
    UserQuestionMapper userQuestionMapper;
    @Autowired
    UserIdentityMapper userIdentityMapper;

    @Override
    /**
     * 添加问答
     */
    public ServiceResult addQuestion(UserQuestion userQuestion){
        try {
            //判断用户名是否存在
            UserIdentity userIdentityInDb = userIdentityMapper.selectByUsername(userQuestion.getUsername());
            if (userIdentityInDb!=null){
                userQuestion.setCreateAt(new Date());
                userQuestion.setUpdateAt(new Date());
                int a=userQuestionMapper.addQuestion(userQuestion);
                if (a==1){
                    return ServiceResult.success(userQuestion);
                }else {
                    return ServiceResult.failure("添加问答失败");
                }
            }else {
                return ServiceResult.failure("没有该用户");
            }

            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("添加问答失败");
        }
    }
    @Override
    /**
     * 更改问答
     */
    public ServiceResult updateQuestion(UserQuestion userQuestion){
        try {
            //判断用户名是否存在
            UserIdentity userIdentityInDb = userIdentityMapper.selectByUsername(userQuestion.getUsername());
            if (userIdentityInDb!=null){
                userQuestion.setUpdateAt(new Date());
                int a=userQuestionMapper.updateQuestion(userQuestion);
                if (a==1){
                    return ServiceResult.success(userQuestion);
                }else {
                    return ServiceResult.failure("添加问答失败");
                }
            }else {
                return ServiceResult.failure("该用户不存在");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加问答失败");
        }
    }



    public ServiceResult byQuestion(UserQuestion userQuestion){
        try {
            //判断用户名是否存在
            UserIdentity userIdentityInDb = userIdentityMapper.selectByUsername(userQuestion.getUsername());
            if (userIdentityInDb!=null) {
                //用户名存在，取得questionABC，比较是否相同，相同改密码，不同返回答案错误
                UserQuestion userQuestionbySQL = userQuestionMapper.selectQuestion(userQuestion);
                if (userQuestion.getQuestionA().equals(userQuestionbySQL.getQuestionA())) {
                    if (userQuestion.getQuestionB().equals(userQuestionbySQL.getQuestionB())) {
                        if (userQuestion.getQuestionC().equals(userQuestionbySQL.getQuestionC())) {
                            return ServiceResult.success("答案正确，允许更改密码");
                        } else {
                            return ServiceResult.failure("答案错误");
                        }
                    } else {
                        return ServiceResult.failure("答案错误");
                    }
                } else {
                    return ServiceResult.failure("答案错误");
                }

            }else {
                return ServiceResult.failure("该用户不存在");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加问答失败");
        }
    }

}
