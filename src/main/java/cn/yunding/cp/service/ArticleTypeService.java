package cn.yunding.cp.service;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ArticleType;
import cn.yunding.cp.exception.ServiceException;

import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
public interface ArticleTypeService {


    /**
     * 查询所有的文章类型
     * @return
     */

    ServiceResult selectAll() throws ServiceException;
}
