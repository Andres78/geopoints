package es.ahs.mygeopoints.service;

import es.ahs.mygeopoints.model.GeoPoint;

import java.util.List;

/**
 * Created by ahs on 30.05.16.
 */
public interface GeoPointService {
    List<GeoPoint> getAll();

    GeoPoint getById(int id);

    boolean deleteById(Integer id);

    GeoPoint save(GeoPoint point);

    GeoPoint update(GeoPoint point);
}
