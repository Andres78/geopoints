package es.ahs.mygeopoints.model;

/**
 * Created by ahs on 30.05.16.
 */

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = GeoPoint.DELETE, query = "DELETE FROM GeoPoint p WHERE p.id=:id"),
        @NamedQuery(name = GeoPoint.BY_NAME, query = "SELECT p FROM GeoPoint p WHERE p.name=?1"),
        @NamedQuery(name = GeoPoint.BY_ID, query = "SELECT p FROM GeoPoint p WHERE p.id=?1"),
        @NamedQuery(name = GeoPoint.ALL_SORTED, query = "SELECT p FROM GeoPoint p")
})
@Entity
@Table(name = "points")
public class GeoPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int START_SEQ = 100000;

    public static final String ALL_SORTED = "GeoPoint.getAllSorted";
    public static final String DELETE = "GeoPoint.delete";
    public static final String BY_ID = "GeoPoint.get";
    public static final String BY_NAME = "GeoPoint.getByName";

    @Id
    @SequenceGenerator(name = "global_seq_points", sequenceName = "global_seq_points", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_points")
    protected Integer id;

    @Column
    protected String name;

    @Column
    protected String coords;


    public GeoPoint() {
    }

    public GeoPoint(String name, String coords) {
        this.name = name;
        this.coords = coords;
    }

    public GeoPoint(Integer id, String name, String coords) {
        this.id = id;
        this.name = name;
        this.coords = coords;
    }

    public GeoPoint(GeoPoint p) {
        this(p.getId(), p.getName(), p.getCoords());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coords='" + coords + '\'' +
                '}';
    }
}
