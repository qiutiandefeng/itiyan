package com.yfhl.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yfhl.entity.Texture;
import com.yfhl.mapper.TextureMapper;
import com.yfhl.service.TextureSerice;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月30日 上午11:35:06
 * 类说明
 */
@Service
@Transactional
public class TextureSericeImpl implements TextureSerice {

	@Resource
	private TextureMapper textureMapper;
	
	public int deleteByPrimaryKey(Integer tid) {
		return textureMapper.deleteByPrimaryKey(tid);
	}

	public int insert(Texture record) {
		return textureMapper.insert(record);
	}

	public int insertSelective(Texture record) {
		return textureMapper.insertSelective(record);
	}

	public Texture selectByPrimaryKey(Integer tid) {
		return textureMapper.selectByPrimaryKey(tid);
	}

	public int updateByPrimaryKeySelective(Texture record) {
		return textureMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Texture record) {
		return textureMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Texture record) {
		return textureMapper.updateByPrimaryKey(record);
	}

	public List<Texture> getTextureAll() {
		return textureMapper.getTextureAll();
	}

	

}
