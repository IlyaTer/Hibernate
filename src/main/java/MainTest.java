
import com.mycompany.dzjdbchibernate.hibernate.config.AppConfig;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IBookDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes.CustomerDaoImpl;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.ICustomerDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IPurchaseDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IStoreDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=================================================");
        System.out.println();

        IBookDao books = context.getBean("bookDao", IBookDao.class);
        ICustomerDao cust = context.getBean("customerDao", ICustomerDao.class);
        IStoreDao st = context.getBean("storeDao", IStoreDao.class);
        IPurchaseDao purch = context.getBean("purchDao", IPurchaseDao.class);

        System.out.println(books.findById(1));
        System.out.println(cust.findById(1));
        System.out.println(st.findById(1));

        Store store = new Store();
        store.setCommissions(12.0);
        store.setName("New Store");
        store.setDistrict("District 2");
        
        st.addUpdate(store);
                
        System.out.println("Stores:");
        for (Store s : st.findAllWithDetail()) {
            System.out.println(s);
            for (Purchase p : s.getPurchases()) {
                System.out.println("    "+p);
            }
        }
        
        System.out.println("Purch:");
        for (Purchase p : purch.findAll()) {
            System.out.println(p);
        }

        System.out.println("Customers:");
        for (Customer c : cust.findAllWithDetail()) {
            System.out.println(c);
            for (Purchase p : c.getPurchases()) {
                System.out.println("    "+p);
            }
        }

        System.out.println("Books:");
        for (Book b : books.findAllWithDetail()) {
            System.out.println(b);
            for (Purchase p : b.getPurchases()) {
                System.out.println("    "+p);
            }
        }

        System.out.println();
        System.out.println("=================================================");
    }//end main 
}//end MainTest
