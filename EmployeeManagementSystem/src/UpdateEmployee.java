import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.klh.ab.EmployeeDao;  
import com.klh.ab.Employee;
@WebServlet("/UpdateEmployee")  
public class UpdateEmployee extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
      
          
        Employee e= new Employee();
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
       
          
        int status=EmployeeDao.update(e);  
        if(status>0) 
            response.sendRedirect("ViewEmployee");  
    else{  
        	response.sendRedirect("ViewEmployee"); 
        }  
          
        out.close();  
    }  
  
}  