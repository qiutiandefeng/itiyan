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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/maskLayer.js"></script>

<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/banner.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/recommended.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/ourmoreproducts.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/dengluzhuce.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网</title>

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
        	时间：2016-03-23
        	描述：库存不足
        -->
	<div class="xiajia_div1">SORRY!您有提交的产品有库存不足或者已下架的产品，请您重新选择商品。</div>
	<div class="xiajia_div2">
		<a class="xiajia_div2_a1"
			href="<%=request.getContextPath()%>/modelController/gotoModelListPC.do">继续逛</a> <a
			class="xiajia_div2_a2" href="###" onclick="gotoShopping()">返回购物车</a>
	</div>
	<!--
        	作者：offline
        	时间：2016-01-08
        	描述：最近浏览
        -->
	<div class="cartbot">
		<div class="cartbot1">
			<div class="cart">
				<p>最近浏览 RECENT REVIEW</p>
			</div>
			<img src="<%=request.getContextPath()%>/images/pc/cart2.gif" />
			<div class="cart1">
				<div class="recent_img">
					<c:forEach items="${recentList}" var="recent">
						<a href="###"><img
							src="<%=request.getContextPath()%>/upload/uploadImg/model/${recent.modelImg}" /></a>
					</c:forEach>

				</div>
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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/banner.js"></script>
<script type="text/javascript">
//跳转到商品详情页面
function to_modeldetail(mid){
	document.write('<form action="<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do" method="post" name="formx1" style="display:none">');
	document.write('<input type="hidden" name="mid" value="'+mid+'"/>');
	document.write("</form>");
	document.formx1.submit();

	}
//跳转到设计师品牌页面
function to_designerBrand(id){
	window.location.href="<%=request.getContextPath()%>/userManage/gotoDesignerBrandPC.do?id="+id;
}
//本周推荐点击More
function recommendMore(){
		var marker_recommend=$("#marker_recommend").val();
		var startIndex=Number(marker_recommend)*5;
		var recommend_div=document.getElementById("recommend_div");
		//alert(recommend_div.id);
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/modelController/queryRecommendMore.do",
					data : {
						startIndex : startIndex,
						endIndex : 5
					},
					dataType : 'text',
					success : function(result) {
						var ret = JSON.parse(result);
						//alert("返回的结果集：" + ret.length);
						if (ret.length != 0) {
							for (var i = 0; i < ret.length; i++) {
								var div1 = document.createElement("div");
								if (i == 0) {
									div1
											.setAttribute("class",
													"recommended_div_big recommended_div_");
									//div1.innerHTML("<img src='..//upload//uploadImg//model/"+ret[i].img+"'/><div class='oursss'><p class='p1'>"+ret[i].title+"</p><p class='p2'>￥"+ret[i].price+"</p></div>");
									//	div1.innerHTML('<img src="..//upload//uploadImg//model/'+ret[i].img+'" onclick="to_modeldetail("'+ret[i].mid+'")" /><div class="oursss"><p class="p1">'+ret[i].title+'</p><p class="p2">￥'+ret[i].price+'</p></div>');
								}
								if (i != 0) {
									div1
											.setAttribute("class",
													"recommended_div_small recommended_div_");
								}
								var img1 = document.createElement("img");
								img1.setAttribute("src",
										"<%=request.getContextPath()%>/upload/uploadImg/model/"
												+ ret[i].img);
								img1.setAttribute("onclick", "to_modeldetail("
										+ ret[i].mid + ")");
								var div2 = document.createElement("div");
								div2.setAttribute("class", "oursss");
								var p1 = document.createElement("p");
								p1.setAttribute("class", "p1");
								var p2 = document.createElement("p");
								p2.setAttribute("class", "p2");
								p2.innerHTML = "￥" + ret[i].price;
								recommend_div.appendChild(div1);
								div1.appendChild(img1);
								div1.appendChild(div2);
								div2.appendChild(p1);
								div2.appendChild(p2);
							}
							$("#marker_recommend").val(
									Number(marker_recommend) + 1);
							var $ours = $(".recommended_div_");
							$ours.hover(function() {
								$(this).children("div.oursss").stop().fadeIn()
							}, function() {
								$(this).children("div.oursss").stop().fadeOut()
							})
						} else {
							alert("没有更多推荐了！！");
						}
					},

				});

	}
	//去登录页面
	function gotoLogin() {
		window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
	}
	//去商品列表页
	function gotoModelList() {
		window.location.href = "<%=request.getContextPath()%>/modelController/gotoModelListPC.do";
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
</script>
</html>