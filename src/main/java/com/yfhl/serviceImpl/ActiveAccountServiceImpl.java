package com.yfhl.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.ActiveAccount;
import com.yfhl.mapper.ActiveAccountMapper;
import com.yfhl.service.ActiveAccountService;

/**
 * 激活码Service实现类层
 * 
 * @author luans
 *
 */
@Service
public class ActiveAccountServiceImpl implements ActiveAccountService {

	@Resource
	public ActiveAccountMapper activeAccountMapper;

	/**
	 * 添加激活码表信息
	 * 
	 * @param ActiveAccount
	 * @return int
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public int insertSelective(ActiveAccount record) {
		return activeAccountMapper.insertSelective(record);
	}

	/**
	 * 激活码验证，查询激活码实体类信息
	 * 
	 * @param ActiveAccount
	 * @return ActiveAccount
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public ActiveAccount queryActiveAccountByself(ActiveAccount record) {
		return activeAccountMapper.queryActiveAccountByself(record);
	}

	/**
	 * 激活码成功后，删除激活码实体类信息
	 * 
	 * @param ActiveAccount
	 * @return int
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public int deleteActiveAccount(ActiveAccount record) {
		return activeAccountMapper.deleteActiveAccount(record);
	}
}
