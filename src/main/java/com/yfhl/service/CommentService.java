package com.yfhl.service;

import java.util.List;

import com.yfhl.entity.Comment;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月30日 下午8:11:02 类说明
 */
public interface CommentService {

	int deleteByPrimaryKey(Integer cid);

	int insert(Comment record);

	Comment selectByPrimaryKey(Integer cid);

	int updateByPrimaryKeySelective(Comment record);

	int updateByPrimaryKey(Comment record);

	/**
	 * 分页查询List
	 * 
	 * @param comment
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月30日
	 */
	List<Comment> queryListByPage(Comment comment);

	/**
	 * 添加商品评论
	 * 
	 * @param Comment
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int insertSelective(Comment record);

	/**
	 * 根据商品的编号查询该商品的评论数量
	 * @param mid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	Integer getModelCommentCount(Integer mid);

}
