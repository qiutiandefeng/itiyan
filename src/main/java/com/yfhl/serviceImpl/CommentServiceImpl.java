package com.yfhl.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yfhl.entity.Comment;
import com.yfhl.mapper.CommentMapper;
import com.yfhl.service.CommentService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月30日 下午8:13:31 类说明
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;

	public int deleteByPrimaryKey(Integer cid) {
		return commentMapper.deleteByPrimaryKey(cid);
	}

	public int insert(Comment record) {
		return commentMapper.insert(record);
	}

	public Comment selectByPrimaryKey(Integer cid) {
		return commentMapper.selectByPrimaryKey(cid);
	}

	public int updateByPrimaryKeySelective(Comment record) {
		return commentMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Comment record) {
		return commentMapper.updateByPrimaryKey(record);
	}

	public List<Comment> queryListByPage(Comment comment) {
		return commentMapper.queryListByPage(comment);
	}

	/**
	 * 添加商品评论
	 * 
	 * @param Comment
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	public int insertSelective(Comment record) {
		// 添加评论添加时间
		record.setAddTime(new Date());
		return commentMapper.insertSelective(record);
	}

	/**
	 * 根据商品的编号查询该商品的评论数量
	 * @param mid
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年3月5日
	 */
	@Override
	public Integer getModelCommentCount(Integer mid) {
		return commentMapper.getModelCommentCount(mid);
	}

}
