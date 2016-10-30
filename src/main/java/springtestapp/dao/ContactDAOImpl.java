package springtestapp.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springtestapp.model.Contact;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Gvozd on 26.03.2016.
 */
@Repository
public class ContactDAOImpl implements ContactDAO {
    private final static Log logger = LogFactory.getLog(ContactDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ContactDAOImpl() {
    }

    public void save(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @SuppressWarnings("unchecked")
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    @SuppressWarnings("unchecked")
    public List<Contact> findAllWithDetail() {
        return sessionFactory.openSession().getNamedQuery("Contact.findAllWithDetail").list();
    }

    public void delete(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }

    @SuppressWarnings("unchecked")   
    public Contact findById(Long id) {
        return (Contact) sessionFactory.openSession().getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
    }
}