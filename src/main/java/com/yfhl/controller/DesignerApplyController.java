package com.yfhl.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.DesignerApply;
import com.yfhl.service.DesignerApplyService;
import com.yfhl.service.UserService;

/**
 * 设计师申请Controller
 * 
 * @date 2015年11月16日
 * @auther luans
 *
 */
@Controller
@RequestMapping("designerApplyController")
public class DesignerApplyController {
	@Resource
	public DesignerApplyService designerApplyService;//注入申请设计师Service层实例对象
	@Resource
	public UserService userServiceImpl;//注入用户Service层实例对象

	/**
	 * 设计师管理：分页查询设计师申请List
	 * 
	 * @param DesignerApply
	 * @return ModelAndView
	 * @date 2015年11月16日
	 * @auther luans
	 */
	@RequestMapping("queryList")
	public ModelAndView queryList(DesignerApply designerApply) {
		ModelAndView mv = new ModelAndView();
		designerApply.getPageInfo().setPageSize(4);
		List<DesignerApply> list = designerApplyService
				.queryListByPage(designerApply);
		mv.addObject("list", list);
		mv.setViewName("/manager/userManage/designerApplyList");
		return mv;
	}

	/**
	 * 设计师管理：审核
	 * 
	 * @param DesignerApply
	 * @return ModelAndView
	 * @date 2015年11月17日
	 * @auther luans
	 */
	@RequestMapping("checkDensignerApply")
	public ModelAndView checkDensignerApply(DesignerApply designerApply) {
		designerApplyService.checkDensignerApply(designerApply);

		return queryList(designerApply);
	}

}
