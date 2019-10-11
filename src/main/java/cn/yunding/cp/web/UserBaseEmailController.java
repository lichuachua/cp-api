package cn.yunding.cp.web;

import cn.yunding.cp.entity.UserEmail;

import javax.servlet.http.HttpSession;

public class UserBaseEmailController {
    static  final String SESSION_USER="_front_user";
    static final int CAPTCHA_LENGTH = 5;//验证码长度
    /**
     * 用户登陆后，将用户信息放到session中，但是哪些信息要放，可以在这里统一管理
     */
    public void loginSession(HttpSession session, UserEmail user){
        session.setAttribute(SESSION_USER,user);
    }
    /**
     * 获取当前已登录用户信息
     */
    public UserEmail getCurrentUser(HttpSession session){
        return (UserEmail)session.getAttribute(SESSION_USER);
    }
    /**
     * 用户退出登录时，需要从session中移除哪些信息，也可以统一在这里管理
     */
    public void logoutSession(HttpSession session){
        session.removeAttribute(SESSION_USER);
    }
}
