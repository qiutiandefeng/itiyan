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
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网</title>

</head>
<body>
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：渐隐轮播：banner
        -->
	<div class="banner">
		<ul class="imgLest">
			<!--图片部分 -->
			<c:forEach items="${bannerList}" var="banner" varStatus="i">
				<c:if test="${i.count==1}">
					<li class="imgOn"><img
						src="<%=request.getContextPath()%>/upload/uploadImg/banner/${banner.banImgurl}" /></li>
				</c:if>
				<c:if test="${i.count!=1}">
					<li><img
						src="<%=request.getContextPath()%>/upload/uploadImg/banner/${banner.banImgurl}" /></li>
				</c:if>
			</c:forEach>
		</ul>
		<div class="banner_div1">
			<ul class="textLest">
				<!--文字部分 -->
				<c:forEach items="${bannerList}" var="banner" varStatus="i">
					<c:if test="${i.count==1}">
						<li class="textOn">${banner.banName}</li>
					</c:if>
					<c:if test="${i.count!=1}">
						<li>${banner.banName}</li>
					</c:if>
				</c:forEach>
			</ul>
			<ul class="square">
				<!--添加景深块元素-->
				<li class="squareOn"></li>
				<li></li>
				<li></li>
				<li></li>

			</ul>
		</div>

	</div>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：ajax 加载图片名称和价格 ；文字定位划过显示：本周推荐
        -->
	<div class="recommended">
		<div class="theTitle">
			<img src="<%=request.getContextPath()%>/images/pc/092.png" />
		</div>
		<div id="recommend_div">
			<c:forEach items="${recommendList}" var="recommend" varStatus="i">
				<c:if test="${(i.count-1)==0 || (i.count-1)%5==0}">
					<div class="recommended_div_big recommended_div_"
						onclick="to_modeldetail('${recommend.mid}')">
						<img
							src="<%=request.getContextPath()%>/upload/uploadImg/model/${recommend.img}" />
						<div class="oursss">
							<p class="p1">${recommend.title}</p>
							<p class="p2">￥${recommend.price}</p>
						</div>
					</div>
				</c:if>
				<c:if test="${(i.count-1)!=0 && (i.count-1)%5!=0}">
					<div class="recommended_div_small recommended_div_"
						onclick="to_modeldetail('${recommend.mid}')">
						<img
							src="<%=request.getContextPath()%>/upload/uploadImg/model/${recommend.img}" />
						<div class="oursss">
							<p class="p1">${recommend.title}</p>
							<p class="p2">￥${recommend.price}</p>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
<!-- 		<p class="recommended_p">
			<input type="hidden" id="marker_recommend" value="1" /> <a href="#"
				onclick="recommendMore()"></a>
		</p> -->
	</div>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：ajax加载图片名称价格 划过可点赞：更多产品
        -->
	<div class="more" id="more">
		<div class="theTitle">
			<img src="<%=request.getContextPath()%>/images/pc/091.png" />
		</div>
		<ul class="morNav">
			<c:forEach items="${categoryList}" var="categorylist" varStatus="i">
				<li class="showHidden${i.count}"><c:if test="${i.count==1}">
						<a class="initialize" href="###">${categorylist.title}</a>
					</c:if> <c:if test="${i.count!=1}">
						<a href="###">${categorylist.title}</a>
					</c:if></li>
			</c:forEach>

		</ul>
		<c:forEach items="${modellist}" var="modellist" varStatus="j">
			<div class="li1" id="li${j.count}">
				<c:forEach items="${modellist}" var="model">
					<dl>
						<dt class="dtt">
							<img
								src="<%=request.getContextPath()%>/upload/uploadImg/model/${model.img}"
								onclick="to_modeldetail('${model.mid}')" />
							<div class="layer">
								<div class="layer_img" onclick="">
									<img
										src="<%=request.getContextPath()%>/upload/uploadImg/user/${model.designerAvatar}" />
								</div>
								<div class="layer_name" onclick="">${model.designerName}</div>
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
							<span class="showright_dl_dd_sp1" title="${model.title}">${model.title}</span>
							<span class="showright_dl_dd_sp2">{￥${model.price}}</span> <span
								class="new"></span>
						</dd>
					</dl>
				</c:forEach>
			</div>
		</c:forEach>

		<div class="bottomText">
			<a href="#" onclick="gotoModelList()"></a>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-02
        	描述：ajax 加载图片 划过有窗口显示出来  向左轮播 :设计师
        -->
	<div class="designer">
		<div class="theTitle">
			<img src="<%=request.getContextPath()%>/images/pc/093.png" />
		</div>
		<ul class="designer_ul">
			<c:forEach items="${designerList}" var="designer">
				<li><img
					src="<%=request.getContextPath()%>/upload/uploadImg/user/${designer.avatar}" />
					<div class="designer_ul_li_div"
						onclick="to_designerBrand('${designer.uid}')">
						<p class="p1">${designer.username}</p>
					</div></li>
			</c:forEach>
		</ul>
		<div class="bottomText2">
			<a href="<%=request.getContextPath()%>/userManage/gotoDesignerPC.do"></a>
		</div>
	</div>
	<div>
		<!--bottom -->
		<%@include file="partpage/bottom.jsp"%>
	</div>
	<div class="logincalss">
		<!--login -->
		<%@include file="partpage/login.jsp"%>
	</div>
</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pc/banner.js"></script>
<script type="text/javascript">
//跳转到商品详情页面
function to_modeldetail(mid){
	window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);
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
								var div1=document.createElement("div");
								if (i == 0) {
									div1.setAttribute("class","recommended_div_big recommended_div_");
									//div1.innerHTML("<img src='..//upload//uploadImg//model/"+ret[i].img+"'/><div class='oursss'><p class='p1'>"+ret[i].title+"</p><p class='p2'>￥"+ret[i].price+"</p></div>");
								//	div1.innerHTML('<img src="..//upload//uploadImg//model/'+ret[i].img+'" onclick="to_modeldetail("'+ret[i].mid+'")" /><div class="oursss"><p class="p1">'+ret[i].title+'</p><p class="p2">￥'+ret[i].price+'</p></div>');
								}
								if(i!=0){
									div1.setAttribute("class","recommended_div_small recommended_div_");
								}
								var img1=document.createElement("img");
								img1.setAttribute("src","<%=request.getContextPath()%>/upload/uploadImg/model/"+ret[i].img);
								img1.setAttribute("onclick","to_modeldetail("+ ret[i].mid+")");
								var div2=document.createElement("div");
								div2.setAttribute("class","oursss");
								var p1=document.createElement("p");
								p1.setAttribute("class","p1");
								var p2=document.createElement("p");
								p2.setAttribute("class","p2");
								p2.innerHTML="￥"+ ret[i].price;
								recommend_div.appendChild(div1);
								div1.appendChild(img1);
								div1.appendChild(div2);
								div2.appendChild(p1);
								div2.appendChild(p2);
							}
							$("#marker_recommend").val(Number(marker_recommend) + 1);
							var $ours=$(".recommended_div_");
							$ours.hover(function(){
								$(this).children("div.oursss").stop().fadeIn()
								},function(){
								$(this).children("div.oursss").stop().fadeOut()
							})
						} else {
							alert("没有更多推荐了！！");
						}
					},

				});

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
						mcDesignerid : dedignerid,
						mcUserid : uid,
						markType : type
					},
					dataType : 'text',
					success : function(result) {
						if (result == 1) {
							var favoriteNum = $(obj).parent().parent()
									.children("div.layer_num");
							favoriteNum.html(Number(favoriteNum.html()) + 1);
							$(obj).css({
								"display" : "none"
							});
							$(obj).parent().children("span.layer_xin_img3")
									.css({
										"display" : "block"
									})
						}
					},

				});

	}
</script>
</html>