package es.ahs.mygeopoints.repository.mock;

import es.ahs.mygeopoints.model.GeoPoint;
import es.ahs.mygeopoints.repository.GeoPointRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahs on 30.05.16.
 */
public class GeoPointMockRepositoryImpl implements GeoPointRepository {
    private static List<GeoPoint> points;
    private static int count = 0;

    static {
        points = new ArrayList<GeoPoint>();
        points.add(new GeoPoint(0, "tag-0", "(-33.8674869, 151.20699020000006)"));
        points.add(new GeoPoint(1, "tag-1", "(-33.8674869, 151.20699020000006)"));
        points.add(new GeoPoint(2, "spb-2", "(59.9342802, 30.335098600000038)"));
        points.add(new GeoPoint(3, "ifz-3", "(59.8773449, 30.441864200000055)"));
        points.add(new GeoPoint(4, "casa-4", "(59.943233, 30.501555999999937)"));
    }


    public List<GeoPoint> getAll() {
        return points;
    }

    public GeoPoint get(int id) {
        for (GeoPoint point : points) {
            if (point.getId() == id) {
                return point;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        for (GeoPoint point : points) {
            if (point.getId() == id) {
                return points.remove(point);
            }
        }
        return false;
    }

    public boolean update(GeoPoint point) {
        for (GeoPoint temp : points) {
            if (temp.getId() == point.getId()) {
                temp.setName(point.getName());
                temp.setCoords(point.getCoords());
                return true;
            }
        }
        return false;
    }

    public GeoPoint save(GeoPoint point) {
        point.setId(count++);
        if (points.add(point)) return point;
        else return null;
    }
}
