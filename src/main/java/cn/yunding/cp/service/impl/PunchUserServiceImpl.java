package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.PunchTimes;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.UserCreateAt;
import cn.yunding.cp.entity.PunchUser;
import cn.yunding.cp.entity.Punchs;
import cn.yunding.cp.mapper.ItemMapper;
import cn.yunding.cp.mapper.PunchMapper;
import cn.yunding.cp.mapper.PunchUserMapper;
import cn.yunding.cp.service.PunchUserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PunchUserServiceImpl implements PunchUserService {
    @Autowired
    PunchUserMapper punchUserMapper;
    @Autowired
    PunchMapper punchMapper;
    ItemMapper itemMapper;
//    Date date=new Date();
//    Time time=new Time(date.getTime());
    /**
     * 插入
     */
    public ServiceResult insert(Punchs punchs){
        try
        {
            //取得userNick   siteName
            String userNick=punchUserMapper.selectByuserId(punchs.getUserId());
            String siteName=punchUserMapper.selectBysiteId(punchs.getSiteId());

            punchs.setUserNick(userNick);
            punchs.setSiteName(siteName);
            punchs.setUpdateAt(new Date());
            punchs.setCreateAt(new Date());
            int a=punchUserMapper.insert(punchs);
            if (a==1){
                return ServiceResult.success(punchs);
            }else {
                return ServiceResult.failure("shibaile");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("cuole");
        }
    }

    /**
     * 上午上班打卡
     */
    public ServiceResult amStartP(PunchUser punchUser){
        try{
            Date date=new Date();
            Time time=new Time(date.getTime());
            //取出数据库中的时间与当前时间对比
            //1.取出上午上班打卡时间
            Time amStartAt= punchUserMapper.selectAmStartAtBySiteId(punchUser.getSiteId());
            String amStart2=punchUserMapper.selectAmStartAt2BySiteId(punchUser.getSiteId());



            //2.取出上午下班打卡时间
            Time amEndAt=punchUserMapper.selectAmEndAtBySiteId(punchUser.getSiteId());



            String amEndAt2=punchUserMapper.selectAmEndAt2BySiteId(punchUser.getSiteId());
            SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
            String a=df.format(date);

            int ress=amEndAt2.compareTo(a);
            int resss=amStart2.compareTo(a);


            int res=amStartAt.compareTo(time);
            int res1=amEndAt.compareTo(time);

//            转换时间格式为数字
            long digitalDate=time.getTime();
            long digitalDate1=amStartAt.getTime();
            long digitalDate2=amEndAt.getTime();
//            根据userID得到userNick
            String userNick=punchUserMapper.selectByuserId(punchUser.getUserId());
            //根据siteId得到siteNmae
            String siteName=punchUserMapper.selectBysiteId(punchUser.getSiteId());

            punchUser.setUserNick(userNick);
            punchUser.setSiteName(siteName);
            punchUser.setCreateAt(new Date());
            punchUser.setUpdateAt(new Date());
//            res1<0则amStartAt<time
//            if (digitalDate>digitalDate2) {
//            if (res1<0){
            if (ress<0){
                    int amS1 = punchUserMapper.amStartP(punchUser);
                    if (amS1 == 1)
                        return ServiceResult.success("缺卡,申请补卡");
                     else
                        return ServiceResult.failure("cuowu");

                }else {
                punchUser.setAmStartP(time);
                int amS = punchUserMapper.amStartP(punchUser);
//                if (digitalDate < digitalDate1) {
//                if (res>0){
                if (resss>0){
                    if (amS == 1)
                        return ServiceResult.success("正常打卡成功");
                     else
                        return ServiceResult.failure("打卡失败");

                } else {
                    if (amS == 1)
                        return ServiceResult.success("迟到打卡成功");
                     else
                        return ServiceResult.failure("打卡失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("打卡失败");
        }
    }


//
//    /**
//     * 上午下班打卡
//     */
//    public ServiceResult amEndP(UserCreateAt userCreateAt){
//        try{
//
//            //取出数据库中的时间与当前时间对比
//            //2.取出上午下班打卡时间
//            Time amEndAt=punchUserMapper.selectAmEndAtBySiteId(userCreateAt.getSiteId());
//            //取出下午上班时间
//            Time pmStartAt= punchUserMapper.selectPmStartAtBySiteId(userCreateAt.getSiteId());
//            int res1=amEndAt.compareTo(time);
//            int res2=pmStartAt.compareTo(time);
//
////            转换时间格式为数字
//            long digitalDate=time.getTime();
//            long digitalDate2=amEndAt.getTime();
//            long digitalDate3=pmStartAt.getTime();
//            //根据userID得到userNick
//            String userNick=punchUserMapper.selectByuserId(userCreateAt.getUserId());
//            //根据siteId得到siteNmae
//            String siteName=punchUserMapper.selectBysiteId(userCreateAt.getSiteId());
//
//            //根据时间和userId插入
//            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//            userCreateAt.setCreateAt(df.format(new Date()));
//            int punchId=punchUserMapper.selectpunchIdBySiteIdUserIdCreate(userCreateAt);
//            userCreateAt.setSiteId(punchId);
//            userCreateAt.setUpdateAt(new Date());
//            PunchTimes punchTimes=new PunchTimes();
//
////           res1<0则amStartAt<time
//
////            if (res2<0) {
////                //根据punchId插入数据
////                int amS1 = punchUserMapper.amEndP(punchTimes);
////                if (amS1 == 1) {
////                    return ServiceResult.success("缺卡,申请补卡");
////                } else {
////                    return ServiceResult.failure("cuowu");
////                }
////            }else {
//                if (res1>0){
//                    punchTimes.setPunchId(punchId);
//                    punchTimes.setTimes(time);
//                    int amS=punchUserMapper.amEndP(punchTimes);
//                    if (amS==1){
//                        return ServiceResult.success("提前下班打卡");
//                    }else {
//                        return ServiceResult.failure("打卡失败");
//                    }
//                }else {
//                    punchTimes.setPunchId(punchId);
//                    punchTimes.setTimes(time);
//                    int amS=punchUserMapper.amEndP(punchTimes);
//                    if (amS==1){
//                        return ServiceResult.success("正常下班打卡");
//                    }else {
//                        return ServiceResult.failure("打卡失败");
//                    }
//                }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("打卡失败");
//        }
//    }
//    /**
//     * 下午上班打卡
//     */
//    public ServiceResult pmStartP(UserCreateAt userCreateAt){
//        try{
//            //取出数据库中的时间与当前时间对比
//            //2.取出上午下班打卡时间
////            Time amEndAt=punchUserMapper.selectAmEndAtBySiteId(userCreateAt.getSiteId());
////            //取出下午上班时间
////            Time pmStartAt= punchUserMapper.selectPmStartAtBySiteId(userCreateAt.getSiteId());
////            int res1=amEndAt.compareTo(time);
////            int res2=pmStartAt.compareTo(time);
////
//////            转换时间格式为数字
////            long digitalDate=time.getTime();
////            long digitalDate2=amEndAt.getTime();
////            long digitalDate3=pmStartAt.getTime();
//
//
//            //根据时间和userId插入
//            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//            userCreateAt.setCreateAt(df.format(new Date()));
//            int punchId=punchUserMapper.selectpunchIdBySiteIdUserIdCreate(userCreateAt);
//            if (punchId !=0){
//                //数据库中由此条记录，说明上午上班
//                userCreateAt.setSiteId(punchId);
//                userCreateAt.setUpdateAt(new Date());
//                PunchTimes punchTimes=new PunchTimes();
//                punchTimes.setPunchId(punchId);
//                punchTimes.setTimes(time);
//                int amS=punchUserMapper.pmStartP(punchTimes);
//                if (amS==1){
//                    return ServiceResult.success("shnag ban 班打卡");
//                }else {
//                    return ServiceResult.failure("打卡失败");
//                }
//            }else {
//                //上午不用打卡，上午放假,上午未打卡
//                PunchUser punchUser = new PunchUser();
//                //根据userID得到userNick
//                String userNick = punchUserMapper.selectByuserId(userCreateAt.getUserId());
//                //根据siteId得到siteNmae
//                String siteName = punchUserMapper.selectBysiteId(userCreateAt.getSiteId());
//                punchUser.setUserNick(userNick);
//                punchUser.setSiteName(siteName);
//                punchUser.setCreateAt(new Date());
//                punchUser.setUpdateAt(new Date());
//                punchUser.setPmStartP(time);
//                int amS = punchUserMapper.amStartP(punchUser);
//                if (amS == 1) {
//                    return ServiceResult.success("下午上班");
//                } else {
//                    return ServiceResult.failure("失败了");
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("打卡失败");
//        }
//    }
//    /**
//     * 下午下班打卡
//     */
//    public ServiceResult pmEndP(UserCreateAt userCreateAt){
//        try{
//
//            //取出数据库中的时间与当前时间对比
//            //2.取出上午下班打卡时间
//            Time amEndAt=punchUserMapper.selectAmEndAtBySiteId(userCreateAt.getSiteId());
//            //取出下午上班时间
//            Time pmStartAt= punchUserMapper.selectPmStartAtBySiteId(userCreateAt.getSiteId());
//            int res1=amEndAt.compareTo(time);
//            int res2=pmStartAt.compareTo(time);
//
////            转换时间格式为数字
//            long digitalDate=time.getTime();
//            long digitalDate2=amEndAt.getTime();
//            long digitalDate3=pmStartAt.getTime();
//            //根据userID得到userNick
//            String userNick=punchUserMapper.selectByuserId(userCreateAt.getUserId());
//            //根据siteId得到siteNmae
//            String siteName=punchUserMapper.selectBysiteId(userCreateAt.getSiteId());
//
//            //根据时间和userId插入
//            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//            userCreateAt.setCreateAt(df.format(new Date()));
//            int punchId=punchUserMapper.selectpunchIdBySiteIdUserIdCreate(userCreateAt);
//            userCreateAt.setSiteId(punchId);
//            userCreateAt.setUpdateAt(new Date());
//            PunchTimes punchTimes=new PunchTimes();
//
////           res1<0则amStartAt<time
//
////            if (res2<0) {
////                //根据punchId插入数据
////                int amS1 = punchUserMapper.amEndP(punchTimes);
////                if (amS1 == 1) {
////                    return ServiceResult.success("缺卡,申请补卡");
////                } else {
////                    return ServiceResult.failure("cuowu");
////                }
////            }else {
//            if (res1>0){
//                punchTimes.setPunchId(punchId);
//                punchTimes.setTimes(time);
//                int amS=punchUserMapper.pmEndP(punchTimes);
//                if (amS==1){
//                    return ServiceResult.success("提前下班打卡");
//                }else {
//                    return ServiceResult.failure("打卡失败");
//                }
//            }else {
//                punchTimes.setPunchId(punchId);
//                punchTimes.setTimes(time);
//                int amS=punchUserMapper.pmEndP(punchTimes);
//                if (amS==1){
//                    return ServiceResult.success("正常下班打卡");
//                }else {
//                    return ServiceResult.failure("打卡失败");
//                }
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("打卡失败");
//        }
//    }
//
//    /**
//     * 晚上上班打卡
//     */
//    public ServiceResult nightStartP(UserCreateAt userCreateAt){
//        try{
//            //取出数据库中的时间与当前时间对比
//            //2.取出上午下班打卡时间
////            Time amEndAt=punchUserMapper.selectAmEndAtBySiteId(userCreateAt.getSiteId());
////            //取出下午上班时间
////            Time pmStartAt= punchUserMapper.selectPmStartAtBySiteId(userCreateAt.getSiteId());
////            int res1=amEndAt.compareTo(time);
////            int res2=pmStartAt.compareTo(time);
////
//////            转换时间格式为数字
////            long digitalDate=time.getTime();
////            long digitalDate2=amEndAt.getTime();
////            long digitalDate3=pmStartAt.getTime();
//
//
//            //根据时间和userId插入
//            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//            userCreateAt.setCreateAt(df.format(new Date()));
//            int punchId=punchUserMapper.selectpunchIdBySiteIdUserIdCreate(userCreateAt);
//            if (punchId !=0){
//                //数据库中由此条记录，说明上午上班
//                userCreateAt.setSiteId(punchId);
//                userCreateAt.setUpdateAt(new Date());
//                PunchTimes punchTimes=new PunchTimes();
//                punchTimes.setPunchId(punchId);
//                punchTimes.setTimes(time);
//                int amS=punchUserMapper.nightStartP(punchTimes);
//                if (amS==1){
//                    return ServiceResult.success("shnag ban 班打卡");
//                }else {
//                    return ServiceResult.failure("打卡失败");
//                }
//            }else {
//                //上午不用打卡，上午放假,上午未打卡
//                PunchUser punchUser = new PunchUser();
//                //根据userID得到userNick
//                String userNick = punchUserMapper.selectByuserId(userCreateAt.getUserId());
//                //根据siteId得到siteNmae
//                String siteName = punchUserMapper.selectBysiteId(userCreateAt.getSiteId());
//                punchUser.setUserNick(userNick);
//                punchUser.setSiteName(siteName);
//                punchUser.setCreateAt(new Date());
//                punchUser.setUpdateAt(new Date());
//                punchUser.setPmStartP(time);
//                int amS = punchUserMapper.amStartP(punchUser);
//                if (amS == 1) {
//                    return ServiceResult.success("下午上班");
//                } else {
//                    return ServiceResult.failure("失败了");
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("打卡失败");
//        }
//    }
//    /**
//     * 上午下班打卡
//     */
//    public ServiceResult nightEndP(UserCreateAt userCreateAt){
//        try{
//
//            //取出数据库中的时间与当前时间对比
//            //2.取出上午下班打卡时间
//            Time amEndAt=punchUserMapper.selectAmEndAtBySiteId(userCreateAt.getSiteId());
//            //取出下午上班时间
//            Time pmStartAt= punchUserMapper.selectPmStartAtBySiteId(userCreateAt.getSiteId());
//            int res1=amEndAt.compareTo(time);
//            int res2=pmStartAt.compareTo(time);
//
////            转换时间格式为数字
//            long digitalDate=time.getTime();
//            long digitalDate2=amEndAt.getTime();
//            long digitalDate3=pmStartAt.getTime();
//            //根据userID得到userNick
//            String userNick=punchUserMapper.selectByuserId(userCreateAt.getUserId());
//            //根据siteId得到siteNmae
//            String siteName=punchUserMapper.selectBysiteId(userCreateAt.getSiteId());
//
//            //根据时间和userId插入
//            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//            userCreateAt.setCreateAt(df.format(new Date()));
//            int punchId=punchUserMapper.selectpunchIdBySiteIdUserIdCreate(userCreateAt);
//            userCreateAt.setSiteId(punchId);
//            userCreateAt.setUpdateAt(new Date());
//            PunchTimes punchTimes=new PunchTimes();
//
////           res1<0则amStartAt<time
//
////            if (res2<0) {
////                //根据punchId插入数据
////                int amS1 = punchUserMapper.amEndP(punchTimes);
////                if (amS1 == 1) {
////                    return ServiceResult.success("缺卡,申请补卡");
////                } else {
////                    return ServiceResult.failure("cuowu");
////                }
////            }else {
//            if (res1>0){
//                punchTimes.setPunchId(punchId);
//                punchTimes.setTimes(time);
//                int amS=punchUserMapper.nightEndP(punchTimes);
//                if (amS==1){
//                    return ServiceResult.success("提前下班打卡");
//                }else {
//                    return ServiceResult.failure("打卡失败");
//                }
//            }else {
//                punchTimes.setPunchId(punchId);
//                punchTimes.setTimes(time);
//                int amS=punchUserMapper.nightEndP(punchTimes);
//                if (amS==1){
//                    return ServiceResult.success("正常下班打卡");
//                }else {
//                    return ServiceResult.failure("打卡失败");
//                }
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new RuntimeException("打卡失败");
//        }
//    }
}
