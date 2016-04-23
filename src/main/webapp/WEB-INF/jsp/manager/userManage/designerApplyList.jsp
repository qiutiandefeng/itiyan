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
<title>设计师申请审批页</title>

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
	//添加用户:type:1添加；2编辑;id:申请设计师表ID;studioStatus:设计师申请状态
	function userManage(type,id,studioStatus){
		var groupId=4;//获取操作的是普通用户还是设计师：1普通用户；4设计师
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		window.location.href="<%=request.getContextPath()%>/userManage/gotoUserManage.do?pageInfo.pageIndex="+ pageIndex 
				+ "&markManage=" + type + "&groupId=" + groupId+ "&id="+id+"&studioStatus="+studioStatus+"&condition="+condition;
	}
	//设计师审核:3：通过 4：不通过
	function checkPass(type,id,uid) {
		var groupId=4;//获取操作的是普通用户还是设计师：1普通用户；4设计师
		var pageIndex=$("#pageIndex").val();
		var condition = $.trim($("#condition").val());//搜索框去掉前后空格
		var content="确定要通过该设计师的申请吗？";
		if(type==4){
			content="确定要不通过该设计师的申请吗？";
		}
		if(window.confirm(content)){
			window.location.href="<%=request.getContextPath()%>/designerApplyController/checkDensignerApply.do?pageInfo.pageIndex="
					+ pageIndex
					+ "&id="
					+ id
					+ "&uid="
					+ uid
					+ "&applydState="
					+ type + "&condition=" + condition + "&groupId=" + groupId;
		}

	}
</script>
</head>
<body>
	<h1 class="narrow" style="margin-top: 0">
		<img src="../images/icon_29.png"
			style="float: left; margin-top: 10px;">&nbsp;设计师审批管理
	</h1>
	<div class="container-fluid" style="margin-left: -14px;">
		<form id="sform" action="queryList.do" method="post"
			class="newWell form-inline" style="margin-top: -5px;">
			<input type="text" placeholder="设计师/邮箱/手机号" name="condition"
				style="margin-top: 0px;" id="condition"
				value="${designerApply.condition}" class="nav-search-input">
			<input type="submit" onclick="checkSubmit()" id="selectLick"
				value="查询" class="btn btn-primary btn-sm" style="margin-left: 5px;">&nbsp;
			<input type="hidden" id="pageIndex" name="pageIndex"
				value="${designerApply.pageInfo.pageIndex}" />

		</form>
		<table class="table table-bordered table-striped table-hover"
			style="margin-top: -4px;">
			<thead>
				<tr class=" alert-info">
					<th>申请编号</th>
					<th>用户编号</th>
					<th>用户名</th>
					<th>设计师名</th>
					<th>邮箱</th>
					<th>电话</th>
					<th>真实姓名</th>
					<th>所在地</th>
					<th colspan="3">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="designerApply" varStatus="i">
					<tr>
						<td>${designerApply.id}</td>
						<td>${designerApply.uid}</td>
						<td>${designerApply.applydUsername}</td>
						<td>${designerApply.applydDname}</td>
						<td>${designerApply.applydEmail}</td>
						<td>${designerApply.phone}</td>
						<td>${designerApply.realname}</td>
						<td>${designerApply.applydAddress}</td>
						<td colspan="3"><a
							href="javascript:userManage(3,${designerApply.id},${designerApply.applydState});"
							style="color: blue;">查看</a> <a
							href="javascript:checkPass(3,${designerApply.id},${designerApply.uid});"
							style="color: blue;">通过</a> <a
							href="javascript:checkPass(4,${designerApply.id},${designerApply.uid});"
							style="color: blue;">不通过</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page-paging2 " style="margin-left: 15px;">
		<!-- 分页 -->
		<c:set value="${designerApply.pageInfo}" var="pageInfo"></c:set>
		<%@include file="../template/pageTemplate.jsp"%>
	</div>



</body>
</html>