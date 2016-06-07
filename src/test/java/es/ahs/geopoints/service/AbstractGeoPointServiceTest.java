package es.ahs.geopoints.service;

import es.ahs.geopoints.GeoPointTestData;
import es.ahs.mygeopoints.model.GeoPoint;
import es.ahs.mygeopoints.service.GeoPointService;
import es.ahs.mygeopoints.service.GeoPointServiceImpl;
import es.ahs.mygeopoints.util.exception.NotFoundException;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collections;

import static es.ahs.geopoints.GeoPointTestData.*;

/**
 * Created by ahs on 30.05.16.
 */
public class AbstractGeoPointServiceTest extends AbstractServiceTest {

    protected static GeoPointService service = new GeoPointServiceImpl();

    @Test
    public void testSave() throws Exception {
        GeoPoint t1 = GeoPointTestData.POINT_ONE;
        t1.setId(null);
        GeoPoint t2 = GeoPointTestData.POINT_TWO;
        t2.setId(null);
        service.save(t1);
        service.save(t2);
        GeoPointTestData.TestPoint tp = new TestPoint(null, "save_point", "77.777, 77.777");
        GeoPoint created = service.save(tp.asGeoPoint());
        tp.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(GeoPointTestData.POINT_ONE, tp, GeoPointTestData.POINT_TWO), service.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.deleteById(1);
    }
}
