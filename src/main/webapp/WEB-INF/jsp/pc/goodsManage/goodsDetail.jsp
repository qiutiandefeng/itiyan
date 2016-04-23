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
	src="<%=request.getContextPath()%>/js/details.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/js/kindeditor-4.1.10/kindeditor.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>/js/kindeditor-4.1.10/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.css" />
<link href="<%=request.getContextPath()%>/css/pc/Common_style.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/details.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/recent.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/page.css" type="text/css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/pc/logo2.png"
	type="image/x-icon" rel="shortcut icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱体验网-商品详情</title>

</head>
<body onload="showView()">
	<input type="hidden" id="yfhl_user" value="${yfhl_user.uid}" />
	<input type="hidden" id="modelid" value="${model.mid}" />
	<input type="hidden" id="modelname" value="${model.title}" />
	<input type="hidden" id="autherID" value="${model.author}" />
	<input type="hidden" id="brand" value="${model.brand}" />
	<input type="hidden" id="modSelfDesigner"
		value="${model.modSelfDesigner}" />
	<input type="hidden" id="val_textture" value="" />
	<input type="hidden" id="val_size" value="" />

	<div>
		<!--hander -->
		<c:set value="${model.condition}" var="condition"></c:set>
		<%@include file="../partpage/hander.jsp"%>
	</div>
	<div class="nav_bottom"></div>
	<!--
        	作者：offline
        	时间：2016-01-11
        	描述：商品详情
        -->
	<div class="details_text">
		<p>
			<a href="#">首页</a> > <a href="#">产品</a> > <a href="#"
				class="details_text_a1">${model.title}</a>
		</p>
	</div>

	<div class="details_details1">
		<div class="details_details11">
			<div class="details_details_left left">
				<div class="details_details_left_div1">
					<img class="details_details_left_img1"
						src="<%=request.getContextPath()%>/upload/uploadImg/model/${model.imgList.get(0)}"
						id="modelimg" />
				</div>
				<ul class="details_details_left_ul1">
					<c:forEach items="${model.imgList}" var="img" varStatus="i">
						<li><a href="###"><img
								src="<%=request.getContextPath()%>/upload/uploadImg/model/${img}" /></a></li>
					</c:forEach>
				</ul>

			</div>
			<div class="details_details_right left">
				<div class="details_details_right_div1">
					<div class="details_details_right_div1_div1 left">${model.title}</div>
					<div class="details_details_right_div1_div2 right">
						<a class="details_details_right_div1_div2_a1 left" href="###"></a>
						<a class="details_details_right_div1_div2_a2 left" href="###"></a>
						<a class="details_details_right_div1_div2_a3 left" href="###"></a>
						<img class="details_details_right_div1_div2_img1"
							src="<%=request.getContextPath()%>/images/pc/100.gif" />
					</div>
				</div>
				<p class="details_details_right_p1">
					【<span><a href="#">${model.designerName}</a></span>】
				</p>
				<p class="details_details_right_p2">
					<span class="details_details_right_p2_sp1">￥<span
						id="modelprice">${model.price}</span></span> <span
						class="details_details_right_p2_sp2">运费<span
						id="msModtransport">0</span>元
					</span>
				</p>
				<img src="<%=request.getContextPath()%>/images/pc/087.gif" />
				<div class="details_details_right_div2">
					<p></p>
				</div>
				<div class="details_details_right_div3">
					<span class="details_details_right_div3_sp1 left">材质</span>
					<div class="details_details_right_div3_div1 left">
						<c:forEach items="${model.texttrueList}" var="modelTypeTextture">
							<c:if test="${modelTypeTextture.modtImg!='url_null'}">
								<a class="" href="###" name="${modelTypeTextture.modtTexture}"><img
									title="${modelTypeTextture.modtTexture}"
									src="<%=request.getContextPath()%>/upload/uploadImg/textture/${modelTypeTextture.modtImg}" /></a>
							</c:if>
							<c:if test="${modelTypeTextture.modtImg=='url_null'}">
								<a class="" href="###" name="${modelTypeTextture.modtTexture}"><span>${modelTypeTextture.modtTexture}</span></a>
							</c:if>
						</c:forEach>
					</div>
					<div class="clears"></div>
				</div>
				<div class="details_details_right_div4">
					<span class="details_details_right_div4_sp1 left">尺寸</span>
					<div class="details_details_right_div4_div1 left">
						<c:forEach items="${model.sizeList}" var="modelTypeSize">
							<a class="" href="###"><span>${modelTypeSize.modtSize}</span></a>
						</c:forEach>
					</div>
					<div class="clears"></div>
				</div>

				<div class="details_details_right_div6">
					<span class="details_details_right_div6_sp1 left">数量</span> <a
						href="###" class="details_details_right_div6_a1 left">-</a> <span
						class="details_details_right_div6_sp2 left" id="modelcount">1</span>
					<a href="###" class="details_details_right_div6_a2 left">+</a> <span
						class="details_details_right_div6_sp3 left">库存<span
						id="modtRepertory">${model.modRepertory}</span></span>
				</div>
				<div class="details_details_right_div7">
					<div class="details_details_right_div7_div1 left">
						<a href="###" onclick="gopay()" id="buynow">立即购买</a>
						<div></div>
					</div>
					<div class="details_details_right_div7_div2 left">
						<a href="###" onclick="return addshopping()">加入购物车</a>
						<div></div>
					</div>
					<div class="details_details_right_div7_div3 left">
						<c:if test="${model.mcId=='' || model.mcId==null}">
							<a class="details_details_right_div7_div3_a1" href="###"
								onclick="collection(1)">收藏</a>
							<a class="details_details_right_div7_div3_a2" href="###">已收藏</a>
						</c:if>
						<c:if test="${model.mcId!='' && model.mcId!=null}">
							<a class="details_details_right_div7_div3_a3" href="###"
								onclick="collection(2)">已收藏</a>
						</c:if>
					</div>

				</div>

				<img src="<%=request.getContextPath()%>/images/pc/087.gif" />
				<div class="details_details_right_div8">服务：${model.modServe}</div>

			</div>
		</div>

	</div>
	<!--
        	作者：offline
        	时间：2016-01-18
        	描述：加入购物车弹框
        -->
	<div class="motai_jiaru">
		<div class="motai_jiaru_div1">
			<img class="motai_jiaru_div1_img1"
				src="<%=request.getContextPath()%>/images/pc/102.gif" />
			<div class="motai_jiaru_div1_div1">
				<img class="motai_jiaru_div1_div1_img1 left"
					src="<%=request.getContextPath()%>/images/pc/101.gif" />
				<div class="motai_jiaru_div1_div1_div1 left">
					<p class="motai_jiaru_div1_div1_div1_p1">加入购物车成功！</p>
					<p class="motai_jiaru_div1_div1_div1_p2">
						您的购物车已经有<span id="countUserModel"></span>件产品。
					</p>
				</div>
			</div>
			<div class="motai_jiaru_div2 clears">
				<div class="motai_jiaru_div2_div1 left">
					<a href="#" onclick="gotoShopping()">去结算</a>
					<div></div>
				</div>
				<div class="motai_jiaru_div2_div2 left">
					<a
						href="<%=request.getContextPath()%>/modelController/gotoModelListPC.do">继续购物</a>
					<div></div>
				</div>
			</div>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-10
        	描述：商品详情和评论
        -->
	<div class="details_textimg_top">
		<p class="details_textimg_top_p1">
			<a href="#" onclick="changeMark(2)">商品详情DETAILS</a>
		</p>
		<p class="details_textimg_top_p2">
			<a href="#" onclick="changeMark(1)">评论(<span>${comment.pageInfo.totalRec}</span>)COMMENTS
			</a>
		</p>
	</div>
	<div class="details_textimg">

		<div class="shangpinxingqing">
			<div class="details_textimg_center">
				<ul class="details_textimg_center_ul1">
					<li>品牌：${model.brand}</li>
					<li>品牌属地：${model.brandPlace}</li>
				</ul>
				<ul class="details_textimg_center_ul2">

					<li>物料：${model.modElement}</li>
					<li>重量：${model.modWeight}</li>
				</ul>
				<ul class="details_textimg_center_ul3">
					<li>尺寸：${model.modSize}</li>
					<li>温馨提示：${model.modServe}</li>
				</ul>
			</div>
			<div class="details_textimg_brand">
				<p class="details_textimg_brand_p1">品牌故事</p>
				<p class="details_textimg_brand_p2">${model.dbrandStory}</p>
			</div>
			<div class="details_textimg_shop">
				<p class="details_textimg_shop_p1">商品详情</p>
				<div class="details_textimg_shop_div1">${model.modDetail}</div>
			</div>
		</div>
		<div class="pinglun">
			<div class="pinglun_div1">
				<div class="pinglun_div1_div1 left">
					<img src="<%=request.getContextPath()%>/images/pc/088.gif" />
				</div>
				<div class="pinglun_div1_div2 left">
					<img src="<%=request.getContextPath()%>/images/pc/089.gif" />
					<p>评论：</p>
					<textarea id="commContent"></textarea>
					<a href="###" onclick="commSubmit()">发布</a>
				</div>
			</div>
			<c:forEach items="${commentList}" var="comment" varStatus="i">
				<div class="pinglun_div2">
					<div class="pinglun_div2_div1 left">
						<c:if test="${comment.userImg=='' || comment.userImg=='null'}">
							<img
								src="<%=request.getContextPath()%>/images/pc/defalut_useravator.png" />
						</c:if>
						<c:if test="${comment.userImg!='' && comment.userImg!='null'}">
							<img
								src="<%=request.getContextPath()%>/upload/uploadImg/user/${comment.userImg}" />
						</c:if>
					</div>
					<div class="pinglun_div2_div2 left">
						<p class="pinglun_div2_div2_p1">
							<span class="pinglun_div2_div2_p1_sp1">${comment.username}</span>
							<span class="pinglun_div2_div2_p1_sp2"><fmt:formatDate
									value="${comment.addTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
						</p>
						<div class="pinglun_div2_div2_div1">
							<img src="<%=request.getContextPath()%>/images/pc/090.gif" />
							${comment.content}
						</div>
					</div>
					<div class="pinglun_div2_div3"></div>
				</div>
			</c:forEach>
			<form id="sform" action="gotoModelDetailPC.do" method="post">
				<input type="hidden" name="mid" value="${comment.mid}" /> <input
					type="hidden" name="pageIndex" id="pageIndex"
					value="${comment.pageInfo.pageIndex}" /> <input type="hidden"
					id="markView" name="markView" value="${comment.markView}" /><input
					type="hidden" id="uid" name="uid" value="160" />

			</form>
			<div class="page" style="margin-left: 15px;">
				<!-- 分页 -->
				<c:set value="${comment.pageInfo}" var="pageInfo"></c:set>
				<%@include file="../template/pageTemplate.jsp"%>
			</div>

		</div>
		<div class="details_textimg_servic">
			<div class="details_textimg_servic_div1">
				<p>售后服务SERVICE</p>
			</div>
			<div class="details_textimg_servic_div2">也唐王为您提供7天货品质量也唐王为您提供7天货品质量也唐王为您提供7天货品质量也唐王为您提供7天货品质量</div>
			<div class="details_textimg_servic_div2">也唐王提供7天货品质量也唐王为您提供7天货品质量也唐王为您提供7天货品质量</div>
			<p class="details_textimg_servic_p1">
				<a href="#">查看更多</a>
			</p>
		</div>
		<div class="details_textimg_servic">
			<div class="details_textimg_servic_div1">
				<p>关于配送DISTRIBUTION</p>
			</div>
			<div class="details_textimg_servic_div2">也唐王为您提供7天货品质量也唐王为您提供7天货品质量也唐王为您提供7天货品质量也唐王为您提供7天货品质量</div>
			<div class="details_textimg_servic_div2">为您提供7天货品质量也唐王为您提供7天货品质量也唐王为您提供7天货品质量</div>
			<p class="details_textimg_servic_p1">
				<a href="#">查看更多</a>
			</p>
		</div>
	</div>
	<!--
        	作者：offline
        	时间：2015-12-10
        	描述：推荐产品
        -->
	<div class="recent1">
		<div class="recent1_top">爱体验推荐产品</div>
		<div class="recent1_img">
			<c:forEach items="${recommendList}" var="recommend">
				<img
					src="<%=request.getContextPath()%>/upload/uploadImg/model/${recommend.img}"
					onclick="to_modeldetail('${recommend.mid}')" />
			</c:forEach>
		</div>
	</div>
	<div style="height: 100px; clear: both"></div>
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
	function showView() {
		var markView = $("#markView").val();
		if (markView == 1) {//显示评论
			var $shang = $(".shangpinxingqing");
			var $ping = $(".pinglun");
			$ping.css({
				"display" : "block"
			});
			$shang.css({
				"display" : "none"
			});
			$(".details_textimg_top_p2 a").css({
				"border-bottom" : "2px solid #000"
			})
			$(".details_textimg_top_p1 a").css({
				"border" : "0"
			})
		}

		//标签样式

	}
	//发布评论
	function commSubmit() {
		//1.判断用户是否登录，若没有登录，先登录；  
		var uid = $("#yfhl_user").val();
		if (uid == "" || uid == null) {
			window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
			return false;
		}
		//2.获取提交信息
		var commContent = $("#commContent").val();//评论内容
		var modelid = $("#modelid").val();//商品Id
		var pageIndex = $("#pageIndex").val();//当前页
		var markView = $("#markView").val();//标记是否显示评论

		$.ajax({
					type : "post",
					url : "<%=request.getContextPath()%>/comment/addComment.do",
					data : {
						content : commContent,
						mid : modelid,
						uid : uid
					},
					dataType : 'text',
					success : function(result) {
						document.write('<form action="<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do" method="post" name="formx3" style="display:none">');
						document.write('<input type="hidden" name="mid" value="'+modelid+'"/>');
						document
								.write('<input type="hidden" name="markView" value="'+markView+'"/>');
						document
								.write('<input type="hidden" name="pageIndex" value="'+pageIndex+'"/>');
						document
								.write('<input type="hidden" name="uid" value="'+uid+'"/>');
						document.write("</form>");
						document.formx3.submit();
					},

				});

	}
	//改变初始界面时展示的是商品详情还是评论信息：1：商品评论；2：商品详情 
	function changeMark(type) {
		if (type == 1) {
			$("#markView").val("1");
		} else if (type == 2) {
			$("#markView").val("2");
		}
		var markView = $("#markView").val();
	}
	//收藏操作 ：type:1添加收藏；2.取消收藏
	function collection(type) {
		//判断是否已经登录
		var uid = $("#yfhl_user").val();
		if (uid == "" || uid == null) {
			window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
			return false;
		}
		//获取提交信息
		var mcId = $("#mcId").val();//收藏ID
		var modelid = $("#modelid").val();//商品Id
		var mcdesignerid = $("#autherID").val();//商品作者ID

		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/modelCollectionController/modelCollection.do",
			data : {
				mcId : mcId,
				mcModelid : modelid,
				mcDesignerid : mcdesignerid,
				mcUserid : uid,
				markType : type
			},
			dataType : 'text',
			success : function(result) {

				if (result == 1) {
					$(".details_details_right_div5_div").css({
						"display" : "none"
					});
					$(".details_details_right_div5_div2").css({
						"display" : "block"
					});
				}
			},

		});

	}
	//加入购物车
	function addshopping() {
		//判断是否已经登录
		var uid = $("#yfhl_user").val();
		// alert(uid);
		if (uid == "" || uid == null) {
			window.location.href = "<%=request.getContextPath()%>/login/gotoIndexPC.do";
			return false;
		}
		//获取提交信息
		//商品Id
		var modelid = $("#modelid").val();
		//商品名称
		var modelname = $("#modelname").val();
		//商品品牌
		var brand = $("#brand").val();
		//商品图片
		var modelimg = $("#modelimg")[0].src;
		modelimg = modelimg.substring(modelimg.lastIndexOf("/") + 1,
				modelimg.length);
		//商品材质
		var val_textture = $("#val_textture").val();
		if (val_textture == '') {
			alert("请选择商品材质");
			return false;
		}
		//尺寸
		var val_size = $("#val_size").val();
		if (val_size == '') {
			alert("请选择商品尺寸");
			return false;
		}
		//数量
		var modelcount = $("#modelcount").text();
		//alert(modelcount);
		//价格
		var modelprice = $("#modelprice").text();
		//alert(modelprice);
		//运费
		var msModtransport = $("#msModtransport").text();
		//alert(msModtransport);
		//设计师ID
		var autherID = $("#autherID").val();
		//商品来源
		var modSelfDesigner = $("#modSelfDesigner").val();

		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/modelShopping/modelShopping.do",
			data : {
				msModelid : modelid,
				msModelname : modelname,
				msModelbrand : brand,
				msModelimg : modelimg,
				msModtexture : val_textture,
				msModsize : val_size,
				msModcount : modelcount,
				msModprice : modelprice,
				msModtransport : msModtransport,
				msUid : uid,
				msSelfDesigner : modSelfDesigner

			},
			dataType : 'text',
			success : function(result) {
				if (result != 0) {
					$("#countUserModel").text(result);
					$(".motai_jiaru").css({
						"display" : "block"
					});
					$("#shoppingCount").text(result);
				}

			},
			error : function() {
				alert("失败！");
			}

		});

	}

	//设置商品规格信息:type:1:材质；2s:尺寸
	function setModeltype(type, val) {
		//设置隐藏值
		if (type == 1) {
			$("#val_textture").val(val);
		} else if (type == 2) {
			$("#val_size").val(val);
		}

		//异步查询价格信息
		//商品材质
		var val_textture = $("#val_textture").val();
		if (val_textture == '') {
			return false;
		}
		//尺寸
		var val_size = $("#val_size").val();
		if (val_size == '') {
			return false;
		}
		//商品Id
		var modelid = $("#modelid").val();
		$.ajax({
			type : "post",
			url : "<%=request.getContextPath()%>/modelTypeController/queryModelTypeByself.do",
			data : {
				modtModid : modelid,
				modtTexture : val_textture,
				modtSize : val_size

			},
			dataType : 'text',
			success : function(result) {
				if (result != "") {
					var ret = JSON.parse(result);
					$("#modelprice").text(ret.modtPrice.toFixed(2));
					$("#modtRepertory").text(ret.modtRepertory);
				} else {
					alert("暂无商品型号");
				}

			},
			error : function() {
				alert("失败！");
			}

		});

	}
	//商品数量添加减少
	var index = 1;//全局变量INDEX 代表商品 数量
	function dian(num) {
		if (index == 1 && num < 1) {
			//alert("最少一件")
		} else {
			index = index + num
			$(".details_details_right_div4_div").html(index);
		}

	};

	//立即购买
	function gopay() {
		//判断是否已经登录
		var uid = $("#yfhl_user").val();
		if (uid == "" || uid == null) {
			gotoLogin();//去登陆页面
			return false;
		}
		//判断库存
		var qty=$("#modtRepertory").text();
		if(Number(qty)==0){
		  alert("对不起，该商品库存不足啦，您可以先添加都购物车中哦！！");
		  return false;
		}
		//获取提交信息
		//商品Id
		var modelid = $("#modelid").val();
		//商品名称
		var modelname = $("#modelname").val();
		//商品品牌
		var brand = $("#brand").val();
		//商品图片
		var modelimg = $("#modelimg")[0].src;
		modelimg = modelimg.substring(modelimg.lastIndexOf("/") + 1,
				modelimg.length);
		//商品材质
		var val_textture = $("#val_textture").val();
		if (val_textture == '') {
			alert("请选择商品材质");
			return false;
		}
		//尺寸
		var val_size = $("#val_size").val();
		if (val_size == '') {
			alert("请选择商品尺寸");
			return false;
		}
		//数量
		var modelcount = $("#modelcount").text();
		//alert(modelcount);
		//价格
		var modelprice = $("#modelprice").text();
		//alert(modelprice);
		//运费
		var msModtransport = $("#msModtransport").text();
		//alert(msModtransport);
		//设计师ID
		var autherID = $("#autherID").val();
		//商品来源
		var modSelfDesigner = $("#modSelfDesigner").val();
		//提交
		document
				.write('<form action="<%=request.getContextPath()%>/modelShopping/settleCountByDetail.do" method="post" name="formx1" style="display:none">');
		document.write('<input type="hidden" name="msUid" value="'+uid+'"/>');
		document
				.write('<input type="hidden" name="msModelid" value="'+modelid+'"/>');
		document
				.write('<input type="hidden" name="msModelname" value="'+modelname+'"/>');
		document
				.write('<input type="hidden" name="msModelbrand" value="'+brand+'"/>');
		document
				.write('<input type="hidden" name="msModelimg" value="'+modelimg+'"/>');
		document
				.write('<input type="hidden" name="msModtexture" value="'+val_textture+'"/>');
		document
				.write('<input type="hidden" name="msModsize" value="'+val_size+'"/>');
		document
				.write('<input type="hidden" name="msModcount" value="'+modelcount+'"/>');
		document
				.write('<input type="hidden" name="msModprice" value="'+modelprice+'"/>');
		document
				.write('<input type="hidden" name="msModtransport" value="'+msModtransport+'"/>');
		document
				.write('<input type="hidden" name="msSelfDesigner" value="'+modSelfDesigner+'"/>');
		document.write("</form>");
		document.formx1.submit();

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
	//跳转到商品详情页面
	function to_modeldetail(mid) {
		window.open("<%=request.getContextPath()%>/modelController/gotoModelDetailPC.do?mid="+mid);

	}
	//去登录页面
	function gotoLogin() {
		 $(".logincalss").css({"display":"block"});
	}
</script>
</html>