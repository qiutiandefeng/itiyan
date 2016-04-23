package com.yfhl.controller;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.ModelShopping;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.Recent;
import com.yfhl.entity.User;
import com.yfhl.entity.UserAddress;
import com.yfhl.service.ActivityService;
import com.yfhl.service.CacheService;
import com.yfhl.service.CheapCodeService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.RecentService;
import com.yfhl.service.TokenService;
import com.yfhl.service.TradeDetailService;
import com.yfhl.service.TradeService;
import com.yfhl.service.UserAddressService;
import com.yfhl.service.UserCodeService;
import com.yfhl.service.UserService;
import com.yfhl.util.EncryptUtil;
import com.yfhl.util.Md5Encrypt;
import com.yfhl.util.Sign;

/**
 * 微信端：商品管理Controller
 * 
 * @author luans
 * @date 2016年3月19日
 */
@Controller
@RequestMapping("wxModelShoppingController")
public class WXModelShoppingController {
	@Resource
	public ModelShoppingService modelShoppingService;

	@Resource
	private ModelService modelService;// 商品中的Service

	@Resource
	private ModelTypeService modelTypeService;// 类型

	@Resource
	private UserService userService;// 用户

	@Resource
	private UserAddressService userAddressService;// 地址

	@Resource
	private UserCodeService userCodeService;// 用户编号—优惠券编号—活动编号 关联表

	@Resource
	private CheapCodeService cheapCodeService;// 优惠券

	@Resource
	private ActivityService activityService;

	@Resource
	private UserAddressService userAddressServce;// 注入用户收货地址Service层实例

	@Resource
	private CacheService cacheService;

	@Resource
	private TokenService tokenService;

	@Resource
	public RecentService recentService;// 注如最近浏览Service层实例

	@Resource
	private TradeDetailService tradeDetailService;// 注入订单详情Service层实例

	@Resource
	private TradeService tradeService;

	/**
	 * 购物车操作
	 * 
	 * @param modelShopping
	 * @return int
	 * @author luans
	 * @throws Exception
	 */
	@RequestMapping("wxModelShopping")
	@ResponseBody
	public int wxModelShopping(HttpServletRequest request,
			HttpServletResponse response, ModelShopping modelShopping)
			throws Exception {
		System.out.println("购物车：" + modelShopping.toString());
		// 判断用户是否登录
		HttpSession session = request.getSession();
//		System.out.println("useriduseriduserid:" + userid);
//		if (userid == "" || userid == null) {
//			// 没有授权用户，获取用户信息
//			System.out.println("没有授权用户，获取用户信息");
//		}
		User user = getWxUser(request, response);
//		String userid = (String) session.getAttribute("yfhl_userid");
//		String openid = (String) session.getAttribute("openid");
//		Integer uid = Integer.parseInt(userid);
		int result = 0;
		// 判断是否是之前已经存在的相同的购物车信息:如果有的话就把数量加1，否则的话就重新添加一条数据；
		result = modelShoppingService.updateShopping(modelShopping);
		if (result == 0) {
			result = modelShoppingService.insertSelective(modelShopping);
		}
		if (result > 0) {
			// 修改购物车信息后，修改Session和cookie中的值
			this.changeCookieSession(request, response, user.getUid(),user.getWxOpenid());
		}
		// 统计用户购物车中商品数量
		result = modelShoppingService.countUserModel(modelShopping);

		return result;
	}

	/**
	 * 去购物车
	 * 
	 * @param modelShopping
	 * @return int
	 * @date
	 * @author luans
	 * @throws Exception 
	 */
	@RequestMapping("wxGetModelCartList")
	public ModelAndView wxGetModelCartList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
//		System.out.println("useriduseriduserid:" + userid);
//		if (userid == "" || userid == null) {
//			// 没有授权用户，获取用户信息
//			System.out.println("没有授权用户，获取用户信息");
//		}
		User user = getWxUser(request, response);
//		String userid = (String) session.getAttribute("yfhl_userid");
//		String openid = (String) session.getAttribute("openid");
//		Integer uid = Integer.parseInt(userid);
		System.out.println("jin进入购物车的用户ID：" + user.getUid());
		List<ModelShopping> modelCartList = modelShoppingService
				.getModelCartListByUserId(user.getUid());
		List<ModelShopping> shoppingList = new ArrayList<ModelShopping>();
		ModelShopping modelShopping = new ModelShopping();
		ModelType modelType = new ModelType();// 商品详情信息
		float countPrice=0;
		for (int i = 0; i < modelCartList.size(); i++) {
			modelShopping = modelCartList.get(i);
			countPrice=modelShopping.getMsModprice()*modelShopping.getMsModcount();
			BigDecimal   b  =   new BigDecimal(countPrice);
			countPrice=b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();//保留两位小数
			modelCartList.get(i).setCountPrice(countPrice);
			modelType = modelTypeService
					.queryModelByModelShopping(modelShopping);
			if (modelType == null) {
				// 商品失效
				System.out.println("商品失效:" + modelShopping.toString());
				modelShopping.setMarker_state(2);
			} else {
				modelShopping.setMarker_state(1);
				// 重新设置购物车中商品的价格为刚刚取出的商品详情中的商品价格
				modelShopping.setMsModprice(modelType.getModtPrice());
			}
			shoppingList.add(modelShopping);
		}
		mv.addObject("modelCartList", shoppingList);
		mv.setViewName("wx/modelcart/cart_wx");

		return mv;
	}

	/**
	 * 点击减少、增加改变商品数量
	 * 
	 * @param request
	 * @param response
	 * @return Map
	 * @author luans
	 * @date 2016年3月19日
	 */
	@RequestMapping("wxCartChange")
	@ResponseBody
	public Map<Object, Object> wxCartChange(HttpServletRequest request,
			ModelShopping modelShopping) {
		int result = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		/**
		 * 异常参数、封装一起、还有把返回的参数最好用枚举列出
		 */
		if (modelShopping.getMsId() == null
				|| modelShopping.getMarker_count() == null) {
			map.put("state", 0);
			map.put("value", "参数异常");
			map.put("body", new ArrayList<Object>());
			return map;
		}
		List<Object> body = new ArrayList<Object>();
		// 验证库存是否达到上线
		ModelShopping mShopping = modelShoppingService
				.selectByPrimaryKey(modelShopping.getMsId());
		int count = mShopping.getMsModcount();
		// 验证是否小于最小库存
		if (count < 1) {
			map.put("state", 0);
			map.put("value", "达到最小购买数量值");
			return map;

		}
		if (modelShopping.getMarker_count() == 1) {
			count = count - 1;
		} else if (modelShopping.getMarker_count() == 2) {
			count = count + 1;
			mShopping.setMsModcount(count);
		}

		// 验证是否达到库存上线
		ModelType modelType = modelTypeService
				.queryModelByModelShopping(mShopping);
		if (modelType == null) {
			map.put("state", 0);
			map.put("value", "库存达到上线");

		} else {
			result = modelShoppingService.updatemsModcount(modelShopping);
			map.put("state", 1);
			body.add(result);
			body.add(count);
			map.put("body", body);
			map.put("value", "修改成功");
		}
		return map;
	}

	/**
	 * 购物车——>结算
	 * 
	 * @param request
	 * @param response
	 * @return String
	 * @author luans
	 * @throws Exception 
	 * @date 2016年3月19日
	 */
	@RequestMapping("wxSettleCountByShopping")
	public ModelAndView wxSettleCountByShopping(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = getWxUser(request, response);
		String marker_use = "no";// 是否有商品失效
		Integer uid = Integer.valueOf(user.getUid());
		String checks = request.getParameter("check");
		String[] check = checks.split(";");
		float totalPrice = 0;// 总价
		float totaltransportPrice = 0;// 总运费
		float countPrice = 0;// 单商品总价
		float brandPrice = 0;// 品牌总价
		Map<String, Float> priceList = new HashMap<String, Float>();// 存储同一品牌下的订单的总金额
		Map<String, Float> transportPriceList = new HashMap<String, Float>();// 存储同一品牌下的订单的运费
		List<ModelShopping> modelCartList = new ArrayList<ModelShopping>();

		// 获取用户的地址
		List<UserAddress> userAddressList = userAddressService
				.selectUserAddressListByUid(uid);
		// 获取用户默认收货地址信息
		UserAddress userAddress = new UserAddress();
		for (int k = 0; k < userAddressList.size(); k++) {
			if (userAddressList.get(k).getIsDefault() == 1) {
				userAddress = userAddressList.get(k);
				System.out.println("默认收货地址:" + userAddress.toString());
				break;
			}
		}
		// 购物车商品信息
		ModelShopping modelShopping = new ModelShopping();
		// 商品详情信息
		ModelType modelType = new ModelType();
		// 获取商品品牌
		Map<Object, Object> brandMap = new HashMap<Object, Object>();
		// 统计查询商品中的所有品牌
		List<String> brandList = modelShoppingService
				.queryBrandByShoppingById(check);
		for (int i = 0; i < brandList.size(); i++) {

			modelCartList = modelShoppingService.queryModelShoppingByBrand(
					brandList.get(i), check);
			float[] transportPriceArray = new float[modelCartList.size()];// 运费数组
			for (int j = 0; j < modelCartList.size(); j++) {
				modelShopping = modelCartList.get(j);
				modelType = modelTypeService
						.queryModelByModelShopping(modelShopping);
				if (modelType == null) {
					// 商品失效
					System.out.println("商品失效:" + modelShopping.toString());
					marker_use = "yes";
					break;
				} else {
					System.out.println("modelType.toString():"
							+ modelType.toString());
					// 计算单个商品总价
					countPrice = modelShopping.getMsModcount()
							* modelType.getModtPrice();
					modelCartList.get(j).setCountPrice(countPrice);
				}
				// 运费
				transportPriceArray[j] = modelShopping.getMsModtransport();
				brandPrice = brandPrice + countPrice;// 品牌总价
			}
			// 有失效的商品
			if (marker_use.equals("yes")) {
				System.out.println("有商品失效");
				break;
			}
			Arrays.sort(transportPriceArray); // 运费进行排序
			brandPrice = brandPrice + transportPriceArray[0];// 品牌总价格
			brandMap.put(brandList.get(i), modelCartList);// 获取品牌
			transportPriceList.put(brandList.get(i), transportPriceArray[0]);// 品牌总运费
			priceList.put(brandList.get(i), brandPrice);

			totaltransportPrice = totaltransportPrice + transportPriceArray[0];// 总运费
			totalPrice = totalPrice + brandPrice;// 总价格

			// 清空数据
			brandPrice = 0;

		}
		// 有失效的商品
		if (marker_use.equals("yes")) {
			System.out.println("有商品失效");
			// 有失效的商品，跳转到购物车页面
			return this.wxGetModelCartList(request, response);
		} else {

			mv.addObject("modelCartList", modelCartList);
			mv.addObject("brandMap", brandMap);
			mv.addObject("userAddressList", userAddressList);
			mv.addObject("userAddress", userAddress);
			mv.addObject("totalPrice", totalPrice);
			mv.addObject("totaltransportPrice", totaltransportPrice);
			mv.addObject("totalModelPrice",  new BigDecimal(totalPrice-totaltransportPrice).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
			mv.addObject("priceList", priceList);
			mv.addObject("transportPriceList", transportPriceList);
			mv.addObject("check",checks);

			mv.setViewName("wx/modelcart/orders_wx");
		}
		return mv;
	}

	/**
	 * 商品详情(立即购买)——>结算
	 * 
	 * @param ModelShopping
	 * @return ModelAndView
	 * @author luans
	 * @throws Exception 
	 * @date 2016年3月20日
	 */
	@RequestMapping("wxSettleCountByDetail")
	public ModelAndView wxSettleCountByDetail(HttpServletRequest request,HttpServletResponse response,
			ModelShopping modelShopping) throws Exception {
//		System.out.println("立即购买：" + modelShopping.toString());
//		// 从Session中获取用户id
//		HttpSession session = request.getSession();
//		String userid = (String) session.getAttribute("yfhl_userid");
//		int uid = 0;
//		if (userid != null && !"".equals(userid)) {
//			uid = Integer.parseInt(userid);
//		}
		User user = getWxUser(request, response);
		// 判断是否是之前已经存在的相同的购物车信息:如果有的话就把数量叠加，否则的话就重新添加一条数据；
		int result = modelShoppingService.updateShoppingByviews(modelShopping);
		System.out.println("修改结果：" + result);
		if (result == 0) {
			result = modelShoppingService.insertSelective(modelShopping);
			System.out.println("商品详情中添加购物车result：" + result + " modelShopping:"
					+ modelShopping.toString());
		}
		modelShopping = modelShoppingService
				.queryModelShoppingByviews(modelShopping);
		String check=modelShopping.getMsId()+"";
		// 添加进购物车信息
		System.out.println("添加后的购物车信息：" + modelShopping.toString());
		ModelAndView mv = new ModelAndView();
		String marker_use = "no";// 是否有商品失效
		float totalPrice = 0;// 总价
		float totaltransportPrice = 0;// 总运费
		float countPrice = 0;// 单商品总价
		float brandPrice = 0;// 品牌总价
		Map<String, Float> priceList = new HashMap<String, Float>();// 存储同一品牌下的订单的总金额
		Map<String, Float> transportPriceList = new HashMap<String, Float>();// 存储同一品牌下的订单的运费
		List<ModelShopping> modelCartList = new ArrayList<ModelShopping>();

		// 获取用户的地址
		List<UserAddress> userAddressList = userAddressService
				.selectUserAddressListByUid(modelShopping.getMsUid());
		// 获取用户默认收货地址信息
		UserAddress userAddress = new UserAddress();
		for (int k = 0; k < userAddressList.size(); k++) {
			if (userAddressList.get(k).getIsDefault() == 1) {
				userAddress = userAddressList.get(k);
				System.out.println("默认收货地址:" + userAddress.toString());
				break;
			}
		}
		// 商品详情信息
		ModelType modelType = new ModelType();
		// 获取商品品牌
		Map<Object, Object> brandMap = new HashMap<Object, Object>();

		modelType = modelTypeService.queryModelByModelShopping(modelShopping);
		if (modelType == null) {
			// 商品失效
			System.out.println("商品失效:" + modelShopping.toString());
			marker_use = "yes";
		} else {
			System.out.println("商品价格：" + modelType.getModtPrice());
			System.out.println("modelType.toString():" + modelType.toString());
			// 计算单个商品总价
			countPrice = modelShopping.getMsModcount()
					* modelType.getModtPrice();
			modelShopping.setCountPrice(countPrice);
		}
		brandPrice = modelShopping.getMsModtransport() + countPrice;// 品牌总价
		modelCartList.add(modelShopping);
		brandMap.put(modelShopping.getMsModelbrand(), modelCartList);// 获取品牌
		transportPriceList.put(modelShopping.getMsModelbrand(),
				modelShopping.getMsModtransport());// 品牌总运费
		priceList.put(modelShopping.getMsModelbrand(), brandPrice);

		totaltransportPrice = modelShopping.getMsModtransport();// 总运费
		totalPrice = brandPrice;// 总价格
		// 有失效的商品
		if (marker_use.equals("yes")) {
			System.out.println("有商品失效");
			// 查询最近浏览商品
			List<Recent> recentList = new ArrayList<Recent>();
			if (user.getUid() != 0) {
				recentList = this.recentModel(user.getUid());
			}
			mv.addObject("recentList", recentList);
			mv.setViewName("error/error_modelfailure");
		} else {
			mv.addObject("modelCartList", modelCartList);
			mv.addObject("brandMap", brandMap);
			// mv.addObject("cheapCodeList", cheapCodeList);
			mv.addObject("userAddressList", userAddressList);
			mv.addObject("userAddress", userAddress);
			mv.addObject("totalPrice", totalPrice);
			mv.addObject("totaltransportPrice", totaltransportPrice);
			mv.addObject("totalModelPrice",  new BigDecimal(totalPrice-totaltransportPrice).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
			mv.addObject("priceList", priceList);
			mv.addObject("transportPriceList", transportPriceList);	
			mv.addObject("check",check);
			
			
			mv.setViewName("wx/modelcart/orders_wx");
		}
		return mv;
	}


	/**
	 * 微信购物车 删除
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @authorluans
	 * @date 2016年3月25日
	 */
	@RequestMapping("wxcartDel")
	@ResponseBody
	public Integer wxcartDel(HttpServletRequest request,
			HttpServletResponse response, Integer msId) throws Exception {
		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		String openid = (String) session.getAttribute("openid");
		
		if (userid == "" || userid == null) {//
			// 没有授权用户，获取用户信息
			System.out.println("没有授权用户，获取用户信息");
		}
		Integer uid = Integer.parseInt(userid);
		int result = modelShoppingService.deleteByPrimaryKey(msId);
		// 修改购物车信息后，修改Session和cookie中的值
		this.changeCookieSession(request, response, uid,openid);
        
		return result;
	}

	/**
	 * 内部自定义方法：1.查询最近浏览商品
	 * 
	 * @param User
	 * @return List<Recent>
	 * @date 2016年3月24日
	 * @auther luans
	 */
	public List<Recent> recentModel(Integer uid) {
		List<Recent> recentList = new ArrayList<Recent>();
		// 根据用户ID查询用户最近浏览记录
		Recent recent = new Recent();
		recent.setrUid(uid);
		recentList = recentService.queryRecent(recent);
		if (recentList.size() == 0) {// 用户无最近浏览记录
			System.out.println("无最近浏览记录");
		} else if (recentList.size() != 0) {
			Recent r = new Recent();
			for (int i = 0; i < recentList.size(); i++) {
				r = recentList.get(i);
				if (r.getModelImg() != null && !"".equals(r.getModelImg())) {
					String[] imgs = r.getModelImg().split(";");
					r.setModelImg(imgs[0]);// 显示第一张图片
				}
			}
		}
		return recentList;
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
		u.setWxOpenid(openid);
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
}
