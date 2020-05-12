import java.util.*;  
import java.sql.*;  
  
public class StudentDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
public static int save(Student s){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into student(sid,name,year,branch,section,email,contact,pcontact) values (?,?,?,?,?,?,?,?)");  
            ps.setInt(1,s.getId());  
            ps.setString(2,s.getName());  
            ps.setInt(3,s.getYear());  
            ps.setString(4,s.getBranch());  
            ps.setInt(5,s.getSection());  
            ps.setString(6,s.getEmail());  
            ps.setLong(7,s.getContact());  
            ps.setLong(8,s.getPContact());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
   
    public static int update(Student s){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update student set sid=? name=?,year=?,branch=?,section=?,email=?,contact=?,pcontact=? where sid=?");  
            ps.setInt(1,s.getId());  
            ps.setString(2,s.getName());  
            ps.setInt(3,s.getYear());  
            ps.setString(4,s.getBranch());  
            ps.setInt(5,s.getSection());  
            ps.setString(6,s.getEmail());  
            ps.setLong(7,s.getContact());  
            ps.setLong(8,s.getPContact());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
   
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from student where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getStudentById(int id){  
        Student s=new Student();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            	 s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                 s.setYear(rs.getInt(3));  
             s.setBranch(rs.getString(4));  
                 s.setSection(rs.getInt(5));
                 s.setEmail(rs.getString(6));
             s.setContact(rs.getLong(7));
             s.setPContact(rs.getLong(8));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return s;  
    }  
    public static List<Student> getAllStudents(){  
        List<Student> list=new ArrayList<Student>();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	 Student s=new Student();  
            	 s.setId(rs.getInt(1));
                 s.setName(rs.getString(2));
                  s.setYear(rs.getInt(3));  
              s.setBranch(rs.getString(4));  
                  s.setSection(rs.getInt(5));
                  s.setEmail(rs.getString(6));
              s.setContact(rs.getLong(7));
              s.setPContact(rs.getLong(8));
                list.add(s);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  