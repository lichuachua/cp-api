package cn.yunding.cp.dto;

import java.util.Date;

/**
 * @author haoyuli
 * 查询项目列表
 */
public class ItemList {
    /**
     * 项目id
     */
    private int itemId;
    /**
     * 项目名称
     */
    private String itemName;
    /**
     * 项目组长
     */
    private String leader;
    /**
     * 创建时间
     */
    private Date createAt;

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

    @Override
    public String toString() {
        return "ItemList{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", leader='" + leader + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
