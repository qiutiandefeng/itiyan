package com.yfhl.controller;

import java.io.IOException;
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

import com.yfhl.entity.Model;
import com.yfhl.entity.ModelShopping;
import com.yfhl.entity.ModelType;
import com.yfhl.entity.Recent;
import com.yfhl.entity.User;
import com.yfhl.entity.UserAddress;
import com.yfhl.service.ActivityService;
import com.yfhl.service.CheapCodeService;
import com.yfhl.service.ModelService;
import com.yfhl.service.ModelShoppingService;
import com.yfhl.service.ModelTypeService;
import com.yfhl.service.RecentService;
import com.yfhl.service.UserAddressService;
import com.yfhl.service.UserCodeService;
import com.yfhl.service.UserService;
import com.yfhl.util.EncryptUtil;
import com.yfhl.util.Md5Encrypt;

/**
 * 购物车Controller层
 * 
 * @author luans
 *
 */
@Controller
@RequestMapping("modelShopping")
public class ModelShoppingController {
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
	public RecentService recentService;// 注如最近浏览Service层实例

	@Resource
	public UserService userServiceImpl;// 注入用户Service层实例对象

	/**
	 * 购物车操作
	 * 
	 * @param modelShopping
	 * @return
	 * @author luans
	 * @throws Exception
	 */
	@RequestMapping("modelShopping")
	@ResponseBody
	public int modelShopping(HttpServletRequest request,
			HttpServletResponse response, ModelShopping modelShopping)
			throws Exception {
		System.out.println("购物车：" + modelShopping.toString());
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
		int result = 0;
		// 判断是否是之前已经存在的相同的购物车信息:如果有的话就把数量加1，否则的话就重新添加一条数据；
		result = modelShoppingService.updateShopping(modelShopping);
		if (result == 0) {
			result = modelShoppingService.insertSelective(modelShopping);
		}
		
		if (result > 0) {
			// 修改购物车信息后，修改Session和cookie中的值
			this.changeCookieSession(request, response, uid);

		}
		result=modelShoppingService.queryModelShoppingCount(uid);
		System.out.println("meihou zou");
		return result;
	}

	/**
	 * PC端：去购物车页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月19日
	 */
	@RequestMapping("cartList")
	private String getModelCartList(HttpServletRequest request,
			HttpServletResponse response) {

		// 判断用户是否登录
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		if (userid == "" || userid == null) {//
			try {
				response.sendRedirect(request.getContextPath()+ "/login/gotoIndexPC.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer uid = Integer.parseInt(userid);
		System.out.println("jin进入购物车的用户ID：" + uid);
		// User user = (User) session.getAttribute("user");
		// if(user==null){
		// return "pc/login";
		// }else{
		//
		// System.out.println("用户名："+user.getUsername());
		// System.out.println("密码："+user.getPwd());
		// }
		List<Model> modelList = new ArrayList<Model>();
		Integer count = 0;// 参数个数
		float countPrice = 0;// 小计
		float tatlePrice = 0;// 总价
		// Integer uid = Integer.valueOf(request.getParameter("uid"));
		List<Float> priceList = new ArrayList<Float>();
		ModelShopping modelShopping = new ModelShopping();
		ModelType modelType = new ModelType();// 商品详情信息
		if (uid == null) {
			request.setAttribute("msg", "参数异常");
			return "error/error";
		}
		Map<String, String> brandMap = new HashMap<String, String>();
		List<ModelShopping> modelCartList = modelShoppingService
				.getModelCartListByUserId(uid);
		for (int i = 0; i < modelCartList.size(); i++) {
			modelShopping = modelCartList.get(i);
			modelType = modelTypeService.queryModelByModelShopping(modelShopping);
			if (modelType == null) {
				// 商品失效
				System.out.println("商品失效:" + modelShopping.toString());
				modelShopping.setMarker_state(2);
			} else {
				modelShopping.setMarker_state(1);
			}
			Integer modelId = modelShopping.getMsModelid();

			Model model = modelService.getModelBymId(modelId);
			brandMap.put(model.getBrand(), model.getBrand());
			modelList.add(model);
			// 算单价和小计
			count = modelShopping.getMsModcount();
			countPrice = count * modelShopping.getMsModprice();
			priceList.add(countPrice);
			tatlePrice = tatlePrice + countPrice;

		}
		// 查询最近浏览商品
		List<Recent> recentList = new ArrayList<Recent>();
		if (uid != 0) {
			recentList = recentModel(uid);
		}
		request.setAttribute("brandMap", brandMap);
		request.setAttribute("tatlePrice", tatlePrice);
		request.setAttribute("modelCartList", modelCartList);
		request.setAttribute("recentList", recentList);
		request.setAttribute("modelList", modelList);
		request.setAttribute("priceList", priceList);

		return "pc/modelcart/cart";
	}

	/**
	 * 点击减少、增加改变商品数量
	 * 
	 * @param request
	 * @param response
	 * @return Map
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月5日
	 */
	@RequestMapping("cartChange")
	@ResponseBody
	public Map<Object, Object> cartReduce(HttpServletRequest request,
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
		System.out
				.println("mShopping.toString()_luans:" + mShopping.toString());
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
	 * 购物车 删除
	 * 
	 * @param request
	 * @param response
	 * @return JSON
	 * @author Chris li Email:lj520212@gmail.com
	 * @throws Exception 
	 * @date 2016年1月9日
	 */
	@RequestMapping("cartDel")
	@ResponseBody
	public Map<Object, Object> cartDel(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<String> body = new ArrayList<String>();
		int flag = 0;
		String msIds = request.getParameter("msId");
		if ("".equals(msIds) || msIds == null) {
			map.put("state", 0);
			map.put("value", "参数异常");
			map.put("body", new ArrayList<String>());
			return map;
		}

		String[] ms = msIds.split(";");
		for (int i = 0; i < ms.length; i++) {

			Integer msId = Integer.valueOf(ms[i]);
			flag = modelShoppingService.deleteByPrimaryKey(msId);
		}
		if (flag == 0) {
			map.put("state", 0);
			map.put("body", new ArrayList<String>());
			map.put("value", "删除失败");
			return map;
		} else {
			map.put("state", 1);
			map.put("body", new ArrayList<String>());
			map.put("value", "删除成功");
			// 修改购物车信息后，修改Session和cookie中的值
			this.changeCookieSession(request, response, uid);
		}
		return map;
	}

	/**
	 * 购物车——>结算
	 * 
	 * @param request
	 * @param response
	 * @return String
	 * @author Chris li Email:lj520212@gmail.com
	 * @date 2016年1月13日
	 */
	@RequestMapping("settleCountByShopping")
	public String settleCountByShopping(HttpServletRequest request,
			HttpServletResponse response) {
		String str = "pc/modelcart/orders";
		String marker_use = "no";// 是否有商品失效
		Integer uid = Integer.valueOf(request.getParameter("uid"));
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
		// 有效的优惠券
		// List<UserCode> userCodeList =
		// userCodeService.getUserCodeListByUid(uid);
		// List<CheapCode> cheapCodeList = new ArrayList<CheapCode>();
		// for (int k = 0; k < userCodeList.size(); k++) {
		// UserCode userCode = userCodeList.get(k);
		// // 有效的活动
		// Activity activity = activityService.getActivityByActivityIdAndTime(
		// userCode.getActivityId(), new Date());
		// // 有效活动中的优惠券
		// CheapCode cheapCode = cheapCodeService
		// .getCheapCodeByActivityId(activity.getId());
		// cheapCodeList.add(cheapCode);
		// }
		// 有失效的商品
		if (marker_use.equals("yes")) {
			System.out.println("有商品失效");
			// 查询最近浏览商品
			List<Recent> recentList = new ArrayList<Recent>();
			if (uid != 0) {
				recentList = this.recentModel(uid);
			}
			request.setAttribute("recentList", recentList);
			str = "error/error_modelfailure";

		} else {
			request.setAttribute("modelCartList", modelCartList);
			request.setAttribute("brandMap", brandMap);
			// request.setAttribute("cheapCodeList", cheapCodeList);
			request.setAttribute("userAddressList", userAddressList);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("totaltransportPrice", totaltransportPrice);
			request.setAttribute("priceList", priceList);
			request.setAttribute("transportPriceList", transportPriceList);
		}
		return str;
	}

	/**
	 * 商品详情(立即购买)——>结算
	 * 
	 * @param ModelShopping
	 * @return ModelAndView
	 * @author luans
	 * @date 2016年3月4日
	 */
	@RequestMapping("settleCountByDetail")
	public ModelAndView settleCountByDetail(HttpServletResponse response,
			HttpServletRequest request, ModelShopping modelShopping) {
		// 从Session中获取用户id
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("yfhl_userid");
		int uid = 0;
		if (userid != null && !"".equals(userid)) {
			uid = Integer.parseInt(userid);
		}
		System.out.println("立即购买：" + modelShopping.toString());
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

		// 有效的优惠券
		// List<UserCode> userCodeList = userCodeService
		// .getUserCodeListByUid(modelShopping.getMsUid());
		// List<CheapCode> cheapCodeList = new ArrayList<CheapCode>();
		// for (int k = 0; k < userCodeList.size(); k++) {
		// UserCode userCode = userCodeList.get(k);
		// // 有效的活动
		// Activity activity = activityService.getActivityByActivityIdAndTime(
		// userCode.getActivityId(), new Date());
		// // 有效活动中的优惠券
		// CheapCode cheapCode = cheapCodeService
		// .getCheapCodeByActivityId(activity.getId());
		// cheapCodeList.add(cheapCode);
		// }
		// 有失效的商品
		if (marker_use.equals("yes")) {
			System.out.println("有商品失效");
			// 查询最近浏览商品
			List<Recent> recentList = new ArrayList<Recent>();
			if (uid != 0) {
				recentList = this.recentModel(uid);
			}
			mv.addObject("recentList", recentList);
			mv.setViewName("error/error_modelfailure");

		} else {
			mv.addObject("modelCartList", modelCartList);
			mv.addObject("brandMap", brandMap);
			// mv.addObject("cheapCodeList", cheapCodeList);
			mv.addObject("userAddressList", userAddressList);
			mv.addObject("totalPrice", totalPrice);
			mv.addObject("totaltransportPrice", totaltransportPrice);
			mv.addObject("priceList", priceList);
			mv.addObject("transportPriceList", transportPriceList);
			mv.setViewName("pc/modelcart/orders");
		}
		return mv;
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
	 * 用户自定义方法：3.修改购物车信息后，修改Session和cookie中的值
	 * 
	 * @param userid
	 * @return String
	 * @throws Exception
	 * @date 2016年3月27日
	 * @auther luans
	 */
	public void changeCookieSession(HttpServletRequest request,
			HttpServletResponse response, Integer uid) throws Exception {
		User user = new User();
		user.setUid(uid);
		int shoppingCount = modelShoppingService.queryModelShoppingCount(uid);
		user = userServiceImpl.queryUser(user);// 重新查询用户信息
		user.setShoppingCount(shoppingCount);
		user.setPwd("");
		// 清除session
		request.getSession().invalidate();
		// 重新添加session
		HttpSession session2 = request.getSession();
		session2.setAttribute("yfhl_user", user);
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
}
