package springtestapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springtestapp.dao.ContactDAO;
import springtestapp.model.Contact;

import java.util.List;

/**
 * Created by Gvozd on 26.03.2016.
 */
@Service
public class ContactServiceImpl implements ContactService {
    private final static Log logger = LogFactory.getLog(ContactServiceImpl.class);

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        return contactDAO.findAllWithDetail();
    }

    @Transactional
    public void delete(Long id) {
        contactDAO.delete(id);
    }

    @Transactional
    public void update(Contact contact) {
        contactDAO.update(contact);
    }

    @Transactional
    public SessionFactory getSessionFactory(){
        return contactDAO.getSessionFactory();
    }

    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactDAO.findById(id);
    }
}
