<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<link rel="stylesheet" href="<%=path%>/css/common.css">
<link rel="stylesheet" href="<%=path%>/css/indexcss.css">
<link rel="stylesheet" href="<%=path%>/css/font-awesome.css">

<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/layer.js"></script>
<script type="text/javascript">
	$(function() {
		var index = "";
		$("#mychange h3").bind("click", function() {
			$(this).children().addClass('clickClass');
			$(this).siblings().children().removeClass("clickClass");
		});
		$("#btn_parent").click(function() {
			index = layer.load(1, {
				shade : [ 0.1, '#fff' ]
			//0.1透明度的白色背景
			});
		});
		$("#btn_close").click(function() {
			layer.close(index); //关闭加载层
		});

		$(".main-btn a").on("click", function() {
			var left = $(".side").css("left");
			if (left != "0px") {
				$(".side").animate({
					left : "0px"
				});
				$(".main").animate({
					left : "206px"
				});
				$(".main-btn a").attr("class", "main-unfold");
			} else {
				$(".side").animate({
					left : "-200px"
				});

				$(".main").animate({
					left : "0px"
				});
				$(this).attr("class", "main-fold");
			}
		});

		$(".top-btn a").on("click", function() {
			var top = $(".top").css("top");
			if (top != "0px") {
				$(".top").animate({
					top : "0px"
				});

				$(".side").animate({
					top : "125px"
				});
				$(".main").animate({
					top : "81px"
				});

				$(".top-btn").animate({
					bottom : "44px"
				})

				$(".top-btn a").attr("class", "top-unfold");
			} else {
				$(".top").animate({
					top : "-125px"
				});

				$(".top-btn").animate({
					bottom : "0px"
				})

				$(".side").animate({
					top : "0px"
				});
				$(".main").animate({
					top : "0px"
				});

				$(this).attr("class", "top-fold");
			}
		});

	});
</script>

<style type="text/css">
.clickClass {
	color: green;
}
</style>

<title>欢迎来到爱体验后台系统</title>
</head>
<body>
	<button style="display: none;" id="btn_parent"></button>
	<button style="display: none;" id="btn_close"></button>
	<div class="top">

		<div class="top-btn">
			<a class="top-unfold" href="javascript:void(0);"></a>
		</div>


		<div id="top_t">





			<div id="logo" class="fl"></div>
			<div id="photo_info" class="fr">
				<div id="photo" class="fl">
					<a href="#"><img src="<%=basePath%>/images/a.png" alt=""
						width="60" height="60"></a>
				</div>
				<div id="base_info" class="fr">
					<div class="help_info">
						<table>
							<tr>
								<td><a href="###"
									style="color: #094169; text-decoration: none; margin-left: 20px; font-size: 13px"
									target="right"></a> <a
									href="<%=basePath %>/login/logout.do"
									style="color: #094169; text-decoration: none; margin-left: -35px; font-size: 13px">
										<i class="ace-icon fa fa-power-off"></i>&nbsp;安全退出
								</a></td>

							</tr>
						</table>

					</div>
					<div class="info_center">欢迎您: ${yfhl_kj_user.username}</div>
				</div>
			</div>
		</div>
		<div id="side_here">
			<div id="side_here_l" class="fl"></div>
			<div id="here_area" class="fl">欢迎页面</div>
		</div>
	</div>
	<div class="side">


		<div class="sideMenu" style="margin: 0 auto">
			<span id="mychange">

				<h3>
					<a
						href="<%=path %>/login/xinxi.do"
						target="right">后台首页</a>
				</h3>
				<h3>
					<a
						href="<%=path%>/userManage/queryList.do?pageInfo.pageIndex=1&groupId=1&markUserfrom=1"
						target="right">爱体验用户</a>
				</h3>
				<h3>
					<a href="<%=path%>/modelController/queryList.do?pageInfo.pageIndex=1&modSelfDesigner=1"
						target="right">爱体验商品</a>
				</h3>
				<h3>
					<a
						href="<%=path%>/tradeManage/queryList.do?trdSelfDesigner=1"
						target="right">爱体验订单</a>
				</h3>
				<h3>
					<a
						href="<%=path%>/userManage/queryList.do?pageInfo.pageIndex=1&groupId=4&markUserfrom=1"
						target="right">设计师管理-设计师</a>
				</h3>
				<h3>
					<a
						href="<%=path%>/modelController/queryList.do?pageInfo.pageIndex=1&modSelfDesigner=2"
						target="right">设计师管理-设计师商品</a>
				</h3>
				<h3>
					<a
						href="<%=path%>/tradeManage/queryList.do?trdSelfDesigner=2"
						target="right">设计师管理-设计师订单</a>
				</h3>
			<!-- 	<h3>
					<a
						href="###"
						target="right">设计师管理-品牌管理</a>
				</h3> -->
				<h3>
				    <a
						href="<%=path%>/designerApplyController/queryList.do?pageInfo.pageIndex=1"
						target="right">设计师管理-设计师审批</a>
				</h3>
				<h3>
					<a href="<%=path%>/categoryController/queryCategory.do" target="right">类目管理</a>
				</h3>
				<h3>
					<a
						href="<%=path %>/bannerController/queryListByPage.do?pageInfo.pageIndex=1"
						target="right">运营推广-广告管理</a>
				</h3>
	<!-- 		<h3>
					<a
						href="<%=path %>/login/xinxi.do"
						target="right">设计师管理-优惠活动管理</a>
				</h3> -->
				<h3>
					<a
						href="<%=path %>/login/xinxi.do"
						target="right">运营管理-微信首页推荐</a>
				</h3>
				<h3>
					<a href="<%=path%>/titleStore/adjust.do" target="right">数据统计-数据统计</a>
				</h3>
	<!-- 		<h3>
					<a href="###" target="right">数据统计-登录日志统计</a>
				</h3>
				<h3>
					<a href="###" target="right">百度数据</a>
				</h3>
				 -->
				<h3>
					<a href="<%=path%>/comment/queryList.do" target="right">消息中心-评论管理</a>
				</h3>
	<!--		<h3>
					<a href="<%=path%>/comment/queryList.do" target="right">消息中心-通知管理</a>
				</h3>
				-->
				<h3>
					<a href="<%=path%>/systemTools/selectDatabaseBackup.do" target="right">系统工具-数据库备份</a>
				</h3>
				<!-- 
				<h3>
					<a href="<%=path%>/systemTools/selectDatabaseBackup.do" target="right">系统工具-订单设置</a>
				</h3>
				<h3>
					<a href="<%=path%>/systemTools/selectDatabaseBackup.do" target="right">系统工具-缓存管理</a>
				</h3>
				 -->
				 
				 
				 
				
			
				
			</span>

		</div>

		<div class="main-btn">
			<a class="main-unfold" href="javascript:void(0);"></a>
		</div>

	</div>
	<div class="main">
		<iframe name="right" id="rightMain" src="<%=path %>/login/xinxi.do"
			frameborder="no" scrolling="auto" width="100%" height="auto"
			allowtransparency="true"></iframe>
	</div>
	<div class="bottom">
		<div id="bottom_bg">版权</div>

	</div>
	<div class="scroll">
		<a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏"
			onClick="menuScroll(1);"></a> <a href="javascript:;" class="next"
			title="使用鼠标滚轴滚动侧栏" onClick="menuScroll(2);"></a>
	</div>
</body>

</html>

