package cn.yunding.cp.service.impl;

import cn.yunding.cp.dto.ServiceResult;
import cn.yunding.cp.dto.UserId;
import cn.yunding.cp.entity.Apply;
import cn.yunding.cp.entity.ApplyType;
import cn.yunding.cp.entity.UserIdentity;
import cn.yunding.cp.exception.ServiceException;
import cn.yunding.cp.mapper.ApplyMapper;
import cn.yunding.cp.mapper.UserIdentityMapper;
import cn.yunding.cp.service.ApplyService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService{

    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    UserIdentityMapper userIdentityMapper;
//    @Override
//    public int gainUserId() {
//        UserIdentity userIdentity = new UserIdentity();
//        int uId = userIdentityMapper.selectByUserId(userIdentity.getUserId());
//        return uId;
//    }

    /**
     * 获取文章详情
     * @param applyId
     * @return
     */
    @Override

    public ServiceResult selectDetial(int applyId) {
        try {
            Apply applyDetial=
                    applyMapper.selectDetial(applyId);
            return ServiceResult.success(applyDetial);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *获取申请类型
     * @return
     */
    @Override
    public ServiceResult findAllTypes() {
        try {
            List<Apply> applyType =
                    applyMapper.findAllTypes();
            if (applyType.size() > 0) {
                return ServiceResult.success(applyType);
            } else {
                return ServiceResult.failure("操作失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 根据userId获取用户申请
     * @param userId
     * @return
     */
    @Override
    public ServiceResult findMyApply(int userId) {
        try {
            List<Apply> list =
                    applyMapper.findMyApply(userId);
            if (list.size() > 0) {
                return ServiceResult.success(list);
            } else {
                return ServiceResult.failure("操作失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
   }
    /**
     * 发布申请
     */
    @Override

        public ServiceResult insert(Apply apply){
        try{
            UserId userId=new UserId();
//            userId.gainUserId();
//            apply.setUserId(userId.gainUserId());
//            gainUserId();
            apply.setCreateAt(new Date());
            apply.setUpdateAt(new Date());
            int result=applyMapper.insert(apply);
            if(result!=1){
                return ServiceResult.failure("操作失败");
            }else {
                return ServiceResult.success(apply);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ServiceResult.failure(" 失败了 ");
        }
    }
}
