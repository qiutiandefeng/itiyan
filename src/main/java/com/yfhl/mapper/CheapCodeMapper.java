package com.yfhl.mapper;

import com.yfhl.entity.CheapCode;

/**
 * 优惠券dao层
 * @author luans
 *
 */
public interface CheapCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheapCode record);

    int insertSelective(CheapCode record);

    CheapCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheapCode record);

    int updateByPrimaryKey(CheapCode record);
    
    /**
     * 根据有效活动编号查询有效的优惠券
     * @param activityId
     * @return CheapCode
     * @author Chris li Email:lj520212@gmail.com
     * @date 2016年1月11日
     */
	CheapCode getCheapCodeByActivityId(Integer activityId);
}