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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理页</title>


</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;商品管理
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="商品名称/设计师/品牌" name="condition"
				style="margin-top: 0px;" id="condition" value="${model.condition}"
				class="nav-search-input"> &nbsp;<input type="button"
				value="类别" class="btn btn-primary btn-sm" style="margin-left: 5px;"
				onclick="openwindow('选择商品类别','460','600');" />&nbsp;<input
				type="text" placeholder="父级/子级" disabled="disabled"
				style="margin-top: 0px;" id="categoryName_show"
				value="${model.condition_categoryName}" class="nav-search-input" />&nbsp;&nbsp;状态&nbsp;<select
				id="status_sel" style="margin-left: 5px;" onchange="onchangeSel(2)">
				<c:if
					test="${model.condition_status==-1 || model.condition_status=='' || model.condition_status==null}">
					<option id="-1" selected="selected">-所有状态-</option>
					<option id="1">审核中</option>
					<option id="2">展示中</option>
					<option id="3">已下架</option>
				</c:if>
				<c:if test="${model.condition_status==1}">
					<option id="-1">-所有状态-</option>
					<option id="1" selected="selected">审核中</option>
					<option id="2">展示中</option>
					<option id="3">已下架</option>
				</c:if>
				<c:if test="${model.condition_status==2}">
					<option id="-1">-所有状态-</option>
					<option id="1">审核中</option>
					<option id="2" selected="selected">展示中</option>
					<option id="3">已下架</option>
				</c:if>
				<c:if test="${model.condition_status==3}">
					<option id="-1">-所有状态-</option>
					<option id="1">审核中</option>
					<option id="2">展示中</option>
					<option id="3" selected="selected">已下架</option>
				</c:if>
			</select> <input type="submit" onclick="checkSubmit()" id="selectLick"
				value="查询" class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<input type="button" onclick="goodsManage(1,0);" value="新增"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">
			&nbsp;<input type="button" value="导出" class="btn btn-primary btn-sm"
				style="margin-left: 5px;" onclick="outExcel();" />&nbsp;<input
				type="button" value="一键取消所有推荐" class="btn btn-primary btn-sm"
				style="margin-left: 5px;" onclick="resetRecommend()" /> <input
				type="hidden" id="pageIndex" name="pageIndex"
				value="${model.pageInfo.pageIndex}" /> <input type="hidden"
				id="condition_status" name="condition_status"
				value="${model.condition_status}" /> <input type="hidden"
				id="condition_categoryid" name="condition_categoryid"
				value="${model.condition_categoryid}" /> <input type="hidden"
				id="condition_categoryName" name="condition_categoryName"
				value="${model.condition_categoryName}" /> <input type="hidden"
				id="markCategory" name="markCategory" value="${model.markCategory}" />
			<input type="hidden" name="modSelfDesigner" id="modSelfDesigner"
				value="${model.modSelfDesigner}" />
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>商品编号</th>
					<th>商品名称</th>
					<th>设计师</th>
					<th>品牌</th>
					<th>类别</th>
					<th>库存</th>
					<th>参加活动</th>
					<th>状态</th>
					<th>推荐</th>
					<th colspan="3">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="model" varStatus="i">
					<tr>
						<td>${model.mid}</td>
						<td>${model.title}</td>
						<td>${model.designerName}</td>
						<td>${model.brand}</td>
						<td>${model.categoryName}</td>
						<td>${model.modRepertory}</td>
						<td></td>
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
								<td>无</td>
							</c:otherwise>
						</c:choose>
						<td><a href="###" style="color: blue;"
							onclick="setRecommend('${model.mid}','recommend_${model.mid}')"><input
								type="hidden" id="recommend_${model.mid}"
								value="${model.recommend}"><span
								id="_recommend_${model.mid}"> <c:if
										test="${model.recommend==1}">
						取消推荐
						</c:if> <c:if test="${model.recommend==2}">
						推荐
						</c:if>
							</span></a></td>
						<td colspan="3"><a
							href="javascript:goodsManage(3,${model.mid});"
							style="color: blue;">查看</a> <a
							href="javascript:goodsManage(2,${model.mid});"
							style="color: blue;">编辑</a> <a
							href="javascript:goodsDel(${model.mid});" style="color: blue;">删除</a>

						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2" style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${model.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>
</body>

<script type="text/javascript">
    //提交验证
	function checkSubmit() {
		//1.搜索框去掉前后空格
		var condition = $.trim($("#condition").val());
		$("#condition").val(condition);
		//2.获取状态:状态为空默认赋值为：-1
		var status=$("#status").val();//
		if(status==''){
			  $("#status").val('-1');
		}
		 
	}
    //根据下拉框动态修改隐藏标记值
   function onchangeSel(type){
	   if(type==1){//类别
		 
	   }else if(type==2){//状态
		   var condition_status=$("#status_sel").find("option:selected").attr("id");
		   $("#condition_status").val(condition_status);//保存到动态隐藏值中 
		    
	   }
   }
	//添加商品:type:1添加；2编辑;3:查看;mid:商品ID;
	function goodsManage(type,mid){
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var condition_categoryid=$("#condition_categoryid").val();
		var condition_categoryName=$("#condition_categoryName").val();
		var condition_status=$("#condition_status").val();
		var markCategory=$("#markCategory").val();
		var modSelfDesigner=$("#modSelfDesigner").val();
	 
		window.location.href="<%=request.getContextPath()%>/modelController/gotoModelManage.do?pageInfo.pageIndex="
				+ pageIndex+ "&mid="+mid+"&markManage="+type+"&condition="+condition+"&condition_categoryid="+condition_categoryid
				+"&condition_categoryName="+condition_categoryName+"&condition_status="+condition_status+"&markCategory="+markCategory+"&modSelfDesigner="+modSelfDesigner;
	}
	//删除商品
	function goodsDel(mid){
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());
		var condition_categoryid=$("#condition_categoryid").val();
		var condition_categoryName=$("#condition_categoryName").val();
		var condition_status=$("#condition_status").val();
		var markCategory=$("#markCategory").val();
		if(window.confirm("确定要删除该商品吗？")){
			window.location.href="<%=request.getContextPath()%>/modelController/modelDel.do?pageInfo.pageIndex="
					+ pageIndex + "&mid=" + mid+"&condition="+condition+"&condition_categoryid="+condition_categoryid
					+"&condition_categoryName="+condition_categoryName+"&condition_status="+condition_status+"&markCategory="+markCategory;
         } 
		
	}
	//导出Excel
	function outExcel(){
		$.ajax({
			async:true,
			error:function(){
				window.location.href="<%=request.getContextPath()%>/outExcelController/outExcelModel.do";
			},
			success:function(){
				window.location.href="<%=request.getContextPath()%>/outExcelController/outExcelModel.do";
					}
				});
	}
	//选择按钮点击事件
	function openwindow(name, iWidth, iHeight) {

		var name; //网页名称，可为空;
		var iWidth; //弹出窗口的宽度;
		var iHeight; //弹出窗口的高度;
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; //获得窗口的水平位置;
		window.open("<%=request.getContextPath()%>/categoryController/queryCategory_sel.do",
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
		//	   	window.open("aa.jsp","ss","500","400");

	}
	//回调方法：用于给商品类目条件赋值
	function setCategory(type, categoryId, categoryName,parentId) {
		$("#markCategory").val(type);
		$("#condition_categoryid").val(categoryId);
		$("#condition_categoryName").val(categoryName);
		$("#categoryName_show").val(categoryName);
	}
	//推荐商品
	function setRecommend(mid,id){
		var type;
		var text=$("#"+id).val();
		if(text=="2"){
			type=1;
		}else{
			type=2;
		}
		$.ajax({
			type:"post",
			url:"<%=path%>/modelController/setRecommend.do",
			data : {
				mid : mid,
				markRecommend : type
			},
			dataType : 'text',
			success : function(result) {
				if (result != 0) {
					//alert("操作成功");
					if (text == "2") {
						$("#" + id).val("1");
						$("#_" + id).text("取消推荐");
					} else {
						$("#" + id).val("2");
						$("#_" + id).text("推荐");
					}
				} else {
					alert("操作失败");
				}
			},
			error : function() {
			}
		});
	}
	//一键取消所有推荐
	function resetRecommend(){
		if(window.confirm("确定要一键取消所有推荐吗？")){
			window.location.href="<%=path%>/modelController/resetRecommend.do";
		}
	}
</script>
</html>