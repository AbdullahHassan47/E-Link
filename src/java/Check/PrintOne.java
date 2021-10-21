package Check;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class PrintOne extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Connection con;
        PreparedStatement pstmt;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            RequestDispatcher p = request.getRequestDispatcher("Profile.jsp");
            HttpSession s = request.getSession();
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("select * from clients where username=?");
            pstmt.setString(1, s.getAttribute("username").toString());
            ResultSet rs = pstmt.executeQuery();
            p.include(request, response);
            out.println("<center>");
            out.println("<pre>");
            while(rs.next())
            {
                out.print("First name: " + rs.getString("firstname") + "<br>");
                out.print("Last name: " + rs.getString("lastname") + "<br>");
                out.print("E-mail: " + rs.getString("email") + "<br>");
                //out.print("Password: " + rs.getString("password") + "<br>");
                out.print("Phone number: " + rs.getString("phonenumber") + "<br>");
                out.print("Gender: " + rs.getString("gender") + "<br>");
                out.print("Birthday: " + rs.getString("birthday") + "<br>");
                out.print("Username: " + rs.getString("username") + "<br>");
            }
            out.println("</pre>");
            out.println("</center>");
        }
        catch(Exception e){}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}