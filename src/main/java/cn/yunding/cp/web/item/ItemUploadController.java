package cn.yunding.cp.web.item;

import cn.yunding.cp.dto.ItemUploads;
import cn.yunding.cp.dto.RequestResult;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.ItemUpload;
import cn.yunding.cp.service.ItemService;
import cn.yunding.cp.service.ItemUploadService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author haoyuli
 */
@Controller
@RequestMapping("/api/item")
public class ItemUploadController {

    @Autowired
    ItemUploadService itemUploadService;
    /**
     * 上传项目进度
     */
    @ResponseBody
    @RequestMapping(value = "/addUpload",method = RequestMethod.POST)
    public RequestResult addUpload(ItemUpload upload){
        try{
            ServiceResult result=itemUploadService.addUpload(upload);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        }
    }


    /**
     * 上传项目进度
     */
    @ResponseBody
    @RequestMapping(value = "/addUploads",method = RequestMethod.POST)
    public RequestResult addUploads(ItemUploads itemUploads){
        try{
            ServiceResult result=itemUploadService.addUploads(itemUploads);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        }
    }
    /**
     * 更改项目进度
     */
    @ResponseBody
    @RequestMapping(value = "/upUploads",method = RequestMethod.POST)
    public RequestResult upUploads(ItemUploads itemUploads){
        try{
            ServiceResult result=itemUploadService.upUploads(itemUploads);
            if (result.isSuccess()){
                return RequestResult.success(result.getData());
            }else {
                return RequestResult.failure(result.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("更改项目进度错误");
        }
    }



    /**
     * 生成单个项目的excel表
     */

    @ResponseBody
    @RequestMapping("/excelByItem")
    public void export(HttpServletResponse response,int itemId,String itemPassword) throws Exception {
//        response.reset();

        InputStream is=itemUploadService.getInputStream(itemId,itemPassword);


//        response.setContentType("application/x-download");//下面三行是关键代码，处理乱码问题

//        response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gbk"), "iso8859-1")+".xls");

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("contentDisposition",
                "attachment;filename="+new String("iso8859-1")+".xls");
//        ServletOutputStream output=response.getOutputStream();
        FileOutputStream output1=new FileOutputStream("C:\\item.xls");
        IOUtils.copy(is,output1);

    }



    /**
     * 生成所有人的excel表
     */

    @ResponseBody
    @RequestMapping("/excel")
    public void export(HttpServletResponse response) throws Exception {
//        response.reset();

        InputStream is=itemUploadService.getInputStreamnull();


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
