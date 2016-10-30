import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springtestapp.model.Contact;
import springtestapp.model.ContactTelDetail;
import springtestapp.model.Hobby;
import springtestapp.service.ContactService;

import java.util.Date;
import java.util.List;

/**
 * Created by Gvozd on 30.10.2016.
 */
public class DaoAndServiceTests {
    @Test
    @SuppressWarnings("resource")
    public void TestFindAllWithDetail() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("DaoServiceTestResources/test-spring-root-context.xml");
        ContactService service = (ContactService) appContext.getBean("contactService");
        List<Contact> resultset = service.findAllWithDetail();
        for (Contact contact : resultset) {
            System.out.println(contact.toString());
            if (contact.getContactTelDetails() != null) {
                System.out.println("Contact telephones:");
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                System.out.println("Hobbies:");
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
        }
    }

    @Test
    @SuppressWarnings("resource")
    public void TestFindById() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("DaoServiceTestResources/test-spring-root-context.xml");
        ContactService service = (ContactService) appContext.getBean("contactService");
        Long searchableId = 4L;
        Contact contact = service.findById(searchableId);
        System.out.println("Contact with id=" + searchableId + " is " + contact.toString());
        if (contact.getContactTelDetails() != null) {
            System.out.println("Contact telephones:");
            for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                System.out.println(contactTelDetail);
            }
        }
        if (contact.getHobbies() != null) {
            System.out.println("Hobbies:");
            for (Hobby hobby : contact.getHobbies()) {
                System.out.println(hobby);
            }
        }
    }

    @Test
    @SuppressWarnings("resource")
    public void TestSaveContact() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("DaoServiceTestResources/test-spring-root-context.xml");
        ContactService service = (ContactService) appContext.getBean("contactService");

        Contact contact = new Contact();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "11111111");
        contact.addContactTelDetail(contactTelDetail);
        contactTelDetail = new ContactTelDetail("Mobile", "22222222");
        contact.addContactTelDetail(contactTelDetail);

        service.save(contact);
    }

    @Test
    @SuppressWarnings("resource")
    public void TestFindByIdAndUpdateContact() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("DaoServiceTestResources/test-spring-root-context.xml");
        ContactService service = (ContactService) appContext.getBean("contactService");
        Long searchableId = 4L;
        Contact contact = service.findById(searchableId);
        System.out.println(contact);
        if (contact.getContactTelDetails() != null) {
            System.out.println("Contact telephones:");
            for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                System.out.println(contactTelDetail);
            }
        }
        contact.setFirstName("Kim");
        contact.setLastName("Wong");
        ContactTelDetail toDelete = null;
        for (ContactTelDetail contactTel : contact.getContactTelDetails()) {
            if (contactTel.getTelType().equals("Home")) {
                System.out.println(contactTel);
                toDelete = contactTel;
            }
        }
        if (toDelete != null) contact.removeContactTelDetail(toDelete);
        service.getSessionFactory().openStatelessSession().update(contact);
//        service.update(contact);
        //*service.save(contact);
    }
}