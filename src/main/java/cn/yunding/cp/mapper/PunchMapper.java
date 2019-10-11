package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.PunchSite;
import cn.yunding.cp.dto.UserCreateAt;
import cn.yunding.cp.entity.PunchUser;

import java.util.List;

public interface PunchMapper {
    PunchSite selectPunchLogLatBySiteId(int siteId);

    List<PunchUser> getStuListnull();
}
