<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.yfhl.entity.ModelType"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("path:" + path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/js/kindeditor-4.1.10/kindeditor.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/manager/upload/webuploader.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/manager/upload/upload.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>/js/kindeditor-4.1.10/themes/default/default.css" />
<link rel="stylesheet"
	href="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.css" />
<link href="<%=path%>/css/manager/index.css" type="text/css"
	rel="stylesheet">
<link href="<%=path%>/css/manager/upload/style.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理页</title>


<script type="text/javascript">
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="modDetail"]', {
			cssPath : '<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.css',
			uploadJson : '<%=basePath%>/js/kindeditor-4.1.10/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/js/kindeditor-4.1.10/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
</script>
</head>
<body onload="updateMdel()">
	<div class="houtai">
		<div class="div1">爱体验商品管理</div>
		<div class="div2"></div>
		<div class="div3">
			<form id="sform" action="modelManage.do" method="post"
				style="margin-top: 30px;">
				<input type="hidden" id="texttureList" value="${texttureList}" /> <input
					type="hidden" id="sizeList" value="${sizeList}" /> <input
					type="hidden" id="modelTypeList" value="${modelTypeList}" /> <input
					type="hidden" name="markManage" id="markManage"
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
				<input type="hidden" name="modSelfDesigner" id="modSelfDesigner"
					value="${model.modSelfDesigner}" /> <input type="hidden"
					name="modelType" id="modelType" value="" /><input type="hidden"
					name="uid" value="${yfhl_kj_user.uid}" />
				<p class="div3_p1">商品添加</p>
				<div class="div3_div1">
					<span>所属类目：</span> <input type="text" placeholder="选择类目"
						disabled="disabled" id="categoryName"
						value="${model.categoryName}" class="div3_div1_input1"> <input
						type="button" class="div3_div1_input2"
						onclick="openwindow(2,'选择商品类目','460','600');" value="选择" /> <input
						type="hidden" name="categoryId" id="categoryId"
						value="${model.categoryId}" /> <input type="hidden"
						id="modCategoryParentid" name="modCategoryParentid"
						value="${model.modCategoryParentid}" /> <span
						class="div3_div1_sp1 red"><span id="warn_categoryName">请选择所属类目</span></span>
				</div>
				<div class="div3_div2">
					<div class="div3_div2_div1">
						<span class="div3_div2_div1_sp1">商品名称：</span> <span><input
							type="text" placeholder="输入商品名称" id="title" name="title"
							maxlength="30" onblur="checkisNull($('#title'),'title');"
							onfocus="getfocus(this);" value="${model.title}"
							class="nav-search-input"> </span> <span class="red"><span
							id="warn_title">请输入商品名称</span></span>
					</div>
					<c:if test="${model.modSelfDesigner==1}">
						<div class="div3_div2_div2">
							<span>品牌：</span> <input type="text" id="brandtext"
								name="brandtext" value="3DCREATIA" disabled="disabled" /><input
								type="hidden" name="brand" id="brand" value="3DCREATIA" /><input
								type="hidden" name="author" id="author" value="1" />
						</div>
					</c:if>
					<c:if test="${model.modSelfDesigner==2}">
						<div class="div3_div2_div2">
							<span>品牌：</span> <input type="text" id="brandtext"
								class="div3_div2_input1" name="brandtext" value=""
								disabled="disabled" /><input class="div3_div2_input2"
								type="button" value="选择品牌"
								onclick="openwindow(1,'选择品牌','460','600');" />
						</div>
						<div class="div3_div2_div2_1">
							<span>设计师:</span><input type="text" id="designer" value=""
								disabled="disabled" /> <input type="hidden" name="brand"
								id="brand" value="${model.brand}" /><input type="hidden"
								name="author" id="author" value="" />
						</div>
					</c:if>
					<c:if test="${model.modSelfDesigner==1}">
						<div class="div3_div2_div3">
							<span>服务：</span> <select id="modServe" name="modServe">
								<option>本商品由爱体验发出，承诺24小时之内发出</option>
							</select> <span class="div3_div2_div3_sp1 red"><span>请选则服务</span></span>
						</div>
					</c:if>
					<c:if test="${model.modSelfDesigner==2}">
						<div class="div3_div2_div3">
							<span>服务：</span> <input type="text" id="modServe"
								class="div3_div2_input1" name="modServe"
								value="${model.modServe}" />
						</div>
					</c:if>
				</div>
				<div class="div3_div3">
					<table class="div3_div3_tab1">
						<tr>
							<td class="div3_div3_tab1_text div3_div3_tab1_text4">货品产地：</td>
							<td><input type="text" id="modFrom" name="modFrom"
								onblur="checkisNull($('#modFrom'),'modFrom');"
								onfocus="getfocus(this);" value="${model.modFrom}" /> <span
								class="red"><span id="warn_modFrom">请输入货品产地</span></span></td>
							<td class="div3_div3_tab1_text div3_div3_tab1_text2">成份：</td>
							<td><input type="text" id="modElement" name="modElement"
								onblur="checkisNull($('#modElement'),'modElement');"
								onfocus="getfocus(this);" value="${model.modElement}" /> <span
								class="red"><span id="warn_modElement">请输入成份</span></span></td>
						</tr>
						<tr>
							<td class="div3_div3_tab1_text div3_div3_tab1_text4">品牌属地：</td>
							<td><input type="text" id="brandPlace" name="brandPlace"
								onblur="checkisNull($('#brandPlace'),'brandPlace');"
								onfocus="getfocus(this);" value="${model.brandPlace}" /> <span
								class="red"><span id="warn_brandPlace">请输入品牌属地</span></span></td>
							<td class="div3_div3_tab1_text div3_div3_tab1_text2">尺寸：</td>
							<td><input type="text" id="modSize" name="modSize"
								onblur="checkisNull($('#modSize'),'modSize');"
								onfocus="getfocus(this);" value="${model.modSize}" /> <span
								class="red"><span id="warn_modSize">请输入尺寸</span></span></td>
						</tr>
						<tr>
							<td class="div3_div3_tab1_text div3_div3_tab1_text2">重量：</td>
							<td><input type="text" id="modWeight" name="modWeight"
								onblur="checkisNull($('#modWeight'),'modWeight');"
								onfocus="getfocus(this);" value="${model.modWeight}" /> <span
								class="red"><span id="warn_modWeight">请输入重量</span></span></td>
							<td class="div3_div3_tab1_text">温馨提示：</td>
							<td><input type="text" maxlength="30" id="modRemark"
								name="modRemark" value="${model.modRemark}" /> <span>还能输入<span>30</span>个字
							</span></td>
						</tr>
					</table>
				</div>
				<div class="div3_div4">
					<div class="div3_div4_div1">
						<span>价格：</span> <input type="text" id="price" name="price"
							onblur="checkisNull($('#price'),'price');"
							onfocus="getfocus(this);" style="margin-top: 0px;"
							value="${model.price}"> <span
							class="div3_div4_div1_sp1 red"><span id="warn_price">请输入价格</span></span>
					</div>
					<div class="div3_div4_div2">
						<div class="div3_div4_div2_div1">型号组合：</div>

						<div class="div3_div4_div2_div2">
							<div class="div3_div4_div2_div2_div1">

								<span class="div3_div4_div2_div2_div1_sp2">提示：选中是可以编辑（10个字符之内）,请先选则好尺寸</span>
							</div>
							<table id="tab2">
								<p>尺寸：</p>
								<tr>
									<td id="td10"><input class="xiao inp1" id="checkbox10"
										type="checkbox" /><input class="inp2" id="checkbox10"
										type="text" value="均码（只有一个尺码时选择）" disabled="disabled" /></td>
									<td id="td11"><input class="xiao inp1" id="checkbox11"
										type="checkbox" /><input class="inp2" id="checkbox11"
										type="text" value="女款-13#" disabled="disabled" /></td>
									<td id="td12"><input class="xiao inp1" id="checkbox12"
										type="checkbox" /><input class="inp2" id="checkbox12"
										type="text" value="男款-19#" disabled="disabled" /></td>
									<td id="td13"><input class="xiao inp1" id="checkbox13"
										type="checkbox" /><input class="inp2" id="checkbox13"
										type="text" value="男款-21#" disabled="disabled" /></td>
								</tr>
								<tr>
									<td id="td14"><input class="xiao inp1" id="checkbox14"
										type="checkbox" /><input class="inp2" id="checkbox14"
										type="text" value="女款-12#" disabled="disabled" /></td>
									<td id="td15"><input class="xiao inp1" id="checkbox15"
										type="checkbox" /><input class="inp2" id="checkbox15"
										type="text" value="女款-14#" disabled="disabled" /></td>
									<td id="td16"><input class="xiao inp1" id="checkbox16"
										type="checkbox" /><input class="inp2" id="checkbox16"
										type="text" value="男款-20#" disabled="disabled" /></td>
									<td id="td17"><input class="xiao inp1" id="checkbox17"
										type="checkbox" /><input class="inp2" id="checkbox17"
										type="text" value="男款-21#" disabled="disabled" /></td>

								</tr>
							</table>
							<br>
							<table id="tab1">
								<p>材料：</p>
								<tr>
									<td id="td1"><input class="xiao inp1" id="checkbox1"
										type="checkbox" /><input class="inp2" id="checkbox1"
										type="text" value="银925" disabled="disabled" /></td>
									<td id="td2"><input class="xiao inp1" id="checkbox2"
										type="checkbox" /><input class="inp2" id="checkbox2"
										type="text" value="金14K" disabled="disabled" /></td>
									<td id="td3"><input class="xiao inp1" id="checkbox3"
										type="checkbox" /><input class="inp2" id="checkbox3"
										type="text" value="金24K" disabled="disabled" /></td>
									<td id="td4"><input class="xiao inp1" id="checkbox4"
										type="checkbox" /><input class="inp2" id="checkbox4"
										type="text" value="铂金" disabled="disabled" /></td>
								</tr>
								<tr>
									<td id="td5"><input class="xiao inp1" id="checkbox5"
										type="checkbox" /><input class="inp2" id="checkbox5"
										type="text" value="银999" disabled="disabled" /></td>
									<td id="td6"><input class="xiao inp1" id="checkbox6"
										type="checkbox" /><input class="inp2" id="checkbox6"
										type="text" value="金18K" disabled="disabled" /></td>
									<td id="td7"><input class="xiao inp1" id="checkbox7"
										type="checkbox" /><input class="inp2" id="checkbox7"
										type="text" value="金999" disabled="disabled" /></td>
									<td id="td8"><input class="xiao inp1" id="checkbox8"
										type="checkbox" /><input class="inp2" id="checkbox8"
										type="text" value="玫瑰金" disabled="disabled" /></td>
								</tr>
								<tr>
									<td id="td9"><input class="xiao inp1" id="checkbox9"
										type="checkbox" /><input class="inp2" id="checkbox9"
										type="text" value="铜0" disabled="disabled" /></td>
									<td id="td10"><input class="xiao inp1" id="checkbox10"
										type="checkbox" /><input class="inp2" id="checkbox10"
										type="text" value="铜1" disabled="disabled" /></td>
									<td id="td11"><input class="xiao inp1" id="checkbox11"
										type="checkbox" /><input class="inp2" id="checkbox11"
										type="text" value="铜2" disabled="disabled" /></td>
									<td id="td12"><input class="xiao inp1" id="checkbox12"
										type="checkbox" /><input class="inp2" id="checkbox12"
										type="text" value="铜3" disabled="disabled" /></td>
								</tr>
							</table>
						</div>
						<div class="div3_div4_div2_div2_div2">
							<table class="ta1" id="ta1">
								<tr>
									<td class="td1">材料</td>
									<td class="td2">图片（无图片可不填）</td>
								</tr>

							</table>
						</div>
						<div class="div3_div4_div2_div2_div3"
							id="div3_div4_div2_div2_div3">
							<table id="ta2">
								<tr>
									<td>材料</td>
									<td>尺寸</td>
									<td>价格</td>
									<td>库存</td>
								</tr>

							</table>
						</div>



						<div class="div3_div4_div3">
							<div class="div3_div4_div3_div1">
								<span>库存量：</span><input type="number" id="modRepertory"
									name="modRepertory"
									onblur="checkisNull($('#modRepertory'),'modRepertory');"
									onfocus="getfocus(this);" value="${model.modRepertory}"
									placeholder="总库存量" class="in1"> <span class="red"><span
									id="warn_modRepertory">请输入库存量</span></span>
							</div>
							<div class="div3_div4_div3_div2">
								<span>标签：</span><input class="in1" type="text" id="modTag"
									onblur="checkisNull($('#modTag'),'modTag');"
									onfocus="getfocus(this);" name="modTag" value="${model.modTag}"
									placeholder="多个请用空格隔开" /> <span class="red"><span
									id="warn_modTag">请输入标签</span></span>
							</div>
							<div class="div3_div4_div3_div3">
								<span class="div3_div4_div3_div3_sp1">是否推荐：</span>
								<c:choose>
									<c:when test="${model.recommend==1}">
										<input type="radio" name="recommend" value="2" />
										<span>否</span>
										<input type="radio" name="recommend" checked="checked"
											value="1" />
										<span>是</span>
									</c:when>
									<c:otherwise>
										<input type="radio" name="recommend" checked="checked"
											value="2" />
										<span>否</span>
										<input type="radio" name="recommend" value="1" />
										<span>是</span>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div class="imgguanli">
					<p class="imgguanli_p1">图片管理：</p>
					<span id="spanButtonPlaceholder"></span> <span
						class="imgguanli_sp1">(至少上传3张图片)</span><span><input
						type="button" onclick="addImg()" value="点击上传" /></span>
					<ul class="imgguanli_ul1">
						<li class="imgguanli_ul1_li1"></li>
						<li class="imgguanli_ul1_li2"></li>
						<li class="imgguanli_ul1_li3"></li>
						<li class="imgguanli_ul1_li4"></li>
						<li class="imgguanli_ul1_li5"></li>
						<li class="imgguanli_ul1_li6"></li>
					</ul>
					<div id="uploader">
						<div class="queueList">
							<div id="dndArea" class="placeholder">
								<div id="filePicker"></div>
								<p></p>
							</div>
						</div>
						<div class="statusBar" style="display: none;">
							<div class="progress">
								<span class="text">0%</span> <span class="percentage"></span>
							</div>
							<div class="info"></div>
							<div class="btns">
								<div id="filePicker2"></div>
								<div class="uploadBtn">开始上传</div>
							</div>
						</div>
					</div>
					<p class="imgguanli_p2">1、图片尺寸为：800px*800px,每张大小不超过1024kb,仅支持jpg.jpeg和png格式</p>
					<p class="imgguanli_p3">2、图片要清晰，不能虚化</p>
					<p class="imgguanli_p4"></p>
					<input type="hidden" name="img" id="img" value="" />
				</div>
				<div class="miaoshu">
					<div class="miaoshu_top">
						<p>
							<span>商品描述：</span>1、图片尺寸最宽不超过750px,每张大小不超过1024kb,仅支持jpg.jpeg和png格式
						</p>
						<p class="miaoshu_top_p2">2、图片要清晰，不能虚化</p>
					</div>
					<div class="miaoshu_bottom">
						<div>
							<textarea id="modDetail" name="modDetail">${model.modDetail}</textarea>
						</div>
					</div>
				</div>
				<div class="div_last">
					<input type="submit" class="div_last_btn1"
						onclick="return checkSubmit();" value="" /> <input type="button"
						class="div_last_btn2" onclick="back()" value="" />

				</div>
			</form>
		</div>

	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/manager/goods.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/manager/goods1.js"></script>
</body>
<script type="text/javascript">
	//提交验证
	function checkSubmit() {
		//getmodeltype();
		//return false;
		 var count=0;
		 //1.验证商品类目
		 if(!checkisNull($("#categoryName"),"categoryName")){
			
			 count=count+1;
		 } 
 		 //2.验证商品名称
		 if(!checkisNull($("#title"),"title")){
			 count=count+1;
		 } 
		 //	3.验证货品产地
		 if(!checkisNull($("#modFrom"),"modFrom")){
			 count=count+1;
		 } 
		 //4.验证成份
		 if(!checkisNull($("#modElement"),"modElement")){
			 count=count+1;
		 } 
		 //5.验证品牌属地
		 if(!checkisNull($("#brandPlace"),"brandPlace")){
			 count=count+1;
		 } 
		 //6.验证尺寸
		 if(!checkisNull($("#modSize"),"modSize")){
			 count=count+1;
		 } 
		 //7.验证重量
		 if(!checkisNull($("#modWeight"),"modWeight")){
			 count=count+1;
		 }
		 //8.验证价格
		 if(!checkisNull($("#price"),"price")){
			 count=count+1;
		 } 
		 if(!checkisNumber($("#price"),"价格")){
			 return false;
		 }
		 //9.验证库存
		 if(!checkisNull($("#modRepertory"),"modRepertory")){
			 count=count+1;
		 } 
		 if(!checkisNumber($("#modRepertory"),"库存")){
			 return false;
		 }
		 //10.验证标签
		 if(!checkisNull($("#modTag"),"modTag")){
			 count=count+1;
		 } 
		 //11.验证商品规格
				
		$(".gong1 tr").each(function(){
			if($(this).children("td").eq(2).children("input").val()==""){
				alert("请填写完整商品规格价格信息");
				return false;
			}
			if($(this).children("td").eq(3).children("input").val()==""){
				alert("请填写完整商品规格库存信息");
				return false;
				
			}
		});
		 
		 //12.判断是否已经上传图片
		 var imgpath=$("#img").val();
		 if(imgpath==""){
			 alert("请先上传商品图片！");
			 return false;
		 } 
		 var imgArray=imgpath.split(";");
		 if(imgArray.length<3){
			 alert("商品图片至少上传3张！");	
			 return false;
		 }	 
		 if (count == 0) {//验证通过：
			//1.计算统计材质和商品规格信息
			getmodeltype();
		   //alert($("#modelType").val());
		   //alert($("#img").val());
		    
		    return true;
		} else {
			alert("您有" + count + "处必填项没有填写，请填写完在保存/预览");
			return false;
		}
	}
	function addImg(){
		 $(".uploadBtn").click();
	}

	//验证是否为空:obj:验证的标签；content:提示前缀：“XXX”不能为空
	function checkisNull(obj, id) {
		var val = $.trim(obj.val());//值去掉前后空格
		if (val == '' || val == null) {
			 $("#warn_"+id).css({"display":"inline-block"});
			 obj.focus();
			return false;
		} else {
			 $("#warn_"+id).css({"display":"none"});
			return true;
		}
	}
	//验证是否是数字：obj:验证的标签；content:提示前缀：“XXX”只能是数字
	function checkisNumber(obj, content) {
		var val = $.trim(obj.val());//值去掉前后空格
		if (val != '' && isNaN(val)) {
			obj.focus();
			return false;
		} else {
			return true;
		}
	}
	//获得焦点事件
	function getfocus(obj) {
		obj.style.color = "black";
	}
	//选择按钮点击事件
	function openwindow(type, name, iWidth, iHeight) {

		var name; //网页名称，可为空;
		var iWidth; //弹出窗口的宽度;
		var iHeight; //弹出窗口的高度;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		var url;//跳转路径:1:设计师；2：商品类别
		if (type == 1) {
			url = "<%=request.getContextPath()%>/modelController/queryBrand.do";
		}else if(type==2){
			url="<%=path%>/categoryController/queryCategory_sel.do";
		}
		window.open(
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
	function setCategory(type, categoryId, categoryName, parentId) {
		$("#markCategory").val(type);
		$("#categoryId").val(categoryId);
		$("#categoryName").val(categoryName);
		$("#modCategoryParentid").val(parentId);
	}
	//回调方法：用于给品牌赋值
	function setbrand(brand,designername,designerid) {
		 $("#brandtext").val(brand);
	     $("#designer").val(designername);
	     $("#brand").val(brand);
	     $("#author").val(designerid);
	}
	//取消事件
	function back() {
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var condition_categoryid=$("#condition_categoryid").val();
		var condition_categoryName=$("#condition_categoryName").val();
		var condition_status=$("#condition_status").val();
		var markCategory=$("#markCategory").val();
		window.location.href="<%=path%>/modelController/queryList.do?pageInfo.pageIndex="
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
	//上传头像
	function selectImagez(file) {
		if (!file.files || !file.files[0]) {
			return;
		}
		var image = '';
		var reader = new FileReader();
		reader.onload = function(evt) {
			document.getElementById(file.name).src = evt.target.result;
			image = evt.target.result;
			$.ajax({
					 type : "post",
					 url : '<%=request.getContextPath()%>/imageController/updateImg.do',
						data : {
							image : image,
							oldImg : file.id,
							path : "upload/uploadImg/textture/"
						},
						async : false,
						dataType : 'json',
						success : function(data) {
							//alert(data);//返回上传图片的名字
							document.getElementById(file.name).name = data;

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
	//修改时，初始化商品信息
	function updateMdel() {
		var markManage = $("#markManage").val();
		if (markManage != 2) {
			return false;
		}

		var modelTypeList = $("#modelTypeList").val();
		var sizeList = $("#sizeList").val();
		var texttureList = $("#texttureList").val();
		var tab1 = document.getElementById("tab1");//材质  
		var tab2 = document.getElementById("tab2");//尺寸
		if (modelTypeList == "" || sizeList == "" || texttureList == "") {
			return false;
		}
		var tab2child = tab2.getElementsByTagName("tr");//尺寸table下的tr
		var tab1child = tab1.getElementsByTagName("tr");//材质table下的tr
		//恢复尺寸
		var sizeList2 = sizeList.split(";;");
		for (var i = 0; i < sizeList2.length; i++) {
			var size = sizeList2[i].split(";");
			for (var j = 0; j < tab2child.length; j++) {
				var td = tab2child[j].getElementsByTagName("td");
				if (size[1] == td[0].id) {
					//alert("1"+size[1]+"&&&"+td[0].id);
					td[0].getElementsByTagName("input")[1].value = size[0];
					td[0].getElementsByTagName("input")[1].disabled = false;
					td[0].getElementsByTagName("input")[0].checked = true;
				}
				if (size[1] == td[1].id) {
					//alert("2"+size[1]+"&&&"+td[0].id);
					td[1].getElementsByTagName("input")[1].value = size[0];
					td[1].getElementsByTagName("input")[1].disabled = false;
					td[1].getElementsByTagName("input")[0].checked = true;
				}
				if (size[1] == td[2].id) {
					//alert("3"+size[1]+"&&&"+td[0].id);
					td[2].getElementsByTagName("input")[1].value = size[0];
					td[2].getElementsByTagName("input")[1].disabled = false;
					td[2].getElementsByTagName("input")[0].checked = true;
				}
				if (size[1] == td[3].id) {
					//alert("4"+size[1]+"&&&"+td[0].id);
					td[3].getElementsByTagName("input")[1].value = size[0];
					td[3].getElementsByTagName("input")[1].disabled = false;
					td[3].getElementsByTagName("input")[0].checked = true;
				}
			}
		}
		//恢复材质
		var texttureList2 = texttureList.split(";;");
		// alert("材质:"+texttureList);
		for (var i = 0; i < texttureList2.length; i++) {
			var textture = texttureList2[i].split(";");
			for (var k = 0; k < tab1child.length; k++) {
				var td = tab1child[k].getElementsByTagName("td");
				if (textture[1] == td[0].id) {
					//alert("1"+size[1]+"&&&"+td[0].id);
					td[0].getElementsByTagName("input")[1].value = textture[0];
					//td[0].getElementsByTagName("input")[1].disabled=false;
					td[0].getElementsByTagName("input")[0].click();
				}
				if (textture[1] == td[1].id) {
					//alert("2"+size[1]+"&&&"+td[0].id);
					td[1].getElementsByTagName("input")[1].value = textture[0];
					//td[1].getElementsByTagName("input")[1].disabled=false;
					td[1].getElementsByTagName("input")[0].click();
				}
				if (textture[1] == td[2].id) {
					//alert("3"+size[1]+"&&&"+td[0].id);
					td[2].getElementsByTagName("input")[1].value = textture[0];
					//td[2].getElementsByTagName("input")[1].disabled=false;
					td[2].getElementsByTagName("input")[0].click();
				}
				if (textture[1] == td[3].id) {
					//alert("4"+size[1]+"&&&"+td[0].id);
					td[3].getElementsByTagName("input")[1].value = textture[0];
					//td[3].getElementsByTagName("input")[1].disabled=false;
					td[3].getElementsByTagName("input")[0].click();
				}
			}
		}
		//恢复材质图片
		for (var i = 0; i < texttureList2.length; i++) {
			var textture = texttureList2[i].split(";");
			$(".ta1 tr")
					.each(
							function() {
								if ($(this).children("td.td1").text() == textture[0]) {

									if (textture[2] != "url_null") {
										$(this).children("td.td2").children(
												"img")[0].src = "<%=request.getContextPath()%>/upload/uploadImg/textture/"
												+ textture[2];
										$(this).children("td.td2").children(
												"img")[0].name = textture[2];
									}
								}
							});
		}
		//恢复商品规格的价格和库存
		var modelTypeList2 = modelTypeList.split(";;");
		$(".gong1 tr")
				.each(
						function() {
							$textture = $(this).children("td").eq(0).html();
							$size = $(this).children("td").eq(1).html();
							for (var i = 0; i < modelTypeList2.length; i++) {
								var modeltype = modelTypeList2[i].split(";");
								if ($textture == modeltype[0]
										&& $size == modeltype[1]) {
									$(this).children("td").eq(2).children(
											"input").val(modeltype[2]);
									$(this).children("td").eq(3).children(
											"input.kucunliang").val(
											modeltype[3]);

								}
							}
						});

	}
</script>
</html>