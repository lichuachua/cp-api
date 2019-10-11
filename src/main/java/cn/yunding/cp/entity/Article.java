package cn.yunding.cp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
public class Article {
    /**
     * 主键
     * 文章
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private int articleId;

    /**
     * 用户
     */

    @GeneratedValue(generator = "JDBC")
    private int userId;
    /**
     * 类型ID
     */

    private int typeId;

    /**
     * 状态
     */

    private int status;
    /**
     * 标题
     */

    private String title;
    /**
     * 内容
     */

    private String content;
    /**
     * 创建时间
     */

    private Date createAt;
    /**
     * 更新时间
     */

    private Date updateAt;

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

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
