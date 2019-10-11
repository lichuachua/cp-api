package cn.yunding.cp.dto;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

public class ItemUploads {
    /**
     * 项目Id
     */
    private int itemId;
    /**
     * 上传id
     */
    private int uploadId;
    /**
     * crewId
     */
    private int crewId;
    /**
     * 项目名称
     */
    private String itemName;
    /**
     * 上传者昵称
     */
    private String  crewNick;
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

    /**
     * 截止日期
     * @return
     */
    private Date datelineAt;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCrewNick() {
        return crewNick;
    }

    public void setCrewNick(String crewNick) {
        this.crewNick = crewNick;
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

    public Date getDatelineAt() {
        return datelineAt;
    }

    public void setDatelineAt(Date datelineAt) {
        this.datelineAt = datelineAt;
    }


    @Override
    public String toString() {
        return "ItemUploads{" +
                "itemId=" + itemId +
                ", uploadId=" + uploadId +
                ", crewId=" + crewId +
                ", itemName='" + itemName + '\'' +
                ", crewNick='" + crewNick + '\'' +
                ", uploadContent='" + uploadContent + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", datelineAt=" + datelineAt +
                '}';
    }
}
