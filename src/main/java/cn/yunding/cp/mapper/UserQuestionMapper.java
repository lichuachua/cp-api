package cn.yunding.cp.mapper;

import cn.yunding.cp.entity.UserQuestion;

public interface UserQuestionMapper {


    int addQuestion(UserQuestion userQuestion);

    int updateQuestion(UserQuestion userQuestion);

    UserQuestion selectQuestion(UserQuestion userQuestion);
}
