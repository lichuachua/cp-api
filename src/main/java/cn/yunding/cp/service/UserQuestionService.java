package cn.yunding.cp.service;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.UserQuestion;

public interface UserQuestionService {
    ServiceResult addQuestion(UserQuestion userQuestion);

    ServiceResult updateQuestion(UserQuestion userQuestion);

    ServiceResult byQuestion(UserQuestion userQuestion);
}
