import org.springframework.orm.hibernate4.HibernateTemplate;
 
public class BookDao {
    private HibernateTemplate hibernateTemplate;
 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
        this.hibernateTemplate.setCheckWriteOperations(false);
      
    }
 
    public void save(Book book) {
        hibernateTemplate.save(book);
    }
}