package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.Texture;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月30日 上午11:34:26
 * 类说明
 */
public interface TextureSerice {

	int deleteByPrimaryKey(Integer tid);

    int insert(Texture record);

    int insertSelective(Texture record);

    Texture selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Texture record);

    int updateByPrimaryKeyWithBLOBs(Texture record);

    int updateByPrimaryKey(Texture record);

    /**
     * 获取所有的Texture
     * @return
     * @author Chris li Email:lj520212@gmail.com
     * @date 2015年12月16日
     */
	List<Texture> getTextureAll();

	
}
