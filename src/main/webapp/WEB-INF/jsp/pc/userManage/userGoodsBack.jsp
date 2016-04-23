<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link
	href="<%=request.getContextPath()%>/css/gonggong_gerenzhongxin.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/zhangh_xiugaichenggong.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/text_tuihuanhuo.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-退换货</title>

</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2015-12-28
        	描述：交易——收藏
        -->
	<p class="shoucang_p">
		<a href="#">首页 </a> > <a href="#">个人中心</a> > <a href="#">交易中心</a> > <a
			href="<%=path%>/userManage/gotoGoodsBackPagePC.do">退换货</a>
	</p>
	<div class="shoucang">
		<div class="shoucang_left left">
			<div class="shoucang_left_div1">
				<div class="shoucang_left_div1_div1 left">
					<c:if test="${yfhl_user.avatar=='' || yfhl_user.avatar=='null'}">
						<img src="<%=request.getContextPath()%>/images/pc/defalut_useravator.png" />
					</c:if>
					<c:if test="${yfhl_user.avatar!='' && yfhl_user.avatar!='null'}">
						<img src="<%=request.getContextPath()%>/upload/uploadImg/user/${yfhl_user.avatar}" />
					</c:if>
				</div>
				<div class="shoucang_left_div1_div2 left">
					<p class="shoucang_left_div1_div2_p1">${yfhl_user.username}</p>
					<p class="shoucang_left_div1_div2_p2">
						<a href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a>
					</p>
				</div>
			</div>
			<div class="shoucang_left_div2">
				<p class="shoucang_left_div2_p1">交易中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="<%=path%>/tradeManage/queryListPC.do">我的订单</a></li>
					<li><a href="<%=path%>/modelCollectionController/queryList.do">我的收藏</a></li>
					<li><a href="<%=path%>/userManage/gotoGoodsBackPagePC.do"
						class="a1">退换货</a></li>
				</ul>
				<p class="shoucang_left_div2_p1">账户中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a></li>
					<li><a href="<%=request.getContextPath()%>/userManage/gotochangePwdPC.do">修改密码</a></li>
					<li><a
						href="<%=path%>/userAddressController/queryUserAddress.do">收货地址</a></li>
				</ul>
			</div>
			<div class="dongde"></div>
		</div>
		<div class="xiugai_right left">
			<p class="xiugai_right_p1">【退换货】</p>
			<div class="tuihuanhuo">
				<p class="tuihuanhuo_p1">
					<退换货申请方式>
				</p>
				<p class="tuihuanhuo_p2">质量问题</p>
				<p class="tuihuanhuo_p3">(1) 请将有质量问题的商品拍照并发送至暖岛网客服邮箱
					hello@nuandao.com</p>
				<p class="tuihuanhuo_p4">(2)
					客服收到并确认之后，会为您安排退换货，届时请注意查收邮件并根据客服提供的地址退回该商品。</p>
				<p class="tuihuanhuo_p5">时间：请于客服确认申请后5日内寄出商品。</p>
				<p class="tuihuanhuo_p6">非质量问题</p>
				<p class="tuihuanhuo_p7">以下三种方式可联系暖岛申请退换货</p>
				<p class="tuihuanhuo_p8">(1) 致电客服：4006669106</p>
				<p class="tuihuanhuo_p9">(2) 客服邮箱：hello@nuandao.com</p>
				<p class="tuihuanhuo_p10">(3) 在线客服</p>
				<p class="tuihuanhuo_p11">客服确认申请后会告知您退换货地址，请您按地址退回该商品，并向客服提供快递单号。</p>
				<p class="tuihuanhuo_p12">时间：请于客服确认申请后5日内寄出商品。</p>
				<p class="tuihuanhuo_p13">< 运费报销 ></p>
				<p class="tuihuanhuo_p14">有关质量问题的退换货可向暖岛报销运费。</p>
				<p class="tuihuanhuo_p15">(1)
					退换货邮费需您先垫付，商家在收到货品后将会根据您提供的支付宝账户为您报销所垫付运费。</p>
				<p class="tuihuanhuo_p16">(2)
					请您在寄回商品时于包裹中放入一张纸条，注明您的支付宝账户以及您所垫付的运费金额。如果您忘记放入小纸条，直接联系客服即可。</p>
				<p class="tuihuanhuo_p17">(3)
					因顾客拒收，长期不在，导致商品被快递公司或邮局退回时，需由顾客承担二次运费。</p>
				<p class="tuihuanhuo_p18">(4)
					非质量问题的退换货运费，需要由客户承担换货和再次发货的运费，暖岛网及商家不承担此项费用。</p>
				<p class="tuihuanhuo_p19">暖岛网于收到退换货商品后会及时为您安排退款及换货。</p>
				<p class="tuihuanhuo_p20">< 退款服务内容 ></p>
				<p class="tuihuanhuo_p21">退款相关说明</p>
				<p class="tuihuanhuo_p22">(1)
					暖岛网退款一般情况下会原路退回至您的付款账户中，退货时垫付的运费由商家单独退回。</p>
				<p class="tuihuanhuo_p23">(2)
					对于订单中使用暖岛优惠券的部分，暖岛网只退还其中实际消费现金的部分；对于订单中未使用暖岛优惠券的部分，暖岛网将会退还您等同于商品售价的金额。</p>
				<p class="tuihuanhuo_p24">(3)
					暖岛网会于每周三统一对已经确认可以退款的订单进行退款，周五前到达您的支付账户中，请您留意查收。</p>
			</div>
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