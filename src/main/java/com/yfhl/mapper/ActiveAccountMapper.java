package com.yfhl.mapper;

import com.yfhl.entity.ActiveAccount;

/**
 * 注册激活码dao层
 * 
 * @date 2016年3月7日
 *
 */
public interface ActiveAccountMapper {

	/**
	 * 添加注册激活码表信息
	 * 
	 * @param ActiveAccount
	 * @return int
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public int insertSelective(ActiveAccount record);

	/**
	 * 激活码验证，查询激活码实体类信息
	 * 
	 * @param ActiveAccount
	 * @return ActiveAccount
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public ActiveAccount queryActiveAccountByself(ActiveAccount record);

	/**
	 * 激活码成功后，删除激活码实体类信息
	 * 
	 * @param ActiveAccount
	 * @return int
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public int deleteActiveAccount(ActiveAccount record);

	ActiveAccount selectByPrimaryKey(Integer aaId);

	int updateByPrimaryKeySelective(ActiveAccount record);

	int updateByPrimaryKey(ActiveAccount record);
}