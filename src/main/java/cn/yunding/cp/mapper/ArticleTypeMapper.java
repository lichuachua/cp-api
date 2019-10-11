package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Article;
import cn.yunding.cp.entity.ArticleType;

import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
public interface ArticleTypeMapper {


    /**
     * 查询文章类型列表
     *
     * @return
     */
     List<ArticleType> selectAll() ;

}
