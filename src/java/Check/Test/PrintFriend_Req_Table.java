package Check.Test;
import Check.Friend_req_Db;
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
public class PrintFriend_Req_Table extends HttpServlet
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
            ResultSet rs = stmt.executeQuery("select * from friend_req");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.print("<h1>From:To<br></h1>");
            while(rs.next())
            {
                out.print(rs.getString("sender_username") + ":" + rs.getString("reciver_username") + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
//            Friend_req_Db frd = new Friend_req_Db();
//            frd.Drop();
        }
        catch(Exception e){}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}