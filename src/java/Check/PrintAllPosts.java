package Check;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class PrintAllPosts extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        Connection con;
        Statement stmt1,stmt2;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            RequestDispatcher rd = request.getRequestDispatcher("Home Page.jsp");
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("select * from posts");
            rd.include(request, response);
            out.println("<center>");
            out.println("<pre>");
            while(rs.next())
            {
                out.print("<form action='friendInfo' method='get'>");
                out.print("<input type='hidden' value='"+rs.getString("username")+"' name='user'>");
                out.print("<input type='submit' value='"+rs.getString("username")+"'>");
                out.print("</form>");
                HttpSession s = request.getSession();
                s.setAttribute("post_user", rs.getString("username"));
                s.setAttribute("post_content", rs.getString("content"));
                out.print(rs.getString("content") + "<br>");
                out.print("<form action='AddLike' method='get'>"
                   + rs.getInt("like_count") + "<input type='submit' name='like' value='Likes'>");
                out.print("<input type='hidden' value='"+rs.getString("post_id")+"' name='id'>");
                out.print("</form>");
                out.print("<h4>Comments:</h4>");
                stmt2 = con.createStatement();
                ResultSet com = stmt2.executeQuery("select * from COMMENTS,POSTS where COMMENTS.POST_ID = POSTS.POST_ID and POSTS.POST_ID=" + rs.getInt("post_id"));
                while(com.next())
                {
                    out.print("<form action='friendInfo' method='get'>");
                    out.print("<input type='hidden' value='" + com.getString("username") + "' name='user'>");
                    out.print("<input type='submit' value='" + com.getString("username") + "'>");
                    out.print(com.getString("content") + "<br></form>");
                }
                out.print("<form action='InsertComment' method='get'><textarea rows='2' cols='30' name='comment' placeholder='Write a comment here...'></textarea><br>");
                out.print("<input type='hidden' value='"+rs.getString("post_id")+"' name='id'>");
                out.print("<input type='submit' value='Comment'></form>");
            }
            out.println("</pre>");
            out.println("</center>");
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
            Logger.getLogger(PrintAllPosts.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PrintAllPosts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }
}