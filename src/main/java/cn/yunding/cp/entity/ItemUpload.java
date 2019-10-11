package cn.yunding.cp.entity;

import java.util.Date;

/**
 * @author haoyuli
 */
public class ItemUpload {
    /**
     * 项目Id
     */
    private int itemId;

    /**
     * 用户id
     */
    private int userId;
    /**
     * 上传id
     */
    private int uploadId;
    /**
     * 成员Id
     */
    private int crewId;
    /**
     * 上传内容
     */private String uploadContent;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUploadId() {
        return uploadId;
    }

    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public String getUploadContent() {
        return uploadContent;
    }

    public void setUploadContent(String uploadContent) {
        this.uploadContent = uploadContent;
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
        return "ItemUploads{" +
                "itemId=" + itemId +
                ", userId=" + userId +
                ", uploadId=" + uploadId +
                ", crewId=" + crewId +
                ", uploadContent='" + uploadContent + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
