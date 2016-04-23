package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.DesignerApply;
import com.yfhl.entity.User;
import com.yfhl.mapper.DesignerApplyMapper;
import com.yfhl.mapper.UserMapper;
import com.yfhl.service.DesignerApplyService;

/**
 * 用户管理：设计师申请ServiceImpl实现类
 * 
 * @date 2015年11月16日
 * @author luans
 *
 */
@Service
public class DesignerApplyServiceImpl implements DesignerApplyService {

	@Resource
	public DesignerApplyMapper designerApplyMapper;//注入申请设计师dao层对象
	@Resource
	public UserMapper userMapper;//注入用户dao层对象

	/**
	 * 分页查询用户List
	 * 
	 * @param DesignerApply
	 * @return List<DesignerApply>
	 * @date 2015年11月16日
	 * @auther luans
	 */
	public List<DesignerApply> queryListByPage(DesignerApply designerApply) {

		return designerApplyMapper.queryListByPage(designerApply);
	}

	/**
	 * 用户管理：条件查询设计师
	 * 
	 * @param DesignerApply
	 * @return DesignerApply
	 * @date 2015年11月17日
	 * @auther luans
	 */
	public DesignerApply queryDesigner(DesignerApply designerApply) {

		return designerApplyMapper.queryDesigner(designerApply);
	}

	/**
	 * 设计师管理：审核
	 * 
	 * @param DesignerApply
	 * @date 2015年11月17日
	 * @auther luans
	 */
	public void checkDensignerApply(DesignerApply designerApply) {

		User user = new User();
		user.setUid(designerApply.getUid());
		if (designerApply.getApplydState() == 3) {// 审核通过
			user.setStudioStatus(3);
			user.setGroupId(4);
			// 修改用户表状态
			userMapper.densignerApplyPass(user);
		} else if (designerApply.getApplydState() == 4) {// 审核不通过
			user.setStudioStatus(4);
		}

		designerApplyMapper.checkDensignerApply(designerApply);
	}
}
