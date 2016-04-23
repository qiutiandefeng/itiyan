package com.yfhl.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.ActiveAccount;
import com.yfhl.entity.User;
import com.yfhl.service.ActiveAccountService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.TradeService;
import com.yfhl.service.UserService;
import com.yfhl.util.CustomDateUtil;
import com.yfhl.util.EncryptUtil;
import com.yfhl.util.Md5Encrypt;
import com.yfhl.util.mail.MailUtil;
import com.yfhl.util.mail.MimeMessageDTO;

/**
 * 用户登录Controller
 * 
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private HttpServletRequest request;

	@Resource
	private UserService userService;// 用户

	@Resource
	private ModelService modelService;// 商品

	@Resource
	private TradeService tradeService;// 订单

	@Resource
	private ActiveAccountService activeAccountService;// 注入注册激活码Service层实例
	@Resource
	public ModelShoppingService modelShoppingService;// 注入购物车Service层实例

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	/**
	 * 
	 * @Description 跳往后台登录页面，初始化登陆角色
	 * @return ModelAndView
	 */
	@RequestMapping("/beforeLogin")
	public ModelAndView index(HttpServletResponse response) {
		System.out.println("跳转到登陆界面~~");
		ModelAndView mv = new ModelAndView();
		// List<SysRoles> list = roleService.QueryAllRole();
		// mv.addObject("list", list);
		mv.setViewName("manager/login");
		return mv;
	}

	/**
	 * PC端：跳转到登录注册页面
	 * 
	 * @return Model
	 * @date 2016年3月5日
	 * @auther luans
	 */
	@RequestMapping("gotoIndexPC")
	public ModelAndView gotoIndexPC() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("pc/login");
		return mv;
	}

	/**
	 * PC端：登录注册页
	 * 
	 * @param HttpServletRequest
	 * @param User
	 * @return Model
	 * @throws Exception
	 * @date 2016年3月6日
	 * @auther luans
	 */
	@RequestMapping("loginDesignPC")
	@ResponseBody
	public Map<Object, Object> loginDesignPC(HttpServletRequest requst,
			HttpServletResponse response, User user) throws Exception {
		String username = request.getParameter("yfhl_username");
		String password = request.getParameter("yfhl_password");
		int type = Integer.parseInt(request.getParameter("yfhl_type"));
		System.out.println("username:" + username + " password:" + password);
		Map<Object, Object> map = new HashMap<Object, Object>();
		HttpSession session = request.getSession();
		User sel_user = new User();
		User sessionUser = new User();
		String value = "";
		if (type == 1) {// 登录
			System.out.println("登录");
			int remember_pwd = Integer.parseInt(request
					.getParameter("remember_pwd"));
			System.out.println("remember_pwd:" + remember_pwd);
			sel_user = this.queryUserByname(username);
			if (sel_user == null) {
				map.put("state", 0);
				map.put("value", "用户名不存在");
				map.put("type", 1);
			} else {
				boolean pass = pwdByName(username, password);
				if (pass) {// 验证通过
					map.put("state", 1);
					map.put("value", "验证通过，登录成功");
					// 统计用户购物车中商品数量
					int shoppingCount = modelShoppingService
							.queryModelShoppingCount(sel_user.getUid());
					System.out.println("购物车中数量：" + shoppingCount);
					sessionUser.setShoppingCount(shoppingCount);
					sessionUser.setAvatar(sel_user.getAvatar());
					sessionUser.setUsername(sel_user.getdUsername());
					sessionUser.setEmail(sel_user.getEmail());
					sessionUser.setUid(sel_user.getUid());
					System.out.println("放入sessiion中的user值："
							+ sessionUser.toString());
					sel_user.setShoppingCount(shoppingCount);
					session.setAttribute("yfhl_user", sessionUser);
					session.setAttribute("yfhl_userid", sel_user.getUid()+"");// 将用户ID存入Session

					// 写入Cookie
					value = this.setCookievalue(sel_user);
					Cookie cookie = new Cookie("yfhlkj_user", value);
					if (remember_pwd == 1) {// 记住密码
						cookie.setMaxAge(60 * 60 * 24 * 7);// 设置Cookie的有效时间为7天
					} else {// 不记住密码
						cookie.setMaxAge(60 * 60 * 24 * 1);// 设置Cookie的有效时间为7天
					}
					cookie.setPath("/");// cookie有效路径是网站根目录
					response.addCookie(cookie); // 向客户端写入
				} else {
					map.put("state", 0);
					map.put("value", "密码不正确");
					map.put("type", 2);
					// session.setAttribute("yfhl_password", "");
				}

			}
		} else if (type == 2) {// 注册
			System.out.println("注册");
			String pwdcode = RandomStringUtils.randomAlphanumeric(8);// 生成8位随机字符串
			String code = RandomStringUtils.randomAlphanumeric(10);// 生成10位随机字符串

			String marker_jsp = (String) session.getAttribute("marker_jsp");
			// 邮箱注册
			map = registerUserByEmail(username, password, pwdcode, code,
					marker_jsp);
			// 手机号注册

		}

		return map;
	}

	/**
	 * PC端：邮箱注册激活
	 * 
	 * @param HttpServletRequest
	 * @param ModelAndView
	 * @return ModelAndView
	 * @date 2016年3月7日
	 * @auther luans
	 */
	@RequestMapping("activeAccount")
	public ModelAndView activeAccount(HttpServletRequest request,
			ActiveAccount avtiveAccount) {
		System.out.println("激活验证：" + avtiveAccount.toString());
		ModelAndView mv = new ModelAndView();
		ActiveAccount queryModel = activeAccountService
				.queryActiveAccountByself(avtiveAccount);
		int result = 0;
		if (queryModel == null) {
			// 激活失败
			mv.setViewName("pc/error/error_activeAccount");
		} else {
			// 删除激活成功的数据
			result = activeAccountService.deleteActiveAccount(queryModel);
			User user = new User();
			user.setEmail(queryModel.getAaName());
			user.setPwd(queryModel.getAaPwd());
			user.setUsername("yfhl_" + queryModel.getAaName());
			result = userService.insertSelective(user);

		}
		if (result == 1) {// 激活成功
			if (queryModel.getAaUrl() == null
					|| "".equals(queryModel.getAaUrl())) {
				mv.addObject("urlPath",
						"http://javali.cn/modelController/gotoModelPC.do");
			} else {

				mv.addObject("urlPath", queryModel.getAaUrl());
			}
			HttpSession session = request.getSession();
			session.setAttribute("yfhl_username", queryModel.getAaName());
			mv.setViewName("pc/success/success_activeAccount");
		} else {// 激活失败
			mv.setViewName("pc/error/error_activeAccount");
		}
		return mv;
	}

	/**
	 * PC端：退出登录
	 * 
	 * @return ModelAndView
	 * @throws IOException
	 * @date 2016年3月17日
	 * @auther luans
	 */
	@RequestMapping("loginOutPC")
	public void loginOutPC(HttpServletResponse response) throws IOException {
		// 1.1清除session
		request.getSession().invalidate();
		// 1.2清除cookie
		Cookie cookie = new Cookie("yfhlkj_user", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");// cookie有效路径是网站根目录
		response.addCookie(cookie); //向客户端写入
		response.sendRedirect(request.getContextPath()+ "/modelController/gotoModelPC.do");

	}

	/**
	 * PC端：找回邮箱密码1:跳转到邮箱找回密码页
	 * 
	 * @return ModelAndView
	 * @date 2016年3月8日
	 * @auther luans
	 */
	@RequestMapping("gotobackPwd")
	public ModelAndView gotobackPwd() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pc/login/backpwd1");
		return mv;
	}

	/**
	 * PC端：找回邮箱密码2.1:发送链接到指定邮箱
	 * 
	 * @param emailCount
	 *            ：邮箱
	 * @return ModelAndView
	 * @date 2016年3月8日
	 * @auther luans
	 */
	@RequestMapping("backPwd")
	public ModelAndView backPwd(String emailCount) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emailCount", emailCount);
		User user = userService.getPwdByName(emailCount);
		String code = RandomStringUtils.randomAlphanumeric(10);// 生成10位随机字符串
		ActiveAccount aa = new ActiveAccount();// 注册码表
		aa.setAaName(emailCount);//找回密码的邮箱
		aa.setAaActivecode(code);//激活码
		aa.setAaDate(new Date());//添加时间
		activeAccountService.insertSelective(aa);
		System.out.println("刚刚的激活码ID:" + aa.getAaId());
		// 设置邮件内容
		String urlPath = "http://javali.cn/login/gotoResetPwd.do?uid="
				+ user.getUid()+"&aaId="+aa.getAaId()+"&aaActivecode="+aa.getAaActivecode();
		MimeMessageDTO mimeDTO = new MimeMessageDTO();
		String url = "还差一点点就能找回密码了，赶快点击链接，重置密码吧！" + urlPath;
		mimeDTO.setSentDate(new Date());
		mimeDTO.setSubject("爱体验网邮箱账号找回密码邮件");
		mimeDTO.setText(url);

		// 设置相关参数
		String name = "yfhl_3dcreatia@163.com";// 发件人邮箱
		String pwd = "yfhl3Dcreatia";// 发件人邮箱密码
		String targetAddress = emailCount;// 收件人邮箱

		// 发送邮件
		if (MailUtil.sendEmail(name, pwd, targetAddress, mimeDTO)) {
			System.out.println("邮件发送成功！");
			mv.setViewName("pc/login/backpwd2");
		} else {
			System.out.println("邮件发送失败!!!");
			mv.setViewName("pc/error/error_backpwd");
		}

		return mv;
	}

	/**
	 * PC端：找回邮箱密码2.2:通过邮箱链接跳转到重置密码页面
	 * 
	 * @param HttpServletRequest
	 * @param ModelAndView
	 * @return ModelAndView
	 * @date 2016年3月8日
	 * @auther luans
	 */
	@RequestMapping("gotoResetPwd")
	public ModelAndView gotoResetPwd(String uid,ActiveAccount aa) {
		ModelAndView mv = new ModelAndView();
		ActiveAccount queryModel = activeAccountService.queryActiveAccountByself(aa);
		if (queryModel == null) {
			// 激活失败:链接失效
			mv.setViewName("pc/error/error_activeAccount");
		} else {
			// 删除激活成功的数据
			activeAccountService.deleteActiveAccount(queryModel);
			mv.addObject("uid", uid);
			mv.setViewName("pc/login/backpwd3");
		}
		return mv;
	}

	/**
	 * PC端：找回邮箱密码3:重置密码
	 * 
	 * @param HttpServletRequest
	 * @param ModelAndView
	 * @return ModelAndView
	 * @date 2016年3月8日
	 * @auther luans
	 */
	@RequestMapping("resetPwd")
	public ModelAndView resetPwd(Integer uid, String pwd) {
		ModelAndView mv = new ModelAndView();
		String pwdcode = RandomStringUtils.randomAlphanumeric(8);// 生成8位随机字符串
		String password = pwdcode + Md5Encrypt.md5(pwdcode + pwd);
		User user = new User();
		user.setUid(uid);
		user.setPwd(password);
		int result = userService.userUpdate(user);
		if (result == 0) {
			mv.setViewName("pc/error/error_backpwd");
		} else {

			user = userService.queryUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("yfhl_username", user.getEmail());
			mv.addObject("uid", user.getEmail());
			mv.setViewName("pc/login/backpwd4");
		}
		return mv;
	}

	/**
	 * PC端：去邮件发送成功页面
	 * 
	 * @param emailCount
	 *            :邮箱账户
	 * @return ModelAndView
	 * @date 2016年3月8日
	 * @auther luans
	 */
	@RequestMapping("gotoEmailCount")
	public ModelAndView gotoEmailCount(String emailCount) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emailCount", emailCount);
		mv.setViewName("pc/success/success_sendEmail");
		return mv;
	}

	 

	/**
	 * @Description 判断登录信息获取用户登录路径
	 * @throws Exception
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/login")
	public String login(User user, HttpServletResponse response)
			throws Exception {
		String URLStr = null;
		// 防止直接通过url访问
		if (user.getGroupId() != null) {
			request.setAttribute("groupId", user.getGroupId());
		} else {
			return "manager/login";
		}
		HttpSession session = request.getSession();
		// //从session中获取验证码
		String v_code = (String) session.getAttribute("validateCode");
		// //从请求中拿到前台提交的验证码
		String valiCode = request.getParameter("validateCode");
		if (!v_code.equalsIgnoreCase(valiCode.trim())) {
			return "manager/login";
		}
		// 判断系统参数中是否存在此序列号
		boolean jiaoyan = pwdByName(user.getUsername(), user.getPwd());
		if (jiaoyan) {

			// 获取管理员登录的信息
			User updateUser = userService.getPwdByName(user.getUsername());
			if (updateUser != null) {
				// 获取系统管理员登录跳转路径
				String loginRedirect = "index";
				updateUser.setRegTime(new Date());
				updateUser.setShoppingCount(modelShoppingService.queryModelShoppingCount(updateUser.getUid()));
				session.setAttribute("yfhl_kj_user", updateUser);
				System.out.println("后台加密前的用户信息" + updateUser.toString());
				String value = this.setCookievalue(updateUser);
				System.out.println("后台加密后的cookie值" + value);
				Cookie cookie1 = new Cookie("yfhlkj_user", value);
				cookie1.setMaxAge(60 * 60 * 24 * 1);// 设置Cookie的有效时间为1天
				cookie1.setPath("/");// cookie有效路径是网站根目录
				response.addCookie(cookie1); // 向客户端写入
				 
				
				String logDescription = "登录了该系统";
				URLStr = "redirect:/login/index.do?loginRedirect="
						+ loginRedirect;
			}
		} else {
			request.setAttribute("msg", "角色名称或密码错误");
			URLStr = "manager/login";
		}
		return URLStr;
	}

	/**
	 * 管理员退出登录，需要消除session
	 * 
	 * @author
	 * 
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse response) {
		// 1.1清除session
		request.getSession().invalidate();
		// 1.2清除cookie
		Cookie cookie = new Cookie("yfhlkj_user", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");// cookie有效路径是网站根目录
		response.addCookie(cookie); // 向客户端写入
		// 2.跳转到登录界面
		return "manager/login";
	}

	/**
	 * @跳转到主界面
	 * @param loginRedirect
	 * @return
	 */
	@RequestMapping("/index")
	public String redirect(String loginRedirect) {

		return "manager/" + loginRedirect;
	}

	/**
	 * @Description 跳转到修改密码界面
	 * @return String
	 */
	@RequestMapping("/update")
	public String updateUserInfoUI() {
		return "/user/UpdateUserInfo";
	}

	/**
	 * @Description 修改管理员密码
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/updateuserInfo")
	public String updateuserInfo(User user, BindingResult bindresult,
			HttpServletResponse response) throws Exception {
		user.setRegTime(new Date());
		int i = userService.updateLoginState(user);
		if (i > 0) {
			// 将管理员的登录状态置为0(可登陆)
			// loginService.updateLoginState(String.valueOf(sysuser.getUserId()),
			// 0);
			// 操作日志描述
			String logDescription = "修改了密码";

			request.getSession().invalidate();// 清除session

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter()
					.write("<script>window.parent.location.href='"
							+ "/examSystem/login/beforeLogin.do"
							+ "';"
							+ "window.onload=function(){alert('修改密码成功,请重新登录')}</script>");
		} else {
			request.setAttribute("msg", "修改密码失败");
			return "/user/UpdateUserInfo";
		}
		return null;
	}

	/**
	 * 进入欢迎界面
	 * 
	 */
	@RequestMapping("/towelcome")
	public ModelAndView toWelcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping("/xinxi")
	public String xinxi() {

		Map<Object, Object> objMap = new HashMap<Object, Object>();
		Properties props = System.getProperties(); // 系统属性
		/**
		 * 获取数据源 (1)用户 全部/一周的动态 (2)商品 全部/一周的动态 (3)设计师 全部/一周的动态
		 */
		// 获取当前时间的这一周集合——>第0个：周一
		List<Date> days = CustomDateUtil.dateToWeek(new Date());
		int countUserAll = userService.getCountUserByTime(null, null, "");
		int countUser = userService.getCountUserByTime(
				CustomDateUtil.sdf.format(days.get(0)),
				CustomDateUtil.sdf.format(new Date()), "1");

		// 商品
		int countModelAll = modelService.getCountModelByTime(null, null);
		int countModel = modelService.getCountModelByTime(
				CustomDateUtil.sdf.format(days.get(0)),
				CustomDateUtil.sdf.format(new Date()));

		// 订单
		int countTradeAll = tradeService.getCountTradeByTime(null, null);
		int countTrade = tradeService.getCountTradeByTime(
				CustomDateUtil.sdf.format(days.get(0)),
				CustomDateUtil.sdf.format(new Date()));

		// 设计师
		int countDesignerUserAll = userService.getCountDesignerUserByTime(null,
				null, "");
		int countDesignerUser = userService.getCountDesignerUserByTime(
				CustomDateUtil.sdf.format(days.get(0)),
				CustomDateUtil.sdf.format(new Date()), "");
		objMap.put("countUserAll", countUserAll);
		objMap.put("countUser", countUser);
		objMap.put("countModelAll", countModelAll);
		objMap.put("countModel", countModel);
		objMap.put("countTradeAll", countTradeAll);
		objMap.put("countTrade", countTrade);
		objMap.put("countDesignerUserAll", countDesignerUserAll);
		objMap.put("countDesignerUser", countDesignerUser);
		// 系统信息
		objMap.put("JAVA_VERSION", props.getProperty("java.version"));
		objMap.put("OS_NAME", props.getProperty("os.name"));
		objMap.put("mysqlProductName", "Mysql 5.6");// 数据库的产品名称

		request.setAttribute("objMap", objMap);

		return "manager/shou";
	}

	/**
	 * 封装的校验用户名密码
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return false,true
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月19日
	 */
	public Boolean pwdByName(String name, String pwd) {
		boolean flag = false;

		User user = userService.getPwdByName(name);
		if (user == null) {
			return flag;
		}
		String str = user.getPwd();
		String strPwd = str.substring(8);// 后32位
		String pwdStr = str.substring(0, 8);// MD5后的密码前8位
		String pwdYuan = Md5Encrypt.md5(pwdStr + "" + pwd);// 前8位随机数字+明文密码=MD5
		if (pwdYuan.equals(strPwd)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 通过登录时用户名查询用户信息
	 * 
	 * @param User
	 * @return User
	 * @date 2016年3月6日
	 * @auther luans
	 */
	public User queryUserByname(String name) {
		return userService.getPwdByName(name);
	}

	/**
	 * 验证注册的用户手机号/邮箱是否重复
	 * 
	 * @param HttpServletRequest
	 * @return Map
	 * @date 2016年3月6日
	 * @auther luans
	 */
	@RequestMapping("checkSameName")
	@ResponseBody
	public Map<Object, Object> checkSameName(HttpServletRequest requst) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String username = request.getParameter("yfhl_username");
		int result = userService.checkSameName(username);
		map.put("state", result);
		return map;
	}

	/**
	 * 用户自定义方法：1.邮箱注册
	 * 
	 * @param username
	 *            :注册邮箱
	 * @param password
	 *            :密码
	 * @param pwd
	 *            :8位密码随机数
	 * @param code
	 *            :10位激活码随机数
	 * @return Map
	 * @date 2016年3月7日
	 * @auther luans
	 */
	public Map<Object, Object> registerUserByEmail(String username,
			String password, String pwdcode, String code, String marker_jsp) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		ActiveAccount aa = new ActiveAccount();// 注册码表
		aa.setAaName(username);
		aa.setAaActivecode(code);
		aa.setAaUrl(marker_jsp);
		String pwdfinal = pwdcode + Md5Encrypt.md5(pwdcode + password);
		aa.setAaPwd(pwdfinal);
		aa.setAaDate(new Date());
		activeAccountService.insertSelective(aa);
		System.out.println("刚刚的激活码ID:" + aa.getAaId());
		//设置邮件内容
		String urlPath = "http://javali.cn/login/activeAccount.do?aaId="
				+ aa.getAaId() + "&aaActivecode=" + code;
		MimeMessageDTO mimeDTO = new MimeMessageDTO();
		String url = "欢迎您注册爱体验网账号，快快点击链接，完成最后的注册验证吧！" + urlPath;
		mimeDTO.setSentDate(new Date());
		mimeDTO.setSubject("爱体验账号注册激链接邮件");
		mimeDTO.setText(url);

		// 设置相关参数
		String name = "yfhl_3dcreatia@163.com";// 发件人邮箱
		String pwd = "yfhl3Dcreatia";// 发件人邮箱密码
		String targetAddress = username;// 收件人邮箱

		// 发送邮件
		if (MailUtil.sendEmail(name, pwd, targetAddress, mimeDTO)) {
			System.out.println("邮件发送成功！");
			map.put("state", 1);
			map.put("value", "注册邮箱发送成功，请到注册邮箱内点击链接完成注册验证！");
			map.put("email", username);
		} else {
			System.out.println("邮件发送失败!!!");
			map.put("state", 0);
			map.put("value", "邮箱注册失败");
		}
		return map;
	}

	/**
	 * 用户自定义方法：2.加密写入Cookie的值
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
}
