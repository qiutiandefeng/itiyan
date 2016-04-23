<%@ page language="java" import="java.util.*,com.yfhl.entity.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<title>3DCREATIA/分类</title>
<link rel="stylesheet" href="<%=path%>/css/wx/fenlei.css" />
<!-- 微信 -->
<script type="text/javascript"
	src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<%
	List<Category> modelList = (List<Category>)request.getAttribute("categoryList");
// 	String modelUrl = modelList.get(0).get;
	String appid = (String)request.getAttribute("appId");
	String timestamp = (String)request.getAttribute("timestamp");
	String nonceStr = (String)request.getAttribute("nonceStr");
	String signature = (String)request.getAttribute("signature");
%>
<!-- 微信分享接口 -->
<script type="text/javascript">

//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx66f9db2c0482ac07&redirect_uri=http://aishaimi.cn/campusambassador/users/share?uid=dbe22b1a-77e6-4f45-9872-f6e5248fdc17&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
     	var uurl = location.href.split('#')[0];
     	var appId = '<%=appid%>';
     	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appId+"&redirect_uri="+uurl+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
     	var timestamp = '<%=timestamp%>';
     	var nonceStr = '<%=nonceStr%>';
     	var signature = '<%=signature%>';
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
    //去分类下的商品列表页
    function onClickModelCategory(categoryId){
			 window.location.href= "<%=path%>/wxModelCategory/wxMClist.do?condition_categoryid="+categoryId;
	}
    //页面底部去分类页面
	function onClickFenlei(){
		     window.location.href= "<%=path%>/wxModelCategory/wxlist.do";
	}
	//去购物车
	function gotoShopping() {
		window.location.href = "<%=path%>/wxModelShoppingController/wxGetModelCartList.do";
	}
	// 分类搜索
	function sel_category() {
		$("#sform").submit();
	}
	//去首页
	function gotoFirstPage() {
		window.location.href = "<%=path%>/wxModel/wxgotoModelIndex.do";
	}
	//去我的订单页
	function gotoMytreade() {
		window.location.href = "<%=path%>/wxtrade/wxtradeList.do";
	}
</script>

<link rel="stylesheet" href="/3dcreatia/css/wx/fenlei.css" />

</head>
<body>
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：头部（部分统一）
        -->
	<div class="heads">
		<div class="head" onclick="gotoShopping()">
			<a href="###"><img src="<%=path%>/images/wx/005.png" /></a>

			<div>
				<a href="###"><span>${yfhl_user.shoppingCount}</span></a>
			</div>
		</div>
	</div>
	<div class="head_head">分类</div>
	<!--
        	作者：offline
        	时间：2016-03-07
        	描述：搜索
        -->
	<div class="sousuo">
		<form action="<%=path%>/wxModelCategory/wxlist.do" method="post"
			id="sform">
			<img src="<%=path%>/images/wx/032.gif" onclick="sel_category()" /> <input
				type="text" id="condition" name="condition" placeholder="找到属于你自己的"
				value="${categorys.condition}" /> <img class="sousuo_img2"
				src="<%=path%>/images/wx/034.png" />
		</form>
	</div>
	<!--
        	作者：offline
        	时间：2016-03-07
        	描述：分类选择
        -->
	<div class="choose">
		<div class="choose_div1 choose_divs"
			onclick="onClickModelCategory(0)">
			<img src="<%=path%>/images/wx/037.jpg" />
			<div class="choose_divs_div1">
				<div class="choose_divs_div1_div1">
					<p class="choose_divs_div1_div1_p1">ALL PPRODUCTS</p>
					<p class="choose_divs_div1_div1_p2"
						onclick="onClickModelCategory(0)">所有产品</p>
				</div>

			</div>
		</div>
		<c:forEach items="${categoryList}" var="category" varStatus="i">
			<c:choose>
				<c:when test="${i.count==2}">
					<div class="choose_div2 choose_divs"
						onclick="onClickModelCategory('${category.categoryId}')">
						<img src="<%=path%>/images/wx/038.jpg" />
						<div class="choose_divs_div1">
							<div class="choose_divs_div1_div1">
								<p class="choose_divs_div1_div1_p1">NECKLACE</p>
								<p class="choose_divs_div1_div1_p2"
									onclick="onClickModelCategory('${category.categoryId}')">${category.title}</p>
							</div>

						</div>
					</div>
				</c:when>
				<c:when test="${i.count==3}">
					<div class="choose_div3 choose_divs"
						onclick="onClickModelCategory('${category.categoryId}')">
						<img src="<%=path%>/images/wx/039.jpg" />
						<div class="choose_divs_div1">
							<div class="choose_divs_div1_div1">
								<p class="choose_divs_div1_div1_p1">NECKLACE</p>
								<p class="choose_divs_div1_div1_p2"
									onclick="onClickModelCategory('${category.categoryId}')">${category.title}</p>
							</div>

						</div>
					</div>
				</c:when>
				<c:when test="${i.count==4}">
					<div class="choose_div2 choose_divs"
						onclick="onClickModelCategory('${category.categoryId}')">
						<img src="<%=path%>/images/wx/040.jpg" />
						<div class="choose_divs_div1">
							<div class="choose_divs_div1_div1">
								<p class="choose_divs_div1_div1_p1">NECKLACE</p>
								<p class="choose_divs_div1_div1_p2"
									onclick="onClickModelCategory('${category.categoryId}')">${category.title}</p>
							</div>

						</div>
					</div>
				</c:when>
				<c:when test="${i.count==5}">
					<div class="choose_div3 choose_divs"
						onclick="onClickModelCategory('${category.categoryId}')">
						<img src="<%=path%>/images/wx/041.jpg" />
						<div class="choose_divs_div1">
							<div class="choose_divs_div1_div1">
								<p class="choose_divs_div1_div1_p1">NECKLACE</p>
								<p class="choose_divs_div1_div1_p2"
									onclick="onClickModelCategory('${category.categoryId}')">${category.title}</p>
							</div>

						</div>
					</div>
				</c:when>
				<c:when test="${i.count==6}">
					<div class="choose_div2 choose_divs"
						onclick="onClickModelCategory('${category.categoryId}')">
						<img src="<%=path%>/images/wx/042.jpg" />
						<div class="choose_divs_div1">
							<div class="choose_divs_div1_div1">
								<p class="choose_divs_div1_div1_p1">NECKLACE</p>
								<p class="choose_divs_div1_div1_p2"
									onclick="onClickModelCategory('${category.categoryId}')">${category.title}</p>
							</div>

						</div>
					</div>
				</c:when>
				<c:when test="${i.count==7}">
					<div class="choose_div3 choose_divs"
						onclick="onClickModelCategory('${category.categoryId}')">
						<img src="<%=path%>/images/wx/043.jpg" />
						<div class="choose_divs_div1">
							<div class="choose_divs_div1_div1">
								<p class="choose_divs_div1_div1_p1">NECKLACE</p>
								<p class="choose_divs_div1_div1_p2"
									onclick="onClickModelCategory('${category.categoryId}')">${category.title}</p>
							</div>

						</div>
					</div>
				</c:when>
			</c:choose>
		</c:forEach>

	</div>
	<!--
        	作者：offline
        	时间：2016-02-17
        	描述：底部（绝对定位）
        -->
	<div class="tianchong"></div>
	<div class="bottom">
		<div class="bottom_div1">
			<img src="<%=path%>/images/wx/056.png" />
		</div>
		<div class="bottom_div2">
			<img src="<%=path%>/images/wx/053.png" onclick="gotoFirstPage()" />
		</div>
		<div class="bottom_div3">
			<img src="<%=path%>/images/wx/057.png" onclick="gotoMytreade()" />
		</div>
	</div>
</body>
<script type="text/javascript">
	//去分类下的商品列表页
	function onClickModelCategory(categoryId) {
		window.location.href = "/3dcreatia/wxModelCategory/wxMClist.do?condition_categoryid="
				+ categoryId;
	}
	//页面底部去分类页面
	function onClickFenlei() {
		window.location.href = "/3dcreatia/wxModelCategory/wxlist.do";
	}
	//去购物车
	function gotoShopping() {
		window.location.href = "/3dcreatia/wxModelShoppingController/wxGetModelCartList.do";
	}
	// 分类搜索
	function sel_category() {
		$("#sform").submit();
	}
	//去首页
	function gotoFirstPage() {
		window.location.href = "/3dcreatia/wxModel/wxgotoModelIndex.do";
	}
	//去我的订单页
	function gotoMytreade() {
		window.location.href = "/3dcreatia/wxtrade/wxtradeList.do";
	}
</script>
</html>
