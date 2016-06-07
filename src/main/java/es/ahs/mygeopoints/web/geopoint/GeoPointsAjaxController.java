package es.ahs.mygeopoints.web.geopoint;

import es.ahs.mygeopoints.model.GeoPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


/**
 * Created by ahs on 30.05.16.
 */

@RestController
@RequestMapping(value = "/ajax/points")
public class GeoPointsAjaxController extends AbstractGeoPointsController {

    private static final Logger log = LoggerFactory.getLogger(GeoPointsAjaxController.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GeoPoint> getAll() {
        return super.getAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GeoPoint get(@PathVariable("id") int id) {
        log.info("get by id {}", id);
        return super.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> updateOrCreate(@Valid GeoPoint point, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("error", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (point.getId() == 0) {
            super.create(point);
        } else {
            log.info("update point {}", point.toString());
            super.update(point);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id) {
        super.delete(id);
    }


}
