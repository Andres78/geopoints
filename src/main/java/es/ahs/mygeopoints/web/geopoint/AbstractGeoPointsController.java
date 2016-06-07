package es.ahs.mygeopoints.web.geopoint;

import es.ahs.mygeopoints.model.GeoPoint;
import es.ahs.mygeopoints.service.GeoPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ahs on 30.05.16.
 */
public class AbstractGeoPointsController {

    private static final Logger log = LoggerFactory.getLogger(AbstractGeoPointsController.class);

    @Autowired
    private GeoPointService service;

    public GeoPoint getById(int id) {
        log.info("id {}", id);
        GeoPoint point = service.getById(id);
        log.info("point: {}", point.toString());
        return point;
    }

    public List<GeoPoint> getAll() {
        return service.getAll();
    }

    public GeoPoint create(GeoPoint point) {
        point.setId(null);
        return service.save(point);
    }

    public void update(GeoPoint point) {
        service.update(point);
    }

    public void delete(Integer id) {
        service.deleteById(id);
    }
}
