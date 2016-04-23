package com.yfhl.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfhl.entity.User;
import com.yfhl.service.CacheService;
import com.yfhl.service.TokenService;
import com.yfhl.service.UserService;
import com.yfhl.util.Sign;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年3月19日 上午12:24:05 类说明
 */
@Controller
@RequestMapping("3d")
public class WxFilterController {

	@Resource
	private UserService userService;

	@Resource
	private TokenService tokenService;

	@Resource
	private CacheService cacheService;

	@RequestMapping("wx")
	public String wx(HttpServletRequest request, HttpServletResponse response) {

		String path = request.getContextPath();
		String pathBuffer = request.getRequestURL().toString();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		String remoteAddress = request.getRemoteAddr();
		String servletPath = request.getServletPath();
		String realPath = request.getRealPath("/");
		String remoteUser = request.getRemoteUser();
		String requestURI = request.getRequestURI();

		System.out.println("path:" + path + "<br>");
		System.out.println("pathBuffer:" + pathBuffer + "<br>");
		System.out.println("basePath:" + basePath + "<br>");
		System.out.println("remoteAddr:" + remoteAddress + "<br>");
		System.out.println("servletPath:" + servletPath + "<br>");
		System.out.println("realPath:" + realPath + "<br>");
		System.out.println("remoteUser:" + remoteUser + "<br>");
		System.out.println("requestURI:" + requestURI + "<br>");

		String[] pathStr = pathBuffer.split("/wx");
		String httpPath = pathStr[0] + pathStr[1];
		String red = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0e81c3bee622d60&redirect_uri="
				+ httpPath
				+ "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		return "redirect:" + red;
	}

	@RequestMapping("yfhl")
	public String yfhl(HttpServletRequest request, User user, 
			HttpServletResponse response) {
		String pathBuffer = request.getRequestURL().toString();
		String openid = (String)request.getParameter("openid");
		String code = (String) request.getParameter("code");
		String state = (String) request.getParameter("state");
		String ticket = null;
		String acessToken = null;
		String refreshToken = null;
		/**
		 * 没有分享的时候用户自己进入
		 */
		if (code != null) {
			openid = this.tokenService.getAccessTokenByCode(code);
			acessToken = this.tokenService.getAcessToken();
			refreshToken = this.tokenService.getRefreshToken();
			/**
			 * 验证accessToken是否过期 正确的Json返回结果：{ "errcode":0,"errmsg":"ok"} true
			 * 是无过期 false是过期
			 */
			if (!this.tokenService.isAccessToken(acessToken, openid)) {
				/**
				 * 刷新获取的openid
				 */
				openid = this.tokenService.getRefreshToken(refreshToken);
				acessToken = this.tokenService.getAcessToken();

			}
			/**
			 * 微信授权后得到用户信息
			 */
			user = this.tokenService.getWeixinUser(acessToken, openid);
			user.setWxOpenid(openid);

			if (!user.equals(null)) {
				/**
				 * 获取完后在保存微信授权用户
				 */
				int falgUserinsert = this.userService.insertSelective(user);

			}
		}

		/**
		 * 根据用户id查出用户总信息
		 * 
		 */
		User u = this.userService.getUserByUid(user.getUid());

		// Video video = this.videoService.findVideoById(uid);
		// List<Tag> tagList = this.tagService.getTagListByUid(uid);
		//
		// int praiseCount = this.praiseService.getPraiseCount(video.getId());

		if (user != null) {
			// str = "redirect:/api/v1/campusambassador/users/resume";
			/***
			 * ticket appId 微信公众号的唯一标识 timestamp 微信生成签名的时间戳 nonceStr 微信生成签名的随机串
			 * signature 微信签名 jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VBdGdp
			 * -6Yp7aZYtIvNi0SvD_L6GCAZs_edqKvR6okCAUYAfu8_m9gNa
			 * -qj-Fux8Haw&noncestr =JBOPCYOSTPWX&timestamp=1428746372607
			 * &url=http
			 * ://192.168.1.110:8080/ishareme/campusambassador/users/resume
			 * ?uid=29070efe-7059-4c12-8279-7986030f8d81
			 * 
			 * @return
			 */

			/**
			 * @author home
			 * @param 1、先查看是否存在缓存 exist 是：true / 否：false
			 * @param （1）2、true——>查看缓存是否过期 isExpired 是：true / 否：false
			 * @param （2） true——>过期的话、刷新缓存、并设置缓存时间(单位：毫秒)：void refresh(String
			 *        key, T target); void setExpired(Long millsec);
			 * @param （3）false——>没有过期获取现有的缓存：T getCache(String key);
			 * @param （1）3、false——>没有存在缓存、刷新缓存、并设置缓存时间(单位：毫秒)：void
			 *        refresh(String key, T target); void setExpired(Long
			 *        millsec);
			 */
			Boolean exist = this.cacheService.exist("ticket");
			if (exist) {
				Boolean isExpired = this.cacheService.isExpired("ticket");
				if (isExpired) {
					ticket = this.tokenService.getTicketWeixin();
					this.cacheService.refresh("ticket", ticket);
					this.cacheService.setExpired(Long.valueOf(7200000));
				} else {
					ticket = (String) this.cacheService.getCache("ticket");
				}
			} else {
				ticket = this.tokenService.getTicketWeixin();
				this.cacheService.refresh("ticket", ticket);
				this.cacheService.setExpired(Long.valueOf(7200000));
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
			request.setAttribute("user", user);
			request.setAttribute("openid", openid);

			String[] pathStr = pathBuffer.split("/yfhl");
			String httpPath =  pathStr[1];
			return "redirect:/" + httpPath;

		} else {
			return "/error/businessException";
		}

	}

}
