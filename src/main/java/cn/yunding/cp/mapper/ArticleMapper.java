package cn.yunding.cp.mapper;



import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Article;
import cn.yunding.cp.entity.ArticlePraise;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
@Service
public interface ArticleMapper {



    /**
     * 发布文章
     * @param article 文章信息
     * @return
     */
    int insert(Article article);

    /**
     * 查询文章详情
     * @param id
     * @return
     */

    Article article(Integer id);

    /**
     * 查询文章列表
     * @return
     */
    List<Article> selectAll();

    ArticlePraise selectPraise(ArticlePraise articlePraise);

    int insertPraise(ArticlePraise articlePraise);
}
