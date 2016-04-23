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
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog.js"></script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/newWell.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/luans.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banner操作页</title>


</head>
<body onload="setSelChecked()">
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;广告管理-
		<c:if test="${banner.markManage==1}">新增banner活动</c:if>
		<c:if test="${banner.markManage==2}">编辑banner活动</c:if>
	</h1>

	<form id="sform" action="bannerManage.do" method="post" align="center"
		style="margin-top: 0px;">
		<input type="hidden" name="markManage" id="markManage"
			value="${banner.markManage}" /> <input type="hidden" id="pageIndex"
			name="pageIndex" value="${banner.pageInfo.pageIndex}" /><input
			type="hidden" name="bannerid" id=bannerid value="${banner.bannerid}" /> <input
			type="hidden" name="banStation_sel" id="banStation_sel"
			value="${banner.banStation_sel}" /><input type="hidden"
			name="condition" id="condition" value="${banner.condition}" /> <input
			type="hidden" name="banOrder" id="banOrder"
			value="${banner.banOrder}" />
		<table align="center" height="90%">
			<tr height="13px">
				<td align="center">banner名称：</td>
				<td><c:if
						test="${banner.markManage==1 || banner.markManage==2}">
						<input type="text" placeholder="不能为空" id="banName" name="banName"
							value="${banner.banName}">
					</c:if> <c:if test="${banner.markManage==3}">${banner.banName}</c:if></td>
			</tr>
			<tr height="13px">
				<td align="center">排序：</td>
				<td><select id="order_sel" style="margin-left: 5px;"
					onchange="onchangeSel()">
						<option id="1">1</option>
						<option id="2">2</option>
						<option id="3">3</option>
						<option id="4">4</option>
						<option id="5">5</option>
						<option id="6">6</option>
						<option id="7">7</option>
						<option id="8">8</option>
						<option id="9">9</option>
				</select></td>

			</tr>

			<tr>
				<td>位置：</td>
				<td><c:if
						test="${banner.markManage==1 || banner.markManage==2}">
						<c:choose>

							<c:when test="${banner.banStation==1}">
								<input type="radio" name="banStation" checked="checked"
									value="1">PC &nbsp;&nbsp;
						<input type="radio" name="banStation" value="2">微信 &nbsp;&nbsp;</c:when>
							<c:when test="${banner.banStation==2}">
								<input type="radio" name="banStation" value="1">PC &nbsp;&nbsp;
						<input type="radio" name="banStation" checked="checked" value="2">微信 &nbsp;&nbsp;
				 </c:when>
							<c:otherwise>
								<input type="radio" name="banStation" checked="checked"
									value="1">PC &nbsp;&nbsp;
						<input type="radio" name="banStation" value="2">微信 &nbsp;&nbsp;
				 
				 </c:otherwise>

						</c:choose>
					</c:if> <c:if test="${banner.markManage==3 || banner.banStation==1}">PC</c:if>
					<c:if test="${banner.markManage==3 || banner.banStation==2}">微信</c:if>
				</td>
			</tr>
			<tr>
				<td>参与商品：</td>
				<td><c:if
						test="${banner.markManage==1 || banner.markManage==2}">
						<input type="button" onclick="openwindow('选择商品','400','650')"
							value="选择商品" class="btn btn-primary btn-sm" />
						<span id="banModcount_text">已经选择${banner.banModcount}件商品</span>
						<input type="hidden" name="banModcount" id="banModcount"
							value="${banner.banModcount}" />
						<input type="hidden" name="banUrlpath" id="banUrlpath"
							value="${banner.banUrlpath}" />
					</c:if> <c:if test="${banner.markManage==3}">${banner.banModcount}商品</c:if>
				</td>
			</tr>
			<tr>
				<td>参与链接：</td>
				<td><span id="banUrlpath_text">${banner.banUrlpath}</span></td>

			</tr>
			<tr>
				<td>是否显示：</td>
				<td><c:if
						test="${banner.markManage==1 || banner.markManage==2}">
						<c:choose>
							<c:when test="${banner.banState==1}">
								<input type="radio" name="banState" checked="checked" value="1">是 &nbsp;&nbsp;
						<input type="radio" name="banState" value="2">否 &nbsp;&nbsp;</c:when>
							<c:when test="${banner.banState==2}">
								<input type="radio" name="banState" value="1">是 &nbsp;&nbsp;
						<input type="radio" name="banState" checked="checked" value="2">否 &nbsp;&nbsp;
				 </c:when>
							<c:otherwise>
								<input type="radio" name="banState" value="1">是 &nbsp;&nbsp;
						<input type="radio" name="banState" checked="checked" value="2">否 &nbsp;&nbsp;
				 
				 </c:otherwise>
						</c:choose>
					</c:if> <c:if test="${banner.markManage==3 && banner.markManage==1}">是</c:if>
					<c:if test="${banner.markManage==3 && banner.markManage==2}">否</c:if></td>
			</tr>
			<tr>
				<td>banner图片：</td>
				<td><img id="imagez"
					src="<%=path%>/upload/uploadImg/banner/${banner.banImgurl}"
					style="width: 80px; height: 80px;" /> <c:if
						test="${banner.markManage==1 || banner.markManage==2}">
						<a href="#" class="file">banner上传 <input type="file"
							onchange="selectImagez(this);" />
						</a>
						<input type="hidden" id="banImgurl" name="banImgurl"
							value="${banner.banImgurl}" />
						<input type="hidden" name="oldImg" id="oldImg"
							value="${banner.banImgurl}" disabled="disabled" />
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><c:if
						test="${banner.markManage==1 || banner.markManage==2}">
						<input type="submit" onclick="return checkSubmit();" value="保存"
							class="btn btn-primary btn-sm" />
					</c:if> &nbsp;&nbsp;<input type="button" onclick="back()" value="返回"
					class="btn btn-primary btn-sm" /></td>

			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
 
    //提交验证
	function checkSubmit() {
		//1.验证banner名称
		var banName = $("#banName").val();
		if (banName== null || banName == '') {
			alert("banner名称不能为空！");
			return false;
		}
		//2.验证banner图片
		var banImgurl = $("#banImgurl").val();
		if (banImgurl == null || banImgurl == '') {
			alert("请上传banner图片！");
		 
			return false;
		}  
		//3.验证是否选择商品
		var banUrlpath=$("#banUrlpath").val();
		if(banUrlpath.length==0){
			alert("请选择商品");
			return false;
		}
		//4.验证排序
		var banOrder=$("#banOrder").val();
		if(banOrder.length==0){
			$("#banOrder").val(1);
		}
		return true;
	}
	 
	//返回事件
	function back(){
		var pageIndex = $("#pageIndex").val();
		var banStation_sel=$("#banStation_sel").val();
		var condition=$("#condition").val();
		window.location.href="<%=request.getContextPath()%>/bannerController/queryListByPage.do?pageInfo.pageIndex="
				+ pageIndex + "&banStation_sel=" + banStation_sel+"&condition="+condition;
	}
	//上传头像
	function selectImagez(file) {
		if (!file.files || !file.files[0]) {
			return;
		}
		var image = '';
		var reader = new FileReader();
		reader.onload = function(evt) {
			document.getElementById('imagez').src = evt.target.result;
			image = evt.target.result;
			$.ajax({
					 type : "post",
					 url : '<%=request.getContextPath()%>/imageController/updateImg.do',
						data : {
							image : image,
							oldImg : file.id,
							path : "upload/uploadImg/banner/"
						},
						async : false,
						dataType : 'json',
						success : function(data) {
							//alert(data);//返回上传图片的名字
							$("#banImgurl").val(data);
							file.id = data;
						},
						error : function(err) {
							alert(err)
							alert('网络故障');
						}
					});
		}
		reader.readAsDataURL(file.files[0]);
	}
	
	//选择按钮点击事件
	function openwindow(name, iWidth, iHeight) {
        var banUrlpath=$("#banUrlpath").val();
		var name; //网页名称，可为空;
		var iWidth; //弹出窗口的宽度;
		var iHeight; //弹出窗口的高度;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		var url= "<%=request.getContextPath()%>/modelController/queryModelsel.do?oldmodelids="+banUrlpath;//跳转路径

		window
				.open(
						url,
						name,
						'height='
								+ iHeight
								+ ',innerHeight='
								+ iHeight
								+ ',width='
								+ iWidth
								+ ',innerWidth='
								+ iWidth
								+ ',top='
								+ iTop
								+ ',left='
								+ iLeft
								+ ',toolbar=yes,menubar=yes,scrollbars=yes,resizeable=yes,location=no,status=no');

	}

	//回调方法：用于给商品类别赋值
	function setModelCount(count, modelids) {
		if (modelids.length > 50) {
			$("#banUrlpath_text").text(modelids.substring(0, 100) + "...");
		} else {
			$("#banUrlpath_text").text(modelids);
		}
		$("#banModcount_text").text("已经选择" + count + "件商品");
		$("#banUrlpath").val(modelids);
		$("#banModcount").val(count);

	}
	//页面加载完后设置下拉框的选中值
	function setSelChecked() {
		var banOrder = $("#banOrder").val();
		if (banOrder != "") {
			document.getElementById("order_sel").value = banOrder;

		}
	}
	//下拉框的改变事件
	function onchangeSel() {
		var sel = document.getElementById("order_sel").value;
		$("#banOrder").val(sel);

	}
</script>
</html>