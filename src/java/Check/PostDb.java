package Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class PostDb
{
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
//    public PostDb() throws SQLException, ClassNotFoundException
//    {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
//        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
//        stmt = con.createStatement();
//        stmt.executeUpdate("create table posts (post_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),username varchar(25), content varchar(2500),like_count INTEGER default 0)");
//    }
    public void Insert(String username,String content)
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("insert into posts(username,content) values (?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
        }
        catch (SQLException ex){}
        finally
        {
            try 
            {
                con.close();
            }
            catch (SQLException ex){}
        }
    }
    public void Drop() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
        stmt = con.createStatement();
        stmt.executeUpdate("drop table posts");
    }
}