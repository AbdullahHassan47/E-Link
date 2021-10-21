package Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class CommentDb
{
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
//    public CommentDb() throws SQLException, ClassNotFoundException
//    {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
//        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
//        stmt = con.createStatement();
//        stmt.executeUpdate("create table comments (comment_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),post_id INTEGER,username varchar(25),content varchar(2500))");
//    }
    public void Insert(String post_id,String username,String content)
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("insert into comments (post_id,username,content) values (?,?,?)");
            pstmt.setInt(1, Integer.parseInt(post_id));
            pstmt.setString(2, username);
            pstmt.setString(3, content);
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
        stmt.executeUpdate("drop table comments");
    }
    public void del()
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("delete from comments where post_id = 3");
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
}