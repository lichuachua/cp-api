package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.Distance;
import cn.yunding.cp.dto.PunchSite;
import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.WriteExcel;
import cn.yunding.cp.entity.PunchUser;
import cn.yunding.cp.mapper.ItemMapper;
import cn.yunding.cp.mapper.PunchMapper;
import cn.yunding.cp.service.PunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haoyuli
 */
@Service
public class PunchServiceImpl implements PunchService {
    @Autowired
    PunchMapper punchMapper;
    ItemMapper itemMapper;

    /**
     * 查询是否在范围
     */
    @Override
    public ServiceResult judgeSite(PunchSite punchSite) {

        try{
            //根据Id取得数据库中的经纬度和范围
            PunchSite p=punchMapper.selectPunchLogLatBySiteId(punchSite.getSiteId());

            //判断当前地点和所在地的距离(通过经纬度)
            double distance=Distance.GetDistance(punchSite.getLng(),punchSite.getLat(),p.getLng(),p.getLat());
            if (distance<0.1){
                return ServiceResult.success("您在打卡范围内，可以打卡");
            }else {
                return ServiceResult.failure("您不在打卡范围内，选择外勤打卡");
            }


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("没有获取到当前位置");
        }
    }
    /**
     * 生成所有项目组excle表
     */
    public InputStream getInputStreamnull() throws Exception {
        String [] title=new String[]{
                "地点","成员","上午","上午","下午","下午","晚上","晚上","日期"
        };
        List<PunchUser> plist=punchMapper.getStuListnull();
        List<Object[]> dataList= new ArrayList<Object[]>();
        for (int i=0;i<plist.size();i++){
            Object[] obj=new Object[9];
            obj[0]=plist.get(i).getSiteName();
            obj[1]=plist.get(i).getUserNick();
            obj[2]=plist.get(i).getAmStartP();
            obj[3]=plist.get(i).getAmEndP();
            obj[4]=plist.get(i).getPmStartP();
            obj[5]=plist.get(i).getPmEndP();
            obj[6]=plist.get(i).getNightStartP();
            obj[7]=plist.get(i).getNightEndP();
            obj[8]=plist.get(i).getCreateAt();

            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;

    }


}


