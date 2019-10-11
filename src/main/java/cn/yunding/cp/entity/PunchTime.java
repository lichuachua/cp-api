package cn.yunding.cp.entity;

import javax.xml.crypto.Data;
import java.sql.Time;

/**
 * @author haoyuli
 */
public class PunchTime {
    /**
     * 时间序列
     */
    private int timeId;
    /**
     * siteId
     */
    private int siteId;
    /**
     * 上午上班时间
     */
    private Time amStartAt;
    /**
     *上午下班时间
     */
    private Time amEndAt;
    /**
     * 下午上班时间
     */
    private Time pmStartAt;
    /**
     * 下午下班时间
     */
    private Time pmEndAt;
    /**
     * 晚上上班时间
     */
    private Time nightStartAt;
    /**
     * 晚上下班时间
     */
    private Time nightEndAt;
    /**
     * 创建时间
     */
    private Data createAt;
    /**
     * 更新时间
     */
    private Data updateAt;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public Time getAmStartAt() {
        return amStartAt;
    }

    public void setAmStartAt(Time amStartAt) {
        this.amStartAt = amStartAt;
    }

    public Time getAmEndAt() {
        return amEndAt;
    }

    public void setAmEndAt(Time amEndAt) {
        this.amEndAt = amEndAt;
    }

    public Time getPmStartAt() {
        return pmStartAt;
    }

    public void setPmStartAt(Time pmStartAt) {
        this.pmStartAt = pmStartAt;
    }

    public Time getPmEndAt() {
        return pmEndAt;
    }

    public void setPmEndAt(Time pmEndAt) {
        this.pmEndAt = pmEndAt;
    }

    public Time getNightStartAt() {
        return nightStartAt;
    }

    public void setNightStartAt(Time nightStartAt) {
        this.nightStartAt = nightStartAt;
    }

    public Time getNightEndAt() {
        return nightEndAt;
    }

    public void setNightEndAt(Time nightEndAt) {
        this.nightEndAt = nightEndAt;
    }

    public Data getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Data createAt) {
        this.createAt = createAt;
    }

    public Data getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Data updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "PunchTime{" +
                "timeId=" + timeId +
                ", siteId=" + siteId +
                ", amStartAt=" + amStartAt +
                ", amEndAt=" + amEndAt +
                ", pmStartAt=" + pmStartAt +
                ", pmEndAt=" + pmEndAt +
                ", nightStartAt=" + nightStartAt +
                ", nightEndAt=" + nightEndAt +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
