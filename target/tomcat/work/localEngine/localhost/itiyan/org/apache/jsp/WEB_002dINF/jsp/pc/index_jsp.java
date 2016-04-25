package org.apache.jsp.WEB_002dINF.jsp.pc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/jsp/pc/partpage/hander.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/pc/partpage/bottom.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/pc/partpage/login.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-1.8.2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/pc/maskLayer.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/Common_style.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/banner.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/recommended.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/ourmoreproducts.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/dengluzhuce.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/logo2.png\"\r\n");
      out.write("\ttype=\"image/x-icon\" rel=\"shortcut icon\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>爱体验网</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" id=\"yfhl_user\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<!--hander -->\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/pc/maskLayer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/pc/gg_denglu.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" id=\"yfhl_user\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：头部    公共样式\r\n");
      out.write("        -->\r\n");
      out.write("\t<header class=\"head\">\r\n");
      out.write("\t\t<a class=\"head_a1 left\"\r\n");
      out.write("\t\t\thref=\"###\" onclick=\"gotoManageTrade()\"></a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"left shoopCar\" onclick=\"gotoShopping()\"><span>");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</span></a>\r\n");
      out.write("\t\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /WEB-INF/jsp/pc/partpage/hander.jsp(23,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.uid!=null && yfhl_user.uid!=''}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<a href=\"");
          out.print(request.getContextPath());
          out.write("/login/loginOutPC.do\"\r\n");
          out.write("\t\t\t\tclass=\"left\">退出</a>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      out.write("\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：导航 和logo所在位置   划过和搜索点击效果\r\n");
      out.write("        -->\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"nav\">\r\n");
      out.write("\t\t<form\r\n");
      out.write("\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/modelController/gotoModelListPC.do\"\r\n");
      out.write("\t\t\tmethod=\"post\" name=\"form_condition\" id=\"form_condition\">\r\n");
      out.write("\t\t\t<div class=\"left nav_left\" onclick=\"gotoModelPc()\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/logo.png\" style=\"width: 192px;height: 63px;\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<ul class=\"left nav_right\">\r\n");
      out.write("<!-- \t\t\t\t<li class=\"nav_right_li1\"><a -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"nav_right_li1\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/modelController/gotoModelListPC.do\"></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"showright_nav_ulprice\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"showright_nav_ul1_li1\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/006.gif\"></li>\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("<!-- \t\t\t\t<li class=\"nav_right_li3\"><a -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"nav_right_li4\"><a\r\n");
      out.write("\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/turncenterController/turnBottom.do?markerPage=5\"></a></li>\r\n");
      out.write("\t\t\t\t<li class=\"search\"><input class=\"two left\" type=\"text\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"搜索关键词\" name=\"condition\" id=\"condition\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${condition}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /><a class=\"left \" href=\"#\" onclick=\"selByCondition()\">\r\n");
      out.write("\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t \r\n");
      out.write("\t//跳转到设计师品牌页面\r\n");
      out.write("\tfunction to_designerBrand(id){\r\n");
      out.write("\t\twindow.location.href=\"");
      out.print(request.getContextPath());
      out.write("/userManage/gotoDesignerBrandPC.do?id=\"+id;\r\n");
      out.write("\t}\r\n");
      out.write("\t \r\n");
      out.write("\t//去登录页面\r\n");
      out.write("\tfunction gotoLogin(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlogincalssfadein();\r\n");
      out.write("\t}\r\n");
      out.write("\t//去个人中心\r\n");
      out.write("\tfunction gotoManage(){\r\n");
      out.write("\t\t//判断是否已经登录\r\n");
      out.write("\t\tvar uid = $(\"#yfhl_user\").val();\r\n");
      out.write("\t\tif (uid == \"\" || uid == null) {\r\n");
      out.write("\t\t\tgotoLogin();//去登陆页面\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\twindow.location.href = \"");
      out.print(request.getContextPath());
      out.write("/userManage/gotoUserManagePC.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//个人订单页\r\n");
      out.write("\tfunction gotoManageTrade(){\r\n");
      out.write("\t\t//判断是否已经登录\r\n");
      out.write("\t\tvar uid = $(\"#yfhl_user\").val();\r\n");
      out.write("\t\tif (uid == \"\" || uid == null) {\r\n");
      out.write("\t\t\tgotoLogin();//去登陆页面\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\twindow.location.href = \"");
      out.print(request.getContextPath());
      out.write("/tradeManage/queryListPC.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//去商品列表页\r\n");
      out.write("\tfunction gotoModelList(){\r\n");
      out.write("\t\twindow.location.href=\"");
      out.print(request.getContextPath());
      out.write("/modelController/gotoModelListPC.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//去购物车\r\n");
      out.write("\tfunction gotoShopping() {\r\n");
      out.write("\t\t//判断是否已经登录\r\n");
      out.write("\t\tvar uid = $(\"#yfhl_user\").val();\r\n");
      out.write("\t\tif (uid == \"\" || uid == null) {\r\n");
      out.write("\t\t\tgotoLogin();//去登陆页面\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\twindow.location.href = \"");
      out.print(request.getContextPath());
      out.write("/modelShopping/cartList.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//模糊查询\r\n");
      out.write("\tfunction selByCondition() {\r\n");
      out.write("\t\t//1.搜索框去掉前后空格\r\n");
      out.write("\t\tvar condition = $.trim($(\"#condition\").val());\r\n");
      out.write("\t\t$(\"#condition\").val(condition);\r\n");
      out.write("\t\tdocument.form_condition.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\t//去底部页面\r\n");
      out.write("\tfunction gotoLastPage(type) {\r\n");
      out.write("\t\twindow.location.href = \"");
      out.print(request.getContextPath());
      out.write("/turncenterController/turnBottom.do?markerPage=\"\r\n");
      out.write("\t\t\t\t+ type;\r\n");
      out.write("\t}\r\n");
      out.write("\t //根据商品类别查询商品信息\r\n");
      out.write("\tfunction selByCategory(id){\r\n");
      out.write("\t//提交\r\n");
      out.write("\tdocument.write('<form action=\"");
      out.print(request.getContextPath());
      out.write("/modelController/gotoModelListPC.do\" method=\"post\" name=\"formx1\" style=\"display:none\">');\r\n");
      out.write("\t\tdocument.write('<input type=\"hidden\" name=\"condition_categoryid\" value=\"'+id+'\"/>');\r\n");
      out.write("\t\tdocument.write('<input type=\"hidden\" name=\"markCategory\" value=\"2\"/>');\r\n");
      out.write("\t\tdocument.write(\"</form>\");\r\n");
      out.write("\t\tdocument.formx1.submit();\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t //去首页\r\n");
      out.write("\t function gotoModelPc(){\r\n");
      out.write("\t\t window.location.href=\"");
      out.print(request.getContextPath());
      out.write("/modelController/gotoModelPC.do\";\r\n");
      out.write("\t }\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"nav_bottom\"></div>\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：渐隐轮播：banner\r\n");
      out.write("        -->\r\n");
      out.write("\t<div class=\"banner\">\r\n");
      out.write("\t\t<ul class=\"imgLest\">\r\n");
      out.write("\t\t\t<!--图片部分 -->\r\n");
      out.write("\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /WEB-INF/jsp/pc/index.jsp(50,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(50,3) '${bannerList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${bannerList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/pc/index.jsp(50,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("banner");
      // /WEB-INF/jsp/pc/index.jsp(50,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVarStatus("i");
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  c:if
            org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
            _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
            // /WEB-INF/jsp/pc/index.jsp(51,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count==1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
            int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
            if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("\t\t\t\t\t<li class=\"imgOn\"><img\r\n");
                out.write("\t\t\t\t\t\tsrc=\"");
                out.print(request.getContextPath());
                out.write("/upload/uploadImg/banner/");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${banner.banImgurl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" /></li>\r\n");
                out.write("\t\t\t\t");
                int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
              return;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  c:if
            org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
            _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
            // /WEB-INF/jsp/pc/index.jsp(55,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count!=1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
            int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
            if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("\t\t\t\t\t<li><img\r\n");
                out.write("\t\t\t\t\t\tsrc=\"");
                out.print(request.getContextPath());
                out.write("/upload/uploadImg/banner/");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${banner.banImgurl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" /></li>\r\n");
                out.write("\t\t\t\t");
                int evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fif_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
              return;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f5);
            out.write("\r\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      }
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"banner_div1\">\r\n");
      out.write("\t\t\t<ul class=\"textLest\">\r\n");
      out.write("\t\t\t\t<!--文字部分 -->\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"square\">\r\n");
      out.write("\t\t\t\t<!--添加景深块元素-->\r\n");
      out.write("\t\t\t\t<li class=\"squareOn\"></li>\r\n");
      out.write("\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t<li></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：ajax 加载图片名称和价格 ；文字定位划过显示：本周推荐\r\n");
      out.write("        -->\r\n");
      out.write("\t<div class=\"recommended\">\r\n");
      out.write("\t\t<div class=\"theTitle\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/092.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"recommend_div\">\r\n");
      out.write("\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f3.setParent(null);
      // /WEB-INF/jsp/pc/index.jsp(94,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(94,3) '${recommendList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${recommendList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/pc/index.jsp(94,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setVar("recommend");
      // /WEB-INF/jsp/pc/index.jsp(94,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setVarStatus("i");
      int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
        if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  c:if
            org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
            _jspx_th_c_005fif_005f8.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
            // /WEB-INF/jsp/pc/index.jsp(95,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(i.count-1)==0 || (i.count-1)%5==0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
            int _jspx_eval_c_005fif_005f8 = _jspx_th_c_005fif_005f8.doStartTag();
            if (_jspx_eval_c_005fif_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("\t\t\t\t\t<div class=\"recommended_div_big recommended_div_\"\r\n");
                out.write("\t\t\t\t\t\tonclick=\"to_modeldetail('");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.mid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("')\">\r\n");
                out.write("\t\t\t\t\t\t<img\r\n");
                out.write("\t\t\t\t\t\t\tsrc=\"");
                out.print(request.getContextPath());
                out.write("/upload/uploadImg/model/");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.img}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" />\r\n");
                out.write("\t\t\t\t\t\t<div class=\"oursss\">\r\n");
                out.write("\t\t\t\t\t\t\t<p class=\"p1\">");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("</p>\r\n");
                out.write("\t\t\t\t\t\t\t<p class=\"p2\">￥");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.price}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("</p>\r\n");
                out.write("\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t");
                int evalDoAfterBody = _jspx_th_c_005fif_005f8.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fif_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f8);
              return;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f8);
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  c:if
            org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
            _jspx_th_c_005fif_005f9.setPageContext(_jspx_page_context);
            _jspx_th_c_005fif_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
            // /WEB-INF/jsp/pc/index.jsp(106,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fif_005f9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(i.count-1)!=0 && (i.count-1)%5!=0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
            int _jspx_eval_c_005fif_005f9 = _jspx_th_c_005fif_005f9.doStartTag();
            if (_jspx_eval_c_005fif_005f9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\r\n");
                out.write("\t\t\t\t\t<div class=\"recommended_div_small recommended_div_\"\r\n");
                out.write("\t\t\t\t\t\tonclick=\"to_modeldetail('");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.mid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("')\">\r\n");
                out.write("\t\t\t\t\t\t<img\r\n");
                out.write("\t\t\t\t\t\t\tsrc=\"");
                out.print(request.getContextPath());
                out.write("/upload/uploadImg/model/");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.img}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("\" />\r\n");
                out.write("\t\t\t\t\t\t<div class=\"oursss\">\r\n");
                out.write("\t\t\t\t\t\t\t<p class=\"p1\">");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("</p>\r\n");
                out.write("\t\t\t\t\t\t\t<p class=\"p2\">￥");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recommend.price}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                out.write("</p>\r\n");
                out.write("\t\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t\t</div>\r\n");
                out.write("\t\t\t\t");
                int evalDoAfterBody = _jspx_th_c_005fif_005f9.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_005fif_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f9);
              return;
            }
            _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f9);
            out.write("\r\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f3.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
      }
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<!-- \t\t<p class=\"recommended_p\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"marker_recommend\" value=\"1\" /> <a href=\"#\"\r\n");
      out.write("\t\t\t\tonclick=\"recommendMore()\"></a>\r\n");
      out.write("\t\t</p> -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：ajax加载图片名称价格 划过可点赞：更多产品\r\n");
      out.write("        -->\r\n");
      out.write("\t<div class=\"more\" id=\"more\">\r\n");
      out.write("\t\t<div class=\"theTitle\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/091.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<ul class=\"morNav\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f5.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f5.setParent(null);
      // /WEB-INF/jsp/pc/index.jsp(143,2) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f5.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(143,2) '${modellist}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${modellist}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/pc/index.jsp(143,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f5.setVar("modellist");
      // /WEB-INF/jsp/pc/index.jsp(143,2) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f5.setVarStatus("j");
      int[] _jspx_push_body_count_c_005fforEach_005f5 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f5 = _jspx_th_c_005fforEach_005f5.doStartTag();
        if (_jspx_eval_c_005fforEach_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t<div class=\"li1\" id=\"li");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${j.count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\">\r\n");
            out.write("\t\t\t\t");
            //  c:forEach
            org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f6 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
            _jspx_th_c_005fforEach_005f6.setPageContext(_jspx_page_context);
            _jspx_th_c_005fforEach_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
            // /WEB-INF/jsp/pc/index.jsp(145,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f6.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(145,4) '${modellist}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${modellist}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
            // /WEB-INF/jsp/pc/index.jsp(145,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
            _jspx_th_c_005fforEach_005f6.setVar("model");
            int[] _jspx_push_body_count_c_005fforEach_005f6 = new int[] { 0 };
            try {
              int _jspx_eval_c_005fforEach_005f6 = _jspx_th_c_005fforEach_005f6.doStartTag();
              if (_jspx_eval_c_005fforEach_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t<dl>\r\n");
                  out.write("\t\t\t\t\t\t<dt class=\"dtt\">\r\n");
                  out.write("\t\t\t\t\t\t\t<img\r\n");
                  out.write("\t\t\t\t\t\t\t\tsrc=\"");
                  out.print(request.getContextPath());
                  out.write("/upload/uploadImg/model/");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.img}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("\"\r\n");
                  out.write("\t\t\t\t\t\t\t\tonclick=\"to_modeldetail('");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.mid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("')\" />\r\n");
                  out.write("\t\t\t\t\t\t\t<div class=\"layer\">\r\n");
                  out.write("\t\t\t\t\t\t\t\t<div class=\"layer_img\" onclick=\"\">\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t<img\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t\tsrc=\"");
                  out.print(request.getContextPath());
                  out.write("/upload/uploadImg/user/");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.designerAvatar}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("\" />\r\n");
                  out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t<div class=\"layer_name\" onclick=\"\">");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.designerName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t<div class=\"layer_num\">");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.favoriteNum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("</div>\r\n");
                  out.write("\t\t\t\t\t\t\t\t<div class=\"layer_xin\">\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t");
                  if (_jspx_meth_c_005fif_005f12(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
                    return;
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t\t");
                  if (_jspx_meth_c_005fif_005f13(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
                    return;
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t\t</div>\r\n");
                  out.write("\t\t\t\t\t\t</dt>\r\n");
                  out.write("\t\t\t\t\t\t<dd>\r\n");
                  out.write("\t\t\t\t\t\t\t<span class=\"showright_dl_dd_sp1\" title=\"");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write('"');
                  out.write('>');
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("</span>\r\n");
                  out.write("\t\t\t\t\t\t\t<span class=\"showright_dl_dd_sp2\">{￥");
                  out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.price}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
                  out.write("}</span> <span\r\n");
                  out.write("\t\t\t\t\t\t\t\tclass=\"new\"></span>\r\n");
                  out.write("\t\t\t\t\t\t</dd>\r\n");
                  out.write("\t\t\t\t\t</dl>\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_005fforEach_005f6.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fforEach_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_c_005fforEach_005f6[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_c_005fforEach_005f6.doCatch(_jspx_exception);
            } finally {
              _jspx_th_c_005fforEach_005f6.doFinally();
              _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f6);
            }
            out.write("\r\n");
            out.write("\t\t\t</div>\r\n");
            out.write("\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f5.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f5[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f5.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f5.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f5);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"bottomText\">\r\n");
      out.write("\t\t\t<a href=\"#\" onclick=\"gotoModelList()\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：ajax 加载图片 划过有窗口显示出来  向左轮播 :设计师\r\n");
      out.write("        -->\r\n");
      out.write("\t<div class=\"designer\">\r\n");
      out.write("\t\t<div class=\"theTitle\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/093.png\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<ul class=\"designer_ul\">\r\n");
      out.write("\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f7 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f7.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f7.setParent(null);
      // /WEB-INF/jsp/pc/index.jsp(194,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f7.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(194,3) '${designerList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${designerList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/jsp/pc/index.jsp(194,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f7.setVar("designer");
      int[] _jspx_push_body_count_c_005fforEach_005f7 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f7 = _jspx_th_c_005fforEach_005f7.doStartTag();
        if (_jspx_eval_c_005fforEach_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t<li><img\r\n");
            out.write("\t\t\t\t\tsrc=\"");
            out.print(request.getContextPath());
            out.write("/upload/uploadImg/user/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${designer.avatar}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\" />\r\n");
            out.write("\t\t\t\t\t<div class=\"designer_ul_li_div\"\r\n");
            out.write("\t\t\t\t\t\tonclick=\"to_designerBrand('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${designer.uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("')\">\r\n");
            out.write("\t\t\t\t\t\t<p class=\"p1\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${designer.username}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("</p>\r\n");
            out.write("\t\t\t\t\t</div></li>\r\n");
            out.write("\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f7.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f7[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f7.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f7.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f7);
      }
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"bottomText2\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/userManage/gotoDesignerPC.do\"></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<!--bottom -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!--\r\n");
      out.write("        \t作者：offline\r\n");
      out.write("        \t时间：2015-12-02\r\n");
      out.write("        \t描述：文字链接\r\n");
      out.write("        -->\r\n");
      out.write("\t<footer class=\"foot\">\r\n");
      out.write("\t\t<div class=\"foot_div\">\r\n");
      out.write("\t\t\t<div class=\"foot_top\">\r\n");
      out.write("\t\t\t\t<ul class=\"foot_ul_one left\">\r\n");
      out.write("\t\t\t\t\t<li class=\"lastLi\"><a href=\"#\" onclick=\"gotoLastPage(1)\">关于我们</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"gotoLastPage(1)\">公司介绍</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">团队介绍</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"foot_ul_two left\">\r\n");
      out.write("\t\t\t\t\t<li class=\"lastLi\"><a href=\"#\" onclick=\"gotoLastPage(2)\">加入我们</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">招聘信息</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"foot_ul_three left\">\r\n");
      out.write("\t\t\t\t\t<li class=\"lastLi\"><a href=\"#\" onclick=\"gotoLastPage(3)\">品牌合作</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"gotoLastPage(3)\">已合作品牌</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">友情链接</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">合作热线</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"foot_ul_four left\">\r\n");
      out.write("\t\t\t\t\t<li class=\"lastLi\"><a href=\"#\" onclick=\"gotoLastPage(4)\">帮助中心</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"gotoLastPage(4)\">购物流程</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"gotoLastPage(4)\">支付方式</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"gotoLastPage(4)\">产品配送</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" onclick=\"gotoLastPage(4)\">在线客服</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">定制流程</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div class=\"foot_div_one left\">\r\n");
      out.write("\t\t\t\t\t<div class=\"outside_border\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"inside_border\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"p1\">3D CREATIA</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>为创造而生</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>订制你的生活</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>爱体验网，专属于你的生活方式</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>WHAT YOU WANT</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p>WHAT I CREATE</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<img class=\"telephone\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/066.gif\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"foot_bottom\">\r\n");
      out.write("\t\t\t\t\t<p>Copyright&copy;北京云帆互联科技有限公司  2015-2016 All Rights Reserved.网站备案:京ICP备16006346号</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//去底部页面\r\n");
      out.write("\tfunction gotoLastPage(type) {\r\n");
      out.write("\t\twindow.location.href = \"");
      out.print(request.getContextPath());
      out.write("/turncenterController/turnBottom.do?markerPage=\"\r\n");
      out.write("\t\t\t\t+ type;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"logincalss\">\r\n");
      out.write("\t\t<!--login -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-1.8.2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/pc/dengluzhuce.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/Common_style.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/pc/dengluzhuce.css\"\r\n");
      out.write("\ttype=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/logo2.png\" type=\"image/x-icon\"\r\n");
      out.write("\trel=\"shortcut icon\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>爱体验网-登录注册</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"onload()\">\r\n");
      out.write("\t<input type=\"hidden\" id=\"beforePath\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${beforePath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t<input type=\"hidden\" id=\"marker_time\" value=\"\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"denglu_waitao\">\r\n");
      out.write("\t\t<div class=\"denglu\">\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/login/loginDesignPC.do\" method=\"post\" id=\"login\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"remember_pwd\" value=\"2\" />\r\n");
      out.write("\t\t\t\t<div class=\"denglu_div1 left\">\r\n");
      out.write("\t\t\t\t\t<p class=\"denglu_div1_p1\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"denglu_div1_p1_a1\" href=\"#\">登陆</a> | <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"denglu_div1_p1_zhuanhuan\" href=\"#\">注册</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"denglu_div1_p2\">\r\n");
      out.write("\t\t\t\t\t\t<span>请输入正确的用户名/密码！</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<input class=\"denglu_div1_input1\" type=\"text\" id=\"username_login\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"请输入手机号或邮箱\" />\r\n");
      out.write("\t\t\t\t\t<p class=\"denglu_div1_p4\" id=\"username_log\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"denglu_div1_p4_sp1\">请输入正确的手机号</span><span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"denglu_div1_p4_sp2\">请输入正确的邮箱号</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<input class=\"denglu_div1_input2\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tid=\"password_login\" value=\"\" placeholder=\"请输入密码\" />\r\n");
      out.write("\t\t\t\t\t<p class=\"denglu_div1_p5\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"pwd_log\">请输入密码</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"denglu_div1_p3\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"denglu_div1_p3_a1 left\" href=\"###\"> <img\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"denglu_div1_p3_img1 left\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/099.gif\" />\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"denglu_div1_p3_img2 left\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/098.gif\" /> &nbsp;&nbsp;记住密码\r\n");
      out.write("\t\t\t\t\t\t</a> <a class=\"denglu_div1_p3_a2 right\" href=\"###\" onclick=\"backPwd()\">忘记密码？</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<a class=\"denglu_div1_a1\" href=\"#\" onclick=\"submitViewBylogin()\">登陆</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"denglu_div2 left\">\r\n");
      out.write("\t\t\t\t\t<p class=\"denglu_div2_p1\">其他账号登陆</p>\r\n");
      out.write("\t\t\t\t\t<a href=\"#\"><img class=\"denglu_div2_img1\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/095.gif\" /></a> <a href=\"###\"><img\r\n");
      out.write("\t\t\t\t\t\tclass=\"denglu_div2_img2\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/096.gif\" /></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"zhuce\">\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/login/loginDesignPC.do\" method=\"post\" id=\"register\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"agree_message\" value=\"1\" />\r\n");
      out.write("\t\t\t\t<p class=\"zhuce_p1\">\r\n");
      out.write("\t\t\t\t\t<a class=\"zhuce_p1_zhuanhuan\" href=\"###\">登陆</a> | <a\r\n");
      out.write("\t\t\t\t\t\tclass=\"denglu_div1_p1_a1\" href=\"###\">注册</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<input class=\"zhuce_input1\" type=\"text\" placeholder=\"请输入你的邮箱\"\r\n");
      out.write("\t\t\t\t\tid=\"username_register\"/>\t<img class=\"zhuce_img1\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/7.png\" />\r\n");
      out.write("\t\t\t\t<p class=\"zhuce_p2\">\r\n");
      out.write("\t\t\t\t\t<span id=\"register_logname\"></span>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<input class=\"zhuce_input2\" type=\"password\" placeholder=\"请输入密码\"\r\n");
      out.write("\t\t\t\t\tid=\"password_register\" />\t<img class=\"zhuce_img2\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/7.png\" />\r\n");
      out.write("\t\t\t\t<p class=\"zhuce_p3\"><span id=\"register_logpwd\">密码由6-20位英文字母、数字或符号组成</span></p>\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t<input class=\"zhuce_input3\" type=\"password\" id=\"password_confirm\" placeholder=\"确认密码\" />\r\n");
      out.write("\t\t\t\t<img class=\"zhuce_img3\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/7.png\" />\r\n");
      out.write("\t\t\t\t<p class=\"zhuce_p5\" > \t\r\n");
      out.write("\t\t\t\t<span id=\"register_logpwdc\">请再次输入密码</span></p>\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t<a class=\"zhuce_a1\" href=\"#\" onclick=\"submitViewByRegister()\" id=\"submitRegitser\" >注册爱体验</a>\r\n");
      out.write("\t\t\t\t<div class=\"zhuce_div1\">\r\n");
      out.write("\t\t\t\t\t<a class=\"left  zhuce_div1_a1\" href=\"###\"><img\r\n");
      out.write("\t\t\t\t\t\tclass=\"left zhuce_div1_img1\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/099.gif\" />\r\n");
      out.write("\t\t\t\t\t\t<img class=\"left zhuce_div1_img2\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/pc/login/098.gif\" />\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;我同意注册合同\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t \r\n");
      out.write("\t//登录提交验证\r\n");
      out.write("\tfunction submitViewBylogin(){\r\n");
      out.write("\t\t  var username=$(\"#username_login\").val();\r\n");
      out.write("\t\t  var password=$(\"#password_login\").val();\r\n");
      out.write("\t\t  var remember=$(\"#remember_pwd\").val();\r\n");
      out.write("\t\t  if(username==\"\" || password==\"\"){\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t  $.ajax({\r\n");
      out.write("          type: \"POST\",\r\n");
      out.write("          url: \"");
      out.print(request.getContextPath());
      out.write("/login/loginDesignPC.do\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tyfhl_username : username,\r\n");
      out.write("\t\t\t\tyfhl_password : password,\r\n");
      out.write("\t\t\t\tyfhl_type : 1,\r\n");
      out.write("\t\t\t\tremember_pwd : remember\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif(data.state==\"0\"){\r\n");
      out.write("\t\t\t\t\tif(data.type==1){\r\n");
      out.write("\t\t\t\t\t\t$(\"#username_log\").text(data.value);\r\n");
      out.write("\t\t\t\t\t\t$(\"#pwd_log\").text(\"\");\r\n");
      out.write("\t\t\t\t\t}else if(data.type==2){\r\n");
      out.write("\t\t\t\t\t\t$(\"#username_log\").text(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#pwd_log\").text(data.value);\r\n");
      out.write("\t\t\t\t\t\t$(\".denglu_div1_p5 span\").css({\"display\":\"block\"});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t//登录成功\r\n");
      out.write("\t\t\t\t\tvar beforePath=$(\"#beforePath\").val();\r\n");
      out.write("\t\t\t\t\tif(beforePath==null || beforePath==\"\" || beforePath==\"/login/index.do\"){\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tbeforePath=\"/modelController/gotoModelPC.do\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\twindow.location.href=\"");
      out.print(request.getContextPath());
      out.write("\" + beforePath;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(error) {\r\n");
      out.write("\t\t\t\talert(\"error\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//注册提交验证\r\n");
      out.write("\tfunction submitViewByRegister(){\r\n");
      out.write("\t\tvar username=$(\"#username_register\").val();\r\n");
      out.write("\t\tvar password=$(\"#password_register\").val();\r\n");
      out.write("\t\t  //验证用户名\r\n");
      out.write("\t\t  if(!checkRegisterName()){\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  //验证密码\r\n");
      out.write("\t\t  if(!checkRegisterpwd()){\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  //验证确认密码\r\n");
      out.write("\t\t  if(!checkRegisterpwdSame()){\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  //判断是否同意注册协议\r\n");
      out.write("\t\t  var agree_message=$(\"#agree_message\").val();\r\n");
      out.write("\t\t  if(agree_message==2){\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t  }\r\n");
      out.write("         //暂时去除注册按钮的点击事件\r\n");
      out.write("         $(\"#submitRegitser\").removeAttr('onclick');\r\n");
      out.write("\t  $.ajax({\r\n");
      out.write("          type: \"POST\",\r\n");
      out.write("          url: \"");
      out.print(request.getContextPath());
      out.write("/login/loginDesignPC.do\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tyfhl_username : username,\r\n");
      out.write("\t\t\t\tyfhl_password : password,\r\n");
      out.write("\t\t\t\tyfhl_type : 2\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif(data.state==\"0\"){\r\n");
      out.write("\t\t\t\t\tif(data.type==1){\r\n");
      out.write("\t\t\t\t\t\t$(\"#username_log\").text(data.value);\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\"#pwd_log\").text(data.value);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t//注册成功\r\n");
      out.write("\t\t\t\t\t//alert(data.email);\r\n");
      out.write("\t\t\t\t\twindow.location.href=\"");
      out.print(request.getContextPath());
      out.write("/login/gotoEmailCount.do?emailCount=\"+data.email;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(error) {\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//判断是否记住密码\r\n");
      out.write("\tfunction onload() {\r\n");
      out.write("\t\tvar pwd = $(\"#password_login\").val();\r\n");
      out.write("\t\tif (pwd != \"\") {\r\n");
      out.write("\t\t\t$(\".denglu_div1_p3_img1\").css({\r\n");
      out.write("\t\t\t\t\"display\" : \"none\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\".denglu_div1_p3_img2\").css({\r\n");
      out.write("\t\t\t\t\"display\" : \"block\"\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//判断手机号/邮箱是否已经注册\r\n");
      out.write("\tfunction checkSame(){\r\n");
      out.write("\t\tvar username=$(\"#username_register\").val();\r\n");
      out.write("\t\t  $.ajax({\r\n");
      out.write("\t          type: \"POST\",\r\n");
      out.write("\t          url: \"");
      out.print(request.getContextPath());
      out.write("/login/checkSameName.do\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tyfhl_username : username\r\n");
      out.write("\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif (data.state == \"0\") {\r\n");
      out.write("\t\t\t\t\t$(\"#register_logname\").text(\"\");\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"inline-block\"});\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#register_logname\").css({color:\"red\"});\r\n");
      out.write("\t\t\t\t\t$(\"#register_logname\").text(\"该邮箱已经被注册，您可以尝试找回密码！\");\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//2.注册验证\r\n");
      out.write("\t//2.1验证注册时用户名格式是否正确\r\n");
      out.write("\tfunction checkRegisterName(){\r\n");
      out.write("\t\tvar index=$(\".zhuce_input1\").val();\r\n");
      out.write("\t\tvar index1=/^([a-zA-Z0-9_\\.\\-]+)@([a-zA-Z0-9_\\.\\-]+)\\.[c]{1}[o]{1}[m]{1}$/;\r\n");
      out.write("\t\tvar index2=/^[1][3,5,7,8]{1}[0-9]{9}$/;\r\n");
      out.write("\t\tif(index.match(\"@\")==\"@\"){\r\n");
      out.write("\t\t\t//alert(\"邮箱号\")\r\n");
      out.write("\t\t\tif(index==\"\"){\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").text(\"注册邮箱不能为空，请输入邮箱！\");\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}else if(!index1.test(index)){\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").text(\"邮箱格式不正确，请重新输入！\");\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\t//alert(\"假1\")\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tcheckSame();\r\n");
      out.write("\t\t\t\tif($(\".zhuce_p2 span\").text()==\"\"){\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_p2 span\").text(\"\");\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_p2 span\").css({color:\"green\"});\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"inline-block\"});\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}else{\r\n");
      out.write(" \t\t\tif(index==\"\"){\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").text(\"注册邮箱不能为空，请输入邮箱！\");\r\n");
      out.write("\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}else if(!index1.test(index)){\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t\t$(\".zhuce_p2 span\").text(\"邮箱格式不正确，请重新输入！\");\r\n");
      out.write("\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\t//alert(\"假1\")\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tcheckSame();\r\n");
      out.write("\t\t\t\tif($(\".zhuce_p2 span\").text()==\"\"){\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_p2 span\").text(\"\");\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_p2 span\").css({color:\"#01DEBD\"});\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"inline-block\"});\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$(\".zhuce_img1\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("//\t\t\t//alert(\"手机号\")\r\n");
      out.write("//\t\t\tif(index2.test(index)){\r\n");
      out.write("//\t\t\t\t$(\".zhuce_p2 span\").css({\"display\":\"none\"})\r\n");
      out.write("//\t\t\t\t//alert(\"真\")\r\n");
      out.write("//\t\t\t\treturn true;\r\n");
      out.write("//\t\t\t}else{\r\n");
      out.write("//\t\t\t\t$(\".zhuce_p2 span\").css({\"display\":\"block\"})\r\n");
      out.write("//\t\t\t\t//alert(\"假\")\r\n");
      out.write("//\t\t\t\treturn false;\r\n");
      out.write("//\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t//2.2验证注册时密码格式是否正确\r\n");
      out.write("\tfunction checkRegisterpwd(){\r\n");
      out.write("\t\tvar index=$(\".zhuce_input2\").val()\r\n");
      out.write("\t\tvar index1=/^[a-zA-Z0-9]{6,20}$/\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(index==\"\"){\r\n");
      out.write("\t\t\t$(\".zhuce_p3 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t$(\".zhuce_p3 span\").text(\"密码不能为空！\");\r\n");
      out.write("\t\t\t$(\".zhuce_img2\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else if(!index1.test(index)){\r\n");
      out.write("\t\t\t$(\".zhuce_p3 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t$(\".zhuce_p3 span\").text(\"密码由6-20位英文字母、数字或符号组成！\");\r\n");
      out.write("\t\t\t$(\".zhuce_img2\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(\".zhuce_p3 span\").css({color:\"#01DEBD\"});\r\n");
      out.write("\t\t\t$(\".zhuce_p3 span\").text(\"\");\r\n");
      out.write("\t\t\t$(\".zhuce_img2\").css({\"display\":\"inline-block\"});\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//2.3验证注册时确认密码\r\n");
      out.write("\tfunction checkRegisterpwdSame(){\r\n");
      out.write("\t\tvar index=$(\".zhuce_input2\").val();\r\n");
      out.write("\t\tvar index1=$(\".zhuce_input3\").val();\r\n");
      out.write("\t\tif(index==\"\"){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else if(index1==\"\"){\r\n");
      out.write("\t\t\t$(\".zhuce_p5 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t$(\".zhuce_p5 span\").text(\"请输入确认密码！\");\r\n");
      out.write("\t\t\t$(\".zhuce_img3\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else if(index!=index1){\r\n");
      out.write("\t\t\t$(\".zhuce_p5 span\").css({color:\"red\"});\r\n");
      out.write("\t\t\t$(\".zhuce_p5 span\").text(\"两次输入的密码不一致，请重新输入！\");\r\n");
      out.write("\t\t\t$(\".zhuce_img3\").css({\"display\":\"none\"});\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(\".zhuce_p5 span\").css({color:\"#01DEBD\"});\r\n");
      out.write("\t\t\t$(\".zhuce_p5 span\").text(\"\");\r\n");
      out.write("\t\t\t$(\".zhuce_img3\").css({\"display\":\"inline-block\"});\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("//找回密码\r\n");
      out.write("function backPwd(){\r\n");
      out.write("\twindow.location.href=\"");
      out.print(request.getContextPath());
      out.write("/login/gotobackPwd.do\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/js/pc/banner.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//跳转到商品详情页面\r\n");
      out.write("function to_modeldetail(mid){\r\n");
      out.write("\twindow.open(\"");
      out.print(request.getContextPath());
      out.write("/modelController/gotoModelDetailPC.do?mid=\"+mid);\r\n");
      out.write("\t}\r\n");
      out.write("//本周推荐点击More\r\n");
      out.write("function recommendMore(){\r\n");
      out.write("\t\tvar marker_recommend=$(\"#marker_recommend\").val();\r\n");
      out.write("\t\tvar startIndex=Number(marker_recommend)*5;\r\n");
      out.write("\t\tvar recommend_div=document.getElementById(\"recommend_div\");\r\n");
      out.write("\t\t//alert(recommend_div.id);\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\turl:\"");
      out.print(request.getContextPath());
      out.write("/modelController/queryRecommendMore.do\",\r\n");
      out.write("\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\tstartIndex : startIndex,\r\n");
      out.write("\t\t\t\t\t\tendIndex : 5\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\tvar ret = JSON.parse(result);\r\n");
      out.write("\t\t\t\t\t\t//alert(\"返回的结果集：\" + ret.length);\r\n");
      out.write("\t\t\t\t\t\tif (ret.length != 0) {\r\n");
      out.write("\t\t\t\t\t\t\tfor (var i = 0; i < ret.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\tvar div1=document.createElement(\"div\");\r\n");
      out.write("\t\t\t\t\t\t\t\tif (i == 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdiv1.setAttribute(\"class\",\"recommended_div_big recommended_div_\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//div1.innerHTML(\"<img src='..//upload//uploadImg//model/\"+ret[i].img+\"'/><div class='oursss'><p class='p1'>\"+ret[i].title+\"</p><p class='p2'>￥\"+ret[i].price+\"</p></div>\");\r\n");
      out.write("\t\t\t\t\t\t\t\t//\tdiv1.innerHTML('<img src=\"..//upload//uploadImg//model/'+ret[i].img+'\" onclick=\"to_modeldetail(\"'+ret[i].mid+'\")\" /><div class=\"oursss\"><p class=\"p1\">'+ret[i].title+'</p><p class=\"p2\">￥'+ret[i].price+'</p></div>');\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tif(i!=0){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdiv1.setAttribute(\"class\",\"recommended_div_small recommended_div_\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tvar img1=document.createElement(\"img\");\r\n");
      out.write("\t\t\t\t\t\t\t\timg1.setAttribute(\"src\",\"");
      out.print(request.getContextPath());
      out.write("/upload/uploadImg/model/\"+ret[i].img);\r\n");
      out.write("\t\t\t\t\t\t\t\timg1.setAttribute(\"onclick\",\"to_modeldetail(\"+ ret[i].mid+\")\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar div2=document.createElement(\"div\");\r\n");
      out.write("\t\t\t\t\t\t\t\tdiv2.setAttribute(\"class\",\"oursss\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar p1=document.createElement(\"p\");\r\n");
      out.write("\t\t\t\t\t\t\t\tp1.setAttribute(\"class\",\"p1\");\r\n");
      out.write("\t\t\t\t\t\t\t\tvar p2=document.createElement(\"p\");\r\n");
      out.write("\t\t\t\t\t\t\t\tp2.setAttribute(\"class\",\"p2\");\r\n");
      out.write("\t\t\t\t\t\t\t\tp2.innerHTML=\"￥\"+ ret[i].price;\r\n");
      out.write("\t\t\t\t\t\t\t\trecommend_div.appendChild(div1);\r\n");
      out.write("\t\t\t\t\t\t\t\tdiv1.appendChild(img1);\r\n");
      out.write("\t\t\t\t\t\t\t\tdiv1.appendChild(div2);\r\n");
      out.write("\t\t\t\t\t\t\t\tdiv2.appendChild(p1);\r\n");
      out.write("\t\t\t\t\t\t\t\tdiv2.appendChild(p2);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#marker_recommend\").val(Number(marker_recommend) + 1);\r\n");
      out.write("\t\t\t\t\t\t\tvar $ours=$(\".recommended_div_\");\r\n");
      out.write("\t\t\t\t\t\t\t$ours.hover(function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).children(\"div.oursss\").stop().fadeIn()\r\n");
      out.write("\t\t\t\t\t\t\t\t},function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).children(\"div.oursss\").stop().fadeOut()\r\n");
      out.write("\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\talert(\"没有更多推荐了！！\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t//收藏商品操作：type:1添加收藏；2.取消收藏\r\n");
      out.write("\tfunction collection(obj,type,dedignerid,mcId,mid){\r\n");
      out.write("\t\t//判断是否已经登录\r\n");
      out.write("\t\t var uid=$(\"#yfhl_user\").val();\r\n");
      out.write("\t\t  if(uid==\"\" || uid==null){\r\n");
      out.write("\t\t\t  $(\".logincalss\").css({\"display\":\"block\"});\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//获取提交信息\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\turl:\"");
      out.print(request.getContextPath());
      out.write("/modelCollectionController/modelCollection.do\",\r\n");
      out.write("\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\tmcId : mcId,\r\n");
      out.write("\t\t\t\t\t\tmcModelid : mid,\r\n");
      out.write("\t\t\t\t\t\tmcDesignerid : dedignerid,\r\n");
      out.write("\t\t\t\t\t\tmcUserid : uid,\r\n");
      out.write("\t\t\t\t\t\tmarkType : type\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tdataType : 'text',\r\n");
      out.write("\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\tif (result == 1) {\r\n");
      out.write("\t\t\t\t\t\t\tvar favoriteNum = $(obj).parent().parent()\r\n");
      out.write("\t\t\t\t\t\t\t\t\t.children(\"div.layer_num\");\r\n");
      out.write("\t\t\t\t\t\t\tfavoriteNum.html(Number(favoriteNum.html()) + 1);\r\n");
      out.write("\t\t\t\t\t\t\t$(obj).css({\r\n");
      out.write("\t\t\t\t\t\t\t\t\"display\" : \"none\"\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t$(obj).parent().children(\"span.layer_xin_img3\")\r\n");
      out.write("\t\t\t\t\t\t\t\t\t.css({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\"display\" : \"block\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/jsp/pc/index.jsp(38,2) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(38,2) '${model.condition}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${model.condition}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/pc/index.jsp(38,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("condition");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/pc/partpage/hander.jsp(18,67) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.shoppingCount=='' || yfhl_user.shoppingCount==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('0');
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/jsp/pc/partpage/hander.jsp(20,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.shoppingCount!='' && yfhl_user.shoppingCount!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.shoppingCount}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/jsp/pc/partpage/hander.jsp(27,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${yfhl_user.uid==null || yfhl_user.uid==''}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<a href=\"#\" class=\"left\" onclick=\"gotoLogin()\">登陆</a>\r\n");
        out.write("\t\t\t<span class=\"left\">|</span>\r\n");
        out.write("\t\t\t<a href=\"#\" onclick=\"gotoLogin()\" class=\"left\">注册</a>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/pc/partpage/hander.jsp(54,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/partpage/hander.jsp(54,6) '${categoryListForHander}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${categoryListForHander}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/pc/partpage/hander.jsp(54,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("category");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<li class=\"showright_nav_ul1_li2\"><a href=\"###\"\r\n");
          out.write("\t\t\t\t\t\t\t\tonclick=\"selByCategory('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.categoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a></li>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /WEB-INF/jsp/pc/index.jsp(64,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(64,4) '${bannerList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${bannerList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/pc/index.jsp(64,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("banner");
    // /WEB-INF/jsp/pc/index.jsp(64,4) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVarStatus("i");
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f6(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f7(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /WEB-INF/jsp/pc/index.jsp(65,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count==1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f6 = _jspx_th_c_005fif_005f6.doStartTag();
    if (_jspx_eval_c_005fif_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li class=\"textOn\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${banner.banName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</li>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /WEB-INF/jsp/pc/index.jsp(68,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count!=1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f7 = _jspx_th_c_005fif_005f7.doStartTag();
    if (_jspx_eval_c_005fif_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${banner.banName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</li>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent(null);
    // /WEB-INF/jsp/pc/index.jsp(134,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/pc/index.jsp(134,3) '${categoryList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${categoryList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/pc/index.jsp(134,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVar("categorylist");
    // /WEB-INF/jsp/pc/index.jsp(134,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVarStatus("i");
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<li class=\"showHidden");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fif_005f10(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write(' ');
          if (_jspx_meth_c_005fif_005f11(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("</li>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/jsp/pc/index.jsp(135,37) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count==1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f10 = _jspx_th_c_005fif_005f10.doStartTag();
    if (_jspx_eval_c_005fif_005f10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<a class=\"initialize\" href=\"###\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${categorylist.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/jsp/pc/index.jsp(137,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i.count!=1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f11 = _jspx_th_c_005fif_005f11.doStartTag();
    if (_jspx_eval_c_005fif_005f11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<a href=\"###\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${categorylist.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</a>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /WEB-INF/jsp/pc/index.jsp(159,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.mcId=='' || model.mcId==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f12 = _jspx_th_c_005fif_005f12.doStartTag();
    if (_jspx_eval_c_005fif_005f12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"layer_xin_img1\"\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\tonclick=\"collection(this,1,'");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.author}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('\'');
        out.write(',');
        out.write('\'');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.mcId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('\'');
        out.write(',');
        out.write('\'');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.mid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("')\"></span>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"layer_xin_img3\"></span>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f13 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /WEB-INF/jsp/pc/index.jsp(164,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f13.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.mcId!='' && model.mcId!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f13 = _jspx_th_c_005fif_005f13.doStartTag();
    if (_jspx_eval_c_005fif_005f13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"layer_xin_img2\"></span>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f13);
    return false;
  }
}
