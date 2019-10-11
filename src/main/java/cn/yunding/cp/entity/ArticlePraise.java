package cn.yunding.cp.entity;

import java.util.Date;

/**
 * @author haoyuli
 */
public class ArticlePraise {
    /**
     * 点赞Id
     */
    private int praiseId;
    /**
     * 点赞人Id
     */
    private int userId;
    /**
     * 文章Id
     */
    private int articleId;
    /**
     * 点赞时间
     */
    private Date praiseTime;

    public int getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(int praiseId) {
        this.praiseId = praiseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Date getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Date praiseTime) {
        this.praiseTime = praiseTime;
    }

    @Override
    public String toString() {
        return "ArticlePraise{" +
                "praiseId=" + praiseId +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", praiseTime=" + praiseTime +
                '}';
    }
}
