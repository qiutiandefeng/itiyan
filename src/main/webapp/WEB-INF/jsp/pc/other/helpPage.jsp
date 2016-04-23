<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/bottomtext.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网</title>
</head>
<body>
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<div class="banner">
		<img src="<%=request.getContextPath()%>/images/pc/1.png" />
		<div class="banner_div">
			<div>
				<span class="s1">帮助中心</span> <span class="s2">HELP CENTER.</span>
			</div>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：文字链接
        -->
	<div class="two_nav1">
		<ul class="two_nav">
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=1">关于我们</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=2">加入我们</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=3">合作伙伴</a></li>
			<li><a
				href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=4"
				class="a1">帮助中心</a></li>
		</ul>
	</div>
	<!--
        	作者：offline
        	时间：2016-03-22
        	描述：文字
        -->
	<div class="bangzhu_div1">
		<div class="bangzhu_div1_div">
			<p class="bangzhu_div1_p1">购物流程</p>
			<p class="bangzhu_div1_p2">1.登录爱体验，未注册用户请点击这里注册；</p>
			<p class="bangzhu_div1_p2">2.查找商品：通过分类浏览或者直接搜索来查找商品；</p>
			<p class="bangzhu_div1_p2">3.放入购物车：将商品放入购物车后去结算或者继续购物，单个商品也可以不加入购物车直接购买；</p>
			<p class="bangzhu_div1_p2">4.提交订单：填写收获地址，选择配送方式和支付方式后提交订单；</p>
			<p class="bangzhu_div1_p2">5.查看订单状态：发货后，订单详情页或提供相应的快递单号，您可以根据单号来查询运单状态；</p>
			<p class="bangzhu_div1_p2">6.收获后评价：收获确认后可以评价商品；</p>
		</div>
	</div>
	<div class="bangzhu_div1">
		<div class="bangzhu_div1_div">
			<p class="bangzhu_div1_p1">支付方式</p>
			<p class="bangzhu_div1_p2">目前爱体验支持支付宝和微信两种支付方式，我们今后会增加更多的支付方式，方便大家购买。</p>
		</div>
	</div>

	<div class="bangzhu_div1">
		<div class="bangzhu_div1_div">
			<p class="bangzhu_div1_p1">产品配送</p>
			<p class="bangzhu_div1_p2">1.发货时间</p>
			<p class="bangzhu_div1_p2">发货时间会因设计师个人情况而定，预计发货时间会在商品详情页面会有注明。</p>
			<p class="bangzhu_div1_p2">2.收费标准</p>
			<p class="bangzhu_div1_p2">具体运费根据收获地址会稍有偏差，具体价格请参考商品详情页面的定价。</p>
		</div>
	</div>
	<div class="bangzhu_div1">
		<div class="bangzhu_div1_div">
			<p class="bangzhu_div1_p1">售后政策</p>
			<p class="bangzhu_div1_p2">1.取消订单</p>
			<p class="bangzhu_div1_p2">非定制商品在未发货之前可取消订单，定制商品在下单后无法取消。</p>
			<p class="bangzhu_div1_p2">2.退货政策</p>
			<p class="bangzhu_div1_p2">在您收到产品之后的7天内若出现质量问题，可以申请退换货服务。退款将通过之前的付款渠道返回您的账户</p>
			<p class="bangzhu_div1_p2">3.非定制产品支持7天内无理由退货。</p>
		</div>
	</div>

	<div class="bangzhu_div1 bangzhu_div1No">
		<div class="bangzhu_div1_div">
			<p class="bangzhu_div1_p1">联系客服</p>
			<p class="bangzhu_div1_p2">客服电话：17701317708</p>
			<p class="bangzhu_div1_p2">爱体验微信：Mei-J2014</p>
			<p class="bangzhu_div1_p2">客服邮箱：service@3Dcreatia.com</p>
		</div>
	</div>
	<div>
		<!--bottom -->
		<%@include file="../partpage/bottom.jsp"%>
	</div>
	<div class="logincalss">
		<!--login -->
		<%@include file="../partpage/login.jsp"%>
	</div>
</body>
 
</html>