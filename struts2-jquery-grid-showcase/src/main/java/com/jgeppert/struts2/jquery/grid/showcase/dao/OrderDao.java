package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;

import jakarta.inject.Named;
import java.util.List;

@Named
public class OrderDao extends AbstractSimpleGenericDao<Order, Integer> {
    private static final Logger log = LogManager.getLogger(OrderDao.class);

    public List<Order> findByCriteria(CriteriaQuery<Order> criteriaQuery, int from, int size) {
        log.debug("Return orders from {} to {}", from, size);

        Session session = getCurrentSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Order> query = criteriaQuery != null ? criteriaQuery : criteriaBuilder.createQuery(Order.class);
            List<Order> results = session.createQuery(query)
            .setFirstResult(from)
            .setMaxResults(size)
            .getResultList();
            return results;
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int countByCriteria(CriteriaQuery<Long> criteriaQuery) {
        log.debug("Count orders");
        Session session = getCurrentSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = criteriaQuery != null ? criteriaQuery : criteriaBuilder.createQuery(Long.class);
            
            Root<Order> root = query.from(Order.class);
            query.select(criteriaBuilder.count(root));
            return session.createQuery(query).getSingleResult().intValue();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
