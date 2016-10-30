package springtestapp.controller;

/**
 * Created by Gvozd on 29.03.2016.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springtestapp.service.ContactService;

import java.util.Map;

@Controller
public class MainController {
    final Log logger = LogFactory.getLog(getClass());

    public MainController() {
        logger.info("MainControllerLoaded");
    }

    @Autowired
    private ContactService contactService;

    @RequestMapping("/list")
    public String listPlaces(Map<String, Object> map) {
        map.put("placeList", contactService.listPlace());

        return "places";
    }

    @RequestMapping("/")
    public String homeSlash() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String home() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/adding")
    public String adding() {
        Place place = new Place();
        return "adding";
    }

    @RequestMapping(value = "/adding2Handler", method = RequestMethod.POST)
    public String addingPlace(@ModelAttribute("place") Place place,
                              BindingResult result) {

        contactService.addContact(place);

        return "redirect:/list";
    }

    @RequestMapping(value = "/select/{placeId}")
    public String selectPlace(@PathVariable("placeId") Integer placeId, Map<String, Object> map) {
        Place place = contactService.getPlace(placeId);
        logger.info(place.getPlacename() + " in maincontroller - loaded!");
        map.put("searchable", place);
        return "place";
    }

    @RequestMapping("/delete/{placeId}")
    public String deletePlace(@PathVariable("placeId") Integer placeId) {

        contactService.removePlace(placeId);

        return "redirect:/list";
    }
}