import java.util.List;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  

 
public class Test {
    public static void main(String[] args) 
    {
    	 Resource r=new ClassPathResource("beans.xml");  
    	    BeanFactory factory=new XmlBeanFactory(r);  
       
        BookDao dao = (BookDao)factory.getBean("bookDao");
 
        Book book = new Book();
        book.setId(123);
 
        book.setAuthor("John McCarthy");
        book.setIsbn("978-19302-2049");
        book.setName("Artificial Intelligence a mordern approach");
        book.setPrice(669);
        book.setPublisher("McGraw hill");
 
        dao.save(book);        
    }
}