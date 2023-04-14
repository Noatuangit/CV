package com.java.repos.impl;

import com.java.model.ServiceDetails;
import com.java.repos.IServiceDetailsRepos;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ServiceDetailsReposImpl implements IServiceDetailsRepos {
    private final int max_page = 5;

    private SessionFactory sessionFactory;

    public ServiceDetailsReposImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ServiceDetails> findAll(Integer page) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select s from ServiceDetails s", ServiceDetails.class)
                .setFirstResult(page * max_page)
                .setMaxResults(max_page)
                .getResultList();
    }

    @Override
    public long countQuery() {
        String sql = "select count(c) from ServiceDetails c";
        return (long) Math.ceil(((float) ((long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult()) / max_page));
    }

    @Override
    public ServiceDetails save(ServiceDetails serviceDetails) {
        sessionFactory.getCurrentSession().persist(serviceDetails);
        return serviceDetails;
    }

    @SuppressWarnings("deprecation")
	public void removeByCustomerId(String id) {
        sessionFactory.getCurrentSession()
                .createSQLQuery("delete from service_detail where customer_id = :param")
                .setParameter("param", id)
                .executeUpdate();
    }

    @SuppressWarnings("deprecation")
	public void removeByServiceId(String id) {
        sessionFactory.getCurrentSession()
                .createSQLQuery("delete from service_detail where service_id = :param")
                .setParameter("param", id)
                .executeUpdate();
    }
}
