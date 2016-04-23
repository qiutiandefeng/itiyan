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
	src="<%=request.getContextPath()%>/js/editor/kindeditor.js"></script>
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
<title>商品管理页</title>

<script type="text/javascript">
	//屏蔽点击键盘Backspace键，页面向后跳转
	window.onload = function() {
		//获取事件对象  
		var elem = event.relatedTarget || event.srcElement || event.target
				|| event.currentTarget;
		if (event.keyCode == 8) {//判断按键为backSpace键  
			//获取按键按下时光标做指向的element  
			var elem = event.srcElement || event.currentTarget;

			//判断是否需要阻止按下键盘的事件默认传递  
			var name = elem.nodeName;

			if (name != 'INPUT' && name != 'TEXTAREA') {
				return _stopIt(event);
			}
			var type_e = elem.type.toUpperCase();
			if (name == 'INPUT'
					&& (type_e != 'TEXT' && type_e != 'TEXTAREA'
							&& type_e != 'PASSWORD' && type_e != 'FILE')) {
				return _stopIt(event);
			}
			if (name == 'INPUT'
					&& (elem.readOnly == true || elem.disabled == true)) {
				return _stopIt(event);
			}
		}
       //展示图片
       var img=$("#img").val();//获取隐藏图片路径 ..//updateImg/
       var imgbrand='<img  src="..//updateImg/${user.avatar}" style="width: 80px; height: 80px;" />';   
       if(img.length>0){
    	   var imgs=img.split(";");
    	   for(var i=0;i<imgs.length;i++){
    		   $("#fileimg").before('<img  src="..//updateImg/'+imgs[i]+'" alt="暂无图片" style="width: 80px; height: 80px;" />&nbsp;&nbsp;'); 
    	   }
       }
	}
	function _stopIt(e) {
		if (e.returnValue) {
			e.returnValue = false;
		}
		if (e.preventDefault) {
			e.preventDefault();
		}

		return false;
	}
	//提交验证
	function checkSubmit() {
	 
		 //1.验证商品名称
		 var title=$("#title");
		 if(title.val()==''|| title.val()==null){
			 alert("商品名称不能为空！");
			 title.focus();
			 return false;
		 }
		 //	2.验证设计师
		 var author=$("#designerName");
		 if(author.val()=="" || author.val()==null){
			 alert("请选择设计师，设计师不能为空！");
			 author.focus();
			 return false;
		 }
		 //3.验证商品类目
		 var categoryName=$("#categoryName");
		 if(categoryName.val()=="" || categoryName.val()==null){
			 alert("请选择商品类目，商品类目不能为空！");
			 categoryName.focus();
			 return false;
		 }
		 //4.验证价格
		 var price=$("#price");
		 if(price.val()=="" || prive.val()==null){
			 alert("请填写商品价格，商品价格不能为空！");
			 price.focus();
			 return false;
		 }else if(isNaN(price.val())){
			 alert("价格格式不正确，价格只能为数字！");
			 price.focus();
			 return false;
		 }
		 //5.验证库存
		 var modRepertory=$("#modRepertory");
		 if(isNaN(modRepertory.val())){
			 alert("库存格式不正确，库存只能为数字！");
			 modRepertory.focus();
			 return false;
		 }
		 return true;
	}
	//输入信息验证
	function checkView(obj) {
		var val = $.trim(obj.value);//值去掉前后空格
		var content;//提示信息

		if (obj.id == 'title') {
			content = "商品名称不能为空";
		} else if (obj.id == 'price') {
			content = '价格只能为数字！';
		} else if (obj.id == 'modRepertory') {
			content = '库存只能为数字！';
		} 
		//非空验证
		if ((val == '' || val == null) && obj.id != 'price' && obj.id != 'modRepertory') {
			 
			obj.style.color = "#FF0000";
			obj.placeholder = content;
			return 1;
		} else {
			obj.style.color = "#110000";
		}
		//数字验证
		if (val != '' && (obj.id == 'price' || obj.id == 'modRepertory') && isNaN(val)) {
			alert(content);
			obj.focus();
			return 2;
		}
		return 1;
	}
	//获得焦点事件
	function getfocus(obj) {
		obj.style.color = "black";
	}
	//选择按钮点击事件
	function openwindow(type,name, iWidth, iHeight) {
   
		var name; //网页名称，可为空;
		var iWidth; //弹出窗口的宽度;
		var iHeight; //弹出窗口的高度;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		var url;//跳转路径:1:设计师；2：商品类别
		if(type==1){
			url="<%=request.getContextPath()%>/userManage/queryList.do?pageInfo.pageIndex=1&groupId=4&markUserfrom=1&markSelect=1";
		}else if(type==2){
			url="<%=request.getContextPath()%>/categoryController/queryCategory_sel.do";
		}
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
	//回调方法：用于给设计师赋值
	function setDesigner(author, designerName) {
		$("#author").val(author);
		$("#designerName").val(designerName);
	}
	//回调方法：用于给商品类别赋值
	function setCategory(type, categoryId, categoryName, parentId) {
		$("#markCategory").val(type);
		$("#categoryId").val(categoryId);
		$("#categoryName").val(categoryName);
		$("#modCategoryParentid").val(parentId);
	}
	//取消事件
	function back() {
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var condition_categoryid=$("#condition_categoryid").val();
		var condition_categoryName=$("#condition_categoryName").val();
		var condition_status=$("#condition_status").val();
		var markCategory=$("#markCategory").val();
		window.location.href="<%=request.getContextPath()%>/modelController/queryList.do?pageInfo.pageIndex="
				+ pageIndex
				+ "&condition="
				+ condition
				+ "&condition_categoryid="
				+ condition_categoryid
				+ "&condition_categoryName=" 
				+ condition_categoryName
				+ "&condition_status="
				+ condition_status + "&markCategory=" + markCategory;
	}
	//上传图片
	function selectImagez(file) {
		if (!file.files || !file.files[0]) {
			return;
		}
		var image = '';
		var reader = new FileReader();
		reader.onload = function(evt) {
			//document.getElementById('imagez').src = evt.target.result;
			image = evt.target.result;
			$.ajax({
				type : "post",
				url : '<%=request.getContextPath()%>/imageController/updateImg.do',
						data : {
							image : image
						},
						async : false,
						dataType : 'json',
						success : function(data) {
							var oldimg = $("#img").val();
							if ($("#img").val().length > 0) {
								$("#img").val(oldimg + ";" + data);
							} else {
								$("#img").val(data);
							}
							$("#fileimg")
									.before(
											'&nbsp;<img  src="..//updateImg/'+data+'" alt="<%=request.getContextPath()%>/images/no_picture.png" style="width: 80px; height: 80px;" />');
						},
						error : function(err) {
							alert(err)
							alert('网络故障');
						}
					});
		}
		reader.readAsDataURL(file.files[0]);
	}
</script>
<script type="text/javascript">
	KE.show({
		id : 'modDetail',
		cssPath : './index.css'
	});
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;商品管理-
		<c:if test="${user.markManage==1}">新增商品</c:if>
		<c:if test="${user.markManage==2}">编辑商品</c:if>
	</h1>

	<form id="sform" action="modelManage.do" method="post" align="center"
		style="margin-top: 30px;">
		<input type="hidden" name="markManage" id="markManage"
			value="${model.markManage}" /> <input type="hidden" id="pageIndex"
			name="pageInfo.pageIndex" value="${model.pageInfo.pageIndex}" /> <input
			type="hidden" name="mid" id="mid" value="${model.mid}" /><input
			type="hidden" id="pageIndex" name="pageIndex"
			value="${model.pageInfo.pageIndex}" /> <input type="hidden"
			name="condition" id="condition" value="${model.condition}" /><input
			type="hidden" id="condition_status" name="condition_status"
			value="${model.condition_status}" /> <input type="hidden"
			id="condition_categoryid" name="condition_categoryid"
			value="${model.condition_categoryid}" /> <input type="hidden"
			id="condition_categoryName" name="condition_categoryName"
			value="${model.condition_categoryName}" /> <input type="hidden"
			id="markCategory" name="markCategory" value="${model.markCategory}" />


		<table align="center" height="90%">
			<tr height="13px">
				<td>商品名称：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" placeholder="不能为空" id="title" name="title"
							onblur="checkView(this);" onfocus="getfocus(this);"
							style="margin-top: 0px;" value="${model.title}"
							class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.title}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>设 计 师：</td>
				<c:if test="${model.markManage==1 || model.markManage==2}">
					<td><input type="text" placeholder="不能为空" disabled="disabled"
						id="designerName" style="margin-top: 0px;"
						value="${model.designerName}" class="nav-search-input" /></td>
					<td><input type="button" class="btn btn-primary btn-sm"
						onclick="openwindow(1,'选择设计师','1000','500');" value="选择设计师" /> <input
						type="hidden" name="author" id="author" value="${model.author}" /></td>
				</c:if>
				<c:if test="${model.markManage==3}">
					<td>${model.designerName}</td>
					<td>&nbsp;</td>
				</c:if>
			</tr>
			<tr>
				<td>品&nbsp;&nbsp;&nbsp;&nbsp;牌：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" id="brand" name=brand style="margin-top: 0px;"
							value="${model.brand}" class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.brand}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>所属类目：</td>
				<c:if test="${model.markManage==1 || model.markManage==2}">
					<td><input type="text" placeholder="不能为空" disabled="disabled"
						id="categoryName" style="margin-top: 0px;"
						value="${model.designerName}" class="nav-search-input"></td>
					<td><input type="button" class="btn btn-primary btn-sm"
						onclick="openwindow(2,'选择商品类目','1000','500');" value="选择商品类目" />
						<input type="hidden" name="categoryId" id="categoryId"
						value="${model.categoryId}" /> <input type="hidden"
						id="modCategoryParentid" name="modCategoryParentid"
						value="${model.modCategoryParentid}" /></td>
				</c:if>
				<c:if test="${model.markManage==3}">
					<td>${model.designerName}</td>
					<td>&nbsp;</td>
				</c:if>

			</tr>
			<tr>
				<td>价&nbsp;&nbsp;&nbsp;&nbsp;格：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" id="price" name="price"
							onblur="checkView(this);" onfocus="getfocus(this);"
							style="margin-top: 0px;" value="${model.price}"
							class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.price}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>型号类别：</td>
				<td>如本商品有多种型号，价格不同请选择此项</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>库&nbsp;&nbsp;&nbsp;&nbsp;存：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" id="modRepertory" name="modRepertory"
							onblur="checkView(this);" onfocus="getfocus(this);"
							style="margin-top: 0px;" value="${model.modRepertory}"
							class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.modRepertory}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>商品状态：</td>
				<c:choose>
					<c:when test="${model.status==1}">
						<td>审核中</td>
					</c:when>
					<c:when test="${model.status==2}">
						<td>展示中</td>
					</c:when>
					<c:when test="${model.status==3}">
						<td>已下架</td>
					</c:when>
					<c:when test="${model.status==4}">
						<td>暂不出售</td>
					</c:when>
					<c:otherwise>
						<td>未审核</td>
					</c:otherwise>
				</c:choose>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>是否推荐：</td>
				<td><select id="recommend_sel" name="recommend"
					style="margin-left: 5px;"><c:choose>
							<c:when test="${model.recommend==1}">
								<option id="1" value="1">推荐</option>
								<option id="2" selected="selected" value="2">可推荐</option>
							</c:when>
							<c:otherwise>
								<option id="1" value="1">推荐</option>
								<option id="2" selected="selected" value="2">不推荐</option>
							</c:otherwise>
						</c:choose>
				</select></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>展示图片：</td>
				<td><input type="hidden" id="img" name="img"
					value="${model.img}" /> <input type="hidden" id="fileimg" /> <c:if
						test="${model.markManage==1 || model.markManage==2}">
						<a href="#" class="file">选择头像 <input type="file"
							onchange="selectImagez(this);" />
						</a>

					</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>商品详情：</td>
				<td colspan="2"><textarea id="modDetail" name="modDetail">${model.modDetail}</textarea>
			</tr>
			<tr>
				<td>是否可定制：</td>
				<td><select id="customization_sel" name="customization"
					style="margin-left: 5px;"><c:choose>
							<c:when test="${model.customization==1}">
								<option id="0" value="0">不可定制</option>
								<option id="1" selected="selected" value="1">可定制</option>
							</c:when>
							<c:otherwise>
								<option id="0" selected="selected" value="0">不可定制</option>
								<option id="1" value="1">可定制</option>
							</c:otherwise>
						</c:choose>
				</select></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>可定制提示信息：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" id="customizationTip" name="customizationTip"
							style="margin-top: 0px;" value="${model.customizationTip}"
							class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.customizationTip}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>品牌属地：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" id="brandPlace" name="brandPlace"
							style="margin-top: 0px;" value="${model.brandPlace}"
							class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.brandPlace}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>送货时间：</td>
				<td><c:if test="${model.markManage==1 || model.markManage==2}">
						<input type="text" id="deliveryTime" name="deliveryTime"
							style="margin-top: 0px;" value="${model.deliveryTime}"
							class="nav-search-input">
					</c:if> <c:if test="${model.markManage==3}">${model.deliveryTime}</c:if></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><c:if
						test="${model.markManage==1 || model.markManage==2}">
						<input type="submit" onclick="return checkSubmit()" value="保 存"
							class="btn btn-primary btn-sm" />
					</c:if> &nbsp;&nbsp; <input type="button" onclick="back()" value="返回"
					class="btn btn-primary btn-sm" /></td>

			</tr>
		</table>
	</form>




</body>
</html>