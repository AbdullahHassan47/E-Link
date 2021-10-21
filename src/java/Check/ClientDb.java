package Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ClientDb
{
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
//    public MyDb() throws SQLException, ClassNotFoundException
//    {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
//        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
//        stmt = con.createStatement();
//        stmt.executeUpdate("create table clients (firstname varchar(25), lastname varchar(25), email varchar(25), password varchar(25), phonenumber varchar(25), gender varchar(25), birthday varchar(25), username varchar(25) unique, primary key(email))");
//    }
    public void Insert(String firstName,String lastName,String email,String signUpPass,String num,String gender,String birthDay,String signUsername)
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            pstmt = con.prepareStatement("insert into clients values (?,?,?,?,?,?,?,?)");
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, signUpPass);
            pstmt.setString(5, num);
            pstmt.setString(6, gender);
            pstmt.setString(7, birthDay);
            pstmt.setString(8, signUsername);
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
    public boolean signUpCheck(String signUsername, String email) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
        pstmt = con.prepareStatement("select username,email from clients where username=? or email=?");
        pstmt.setString(1, signUsername);
        pstmt.setString(2, email);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
    public boolean loginCheck(String username, String password) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
        pstmt = con.prepareStatement("select username,password from clients where username=? and password=?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
    public void PrintAllClients()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby:code/db;create=true");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from clients");
            while(rs.next())
            {
                System.out.println(rs.getString("firstname"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("phonenumber"));
                System.out.println(rs.getString("gender"));
                System.out.println(rs.getString("birthday"));
                System.out.println(rs.getString("username"));
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
}