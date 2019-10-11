package cn.yunding.cp.dto;

import java.sql.Time;
import java.util.Date;

public class UserCreateAt {
    /**
     * userId
     *
     */
    private int userId;

    /**
     * siteId
     */
    private int siteId;
    /**
     * createAt
     */
    private String createAt;
    private Time times;
    private Date updateAt;

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public Time getTimes() {
        return times;
    }

    public void setTimes(Time times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "UserCreateAt{" +
                "userId=" + userId +
                ", siteId=" + siteId +
                ", createAt='" + createAt + '\'' +
                ", times=" + times +
                '}';
    }
}
