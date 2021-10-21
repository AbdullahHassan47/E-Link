package Check;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class friendInfo extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            RequestDispatcher p = request.getRequestDispatcher("CheckFriend");
            RequestDispatcher rd = request.getRequestDispatcher("PrintOne");
            HttpSession s = request.getSession();
            s.setAttribute("reciver_username", request.getParameter("user"));
            if(s.getAttribute("username").toString().equals(s.getAttribute("reciver_username").toString()))
            {
                rd.include(request, response);
            }
            else
            {
                p.forward(request, response);
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