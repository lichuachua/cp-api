package cn.yunding.cp.entity;

import java.util.Date;

/**
 * @author haoyuli
 */
public class User {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String userNick;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户签名
     */
    private String signature;
    /**
     * 用户性别
     */
    private Integer gender;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户创建时间
     */
    private Date createAt;
    /**
     * 用户更新时间
     */
    private Date updateAt;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", avatar='" + avatar + '\'' +
                ", signature='" + signature + '\'' +
                ", gender=" + gender +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
