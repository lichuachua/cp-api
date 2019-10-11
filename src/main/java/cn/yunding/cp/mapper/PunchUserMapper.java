package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.PunchTimes;
import cn.yunding.cp.dto.UserCreateAt;
import cn.yunding.cp.entity.PunchUser;
import cn.yunding.cp.entity.Punchs;

import java.sql.Time;

public interface PunchUserMapper {
    int insert(Punchs punchs);

    String selectByuserId(int userId);

    String selectBysiteId(int siteId);

    Time selectAmStartAtBySiteId(int siteId);

    Time selectAmEndAtBySiteId(int siteId);

    int amStartP(PunchUser punchUser);

    Time selectPmStartAtBySiteId(int siteId);

    int selectpunchIdBySiteIdUserIdCreate(UserCreateAt userCreateAt);

    int amEndP(PunchTimes punchTimes);

    int pmStartP(PunchTimes punchTimes);

    int pmEndP(PunchTimes punchTimes);

    int nightStartP(PunchTimes punchTimes);

    int nightEndP(PunchTimes punchTimes);

    String selectAmEndAt2BySiteId(int siteId);

    String selectAmStartAt2BySiteId(int siteId);
}
