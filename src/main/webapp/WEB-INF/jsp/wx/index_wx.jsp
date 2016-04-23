<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link rel="stylesheet" href="<%=path%>/css/wx/swiper.3.1.7.min.css" />
<link rel="stylesheet" href="<%=path%>/css/wx/index.css" />
<script type="text/javascript" src="<%=path%>/js/wx/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/index.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/swiper.3.1.7.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/wx/index.js"></script>

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
              desc : "www.3dcreatia.com",
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
                desc : "www.3dcreatia.com",
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


</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：头部（部分统一）
        -->
	<div class="heads">
		<div class="head" onclick="gotoShopping()">
			<a href="###"><img src="../images/wx/005.png" /></a>
			<div>
				<a href="###"><span>${yfhl_user.shoppingCount}</span></a>
			</div>
			
		</div>
	</div>
	<div class="swiper-container swiper-container1">
		<div class="swiper-wrapper">
		   <c:forEach items="${bannerList}" var="banner" >
			<div class="swiper-slide">
				<img src="/upload/uploadImg/banner/${banner.banImgurl}" />
			</div>
		</c:forEach>
		</div>
		<div class="swiper-pagination"></div>
	</div>
	<div class="index_div1">
		<img src="../images/wx/031.png" />
	</div>
	<div class="index_div2">
		<p class="index_div2_p1">[隐世的文艺范，神秘在开放]</p>
		<p class="index_div2_p2">
			September<span>14,2015</span>
		</p>
	</div>
	<div class="swiper-container swiper-container2">
		<div class="swiper-wrapper">
			<c:forEach items="${modelList1}" var="model1">
				<div class="swiper-slide" onclick="onClickModel('${model1.mid}')">
					<img src="/upload/uploadImg/model/${model1.img}" />
					<div class="divs">
						<img src="../images/wx/012.gif" /> <span>${model1.favoriteNum}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="index_div3">
		<p class="index_div3_p1">[隐世的文艺范，神秘在开放]</p>
		<p class="index_div3_p2">
			September<span>14,2015</span>
		</p>
	</div>
	<div class="swiper-container swiper-container3">
		<div class="swiper-wrapper">
			<c:forEach items="${modelList2}" var="model2">
				<div class="swiper-slide" onclick="onClickModel('${model2.mid}')">
					<img src="/upload/uploadImg/model/${model2.img}" />
					<div class="divs">
						<img src="../images/wx/012.gif" /> <span>${model2.favoriteNum}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="index_div4">
		<p class="index_div4_p1">[隐世的文艺范，神秘在开放]</p>
		<p class="index_div4_p2">
			September<span>14,2015</span>
		</p>
	</div>
	<div class="swiper-container swiper-container4">
		<div class="swiper-wrapper">
			<c:forEach items="${modelList3}" var="model3">
				<div class="swiper-slide" onclick="onClickModel('${model3.mid}')">
					<img src="/upload/uploadImg/model/${model3.img}" />
					<div class="divs">
						<img src="../images/wx/012.gif" /> <span>${model3.favoriteNum}</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：底部（绝对定位）
        -->
	<div class="tianchong"></div>
	<div class="bottom">
		<div class="bottom_div1">
			<img src="../images/wx/055.png" onclick="onClickFenlei()" />
		</div>
		<div class="bottom_div2">
			<img src="../images/wx/054.png" />
		</div>
		<div class="bottom_div3">
			<img src="../images/wx/057.png"  onclick="gotoMytreade()"/>
		</div>
	</div>
	<img class="imgTop" src="../images/wx/035.gif" />

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
	//去首页
	function gotoFirstPage(){
		window.location.href="/3dcreatia/wxModel/wxgotoModelIndex.do";
	}
	//去我的订单页
	function gotoMytreade(){
		window.location.href="/3dcreatia/wxtrade/wxtradeList.do";
	}

</script>
</html>
