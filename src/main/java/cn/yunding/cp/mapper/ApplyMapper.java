package cn.yunding.cp.mapper;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.entity.Apply;
import cn.yunding.cp.entity.ApplyType;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author chentingDu
 */
public interface ApplyMapper {
    /**
     * 查询申请详情
     * @param applyId
     * @return
     */
    Apply selectDetial(@Param("applyId") int applyId);

    /**
     * 获取所有申请类型
     * @return
     */
    List<Apply> findAllTypes();

    /**
     * 根据用户id获取
     * @param userId
     * @return
     */
    List<Apply> findMyApply(@Param("userId") int userId);

    /**
     * 发布申请
     * @param apply
     * @return
     */
    int insert(Apply apply);
}
