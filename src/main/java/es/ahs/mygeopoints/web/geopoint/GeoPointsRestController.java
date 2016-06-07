package es.ahs.mygeopoints.web.geopoint;

import es.ahs.mygeopoints.model.GeoPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ahs on 30.05.16.
 */
@RestController
@RequestMapping(value = "/rest/points", produces = MediaType.APPLICATION_JSON_VALUE)
public class GeoPointsRestController extends AbstractGeoPointsController {

    private static final Logger log = LoggerFactory.getLogger(GeoPointsAjaxController.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<GeoPoint> getAll() {
        return super.getAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GeoPoint get(int id) {
        return super.getById(id);
    }
}
