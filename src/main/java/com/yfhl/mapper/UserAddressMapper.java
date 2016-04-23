package com.yfhl.mapper;

import java.util.List;

import com.yfhl.entity.UserAddress;

/**
 * 用户收货地址dao层
 * 
 * @date 2015年12月27日
 * @author luans
 *
 */
public interface UserAddressMapper {

	/**
	 * 删除用户收货地址信息
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer id);

	/**
	 * 修改用户收货地址信息
	 * 
	 * @param UserAddress
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int updateByPrimaryKeySelective(UserAddress record);

	/**
	 * 设置默认地址
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int setDefault(Integer id);

	/**
	 * 添加用户收货地址
	 * 
	 * @param UserAddress
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int insertSelective(UserAddress record);

	/**
	 * 清空默认地址
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月27日
	 * @auther luans
	 */
	public int clearDefault(Integer uid);

	/**
	 * 根据ID查询收货地址信息
	 * 
	 * @param Integer
	 * @return UserAddress
	 * @date 2016年3月3日
	 * @auther luans
	 */
	public UserAddress selectByPrimaryKey(Integer id);

	/**
	 * 根据用户的编号来查询——>User_Address
	 * 
	 * @param uid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月9日
	 */
	public List<UserAddress> selectUserAddressListByUid(Integer uid);

	int insert(UserAddress record);

	int updateByPrimaryKey(UserAddress record);

	public List<UserAddress> queryUserAddressByUid(Integer uid);

}