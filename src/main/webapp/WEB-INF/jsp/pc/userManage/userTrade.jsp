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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/zhanghu_dingdanquxiao.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/gonggong_gerenzhongxin.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/jiaoyi_shoucang.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/zhanghu_wodedingdan.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/page.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/quxiaoshanchudingdan.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
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
        	时间：2015-12-28
        	描述：交易——收藏
        -->
	<p class="shoucang_p">
		<a href="#">首页 </a> > <a href="#">个人中心</a> > <a href="#">交易中心</a> > <a
			href="<%=path%>/tradeManage/queryListPC.do">我的订单</a>
	</p>
	<div class="shoucang">
		<div class="shoucang_left left">
			<div class="shoucang_left_div1">
				<div class="shoucang_left_div1_div1 left">
					<c:if test="${yfhl_user.avatar=='' || yfhl_user.avatar=='null'}">
						<img
							src="<%=request.getContextPath()%>/images/pc/defalut_useravator.png" />
					</c:if>
					<c:if test="${yfhl_user.avatar!='' && yfhl_user.avatar!='null'}">
						<img
							src="<%=request.getContextPath()%>/upload/uploadImg/user/${yfhl_user.avatar}" />
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
					<li><a class="a1" href="<%=path%>/tradeManage/queryListPC.do">我的订单</a></li>
					<li><a href="<%=path%>/modelCollectionController/queryList.do">我的收藏</a></li>
					<li><a href="<%=path%>/userManage/gotoGoodsBackPagePC.do">退换货</a></li>
				</ul>
				<p class="shoucang_left_div2_p1">账户中心</p>
				<ul class="shoucang_left_div2_ul1">
					<li><a href="<%=path%>/userManage/gotoUserManagePC.do">编辑个人信息</a></li>
					<li><a
						href="<%=request.getContextPath()%>/userManage/gotochangePwdPC.do">修改密码</a></li>
					<li><a
						href="<%=path%>/userAddressController/queryUserAddress.do">收货地址</a></li>
				</ul>
			</div>
			<div class="dongde"></div>
		</div>
		<div class="shoucang_right left">
			<p class="shoucang_right_p1">【我的订单】</p>
			<form id="sform" action="queryListPC.do" method="post">
				<ul class="quxiao_ul1">
					<c:choose>
						<c:when test="${trade.state==1}">
							<li><a href="#" onclick="selectTrade(0)">所有订单</a><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(1)"
								class="quxiao_ul1_red">未付款</a><span class="quxiao_ul1_red">${trade.state1Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(2)">代发货</a><span
								class="quxiao_ul1_red">${trade.state2Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(3)">待收货</a><span
								class="quxiao_ul1_red">${trade.state3Count}</span></li>
						</c:when>
						<c:when test="${trade.state==2}">
							<li><a href="#" onclick="selectTrade(0)">所有订单</a><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(1)">未付款</a><span
								class="quxiao_ul1_red">${trade.state1Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(2)"
								class="quxiao_ul1_red">代发货</a><span class="quxiao_ul1_red">${trade.state2Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(3)">待收货</a><span
								class="quxiao_ul1_red">${trade.state3Count}</span></li>
						</c:when>
						<c:when test="${trade.state==3}">
							<li><a href="#" onclick="selectTrade(0)">所有订单</a><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(1)">未付款</a><span
								class="quxiao_ul1_red">${trade.state1Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(2)">代发货</a><span
								class="quxiao_ul1_red">${trade.state2Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(3)"
								class="quxiao_ul1_red">待收货</a><span class="quxiao_ul1_red">${trade.state3Count}</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="#" class="quxiao_ul1_red"
								onclick="selectTrade(0)">所有订单</a><span class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(1)">未付款</a><span
								class="quxiao_ul1_red">${trade.state1Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(2)">代发货</a><span
								class="quxiao_ul1_red">${trade.state2Count}</span><span
								class="quxiao_ul1_cu">·</span></li>
							<li><a href="#" onclick="selectTrade(3)">待收货</a><span
								class="quxiao_ul1_red">${trade.state3Count}</span></li>

						</c:otherwise>
					</c:choose>
					<li class="quxiao_ul1_li6"><input type="submit" value="搜索"
						onclick="checkSubmit()" /></li>
					<li class="quxiao_ul1_li5"><div class="left"></div> <input
						class="left" type="text" id="tradeOneNo" name="tradeOneNo"
						value="${trade.tradeOneNo}" /></li>

				</ul>
				<input type="hidden" name="state" id="state" value="${trade.state}" />
				<input type="hidden" name="markUserid" value="${trade.markUserid}" />
				<input type="hidden" id="pageIndex" name="pageIndex"
					value="${trade.pageInfo.pageIndex}" />
			</form>
			<div class="quxiao_div1">
				<div class="quxiao_div1_div1">
					<span class="quxiao_div1_div1_sp1">商品信息</span> <span
						class="quxiao_div1_div1_sp2">单价(元)</span> <span
						class="quxiao_div1_div1_sp3">数量</span> <span
						class="quxiao_div1_div1_sp4">优惠活动</span> <span
						class="quxiao_div1_div1_sp5">实付款(元)</span> <span
						class="quxiao_div1_div1_sp6">订单状态</span> <span
						class="quxiao_div1_div1_sp7">操作</span>
				</div>
				<c:forEach items="${list}" var="trade" varStatus="i">
					<div class="quxiao_div1_div2">
						<c:if test="${trade.marker_state==2}">
							<div class="quxiao_div1_div2_div1">
								<p class="left quxiao_div1_div2_div1_p1">
									<span class="shixiao1">失效</span>订单编号：<span>3030303030</span>
								</p>
								<p class="right quxiao_div1_div2_div1_p2">
									下单时间：<span>2015-01-01 16:28:29</span>
								</p>
							</div>

						</c:if>
						<c:if test="${trade.marker_state!=2}">
							<div class="quxiao_div1_div2_div1">
								<p class="left quxiao_div1_div2_div1_p1">
									订单编号：<span>${trade.tradeNo}</span>
								</p>
								<p class="right quxiao_div1_div2_div1_p2">
									下单时间：<span><fmt:formatDate value="${trade.addTime}"
											pattern="yyyy-MM-dd:HH:mm" /></span>
								</p>
							</div>
						</c:if>
						<div class="quxiao_div1_div2_div2">
							<c:forEach items="${trade.tradeDetailList}" var="tdetail"
								varStatus="i">
								<ul class="quxiao_div1_div2_div2_ul1">
									<li class="quxiao_div1_div2_div2_ul1_li1"><a href="###"><img
											src="<%=request.getContextPath()%>/upload/uploadImg/model/${tdetail.tradeDetailImg}"
											onclick="to_modeldetail('${tdetail.id}')" /></a>
										<div class="quxiao_div1_div2_div2_ul1_li1_div1 left">
											<p class="quxiao_div1_div2_div2_ul1_li1_div1_p1">
												<a href="#" onclick="to_modeldetail('${tdetail.id}')">${tdetail.name}</a>
											</p>
											<p class="quxiao_div1_div2_div2_ul1_li1_div1_p2">
												<span>材质：</span><span>${tdetail.modtTextture}</span>

											</p>
											<p class="quxiao_div1_div2_div2_ul1_li1_div1_p3">
												<span>尺寸：</span><span title="${tdetail.modtSize}">${tdetail.modtSize}</span>
											</p>
										</div></li>
									<li class="quxiao_div1_div2_div2_ul1_li2">￥<span>${tdetail.price}</span></li>
									<li class="quxiao_div1_div2_div2_ul1_li3">${tdetail.qty}</li>
									<li class="quxiao_div1_div2_div2_ul1_li4">无</li>
								</ul>
							</c:forEach>
							<div class="quxiao_div1_div2_div2_div1 left">
								￥<span>${trade.totalPrice}</span>
							</div>
							<div class="quxiao_div1_div2_div2_div2 left">
								<c:choose>
									<c:when test="${trade.status==1}">
										<c:if test="${trade.marker_state!=2}">
											<span class="quxiao_div1_div2_div2_div2_sp2">等待付款</span>
										</c:if>
										<c:if test="${trade.marker_state==2}">
											<span class="quxiao_div1_div2_div2_div2_sp2">订单已失效</span>
										</c:if>
									</c:when>
									<c:when test="${trade.status==2}">
										<span class="quxiao_div1_div2_div2_div2_sp3">等待发货</span>
									</c:when>
									<c:when test="${trade.status==3}">
										<span class="quxiao_div1_div2_div2_div2_sp4">等待收货</span>
									</c:when>
									<c:when test="${trade.status==4}">
										<span class="quxiao_div1_div2_div2_div2_sp4">交易完成</span>
									</c:when>
									<c:when test="${trade.status==5}">
										<span class="quxiao_div1_div2_div2_div2_sp5">交易关闭</span>
									</c:when>
								</c:choose>
							</div>
							<div class="quxiao_div1_div2_div2_div3 left">
								<c:choose>
									<c:when test="${trade.status==1}">
										<c:if test="${trade.marker_state!=2}">
											<a href="#" class="quxiao_div1_div2_div2_div3_btn1"
												onclick="fastTopay('${trade.totalPrice}','${trade.tradeNo}')">立即付款</a>
											<a href="#" class="quxiao_div1_div2_div2_div3_sp2"
												onclick="toDetail(1,'${trade.id}')">查看订单</a>
											<a href="#" class="quxiao_div1_div2_div2_div3_sp3"
												onclick="tocancelTrade('${trade.id}')">取消订单</a>
										</c:if>
										<c:if test="${trade.marker_state==2}">
											<a href="#" class="quxiao_div1_div2_div2_div3_sp2"
											onclick="toDetail(5,'${trade.id}')">查看订单</a>
										<a href="#" class="quxiao_div1_div2_div2_div3_sp4"
											onclick="todelTrade('${trade.id}')">删除订单</a>
										</c:if>

									</c:when>
									<c:when test="${trade.status==2}">
										<a href="#" class="quxiao_div1_div2_div2_div3_btn3" onclick="">提醒发货</a>
										<a href="#" class="quxiao_div1_div2_div2_div3_sp2"
											onclick="toDetail(2,'${trade.id}')">查看订单</a>
									</c:when>
									<c:when test="${trade.status==3}">
										<a href="#" class="quxiao_div1_div2_div2_div3_btn2"
											onclick="makesureTreade('${trade.id}')">确认收货</a>
										<a href="#" class="quxiao_div1_div2_div2_div3_sp2"
											onclick="toDetail(3,'${trade.id}')">查看订单</a>
									</c:when>
									<c:when test="${trade.status==4}">
										<a href="#" class="quxiao_div1_div2_div2_div3_sp1" onclick="">评价</a>
										<a href="#" class="quxiao_div1_div2_div2_div3_sp2"
											onclick="toDetail(4,'${trade.id}')">查看订单</a>
										<a href="#" class="quxiao_div1_div2_div2_div3_sp4"
											onclick="todelTrade('${trade.id}')">删除订单</a>
									</c:when>
									<c:when test="${trade.status==5}">
										<a href="#" class="quxiao_div1_div2_div2_div3_sp2"
											onclick="toDetail(5,'${trade.id}')">查看订单</a>
										<a href="#" class="quxiao_div1_div2_div2_div3_sp4"
											onclick="todelTrade('${trade.id}')">删除订单</a>
									</c:when>
								</c:choose>
							</div>

						</div>
						<div class="quxiao_div1_div2_div3">
							备注：
							<c:if test="${trade.remark!='val_null'}">${trade.remark}</c:if>
						</div>
					</div>
				</c:forEach>
				<div class="page" style="margin-left: 15px;">
					<!-- 分页 -->
					<c:set value="${trade.pageInfo}" var="pageInfo"></c:set>
					<%@include file="../template/pageTemplate.jsp"%>
				</div>

			</div>
		</div>
	</div>
	<!-- 作者：offline
        	时间：2015-12-02
        	描述：取消订单窗口 -->
	<div class="motai_quxiaodingdan"></div>
	<div class="motai_waitao1">
		<div class="motai_quxiao">
			<p class="motai_quxiao_p1">您取消订单的原因是：</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" onclick="setcancelInfo('支付不成功')">支付不成功
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" onclick="setcancelInfo('现在不想购买')">现在不想购买
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" onclick="setcancelInfo('订单价格有问题')">订单价格有问题
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" onclick="setcancelInfo('修改订单信息')">修改订单信息
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" onclick="setcancelInfo('错误或重复下单')">错误或重复下单
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao"
					onclick="setcancelInfo('等待发货时间过长')">等待发货时间过长
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" onclick="setcancelInfo('商品价格较贵')">商品价格较贵
			</p>
			<p class="motai_quxiao_p2">
				<input type="radio" name="quxiao" checked="checked"
					onclick="setcancelInfo('其他原因')">其他原因
			</p>
			<a class="motai_quxiao_a1 left" href="#" onclick="cancelTrade()">确认并取消订单</a>
			<a class="motai_quxiao_a2 left" href="#">取消</a> <input type="hidden"
				id="canceltid" value="" /><input type="hidden" id="cancelinfo"
				value="其他原因" />

		</div>
	</div>
	<div class="motai_waitao2">
		<div class="motai_shanchu">
			<p>您确认删除订单吗？</p>
			<a class="motai_shanchu_a1 left" href="#" onclick="delTrade()">确认并删除订单</a>
			<a class="motai_shanchu_a2 left" href="#">取消</a> <input type="hidden"
				id="deletetid" value="" />
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
	//查看订单:1：等待付款 2：已付款，等待发货 3：已发货，等待收货 4：交易完成 5：交易取消
	function toDetail(type, tid) {
		var userid = $("#yfhl_user").val();
		document.write('<form action="<%=request.getContextPath()%>/tradeManage/queryTradeDetailPC.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="state" value="'+type+'"/>');
		document.write('<input type="hidden" name="markUserid" value="'+userid+'"/>');
		document.write('<input type="hidden" name="id" value="'+tid+'"/>');
		document.write("</form>");
		document.formx1.submit();

	}
	//设置删除订单的订单ID
	function todelTrade(tid) {
		$("#deletetid").val(tid);
	}
	//删除订单
	function delTrade() {
		var tid = $("#deletetid").val();
		var userid = $("#yfhl_user").val();
		var pageIndex = $("#pageIndex").val();
		document
				.write('<form action="<%=request.getContextPath()%>/tradeManage/delTradePC.do" method="post" name="formx2" style="display:none">');
		document
				.write('<input type="hidden" name="pageIndex" value="'+pageIndex+'"/>');
		document
				.write('<input type="hidden" name="markUserid" value="'+userid+'"/>');
		document.write('<input type="hidden" name="id" value="'+tid+'"/>');
		document.write("</form>");
		document.formx2.submit();

	}
	//确认收货
	function makesureTreade(tid) {
		var userid = $("#yfhl_user").val();
		var pageIndex = $("#pageIndex").val();
		if (window.confirm("确认收货后您的预付款将会打到卖家平台，请确认您是否已收到货品！")) {
			document
					.write('<form action="<%=request.getContextPath()%>/tradeManage/makeSureTreadePC.do" method="post" name="formx3" style="display:none">');
			document
					.write('<input type="hidden" name="pageIndex" value="'+pageIndex+'"/>');
			document
					.write('<input type="hidden" name="markUserid" value="'+userid+'"/>');
			document.write('<input type="hidden" name="id" value="'+tid+'"/>');
			document.write("</form>");
			document.formx3.submit();
		}
	}
	//设置取消订单的订单ID
	function tocancelTrade(tid) {
		$("#canceltid").val(tid);
	}
	//设置取消原因
	function setcancelInfo(info) {
		$("#cancelinfo").val(info);
	}
	//取消订单
	function cancelTrade() {
		var userid = $("#yfhl_user").val();
		var tid = $("#canceltid").val();
		var pageIndex = $("#pageIndex").val();
		var cancelInfo = $("#cancelinfo").val();
		var state=$("#state").val();
		document.write('<form action="<%=request.getContextPath()%>/tradeManage/cancelTradePC.do" method="post" name="formx4" style="display:none">');
		document.write('<input type="hidden" name="pageIndex" value="'+pageIndex+'"/>');
		document.write('<input type="hidden" name="markUserid" value="'+userid+'"/>');
		document.write('<input type="hidden" name="id" value="'+tid+'"/>');
		document.write('<input type="hidden" name="cancelInfo" value="'+cancelInfo+'"/>');
		document.write('<input type="hidden" name="state" value="'+state+'"/>');
		document.write("</form>");
		document.formx4.submit();

	}
	//立即付款
	function fastTopay(totalPrice,tradeNo) {
		document.write('<form action="<%=request.getContextPath()%>/tradeManage/fastTopay.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="totalPrice" value="'+totalPrice+'"/>');
		document.write('<input type="hidden" name="tradeNo" value="'+tradeNo+'"/>');
		document.write('<input type="hidden" name="tradeCount" value="1"/>');
		document.write("</form>");
		document.formx1.submit();
	}
	//跳转到商品详情页面
	function to_modeldetail(mid) {
		window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="
						+ mid);

	}
</script>
</html>