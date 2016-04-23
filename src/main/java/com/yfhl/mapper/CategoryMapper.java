package com.yfhl.mapper;

import java.util.List;

import com.yfhl.entity.Category;

/**
 * 商品类别Dao层
 * 
 * @author luans
 *
 */
public interface CategoryMapper {

	/**
	 * 根据条件获取商品类别信息
	 * 
	 * @param Category
	 * @return List<Category>
	 * @date 2015年11月23日
	 * @auther luans
	 */
	public List<Category> queryCategory(Category category);

	/**
	 * 计算商品类别在改类别下的顺序
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public int getOrder(Integer pid);

	/**
	 * 根据ID查询类别名称
	 * 
	 * @param int
	 * @return Category
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public Category queryCategoryById(int id);

	/**
	 * 添加商品类别
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public int insert(Category record);

	/**
	 * 修改商品类别信息
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月24日
	 * @auther luans
	 */
	public int updateByPrimaryKeySelective(Category record);

	/**
	 * 删除商品类目信息
	 * 
	 * @param Integer
	 * @return int
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public int deleteByPrimaryKey(Integer categoryId);

	/**
	 * 查询所有同一级别下排序在其后的商品类别ID
	 * 
	 * @param Category
	 * @return List<Integer>
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public List<Integer> getMoveOrderId(Category category);

	/**
	 * 改变位置顺序
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public int moveOrderTo(Category category);

	/**
	 * 改变目标位置的排列顺序
	 * 
	 * @param Category
	 * @return int
	 * @date 2015年11月25日
	 * @auther luans
	 */
	public int moveOrdergoal(Category category);

	/**
	 * 查询商品类别：PC端首页显示更多产品：最新添加的6个
	 * 
	 * @return List<Category>
	 * @date 2016年3月14日
	 * @auther luans
	 */
	public List<Category> queryCategoryForIndex();

	int insertSelective(Category record);

	Category selectByPrimaryKey(Integer categoryId);

	int updateByPrimaryKey(Category record);

	/**
	 * 获取所有的商品类别
	 * 
	 * @param Category
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	public List<Category> getModelCategoryAll(Category record);

}