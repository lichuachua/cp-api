package cn.yunding.cp.web.user;

import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ArticleType;
import cn.yunding.cp.exception.ServiceException;
import cn.yunding.cp.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by renjiamin123 on 2018/8/1.
 */
@Controller
public class ArticleTypeController {

@Autowired
    ArticleTypeService articleTypeService;



    /**
     * 获取文章类型列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/article/allTypes")
    public RequestResult ArticleTypes() throws ServiceException {


       ServiceResult result = articleTypeService.selectAll();

        if (result.isSuccess()){
            return RequestResult.success(result.getData());
        }

        return RequestResult.success(result);

    }
}
