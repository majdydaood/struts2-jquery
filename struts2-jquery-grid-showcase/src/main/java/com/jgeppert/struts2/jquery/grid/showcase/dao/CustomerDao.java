package com.jgeppert.struts2.jquery.grid.showcase.dao;

import com.jgeppert.struts2.jquery.grid.showcase.model.Customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;

import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Named
public class CustomerDao extends AbstractSimpleGenericDao<Customer, Integer> {

    private static final Logger log = LogManager.getLogger(CustomerDao.class);

    public List<Customer> findByCriteria(CriteriaQuery<Customer> criteriaQuery, int from, int size) {
        log.debug("Return customers from {} to {}", from, size);

        Session session = getCurrentSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = criteriaQuery != null ? criteriaQuery : criteriaBuilder.createQuery(Customer.class);
            List<Customer> results = session.createQuery(query)
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
        if (log.isDebugEnabled()) log.debug("count Customers");

        Session session = getCurrentSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = criteriaQuery != null ? criteriaQuery : criteriaBuilder.createQuery(Long.class);
            
            Root<Customer> root = query.from(Customer.class);
            query.select(criteriaBuilder.count(root));
            return session.createQuery(query).getSingleResult().intValue();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public List<String> findCountrys() {
        if (log.isDebugEnabled()) log.debug("find all country's");
        Session session = getCurrentSession();
        try {
            String queryString = "SELECT DISTINCT c.country FROM CLASSICMODELS.CUSTOMERS c where c.country is not null";
            NativeQuery<String> q = session.createNativeQuery(queryString, String.class);
            q.setCacheable(true);
            return q.list();
        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public int nextCustomerNumber() {
        log.debug("find next customer number");
        Session session = getCurrentSession();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
            Root<Customer> root = criteriaQuery.from(Customer.class);
            criteriaQuery.select(criteriaBuilder.max(root.get("customernumber")));
            Integer maxCustomerNumber = session.createQuery(criteriaQuery).getSingleResult();

            return (maxCustomerNumber != null ? maxCustomerNumber + 1 : 1); // Handle case where no customers exist

        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
