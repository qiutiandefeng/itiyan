package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.DesignerApply;

/**
 * 用户管理:设计师申请Service层
 * 
 * @date 2015年11月16日
 * @auther luans
 *
 */
public interface DesignerApplyService {

	/**
	 * 分页查询用户List
	 * 
	 * @param DesignerApply
	 * @return List<DesignerApply>
	 * @date 2015年11月16日
	 * @auther luans
	 */
	public List<DesignerApply> queryListByPage(DesignerApply designerApply);

	/**
	 * 用户管理：条件查询设计师
	 * 
	 * @param DesignerApply
	 * @return DesignerApply
	 * @date 2015年11月17日
	 * @auther luans
	 */
	public DesignerApply queryDesigner(DesignerApply designerApply);

	/**
	 * 设计师管理：审核
	 * 
	 * @param DesignerApply
	 * @return ModelAndView
	 * @date 2015年11月17日
	 * @auther luans
	 */
	public void checkDensignerApply(DesignerApply designerApply);

}
