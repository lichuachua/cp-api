package cn.yunding.cp.entity;

import java.util.Date;

/**
 * @author haoyuli
 */
public class Punch {
    /**
     * 地点Id
     */
    private int siteId;
    /**
     * 地点名字
     */
    private String siteName;
    /**
     * 经度
     */
    private double lng;
    /**
     * 纬度
     */
    private double lat;
    /**
     * 范围
     */
    private int scope;
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

    public double getLng() {
        return lng;
    }

    public void setLog(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
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
        return "Punch{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", scope=" + scope +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
