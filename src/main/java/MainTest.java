
import com.mycompany.dzjdbchibernate.hibernate.config.AppConfig;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IBookDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes.CustomerDaoImpl;
import com.mycompany.dzjdbchibernate.hibernate.dao.classes.services.StoreService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.BookDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.CustomerDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.ICustomerDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IPurchaseDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IStoreDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.PurchaseDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.StoreDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksFive;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksFour;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksThree;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksTwo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=================================================");
        System.out.println();
        
        TasksTwo task = new TasksTwo(context);
        task.start();
        
        TasksThree task1 = new TasksThree(context);
        task1.start();
        
        TasksFour task2 = new TasksFour(context);
        task2.start();
        
        TasksFive task3 = new TasksFive(context);
        task3.start();

        System.out.println();
        System.out.println("=================================================");
    }//end main 
}//end MainTest
