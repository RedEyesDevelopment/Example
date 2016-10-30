package springtestapp.dao;

import springtestapp.model.Contact;

import java.util.List;

/**
 * Created by Gvozd on 26.03.2016.
 */
public interface ContactDAO {

    public void save(Contact contact);

    public List<Contact> findAll();

    public List<Contact> findAllWithDetail();

    public Contact findById(Long id);

    public void delete(Integer id);
}