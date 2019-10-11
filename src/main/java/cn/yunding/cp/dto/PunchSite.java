package cn.yunding.cp.dto;

/**
 * @author haoyuli
 */
public class PunchSite {
    /**
     * 地点Id
     * @return
     */
    private int siteId;
    /**
     * 经度
     */
    private double lng;
    /**
     * 纬度
     */
    private double lat;

    public int getSiteId() {

        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double log) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "PunchSite{" +
                "siteId=" + siteId +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
