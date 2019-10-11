package cn.yunding.cp.entity;

import java.sql.Time;
import java.util.Date;

public class PunchUser {
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
    /**
     * 上午上班打卡时间
     */
    private Time amStartP;
    /**
     * 上午下班打卡时间
     */
    private Time amEndP;
    /**
     * 下午上班打卡时间
     */
    private Time pmStartP;
    /**
     * 下午下班打卡时间
     */
    private Time pmEndP;
    /**
     * 晚上上班打卡时间
     */
    private Time nightStartP;
    /**
     * 晚上下班打卡时间
     */
    private Time  nightEndP;
    /**
     * 创建时间
     */
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

    public Time getAmStartP() {
        return amStartP;
    }

    public void setAmStartP(Time amStartP) {
        this.amStartP = amStartP;
    }

    public Time getAmEndP() {
        return amEndP;
    }

    public void setAmEndP(Time amEndP) {
        this.amEndP = amEndP;
    }

    public Time getPmStartP() {
        return pmStartP;
    }

    public void setPmStartP(Time pmStartP) {
        this.pmStartP = pmStartP;
    }

    public Time getPmEndP() {
        return pmEndP;
    }

    public void setPmEndP(Time pmEndP) {
        this.pmEndP = pmEndP;
    }

    public Time getNightStartP() {
        return nightStartP;
    }

    public void setNightStartP(Time nightStartP) {
        this.nightStartP = nightStartP;
    }

    public Time getNightEndP() {
        return nightEndP;
    }

    public void setNightEndP(Time nightEndP) {
        this.nightEndP = nightEndP;
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
        return "PunchUser{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", punchId=" + punchId +
                ", userId=" + userId +
                ", userNick='" + userNick + '\'' +
                ", amStartP=" + amStartP +
                ", amEndP=" + amEndP +
                ", pmStartP=" + pmStartP +
                ", pmEndP=" + pmEndP +
                ", nightStartP=" + nightStartP +
                ", nightEndP=" + nightEndP +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
