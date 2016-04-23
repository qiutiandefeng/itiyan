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
<link href="<%=request.getContextPath()%>/css/gonggong_xiangqing.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/dingdanfahuo.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的爱体验-订单</title>
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
        	时间：2015-12-30
        	描述：订单详情
        -->
	<p class="xiangqing_p">
		<a href="#">首页</a> > <a href="#">个人中心</a> > <a href="#">我的订单</a> > <a
			href="#">订单详情</a>
	</p>
	<div class="xiangqing_div1">
		<p class="xiangqing_div1_p1">订单状态：您已付款到支付宝，等待爱体验/设计师发货</p>
		<p class="xiangqing_div1_p2">
			1.付款24小时后如果设计师一直不发货，您可以联系爱体验网或<a href="#">提醒发货</a>
		</p>
		<p class="xiangqing_div1_p3">
			2.如果产品本身存在质量问题，或者卖家存在违背发货时间承诺的情况<a href="#">(什么是违背发货时间承诺)</a>，您不想继续购买，可以<a
				href="#">申请退款(查看退款流程和规则)</a>
		</p>
		<p class="xiangqing_div1_p4">3.对于爱体验提供的产品和服务，您可以联系爱体验官方客服，提出您宝贵的建议</p>
		<p class="xiangqing_div1_p5">物流信息</p>
		<p class="xiangqing_div1_p6">请耐心等待，发货后显示物流信息~</p>
		<p class="xiangqing_div1_p7">包裹跟踪</p>
		<img class="xiangqing_div1_img1" src="<%=request.getContextPath()%>/images/pc/048.gif" />
	</div>
	<div class="xiangqing_div2">
		<p class="xiangqing_div2_p1">【订单详情】</p>
		<div class="xiangqing_div2_div1">
			<p class="xiangqing_div2_div1_p1">
				<span class="xiangqing_div2_div1_p1_sp1">收货信息</span> <span
					class="xiangqing_div2_div1_p1_sp2"> <span
					class="xiangqing_div2_div1_p1_sp2_sp1">收</span> <span
					class="xiangqing_div2_div1_p1_sp2_sp2">货</span> <span>人：</span>
				</span> <span>${trade.realname}</span>
			</p>
			<p class="xiangqing_div2_div1_p2">
				<span>手机号码：</span> <span>${trade.phone}</span>

			</p>
			<p class="xiangqing_div2_div1_p3">
				<span class="xiangqing_div2_div1_p3_sp1"> <span
					class="xiangqing_div2_div1_p3_sp1_sp1">地</span> <span>址：</span>
				</span> <span>北京市</span> <span>朝阳区</span> <span>${trade.address}</span>
			</p>
		</div>
		<div class="xiangqing_div2_div2">
			<p class="xiangqing_div2_div2_p1">
				<span class="xiangqing_div2_div2_p1_sp1">卖家信息</span> <span>品牌</span>
				- <span>爱体验</span>
			</p>
			<p class="xiangqing_div2_div2_p2">
				<span>城市</span> - <span>北京</span>
			</p>
		</div>
		<div class="xiangqing_div2_div3">
			<p class="xiangqing_div2_div3_p1">
				<span class="xiangqing_div2_div3_p1_sp1">订单信息</span> <span>订单编号</span>
				- <span>${trade.tradeNo}</span>
			</p>
			<p class="xiangqing_div2_div3_p2">
				<span>下单时间</span> - <span><fmt:formatDate
						value="${trade.addTime}" pattern="yyyy-MM-dd:HH:mm" /></span>
			</p>
			<p class="xiangqing_div2_div3_p3">
				<span>付款时间</span> - <span><fmt:formatDate
						value="${trade.paymentTime}" pattern="yyyy-MM-dd:HH:mm" /></span>
			</p>
		</div>
	</div>
	<div class="xiangqing_div3">
		<div class="xiangqing_div3_div1">
			<span class="xiangqing_div3_div1_sp1">商品信息</span> <span
				class="xiangqing_div3_div1_sp2">单价(元)</span> <span
				class="xiangqing_div3_div1_sp3">数量</span> <span
				class="xiangqing_div3_div1_sp4">优惠活动</span> <span
				class="xiangqing_div3_div1_sp5">状态</span> <span
				class="xiangqing_div3_div1_sp6">总金额(元)</span>
		</div>
		<div class="xiangqing_div3_div2">
			<div class="xiangqing_div3_div2_div1">
				<div class="xiangqing_div3_div2_div1_div1 left">
					<c:forEach items="${list}" var="tdetail">
						<ul class="xiangqing_div3_div2_div1_div1_ul1">
							<li class="xiangqing_div3_div2_div1_div1_ul1_li1"><a
								href="#"><img
									src="<%=request.getContextPath()%>/upload/uploadImg/model/${tdetail.tradeDetailImg}"
									onclick="to_modeldetail('${tdetail.id}')" /></a>
								<div class="xiangqing_div3_div2_div1_div1_ul1_li1_div1">
									<p class="xiangqing_div3_div2_div1_div1_ul1_li1_div1_p1">
										<a href="#" onclick="to_modeldetail('${tdetail.id}')">${tdetail.name}</a>
									</p>
									<p class="xiangqing_div3_div2_div1_div1_ul1_li1_div1_p2">
										<span>材质：</span><span>${tdetail.modtTextture}</span>

									</p>
									<p class="xiangqing_div3_div2_div1_div1_ul1_li1_div1_p3">
										<span>颜色：</span><span>${tdetail.modtSize}</span>
									</p>
								</div></li>
							<li class="xiangqing_div3_div2_div1_div1_ul1_li2">￥<span>${tdetail.price}</span></li>
							<li class="xiangqing_div3_div2_div1_div1_ul1_li3">${tdetail.qty}</li>
							<li class="xiangqing_div3_div2_div1_div1_ul1_li4">无</li>
							<li class="xiangqing_div3_div2_div1_div1_ul1_li5">未付款</li>
						</ul>
					</c:forEach>
				</div>

				<div class="xiangqing_div3_div2_div1_div2 left">
					<p>
						￥<span>${trade.totalPrice}</span>
					</p>
					<p>
						(含运费：<span>${trade.postage}</span>)
					</p>
				</div>
			</div>
			<p class="xiangqing_div3_div2_p1">
				备注： <span><c:if test="${trade.remark!='val_null'}">${trade.remark}</c:if></span>
			</p>

		</div>
		<div class="xixian"></div>
		<p class="xiangqing_p2">
			订单总金额： <span>￥</span> <span>${trade.totalPrice}</span> 元
		</p>
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
<script type="text/javascript">
	//提交验证
	function checkSubmit() {

		var tradeOneNo = $.trim($("#tradeOneNo").val());//搜索框去掉前后空格
		$("#tradeOneNo").val(tradeOneNo);
	}
	//根据条查询订单:type:订单种类1：未付款；2：待发货；3：待收货
	function selectTrade(type) {

		$("#state").val(type);//设置查询条件
		checkSubmit();//表单验证
		$("#sform").submit();//提交表单
	}
	//跳转到商品详情页面
	function to_modeldetail(mid) {
		window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);
	}
</script>
</html>