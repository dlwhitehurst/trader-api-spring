package com.dlwhitehurst.tradetx.repository.impl;

import com.dlwhitehurst.tradetx.model.Position;
import com.dlwhitehurst.tradetx.repository.PositionRepositoryCustom;
//import org.springframework.data.jpa.repository.Query;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PositionRepositoryCustomImpl implements PositionRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Position> findAllBySymbol(String symbol) {
        Query query = entityManager.createQuery("SELECT p FROM Position p WHERE p.posSymbol = :symbol");
        query.setParameter("symbol", symbol);
        return query.getResultList();
    }
}
