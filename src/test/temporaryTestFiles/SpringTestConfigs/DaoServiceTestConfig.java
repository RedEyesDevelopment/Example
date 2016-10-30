package SpringTestConfigs;

import HibernateLocalSessionUtil.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springtestapp.dao.ContactDAO;
import springtestapp.dao.ContactDAOImpl;
import springtestapp.service.ContactService;
import springtestapp.service.ContactServiceImpl;

/**
 * Created by Gvozd on 30.10.2016.
 */
@Configuration
public class DaoServiceTestConfig {

    @Bean(name = "contactService")
    public ContactService getContactService() {
        return new ContactServiceImpl();
    }

    @Bean(name="contactDAO")
    public ContactDAO getContactDAO(){
        return new ContactDAOImpl();
    }

    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory(){
        return HibernateUtil.getSessionFactory();
    }
}
