<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.yfhl.entity.*"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>爱体验网</title>

<link rel="stylesheet" href="<%=path%>/css/wx/shangpinliebiao.css" />
<script type="text/javascript" src="<%=path%>/js/wx/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/shangpinliebiao.js"></script>
<!-- 微信 -->
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	
<%
	String appid = (String)request.getAttribute("appId");
	String timestamp = (String)request.getAttribute("timestamp");
	String nonceStr = (String)request.getAttribute("nonceStr");
	String signature = (String)request.getAttribute("signature");
%>
<!-- 微信分享接口 -->
<script type="text/javascript">

//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx66f9db2c0482ac07&redirect_uri=http://aishaimi.cn/campusambassador/users/share?uid=dbe22b1a-77e6-4f45-9872-f6e5248fdc17&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
     	var uurl = location.href.split('#')[0];
     	var appId = '<%= appid%>';
     	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+uurl+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
     	var timestamp = '<%= timestamp%>';
     	var nonceStr = '<%= nonceStr%>';
     	var signature = '<%= signature%>';
     	var imgUrl = 'http://javali.cn/3dcreatia/images/pc/051.gif';
     	
     	//alert(timestamp+","+nonceStr+","+signature+","+appId);
         //微信权限设置
		wx.config({
		    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		    appId:  appId, // 必填，公众号的唯一标识<>
		    timestamp: timestamp, // 必填，生成签名的时间戳
		    nonceStr: nonceStr, // 必填，生成签名的随机串
		    signature: signature,// 必填，签名，见附录1
		    jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage'] // 必填，需要使,用的JS接口列表，所有JS接口列表见附录2
		});
         // 开启Api的debug模式
         //WeixinApi.enableDebugMode();
         
         wx.ready(function(){
         	//alert("微信开始");
         	
         	//分享给朋友圈
            wx.onMenuShareTimeline({
              imgUrl :imgUrl,
              link : url,
              title : '爱体验网',
              desc : "一起嗨起来~~~",
              type :"link",
               success: function () { 
                    // 用户确认分享后执行的回调函数
                    alert("分享成功");
                },
                cancel: function () { 
                    // 用户取消分享后执行的回调函数
                    alert("分享失败");
                }
            });
          //分享给好友
            wx.onMenuShareAppMessage({
            	title : '爱体验网',
                desc : "一起嗨起来~~~",
                link: url, // 分享链接
                imgUrl: imgUrl, // 分享图标
                type: 'link', // 分享类型,music、video或link，不填默认为link
                success: function () { 
                    // 用户确认分享后执行的回调函数
                	alert("分享成功");
                },
                cancel: function () { 
                    // 用户取消分享后执行的回调函数
                	alert("分享失败");
                }
            });
            
         	
         });
         
         wx.error(function(res){
        	 
        	 alert("微信失败:" + res);
         });
         
</script>

<script type="text/javascript">
		//去商品详情页
			function onClickModel(mid){
					window.location.href= "<%=path%>/wxModel/wxmodelDetails.do?mid="+mid;
			}
		//去分类页面
			function onClickFenlei(){
				window.location.href= "<%=path%>/wxModelCategory/wxlist.do";
	}
	//去购物车
	function gotoShopping() {
		window.location.href = "<%=path%>/wxModelShoppingController/wxGetModelCartList.do";
	}
</script>
<link rel="stylesheet" href="/3dcreatia/css/wx/shangpinliebiao.css" />
<script type="text/javascript" src="/3dcreatia/js/wx/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/3dcreatia/js/wx/shangpinliebiao.js"></script>

</head>
<body>
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：头部（部分统一）
        -->
	<div class="heads">
		<div class="head">
			<img class="heads_img1" src="/3dcreatia/images/wx/044.png"
				onclick="onClickFenlei()" /> <img src="/3dcreatia/images/wx/005.png"
				onclick="gotoShopping()" />
			<div>
				<span>${yfhl_user.shoppingCount}</span>
			</div>
		</div>
	</div>
	<div class="head_head">${category.title}</div>

	<div class="navs">
		<div class="navs_div1">
			<a class="blue_a1"
				href="/3dcreatia/wxModelCategory/wxMClist.do?condition_categoryid=${category.categoryId}">最新</a>
			<a
				href="/3dcreatia/wxModelCategory/wxMClist.do?condition_categoryid=${category.categoryId}">被摸最多</a>
		</div>
		<div class="clearBoth"></div>
	</div>
	<!--
        	作者：offline
        	时间：2016-02-18
        	描述：商品列表
        -->
	<div class="list">
		<div class="list_div1">·让首饰变成你的形象名片·</div>
		<c:forEach items="${modelList}" var="model" varStatus="i">
			<c:if test="${(i.index+1)%5 == 0}">
				<dl class="dlFive">
					<dt>
						<img src="/upload/uploadImg/model/${model.img}"
							onclick="onClickModel('${model.mid}')" />
						<div class="dt_div1">
							<img src="/3dcreatia/images/wx/012.gif" /><span>${model.favoriteNum}</span>
						</div>
					</dt>
					<dd>
						<p class="p1" onclick="onClickModel('${model.mid}')">${model.title}</p>
						<p class="p2">
							<span class="spn1">￥<span>${model.price}</span></span> <span
								class="spn2">· <span>${model.designerName}</span></span>
						</p>
					</dd>
				</dl>
			</c:if>
			<c:if test="${(i.index+1)%5 != 0}">
				<dl>
					<dt>
						<img src="/upload/uploadImg/model/${model.img}"
							onclick="onClickModel('${model.mid}')" />
						<div class="dt_div1">
							<img src="/3dcreatia/images/wx/012.gif" /><span>${model.favoriteNum}</span>
						</div>
					</dt>
					<dd>
						<p class="p1" onclick="onClickModel('${model.mid}')">${model.title}</p>
						<p class="p2">
							<span class="spn1">￥<span>${model.price}</span></span> <span
								class="spn2">· <span>${model.designerName}</span></span>
						</p>
					</dd>
				</dl>
			</c:if>

		</c:forEach>

		<div class="clearBoth"></div>

	</div>
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：底部（绝对定位）
        -->

</body>
<script type="text/javascript">
		//去商品详情页
			function onClickModel(mid){
					window.location.href= "/3dcreatia/wxModel/wxmodelDetails.do?mid="+mid;
			}
		//去分类页面
			function onClickFenlei(){
				window.location.href= "/3dcreatia/wxModelCategory/wxlist.do";
	}
	//去购物车
	function gotoShopping() {
		window.location.href = "/3dcreatia/wxModelShoppingController/wxGetModelCartList.do";
	}
</script>
</html>
