package es.ahs.geopoints;

import es.ahs.geopoints.matcher.ModelMatcher;
import es.ahs.mygeopoints.model.GeoPoint;

import java.util.Objects;

import static es.ahs.mygeopoints.model.GeoPoint.START_SEQ;

/**
 * Created by ahs on 30.05.16.
 */
public class GeoPointTestData {

    public static final int FIRST_REC = START_SEQ;
    public static final int SECOND_REC = START_SEQ + 1;

    public static final GeoPoint POINT_ONE = new GeoPoint(FIRST_REC, "point_one", "1.111, 1.111");
    public static final GeoPoint POINT_TWO = new GeoPoint(SECOND_REC, "poiint_two", "22.222, 22.222");

    public static final ModelMatcher<GeoPoint, TestPoint> MATCHER = new ModelMatcher<>(p -> ((p instanceof TestPoint) ? (TestPoint) p : new TestPoint(p)), GeoPoint.class);

    public static class TestPoint extends GeoPoint {
        public TestPoint(GeoPoint p) {
            this(p.getId(), p.getName(), p.getCoords());
        }

        public TestPoint(String name, String coord) {
            this(null, name, coord);
        }

        public TestPoint(Integer id, String name, String coord) {
            super(id, name, coord);
        }

        public GeoPoint asGeoPoint() {
            return new GeoPoint(this);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TestPoint that = (TestPoint) o;
            return Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.coords, that.coords);
        }
    }
}
