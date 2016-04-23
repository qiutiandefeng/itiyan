package org.apache.jsp.WEB_002dINF.jsp.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");

    String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";

      out.write("    \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/css/login.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/jquery-1.8.2.js\"></script>\r\n");
      out.write("     <script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/Regular.js\"></script>\r\n");
      out.write("\t<title>后台登陆</title>\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t  if(top!=self){\r\n");
      out.write("               top.location=self.location;\r\n");
      out.write("     \t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\tvar roleId =\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${groupId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t  \t\t$(\"#groupId option\").each(function() {\r\n");
      out.write("\t\t\t\tif ($(this).val() == roleId) {\r\n");
      out.write("\t\t\t\t\t$(this).prependTo($(\"#groupId\"));\r\n");
      out.write("\t\t\t\t\t$(this).attr(\"selected\", \"selected\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t  \t\t\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\tfunction validate(){ \r\n");
      out.write("\t\t\tvar select =$(\"#groupId\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(select==2){\r\n");
      out.write("\t\t\t\tvar password=$(\"#pwd\").val();\r\n");
      out.write("\t\t\t\tif(password.length==\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#msg\").html(\"\");\r\n");
      out.write("\t\t\t    \t$(\"#msg\").html(\"密码不能为空\");\r\n");
      out.write("\t\t\t\t}else if(!passwordReg(password)){\r\n");
      out.write("\t\t\t    \t $(\"#msg\").html(\"\");\r\n");
      out.write("\t\t\t    \t $(\"#msg\").html(\"密码格式错误\");\r\n");
      out.write("\t\t\t    }else{\r\n");
      out.write("\t\t\t\t  \t\twith(document.sform){\r\n");
      out.write("\t\t\t\t\t\t\t action=\"");
      out.print(path);
      out.write("/login/login.do\"; //修改跳转的路径\r\n");
      out.write("\t\t\t\t\t\t\t submit();\r\n");
      out.write("\t\t\t\t\t\t}    \r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction myclear(){\r\n");
      out.write("\t\t $(\"#msg\").html(\"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction changeImg(){     \r\n");
      out.write("\t\t    var imgSrc = $(\"#imgObj\");     \r\n");
      out.write("\t\t    var src = imgSrc.attr(\"src\");     \r\n");
      out.write("\t\t    imgSrc.attr(\"src\",chgUrl(src));     \r\n");
      out.write("\t\t}     \r\n");
      out.write("\t\t//时间戳     \r\n");
      out.write("\t\t//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     \r\n");
      out.write("\t\tfunction chgUrl(url){     \r\n");
      out.write("\t\t    var timestamp = (new Date()).valueOf();     \r\n");
      out.write("\t\t    urlurl = url.substring(0,17);     \r\n");
      out.write("\t\t    if((url.indexOf(\"&\")>=0)){     \r\n");
      out.write("\t\t        urlurl = url + \"×tamp=\" + timestamp;     \r\n");
      out.write("\t\t    }else{     \r\n");
      out.write("\t\t        urlurl = url + \"?timestamp=\" + timestamp;     \r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t    return url;     \r\n");
      out.write("\t\t}     \r\n");
      out.write("\r\n");
      out.write("\t\tfunction callback(data){     \r\n");
      out.write("\t\t    $(\"#info\").html(data);     \r\n");
      out.write("\t\t}  \r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"login_top\">\r\n");
      out.write("\t\t<div id=\"welcome\">\r\n");
      out.write("\t\t\t欢迎使用美匠科技管理系统\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"login_center\">\r\n");
      out.write("\t\t<div id=\"login_area\">\r\n");
      out.write("\t\t\t<div id=\"login_form\">\r\n");
      out.write("\t\t\t\t<form action=\"#\" method=\"post\"  id=\"sform\" name=\"sform\">\r\n");
      out.write("\t\t\t\t\t<div id=\"login_tip\">\r\n");
      out.write("\t\t\t\t\t\t用户登录&nbsp;&nbsp; <font color=\"red\" id=\"msg\" size=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font> \r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div>&nbsp;&nbsp;用户名&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<input  class=\"username\" name=\"username\" id=\"username\"> \t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"role\">\r\n");
      out.write("\t\t\t\t\t<span id=\"rolepwd\" >&nbsp;&nbsp;&nbsp;密 码</span>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" class=\"pwd\" name=\"pwd\" id=\"pwd\" onclick=\"myclear()\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"groupId\" name=\"groupId\" value=\"2\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"role\"><!-- request.getContextPath() -->\r\n");
      out.write("\t\t\t\t\t<span id=\"roleyanzhengma\">&nbsp;&nbsp;验证码&nbsp;&nbsp;</span>\r\n");
      out.write("\t\t\t\t\t<input name=\"validateCode\" id=\"validateCode\" class=\"yanzheng\"/>\r\n");
      out.write("\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<img id=\"imgObj\"  alt=\"\" class=\"imgObj\" src=\"");
      out.print(request.getContextPath() );
      out.write("/xuan/verifyCode.do\"/>       \r\n");
      out.write("        \t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/login/login.do\" onclick=\"changeImg()\">换一张</a>  \r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"btn_area\">\r\n");
      out.write("                        <input type=\"submit\" name=\"submit\" id=\"sub_btn\" value=\"登&nbsp;&nbsp;录\" onclick=\"validate();return false;\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write(" ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
