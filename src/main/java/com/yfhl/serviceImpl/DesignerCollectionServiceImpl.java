package com.yfhl.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.DesignerCollection;
import com.yfhl.mapper.DesignerCollectionMapper;
import com.yfhl.service.DesignerCollectionService;

/**
 * 用户收藏设计师Servic实现类层
 * 
 * @date 2015年12月18日
 * @author luans
 *
 */
@Service
public class DesignerCollectionServiceImpl implements DesignerCollectionService {
	@Resource
	public DesignerCollectionMapper designerCollectionMapper;

	/**
	 * 用户添加收藏设计师
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int insertSelective(DesignerCollection record) {

		return designerCollectionMapper.insertSelective(record);
	}

	/**
	 * 删除收藏
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer dcId) {
		return designerCollectionMapper.deleteByPrimaryKey(dcId);
	}

	/**
	 * 查询设计师被收藏ID
	 * 
	 * @param DesignerCollection
	 * @return Integer
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public Integer queryId(DesignerCollection record) {
		return designerCollectionMapper.queryId(record);
	}

	/**
	 * 统计判断用户对该设计师是否收藏
	 * 
	 * @param DesignerCollection
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int queryCount(DesignerCollection record) {
		return designerCollectionMapper.queryCount(record);
	}
}
