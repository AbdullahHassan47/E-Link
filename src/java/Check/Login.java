package Check;
import javax.servlet.http.*; 
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
public class Login extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String username = request.getParameter("un");
            String password = request.getParameter("lpass");
            ClientDb db = new ClientDb();
            RequestDispatcher fail = request.getRequestDispatcher("Sign-Up and Login.jsp");
            RequestDispatcher success = request.getRequestDispatcher("PrintAllPosts");
            HttpSession s = request.getSession();
            s.setAttribute("username",request.getParameter("un"));
            if(db.loginCheck(username, password))
            {
                success.include(request, response);
            }
            else
            {
                out.println("<h2>Wrong username or password!</h2>");
                fail.include(request, response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}