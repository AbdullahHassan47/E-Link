package Check;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ShowFriendList extends HttpServlet
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
            RequestDispatcher rd = request.getRequestDispatcher("FriendList.jsp");
            rd.include(request, response);
            HttpSession s = request.getSession();
            ResultSet rs = stmt.executeQuery("select * from friends where reciver_username='"+s.getAttribute("username").toString()+"'");
            while(rs.next())
            {
                out.print(rs.getString("sender_username"));
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