package es.ahs.mygeopoints.repository;

import es.ahs.mygeopoints.model.GeoPoint;

import java.util.List;

/**
 * Created by ahs on 30.05.16.
 */
public interface GeoPointRepository {
    List<GeoPoint> getAll();

    GeoPoint get(int id);

    boolean deleteById(int id);

    GeoPoint save(GeoPoint point);

}
