package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class recordTable_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p><center>บันทึกการล้างไต</center></p>\n");
      out.write("        <table width = \"100%\" border = \"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th rowspan=\"2\">วันที่</th>\n");
      out.write("                <th rowspan=\"2\">รอบที่</th>\n");
      out.write("                <th rowspan=\"2\">ปริมาณความเข้มข้นนน้ำยา</th>\n");
      out.write("                <th colspan=\"3\">น้ำยาเข้า</th>\n");
      out.write("                <th colspan=\"3\">น้ำยาออก</th>\n");
      out.write("                <th rowspan=\"2\">กำไรขาดทุน</th>\n");
      out.write("                <th rowspan=\"2\">สุทธิ</th>\n");
      out.write("                <th rowspan=\"2\">ลักษณะน้ำยา</th>\n");
      out.write("                <th rowspan=\"2\">น้ำหนัก</th>\n");
      out.write("                <th rowspan=\"2\">ความดันโลหิต</th>\n");
      out.write("                <th rowspan=\"2\">หมายเหตุ</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>เวลาเริ่ม</td>\n");
      out.write("                <td>เวลาหมด</td>\n");
      out.write("                <td>ปริมาตร</td>\n");
      out.write("                <td>เวลาเริ่ม</td>\n");
      out.write("                <td>เวลาหมด</td>\n");
      out.write("                <td>ปริมาตร</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                <td> 1 </td>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
