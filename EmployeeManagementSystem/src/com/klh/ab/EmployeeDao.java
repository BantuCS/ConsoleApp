package com.klh.ab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;
import org.hibernate.Query;
 
public class EmployeeDao {  
  
public static int register(Employee  e){  
 int i=0;  

 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

SessionFactory factory = meta.getSessionFactoryBuilder().build();
Session session = factory.openSession();
Transaction t = session.beginTransaction(); 

i=(Integer)session.save(e);  

t.commit();  
session.close();  
  
return i;  
 
 }  

public static List<Employee> getAllEmployees()
{
	  
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
     Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
    
  SessionFactory factory = meta.getSessionFactoryBuilder().build();  
  Session session = factory.openSession();  
  Transaction t = session.beginTransaction();  
  Query query = session.createQuery("from Employee");
  List emps = query.list();
  t.commit();  
  session.close();  
	return emps;
}





public static int update(Employee  e){  
int i=0;  

StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

SessionFactory factory = meta.getSessionFactoryBuilder().build();
Session session = factory.openSession();
Transaction t = session.beginTransaction(); 

session.update(e);  

t.commit();  
session.close();  

return i;  

}  


public static int deleteEmployee(Integer EmployeeID){
	
	int i=0;
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction(); 

    
    try {
      
       Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
       session.delete(employee); 
       tx.commit();
    } catch (Exception e) {
       if (tx!=null) tx.rollback();
       e.printStackTrace(); 
    } finally {
       session.close(); 
    }
    return i;
 }

}
