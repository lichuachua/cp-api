package cn.yunding.cp.dto;

import java.util.Date;

public class ItemDetail {

    /**
     * 项目id
     */
    private int itemId;
    /**
     * 项目名称
     */
    private String itemName;
    /**
     * 项目介绍
     */
    private String introduce;
    /**
     * 项目申请加入密码
     */
    private String itemPassword;
    /**
     * 项目组长
     */
    private String leader;

    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;

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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getItemPassword() {
        return itemPassword;
    }

    public void setItemPassword(String itemPassword) {
        this.itemPassword = itemPassword;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
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
        return "ItemDetail{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", introduce='" + introduce + '\'' +
                ", itemPassword='" + itemPassword + '\'' +
                ", leader='" + leader + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
