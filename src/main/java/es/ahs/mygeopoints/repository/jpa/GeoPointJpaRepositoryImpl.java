package es.ahs.mygeopoints.repository.jpa;

import es.ahs.mygeopoints.model.GeoPoint;
import es.ahs.mygeopoints.repository.GeoPointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * Created by ahs on 30.05.16.
 */

@Repository
@Transactional(readOnly = true)
public class GeoPointJpaRepositoryImpl implements GeoPointRepository {

    @PersistenceContext
    private EntityManager em;

    private static final Logger log = LoggerFactory.getLogger(GeoPointJpaRepositoryImpl.class);

    @Override
    @SuppressWarnings("unchecked")
    public List<GeoPoint> getAll() {
        log.info("repoJpaGetAll");
        List<GeoPoint> lgp = em.createNamedQuery(GeoPoint.ALL_SORTED, GeoPoint.class).getResultList();
        return lgp;
    }

    @Override
    public GeoPoint get(int id) {
        log.info("repository.get id: {}", id);
        return em.find(GeoPoint.class, id);
//        return em.createNamedQuery(GeoPoint.BY_ID, GeoPoint.class).setParameter(1, id).getSingleResult();
    }

    @Transactional
    @Override
    public boolean deleteById(int id) {
        log.info("repository.deleteById {}", id);
        GeoPoint geoPoint = get(id);
        if (null == geoPoint) return false;
        em.remove(geoPoint);
        return (get(id) == null);
    }

    @Transactional
    @Override
    public GeoPoint save(GeoPoint point) {
        log.info("repos save {}", point);
        if (point.isNew()) {
            log.info("save new");
            em.persist(point);
            return point;
        } else {
            log.info("update");
            return em.merge(point);
        }
    }
}
