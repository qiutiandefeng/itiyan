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
<title>商品类目页</title>

<script type="text/javascript">
//屏蔽点击键盘Backspace键，页面向后跳转
window.onload=function(){  
   
        //获取事件对象  
        var elem = event.relatedTarget || event.srcElement || event.target ||event.currentTarget;   
          
        if(event.keyCode==8){//判断按键为backSpace键  
          
                //获取按键按下时光标做指向的element  
                var elem = event.srcElement || event.currentTarget;   
                  
                //判断是否需要阻止按下键盘的事件默认传递  
                var name = elem.nodeName;  
                  
                if(name!='INPUT' && name!='TEXTAREA'){  
                    return _stopIt(event);  
                }  
                var type_e = elem.type.toUpperCase();  
                if(name=='INPUT' && (type_e!='TEXT' && type_e!='TEXTAREA' && type_e!='PASSWORD' && type_e!='FILE')){  
                        return _stopIt(event);  
                }  
                if(name=='INPUT' && (elem.readOnly==true || elem.disabled ==true)){  
                        return _stopIt(event);  
                }  
            }  
         
    }  
	function _stopIt(e){  
	    if(e.returnValue){  
	        e.returnValue = false ;  
	    }  
	    if(e.preventDefault ){  
	        e.preventDefault();  
	    }                 

     return false;  
	}  
    //提交验证
	function checkSubmit() {
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		$("#condition").val(condition);
	 
	}
	//添加商品类别:type:1添加，2编辑；id：如果是添加id代表父类ID,如果是编辑id代表该类别ID
	function categoryManage(type,id){
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		window.location.href="<%=request.getContextPath()%>/categoryController/gotoCategoryManage.do?markManage="
				+type+"&parentId="+id+"&condition="+condition;
	}
	//删除商品类别
	function categoryDel(cateyId,pid){
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		var content="确定要删除该商品类别吗？";
		if(cateyId==pid){
			content="确定要删除该商品类别及其下的所有子类别吗？";
		}
			if(window.confirm(content)){
				window.location.href="<%=request.getContextPath()%>/categoryController/delCategory.do?categoryId="+cateyId+"&condition="+condition;
             } 
	}
	//移动顺序:type:1上移，2下移;id类别ID
	function moveOrder(type,id){
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		window.location.href="<%=request.getContextPath()%>/categoryController/moveOrder.do?categoryId="+id+"&markMoveType="+type+"&condition="+condition;
	}
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;商品类目管理
	</h1>
	<div class="container-fluid" style="margin-left: -14px;position:absolute; height:800px; width:100%;overflow:auto">
		<form id="sform" action="queryCategory.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="类目名称" name="condition"
				style="margin-top: 0px;" id="condition"
				value="${category.condition}" class="nav-search-input"> <input
				type="submit" onclick="checkSubmit();" id="selectLick"
				value="查询" class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<input type="button" onclick="categoryManage(1,0)" value="新增"
				class="btn btn-primary btn-sm" style="margin-left: 5px;">
		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>排序</th>
					<th>分类</th>
					<th>本身ID</th>
					<th>父节点ID</th>
					<th colspan="3">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="categy" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${categy.title}<input type="button"
							class="btn btn-primary btn-sm" style="margin-left: 5px;"
							onclick="categoryManage(1,${categy.categoryId})" value="Add" /></td>
						<td>${categy.categoryId}</td>
						<td>${categy.parentId}</td>
						<td colspan="3"><c:if test="${i.first}">上移&nbsp;</c:if> <c:if
								test="${!i.first}">
								<a href="javascript:moveOrder(1,${categy.categoryId});"
									style="color: blue;">上移</a>&nbsp;</c:if> <c:if test="${!i.last}">
								<a
									href="javascript:moveOrder(2,${categy.categoryId},${categy.categoryId});"
									style="color: blue;">下移</a>&nbsp;</c:if> <c:if test="${i.last}">下移&nbsp;</c:if>
							<a href="javascript:categoryManage(2,${categy.categoryId});"
							style="color: blue;">编辑</a>&nbsp; <a
							href="javascript:categoryDel(${categy.categoryId},${categy.parentId});"
							style="color: blue;">删除</a></td>
					</tr>
					<c:forEach items="${categy.list}" var="catey" varStatus="j">
						<tr>
							<td></td>
							<td>&nbsp;&nbsp;${catey.title}</td>
							<td>${catey.categoryId}</td>
							<td>${catey.parentId}</td>
							<td colspan="3"><c:if test="${j.first}">上移&nbsp;</c:if> <c:if
									test="${!j.first}">
									<a href="javascript:moveOrder(1,${catey.categoryId});"
										style="color: blue;">上移</a>&nbsp;</c:if> <c:if test="${!j.last}">
									<a href="javascript:moveOrder(2,${catey.categoryId});"
										style="color: blue;">下移</a>&nbsp;</c:if> <c:if test="${j.last}">下移&nbsp;</c:if>
								<a href="javascript:categoryManage(2,${catey.categoryId});"
								style="color: blue;">编辑</a>&nbsp; <a
								href="javascript:categoryDel(${catey.categoryId},${catey.parentId});"
								style="color: blue;">删除</a></td>
						</tr>
					</c:forEach>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>