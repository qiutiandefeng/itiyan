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
<link href="<%=request.getContextPath()%>/css/dingdanshouhuo.css"
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
		<p class="xiangqing_div1_p1">订单状态：设计师已发货，请查看页面下方物流信息了解宝贝寄送情况</p>
		<p class="xiangqing_div1_p2">
			您还有<span class="xiangqing_div1_p2_sp1"><span>8</span> 天<span>18</span>小时<span>23</span>分<span>7</span>秒</span>
			来完成宝贝的"确认收货"操作。如果期间您没有"确认收货"，也没有"申请退款"，以上宝贝将自动确认收货，支付宝将把货款支付给爱体验网
		</p>
		<p class="xiangqing_div1_p3">
			1.如果您已收到货，且对商品满意，您可以<a href="#">确认收货</a>打款给爱体验网
		</p>
		<p class="xiangqing_div1_p4">
			2.如果还未收到货，请注意自动打款时间，您可以<a href="#">延长收货时间</a>或<a href="#">申请退款</a>
		</p>
		<p class="xiangqing_div1_p5">物流信息</p>
		<p class="xiangqing_div1_p6">
			发货方式：<span>快递</span>
		</p>
		<p class="xiangqing_div1_p7">
			物流公司：<span>圆通快递</span>
		</p>
		<p class="xiangqing_div1_p8">
			运单号码：<span>123123123123</span>
		</p>
		<p class="xiangqing_div1_p9">包裹跟踪</p>
		<img class="xiangqing_div1_img1" src="../images/pc/049.gif" />
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
			<p class="xiangqing_div2_div3_p4">
				<span>发货时间</span> - <span><fmt:formatDate
						value="${trade.shipmentsTime}" pattern="yyyy-MM-dd:HH:mm" /></span>
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
							<li class="xiangqing_div3_div2_div1_div1_ul1_li1"><img
								src="<%=request.getContextPath()%>/upload/uploadImg/model/${tdetail.tradeDetailImg}"
								onclick="to_modeldetail('${tdetail.id}')" />
								<div class="xiangqing_div3_div2_div1_div1_ul1_li1_div1">
									<p class="xiangqing_div3_div2_div1_div1_ul1_li1_div1_p1">
										<a href="###" onclick="to_modeldetail('${tdetail.id}')">${tdetail.name}</a>
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