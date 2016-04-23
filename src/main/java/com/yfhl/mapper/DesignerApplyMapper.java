package com.yfhl.mapper;

import java.util.List;

import com.yfhl.entity.DesignerApply;

/**
 * 用户管理：设计师dao层接口
 * 
 * @author luans
 *
 */
public interface DesignerApplyMapper {

	/**
	 * 用户管理：添加设计师
	 * 
	 * @param DesignerApply
	 * @return int
	 * @date 2015年11月16日
	 * @auther luans
	 */
	public int insert(DesignerApply designerApply);

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
	 * @date 2015年11月17日
	 * @auther luans
	 */
	public void checkDensignerApply(DesignerApply designerApply);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(DesignerApply record);

	DesignerApply selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DesignerApply record);

	int updateByPrimaryKeyWithBLOBs(DesignerApply record);

	int updateByPrimaryKey(DesignerApply record);
}