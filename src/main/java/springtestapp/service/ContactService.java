package springtestapp.service;

import springtestapp.model.Contact;

import java.util.List;

/**
 * Created by Gvozd on 26.03.2016.
 */
public interface ContactService {

    public void save(Contact contact);

    public List<Contact> findAll();

    public List<Contact> findAllWithDetail();

    public Contact findById(Long id);

    public void delete(Long id);
}