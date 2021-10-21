package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_0020Page_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            body \n");
      out.write("            {\n");
      out.write("                margin: 0;\n");
      out.write("                font-size: 28px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header\n");
      out.write("            {\n");
      out.write("                background-image: url(\"journey-login-background.png\");\n");
      out.write("                padding: 30px;\n");
      out.write("                color: #ffffff;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar\n");
      out.write("            {\n");
      out.write("                overflow: hidden;\n");
      out.write("                background-color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar a\n");
      out.write("            {\n");
      out.write("                float: right;\n");
      out.write("                display: block;\n");
      out.write("                color: #f2f2f2;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 17px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar logo\n");
      out.write("            {\n");
      out.write("                float: left;\n");
      out.write("                display: block;\n");
      out.write("                color: #f2f2f2;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar a:hover\n");
      out.write("            {\n");
      out.write("                background-color: #ddd;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navbar a.active \n");
      out.write("            {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .content\n");
      out.write("            {\n");
      out.write("                padding: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .sticky\n");
      out.write("            {\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .sticky + .content\n");
      out.write("            {\n");
      out.write("                padding-top: 60px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <h2>elink header</h2>\n");
      out.write("            <p>elink paragraph</p>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"navbar\">\n");
      out.write("            <a href=\"Sign-Up and Login.jsp\">Sign out</a>\n");
      out.write("            <a href=\"PrintOne\">Profile</a>\n");
      out.write("            <a class=\"active\" href=\"javascript:void(0)\">Home</a>\n");
      out.write("            <logo href=\"javascript:void(0)\">eLink</logo>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            window.onscroll = function () \n");
      out.write("            {\n");
      out.write("                myFunction();\n");
      out.write("            };\n");
      out.write("            var navbar = document.getElementById(\"navbar\");\n");
      out.write("            var sticky = navbar.offsetTop;\n");
      out.write("            function myFunction() \n");
      out.write("            {\n");
      out.write("                if (window.pageYOffset >= sticky) \n");
      out.write("                {\n");
      out.write("                    navbar.classList.add(\"sticky\");\n");
      out.write("                } \n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    navbar.classList.remove(\"sticky\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <h3><a href=\"ShowFriendList\">Friend List</a></h3>\n");
      out.write("        <h3><a href=\"ShowFriendRequest\">Friend request</a></h3>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <section>\n");
      out.write("            ");

                HttpSession s = request.getSession();
                String name = s.getAttribute("username").toString();
            
      out.write("\n");
      out.write("            <h4>Welcome ");
      out.print(name);
      out.write("</h4>\n");
      out.write("            <form action=\"InsertPost\" method=\"post\">\n");
      out.write("                <pre>\n");
      out.write("                                <textarea rows=\"4\" cols=\"50\" name=\"post\" placeholder=\"What's on your mind?\"></textarea>\n");
      out.write("                                                     <input type=\"submit\" value=\"Post\">\n");
      out.write("                </pre>\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
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
