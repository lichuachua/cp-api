package cn.yunding.cp.dto;

import org.apache.ibatis.annotations.Param;

public class ItemDetailBy {
    /**
     * 项目id
     */
    private int itemId;
    /**
     * 项目创始人iD
     */
    private int userId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ItemDetailBy{" +
                "itemId=" + itemId +
                ", userId=" + userId +
                '}';
    }
}
