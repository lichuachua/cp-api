package cn.yunding.cp.entity;


import java.sql.Time;
import java.util.Date;

/**
 * @author haoyuli
 */
public class Punchs {
    private int punchId;
    private String siteName;
    private int siteId;
    private int userId;
    private String userNick;
    private Date createAt;
    private Date updateAt;
    private Time times;

    public Time getTimes() {
        return times;
    }

    public void setTimes(Time times) {
        this.times = times;
    }

    public int getPunchId() {
        return punchId;
    }

    public void setPunchId(int punchId) {
        this.punchId = punchId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
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
        return "Punchs{" +
                "punchId=" + punchId +
                ", siteName='" + siteName + '\'' +
                ", siteId=" + siteId +
                ", userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
