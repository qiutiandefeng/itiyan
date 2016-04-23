<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/maskLayer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/gg_denglu.js"></script>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：头部    公共样式
        -->
	<header class="head">
		<a class="head_a1 left"
			href="###" onclick="gotoManageTrade()"></a>
		<a href="#" class="left shoopCar" onclick="gotoShopping()"><span><c:if
					test="${yfhl_user.shoppingCount=='' || yfhl_user.shoppingCount==null}">0</c:if>
				<c:if
					test="${yfhl_user.shoppingCount!='' && yfhl_user.shoppingCount!=null}">${yfhl_user.shoppingCount}</c:if>
		</span></a>
		<c:if test="${yfhl_user.uid!=null && yfhl_user.uid!=''}">
			<a href="<%=request.getContextPath()%>/login/loginOutPC.do"
				class="left">退出</a>
		</c:if>
		<c:if test="${yfhl_user.uid==null || yfhl_user.uid==''}">
			<a href="#" class="left" onclick="gotoLogin()">登陆</a>
			<span class="left">|</span>
			<a href="#" onclick="gotoLogin()" class="left">注册</a>
		</c:if>
	</header>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：导航 和logo所在位置   划过和搜索点击效果
        -->

	<div class="nav">
		<form
			action="<%=request.getContextPath()%>/modelController/gotoModelListPC.do"
			method="post" name="form_condition" id="form_condition">
			<div class="left nav_left" onclick="gotoModelPc()">
				<img src="<%=request.getContextPath()%>/images/pc/051.gif" />
			</div>
			<ul class="left nav_right">
				<li class="nav_right_li1"><a
					href="<%=request.getContextPath()%>/modelController/gotoModelPC.do"></a></li>
				<li class="nav_right_li2"><a
					href="<%=request.getContextPath()%>/modelController/gotoModelListPC.do"></a>
					<ul class="showright_nav_ulprice">
						<li class="showright_nav_ul1_li1"><img
							src="<%=request.getContextPath()%>/images/pc/006.gif"></li>
						<c:forEach items="${categoryListForHander}" var="category">
							<li class="showright_nav_ul1_li2"><a href="###"
								onclick="selByCategory('${category.categoryId}')">${category.title}</a></li>
						</c:forEach>
					</ul></li>
				<li class="nav_right_li3"><a
					href="<%=request.getContextPath()%>/userManage/gotoDesignerPC.do"></a></li>
				<li class="nav_right_li4"><a
					href="<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage=5"></a></li>
				<li class="search"><input class="two left" type="text"
					placeholder="搜索关键词" name="condition" id="condition"
					value="${condition}" /><a class="left " href="#" onclick="selByCondition()">
					</a></li>
			</ul>
		</form>
	</div>
</body>
<script type="text/javascript">
	 
	//跳转到设计师品牌页面
	function to_designerBrand(id){
		window.location.href="<%=request.getContextPath()%>/userManage/gotoDesignerBrandPC.do?id="+id;
	}
	 
	//去登录页面
	function gotoLogin(){
		
		logincalssfadein();
	}
	//去个人中心
	function gotoManage(){
		//判断是否已经登录
		var uid = $("#yfhl_user").val();
		if (uid == "" || uid == null) {
			gotoLogin();//去登陆页面
			return false;
		}
		window.location.href = "<%=request.getContextPath()%>/userManage/gotoUserManagePC.do";
	}
	//个人订单页
	function gotoManageTrade(){
		//判断是否已经登录
		var uid = $("#yfhl_user").val();
		if (uid == "" || uid == null) {
			gotoLogin();//去登陆页面
			return false;
		} 
		window.location.href = "<%=request.getContextPath()%>/tradeManage/queryListPC.do";
	}
	//去商品列表页
	function gotoModelList(){
		window.location.href="<%=request.getContextPath()%>/modelController/gotoModelListPC.do";
	}
	//去购物车
	function gotoShopping() {
		//判断是否已经登录
		var uid = $("#yfhl_user").val();
		if (uid == "" || uid == null) {
			gotoLogin();//去登陆页面
			return false;
		}
		window.location.href = "<%=request.getContextPath()%>/modelShopping/cartList.do";
	}
	//模糊查询
	function selByCondition() {
		//1.搜索框去掉前后空格
		var condition = $.trim($("#condition").val());
		$("#condition").val(condition);
		document.form_condition.submit();
	}
	//去底部页面
	function gotoLastPage(type) {
		window.location.href = "<%=request.getContextPath()%>/turncenterController/turnBottom.do?markerPage="
				+ type;
	}
	 //根据商品类别查询商品信息
	function selByCategory(id){
	//提交
	document.write('<form action="<%=request.getContextPath()%>/modelController/gotoModelListPC.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="condition_categoryid" value="'+id+'"/>');
		document.write('<input type="hidden" name="markCategory" value="2"/>');
		document.write("</form>");
		document.formx1.submit();

	}
	 //去首页
	 function gotoModelPc(){
		 window.location.href="<%=request.getContextPath()%>/modelController/gotoModelPC.do";
	 }
</script>
</html>