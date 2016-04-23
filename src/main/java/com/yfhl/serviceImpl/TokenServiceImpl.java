package com.yfhl.serviceImpl;

import org.json.JSONException;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yfhl.entity.User;
import com.yfhl.service.CacheService;
import com.yfhl.service.TokenService;

/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2016年3月18日 下午9:36:27
 * 类说明
 */
@Transactional
@Service
public class TokenServiceImpl implements TokenService {

	 public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";// 获取微信token
	    public static final String GET_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";// 获取微信ticket
	    public static final String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";// 获取微信AccessToken
	    public static final String GET_REFRESHTOKEN_URL = "https://api.weixin.qq.com/sns/auth";//判断AccessToken是否过期
	    public static final String GET_REFRESHACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";//AccessToken过期后二次刷新获取
	    public static final String GET_WEIXINUSER_URL = "https://api.weixin.qq.com/sns/userinfo";//授权后获取微信用户的信息
	    
	    public static final String APPID = "wx78dd3c672db3c05f";
	    public static final String APPSECRET = "af211897af7c6b11421cbcd878a86b38";
	    
	    public String acessToken = null;
	    
	    public String refreshToken = null;
	    
	    
	    @SuppressWarnings("rawtypes")
		@javax.annotation.Resource
	    private CacheService cache;
	    
	    
	    /**
	     * http获取链接的微信token https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx66f9db2c0482ac07&secret=65ca953d4be1fec425b18fbe5dd49f96
	     * 返回的比如：
	     * {"access_token":"gGx_UmusM6Z-39peyxUfmQF4kf3XD828FcNUzW_RZyOQihRZ_2Zs9fS4wPLcR1TLSWSbgKgGVz2ZYep93MC2bsS7tKKx6rpji_s_3yTkdGc","expires_in":7200}
	     */
	    public String getTokenUrlWeixin()
	    {
	    	return "https://api.weixin.qq.com/cgi-bin/token";
	    }
	    
	    /**
	     * https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=gGx_UmusM6Z-39peyxUfmQF4kf3XD828FcNUzW_RZyOQihRZ_2Zs9fS4wPLcR1TLSWSbgKgGVz2ZYep93MC2bsS7tKKx6rpji_s_3yTkdGc&type=jsapi
	     *返回的是：
	     *{"errcode":0,"errmsg":"ok","ticket":"sM4AOVdWfPE4DxkXGEs8VBdGdp-6Yp7aZYtIvNi0SvC5-49Z8t-Yzz3-CQnVNMPtSofP0d1whFMWkFCx1k0VGg","expires_in":7200}
	     */
	    public String getTicketUrlWeixin()
	    {
	    	return "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	    }
	    
	    /**
	     * 微信的一个APPid
	     */
	    public String getAppIdWeixin()
	    {
	    	return "wx78dd3c672db3c05f";
	    }
	    
	    /**
	     * 微信的secret
	     */
	    public String gatSecretWeixin()
	    {
	    	return "af211897af7c6b11421cbcd878a86b38";
	    }
	    
	    /**
	     * 获取微信中的Accesstoken:Nk6MLCrf6DZ9C8Xb34t_p0fYL5lM1T5tJVG2BCUegcLEvUPS25zbvC8x0QT-HEn-hKz8AKdhEm_17OymSaA_v8PkYfOJETSaBJq-9RFLqpk
	     */
	    public String getAccesstokenWeixin()
	    {
	        String appId = this.getAppIdWeixin();
	        String secret = this.gatSecretWeixin();
	        String tokenUrl = this.getTokenUrlWeixin();
	        String accessToken = getTokenWeixin(tokenUrl, appId, secret);
	        
	        return accessToken;
	    }
	    
	    
	    /**
	     * 微信分享——请求一个HTTP协议、返回的json数据获取Token
	     */
	    private String getTokenWeixin(String apiurl, String appid, String secret)
	    {
	        
	        String turl = String.format(
	            "%s?grant_type=client_credential&appid=%s&secret=%s", apiurl,
	            appid, secret);
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(turl);
	        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	        String result = null;
	        try
	        {
	            HttpResponse res = client.execute(get);
	            String responseContent = null; // 响应内容
	            HttpEntity entity = res.getEntity();
	            responseContent = EntityUtils.toString(entity, "UTF-8");
	            JsonObject json = jsonparer.parse(responseContent)
	                .getAsJsonObject();
	            // 将json字符串转换为json对象
	            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	            {
	            	//
	                if (json.get("errmsg") != null)
	                {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	                }
	                else
	                {// 正常情况下{"access_token":"ACCESS_TOKEN","expires_in":7200}
	                    result = json.get("access_token").getAsString();
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            // 关闭连接 ,释放资源
	            client.getConnectionManager().shutdown();
	            return result;
	        }
	    }
	    
	    /**
	     * 获取微信的Ticket
	     */
	    public String getTicketWeixin()
	    {
	    	String token = null;
	    	Boolean exist = this.cache.exist("token");
			if (exist)
			{
				Boolean isExpired = this.cache.isExpired("token");
				if (isExpired)
				{
					token = this.getAccesstokenWeixin();
					this.cache.refresh("token", token);
					this.cache.setExpired(Long.valueOf(7200000));
				}
				else
				{
					token = (String)this.cache.getCache("token");
				}
			}
			else
			{
				token = this.getAccesstokenWeixin();
				this.cache.refresh("token", token);
				this.cache.setExpired(Long.valueOf(7200000));
			}
	        String ticketUrl = this.getTicketUrlWeixin();
	        String ticket = getTicket(ticketUrl,token);
	        
	        return ticket;
	    }
	    
	    /**
	     * 请求一个HTTP协议、返回的json数据获取Ticket：
	     */
	    private String getTicket(String apiurl, String token)
	    {
	        
	        String turl = String.format(
	            "%s?access_token=%s&type=jsapi", apiurl,token);
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(turl);
	        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	        String result = null;
	        try
	        {
	            HttpResponse res = client.execute(get);
	            String responseContent = null; // 响应内容
	            HttpEntity entity = res.getEntity();
	            responseContent = EntityUtils.toString(entity, "UTF-8");
	            JsonObject json = jsonparer.parse(responseContent)
	                .getAsJsonObject();
	            // 将json字符串转换为json对象
	            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	            {
	            	//{"errcode":0,"errmsg":"ok","ticket":"sM4AOVdWfPE4DxkXGEs8VBdGdp-6Yp7aZYtIvNi0SvC5-49Z8t-Yzz3-CQnVNMPtSofP0d1whFMWkFCx1k0VGg","expires_in":7200}
	                if (json.get("errmsg").equals("no"))
	                {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	                }
	                else
	                {// 正常情况下{"ticket":"ticket","expires_in":7200}
	                    result = json.get("ticket").getAsString();
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            // 关闭连接 ,释放资源
	            client.getConnectionManager().shutdown();
	            return result;
	        }
	    }
	    
	    /**
	     * 获取微信中的getAccessTokenByCode
	     */
	    public String getAccessTokenByCode(String code)
	    {
	        String openid = null;
	        String appid = this.getAppIdWeixin();
	        String secret = this.gatSecretWeixin();
	        openid = this.getAccessToken(GET_ACCESSTOKEN_URL,appid,secret,code);
	        return openid;
	    }
	   
	    /**
	     * 请求一个HTTP协议、返回的json数据获取AccessToken：
	     */
	    private String getAccessToken(String apiurl,String appid,String secret, String code)
	    {
	        
	        String turl = String.format(
	            "%s?appid=%s&secret=%s&code=%s&grant_type=authorization_code", apiurl,appid,secret,code);
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(turl);
	        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	        String result = null;
	        try
	        {
	            HttpResponse res = client.execute(get);
	            String responseContent = null; // 响应内容
	            HttpEntity entity = res.getEntity();
	            responseContent = EntityUtils.toString(entity, "UTF-8");
	            JsonObject json = jsonparer.parse(responseContent)
	                .getAsJsonObject();
	            // 将json字符串转换为json对象
	            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	            {
	                //{"errcode":0,"errmsg":"ok","ticket":"sM4AOVdWfPE4DxkXGEs8VBdGdp-6Yp7aZYtIvNi0SvC5-49Z8t-Yzz3-CQnVNMPtSofP0d1whFMWkFCx1k0VGg","expires_in":7200}
	                if (json.get("openid").getAsString() != "")
	                {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	                    result = json.get("openid").getAsString();
	                    this.setAcessToken(json.get("access_token").getAsString());
	                    this.setRefreshToken(json.get("refresh_token").getAsString());
	                }
	                else
	                {// 正常情况下{"ticket":"ticket","expires_in":7200}
	                    json.get("errcode").getAsString();
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            // 关闭连接 ,释放资源
	            client.getConnectionManager().shutdown();
	            return result;
	        }
	    }
	    
	    /**
	     * 判断AccessToken是否过期
	     * true false
	     */
	    public boolean isAccessToken(String accesstoken, String openid)
	    {
	        return this.isAccessToken(GET_REFRESHTOKEN_URL,accesstoken,openid);
	    }
	    
	    /**
	     * 请求一个HTTP协议、返回的json数据获取AccessToken：
	     */
	    private boolean isAccessToken(String apiurl,String accesstoken, String openid)
	    {
	        
	        String turl = String.format(
	            "%s?access_token=%s&openid=%s", apiurl,accesstoken,openid);
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(turl);
	        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	        boolean result = false;
	        try
	        {
	            HttpResponse res = client.execute(get);
	            String responseContent = null; // 响应内容
	            HttpEntity entity = res.getEntity();
	            responseContent = EntityUtils.toString(entity, "UTF-8");
	            JsonObject json = jsonparer.parse(responseContent)
	                .getAsJsonObject();
	            // 将json字符串转换为json对象
	            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	            {
	                //{"errcode":0,"errmsg":"ok","ticket":"sM4AOVdWfPE4DxkXGEs8VBdGdp-6Yp7aZYtIvNi0SvC5-49Z8t-Yzz3-CQnVNMPtSofP0d1whFMWkFCx1k0VGg","expires_in":7200}
	                if (json.get("errcode").equals("40003"))
	                {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	                    result = false;
	                }
	                else
	                {// 正常情况下{"ticket":"ticket","expires_in":7200}
	                    result = true;
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            // 关闭连接 ,释放资源
	            client.getConnectionManager().shutdown();
	            return result;
	        }
	    }
	    
	    /**
	     * 过期后再次刷新
	     */
	    public String getRefreshToken(String refreshToken)
	    {
	        String openid = null;
	        String appid = this.getAppIdWeixin();
	        openid = this.getRefreshAccessToken(GET_REFRESHACCESSTOKEN_URL,appid,refreshToken);
	        return openid;
	    }
	    
	    /**
	     * 请求一个HTTP协议、返回的json数据获取AccessToken：
	     */
	    private String getRefreshAccessToken(String apiurl,String appid,String refreshToken)
	    {
	        
	        String turl = String.format(
	            "%s?appid=%s&grant_type=refresh_token&refresh_token=%s", apiurl,appid,refreshToken);
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(turl);
	        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	        String result = null;
	        try
	        {
	            HttpResponse res = client.execute(get);
	            String responseContent = null; // 响应内容
	            HttpEntity entity = res.getEntity();
	            responseContent = EntityUtils.toString(entity, "UTF-8");
	            JsonObject json = jsonparer.parse(responseContent)
	                .getAsJsonObject();
	            // 将json字符串转换为json对象
	            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	            {
	                //{"errcode":0,"errmsg":"ok","ticket":"sM4AOVdWfPE4DxkXGEs8VBdGdp-6Yp7aZYtIvNi0SvC5-49Z8t-Yzz3-CQnVNMPtSofP0d1whFMWkFCx1k0VGg","expires_in":7200}
	                if (json.get("errcode").equals("40029"))
	                {// 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	                }
	                else
	                {// 正常情况下{"ticket":"ticket","expires_in":7200}
	                    result = json.get("openid").getAsString();
	                    this.setAcessToken(json.get("access_token").getAsString());
	                    this.setRefreshToken(json.get("refresh_token").getAsString());
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            // 关闭连接 ,释放资源
	            client.getConnectionManager().shutdown();
	            return result;
	        }
	    }
	    
	    
	    /**
	     * 微信用户授权后获取用户的信息
	     */
	    public User getWeixinUser(String acessToken, String openid)
	    {
	        
	        return this.getWeixinUser(GET_WEIXINUSER_URL, acessToken, openid);
	    }
	    
	    /**
	     * 请求一个HTTP协议、返回的json数据获取AccessToken：
	     */
	    private User getWeixinUser(String apiurl,String acessToken,String openid)
	    {
	        
	        String turl = String.format(
	            "%s?access_token=%s&openid=%s&lang=zh_CN", apiurl,acessToken,openid);
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpGet get = new HttpGet(turl);
	        JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
	        User result = new User();
	        try
	        {
	            HttpResponse res = client.execute(get);
	            String responseContent = null; // 响应内容
	            HttpEntity entity = res.getEntity();
	            responseContent = EntityUtils.toString(entity, "UTF-8");
	            JsonObject json = jsonparer.parse(responseContent)
	                .getAsJsonObject();
	            // 将json字符串转换为json对象
	            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
	            {
	             // 正常情况下{"ticket":"ticket","expires_in":7200}
	                if (json.get("openid").getAsString() != "")
	                {
	                    result.setWxOpenid(json.get("openid").getAsString());
	                    result.setUsername(json.get("nickname").getAsString());
	                    result.setCity(json.get("city").getAsString());
//	                    result.setCountry(json.get("country").getAsString());
	                    result.setAvatar(json.get("headimgurl").getAsString());
	                    result.setProvince(json.get("province").getAsString());
	                    result.setSex(Integer.valueOf(json.get("sex").getAsString()));
	                    result.setWxUnionid(json.get("unionid").getAsString());
//	                    JSONArray ja = new JSONArray(json.get("privilege"));
//	                    if(ja.length() != 0)
//	                    {
//	                        String str = "";
//	                        for (int i=0;i<ja.length();i++)
//	                        {
//	                            str += ja.get(i);
//	                        }
//	                        result.setPrivilege(str);
//	                    }
	                }
	                else
	                {
	                  //{"errcode":0,"errmsg":"ok","ticket":"sM4AOVdWfPE4DxkXGEs8VBdGdp-6Yp7aZYtIvNi0SvC5-49Z8t-Yzz3-CQnVNMPtSofP0d1whFMWkFCx1k0VGg","expires_in":7200}
	                    // 错误时微信会返回错误码等信息，{"errcode":40013,"errmsg":"invalid appid"}
	                    
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            // 关闭连接 ,释放资源
	            client.getConnectionManager().shutdown();
	            return result;
	        }
	    }
	    
	    
	    public String getAcessToken()
	    {
	        return acessToken;
	    }
	    public void setAcessToken(String acessToken)
	    {
	        this.acessToken = acessToken;
	    }
	    
	    public String getRefreshToken()
	    {
	        return refreshToken;
	    }
	    public void setRefreshToken(String refreshToken)
	    {
	        this.refreshToken = refreshToken;
	    }
    
}
