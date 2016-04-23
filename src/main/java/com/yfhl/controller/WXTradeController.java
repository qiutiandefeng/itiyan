package com.yfhl.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.yfhl.entity.Trade;
import com.yfhl.entity.TradeDetail;
import com.yfhl.entity.User;
import com.yfhl.entity.UserAddress;
import com.yfhl.pay.weixin.demo.Demo;
import com.yfhl.pay.weixin.demo.WxPayDto;
import com.yfhl.service.CacheService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.TokenService;
import com.yfhl.service.TradeDetailService;
import com.yfhl.service.TradeService;
import com.yfhl.service.UserAddressService;
import com.yfhl.service.UserService;
import com.yfhl.util.EncryptUtil;
import com.yfhl.util.Md5Encrypt;
import com.yfhl.util.Sign;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年3月7日 下午11:44:49 类说明
 */
@Controller
@RequestMapping("wxtrade")
public class WXTradeController {

	@Resource
	private TradeService tradeService;

	@Resource
	private ModelService modelService;

	@Resource
	private UserService userService;

	@Resource
	private TokenService tokenService;

	@Resource
	private TradeDetailService tradeDetailService;

	@Resource
	private UserAddressService userAddressServiceImpl;// 注入用户地址Service层实例对象

	@Resource
	public ModelShoppingService modelShoppingService;

	@Resource
	private ModelTypeService modelTypeService;

	@Resource
	private CacheService cacheService;

	@RequestMapping("wxtradeList")
	public ModelAndView wxtradeList(Trade trade, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 判断用户是否登录
//		HttpSession session = request.getSession();
//		String userid = (String) session.getAttribute("yfhl_userid");
//		Integer uid = 0;
//		System.out.println("useriduseriduserid:" + userid);
//		if (userid == "" || userid == null) {
			// 没有授权用户，获取用户信息
			System.out.println("没有授权用户，获取用户信息");
			User user = getWxUser(request, response);
//			uid = user.getUid();
//		}else {
//			uid = Integer.parseInt(userid);
//		}
		
		ModelAndView mv = new ModelAndView();
		trade.setUid(user.getUid());
		// 获取用户的所有的订单
		List<Trade> tradeList = tradeService.getTradeListByUid(trade);
		// 根据订单获取订单详情信息
		tradeList = this.queryTradeDetial(tradeList);
		// 统计订单数量
		trade.setMarkUserid(user.getUid());
		trade = this.queryTradeCount(trade);

		mv.addObject("trade", trade);
		mv.addObject("tradeList", tradeList);

		mv.setViewName("/wx/trade/tradeList_wx");
		return mv;
	}

	/**
	 * 提交订单：通过购物车-提交订单
	 * 
	 * @param Trade
	 * @return List<Trade>
	 * @author luans
	 * @date 2016年3月19日
	 */
	@RequestMapping("wxAddTrades")
	@ResponseBody
	public String wxAddTrades(HttpServletResponse response,
			HttpServletRequest request, Trade trade) {
		System.out.println("进入添加订单：" + trade.toString());
		String erweima = "yes";// 判断订单是否生成成功
		ModelAndView mv = new ModelAndView();
		String marker_use = "no";// 是否有商品失效
		String[] submit_views = trade.getSubmit_views().split(";;");// 订单数量
		List<Trade> tradeList = new ArrayList<Trade>();
		List<TradeDetail> tradeDetailList = new ArrayList<TradeDetail>();
		ModelShopping modelShopping = new ModelShopping();
		ModelType modelType = new ModelType();// 商品详情信息
		TradeDetail tradeDetail = new TradeDetail();
		Trade trades = new Trade();
		UserAddress address = userAddressServiceImpl.selectByPrimaryKey(trade
				.getAddressid());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
		NumberFormat ddf1 = NumberFormat.getNumberInstance();
		ddf1.setMaximumFractionDigits(2);
		float brandprice = 0;// 订单总价格
		float totalprice = 0;// 所有订单总价格
		int result = 0;
		int modelTypeid = 0;// 商品规格ID
		List<Integer> mIds = new ArrayList<Integer>();// 购物车Id
		for (int i = 0; i < submit_views.length; i++) {
			// 订单编号
			trades.setTradeNo(fmt.format(new Date())
					+ trade.getUid().toString());
			System.out.println("订单编号：" + trades.getTradeNo());
			// 用户编号
			trades.setUid(trade.getUid());
			// 订单详情信息
			String[] details = submit_views[i].split(";");
			System.out.println("订单详情数量：" + details.length);
			float[] transportPriceArray = new float[details.length - 1];// 运费数组
			for (int j = 1; j < details.length; j++) {
				modelShopping = modelShoppingService.selectByPrimaryKey(Integer
						.valueOf(details[j]));
				mIds.add(Integer.valueOf(details[j]));
				trades.setTrdSelfDesigner(modelShopping.getMsSelfDesigner());
				trades.setTradeTitle(modelShopping.getMsModelbrand());
				tradeDetail.setId(modelShopping.getMsModelid());
				tradeDetail.setName(modelShopping.getMsModelname());
				tradeDetail.setQty(modelShopping.getMsModcount());
				tradeDetail.setPrice(modelShopping.getMsModprice());
				tradeDetail.setTradeDetailImg(modelShopping.getMsModelimg());
				// 查询商品的规格ID
				System.out.println("添加订单详情的商品规格查询条件信息："
						+ modelShopping.toString());
				modelTypeid = modelTypeService
						.queryIDByModelShopping(modelShopping);
				System.out.println("查询到的ID：" + modelTypeid);
				tradeDetail.setModeltypeId(modelTypeid);
				// tradeDetail.setRemark(details[0]);
				tradeDetailList.add(tradeDetail);
				transportPriceArray[j - 1] = modelShopping.getMsModtransport();
				brandprice = brandprice + modelShopping.getMsModcount()
						* modelShopping.getMsModprice();
				tradeDetail = new TradeDetail();
			}
			for (int m = 0; m < tradeDetailList.size(); m++) {
				System.out.println("订单详情信息luasn："
						+ tradeDetailList.get(m).toString());
			}
			trades.setTradeDetailList(tradeDetailList);
			System.out.println("订单总价：" + brandprice);
			// 订单总价
			Arrays.sort(transportPriceArray); // 运费进行排序
			System.out.println("运费数组长度：" + transportPriceArray.length);
			totalprice = totalprice + transportPriceArray[0];// 品牌总价格
			trades.setTotalPrice(brandprice + transportPriceArray[0]);
			totalprice = totalprice + brandprice;// 支付总金额
			brandprice = 0;// 清空
			// 运费
			trades.setPostage(transportPriceArray[0]);
			// 运送方式
			trades.setIsPost(1);// 邮递
			// 收货地址信息
			trades.setAddress(address.getProvince() + " " + address.getCity()
					+ " " + address.getAddressArea() + " "
					+ address.getAddress());
			trades.setRealname(address.getUsername());
			trades.setPhone(address.getTelephone());
			trades.setZipcode(address.getZipcode());
			// 备注
			trades.setRemark(details[0]);
			// 添加事件
			trades.setAddTime(new Date());
			// 订单状态:未付款
			trades.setState(1);

			modelType = modelTypeService
					.queryModelByModelShopping(modelShopping);
			if (modelType == null) {
				// 商品失效
				System.out.println("商品失效:" + modelShopping.toString());
				marker_use = "yes";
				break;
			}

			tradeList.add(trades);
			trades = new Trade();// 清空
			tradeDetailList = new ArrayList<TradeDetail>();

		}
		// 判断是否有失效的商品
		if (marker_use.equals("yes")) {
			// 有失效订单：提交订单那失败，跳转至购物车页面
			erweima = "error";
		} else {
			String tradeid = "";// 订单编号字符串
			for (int l = 0; l < tradeList.size(); l++) {

				trades = tradeList.get(l);
				// 添加订单
				result = tradeService.insertSelective(trades);
				tradeid = tradeid + trades.getTradeNo() + ";";
				System.out.println("刚刚插入的订单的id:" + trades.getId());
				// 添加订单详情
				for (int k = 0; k < trades.getTradeDetailList().size(); k++) {
					tradeDetail = trades.getTradeDetailList().get(k);
					System.out.println(k + "tradeDetail:"
							+ tradeDetail.toString());
					tradeDetail.setTradeId(trades.getId());
					result = tradeDetailService.insertSelective(tradeDetail);
					tradeDetail = new TradeDetail();
				}
			}
			tradeid = tradeid.substring(0, tradeid.length() - 1);
			// 删除购物车信息
			for (int l = 0; l < mIds.size(); l++) {
				result = modelShoppingService.deleteByPrimaryKey(mIds.get(l));
			}
			erweima = this.wxpay(request,tradeid, totalprice + "");// 生成支付二维码
		}

		return erweima;
	}

	/**
	 * 立即付款：通过订单详情页直接点击"立即付款"进入
	 * 
	 * @param Trade
	 * @return List<Trade>
	 * @author luans
	 * @date 2016年3月28日
	 */
	@RequestMapping("wxfastTopay")
	@ResponseBody
	public String wxfastTopay(HttpServletRequest request,String totalPrice,String tradeNo) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("tradeid", tradeNo);
//		mv.addObject("totalprice", totalPrice);
//		mv.addObject("tradeCount", tradeCount);
//		mv.setViewName("pc/modelcart/payment");
		System.out.println("进入立即支付");
		String erweima = this.wxpay(request,tradeNo, totalPrice);// 生成支付二维码
		System.out.println("立即支付的二维码："+erweima);
		return erweima;
	}

	/**
	 * 微信端：取消订单
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @throws Exception 
	 * @date 2016年3月21日
	 */
	@RequestMapping("wxcancelTrade")
	public ModelAndView wxcancelTrade(HttpServletRequest request,
			HttpServletResponse response, Trade trade) throws Exception {
		System.out.println("进入取消我的订单" + trade.toString());

		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		if (userid == "" || userid == null) {//
			try {
				response.sendRedirect(request.getContextPath()
						+ "/login/gotoIndexPC.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Integer uid = Integer.parseInt(userid);
		trade.setMarkUserid(uid);
		int result = 0;
		List<TradeDetail> list = tradeDetailService
				.getTradeDetailListByTradeId(uid);
		TradeDetail detail = new TradeDetail();
		for (int i = 0; i < list.size(); i++) {
			detail = list.get(i);
			detail.setMarker_changeNumber(1);
			// 修改modelType表中商品数量
			result = modelTypeService.updateModelTypeCount(detail);
			// 修改model表中商品数量
			result = modelService.updateModelCount(detail);
		}
		result = tradeService.cancelTrade(trade);
		System.out.println("result:" + result);
		return wxtradeList(trade, request, response);
	}

	/**
	 * 微信端：删除订单信息
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @throws Exception 
	 * @date 2016年3月21日
	 */
	@RequestMapping("wxdelTrade")
	public ModelAndView wxdelTrade(HttpServletRequest request,
			HttpServletResponse response, Trade trade) throws Exception {
		System.out.println("进入删除我的订单" + trade.toString());
		int result = tradeService.delTradePC(trade);
		System.out.println("result:" + result);
		return wxtradeList(trade, request, response);
	}

	/**
	 * 微信端：确认订单
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @throws Exception 
	 * @date 2016年3月21日
	 */
	@RequestMapping("wxmakeSureTreadePC")
	public ModelAndView wxmakeSureTreadePC(HttpServletRequest request,
			HttpServletResponse response, Trade trade) throws Exception {
		System.out.println("进入确认我的订单" + trade.toString());
		int result = tradeService.makeSureTreade(trade);
		System.out.println("result:" + result);
		return wxtradeList(trade, request, response);
	}

	@RequestMapping("zhifu")
	ModelAndView zhifu(HttpServletRequest request,
			HttpServletResponse response, Integer status, User user, Trade trade) {
		System.out.println("支付 状态 0：微信；1：PC " + status);

		ModelAndView mv = new ModelAndView();
		String body = "";
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(user.getWxOpenid());
		tpWxPay.setBody(trade.getTradeTitle());
		tpWxPay.setOrderId(Demo.getNonceStr());
		tpWxPay.setSpbillCreateIp("127.0.0.1");
		tpWxPay.setTotalFee(trade.getTotalPrice().toString());
		// tpWxPay.setOpenId("ol4OMuIcnKOIVlRnizoLyxZMA3js");
		// tpWxPay.setBody("商品信息");
		// tpWxPay.setOrderId(Demo.getNonceStr());
		// tpWxPay.setSpbillCreateIp("127.0.0.1");
		// tpWxPay.setTotalFee("0.02");

		if (status == 0)// 微信 支付
		{
			body = Demo.getPackage(tpWxPay);
			mv.addObject("body", body);
			mv.setViewName("/pay/jsapi");
			return mv;
		}
		body = Demo.getCodeurl(tpWxPay);
		mv.addObject("body", body);
		mv.setViewName("/pay/native");
		return mv;

	}

	/**
	 * 内部自定义方法：1.根据订单信息获取订单详情信息
	 * 
	 * @param List
	 *            <Trade>
	 * @return List<Trade>
	 * @author luans
	 * @date 2016年3月21日
	 */
	public List<Trade> queryTradeDetial(List<Trade> list) {
		List<TradeDetail> tdetailList = new ArrayList<TradeDetail>();
		for (int i = 0; i < list.size(); i++) {
			tdetailList = tradeDetailService.getTradeDetailListByTradeId(list
					.get(i).getId());
			list.get(i).setTradeDetailList(tdetailList);
			if (list.get(i).getStatus() == 1) {
			for(int j=0;j<tdetailList.size();j++){
				
				if(modelTypeService.checkmodelUseBytdetail(tdetailList.get(j))==0){
					list.get(i).setMarker_state(2);//订单商品库存不足，订单设置为失效状态
					break;
				}
				}
			}
		}
		return list;
	}

	/**
	 * 内部自定义方法：2.根据用户信息统计各类订单数量
	 * 
	 * @param Trade
	 * @return Trade
	 * @author luans
	 * @date 2016年3月21日
	 */
	public Trade queryTradeCount(Trade trade) {
		Trade t = tradeService.queryTradeCountByUId(trade);
		trade.setStateCount(t.getStateCount());
		trade.setState1Count(t.getState1Count());
		trade.setState2Count(t.getState2Count());
		trade.setState3Count(t.getState3Count());
		return trade;
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
	 * 内部自定义方法：3.生成支付二维码
	 * 
	 * @param Trade
	 * @return Trade
	 * @author luans
	 * @date 2016年3月25日
	 */
	public String wxpay(HttpServletRequest request, String OrderId, String totalFee) {

		// 扫码支付
		WxPayDto tpWxPay1 = new WxPayDto();
		tpWxPay1.setBody("爱体验商品");
		tpWxPay1.setOrderId(OrderId);
	    tpWxPay1.setSpbillCreateIp(getRemoteHost(request));
		tpWxPay1.setTotalFee(totalFee);
		return Demo.getCodeurl(tpWxPay1);
	}
	public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
}
