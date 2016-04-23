package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.UserCode;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年1月11日 上午2:42:17
 * 类说明
 */
public interface UserCodeService {

	int deleteByPrimaryKey(Integer id);

    int insert(UserCode record);

    int insertSelective(UserCode record);

    UserCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCode record);

    int updateByPrimaryKey(UserCode record);

    /**
     * 根据用户编号查询用户的优惠券
     * @param uid
     * @return List<UserCode>
     * @author Chris li Email:lj520212@gmail.com
     * @date 2016年1月11日
     */
	List<UserCode> getUserCodeListByUid(Integer uid);
	
}
