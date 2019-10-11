package cn.yunding.cp.entity;

import java.util.Date;

public class UserQuestion {
    /**
     * 问答id
     */
    private int questionId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 问答a
     */
    private String questionA;
    /**
     * 问答a
     */
    private String questionB;
    /**
     * 问答a
     */
    private String questionC;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public String getQuestionC() {
        return questionC;
    }

    public void setQuestionC(String questionC) {
        this.questionC = questionC;
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
        return "UserQuestion{" +
                "questionId=" + questionId +
                ", username='" + username + '\'' +
                ", questionA='" + questionA + '\'' +
                ", questionB='" + questionB + '\'' +
                ", questionC='" + questionC + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
