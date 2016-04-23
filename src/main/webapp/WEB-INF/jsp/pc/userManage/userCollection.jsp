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
	src="<%=request.getContextPath()%>/js/jiaoyi_shoucang.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/gonggong_gerenzhongxin.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/jiaoyi_shoucang.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/page.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的爱体验-收藏商品</title>

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
		<a href="#">首页</a> > <a href="#">个人中心</a> > <a href="#">交易中心</a> > <a
			href="<%=path%>/modelCollectionController/queryList.do">我的收藏</a>
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
					<li><a href="<%=path%>/tradeManage/queryListPC.do">我的订单</a></li>
					<li><a href="<%=path%>/modelCollectionController/queryList.do"
						class="a1">我的收藏</a></li>
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
			<p class="shoucang_right_p1">【我的收藏】</p>
			<form id="sform" action="queryList.do" method="post">
				<div class="shoucang_right_div1">
					<a href="#" class="shoucang_right_div1_sp5">批量处理</a> <a href="#"
						class="shoucang_right_div1_sp3">全选</a> <a href="#"
						class="shoucang_right_div1_sp4" onclick="delCollection(1,0)">删除</a>
					<div class="shoucang_right_div1_div1">
						<span class="shoucang_right_div1_img1 left"></span> <input
							class="shoucang_right_div1_in1 left" type="text" name="condition"
							value="${modelCollection.condition}" /> <input type="submit"
							class="shoucang_right_div1_btn1" value="搜索"
							onclick="checkSubmit()" /> <input type="hidden" id="pageIndex"
							name="pageIndex" value="${modelCollection.pageInfo.pageIndex}" />
						<input type="hidden" name="mcUserid"
							value="${modelCollection.mcUserid}" /> <input type="hidden"
							id="markmid" value="" />
					</div>

				</div>
			</form>
			<div class="shoucang_right_div2">
				<c:forEach items="${list}" var="collection" varStatus="i">
					<dl class="shoucang_right_div2_dl">
						<dd class="shoucang_right_div2_dl_dd">
							<img
								src="<%=request.getContextPath()%>/upload/uploadImg/model/${collection.modelImg}"
								onclick="to_modeldetail('${collection.mcModelid}')" /> <img
								class="shoucang_right_div2_dl_img1"
								src="<%=request.getContextPath()%>/images/pc/040.png"
								id="${collection.mcId}" /> <img
								class="shoucang_right_div2_dl_img2"
								src="<%=request.getContextPath()%>/images/pc/044.png" />
							<div class="shoucang_right_div2_dl_div1">
								<img class="shoucang_right_div2_dl_div1_img1"
									src="<%=request.getContextPath()%>/images/pc/045.gif" />
							</div>
							<div class="shoucang_right_div2_dl_div2">
								<p class="shoucang_right_div2_dl_div2_p1">确定删除？</p>
								<p class="shoucang_right_div2_dl_div2_p2">
									<a href="#" class="shoucang_right_div2_dl_div2_p2_sp1"
										onclick="delCollection(0,'${collection.mcId}')">确定</a> <a
										href="#" class="shoucang_right_div2_dl_div2_p2_sp2">取消</a>
								</p>
							</div>
						</dd>
						<dt>
							<a href="###" onclick="to_modeldetail('${collection.mcModelid}')">${collection.modelName}</a>
						</dt>
					</dl>
				</c:forEach>
			</div>
			<div class="page" style="margin-left: 15px;">
				<!-- 分页 -->
				<c:set value="${modelCollection.pageInfo}" var="pageInfo"></c:set>
				<%@include file="../template/pageTemplate.jsp"%>
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
<script type="text/javascript">
	//确认删除
	function delCollection(type, id) {
		if (type == 1) {//批量删除
			$(".shoucang_right_div2_dl_img1").each(function() {
				if ($(this).css("display") == "block") {
					if (id == 0) {
						id = this.id;
					} else {
						id = id + ";" + this.id;
					}
				}
			})
		}
		if (window.confirm("确认要删除选中收藏吗？")) {

			var uid = $("#yfhl_user").val();
			var pageIndex = $("#pageIndex").val();
			document
					.write('<form action="<%=request.getContextPath()%>/modelCollectionController/delCollection.do" method="post" name="formx1" style="display:none">');
			document
					.write('<input type="hidden" name="mcUserid" value="'+uid+'"/>');
			document
					.write('<input type="hidden" name="markMID" value="'+id+'"/>');
			document.write("</form>");
			document.formx1.submit();
		}
	}
	//提交验证
	function checkSubmit() {
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		$("#condition").val(condition);
	}
 	//跳转到商品详情页面
	function to_modeldetail(mid) {
		window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);

	}
</script>
</html>