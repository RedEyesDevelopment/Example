package springapp.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springapp.model.Place;

import java.util.List;

/**
 * Created by Gvozd on 26.03.2016.
 */
@Repository
public class PlaceDAOImpl implements PlaceDAO {
    final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    public PlaceDAOImpl() {

    }

    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    @SuppressWarnings("unchecked")
    public List<Place> listPlace() {
        return sessionFactory.getCurrentSession().createQuery("from Place").list();
    }

    public void removePlace(Integer id) {
        Place place = (Place) sessionFactory.getCurrentSession().load(
                Place.class, id);
        if (null != place) {
            sessionFactory.getCurrentSession().delete(place);
        }
    }

    public Place getPlace(Integer id) {
        Place resultplace = new Place();
        try {
            resultplace = (Place) sessionFactory.getCurrentSession().load(Place.class, id);
        } catch (Exception e) {
            resultplace = null;
        }
        logger.info(resultplace.getPlacename() + " in DAO - loaded!");
        return resultplace;
    }
}