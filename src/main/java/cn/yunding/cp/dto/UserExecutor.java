package cn.yunding.cp.dto;

import cn.yunding.cp.entity.User;
import cn.yunding.cp.enums.UserStateEnum;

/**
 * @author haoyuli
 */
public class UserExecutor extends BaseExecutor {

    private User user;

    private JwtResult jwt;

    public User getUserInfo() {
        return user;
    }
    private boolean success;

    /**
     * 单个数据
     */
    private Object data;

    /**
     * 错误信息
     */
    private String message;
    public UserExecutor(UserStateEnum userStateEnum) {
        this.setState(userStateEnum.getState());
        this.setMessage(userStateEnum.getMessage());
    }
    public UserExecutor(UserStateEnum userStateEnum,User user){
        this.setState(userStateEnum.getState());
        this.setMessage(userStateEnum.getMessage());
        this.setUser(user);
    }

    public UserExecutor(UserStateEnum userStateEnum, JwtResult jwtResult) {
        this.setState(userStateEnum.getState());
        this.setMessage(userStateEnum.getMessage());
        this.setJwt(jwtResult);
    }
    public UserExecutor(boolean success, Object data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }
    public JwtResult getJwt() {
        return jwt;
    }

    public void setJwt(JwtResult jwt) {
        this.jwt = jwt;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public static UserExecutor failure(String message) {
        return new UserExecutor(false, null, message);
    }

}
