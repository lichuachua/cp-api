package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Article;
import cn.yunding.cp.entity.ArticlePraise;
import cn.yunding.cp.exception.ServiceException;
import cn.yunding.cp.mapper.ArticleMapper;
import cn.yunding.cp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/1.
 */

@Service
public  class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    /**
     * 发布文章
     * @param article
     * @return
     * @throws ServiceException
     */
    @Override
    public ServiceResult insert(Article article){
        try{

            article.setCreateAt(new Date());
            article.setUpdateAt(new Date());
            article.setStatus(0);
            int result=articleMapper.insert(article);
            if(result!=1){
                return ServiceResult.failure("操作失败");
            }else {
                return ServiceResult.success(article);

            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("发布失败");
        }
    }

    /**
     * 查找文章详情
     * @param articleId
     * @return
     * @throws ServiceException
     */
    @Override
    public ServiceResult article(Integer articleId) throws ServiceException {

        if (articleId == null) {
            throw new ServiceException("查找文章详情失败");
        }
            Article result = articleMapper.article(articleId);


            return ServiceResult.success(result);

    }

    /**
     * 查找文章列表
     * @return
     * @throws ServiceException
     */
    @Override
    public ServiceResult selectAll () throws ServiceException {

        List<Article> result=articleMapper.selectAll();
        if (result.size()<=0){
            throw new ServiceException("查找文章列表失败");
        }
        return ServiceResult.success(result);

    }
    /**
     * 点赞
     */
    @Override
    public ServiceResult praise(ArticlePraise articlePraise){
        try{
            ArticlePraise a=articleMapper.selectPraise(articlePraise);
            if (a==null){
                articlePraise.setPraiseTime(new Date());
                int result=articleMapper.insertPraise(articlePraise);
                if (result==1){
                    return ServiceResult.success(articlePraise);
                }else {
                    return ServiceResult.failure("失败了");
                }
            }else {
                return ServiceResult.failure("已经点过赞了");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("异常了");
        }
    }
}
