package Check.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Print extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Connection con;
        Statement stmt;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from clients");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            while(rs.next())
            {
                out.print(rs.getString("firstname") + " ");
                out.print(rs.getString("lastname") + " ");
                out.print(rs.getString("email") + " ");
                out.print(rs.getString("password") + " ");
                out.print(rs.getString("phonenumber") + " ");
                out.print(rs.getString("gender") + " ");
                out.print(rs.getString("birthday") + " ");
                out.print(rs.getString("username") + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
/*<%
                            Connection con;
                            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from clients where username='"+session.getAttribute("username")+"'");
                            %>First name: <%rs.getString("firstname");
                            %>Last name: <%rs.getString("lastname");
                            %>E-mail: <%rs.getString("email");
                            %>Password: <%rs.getString("password");
                            %>Phone number: <%rs.getString("phonenumber");
                            %>Gender: <%rs.getString("gender");
                            %>Birthday: <%rs.getString("birthday");
                            %>Username: <%rs.getString("username");
    %>*/