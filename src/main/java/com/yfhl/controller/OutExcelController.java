package com.yfhl.controller;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfhl.entity.Model;
import com.yfhl.entity.User;
import com.yfhl.service.ModelService;
import com.yfhl.service.UserService;
import com.yfhl.util.OutExcelSynthesize;

/**
 * 导出Excel表格Controller
 * 
 * @date 2015年11月18日
 * @author luans
 *
 */
@Controller
@RequestMapping("outExcelController")
public class OutExcelController {

	@Resource
	public UserService userServiceImpl;//注入用户Service层对象
	@Resource
	public ModelService modelServiceImpl;//注入商品Service层对象

	/**
	 * 导出普通用户
	 * 
	 * @param HttpServletResponse,User
	 * @throws Exception
	 * @date 2015年11月12日
	 * @auther luans
	 */
	@RequestMapping("outExcelCommonUser")
	public void OutExcelCommonUser(HttpServletResponse response, User user)
			throws Exception {
		System.out.println("参数："+user.getGroupId()+" 模糊查询条件："+user.getMarkUserfrom());
		String name = "普通用户";
		if (user.getGroupId() == 2) {
			name = "设计师";
		}
		OutputStream os = response.getOutputStream();// 取得输出流
		// 获得当前时间
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// Date date = new Date();
		// 下面是对中文文件名的处理
		response.setCharacterEncoding("UTF-8");
		String fname = java.net.URLEncoder.encode(name, "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fname + ".xls");
		response.setContentType("application/msexcel");// 定义输出类型
		// 生成复杂的电子表格
		OutExcelSynthesize cw = new OutExcelSynthesize();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		// 设置日期格式
		// System.out.println("1进入查找考生信息时间：" + df.format(new Date()));//
		List<User> list = userServiceImpl.queryOutUser(user);// 获取导出信息
		// System.out.println("2出来查找考生信息时间：" + df.format(new Date()));// new

		// System.out.println("3进入查询考生考试信息时间：" + df.format(new Date()));// new
		try {
			cw.createsingleExcel(os, list,name);// 调用创建excel方法
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 导出商品信息
	 * @param HttpServletResponse,Model
	 * @throws Exception
	 * @date 2015年12月2日
	 * @auther luans
	 */
	@RequestMapping("outExcelModel")
	public void OutExcelModel(HttpServletResponse response,Model model)throws Exception{
		
		OutputStream os = response.getOutputStream();// 取得输出流
		// 获得当前时间
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// Date date = new Date();
		// 下面是对中文文件名的处理
		response.setCharacterEncoding("UTF-8");
		String fname = java.net.URLEncoder.encode("商品信息", "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fname + ".xls");
		response.setContentType("application/msexcel");// 定义输出类型
		// 生成复杂的电子表格
		OutExcelSynthesize cw = new OutExcelSynthesize();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		// 设置日期格式
		// System.out.println("1进入查找考生信息时间：" + df.format(new Date()));//
		List<Model> list = modelServiceImpl.queryOutModel(model);// 获取导出信息
		// System.out.println("2出来查找考生信息时间：" + df.format(new Date()));// new

		// System.out.println("3进入查询考生考试信息时间：" + df.format(new Date()));// new
		try {
			cw.outModelExcel(os, list);// 调用创建excel方法
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
