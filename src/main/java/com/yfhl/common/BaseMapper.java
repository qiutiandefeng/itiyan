package com.yfhl.common;

import java.util.List;


/**
 * 
 * @author MAjb
 *	
 * @param <Entity>
 *  该接口为父接口，提供最基本的接口方法，子接口继承父接口之后，重复的接口方法就不需要再次重写了
 */
public interface BaseMapper<Entity> {

	/**
	 * 通过id进行查询
	 */
	Entity queryById(int id) throws Exception;
	/**
	 * 添加
	 */
	void insert(Entity entity) throws Exception;
	/**
	 * 更新
	 */
	void update(Entity entity) throws Exception;
	/**
	 * 删除
	 */
	void delete(Entity entity) throws Exception;
	/**
	 * 根据分页参数查询数据集合 
	 */
	List<Entity> queryListByPage(Entity entity) throws Exception;

}
