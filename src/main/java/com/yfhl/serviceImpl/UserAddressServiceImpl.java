package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.UserAddress;
import com.yfhl.mapper.UserAddressMapper;
import com.yfhl.service.UserAddressService;

/**
 * 用户收货地址Service实现类层
 * 
 * @date 2015年12月27日
 * @author luans
 *
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

	@Resource
	private UserAddressMapper userAddressMapper;// 注入用户地址dao层实例对象

	/**
	 * 根据用户Id查询用户收货地址
	 * 
	 * @param Integer
	 * @return List<UserAddress>
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public List<UserAddress> queryUserAddressByUid(Integer uid) {
		return userAddressMapper.queryUserAddressByUid(uid);
	}

	/**
	 * 删除用户收货地址
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer id) {
		return userAddressMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改用户收货地址信息
	 * 
	 * @param UserAddress
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int updateByPrimaryKeySelective(UserAddress record) {
		int result = 0;
		if (record.getIsDefault() == 1) {
			// 如果要修改为默认地址，则先清空默认地址信息
			result = this.clearDefault(record.getUid());
		}
		if (record.getMarkManage() == 1) {// 添加
			record.setAddTime(new Date());
			result = userAddressMapper.insertSelective(record);

		} else if (record.getMarkManage() == 2) {// 修改
			result = userAddressMapper.updateByPrimaryKeySelective(record);
		}
		return result;
	}

	/**
	 * 设置默认地址
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int setDefault(Integer id) {
		return userAddressMapper.setDefault(id);
	}

	/**
	 * 添加用户收货地址
	 * 
	 * @param UserAddress
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int insertSelective(UserAddress record) {
		return userAddressMapper.insertSelective(record);
	}

	/**
	 * 清空默认地址
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int clearDefault(Integer uid) {
		return userAddressMapper.clearDefault(uid);
	}

	/**
	 * 根据ID查询收货地址信息
	 * 
	 * @param Integer
	 * @return UserAddress
	 * @date 2016年3月3日
	 * @auther luans
	 */
	public UserAddress selectByPrimaryKey(Integer id) {
		return userAddressMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据用户的编号来查询——>User_Address
	 * 
	 * @param uid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月9日
	 */
	public List<UserAddress> selectUserAddressListByUid(Integer uid) {
		return userAddressMapper.selectUserAddressListByUid(uid);
	}
}
