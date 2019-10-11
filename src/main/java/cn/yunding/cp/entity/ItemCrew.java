package cn.yunding.cp.entity;

import java.util.Date;

public class ItemCrew {
    /**
     * 用户id
     */
    private int userId;
    /**
     * 所加入的项目的id
     */
    private int itemId;
    /**
     * 项目名
     */
    private String itemName;
    /**
     * 成员Id
     */
    private int crewId;
    /**
     * 成员名，也就是昵称
     */
    private String crewName;
    /**
     * 项目申请加入密码
     */
    private String itemPassword;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getItemPassword() {
        return itemPassword;
    }

    public void setItemPassword(String itemPassword) {
        this.itemPassword = itemPassword;
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
        return "ItemCrew{" +
                "userId=" + userId +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", crewId=" + crewId +
                ", crewName='" + crewName + '\'' +
                ", itemPassword='" + itemPassword + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
