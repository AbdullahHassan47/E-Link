package Check;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class InsertComment extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession s = request.getSession();
            String post_id = request.getParameter("id");
            String username = s.getAttribute("username").toString();
            String content = request.getParameter("comment");
            CommentDb commentDb = new CommentDb();
            commentDb.Insert(post_id, username, content);
            RequestDispatcher rd = request.getRequestDispatcher("PrintAllPosts");
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
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(InsertComment.class.getName()).log(Level.SEVERE, null, ex);
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
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(InsertComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}