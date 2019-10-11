package cn.yunding.cp.service;

import cn.yunding.cp.dto.PunchSite;
import cn.yunding.cp.dto.ServiceResult;

import java.io.InputStream;

/**
 * @author haoyuli
 */
public interface PunchService {

    ServiceResult judgeSite(PunchSite punchSite);

    InputStream getInputStreamnull() throws Exception;
}
