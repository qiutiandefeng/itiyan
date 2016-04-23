package com.yfhl.mapper;

import java.util.List;

import com.yfhl.entity.UserCode;

/**
 *  用户领取的优惠码记录(关联到微信端)
 * @author luans
 *
 */
public interface UserCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCode record);

    int insertSelective(UserCode record);

    UserCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCode record);

    int updateByPrimaryKey(UserCode record);

	List<UserCode> getUserCodeListByUid(Integer uid);
}