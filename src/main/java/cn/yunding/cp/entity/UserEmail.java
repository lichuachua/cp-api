package cn.yunding.cp.entity;

import java.util.Date;

/**
 * @author haoyuli
 */
public class UserEmail {
    /**
     * emailId
     */
    private Long emailId;
    /**
     * 用户Id
     */
    private String uaername;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 验证码
     */
    private String captcha;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 账号更新时间
     */
    private Date updateAt;

    /**
     * 截止日期
     * @return
     */
    private String dateline;

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getUaername() {
        return uaername;
    }

    public void setUaername(String uaername) {
        this.uaername = uaername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
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

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    @Override
    public String toString() {
        return "UserEmail{" +
                "emailId=" + emailId +
                ", uaername='" + uaername + '\'' +
                ", email='" + email + '\'' +
                ", captcha='" + captcha + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", dateline='" + dateline + '\'' +
                '}';
    }
}
