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
	src="<%=request.getContextPath()%>/js/list.js"></script>
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/list.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/page.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/recent.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-商品列表</title>

</head>
<body>
	<form id="sform"
		action="<%=request.getContextPath()%>/modelController/gotoModelListPC.do"
		method="post">
		<input type="hidden" id="pageIndex" name="pageIndex"
			value="${model.pageInfo.pageIndex}" /><input type="hidden"
			id="condition_categoryid" name="condition_categoryid"
			value="${model.condition_categoryid}" /> <input type="hidden"
			id="markCategory" name="markCategory" value="${model.markCategory}" /><input
			type="hidden" name="markOrder" id="markOrder"
			value="${model.markOrder}" /> <input type="hidden" name="beginprice"
			id="beginprice" value="${model.beginprice}" /> <input type="hidden"
			name="endprice" id="endprice" value="${model.endprice}" /> <input
			type="hidden" id="totalPage" value="${model.pageInfo.totalPage}" />
		<input type="hidden" name="uid" id="yfhl_user" value="${yfhl_user.uid}" />
	</form>
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2015-12-08
        	描述：获取当前目标位置
        -->
	<div class="goalNav">
		<a href="###">首页</a> > <a href="###">产品</a>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-08
        	描述：所有展示
        -->
	<div class="show">
		<div class="leftNav">
			<span class="leftNav_a1">产品类目</span>
			<c:forEach items="${categoryList}" var="categy" varStatus="i">
				<ul class="leftNav_ul1">
					<li class="twopx dianji" id="cate${i.count}"><img class="img1"
						src="<%=request.getContextPath()%>/images/pc/005.gif" /><img
						class="img2" src="<%=request.getContextPath()%>/images/pc/004.gif" />${categy.title}
						<c:forEach items="${categy.list}" var="catey">
							<li class="leftNav_ul1_lis"><a href="#"
								onclick="selByCategory(${catey.categoryId})">${catey.title}</a></li>
						</c:forEach></li>
				</ul>
			</c:forEach>


		</div>
		<div class="showright left">
			<ul class="showright_nav">
				<c:choose>
					<c:when test="${model.markOrder==2}">
						<li><a href="###" onclick="changeOrder(1,-1,-1)">最新</a></li>
						<li><a href="###" class="showright_nav_moren"
							onclick="changeOrder(2,-1,-1)">人气</a></li>
						<li><a href="###" onclick="changeOrder(5,-1,-1)">可定制</a></li>
					</c:when>
					<c:when test="${model.markOrder==5}">
						<li><a href="###" onclick="changeOrder(1,-1,-1)">最新</a></li>
						<li><a href="###" onclick="changeOrder(2,-1,-1)">人气</a></li>
						<li><a href="###" class="showright_nav_moren"
							onclick="changeOrder(5,-1,-1)">可定制</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="###" class="showright_nav_moren"
							onclick="changeOrder(1,-1,-1)">最新</a></li>
						<li><a href="###" onclick="changeOrder(2,-1,-1)">人气</a></li>
						<li><a href="###" onclick="changeOrder(5,-1,-1)">可定制</a></li>
					</c:otherwise>
				</c:choose>
				<li class="showright_nav_li1">共${model.pageInfo.totalRec}件产品</li>
<!-- 				<ul class="showright_nav_ulprice">
					<li class="showright_nav_ul1_li1"><img
						src="../images/pc/006.gif"></li>
					<li class="showright_nav_ul1_li2"><a href="###"
						onclick="changeOrder(3,-1,-1)">从高到低</a></li>
					<li class="showright_nav_ul1_li2"><a href="###"
						onclick="changeOrder(4,-1,-1)">从低到高</a></li>
					<li class="showright_nav_ul1_li2"><a href="###"
						onclick="changeOrder(4,0,499)">￥0-499</a></li>
					<li class="showright_nav_ul1_li2"><a href="###"
						onclick="changeOrder(4,500,999)">￥500-999</a></li>
					<li class="showright_nav_ul1_li2"><a href="###"
						onclick="changeOrder(4,1000,2999)">￥1000-2999</a></li>
					<li class="showright_nav_ul1_li2"><a href="###"
						onclick="changeOrder(4,3000,-1)">￥3000以上</a></li>
				</ul> -->
			</ul>
			<c:forEach items="${modelList}" var="model" varStatus="i">
				<dl class="showright_dl">
					<dt class="dtt">
						<img
							src="<%=request.getContextPath()%>/upload/uploadImg/model/${model.img}"
							onclick="to_modeldetail('${model.mid}')" />
						<div class="layer">
							<div class="layer_img">
								<img
									src="<%=request.getContextPath()%>/upload/uploadImg/user/${model.designerAvatar}" />
							</div>
							<div class="layer_name" title="${model.designerName}">${model.designerName}</div>
							<div class="layer_num">${model.favoriteNum}</div>
							<div class="layer_xin">
								<c:if test="${model.mcId=='' || model.mcId==null}">
									<span class="layer_xin_img1"
										onclick="collection(this,1,'${model.author}','${model.mcId}','${model.mid}')"></span>
									<span class="layer_xin_img3"></span>
								</c:if>
								<c:if test="${model.mcId!='' && model.mcId!=null}">
									<span class="layer_xin_img2"></span>
								</c:if>
							</div>
						</div>
					</dt>
					<dd>
						<span class="showright_dl_dd_sp1" title="${model.title}"><a
							href="#" onclick="to_modeldetail('${model.mid}')">
								${model.title}</a></span> <span class="showright_dl_dd_sp2">[￥${model.price}]</span>
						<span class="new"></span>
					</dd>
				</dl>
			</c:forEach>
		</div>
		<div class="page" style="margin-left: 15px;">
			<!-- 分页 -->
			<c:set value="${model.pageInfo}" var="pageInfo"></c:set>
			<%@include file="../template/pageTemplate.jsp"%>
		</div>
		<div class="recent">
			<div class="recent_top">最近浏览 RECENT REVIEW</div>
			<div class="recent_bottom"></div>
			<div class="recent_img">
				<c:forEach items="${recentList}" var="recent">
					<a href="###" onclick="to_modeldetail('${recent.rMid}')"><img
						src="<%=request.getContextPath()%>/upload/uploadImg/model/${recent.modelImg}" /></a>

				</c:forEach>

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

<script>
	$(function() {
		var $dtts = $(".dtt");
		var $layers = $(".layer");
		$dtts.each(function() {
			$(this).hover(function() {
				$(this).children("div.layer").fadeIn(500)
			}, function() {
				$(this).children("div.layer").fadeOut(500)
			})
		})
	});
</script>
<script type="text/javascript">
    //根据商品类别查询商品信息
	function selByCategory(id){
	$("#condition_categoryid").val(id);	//给查询条件商品类别ID赋值
	$("#markCategory").val(2);
	$("#sform").submit();//提交表单
	}
	//改变排序方式:type排序方式；beginprice开始值；endprice结束值;
	function changeOrder(type,beginprice,endprice){
		$("#markOrder").val(type);
		$("#beginprice").val(beginprice);
		$("#endprice").val(endprice);
		$("#sform").submit();//提交表单
	}
	//收藏商品操作：type:1添加收藏；2.取消收藏
	function collection(obj,type,dedignerid,mcId,mid){
		//判断是否已经登录
		 var uid=$("#yfhl_user").val();
		  if(uid=="" || uid==null){
			  $(".logincalss").css({"display":"block"});
			  return false;
		    }
		
		//获取提交信息
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/modelCollectionController/modelCollection.do",
					data : {
						mcId : mcId,
						mcModelid : mid,
						mcDesignerid :dedignerid,
						mcUserid : uid,
						markType : type
					},
					dataType : 'text',
					success : function(result) {
						if(result==1){
							var favoriteNum=$(obj).parent().parent().children("div.layer_num");
							favoriteNum.html(Number(favoriteNum.html())+1);
							$(obj).css({"display":"none"});
							$(obj).parent().children("span.layer_xin_img3").css({"display":"block"})
						}
					},

				});

	} 
	//跳转到商品详情页面
	function to_modeldetail(mid){
		window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);
	}
	
	 
</script>
</html>