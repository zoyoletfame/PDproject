package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class recordDialysis_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <style>\n");
      out.write("            .menu {\n");
      out.write("                overflow: hidden;\n");
      out.write("                background-color: #333;\n");
      out.write("                font-family: Arial;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .menu a {\n");
      out.write("                float: left;\n");
      out.write("                font-size: 16px;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .ล้างไต{\n");
      out.write("                float: left;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .ล้างไต .dropbtn {\n");
      out.write("                font-size: 16px;    \n");
      out.write("                border: none;\n");
      out.write("                outline: none;\n");
      out.write("                color: white;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                background-color: inherit;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container a:hover, .dropdown:hover .dropbtn {\n");
      out.write("                background-color: red;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content {\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("                min-width: 160px;\n");
      out.write("                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a {\n");
      out.write("                float: none;\n");
      out.write("                color: black;\n");
      out.write("                padding: 12px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a:hover {\n");
      out.write("                background-color: #ddd;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .ล้างไต:hover .dropdown-content {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form>\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <div class=\"ล้างไต\">\n");
      out.write("                    <button class=\"dropbtn\">บันทึกการล้างไต</button>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"\">ล้างไต</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"\">Home</a>\n");
      out.write("            </div>\n");
      out.write("        </form>    \n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <form action=\"/SeniorProject/DialysisServlet\" method=\"get\">\n");
      out.write("            ");

                if (request.getAttribute("volIn") != null) {
            
      out.write("\n");
      out.write("            <input type=\"textfield\" name=\"date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dates}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>  \n");
      out.write("\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <input type=\"textfield\" name=\"date\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>  \n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <br>\n");
      out.write("            รอบที่ <h5 style=\"margin-left: 90%;\"><input type=\"checkbox\" name=\"auto1\" value=\"auto1\">ตั้งเวลาอัตโนมัติ</h5>\n");
      out.write("\n");
      out.write("            <table width=\"100%\" border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    ");

                        if (request.getAttribute("volIn") != null) {
                    
      out.write("\n");
      out.write("                    <td>น้ำยาเข้า</td>\n");
      out.write("                    <td>เวลาเริ่ม <input type=\"time\" name=\"timeStartInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${timeIn_start}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">นาที</td>\n");
      out.write("                    <td>เวลาออก <input type=\"time\" name=\"timeEndInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${timeIn_end}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">นาที</td>\n");
      out.write("                    <td>ปริมาตร <input type=\"text\" name=\"capacityInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${volIn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>น้ำยาออก</td>\n");
      out.write("                    <td>เวลาเริ่ม <input type=\"time\" name=\"timeStartOut\">นาที</td>\n");
      out.write("                    <td>เวลาออก <input type=\"time\" name=\"timeEndOut\">นาที</td>\n");
      out.write("                    <td>ปริมาตร <input type=\"text\" name=\"capacityOutput\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ปัสสาวะ</td>\n");
      out.write("                    <td><input type=\"text\" name=\"urinate\"></td>\n");
      out.write("                    <td> ลักษณะน้ำยา  <select name=\"desDia\">\n");
      out.write("                            <option value=\"เหลืองใส\">เหลืองใส</option>\n");
      out.write("                            <option value=\"ขาวใส\">ขาวใส</option>\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <tr>\n");
      out.write("                        \n");
      out.write("                    ");

                        }else if (request.getAttribute("volIn") != null && request.getAttribute("volOut") != null) {
                    
      out.write("\n");
      out.write("                    <td>น้ำยาเข้า</td>\n");
      out.write("                    <td>เวลาเริ่ม <input type=\"time\" name=\"timeStartInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${timeIn_start}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">นาที</td>\n");
      out.write("                    <td>เวลาออก <input type=\"time\" name=\"timeEndInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${timeIn_end}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">นาที</td>\n");
      out.write("                    <td>ปริมาตร <input type=\"text\" name=\"capacityInput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${volIn}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>น้ำยาออก</td>\n");
      out.write("                    <td>เวลาเริ่ม <input type=\"time\" name=\"timeStartOut\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${timeOut_start}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">นาที</td>\n");
      out.write("                    <td>เวลาออก <input type=\"time\" name=\"timeEndOut\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${timeOut_start}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">นาที</td>\n");
      out.write("                    <td>ปริมาตร <input type=\"text\" name=\"capacityOutput\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${volEnd}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ปัสสาวะ</td>\n");
      out.write("                    <td><input type=\"text\" name=\"urinate\"></td>\n");
      out.write("                    <td> ลักษณะน้ำยา  <select name=\"desDia\">\n");
      out.write("                            <option value=\"เหลืองใส\">เหลืองใส</option>\n");
      out.write("                            <option value=\"ขาวใส\">ขาวใส</option>\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                    <td>น้ำยาเข้า</td>\n");
      out.write("                    <td>เวลาเริ่ม <input type=\"time\" name=\"timeStartInput\">นาที</td>\n");
      out.write("                    <td>เวลาออก <input type=\"time\" name=\"timeEndInput\">นาที</td>\n");
      out.write("                    <td>ปริมาตร <input type=\"text\" name=\"capacityInput\"></td>\n");
      out.write("                <tr>\n");
      out.write("                    <td>น้ำยาออก</td>\n");
      out.write("                    <td>เวลาเริ่ม <input type=\"time\" name=\"timeStartOut\">นาที</td>\n");
      out.write("                    <td>เวลาออก <input type=\"time\" name=\"timeEndOut\">นาที</td>\n");
      out.write("                    <td>ปริมาตร <input type=\"text\" name=\"capacityOutput\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ปัสสาวะ</td>\n");
      out.write("                    <td><input type=\"text\" name=\"urinate\"></td>\n");
      out.write("                    <td> ลักษณะน้ำยา  <select name=\"desDia\">\n");
      out.write("                            <option value=\"เหลืองใส\">เหลืองใส</option>\n");
      out.write("                            <option value=\"ขาวใส\">ขาวใส</option>\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                </tr>   \n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"บันทึก\">\n");
      out.write("        </form>\n");
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
