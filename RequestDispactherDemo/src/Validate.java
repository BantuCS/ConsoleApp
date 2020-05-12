import java.sql.*;

public class Validate {
    public static boolean checkUser(String email,String name) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
            PreparedStatement ps = con.prepareStatement("select * from klh where email=? and name=?");
            ps.setString(1, email);
            ps.setString(2, name);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}