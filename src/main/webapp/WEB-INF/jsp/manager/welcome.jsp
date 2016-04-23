<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%
    String path = request.getContextPath();
            String basePath = request.getScheme() + "://"
                    + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script>
$(function(){
    /*屏幕可视区域高度*/
    picMarginTop();
});
function picMarginTop(){
    var oWindowHeight = $(window).height();/*可视区域的高度*/
    var oMarginHeight = parseInt((oWindowHeight-32-420)/2);/*32为标题行的高度，420为图片的高度*/
    if (oMarginHeight < 32){
        $(".weclome").css("margin-top","0px");  
    }else{
        $(".weclome").css("margin-top",oMarginHeight+"px"); 
    }       
}
window.onresize=function(){
picMarginTop(); 
}
</script>
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<h1 class="narrow">
<img src="<%=request.getContextPath()%>/images/icon_29.png" alt="" style="float: left; margin-top: 10px;" />欢迎页面</h1>
<div class="weclome"><img src="images/welcome_391.jpg"/></div>
</body>
</html>
