package Check;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CheckFriend extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Connection con;
        Statement stmt,stmt1;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            RequestDispatcher f = request.getRequestDispatcher("FriendPage.jsp");
            RequestDispatcher nf = request.getRequestDispatcher("NotFriendPage.jsp");
            HttpSession s = request.getSession();
            System.out.println("Rec = " + s.getAttribute("reciver_username").toString());
            System.out.println("Log = " + s.getAttribute("username").toString());
            stmt = con.createStatement();
            ResultSet ch = stmt.executeQuery("select * from friends where sender_username='"+s.getAttribute("reciver_username").toString()+"' and reciver_username='"+s.getAttribute("username").toString()+"'");
            if(ch.next())
            {
                f.include(request, response);
                stmt1 = con.createStatement();
                ResultSet rs = stmt1.executeQuery("select * from clients where username='"+s.getAttribute("reciver_username").toString()+"'");
                out.println("<center>");
                out.println("<pre>");
                while (rs.next()) 
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
            else
            {
                nf.include(request, response);
                stmt1 = con.createStatement();
                ResultSet rs = stmt1.executeQuery("select * from clients where username='"+s.getAttribute("reciver_username").toString()+"'");
                out.println("<center>");
                out.println("<pre>");
                while (rs.next()) 
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