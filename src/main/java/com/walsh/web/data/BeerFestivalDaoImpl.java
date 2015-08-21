package com.walsh.web.data;

import com.walsh.web.model.Beer;
import com.walsh.web.model.BeerFestival;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hibernate implementation of {@link com.walsh.web.data.BeerFestivalDao}
 */
@Repository
public class BeerFestivalDaoImpl implements BeerFestivalDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public BeerFestival getFestival(Long id) {
        return em.find(BeerFestival.class, id);
    }

    @Transactional
    @Override
    public List<BeerFestival> getAllFestivals() {
        TypedQuery<BeerFestival> query = em.createQuery("from BeerFestival", BeerFestival.class);
        return query.getResultList();
    }

}
