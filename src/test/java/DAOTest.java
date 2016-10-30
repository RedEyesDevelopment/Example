import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springtestapp.model.Contact;
import springtestapp.service.ContactService;

/**
 * Created by Gvozd on 30.10.2016.
 */
public class DAOTest {
    @Test
    @SuppressWarnings("resource")
    public void HibernateTest(){
//        ApplicationContext appContext = new AnnotationConfigApplicationContext(DaoServiceTestConfig.class);
        ApplicationContext appContext = new ClassPathXmlApplicationContext("DaoServiceTestResources/test-spring-root-context.xml");
        ContactService service = (ContactService) appContext.getBean("contactService");
        for (Contact contact:service.findAll()){
            System.out.println(contact.toString());
        }


    }
}