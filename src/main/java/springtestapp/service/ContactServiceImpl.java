package springtestapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springtestapp.dao.ContactDAO;
import springtestapp.model.Place;

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
    public void addPlace(Place place) {
        contactDAO.addPlace(place);
    }

    @Transactional
    public List<Place> listPlace() {
        return contactDAO.listPlace();
    }

    @Transactional
    public void removePlace(Integer id) {
        contactDAO.removePlace(id);
    }

    @Transactional
    public Place getPlace(Integer id) {
        logger.info("service impl - place traded to controller!");
        return contactDAO.getPlace(id);
    }
}
