package Check;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddLike extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        Connection con;
        Statement stmt;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            RequestDispatcher rd = request.getRequestDispatcher("PrintAllPosts");
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            stmt = con.createStatement();
            stmt.executeUpdate("update posts set like_count=like_count+1 where post_id="+request.getParameter("id"));
            rd.include(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try 
        {
            processRequest(request, response);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(AddLike.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try 
        {
            processRequest(request, response);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(AddLike.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}