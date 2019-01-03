
import com.mycompany.dzjdbchibernate.hibernate.config.AppConfig;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksFive;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksFour;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksGeneral;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksThree;
import com.mycompany.dzjdbchibernate.hibernate.tests.TasksTwo;
import static java.lang.System.out;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("=================================================");
        System.out.println();
        
        TasksGeneral tests = new TasksGeneral(context);
        tests.start();

        System.out.println();
        System.out.println("=================================================");
    }//end main 
}//end MainTest
