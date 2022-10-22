package com.codegym.repository.expenditures;

import com.codegym.model.Expenditures;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ExRepository implements IExRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Expenditures> findAll() {
        TypedQuery<Expenditures> query = em.createQuery("select e from Expenditures e", Expenditures.class);
        return query.getResultList();
    }

    @Override
    public Expenditures findById(Long id) {
        TypedQuery<Expenditures>query = em.createQuery("select e from Expenditures e where e.id =: id", Expenditures.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Expenditures expenditures) {
        if (expenditures.getId() != null) {
            em.merge(expenditures);
        } else {
            em.persist(expenditures);
        }
    }

    @Override
    public void remove(Long id) {
        Expenditures expenditures = findById(id);
        if (expenditures != null) {
            em.remove(expenditures);
        }
    }
}
