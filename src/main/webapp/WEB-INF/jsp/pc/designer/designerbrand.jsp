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
	src="<%=request.getContextPath()%>/js/pc/shejishi2.js"></script>

<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/pc/shejishi2.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/page.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png" type="image/x-icon"
	rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-设计师品牌</title>

</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<form id="sform" action="<%=request.getContextPath()%>/userManage/gotoDesignerBrandPC.do"
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
	<div class="shengji2_div1">
		<img class="shengji2_div1_img1"
			src="<%=request.getContextPath()%>/upload/uploadImg/user/${designer.avatar}" />
		<p class="shengji2_div1_p1">${designer.dBrand}</p>
		<c:if test="${designer.dcId=='' || designer.dcId==null}">
			<p class="shengji2_div1_p2">
				<a href="###" ><span
					onclick="collectionDesigner(this,1,'${designer.uid}','${designer.dcId}')"
					id="designerdcId">+关注</span></a>
			</p>
		</c:if>
		<c:if test="${designer.dcId!='' && designer.dcId!=null}">
			<p class="shengji2_div1_p2">已关注</p>
		</c:if>
		<p class="shengji2_div1_p3">
			粉丝<span id="dFavoriteNum">${designer.dFavoriteNum}</span>
		</p>
		<p class="shengji2_div1_p4">品牌标签：${designer.dTag}</p>
		<div class="fenxiang">
			<span></span> <a class="fenxiang_a1" href="###"></a> <a
				class="fenxiang_a2" href="###"></a> <a class="fenxiang_a3"
				href="###"></a>

		</div>
	</div>
	<div class="sheji_bottom"></div>
	<!--
        	作者：offline
        	时间：2016-03-18
        	描述：
        -->
	<div class="sheji_nav">
		<a href="###">首页&nbsp;>&nbsp; </a> <a href="###">${designer.dBrand}&nbsp;>
			&nbsp;</a> <a class="sheji_nav_a2"
			href="<%=request.getContextPath()%>/userManage/gotoDesignerPC.do">返回设计师类表>></a> <a
			class="sheji_nav_a1" href="###">共<span>${model.pageInfo.totalRec}</span>件商品
		</a>
	</div>
	<div class="sheji">
		<c:forEach items="${modelList}" var="model_l">
			<dl class="sheji_dl">
				<dt class="sheji_dl_dt">
					<img src="<%=request.getContextPath()%>/upload/uploadImg/model/${model_l.img}"
						onclick="to_modeldetail('${model_l.mid}')" />
					<div class="sheji_dl_dt_div1">
						<div class="sheji_dl_dt_div1_div1">
							<img src="<%=request.getContextPath()%>/images/pc/1.png" />
						</div>
						<div class="sheji_dl_dt_div1_div2">${model_l.designerName}</div>
						<div class="sheji_dl_dt_div1_div3">${model_l.favoriteNum}</div>
						<div class="sheji_dl_dt_div1_div4">
							<c:if test="${model_l.mcId=='' || model_l.mcId==null}">
								<div class="sheji_dl_dt_div1_div4_div1"
									onclick="collectionModel(this,1,'${model_l.author}','${model_l.mcId}','${model_l.mid}')"></div>
								<div class="sheji_dl_dt_div1_div4_div2"></div>
							</c:if>
							<c:if test="${model_l.mcId!='' && model_l.mcId!=null}">
								<div class="sheji_dl_dt_div1_div4_div3"></div>
							</c:if>



						</div>
					</div>
				</dt>
				<dd class="sheji_dl_dd">
					<span class="sheji_dl_dd_sp1">${model_l.title}</span> <span
						class="sheji_dl_dd_sp2">{￥${model_l.price}}</span>
				</dd>
			</dl>
		</c:forEach>
		<div class="clearBoth"></div>
	</div>
	<div class="page" style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${model.pageInfo}" var="pageInfo"></c:set>
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
	window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);
	}
	
//收藏设计师操作：type:1添加收藏；2.取消收藏
function collectionDesigner(obj,type,dedignerid,dcId){
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
						var favoriteNum=$("#dFavoriteNum");
						favoriteNum.text(Number(favoriteNum.text())+1);
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
						var favoriteNum=$(obj).parent().parent().children("div.sheji_dl_dt_div1_div3");
						favoriteNum.html(Number(favoriteNum.html())+1);
						
						$(obj).css({"display":"none"});
						$(obj).parent().children("div.sheji_dl_dt_div1_div4_div2").css({"display":"block"});
					}
					 
				},

			});

} 
</script>
</html>