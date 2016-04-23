package com.yfhl.service;

import com.yfhl.entity.CheapCode;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年1月11日 上午2:50:39
 * 类说明
 */
public interface CheapCodeService {

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
