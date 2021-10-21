package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Sign_002dUp_0020and_0020Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <body>\n");
      out.write("    <head>\n");
      out.write("        <title>\n");
      out.write("            E-Link\n");
      out.write("        </title>\n");
      out.write("        <style>\n");
      out.write("            *.header\n");
      out.write("            {\n");
      out.write("                padding: 30px;\n");
      out.write("                text-align: center;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .SignUp\n");
      out.write("            {\n");
      out.write("                padding-right: 120px;\n");
      out.write("                text-align: right;\n");
      out.write("                color: blue;\n");
      out.write("            }\n");
      out.write("            .LogIn\n");
      out.write("            {\n");
      out.write("                padding-left: 120px;\n");
      out.write("                text-align: left;\n");
      out.write("                color: appworkspace;\n");
      out.write("            }\n");
      out.write("            .Sign\n");
      out.write("            {\n");
      out.write("                padding-right: 290px;\n");
      out.write("                text-align: right;\n");
      out.write("                color: blue;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body \n");
      out.write("        {\n");
      out.write("            background-image: url(\"asd.jpg\");\n");
      out.write("        }\n");
      out.write("        .no-background \n");
      out.write("        {\n");
      out.write("            background-image: url(\"asd.jpg\");\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("    <div class=\"header\">\n");
      out.write("        <font color=\"white\"><h1>eLink</h1>\n");
      out.write("        </font>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"LogIn\">\n");
      out.write("        <h2>Log In</h2>\n");
      out.write("        <form action=\"Login\" method=\"post\">\n");
      out.write("            Username: <input type=\"text\"  placeholder=\"Enter Username\" name=\"un\" ><br><br>\n");
      out.write("            Password: <input type=\"password\" placeholder=\"Enter Password\" name=\"lpass\"><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <div class=\"Sign\">\n");
      out.write("        <h2>Sign Up</h2>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"SignUp\">\n");
      out.write("        <form action=\"SignUp\" method=\"post\">\n");
      out.write("            First name: <input type=\"text\" name=\"fn\" placeholder=\"Enter Your Fristname\" maxlength=\"15\" required><br><br>\n");
      out.write("            Last name:  <input type=\"text\" name=\"ln\" placeholder=\"Enter Your Lastname\" maxlength=\"15\" required><br><br>\n");
      out.write("            Username:   <input type=\"text\" name=\"sun\" placeholder=\"Enter Your Username\" maxlength=\"20\" required><br><br>\n");
      out.write("            Your E-mail: <input type=\"email\" name=\"email\" placeholder=\"sophie@example.com\" required><br><br>\n");
      out.write("            Re-enter your E-mail: <input type=\"email\" name=\"remail\" placeholder=\"sophie@example.com\" required><br><br>\n");
      out.write("            New password:       <input type=\"password\" name=\"spass\" minlength=\"8\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" title=\"Please include at least 1 uppercase character, 1 lowercase character, and 1 number.\" required><br><br>\n");
      out.write("            Re-type password:   <input type=\"password\" name=\"rspass\" minlength=\"8\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" title=\"Please include at least 1 uppercase character, 1 lowercase character, and 1 number.\" required><br><br>\n");
      out.write("            Mobile number:      <input type=\"text\" name=\"num\"><br><br>\n");
      out.write("            Gender:             <input type=\"radio\" name=\"gender\" value=\"Male\" checked>Male \n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"Female\">Female<br><br>\n");
      out.write("            Birthday:           <input type=\"date\" name=\"bday\" max=\"2015-12-31\" min=\"1950-12-31\"><br><br>\n");
      out.write("                                <input type=\"submit\" value=\"Sign Up\">\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
