package com.yfhl.service;

import com.yfhl.entity.Exhibition;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月13日 下午9:00:23
 * 类说明
 */
public interface Exhibitionservice {
	
	int deleteByPrimaryKey(Integer mid);

    int insert(Exhibition record);

    int insertSelective(Exhibition record);

    Exhibition selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Exhibition record);

    int updateByPrimaryKeyWithBLOBs(Exhibition record);

    int updateByPrimaryKey(Exhibition record);
    
    /**
     * 根据时间段来查询商品的增长数
     * @param startTime
     * @param endTime
     * @return
     * @author Chris li Email:lj520212@gmail.com
     * @date 2015年11月13日
     */
    int getCountExhibitionByTime(String startTime, String endTime);

}
