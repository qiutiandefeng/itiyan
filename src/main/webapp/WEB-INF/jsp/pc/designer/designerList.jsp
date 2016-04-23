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
	src="<%=request.getContextPath()%>/js/pc/shejishi.js"></script>

<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/shejishi.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/page.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-设计师品牌</title>

</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<form id="sform"
		action="<%=request.getContextPath()%>/userManage/gotoDesignerPC.do"
		method="post">
		<input type="hidden" id="pageIndex" name="pageIndex"
			value="${user.pageInfo.pageIndex}" /> <input type="hidden"
			name="markOrder" id="markOrder" value="${user.markOrder}" />
	</form>
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<!--
        	作者：offline
        	时间：2016-01-22
        	描述：大图
        -->
	<div class="shejishi_big">
		<img src="<%=request.getContextPath()%>/images/pc/112.png" />
	</div>
	<!--
        	作者：offline
        	时间：2016-01-22
        	描述：nav
        -->
	<div class="div_nav">
		<ul>
			<li class="left"><a href="###">首页</a> > <a href="###">爱体验设计师</a>
			</li>
			<li class="right li2"><a href="###" onclick="changeOrder(1)">最新</a>
				<a href="###" onclick="changeOrder(2)">人气</a></li>

		</ul>
	</div>
	<div class="shejishi_div">
		<c:forEach items="${designerList}" var="designer" varStatus="i">
			<div class="shejishi_div_div1">
				<div class="left shejishi_div_div1_div1">
					<img
						src="<%=request.getContextPath()%>/upload/uploadImg/user/${designer.avatar}"
						onclick="to_designerBrand('${designer.uid}')" />
				</div>
				<div class="left shejishi_div_div1_div2">
					<p class="shejishi_div_div1_div2_p1">${designer.dBrand}</p>
					<p class="shejishi_div_div1_div2_p2">
						<span>${designer.dTag}</span>
					</p>
					<p class="shejishi_div_div1_div2_p3">
						<c:if test="${designer.dcId=='' || designer.dcId==null}">
							<a href="###"><span class="shejishi_div_div1_div2_p3_sp1"
								onclick="collectionDesigner(this,1,'${designer.uid}','${designer.dcId}','dFavoriteNum${i.count}')">关注</span></a>
						</c:if>
						<c:if test="${designer.dcId!='' && designer.dcId!=null}">
							<span class="shejishi_div_div1_div2_p3_sp1">已关注</span>
						</c:if>
						<span class="shejishi_div_div1_div2_p3_sp2">粉丝<span
							class="dFavoriteNum" id="dFavoriteNum${i.count}">${designer.dFavoriteNum}</span></span>
					</p>
				</div>
				<div class="left  shejishi_div_div1_div3">
					<c:forEach items="${designer.designerList}" var="model">
						<div class="shejishi_div_div1_div3_div1 left">
							<img
								src="<%=request.getContextPath()%>/upload/uploadImg/model/${model.img}"
								onclick="to_modeldetail(${model.mid})" />
							<div class="shejishi_div_div1_div3_div1_div1">
								<p class="shejishi_div_div1_div3_div1_div1_p1">
									<span class="favoriteNum">${model.favoriteNum}</span>
									<c:if test="${model.mcId=='' || model.mcId==null}">
										<span class="shejishi_div_div1_div3_div1_div1_p1_sp1"
											onclick="collectionModel(this,1,'${model.author}','${model.mcId}','${model.mid}')"></span>
										<span class="shejishi_div_div1_div3_div1_div1_p1_sp2"></span>
									</c:if>
									<c:if test="${model.mcId!='' && model.mcId!=null}">
										<span class="shejishi_div_div1_div3_div1_div1_p1_sp3"></span>
									</c:if>

								</p>
								<p>${model.title}</p>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="shejishi_qing"></div>
			</div>
		</c:forEach>
	</div>
	<div class="page" style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${user.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
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
		window.location.href="<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid;
	
		}
	//跳转到设计师品牌页面
	function to_designerBrand(id){
		window.location.href="<%=request.getContextPath()%>/userManage/gotoDesignerBrandPC.do?id="+id;
	}
	//收藏设计师操作：type:1添加收藏；2.取消收藏
	function collectionDesigner(obj,type,dedignerid,dcId,favoriteNumID){
		//判断是否已经登录
		 var uid=$("#yfhl_user").val();
		  if(uid=="" || uid==null){
			  $(".logincalss").css({"display":"block"});
			  return false;
		    }
		
		//获取提交信息
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/designerCollectionController/designerCollection.do",
					data : {
						dcId : dcId,
						dcDesignerid :dedignerid,
						dcUserid : uid,
						markType : type
					},
					dataType : 'text',
					success : function(result) {
						if(result==1){
							var favoriteNum=$("#"+favoriteNumID);
							favoriteNum.html(Number(favoriteNum.html())+1);
							$(obj).removeAttr("onclick");
							$(obj).text("已关注");
						}
						 
					},
	
				});
	
	} 
	//收藏商品操作：type:1添加收藏；2.取消收藏
	function collectionModel(obj,type,dedignerid,mcId,mid){
		
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
							var favoriteNum=$(obj).parent().children("span.favoriteNum");
							favoriteNum.html(Number(favoriteNum.html())+1);
							
							$(obj).css({"display":"none"});
							$(obj).parent().children("span.shejishi_div_div1_div3_div1_div1_p1_sp2").css({"display":"block"});
						}
						 
					},
	
				});
	
	} 
	//改变排序方式:type排序方式
	function changeOrder(type){
		$("#markOrder").val(type);
		$("#sform").submit();//提交表单
	} 
</script>
</html>