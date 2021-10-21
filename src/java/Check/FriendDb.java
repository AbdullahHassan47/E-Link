package Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class FriendDb
{
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
//    public FriendDb() throws SQLException, ClassNotFoundException
//    {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
//        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
//        stmt = con.createStatement();
//        stmt.executeUpdate("create table friends (sender_username varchar(25), reciver_username varchar(25),primary key (sender_username, reciver_username))");
//    }
    public void Insert(String sender_username,String reciver_username) throws SQLException
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("insert into friends values (?,?)");
            pstmt.setString(1, sender_username);
            pstmt.setString(2, reciver_username);
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("insert into friends values (?,?)");
            pstmt.setString(2, sender_username);
            pstmt.setString(1, reciver_username);
            pstmt.executeUpdate();
            stmt = con.createStatement();
            stmt.executeUpdate("delete from friend_req where sender_username = '"+sender_username+"' and reciver_username ='"+reciver_username+"'");
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
        stmt.executeUpdate("drop table friends");
    }
}