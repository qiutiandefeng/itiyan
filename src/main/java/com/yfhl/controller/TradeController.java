package com.yfhl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelShopping;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.Recent;
import com.yfhl.entity.Trade;
import com.yfhl.entity.TradeDetail;
import com.yfhl.entity.User;
import com.yfhl.entity.UserAddress;
import com.yfhl.pay.weixin.demo.Demo;
import com.yfhl.pay.weixin.demo.WxPayDto;
import com.yfhl.service.Exhibitionservice;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.RecentService;
import com.yfhl.service.TradeDetailService;
import com.yfhl.service.TradeService;
import com.yfhl.service.UserAddressService;
import com.yfhl.service.UserService;
import com.yfhl.util.CodeUtil;
import com.yfhl.util.TradeOn;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年11月16日 下午12:29:03 类说明
 */
@Controller
@RequestMapping("/tradeManage")
public class TradeController {

	/**
	 * 订单
	 */
	@Resource
	private TradeService tradeService;

	/**
	 * 用户
	 */
	@Resource
	private UserService userService;

	/**
	 * 商品
	 */
	@Resource
	private Exhibitionservice exhibitionservice;// 商品

	/**
	 * 订单详情页面
	 */
	@Resource
	private TradeDetailService tradeDetailService;

	/**
	 * 模型 （商品）
	 */
	@Resource
	private ModelService modelService;

	/**
	 * 材质
	 */
	@Resource
	private ModelTypeService modelTypeService;

	@Resource
	public ModelShoppingService modelShoppingService;

	@Resource
	private UserAddressService userAddressServiceImpl;// 注入用户地址Service层实例对象

	@Resource
	public RecentService recentService;// 注如最近浏览Service层实例

	/**
	 * PC端前台：取消订单
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年1月7日
	 */
	@RequestMapping("cancelTradePC")
	public ModelAndView cancelTradePC(HttpServletRequest request,
			HttpServletResponse response, Trade trade) {
		System.out.println("进入取消我的订单" + trade.toString());

		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		if (userid == "" || userid == null) {//
			try {
				response.sendRedirect(request.getContextPath()
						+ "/login/gotoIndexPC.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer uid = Integer.parseInt(userid);

		trade.setMarkUserid(uid);
		trade = this.turnCode(trade);// 乱码转换
		int result = 0;
		List<TradeDetail> list = tradeDetailService
				.getTradeDetailListByTradeId(trade.getId());
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
		return queryListPC(request, response, trade);
	}

	/**
	 * PC端前台：确认订单
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年1月7日
	 */
	@RequestMapping("makeSureTreadePC")
	public ModelAndView makeSureTreadePC(HttpServletRequest request,
			HttpServletResponse response, Trade trade) {
		System.out.println("进入确认我的订单" + trade.toString());
		int result = tradeService.makeSureTreade(trade);
		System.out.println("result:" + result);
		return queryListPC(request, response, trade);
	}

	/**
	 * PC端前台：删除订单信息
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年1月7日
	 */
	@RequestMapping("delTradePC")
	public ModelAndView delTradePC(HttpServletRequest request,
			HttpServletResponse response, Trade trade) {
		System.out.println("进入删除我的订单" + trade.toString());
		int result = tradeService.delTradePC(trade);
		System.out.println("result:" + result);
		return queryListPC(request, response, trade);
	}

	/**
	 * PC端前台：分页获取订单信息
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年1月5日
	 */
	@RequestMapping("queryListPC")
	public ModelAndView queryListPC(HttpServletRequest request,
			HttpServletResponse response, Trade trade) {
		System.out.println("进入查询我的订单" + trade.toString());
		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
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
		ModelAndView mv = new ModelAndView();
		trade.setMarkUserid(uid);
		trade.getPageInfo().setPageSize(10);
		// 根据条件分页获取用户的订单
		List<Trade> list = tradeService.queryListByPage(trade);
		// 根据订单获取订单详情信息
		list = this.queryTradeDetial(list);
		// 统计订单数量
		trade = this.queryTradeCount(trade);

		mv.addObject("trade", trade);
		mv.addObject("list", list);
		mv.setViewName("/pc/userManage/userTrade");
		return mv;
	}

	/**
	 * PC端前台：获取订单详情信息
	 * 
	 * @param Trade
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年1月7日
	 */
	@RequestMapping("queryTradeDetailPC")
	public ModelAndView queryTradeDetailPC(Trade trade) {
		System.out.println("进入查询订单详情：" + trade.toString());
		ModelAndView mv = new ModelAndView();
		// 根据订单编号获取订单信息
		Trade qtrade = tradeService.queryTradeById(trade.getId());
		// 根据订单编号查询订单详细信息
		List<TradeDetail> tdetailList = tradeDetailService
				.getTradeDetailListByTradeId(trade.getId());
		qtrade.setTradeDetailList(tdetailList);
		qtrade.setPageInfo(trade.getPageInfo());
		System.out.println("订单信息:" + qtrade.toString());
		System.out.println("订单详情个数：" + tdetailList.size());
		if (trade.getState() == 1) {
			mv.setViewName("/pc/userManage/userTradeDetail1");// 1：等待付款
		} else if (trade.getState() == 2) {
			mv.setViewName("/pc/userManage/userTradeDetail2");// 2：已付款，等待发货
		} else if (trade.getState() == 3) {
			mv.setViewName("/pc/userManage/userTradeDetail3");// 3：已发货，等待收货
		} else if (trade.getState() == 4) {
			mv.setViewName("/pc/userManage/userTradeDetail4");// 4：交易完成
		} else if (trade.getState() == 5) {
			mv.setViewName("/pc/userManage/userTradeDetail5");// 5：交易取消
		}

		mv.addObject("trade", qtrade);
		mv.addObject("list", tdetailList);
		return mv;
	}

	/**
	 * 查询订单List
	 * 
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2015年11月17日
	 */
	@RequestMapping("queryList")
	public ModelAndView queryList(Trade trade) {
		ModelAndView mv = new ModelAndView();
		trade.getPageInfo().setPageSize(10);
		List<Trade> tradelist = tradeService.queryListByPage(trade);
		Trade tradeCount = tradeService.queryTradeCount(trade);
		trade.setSumCount(tradeCount.getSumCount());
		trade.setpCount(tradeCount.getpCount());
		trade.setwCount(tradeCount.getwCount());
		mv.addObject("tradelist", tradelist);
		mv.addObject("trade", trade);
		mv.setViewName("/manager/tradeManage/tradeList");
		return mv;
	}

	/**
	 * 根据Trade 点击查看 Trade的详情
	 * 
	 * @param trade
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @throws Exception
	 * @date 2015年11月17日
	 */
	@RequestMapping("gotoTradeManage")
	public ModelAndView gotoTradeManage(Trade trade) throws Exception {
		ModelAndView mv = new ModelAndView();
		/**
		 * 一个订单
		 */
		Trade tradeOne = tradeService.selectByPrimaryKey(trade.getId());
		// tradeOne.setAddTime(StringDateTool.date2Date(tradeOne.getAddTime()));
		// tradeOne.setPaymentTime(StringDateTool.date2Date(tradeOne.getPaymentTime()));
		/**
		 * 指定用户
		 */
		User user = userService.getUserByUid(tradeOne.getUid());

		/**
		 * 订单中详情订单多个trade_detail_id a:1:{i:0;i:691;} a:1:{i:0;i:681;}
		 */
		// List tradeuDatil =
		// (List)PHPSerializer.unserialize(tradeOne.getTradeDetail().getBytes());
		// String tradeDeatils = tradeOne.getTradeDetailId();
		List<Model> ml = new ArrayList<Model>();
		List<User> authorList = new ArrayList<User>();
		List<TradeDetail> tradeDetailList = new ArrayList<TradeDetail>();
		List<ModelType> modelTypeList = new ArrayList<ModelType>();
		tradeDetailList = tradeDetailService
				.getTradeDetailListByTradeId(tradeOne.getId());
		for (int i = 0; i < tradeDetailList.size(); i++) {
			/**
			 * 指定的展示的商品
			 */
			Model model = this.modelService.getModelBymId(tradeDetailList
					.get(i).getId());
			/**
			 * 指定商品的材质
			 */
			ModelType modelType = modelTypeService
					.selectByPrimaryKey(tradeDetailList.get(i).getModeltypeId());
			/**
			 * 设计师
			 */
			User author = userService.getAuthorByUId(model.getAuthor());
			ml.add(model);
			authorList.add(author);
			modelTypeList.add(modelType);
		}

		tradeOne.setMarkTradeFrom(trade.getMarkTradeFrom());
		tradeOne.setTradeOneNo(trade.getTradeOneNo());
		mv.addObject("user", user);
		mv.addObject("tradeOne", tradeOne);
		mv.addObject("modelList", ml);
		mv.addObject("modelTypeList", modelTypeList);
		mv.addObject("authorList", authorList);
		mv.addObject("tradeDetailList", tradeDetailList);

		mv.setViewName("/manager/tradeManage/tradeDetail");
		return mv;
	}

	@RequestMapping("cancelTrade")
	public String cancelTrade(HttpServletRequest request) {
		Integer tId = Integer.valueOf(request.getParameter("tId"));
		Trade record = new Trade();
		record.setId(tId);
		record.setIsDelete(1);// 0正常 1用户删除
		int del = 0;
		if (tId != null || !"".equals(tId)) {
			del = tradeService.updateByPrimaryKeySelective(record);
		}
		if (del != 0) {
			return "redirect:/tradeManage/queryList.do";// 重定向到第二页面 TradeList
		} else {
			return "error";
		}

	}

	/**
	 * 批量添加订单信息 提交订单的时注意： 1、批量的品牌、批量的订单 2、考虑的每一个订单中多个商品、还有用某个商品名称为每个订单中名称
	 * 3、批量中商品的总价格还有每个品牌（订单）中小计 4、优惠券、时效性校验 5、订单备注/商品备注 6、运费
	 * 
	 * @param trade
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月19日
	 */
	@RequestMapping("addTrade")
	public String addTrade(Trade trade, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String[] brandStr = new String(request.getParameter("brandStr")
				.getBytes("ISO-8859-1"), "utf-8").split(";");// 品牌拼接的Str
		String[] modelNo = new String(request.getParameter("modelNo").getBytes(
				"ISO-8859-1"), "utf-8").split(";");// 商品编号Str
		String[] modelTetle = new String(request.getParameter("modelTetle")
				.getBytes("ISO-8859-1"), "utf-8").split(";");// 订单名称Str
		String[] remarkStr = new String(request.getParameter("remarkStr")
				.getBytes("ISO-8859-1"), "utf-8").split(";");// 备注Str
		String[] str = request.getParameter("str").split(";");
		trade.setTradeNo(TradeOn.getOrderNo());// 订单号
		trade.setAddTime(new Date());// 添加时间
		trade.setStatus(1);// 订单状态（1：等待付款 2：已付款，等待发货 3：已发货，等待收货 4：交易完成 5：交易取消
							// 6：供应商打印中）
		trade.setIsDelete(0);// 0正常 1用户删除
		trade.setIsPost(1);// 系统默认/自取0 邮费1

		System.out.println(brandStr.toString() + "====" + modelNo.toString()
				+ "====" + modelTetle.toString() + "===="
				+ remarkStr.toString() + "=====" + str.toString());

		for (int i = 0; i < brandStr.length; i++) {
			Integer brandName = Integer.valueOf(brandStr[i]);// 品牌编号
			Integer strNo = Integer.valueOf(str[i]);// 品牌下面商品数量
			for (int j = 0; j < strNo - 1; j++) {
				trade.setTradeTitle(modelTetle[0]);// 订单名称

			}
		}

		// Integer saveFalg = tradeService.insert(trade);

		// 到支付1页面
		return "";
	}

	/**
	 * 提交订单：通过购物车-提交订单
	 * 
	 * @param Trade
	 * @return List<Trade>
	 * @author luans
	 * @date 2016年2月29日
	 */
	@RequestMapping("addTrades")
	public ModelAndView addTrades(HttpServletResponse response,
			HttpServletRequest request, Trade trade) {
		System.out.println("进入添加订单：" + trade.toString());
		// 从Session中获取用户id
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int uid = 0;
		if (userid != null && !"".equals(userid)) {
			uid = Integer.parseInt(userid);
		}
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
			float[] transportPriceArray = new float[details.length - 1];// 运费数组
			for (int j = 1; j < details.length; j++) {
				modelShopping = modelShoppingService.selectByPrimaryKey(Integer
						.valueOf(details[j]));
				mIds.add(Integer.valueOf(details[j]));
				trades.setTrdSelfDesigner(modelShopping.getMsSelfDesigner());
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
			// 查询最近浏览商品
			List<Recent> recentList = new ArrayList<Recent>();
			if (uid != 0) {
				recentList = this.recentModel(uid);
			}
			System.out.println("跳转到订单失败页面");
			mv.addObject("recentList", recentList);
			mv.setViewName("error/error_modelfailure");
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
					tradeDetail.setMarker_changeNumber(2);
					result = tradeDetailService.insertSelective(tradeDetail);
					result = modelTypeService.updateModelTypeCount(tradeDetail);// 修改modelType表中对应商品详情的商品数量
					result = modelService.updateModelCount(tradeDetail);// 修改商品表中商品的数量
					tradeDetail = new TradeDetail();
				}
			}
			// 删除购物车信息
			for (int l = 0; l < mIds.size(); l++) {
				result = modelShoppingService.deleteByPrimaryKey(mIds.get(l));
			}
			tradeid = tradeid.substring(0, tradeid.length() - 1);
			System.out.println("订单编号集合：" + tradeid);
			mv.addObject("tradeid", tradeid);
			mv.addObject("totalprice", totalprice);
			mv.addObject("tradeCount", tradeList.size());

			mv.setViewName("pc/modelcart/payment");
		}
		return mv;
	}

	/**
	 * 立即付款：通过订单详情页直接点击"立即付款"进入
	 * 
	 * @param Trade
	 * @return List<Trade>
	 * @author luans
	 * @date 2016年3月15日
	 */
	@RequestMapping("fastTopay")
	public ModelAndView fastTopay(String totalPrice, String tradeCount,
			String tradeNo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tradeid", tradeNo);
		mv.addObject("totalprice", totalPrice);
		mv.addObject("tradeCount", tradeCount);

		mv.setViewName("pc/modelcart/payment");
		return mv;
	}

	/**
	 * 支付宝支付成功后跳转路径
	 * 
	 * @param 订单编号
	 *            、付款时间、支付宝交易号、买家支付宝
	 * @return List<Trade>
	 * @author luans
	 * @throws ParseException
	 * @date 2016年3月24日
	 */
	@RequestMapping("alipayresult")
	public ModelAndView aliPayResult(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();
		try {
			// String body = new
			// String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");//商品描述里显示
			String buyer_email = new String(request.getParameter("buyer_email")
					.getBytes("ISO-8859-1"), "UTF-8");// 买家账号
			// String buyer_id = new
			// String(request.getParameter("buyer_id").getBytes("ISO-8859-1"),"UTF-8");//
			// String exterface = new
			// String(request.getParameter("exterface").getBytes("ISO-8859-1"),"UTF-8");
			// String is_success = new
			// String(request.getParameter("is_success").getBytes("ISO-8859-1"),"UTF-8");
			// String notify_id = new
			// String(request.getParameter("notify_id").getBytes("ISO-8859-1"),"UTF-8");
			String notify_time = new String(request.getParameter("notify_time")
					.getBytes("ISO-8859-1"), "UTF-8");// 支付时间
			// String notify_type = new
			// String(request.getParameter("notify_type").getBytes("ISO-8859-1"),"UTF-8");
			String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("ISO-8859-1"), "UTF-8");// 订单号 ：
																		// 201603251057213692
			// String payment_type = new
			// String(request.getParameter("payment_type").getBytes("ISO-8859-1"),"UTF-8");
			// String seller_email = new
			// String(request.getParameter("seller_email").getBytes("ISO-8859-1"),"UTF-8");//商家账号
			// String total_fee = new
			// String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");//金额
			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("ISO-8859-1"), "UTF-8");// 交易号：2016032521001004440222301753
			// String trade_status = new
			// String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");//订单状态TRADE_SUCCESS

			// 查询成功页面需要的信息
			String tradenos = out_trade_no;
			String[] tradenoArray = tradenos.split(";");
			Trade t = new Trade();
			List<Trade> tradeList = new ArrayList<Trade>();
			float totalPrice = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			for (int i = 0; i < tradenoArray.length; i++) {

				t.setTradeNo(tradenoArray[i]);
				t.setAlipayNo(trade_no);// 支付宝交易号
				t.setAlipayBuyerAccount(buyer_email);// 买家支付宝账号
				t.setPaymentTime(sdf.parse(notify_time));// 付款时间
				tradeService.updateForalPay(t);// 支付成功后修改订单信息
				t = tradeService.queryTradeByNo(tradenoArray[i]);
				t.setModelCount(tradeDetailService.getCountModelBytid(t.getId()));
				totalPrice = totalPrice + t.getTotalPrice();

				tradeList.add(t);
			}

			mv.addObject("totalprice", totalPrice);
			mv.addObject("tradeList", tradeList);

			mv.setViewName("pc/modelcart/consummation");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 微信支付成功后跳转路径
	 * 
	 * @param 订单编号
	 *            、付款时间、支付宝交易号、买家支付宝
	 * @author luans
	 * @throws ParseException
	 * @date 2016年3月25日
	 */
	@RequestMapping("weixinPayResult")
	public ModelAndView weixinPayResult(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		ModelAndView mv = new ModelAndView();
		try {
			String body = new String(request.getParameter("body").getBytes(
					"ISO-8859-1"), "UTF-8");// 商品描述里显示
			String appid = new String(request.getParameter("appid").getBytes(
					"ISO-8859-1"), "UTF-8");// 买家账号
			String mch_id = new String(request.getParameter("mch_id").getBytes(
					"ISO-8859-1"), "UTF-8");// 卖家账号
			String detail = new String(request.getParameter("detail").getBytes(
					"ISO-8859-1"), "UTF-8");// 订单详情
			String openid = new String(request.getParameter("openid").getBytes(
					"ISO-8859-1"), "UTF-8");// 用户微信唯一标示
			String result_code = new String(request.getParameter("result_code")
					.getBytes("ISO-8859-1"), "UTF-8");// 支付状态
			String trade_type = new String(request.getParameter("trade_type")
					.getBytes("ISO-8859-1"), "UTF-8");// 交易类型
			String transaction_id = new String(request.getParameter(
					"transaction_id").getBytes("ISO-8859-1"), "UTF-8");// 交易号
			String total_fee = new String(request.getParameter("total_fee")
					.getBytes("ISO-8859-1"), "UTF-8");// 金额
			String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("ISO-8859-1"), "UTF-8");// 订单号
			String time_end = new String(request.getParameter("time_end")
					.getBytes("ISO-8859-1"), "UTF-8");// 交易完成时间
			// 查询成功页面需要的信息
			String tradenos = out_trade_no;
			String[] tradenoArray = tradenos.split(";");
			Trade t = new Trade();
			List<Trade> tradeList = new ArrayList<Trade>();
			float totalPrice = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			for (int i = 0; i < tradenoArray.length; i++) {

				t.setTradeNo(tradenoArray[i]);
				t.setWxOpenid(openid);
				t.setWxpayNo(transaction_id);
				t.setCashFee(Float.valueOf(total_fee));
				t.setPaymentTime(sdf.parse(time_end));// 付款时间
				tradeService.updateWxPay(t);// 支付成功后修改订单信息
				t = tradeService.queryTradeByNo(tradenoArray[i]);
				t.setModelCount(tradeDetailService.getCountModelBytid(t.getId()));
				totalPrice = totalPrice + t.getTotalPrice();

				tradeList.add(t);
			}

			mv.addObject("totalprice", totalPrice);
			mv.addObject("tradeList", tradeList);

			mv.setViewName("pc/modelcart/consummation");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("wxpay")
	@ResponseBody
	public String wxpay(HttpServletRequest request, HttpServletResponse response) {
		String OrderId = (String) request.getParameter("WIDout_trade_no");
		String totalFee = (String) request.getParameter("WIDtotal_fee");
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

	/**
	 * 内部自定义方法：1.根据订单信息获取订单详情信息
	 * 
	 * @param List
	 *            <Trade>
	 * @return List<Trade>
	 * @author luans
	 * @date 2016年1月6日
	 */
	public List<Trade> queryTradeDetial(List<Trade> list) {
		List<TradeDetail> tdetailList = new ArrayList<TradeDetail>();
		ModelType modelType = new ModelType();
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			// 获取订单详情信息
			tdetailList = tradeDetailService.getTradeDetailListByTradeId(list
					.get(i).getId());
			list.get(i).setTradeDetailList(tdetailList);
			if (list.get(i).getStatus() == 1) {
				// 判断订单是否失效
				for (int j = 0; j < tdetailList.size(); j++) {
					modelType = modelTypeService
							.queryModelByTradeDetail(tdetailList.get(j));
					if (modelType == null) {
						result = 1;
						break;
					}
				}
			}
			if (result == 1) {
				list.get(i).setMarker_state(2);
			} else {
				list.get(i).setMarker_state(0);
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
	 * @date 2016年1月6日
	 */
	public Trade queryTradeCount(Trade trade) {
		Trade t = tradeService.queryTradeCountByUId(trade);
		trade.setStateCount(t.getStateCount());
		trade.setState1Count(t.getState1Count());
		trade.setState2Count(t.getState2Count());
		trade.setState3Count(t.getState3Count());
		return trade;
	}

	/**
	 * 内部自定义方法：3.订单信息乱码转换
	 * 
	 * @param Trade
	 * @return Trade
	 * @date 2016年1月15日
	 * @auther luans
	 */
	public Trade turnCode(Trade trade) {
		// 实例化编码工具类
		CodeUtil codeUtil = new CodeUtil();
		// 1.模糊查询条件乱码
		if (trade.getCancelInfo() != null && !"".equals(trade.getCancelInfo())
				&& codeUtil.isMessyCode(trade.getCancelInfo())) {
			try {
				String cancelInfo = new String(trade.getCancelInfo().getBytes(
						"ISO-8859-1"), "utf-8");
				trade.setCancelInfo(cancelInfo);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trade;
	}

	/**
	 * 内部自定义方法：4.查询最近浏览商品
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
					recentList.get(i).setModelImg(imgs[0]);// 显示第一张图片
				}
			}
		}
		return recentList;
	}

}
