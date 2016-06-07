package es.ahs.mygeopoints.service;

import es.ahs.mygeopoints.model.GeoPoint;
import es.ahs.mygeopoints.repository.GeoPointRepository;
import es.ahs.mygeopoints.repository.jpa.GeoPointJpaRepositoryImpl;
import es.ahs.mygeopoints.repository.mock.GeoPointMockRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ahs on 30.05.16.
 */

@Service
public class GeoPointServiceImpl implements GeoPointService {
    private static final Logger log = LoggerFactory.getLogger(GeoPointServiceImpl.class);

    @Autowired
    private GeoPointRepository repository;

    public List<GeoPoint> getAll() {
        log.info("service getAll");
        return repository.getAll();
    }

    public GeoPoint getById(int id) {
        log.info("service get id: {}", id);
        return repository.get(id);

    }

    public boolean deleteById(Integer id) {
        log.info("service deleteById {}", id);
        return repository.deleteById(id);

    }

    public GeoPoint save(GeoPoint point) {
        log.info("service save {}", point);
        return repository.save(point);
    }

    @Override
    public GeoPoint update(GeoPoint point) {
        return repository.save(point);
    }
}
