package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>SignUp Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center><h1>Sign Up</h1></center>\n");
      out.write("            <Form name=\"regestration_form\" action=\"SignUpValidate\" onsubmit=\"return validateForm()\" method=\"POST\">\n");
      out.write("                \n");
      out.write("                <table align=\"center\">\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"right\">Username : </th>\n");
      out.write("                    <td><input type=\"text\" name=\"username\" placeholder=\"username\" onblur=\"checkExist()\"/><span id=\"isExist\"></span></td>\n");
      out.write("                </tr>\n");
      out.write("                <br>\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"right\">E-Mail: </th>\n");
      out.write("                    <td><input type=\"text\" name=\"email\" placeholder=\"email\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <br>\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"right\">Mobile : </th>\n");
      out.write("                    <td><input type=\"text\" name=\"mobile\" placeholder=\"mobile\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <br>\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"right\">Password : </th>\n");
      out.write("                    <td><input type=\"password\" name=\"Pass\" placeholder=\"Pass\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <br>\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"right\">CV : </th>\n");
      out.write("                    <td><input type=\"file\" name=\"CV\" size =\"10\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"right\">\n");
      out.write("                        <input type=\"submit\" name=\"submit\" value=\"SignUp\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("                \n");
      out.write("                 \n");
      out.write("                </table>\n");
      out.write("            </Form>\n");
      out.write("        \n");
      out.write("<script>\n");
      out.write("function validateForm() {\n");
      out.write("  var name = document.forms[\"regestration_form\"][\"username\"].value;\n");
      out.write("  var email = document.forms[\"regestration_form\"][\"email\"].value;\n");
      out.write("  var mobile = document.forms[\"regestration_form\"][\"mobile\"].value;\n");
      out.write("  var password = document.forms[\"regestration_form\"][\"Pass\"].value;\n");
      out.write("  \n");
      out.write("  if (name == \"\") {\n");
      out.write("    alert(\"username must be filled out\");\n");
      out.write("    return false;\n");
      out.write("  }\n");
      out.write("  if (email == \"\") {\n");
      out.write("    alert(\"email must be filled out\");\n");
      out.write("    return false;\n");
      out.write("  }\n");
      out.write("  if (mobile == \"\") {\n");
      out.write("    alert(\"mobile must be filled out\");\n");
      out.write("    return false;\n");
      out.write("  }\n");
      out.write("  if (password == \"\") {\n");
      out.write("    alert(\"password must be filled out\");\n");
      out.write("    return false;\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("function checkExist(){\n");
      out.write("     var xmlhttp = new XMLHttpRequest();\n");
      out.write("     var username = document.forms[\"regestration_form\"][\"username\"].value;\n");
      out.write("     var url = \"profile.jsp?username=\" + username;\n");
      out.write("     xmlhttp.onreadystatechange = function(){\n");
      out.write("     if(xmlhttp.readyState === 4 && xmlhttp.status === 200){\n");
      out.write("     if(xmlhttp.responseText === \"\\n\\n\\n\\n\\nUser already exists\")\n");
      out.write("     document.getElementById(\"isExist\").style.color = \"red\";\n");
      out.write("     else\n");
      out.write("     document.getElementById(\"isExist\").style.color = \"green\";\n");
      out.write("     document.getElementById(\"isExist\").innerHTML = xmlhttp.responseText;\n");
      out.write("    }\n");
      out.write("                    \n");
      out.write("    };\n");
      out.write("    try{\n");
      out.write("    xmlhttp.open(\"GET\",url,true);\n");
      out.write("    xmlhttp.send();\n");
      out.write("}\n");
      out.write("catch(e){\n");
      out.write("    alert(\"unable to connect to server\");\n");
      out.write("}\n");
      out.write("}\n");
      out.write("</script>      \n");
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
