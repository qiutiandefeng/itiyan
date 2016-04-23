package com.yfhl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.util.CommUtil;
import com.yfhl.util.MySQLDatabaseBackup;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年12月1日 上午11:05:46
 * 类说明
 */
@Controller
@RequestMapping("systemTools")
public class SystemToolsController {

	
	   /**
	    * 保存数据备份
	    * @param request
	    * @param response
	    * @return json
	    * @throws Exception
	    * @author Chris li Email:lj520212@gmail.com
	    * @date 2015年12月3日
	    */
	   @RequestMapping({"/databaseBackup"})
	   @ResponseBody
	   public Map databaseBackup(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       Map map = new HashMap();
	       String preBoundSize = request.getParameter("preBoundSize");
	       String name = request.getParameter("name");
		   if (CommUtil.null2Float(preBoundSize) >= 20.0F) {
	           
			   if (MySQLDatabaseBackup.exportDatabaseTool("192.168.31.200", "root", "admin", "D:/backupDatabase", System.currentTimeMillis()+"_"+name+".sql", "creatia")) {
		            System.out.println("数据库备份成功！！！");
		            map.put("state", "数据库备份成功");
		        } else {
		            System.out.println("数据库备份失败！！！");
		            map.put("state", "数据库备份失败");
		        }
	       }
	     else {
	       map.put("state", "分卷小于20k,数据备份失败");
	     }
	     return map;
	   }
	   
	   /**
	    * 跳转到DatabaseBackup
	    * @return
	    * @author Chris li Email:lj520212@gmail.com
	    * @date 2015年12月3日
	    */
	   @RequestMapping("selectDatabaseBackup")
		public String selectDatabaseBackup() {
		   
			return "manager/systemTools/dataBackup";
	   }
	   
	   @RequestMapping("quartzSwitching")
		public String quartzSwitching() {
		   
			return "manager/systemTools/quartzSwitching";
	   }
	   
	   @RequestMapping({"/saveQuartzSwitching"})
	   @ResponseBody
	   public Map saveQuartzSwitching(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       Map map = new HashMap();
	       String cancel = request.getParameter("cancel");
	       String receipt = request.getParameter("receipt");
		   if (CommUtil.isNotNull(cancel) || CommUtil.isNotNull(receipt)) {
	           
			   
	       }
	     else {
	       map.put("state", "设置失败");
	     }
	     return map;
	   }
}
