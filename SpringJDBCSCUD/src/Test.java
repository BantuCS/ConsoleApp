import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import java.util.*;
public class Test {  
 
public static void main(String[] args) {  
	
    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
    EmployeeDAO dao=(EmployeeDAO)ctx.getBean("edao");  
    Employee e=new Employee(); 
    Scanner sc=new Scanner(System.in);
    System.out.println("CRUD Operations");
    System.out.println("1. Add Employee");
    System.out.println("2. Delete Employee");
    System.out.println("3. Update Employee");
    System.out.println("4. View Employee");
    System.out.println("Enter which operation to be performed");
    
    int ch=sc.nextInt();
    
    if(ch==1)
    {
    
   System.out.println("Enter the Employee details sid,name,salary ");
   int id=sc.nextInt();
   String name= sc.next();
   float salary=sc.nextFloat();
    int status=dao.saveEmployee(new Employee(id,name,salary));  
    System.out.println(status);  
    }
    
    else if(ch==2)
    {System.out.println("Enter the Employee Id to delete ");
       int id=sc.nextInt();
       
        e.setId(id); 
        int status=dao.deleteEmployee(e); 
        System.out.println(status);
    }
    
    else if(ch==3)
    {
    	System.out.println("Enter the Employee Id to update details ");
        int id=sc.nextInt();
        e.setId(id);
        System.out.println("Enter the Employee Salary to update ");
        float s=sc.nextFloat();
        e.setSalary(s);
    	int status=dao.updateEmployee(e); 
        System.out.println(status); 
         }
          
    else if (ch==4)
    {
    	 List<Employee> list=dao.getAllEmployees();  
         
    	    for(Employee ae:list)  
    	        System.out.println(ae);  
    }
    
      
}  
  
}  