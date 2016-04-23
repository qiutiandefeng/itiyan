package com.yfhl.controller;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Category;
import com.yfhl.entity.Model;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.User;
import com.yfhl.service.CacheService;
import com.yfhl.service.CategoryService;
import com.yfhl.service.ModelCollectionService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.TokenService;
import com.yfhl.service.UserService;
import com.yfhl.util.EncryptUtil;
import com.yfhl.util.Md5Encrypt;
import com.yfhl.util.Sign;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年3月4日 上午11:10:04
 * 
 *          微信商品类别
 * 
 */
@Controller
@RequestMapping("wxModelCategory")
public class WXModelCategoryController {

	@Resource
	private ModelTypeService modelTypeService;

	@Resource
	private ModelService modelService;

	@Resource
	private ModelCollectionService modelCollectionService;

	@Resource
	private ModelShoppingService modelShoppingService;

	@Resource
	private CategoryService categoryService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private CacheService cacheService;

	@Resource
	private TokenService tokenService;

	/**
	 * 进入商品分类页
	 * 
	 * @param category
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @throws Exception 
	 * @date 2016年3月5日
	 */
	@RequestMapping("wxlist")
	public ModelAndView categroyList(HttpServletRequest request,
			HttpServletResponse response, Category category) throws Exception {
		System.out.println("条件查询类别：" + category.getCondition());
		// 判断用户是否登录
//		HttpSession session = request.getSession();
//		String userid = (String) session.getAttribute("yfhl_userid");
//		Integer uid = 0;
//		System.out.println("useriduseriduserid:" + userid);
//		if (userid == "" || userid == null) {
			// 没有授权用户，获取用户信息
//			System.out.println("没有授权用户，获取用户信息");
			User user = getWxUser(request, response);
//			uid = user.getUid();
//		}else {
//			uid = Integer.parseInt(userid);
//		}
		
		ModelAndView mv = new ModelAndView();
		// 所有产品数量
		Integer modelAllCount = modelService.getModelAll().size();
		// 所有分类
		List<Category> categoryList = categoryService
				.getModelCategoryAll(category);
		// List<Integer> countList = new ArrayList<Integer>();
		// for (int i = 0; i < categoryList.size(); i++) {
		// // 根据每一个分类或者它们下面的商品数量
		// Integer modelCount = modelService.getModelCategoryList(
		// categoryList.get(i).getCategoryId()).size();
		// countList.add(modelCount);
		// }
		// mv.addObject("countList", countList);
		mv.addObject("categoryList", categoryList);
		mv.addObject("categorys", category);
		mv.addObject("modelAllCount", modelAllCount);
		mv.setViewName("/wx/goodsManage/modelCategoryList_wx");
		return mv;
	}

	/**
	 * 单类型商品展示
	 * 
	 * @param category
	 * @param model
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @throws Exception 
	 * @date 2016年3月5日
	 */
	@RequestMapping("wxMClist")
	public ModelAndView modelCategroyList(Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 判断用户是否登录
//		HttpSession session = request.getSession();
//		String userid = (String) session.getAttribute("yfhl_userid");
//		Integer uid = 0;
//		System.out.println("useriduseriduserid:" + userid);
//		if (userid == "" || userid == null) {
			// 没有授权用户，获取用户信息
//			System.out.println("没有授权用户，获取用户信息");
		User user = getWxUser(request, response);
//			uid = user.getUid();
//		}else {
//			uid = Integer.parseInt(userid);
//		}
		
		ModelAndView mv = new ModelAndView();
		// 1.获取显示的商品List
		if (model.getCondition_categoryid() != 0) {
			model.setMarkCategory(2);// 根据子节点类别查询
		}
		model.getPageInfo().setPageSize(10);
		List<Model> modelList = modelService.queryListByPage(model);
		// 2.整理列表展示信息
		modelList = this.modelListHandle(modelList, user.getUid());
		// 3.获取商品类别信息
		Category category = categoryService.queryCategoryById(model
				.getCondition_categoryid());

		mv.addObject("modelList", modelList);
		mv.addObject("category", category);
		mv.setViewName("/wx/goodsManage/modelCategory_wx");
		return mv;
	}
	

	public User getWxUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String ticket = null;
		String acessToken = null;
		String openid = null;
		String refreshToken = null;
		String code = (String) request.getParameter("code");
		String state = (String) request.getParameter("state");
		User user = new User();
		User u = new User();
		int falgUserinsert = 0;
		/**
		 * 点击分享链接进入的
		 */
		if (code != null) {
			openid = (String) session.getAttribute("openid");
			if (openid == null)
			{
				openid = tokenService.getAccessTokenByCode(code);
				acessToken = tokenService.getAcessToken();
				refreshToken = tokenService.getRefreshToken();
				/**
				 * 验证accessToken是否过期 正确的Json返回结果：{ "errcode":0,"errmsg":"ok"} true
				 * 是无过期 false是过期
				 */
				if (!tokenService.isAccessToken(acessToken, openid)) {
					/**
					 * 刷新获取的openid
					 */
					openid = tokenService.getRefreshToken(refreshToken);
					acessToken = tokenService.getAcessToken();
	
				}
				/**
				 * 微信授权后得到用户信息
				 */
				user = tokenService.getWeixinUser(acessToken, openid);
				u =  userService.getUserByopenId(openid);
				if ( u == null)
				{
					userService.insertSelective(user);
					u.setUid(user.getUid());
				}
			} else {
				String userid = (String) session.getAttribute("yfhl_userid");
				openid = (String) session.getAttribute("openid");
				u.setUid(Integer.valueOf(userid));
				u.setWxOpenid(openid);
				System.out.println("useriduseriduserid:" + userid);
				if (!"".equals(u.getUid()) && u.getUid() != null) {
					u = userService.getUserByUid(u.getUid());
				}
			}
		}else {
			String userid = (String) session.getAttribute("yfhl_userid");
			openid = (String) session.getAttribute("openid");
			u.setUid(Integer.valueOf(userid));
			u.setWxOpenid(openid);
			System.out.println("useriduseriduserid:" + userid);
			if (!"".equals(u.getUid()) && u.getUid() != null) {
				u = userService.getUserByUid(u.getUid());
			}
		}

		// str = "redirect:/api/v1/campusambassador/users/resume";
		/***
		 * ticket appId 微信公众号的唯一标识 timestamp 微信生成签名的时间戳 nonceStr 微信生成签名的随机串
		 * signature 微信签名 jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VBdGdp
		 * -6Yp7aZYtIvNi0SvD_L6GCAZs_edqKvR6okCAUYAfu8_m9gNa-qj-Fux8Haw&noncestr
		 * =JBOPCYOSTPWX&timestamp=1428746372607
		 * &url=http://192.168.1.110:8080/ishareme/campusambassador/users/resume
		 * ?uid=29070efe-7059-4c12-8279-7986030f8d81
		 * 
		 * @return
		 */

		/**
		 * @author home
		 * @param 1、先查看是否存在缓存 exist 是：true / 否：false
		 * @param （1）2、true——>查看缓存是否过期 isExpired 是：true / 否：false
		 * @param （2） true——>过期的话、刷新缓存、并设置缓存时间(单位：毫秒)：void refresh(String key, T
		 *        target); void setExpired(Long millsec);
		 * @param （3）false——>没有过期获取现有的缓存：T getCache(String key);
		 * @param （1）3、false——>没有存在缓存、刷新缓存、并设置缓存时间(单位：毫秒)：void refresh(String
		 *        key, T target); void setExpired(Long millsec);
		 */
		Boolean exist = cacheService.exist("ticket");
		if (exist) {
			Boolean isExpired = cacheService.isExpired("ticket");
			if (isExpired) {
				ticket = this.tokenService.getTicketWeixin();
				cacheService.refresh("ticket", ticket);
				cacheService.setExpired(Long.valueOf(7200000));
			} else {
				ticket = (String) cacheService.getCache("ticket");
			}
		} else {
			ticket = this.tokenService.getTicketWeixin();
			cacheService.refresh("ticket", ticket);
			cacheService.setExpired(Long.valueOf(7200000));
		}
		String url = null;
		url = request.getScheme() + "://"; // 请求协议 http 或 https
		url += request.getHeader("host"); // 请求服务器
		url += request.getRequestURI(); // 工程名
		if (request.getQueryString() != null) // 判断请求参数是否为空
			url += "?" + request.getQueryString(); // 参数

		Map<String, String> ret = Sign.sign(ticket, url);
		for (Map.Entry entry : ret.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
			// 微信公众号分享的需要的信息
			request.setAttribute((String) entry.getKey(), entry.getValue());
		}
		request.setAttribute("appId", this.tokenService.getAppIdWeixin());
		request.setAttribute("openid", u.getWxOpenid());
		System.out.println(u.getWxOpenid() + "----------------------");
		//加入Session/Cookies
		changeCookieSession(request,response,u.getUid(),u.getWxOpenid());
		return u;
	}

	/**
	 * 用户自定义方法：3.修改购物车信息后，修改Session和cookie中的值
	 * 
	 * @param userid
	 * @return String
	 * @throws Exception
	 * @date 2016年3月27日
	 * @auther luans
	 */
	public void changeCookieSession(HttpServletRequest request,
			HttpServletResponse response, Integer uid,String openid) throws Exception {
		User user = new User();
		user.setUid(uid);
		int shoppingCount = modelShoppingService.queryModelShoppingCount(uid);
		System.out.println(shoppingCount + "----------------------" + uid);
		user = userService.queryUser(user);// 重新查询用户信息
		user.setShoppingCount(shoppingCount);
		user.setPwd("");
		// 清除session
		request.getSession().invalidate();
		// 重新添加session
		HttpSession session2 = request.getSession();
		session2.setAttribute("yfhl_user", user);
		session2.setAttribute("openid", openid);
		session2.setAttribute("yfhl_userid", user.getUid() + "");// 将用户ID存入Session
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

	/**
	 * 自定义内部方法：1.整理商品列表展示信息
	 * 
	 * @param List
	 *            <Model>,Integer
	 * @return List<Model>
	 * @date 2016年3月20日
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

}
