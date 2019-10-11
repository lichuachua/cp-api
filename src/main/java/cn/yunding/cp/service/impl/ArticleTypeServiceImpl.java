package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ArticleType;
import cn.yunding.cp.exception.ServiceException;
import cn.yunding.cp.mapper.ArticleTypeMapper;
import cn.yunding.cp.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/2.
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    ArticleTypeMapper articleTypeMapper;


    /**
     * 查询文章类型列表
     * @return
     * @throws ServiceException
     */

    @Override
    public ServiceResult selectAll () throws ServiceException {

        List<ArticleType> result=articleTypeMapper.selectAll();
        if(result.size() <= 0){
            throw new ServiceException("查找文章类型列表失败");

        }
        return ServiceResult.success(result);
    }
}

