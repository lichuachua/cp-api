package cn.yunding.cp.web.punch;

import cn.yunding.cp.dto.PunchSite;
import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.service.PunchService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author haoyuli
 */
@Controller
@RequestMapping("/api/punch")
public class PunchController {

    @Autowired
    PunchService punchService;
    /**
     * 判断当前位置是否在打卡范围
     */
    @ResponseBody
    @RequestMapping("/judgeSite")
    public RequestResult judgeSite(PunchSite punchSite){
        try{
            ServiceResult result=punchService.judgeSite(punchSite);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("获取当前位置错误");
        }
    }

    /**
     * 生成所有人的excel表
     */

    @ResponseBody
    @RequestMapping("/excel")
    public void export(HttpServletResponse response) throws Exception {
//        response.reset();

        InputStream is=punchService.getInputStreamnull();


//        response.setContentType("application/x-download");//下面三行是关键代码，处理乱码问题

//        response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gbk"), "iso8859-1")+".xls");

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("contentDisposition",
                "attachment;filename="+new String("iso8859-1")+".xls");
//        ServletOutputStream output=response.getOutputStream();
        FileOutputStream output1=new FileOutputStream("C:\\items.xls");
        IOUtils.copy(is,output1);
    }


}
