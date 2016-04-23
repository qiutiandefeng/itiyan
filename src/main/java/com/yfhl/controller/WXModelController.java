package com.yfhl.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
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

import com.yfhl.entity.Banner;
import com.yfhl.entity.Comment;
import com.yfhl.entity.Model;
import com.yfhl.entity.ModelCollection;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.User;
import com.yfhl.service.BannerService;
import com.yfhl.service.CacheService;
import com.yfhl.service.CommentService;
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
 * @version 创建时间：2016年3月4日 下午6:19:36 类说明
 */

@Controller
@RequestMapping("wxModel")
public class WXModelController {

	@Resource
	private ModelService modelService;

	@Resource
	private CommentService commentService;

	@Resource
	private ModelShoppingService modelShoppingService;

	@Resource
	public ModelTypeService modelTypeService;// 注入商品类别Service层实例对象

	@Resource
	public ModelCollectionService modelCollectionService;// 注入商品收藏Service层实例对象

	@Resource
	public BannerService bannerService;// 注入bannerService层实例

	
	@Resource
	private UserService userService;
	
	@Resource
	private TokenService tokenService;
	
	@Resource
	private CacheService cacheService;
	/**
	 * 商品详情页面
	 * 
	 * @param model
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @throws Exception 
	 * @date 2016年3月5日
	 */
	@RequestMapping("wxmodelDetails")
	public ModelAndView wxmodelDetails(Model model, User user,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 判断用户是否登录
//		HttpSession session = request.getSession();
//		String userid = (String) session.getAttribute("yfhl_userid");
//		Integer uid = 0;
//		System.out.println("useriduseriduserid:" + userid);
//		if (userid == "" || userid == null) {
//			// 没有授权用户，获取用户信息
//			System.out.println("没有授权用户，获取用户信息");
			user = getWxUser(request, response);
//			Integer uid = user.getUid();
//		}else {
//			uid = Integer.parseInt(userid);
//		}

		ModelAndView mv = new ModelAndView();
		// 1.单商品详细信息
		Model models = modelService.queryModel(model);
		// 2.整理商品详细信息
		models = this.modelHandle(models);
		// 3.查询商品评论信息
		Comment comment = new Comment();
		comment.setMid(model.getMid());
		comment.getPageInfo().setPageSize(2);
		List<Comment> commentList = commentService.queryListByPage(comment);
		// 4.商品的规格：金、银、尺寸、、、
		models = this.modelTypeHandel(models);
		// 5.1.获取爱体验推荐商品
		model.setStartIndex(0);
		model.setEndIndex(9);
		List<Model> modelRecommendList = modelService.queryRecommend(model);
		// 5.2.整理推荐商品信息
		this.modelListHandle(modelRecommendList, model.getUid());
		// 6.每个用户的购物车商品数量
		// Integer modelCatCount =
		// modelShoppingService.getModelShoppingCount(user.getUid());

		mv.addObject("user", user);
		mv.addObject("model", models);
		mv.addObject("commentList", commentList);
		// mv.addObject("modelCatCount", modelCatCount);
		mv.addObject("modelRecommendList", modelRecommendList);

		mv.setViewName("/wx/goodsManage/modelDetails_wx");
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
		}else{//不是分享链接进入、是从内部链接进入
//			HttpSession session = request.getSession();
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
		session2.setAttribute("yfhl_userid", user.getUid() + "");// 将用户ID存入Session
		if (openid != null)
		{
			session2.setAttribute("openid", openid);// 将用户ID存入Session
		}
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
	 * 微信端首页
	 * 
	 * @param Model
	 * @return ModelAndView
	 * @throws Exception 
	 * @date 2016年3月21日
	 * @auther luans
	 */
	@RequestMapping("wxgotoModelIndex")
	public ModelAndView wxgotoModelIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		// 判断用户是否登录
		
		// 没有授权用户，获取用户信息
//		System.out.println("没有授权用户，获取用户信息");
		User user = getWxUser(request, response);
		Integer uid = user.getUid();
		
		
		Model model = new Model();
		model.setEndIndex(12);

		// 1.1第一个主题的商品：1-12
		model.setStartIndex(0);
		List<Model> modelList1 = modelService.queryModelforRecommend(model);
//		// 1.2整理列表展示信息
//		modelList1 = this.modelListHandle(modelList1, 0);
//		// 2.第二个主题的商品：13-24
//		model.setStartIndex(13);
//		List<Model> modelList2 = modelService.queryModelforRecommend(model);
//		modelList2 = this.modelListHandle(modelList2, 0);
//		// 3.第三个主题的商品：25-36
//		model.setStartIndex(25);
//		List<Model> modelList3 = modelService.queryModelforRecommend(model);
//		modelList3 = this.modelListHandle(modelList3, 0);

		// 4.banner信息
		List<Banner> bannerList = bannerService.queryBannerforWX();

		mv.addObject("modelList1", modelList1);
//		mv.addObject("modelList2", modelList2);
//		mv.addObject("modelList3", modelList3);
		mv.addObject("bannerList", bannerList);
		mv.setViewName("/wx/index_wx");
		return mv;
	}

	/**
	 * 内部自定义方法：1.整合商品详细信息
	 * 
	 * @param Model
	 * @return Model
	 * @date 2016年3月20日
	 * @auther luans
	 */
	public Model modelHandle(Model mo) {
		// 1.将商品图片转化成List集合形式
		if (mo.getImg() != null && !"".equals(mo.getImg())) {
			System.out.println("mo.getImg()=" + mo.getImg());
			String[] imgArray = mo.getImg().split(";");
			System.out.println("imgArray.length=" + imgArray.length);
			List<String> imglist = new ArrayList<String>();
			for (int i = 0; i < imgArray.length; i++) {
				imglist.add(imgArray[i]);
			}
			mo.setImgList(imglist);
		}
		// 2.将商品标签转化成List集合形式
		if (mo.getModTag() != null && !"".equals(mo.getModTag())) {
			System.out.println("mo.getModTag()=" + mo.getModTag());
			String[] tagArray = mo.getModTag().split(";");
			System.out.println("标签个数：" + tagArray.length);
			List<String> tagList = new ArrayList<String>();
			for (int j = 0; j < tagArray.length; j++) {

				tagList.add(tagArray[j]);
			}
			mo.setTagList(tagList);
		}
		return mo;
	}

	/**
	 * 自定义内部方法：2.整理商品规格信息
	 * 
	 * @param Model
	 * @return Model
	 * @date 2016年3月20日
	 * @auther luans
	 */
	public Model modelTypeHandel(Model mo) {
		List<ModelType> modeltypeList = new ArrayList<ModelType>();
		ModelType modeltype = new ModelType();
		modeltype.setModtModid(mo.getMid());
		modeltype.setMarkSel(1);// 材质
		modeltypeList = modelTypeService.queryModelTypeBymid(modeltype);
		if (modeltypeList.size() > 0) {
			mo.setTexttrueList(modeltypeList);
		}
		modeltype.setMarkSel(2);// 尺寸
		modeltypeList = modelTypeService.queryModelTypeBymid(modeltype);
		if (modeltypeList.size() > 0) {
			mo.setSizeList(modeltypeList);
		}

		return mo;
	}

	/**
	 * 自定义内部方法：3.整理商品列表展示信息
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
