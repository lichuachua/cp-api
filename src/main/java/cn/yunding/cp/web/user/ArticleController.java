package cn.yunding.cp.web.user;

import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Article;
import cn.yunding.cp.entity.ArticlePraise;
import cn.yunding.cp.exception.ServiceException;
import cn.yunding.cp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }


    /**
     * 发布文章
     *
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/article/post")
    public RequestResult insert(Article article){

        try {
            ServiceResult result = articleService.insert(article);
            if (result.isSuccess()) {
                return RequestResult.success(result.getData());
            } else
                return RequestResult.failure(result.getMessage());
        } catch (Exception e) {
            return RequestResult.failure(e.getMessage());
        }


    }


    /**
     * 查看文章详情
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/article/detail")
    public RequestResult aticle(Integer articleId) throws ServiceException {


            ServiceResult result = articleService.article(articleId);
            if (result.isSuccess()) {
                return RequestResult.success(result.getData());

            } else
                return RequestResult.failure(result.getMessage());
    }


    /**
     * 获取文章列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/article/getlist")
    public RequestResult Articles() throws ServiceException {


        ServiceResult result =  articleService.selectAll();
        if (result.isSuccess()) {
            return RequestResult.success(result.getData());
        }
        return RequestResult.success(result);
    }

    /**
     * 点赞
     */
    @ResponseBody
    @RequestMapping("/api/article/praise")
    public RequestResult praise(ArticlePraise articlePraise) throws ServiceException {


        ServiceResult result = articleService.praise(articlePraise);
        if (result.isSuccess()) {
            return RequestResult.success(result.getData());
        }
        return RequestResult.success(result);
    }
}
