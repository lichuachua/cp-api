package cn.yunding.cp.web;

import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.UserQuestion;
import cn.yunding.cp.service.UserQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haoyuli
 */
@Controller
@RequestMapping("/api/user")
public class UserQuestionControllor {
    @Autowired
    UserQuestionService userQuestionService;
    /**
     * 添加问答
     */
    @ResponseBody
    @RequestMapping("/addQuestion")
    public RequestResult addQuestion(UserQuestion userQuestion){
        try{
            ServiceResult result=userQuestionService.addQuestion(userQuestion);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加问答错误");
        }
    }
    /**
     * 更改问答
     */
    @ResponseBody
    @RequestMapping("/updateQuestion")
    public RequestResult updateQuestion(UserQuestion userQuestion){
        try{
            ServiceResult result=userQuestionService.updateQuestion(userQuestion);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加问答错误");
        }
    }
    /**
     * 输入密保，正确改密码
     */
    @ResponseBody
    @RequestMapping("/byQuestion")
    public RequestResult byQuestion(UserQuestion userQuestion){
        try{
            ServiceResult result=userQuestionService.byQuestion(userQuestion);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加问答错误");
        }
    }

}
