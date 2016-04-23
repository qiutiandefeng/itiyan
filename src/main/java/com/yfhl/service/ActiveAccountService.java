package com.yfhl.service;

import com.yfhl.entity.ActiveAccount;

/**
 * 激活码Service层
 * 
 * @author luans
 * @date 2016年3月7日
 *
 */
public interface ActiveAccountService {

	/**
	 * 添加激活码表信息
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

}
