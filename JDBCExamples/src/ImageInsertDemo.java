
import java.sql.*;  
import java.io.*;  
import java.util.*;

public class ImageInsertDemo{  
public static void main(String[] args) {  
String cname=new String();
String path=new String();

Scanner sc=new Scanner(System.in);


System.out.println("Enter Country Name:");
 cname=sc.next();

System.out.println("Enter path:");
 path=sc.next();


try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle"); 
              
PreparedStatement ps=con.prepareStatement("insert into Flag values(?,?)");  
ps.setString(1,cname);  
  
FileInputStream fin=new FileInputStream(path);  
ps.setBinaryStream(2,fin,fin.available());  
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  
          
con.close();  
}catch (Exception e) {e.printStackTrace();}  
}  
}  