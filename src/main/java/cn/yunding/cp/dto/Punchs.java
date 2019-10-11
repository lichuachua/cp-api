package cn.yunding.cp.dto;

public class Punchs {
    /**
     * 用户id
     */
    private int userId;
    /**
     * siteId
     */
    private int siteId;

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

    @Override
    public String toString() {
        return "Punchs{" +
                "userId=" + userId +
                ", siteId=" + siteId +
                '}';
    }
}
