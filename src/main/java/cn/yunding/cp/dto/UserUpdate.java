package cn.yunding.cp.dto;

import java.util.Date;

/**
 * @author haoyuli
 */
public class UserUpdate {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String userNick;
    /**
     * 用户签名
     */
    private String signature;
    /**
     * 用户性别
     */
    private Integer gender;
    /**
     * 用户更新时间
     */
    private Date updateAt;

    /**
     *
     * @return
     */
    private String email;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserUpdate{" +
                "userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", signature='" + signature + '\'' +
                ", gender=" + gender +
                ", updateAt=" + updateAt +
                ", email='" + email + '\'' +
                '}';
    }
}
