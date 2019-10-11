package cn.yunding.cp.entity;
/**
 * @author chentingDu
 */
import java.util.Date;

public class Apply {
    private int applyId;
    /*申请人*/
    private int userId;
    /*用户*/
    private int typeId;
    /*类型id*/
    private Date startTime;
    /*起始时间*/
    private Date endTime;
    /*结束时间*/
    private int status;
    /*申请状态*/
    private Date createAt;
    /*创建时间*/
    private Date updateAt;
    /*更新时间*/
    private String reason;
    /*申请原因*/

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", reason='" + reason + '\'' +
                '}';
    }
}