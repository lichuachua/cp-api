package cn.yunding.cp.entity;

import java.util.Date;
/**
 * @author chentingDu
 */
public class ApplyType {
    private int typeId;
    /*类型*/
    private String type;
    /*类型名称*/
    private Date createAt;
    /*创建时间*/
    private Date updateAt;
    /*更新时间*/

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
