package com.yfhl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Comment;
import com.yfhl.service.CommentService;
import com.yfhl.service.ModelService;
import com.yfhl.service.UserService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月30日 下午8:08:41 类说明
 */
@Controller
@RequestMapping("comment")
public class CommentController {

	@Resource
	private UserService userService;

	@Resource
	private CommentService commentService;

	@Resource
	private ModelService modelService;

	/**
	 * 展示评论信息List
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月30日
	 */
	@RequestMapping("queryList")
	public ModelAndView queryList(Comment comment) {
		ModelAndView mv = new ModelAndView();
		comment.getPageInfo().setPageSize(8);
		List<Comment> commentList = commentService.queryListByPage(comment);
		mv.addObject("commentList", commentList);
		mv.addObject("comments", comment);
		mv.setViewName("/manager/commentManage/commentList");

		return mv;
	}

	/**
	 * 添加评论
	 * 
	 * @param Comment
	 * @return int
	 * @date 2015年12月18日
	 * @auther luans
	 */
	@RequestMapping("addComment")
	@ResponseBody
	public int addComment(Comment comment) {
		System.out.println("comment=" + comment.toString());
		int result = commentService.insertSelective(comment);
		return result;
	}

}
