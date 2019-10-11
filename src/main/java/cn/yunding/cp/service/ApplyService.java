package cn.yunding.cp.service;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Apply;
import cn.yunding.cp.exception.ServiceException;

import java.util.List;
/**
 * @author chentingDu
 */
public interface ApplyService {
//    int gainUserId();

    /*根据申请id获取申请详情
     * @param applyId
     * @return
     */
    ServiceResult selectDetial (int applyId);

    /**
     * 获取所有的申请类型
     * @return
     */
    ServiceResult findAllTypes ();

    /**
     * 根据用户Id获取所有申请
     * @param userId
     * @return
     */
    ServiceResult findMyApply(int userId);

    /**
     * 发布申请
     * @param apply
     * @return
     */
    ServiceResult insert(Apply apply);
}
