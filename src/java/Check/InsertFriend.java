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
public class InsertFriend extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession s = request.getSession();
            String sender_username = request.getParameter("sender_username");
            String reciver_username = s.getAttribute("username").toString();
            FriendDb fd = new FriendDb();
            fd.Insert(sender_username, reciver_username);
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
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(InsertFriend.class.getName()).log(Level.SEVERE, null, ex);
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
        catch(SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(InsertFriend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}