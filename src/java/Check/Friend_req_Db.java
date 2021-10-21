package Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Friend_req_Db
{
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
//    public Friend_req_Db() throws SQLException, ClassNotFoundException
//    {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
//        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
//        stmt = con.createStatement();
//        stmt.executeUpdate("create table friend_req (sender_username varchar(25), reciver_username varchar(25),primary key (sender_username, reciver_username))");
//    }
    public void Insert(String sender_username,String reciver_username)
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("insert into friend_req values (?,?)");
            pstmt.setString(1, sender_username);
            pstmt.setString(2, reciver_username);
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
    public void PrintAllFriendRequest()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from friend_req");
            while(rs.next())
            {
                System.out.println(rs.getString("sender_username"));
                System.out.println(rs.getString("reciver_username"));
            }
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
    public void del(String sender_username,String reciver_username)
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("delete from friend_req where sender_username = '?' and reciver_username = '?'");
            pstmt.setString(1, sender_username);
            pstmt.setString(2, reciver_username);
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
        stmt.executeUpdate("drop table friend_req");
    }
}