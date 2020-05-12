import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import java.util.*;
  
public class InsertData {  
  
    public static void main( String[] args )  

    {  System.out.println("enter details in order like id,name,course");
    	
    	Scanner sc=new Scanner(System.in);
    	
    	int id=sc.nextInt();
    	String n=sc.next();
    	String c=sc.next();
    	
    	
         StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
          
         Student s1=new Student();    
            s1.setId(id);    
            s1.setName(n);    
            s1.setCourse(c);    
            session.save(s1);  
            t.commit();  
            System.out.println("successfully saved");    
             factory.close();  
             session.close(); 
            
      session.save(s1);  
       t.commit();  
       System.out.println("successfully saved");    
        factory.close();  
        session.close();     
    }  
}  
