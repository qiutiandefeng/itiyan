package com.yfhl.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Category;
import com.yfhl.entity.DesignerApply;
import com.yfhl.entity.DesignerCollection;
import com.yfhl.entity.Model;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.User;
import com.yfhl.service.CategoryService;
import com.yfhl.service.DesignerApplyService;
import com.yfhl.service.DesignerCollectionService;
import com.yfhl.service.ModelCollectionService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.UserService;
import com.yfhl.util.CodeUtil;
import com.yfhl.util.EncryptUtil;
import com.yfhl.util.Md5Encrypt;

/**
 * 用户Controller
 * 
 * @author luans
 * @date 2015年11月9日
 */
@Controller
@RequestMapping("/userManage")
public class UserController {
	@Resource
	public UserService userServiceImpl;// 注入用户Service层实例对象
	@Resource
	public DesignerApplyService designerApplyService;// 注入申请设计师Service层实例对象
	@Resource
	public ModelShoppingService modelShoppingService;// 注入购物车Service层实例
	@Resource
	public ModelService modelService;// 注入商品Service层实例
	@Resource
	public ModelCollectionService modelCollectionService;// 注入商品收藏Service层实例对象
	@Resource
	public DesignerCollectionService designerCollectionService;

	@Resource
	public CategoryService categoryService;// 注入商品类别Service层实例对象

	/**
	 * 用户管理：分页查询用户List
	 * 
	 * @param User
	 * @return ModelAndView
	 * @date 2015年11月9日
	 * @auther luans
	 */
	@RequestMapping("queryList")
	public ModelAndView queryList(User user) {
		System.out.println("当前页：" + user.getPageInfo().getPageIndex());
		// 处理条件查询时条件乱码问题
		user = turnCode(user);
		ModelAndView mv = new ModelAndView();
		if (user.getGroupId() == null) {// 解决自动导出excel自动跳转问题
			return mv;
		}
		System.out.println("进入分页查询Controller" + user.toString());

		user.getPageInfo().setPageSize(10);
		List<User> list = userServiceImpl.queryListByPage(user);
		User users = userServiceImpl.queryUserCount(user);
		user.setSumCount(users.getSumCount());
		user.setpCount(users.getpCount());
		user.setwCount(users.getwCount());
		mv.addObject("list", list);
		mv.addObject("user", user);
		if (user.getMarkSelect() != null && user.getMarkSelect() == 1) {
			mv.setViewName("/manager/userManage/sel_designer");
		} else {
			mv.setViewName("/manager/userManage/userList");
		}
		return mv;
	}

	/**
	 * 用户管理：去用户操作页面（添加、编辑）
	 * 
	 * @param User
	 *            ,DesignerApply
	 * @return ModelAndView
	 * @date 2015年11月11日
	 * @auther luans
	 */
	@RequestMapping("gotoUserManage")
	public ModelAndView gotoUserManage(User user, DesignerApply designerApply) {
		// 处理条件查询时条件乱码问题
		user = turnCode(user);
		ModelAndView mv = new ModelAndView();
		if (user.getMarkManage() == 1) {
			mv.addObject("user", user);
			if (user.getGroupId() == 1) {// 添加普通用户
				System.out.println("去添加普通用户");
				mv.addObject("user", user);
				mv.setViewName("/manager/userManage/commonUser");
			} else if (user.getGroupId() == 4) {// 添加设计师
				System.out.println("去添加设计师");
				mv.addObject("user", user);
				mv.setViewName("/manager/userManage/designerUserApply");
			}
		} else if (user.getMarkManage() == 2) {
			if (user.getGroupId() == 1) {// 编辑普通用户
				System.out.println("去编辑普通用户");
				// 查询根据用户ID信息
				User updateUser = userServiceImpl.queryUser(user);
				// 添加之前带过来的信息
				updateUser.setMarkManage(user.getMarkManage());
				updateUser.setMarkUserfrom(user.getMarkUserfrom());
				updateUser.setPageInfo(user.getPageInfo());
				updateUser.setCondition(user.getCondition());
				mv.addObject("user", updateUser);
				mv.setViewName("/manager/userManage/commonUser");
			} else if (user.getGroupId() == 4 && user.getStudioStatus() == 1) {// 去编辑设计师:申请表
				System.out.println(" 去编辑设计师:申请表");
				DesignerApply designerUser = designerApplyService
						.queryDesigner(designerApply);
				mv.addObject("designerApply", designerUser);
				mv.addObject("user", user);
				mv.setViewName("/manager/userManage/designerUserApply");
			} else if (user.getGroupId() == 4 && user.getStudioStatus() != 1) {// 去编辑设计师:用户表
				System.out.println("去编辑设计师:用户表" + user.toString());
				// 查询根据用户ID信息
				User queryUser = userServiceImpl.queryUser(user);
				queryUser.setMarkManage(user.getMarkManage());
				queryUser.setMarkUserfrom(user.getMarkUserfrom());
				queryUser.setPageInfo(user.getPageInfo());
				queryUser.setCondition(user.getCondition());
				mv.addObject("user", queryUser);
				mv.setViewName("/manager/userManage/designerUser");
			}
		} else if (user.getMarkManage() == 3) {

			if (user.getGroupId() == 1) {// 去查看普通用户
				System.out.println("去查看普通用户" + user.toString());
				// 查询根据用户ID信息
				User queryUser = userServiceImpl.queryUser(user);
				queryUser.setMarkManage(user.getMarkManage());
				System.out.println("queryUser=" + queryUser.toString());
				queryUser.setMarkUserfrom(user.getMarkUserfrom());
				queryUser.setPageInfo(user.getPageInfo());
				queryUser.setCondition(user.getCondition());
				mv.addObject("user", queryUser);
				mv.setViewName("/manager/userManage/commonUser");
			} else if (user.getGroupId() == 4 && user.getStudioStatus() == 1) {// 去查看设计师:申请表
				System.out.println("去查看设计师:申请表");
				DesignerApply designerUser = designerApplyService
						.queryDesigner(designerApply);
				mv.addObject("designerApply", designerUser);
				mv.addObject("user", user);
				mv.setViewName("/manager/userManage/designerUserApply");
			} else if (user.getGroupId() == 4 && user.getStudioStatus() != 1) {// 去查看设计师:用户表
				System.out.println("去查看设计师:用户表" + user.toString());
				// 查询根据用户ID信息
				User queryUser = userServiceImpl.queryUser(user);
				queryUser.setMarkManage(user.getMarkManage());
				queryUser.setMarkUserfrom(user.getMarkUserfrom());
				queryUser.setPageInfo(user.getPageInfo());
				queryUser.setCondition(user.getCondition());
				mv.addObject("user", queryUser);
				mv.setViewName("/manager/userManage/designerUser");
			}
		}
		return mv;
	}

	/**
	 * 用户操作：添加、编辑
	 * 
	 * @param User
	 * @param DesignerApply
	 * @param HttpServletRequest
	 * @return ModelAndView
	 * @date 2015年11月12日
	 * @auther luans
	 */
	@RequestMapping("userManage")
	public ModelAndView userManage(User user, DesignerApply designerApply,
			HttpServletRequest request) {
		// 处理条件查询时条件乱码问题
		user = turnCode(user);
		ModelAndView mv = new ModelAndView();
		if (user.getMarkManage() == null) {// 解决自动导出excel自动跳转问题
			return mv;
		}
		if (user.getMarkManage() == 1) {
			if (user.getGroupId() == 1) {// 添加普通用户
				userServiceImpl.insertSelective(user);
			} else if (user.getGroupId() == 4) {// 添加设计师
				userServiceImpl.insert(user, designerApply);
			}
			System.out.println("添加完后的当前页：" + user.getPageInfo().getPageIndex());
			return queryList(user);
		} else if (user.getMarkManage() == 2) {

			System.out.println("结果：" + user.getOldImg() != null
					&& !"".equals(user.getOldImg()));
			System.out.println("getOldImg():" + user.getOldImg());
			// 删除修改之前的头像图片
			if (user.getOldImg() != null && !"".equals(user.getOldImg())) {
				String rootpath = request.getSession().getServletContext()
						.getRealPath(System.getProperty("file.separator"));
				File f = new File(rootpath + "upload\\uploadImg\\user\\"
						+ user.getOldImg());
				f.delete();
			}
			if (user.getGroupId() == 1) {// 修改普通用户
				System.out.println("修改普通用户");
				System.out.println("修改前的当前页："
						+ user.getPageInfo().getPageIndex());
				userServiceImpl.userUpdate(user);
				System.out.println("修改完后的当前页："
						+ user.getPageInfo().getPageIndex());
				return queryList(user);
			} else if (user.getGroupId() == 4 && user.getStudioStatus() == 1) {// 修改设计师:申请表
				System.out.println("修改设计师:申请表");

			} else if (user.getGroupId() == 4 && user.getStudioStatus() != 1) {// 修改设计师:用户表
				System.out.println(" 修改设计师:用户表：" + user.toString());
				userServiceImpl.userUpdate(user);
				// System.out.println("修改完后的当前页："+user.getPageInfo().getPageIndex());
				return queryList(user);
			}
		}

		return mv;
	}

	/**
	 * 用户管理：删除用户
	 * 
	 * @param User
	 * @return ModelAndView
	 * @date 2015年11月13日
	 * @auther luans
	 */
	@RequestMapping("userDel")
	public ModelAndView userDel(User user) {

		userServiceImpl.userDel(user);

		return queryList(user);
	}

	/**
	 * PC端前台：去往用户个人信息编辑页面
	 * 
	 * @param User
	 * @return ModelAndView
	 * @throws Exception
	 * @date 2015年12月25日
	 * @auther luans
	 */
	@RequestMapping("gotoUserManagePC")
	public ModelAndView gotoUserManagePC(HttpServletRequest request,
			HttpServletResponse response, User user) {
		System.out.println("编辑用户查询条件件信息：" + user.toString());
		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		System.out.println("useriduseriduserid:" + userid);
		if (userid == "" || userid == null) {
			try {
				response.sendRedirect(request.getContextPath()
						+ "/login/gotoIndexPC.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer uid = Integer.parseInt(userid);
		user.setUid(uid);
		ModelAndView mv = new ModelAndView();
		User userManage = userServiceImpl.queryUser(user);

		// 将商品类别放入Session，公共调用
		this.setCategorySession(request);

		mv.addObject("user", userManage);
		mv.setViewName("/pc/userManage/userManage");
		return mv;
	}

	/**
	 * PC端前台：修改用户个人信息
	 * 
	 * @param User
	 * @param HttpServletRequest
	 * @return Integer
	 * @throws Exception
	 * @date 2015年12月25日
	 * @auther luans
	 */
	@RequestMapping("updateUserManagePC")
	@ResponseBody
	public Integer updateUserManagePC(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 删除修改之前的头像图片
		if (user.getOldImg() != null && !"".equals(user.getOldImg())) {
			String rootpath = request.getSession().getServletContext()
					.getRealPath(System.getProperty("file.separator"));
			File f = new File(rootpath + "upload\\uploadImg\\user\\"
					+ user.getOldImg());
			f.delete();
		}
		System.out.println("修改用户信息：" + user.toString());
		int result = userServiceImpl.userUpdate(user);
		System.out.println("userid1111111111:" + user.getUid());
		System.out.println("修改后的结果：" + result);
		int shoppingCount = modelShoppingService.queryModelShoppingCount(user
				.getUid());
		user = userServiceImpl.queryUser(user);// 重新查询用户信息
		user.setShoppingCount(shoppingCount);
		user.setPwd("");
		// 清除session
		request.getSession().invalidate();
		// 重新添加session
		HttpSession session = request.getSession();
		session.setAttribute("yfhl_user", user);
		session.setAttribute("yfhl_userid", user.getUid() + "");// 将用户ID存入Session
		// 1.2清除cookie
		Cookie cookie = new Cookie("yfhlkj_user", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");// cookie有效路径是网站根目录
		response.addCookie(cookie); // 向客户端写入
		// 重新写入Cookie
		String value = this.setCookievalue(user);
		Cookie cookie2 = new Cookie("yfhlkj_user", value);
		cookie2.setMaxAge(60 * 60 * 24 * 1);// 设置Cookie的有效时间为1天
		cookie2.setPath("/");// cookie有效路径是网站根目录
		response.addCookie(cookie2); // 向客户端写入

		return result;
	}

	/**
	 * PC端前台：去往退换货页面
	 * 
	 * @param User
	 * @return ModelAndView
	 * @date 2016年1月13日
	 * @auther luans
	 */
	@RequestMapping("gotoGoodsBackPagePC")
	public ModelAndView gotoGoodsBackPagePC(HttpServletRequest request,
			User user) {
		ModelAndView mv = new ModelAndView();
		// 将商品类别放入Session，公共调用
		this.setCategorySession(request);

		mv.addObject("user", user);
		mv.setViewName("/pc/userManage/userGoodsBack");

		return mv;
	}

	/**
	 * PC端前台：去修改密码页面
	 * 
	 * @param User
	 * @return ModelAndView
	 * @date 2016年3月18日
	 * @auther luans
	 */
	@RequestMapping("gotochangePwdPC")
	public ModelAndView gotochangePwdPC(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// 将商品类别放入Session，公共调用
		this.setCategorySession(request);
		mv.setViewName("/pc/userManage/changePassword");
		return mv;
	}

	/**
	 * PC端前台：修改密码
	 * 
	 * @param User
	 * @return ModelAndView
	 * @date 2016年3月18日
	 * @auther luans
	 */
	@RequestMapping("changePwdPC")
	@ResponseBody
	public Integer changePwdPC(User user) {
		int result = 0;
		String pwdcode = RandomStringUtils.randomAlphanumeric(8);// 生成8位随机字符串
		String password = pwdcode + Md5Encrypt.md5(pwdcode + user.getPwd());
		user.setPwd(password);

		result = userServiceImpl.userUpdate(user);
		return result;
	}

	/**
	 * PC端前台：验证旧密码
	 * 
	 * @param User
	 * @return ModelAndView
	 * @date 2016年3月18日
	 * @auther luans
	 */
	@RequestMapping("checkoldPwdPC")
	@ResponseBody
	public Integer checkoldPwdPC(User user) {
		int result = 0;
		// 根据用户ID查询用户信息
		User users = userServiceImpl.queryUser(user);
		if (users == null) {
			return 0;
		}
		String str = users.getPwd();
		String strPwd = str.substring(8);// 后32位
		String pwdStr = str.substring(0, 8);// MD5后的密码前8位
		String pwdYuan = Md5Encrypt.md5(pwdStr + "" + user.getPwd());// 前8位随机数字+明文密码=MD5
		if (pwdYuan.equals(strPwd)) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	/**
	 * PC端前台：去设计师列表页
	 * 
	 * @return ModelAndView
	 * @date 2016年3月18日
	 * @auther luans
	 */
	@RequestMapping("gotoDesignerPC")
	public ModelAndView gotoDesignerPC(HttpServletRequest request, User user) {
		// 从Session中获取用户id
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int logonUserid = 0;
		if (userid != null && !"".equals(userid)) {
			logonUserid = Integer.parseInt(userid);
		}
		ModelAndView mv = new ModelAndView();
		user.setGroupId(4);
		user.getPageInfo().setPageSize(10);
		List<User> designerList = userServiceImpl.queryListByPage(user);
		designerList = this.designerListHandle(designerList, logonUserid);// 整理设计师信息
		// 将商品类别放入Session，公共调用
		this.setCategorySession(request);

		mv.addObject("designerList", designerList);
		mv.addObject("user", user);
		mv.setViewName("/pc/designer/designerList");
		return mv;
	}

	/**
	 * PC端前台：去设计师品牌详情页
	 * 
	 * @param 设计师Id
	 *            ,
	 * @return ModelAndView
	 * @date 2016年3月18日
	 * @auther luans
	 */
	@RequestMapping("gotoDesignerBrandPC")
	public ModelAndView gotoDesignerBrandPC(HttpServletRequest request,
			Model model, Integer id) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int logonUserid = 0;
		if (userid != null && !"".equals(userid)) {
			logonUserid = Integer.parseInt(userid);
		}
		User user = new User();
		user.setUid(id);
		user = userServiceImpl.queryUser(user);// 查询设计师信息
		// 查询已登录用户是否已经关注该设计师
		if (logonUserid != 0) {
			DesignerCollection dCollection = new DesignerCollection();
			dCollection.setDcDesignerid(user.getUid());
			dCollection.setDcUserid(logonUserid);
			if (designerCollectionService.queryCount(dCollection) > 0) {
				user.setDcId(designerCollectionService.queryId(dCollection));
			}
		}
		// 查询设计师品牌下的商品
		model.setDesignerBrand(user.getdBrand());
		List<Model> modelList = modelService.queryListByPage(model);
		modelList = this.modelListHandle(modelList, logonUserid);// 整理商品信息

		// 将商品类别放入Session，公共调用
		this.setCategorySession(request);

		mv.addObject("modelList", modelList);
		mv.addObject("designer", user);
		mv.addObject("model", model);
		mv.setViewName("/pc/designer/designerbrand");
		return mv;
	}

	/**
	 * 内部自定义方法：1.用户乱码转换
	 * 
	 * @param User
	 * @return User
	 * @date 2015年11月13日
	 * @auther luans
	 */
	public User turnCode(User user) {
		// 实例化编码工具类
		CodeUtil codeUtil = new CodeUtil();
		// 1.模糊查询条件乱码
		if (user.getCondition() != null && !"".equals(user.getCondition())
				&& codeUtil.isMessyCode(user.getCondition())) {
			try {
				String cname = new String(user.getCondition().getBytes(
						"ISO-8859-1"), "utf-8");
				user.setCondition(cname);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	public List<User> designerListHandle(List<User> designerList,
			Integer logonUserid) {
		if (logonUserid == null) {
			logonUserid = 0;
		}
		DesignerCollection dCollection = new DesignerCollection();
		List<Model> designerModel = new ArrayList<Model>();
		User designer = new User();
		for (int i = 0; i < designerList.size(); i++) {
			designer = designerList.get(i);
			// 1.根据设计师品牌查询设计师的商品
			designerModel = modelService
					.queryModelBybrand(designer.getdBrand());
			System.out.println("品牌：" + designer.getdBrand());
			designerModel = this.modelListHandle(designerModel, logonUserid);// 整理商品展示信息
			designerList.get(i).setDesignerList(designerModel);
			System.out.println("设计师商品数量：" + designerModel.size());
			// 2.查询用户收藏的设计师的id
			dCollection.setDcDesignerid(designer.getUid());
			dCollection.setDcUserid(logonUserid);
			if (designerCollectionService.queryCount(dCollection) > 0) {
				designerList.get(i).setDcId(
						designerCollectionService.queryId(dCollection));
			}
		}
		return designerList;
	}

	/**
	 * 自定义内部方法：3.整理商品列表展示信息
	 * 
	 * @param List
	 *            <Model>,Integer
	 * @return List<Model>
	 * @date 2016年3月18日
	 * @auther luans
	 */
	public List<Model> modelListHandle(List<Model> list, Integer uid) {
		if (uid == null) {
			uid = 0;
		}
		Model model = new Model();
		ModelCollection mCollection = new ModelCollection();
		mCollection.setMcUserid(uid);
		for (int i = 0; i < list.size(); i++) {
			// 显示第一张商品图片
			model = list.get(i);
			list.get(i).setImg(model.getImg().split(";")[0]);
			// 查询用户收藏商品的id
			mCollection.setMcModelid(model.getMid());
			mCollection.setMcDesignerid(model.getAuthor());
			if (modelCollectionService.queryCount(mCollection) > 0) {
				list.get(i)
						.setMcId(modelCollectionService.queryId(mCollection));
			}

		}
		// 处理设计师是否被收藏状态

		return list;
	}

	/**
	 * 用户自定义方法：4.加密写入Cookie的值
	 * 
	 * @param user
	 * @return String
	 * @throws Exception
	 * @date 2016年3月15日
	 * @auther luans
	 */
	@SuppressWarnings("static-access")
	public String setCookievalue(User user) throws Exception {

		EncryptUtil encryptUtil = new EncryptUtil();
		String value = Md5Encrypt.md5(user.getUid() + ";" + user.getPwd());// 用户ID和MD5加密后的密码的组合，然后在MD5加密
		value = encryptUtil.base64Encoder(user.getUid() + ";"
				+ user.getUsername() + ";" + user.getEmail() + ";"
				+ user.getShoppingCount() + ";" + user.getAvatar() + ";"
				+ user.getGroupId() + ";" + value);// 再组合，再用base64加密
		return value = URLEncoder.encode(value, "utf-8");
	}

	/**
	 * 自定义内部方法：5.设置公共商品类别Session值
	 * 
	 * @param Model
	 * @date 2016年3月30日
	 * @auther luans
	 */
	public void setCategorySession(HttpServletRequest request) {
		HttpSession sessions = request.getSession();
		// 查询商品类别
		List<Category> categoryList = categoryService.queryCategoryForIndex();
		sessions.setAttribute("categoryListForHander", categoryList);// 将商品类别放入Session，公共调用
	}
}
