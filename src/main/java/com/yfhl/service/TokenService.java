package com.yfhl.service;

import com.yfhl.entity.User;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年3月18日 下午9:35:30
 * 类说明
 */
public interface TokenService {
	/**
     * 获取微信中的Accesstoken
     */
    public String getAccesstokenWeixin();
    
    /**
     * 获取微信中的AppId
     */
    public String getAppIdWeixin();
    
    /**
     * 获取微信中的Ticket
     */
    public String getTicketWeixin();
    
    /**
     * 微信中的getAccessTokenByCode
     */
    public String getAccessTokenByCode(String code);
    
    /**
     * 微信中的getAccessToken
     */
    public String getAcessToken();
    
    /**
     * 微信中的refreshToken
     */
    public String getRefreshToken();
    
    /**
     * 过期后再次刷新获取Token
     */
    public String getRefreshToken(String refreshToken);
    
    /**
     * 判断微信中的AccessToken是否过期
     */
    public boolean isAccessToken(String accesstoken,String openid);
    
    /**
     * 获取微信用户基本信息
     */
    public User getWeixinUser(String acessToken,String openid);
}
