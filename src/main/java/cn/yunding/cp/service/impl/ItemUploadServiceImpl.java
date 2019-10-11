package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.ItemUploads;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.WriteExcel;
import cn.yunding.cp.entity.Item;
import cn.yunding.cp.entity.ItemUpload;
import cn.yunding.cp.mapper.ItemMapper;
import cn.yunding.cp.service.ItemUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author haoyuli
 */
@Service
public class ItemUploadServiceImpl implements ItemUploadService{
    @Autowired
    ItemMapper itemMapper;
    /**
     * 上传项目进度
     */
    @Override
    public ServiceResult addUpload(ItemUpload itemUpload){
        try{

            /**
             * 今天提交的就是今天的，明天提交的就是明天的，会有时间显示；；；；；；；；
             */


            //将截止日期设置成第二天零点
            Calendar calendar = Calendar. getInstance();
            calendar.setTime( new Date());
            calendar.set(Calendar. HOUR_OF_DAY, 0);
            calendar.set(Calendar. MINUTE, 0);
            calendar.set(Calendar. SECOND, 0);
            calendar.set(Calendar. MILLISECOND, 0);
            calendar.add(Calendar. DAY_OF_MONTH, 1);
            Date date2 = calendar.getTime();

//            获取当前时间
            Date date1 = new Date();

//            转换时间格式为数字，当前时间和截止日期比较，没到截止时间可以上传，否则提示，时间过了
            long digitalDate2=date2.getTime();
            long digitalDate1=date1.getTime();
            if (digitalDate1<digitalDate2){
//                没到截止时间可以上传


            //根据crewId得到itemId
                int iId=itemMapper.selectItemIdByCrewId(itemUpload.getCrewId());
                itemUpload.setItemId(iId);
                itemUpload.setCreateAt(new Date());
                itemUpload.setUpdateAt(new Date());
                int result=itemMapper.addUpload(itemUpload);
                if (result!=0){
                    return ServiceResult.success(itemUpload);
                }else {
                    return ServiceResult.failure("上传失败");
                }
            }else {
                return ServiceResult.failure("已经过了截止日期");
            }


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        }
    }

    /**
     * 上传项目进度
     * @param itemUploads
     * @return
     */

    public ServiceResult addUploads(ItemUploads itemUploads){
        try{

            /**
             * 注明今天是不是比第一次提交  若是  提交  若不是  更新
             */

            //根据crewId 获取itemId
            int iId=itemMapper.selectItemIdByCrewId(itemUploads.getCrewId());
            //根据itemId 获取项目名
            String iname=itemMapper.selectItemnameByCrewId(iId);
            //根据crewId 获取成员名
            String cname=itemMapper.selectCrewnameByCrewId(itemUploads.getCrewId());

            itemUploads.setCreateAt(new Date());
            itemUploads.setUpdateAt(new Date());



            //将截止日期设置成第二天零点
            Calendar calendar = Calendar. getInstance();
            calendar.setTime( new Date());
            calendar.set(Calendar. HOUR_OF_DAY, 0);
            calendar.set(Calendar. MINUTE, 0);
            calendar.set(Calendar. SECOND, 0);
            calendar.set(Calendar. MILLISECOND, 0);
            calendar.add(Calendar. DAY_OF_MONTH, 1);
            Date date2 = calendar.getTime();
            itemUploads.setItemId(iId);
            itemUploads.setCrewNick(cname);
            itemUploads.setItemName(iname);
            itemUploads.setDatelineAt(date2);

            int result=itemMapper.addUploads(itemUploads);
            if (result==1){
                return ServiceResult.success(itemUploads);

            }else {
                return ServiceResult.failure("上传失败");
            }



        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        }
    }


    /**
     * 更改项目进度
     */
    public ServiceResult upUploads(ItemUploads itemUploads){
        try{
            //根据上传Id取出截止时间，若未到截止时间，将可以更改，若到了截止时间，则不能更改
            //根据上传Id取出截止时间
            Date date=itemMapper.selectDatelineByUploadIp(itemUploads.getUploadId());
            //            转换时间格式为数字，当前时间和截止日期比较，没到截止时间可以上传，否则提示，时间过了
            long digitalDate=date.getTime();
            Date date1=new Date();
            long digitalDate1=date1.getTime();
            if (digitalDate1<digitalDate){
               //                没到截止时间可以上传

                itemUploads.setUpdateAt(new Date());
                int result=itemMapper.upUploads(itemUploads);
                if (result==1){
                    return ServiceResult.success(itemUploads);
                }else {
                    return ServiceResult.failure("更改项目进度失败");
                }
            }else{
                return ServiceResult.failure("时间已经截止，不能更改项目进度");
            }


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("更改项目进度错误");

        }
    }







    /**
     * 生成单个项目组excle表
     */
    public InputStream getInputStream(int itemId,String itemPassword) throws Exception {
        String [] title=new String[]{
                "项目名称","成员","进度","创建时间","最后上传时间"};

        //根据itemId取出密码，密码正确执行导出excel，否则报错
        String password=itemMapper.selectitemPasswordByItemId(itemId);
        if (itemPassword.equals(password)){
            List<ItemUploads> plist=itemMapper.getStuList(itemId);
            List<Object[]> dataList= new ArrayList<Object[]>();
            for (int i=0;i<plist.size();i++){
                Object[] obj=new Object[5];
                obj[0]=plist.get(i).getItemName();
                obj[1]=plist.get(i).getCrewNick();
                obj[2]=plist.get(i).getUploadContent();
                obj[3]=plist.get(i).getCreateAt();
                obj[4]=plist.get(i).getUpdateAt();

                dataList.add(obj);
            }
            WriteExcel ex = new WriteExcel(title, dataList);
            InputStream in;
            in = ex.export();
            return in;
        }else {
            return null;
        }

    }
    /**
     * 生成单个项目组excle表
     */
    public InputStream getInputStreamnull() throws Exception {
        String [] title=new String[]{
                "项目名称","成员","进度","创建时间","最后上传时间"};

            List<ItemUploads> plist=itemMapper.getStuListnull();
            List<Object[]> dataList= new ArrayList<Object[]>();
            for (int i=0;i<plist.size();i++){
                Object[] obj=new Object[5];
                obj[0]=plist.get(i).getItemName();
                obj[1]=plist.get(i).getCrewNick();
                obj[2]=plist.get(i).getUploadContent();
                obj[3]=plist.get(i).getCreateAt();
                obj[4]=plist.get(i).getUpdateAt();

                dataList.add(obj);
            }
            WriteExcel ex = new WriteExcel(title, dataList);
            InputStream in;
            in = ex.export();
            return in;

    }



    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
}
