package springtestapp.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springtestapp.model.Contact;

import java.util.List;

/**
 * Created by Gvozd on 26.03.2016.
 */
@Repository
public class ContactDAOImpl implements ContactDAO {
    private final static Log logger = LogFactory.getLog(ContactDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

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

    public List<Contact> findAllWithDetail() {
        return null;
    }

    public void delete(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }

    public Contact findById(Long id) {
        Contact resultcontact = new Contact();
        try {
            resultcontact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
        } catch (Exception e) {
            resultcontact = null;
        }
        return resultcontact;
    }
}