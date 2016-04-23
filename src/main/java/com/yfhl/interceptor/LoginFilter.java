package com.yfhl.interceptor;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yfhl.common.Constants;
import com.yfhl.entity.User;
import com.yfhl.util.EncryptUtil;

public class LoginFilter implements Filter {

	ServletContext application;
	private List<String> creatiaPCPath;// PC端需要登录的页面集合
	private List<String> creatiaHPath;// 爱体验后台需要登录的页面集合

	// 初始化
	public void init(FilterConfig config) throws ServletException {
		application = config.getServletContext();
		creatiaPCPath = new ArrayList<String>();
		// creatiaPCPath.add("/login/gotoIndexPC.do");//登录注册
		creatiaPCPath.add("/modelShopping/cartList.do");// 购物车
		creatiaPCPath.add("/userAddressController/queryUserAddress.do");// 个人中心：收货地址
		creatiaPCPath.add("/userManage/gotoUserManagePC.do");// 个人中心：编辑信息
		creatiaPCPath.add("/modelCollectionController/queryList.do");// 个人中心：我的收藏
		creatiaPCPath.add("/tradeManage/queryListPC.do.do");// 个人中心：我的订单
		creatiaPCPath.add("/tradeManage/queryTradeDetailPC.do");// 个人中心：订单详情

		creatiaHPath = new ArrayList<String>();
		// creatiaHPath.add("/login/beforeLogin.do");//后台登录
		creatiaHPath.add("/login/index.do");// 后台主页
		creatiaHPath.add("/login/xinxi.do");// 后台首页
		creatiaHPath.add("/userManage/queryList.do");// 后台用户管理
		creatiaHPath.add("/designerApplyController/queryList.do");// 后台审批设计师
		creatiaHPath.add("/modelController/queryList.do");// 后台商品管理
		creatiaHPath.add("/categoryController/queryCategory.do");// 后台类目管理
		creatiaHPath.add("/tradeManage/queryList.do");// 后台订单管理
		creatiaHPath.add("/comment/queryList.do");// 后台评论管理
		creatiaHPath.add("/titleStore/adjust.do");// 后台数据统计
		creatiaHPath.add("/systemTools/selectDatabaseBackup.do");// 后台数据录备份
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		Cookie cookies[] = request.getCookies();
		String cookieValue = "";

		// 记录上次请求地址(如果是地址栏直接访问，则referer为null)，防止用户篡改访问地址，直接访问action
		String referer = request.getHeader("Referer");
		String path = request.getServletPath();// 访问地址
		String pathBuffer = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
		System.out.println("path:" + path + "  pathBuffer:" + pathBuffer);
//		if (pathBuffer.indexOf("/wx")>0)
//		{
//			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx78dd3c672db3c05f&redirect_uri="
//					+ pathBuffer
//					+ "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
//			System.out.println(url+"--------------------------------");
//			response.sendRedirect(url);
//		}
		// 验证参数是否含有非法标签字符
		// if (!validateRequest(request)) {
		// System.out.println("进入非法字符");
		// // 跳转到错误页面
		// response.sendRedirect(request.getContextPath()
		// + Constants.URL_UNSAFE_TAG);
		// } else {
		// (只拦截jsp页面)
		// Object obj = request.getSession().getAttribute("user");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("yfhlkj_user".equals(cookies[i].getName())) {
					cookieValue = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
			}
		}
		System.out.println("cookieValue:" + cookieValue);

		if ((cookieValue == "" || cookieValue == null)
				&& creatiaPCPath.contains(path)) {
			session.setAttribute("beforePath", path);
			System.out.println("进入：跳转到PC端登录页面beforePath:" + path);
			// 跳转到PC端登录页面
			response.sendRedirect(request.getContextPath()
					+ "/login/gotoIndexPC.do");
		} else if ((cookieValue == "" || cookieValue == null)
				&& creatiaHPath.contains(path)) {
			session.setAttribute("beforePath", path);
			// 跳转到后台登录页面
			response.sendRedirect(request.getContextPath()
					+ "/login/beforeLogin.do");
		} else {
			// if(cookieValue!="" && cookieValue != null){
			// //跳转到验证Cookie的Controller
			// response.sendRedirect(request.getContextPath()+
			// "/login/checkCookie.do?path="+path);
			//
			// //filterChain.doFilter(request, response);
			// }
			if (cookieValue != "" && cookieValue != null) {
			 
				try {
					cookieValue = EncryptUtil.base64Decoder(cookieValue);
					System.out.println("过滤器中的cookieValue:" + cookieValue);
					String[] array = cookieValue.split(";");
					if(creatiaHPath.contains(path) && Integer.parseInt(array[5])!=2){
						// 跳转到后台登录页面
						response.sendRedirect(request.getContextPath()
								+ "/login/beforeLogin.do");
					}else if(creatiaPCPath.contains(path) && Integer.parseInt(array[5])!=1){
						// 跳转到PC端登录页面
						response.sendRedirect(request.getContextPath()
								+ "/login/gotoIndexPC.do");
					}
					System.out.println("用户ID array[0]:" + array[0]);
					User user = new User();
					user.setUid(Integer.parseInt(array[0]));
					user.setUsername(array[1]);
					user.setEmail(array[2]);
					user.setShoppingCount(Integer.parseInt(array[3]));
					user.setAvatar(array[4]);
					
					
					System.out.println("过滤器中的用户信息" + user.toString());
					session.setAttribute("yfhl_user", user);// 将用户信息存入Session
					session.setAttribute("yfhl_userid", array[0]+"");// 将用户ID存入Session

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("解密后台的数据cookieValue：" + cookieValue);
			}

			filterChain.doFilter(request, response);
		}
		// }
	}

	/**
	 * 验证参数是否含有非法标签字符
	 * 
	 * @Description
	 * @param request
	 * @return
	 */
	@SuppressWarnings("all")
	public boolean validateRequest(HttpServletRequest request) {
		// 获得所有请求参数名
		Enumeration<String> params = request.getParameterNames();

		while (params.hasMoreElements()) {
			// 得到参数对应值
			String[] values = request.getParameterValues(params.nextElement());

			for (String value : values) {
				// 验证是否含有非法标签字符
				for (String tag : Constants.UNSAFE_TAGS) {
					if (value.toLowerCase().contains(tag)) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
