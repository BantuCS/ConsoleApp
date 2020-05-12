package com.klh.ab;

import java.io.IOException;  
import java.io.PrintWriter;  

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
   
          
       
      StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
       Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session session = factory.openSession();  
    Transaction t = session.beginTransaction();  
    Employee e=new Employee();  
    e.setName(name);  
    e.setPassword(password);  
    e.setEmail(email);  
  Integer status= (Integer)session.save(e);  
   t.commit();  
  
    factory.close();  
    session.close();   
    
    if(status>0){  
        out.print("<a href=ViewEmployee>View</a><br>");  
        out.print("<a href=Update.jsp>Update</a><br>");  
        out.print("<a href=delete.jsp>Delete</a><br>");  
        
    }else{  
        out.println("Sorry! unable to save record");  
    }  
          
        out.close();  
    }  
  
}  