package Check.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Query extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        Connection con;
        Statement stmt;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery("select * from posts inner join comments on comments.post_id = 2");
            //ResultSet rs = stmt.executeQuery("select * from posts inner join comments on comments.post_id = 2");
            ResultSet rs = stmt.executeQuery("select * from friends where sender_username='Momo' and reciver_username='AbdoLala'");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            while(rs.next())
            {
                out.println(rs.getString(1) + "<br>");
                out.println(rs.getString(2) + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}