package cn.yunding.cp.entity;

import java.sql.Time;
import java.util.Date;

/**
 * @author haiyuli
 */
public class PunchUsers {
    /**
     * siteId
     */
    private int siteId;
    /**
     * siteName
     */
    private String siteName;
    /**
     * 打卡Id
     */
    private int punchId;
    /**
     * 用户Id
     */
    private int userId;
    /**
     * 用户昵称
     */
    private String userNick;


    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getPunchId() {
        return punchId;
    }

    public void setPunchId(int punchId) {
        this.punchId = punchId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
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
        return "PunchUsers{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", punchId=" + punchId +
                ", userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
