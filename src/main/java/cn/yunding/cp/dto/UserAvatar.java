package cn.yunding.cp.dto;


public class UserAvatar {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 存储图片
     */
    private String pictures;
    /**
     * 头像
     */
    private String avatar;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserAvatar{" +
                "userId=" + userId +
                ", pictures='" + pictures + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}

