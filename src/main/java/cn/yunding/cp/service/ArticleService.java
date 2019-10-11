package cn.yunding.cp.service;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Article;
import cn.yunding.cp.entity.ArticlePraise;
import cn.yunding.cp.entity.ArticleType;
import cn.yunding.cp.exception.ServiceException;

import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
public interface ArticleService {

    /**
     * 发布文章
     * @param article
     * @return
     * @throws ServiceException
     * @throws ServiceException
     */
   ServiceResult insert(Article article) ;

    /**
     * 查找文章详情
     * @param articleId
     * @return
     * @throws ServiceException
     */
    ServiceResult article(Integer articleId) throws ServiceException;

    /**
     * 查询文章列表
     * @return
     * @throws ServiceException
     */
   ServiceResult selectAll() throws ServiceException;

    ServiceResult praise(ArticlePraise articlePraise);
}
