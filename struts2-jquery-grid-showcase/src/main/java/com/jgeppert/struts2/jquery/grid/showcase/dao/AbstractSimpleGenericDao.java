package com.jgeppert.struts2.jquery.grid.showcase.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractSimpleGenericDao<C, I extends Serializable> {

    private static final Logger log = LogManager.getLogger(AbstractSimpleGenericDao.class);

    @Inject
    protected SessionFactory sessionFactory;

    Class<C> entityClass;

    {
        entityClass = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<C> getAll() {
        try {
            Session session = getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            
            // Create a CriteriaQuery for the entity class
            CriteriaQuery<C> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            Root<C> root = criteriaQuery.from(entityClass);
            
            // Select all entities
            criteriaQuery.select(root);
            
            // Execute the query
            return session.createQuery(criteriaQuery).getResultList();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public C get(I id) {
        try {
            return (C) getCurrentSession().get(entityClass, id);
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Transactional
    public void save(C object) {
        try {
            getCurrentSession().saveOrUpdate(object);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    @Transactional
    public void update(C object) {
        try {
            getCurrentSession().update(object);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }

    @Transactional
    public void delete(I id) {
        try {
            C actual = get(id);
            getCurrentSession().delete(actual);
        } catch (RuntimeException e) {
            log.error("Be sure your Database is in read-write mode!");
            throw e;
        }
    }
}
