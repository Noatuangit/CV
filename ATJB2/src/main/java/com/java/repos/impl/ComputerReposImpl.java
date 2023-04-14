package com.java.repos.impl;

import com.java.model.Computer;
import com.java.repos.IComputerRepos;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ComputerReposImpl implements IComputerRepos {
    private final Integer max_page = 5;
    private SessionFactory sessionFactory;

    public ComputerReposImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Computer> findAllByPositionAndStatus(String position, String status, Integer page) {
        String sql = "select c from Computer c where c.position like '%" + position + "%' and c.status like '%" + status
                + "%'";
        return sessionFactory.getCurrentSession().createQuery(sql, Computer.class).setFirstResult(page * max_page)
                .setMaxResults(max_page).getResultList();
    }

    @Override
    public void save(Computer computer) {
        sessionFactory.getCurrentSession().merge(computer);
    }

    @Override
    public long countQuery(String position, String status) {
        String sql = "select count(c) from Computer c where c.position  like '%" + position + "%' and c.status like '%"
                + status + "%'";
        return (long) Math
                .ceil(((float) ((long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult()) / max_page));
    }



    @Override
    public List<Computer> findAllByStatusNotWaiting() {
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Computer c where c.status not in ('off','waiting') ", Computer.class)
                .getResultList();
    }

    @Override
    public void updateStatusById(String status, String computer_id) {
        sessionFactory.getCurrentSession().createQuery("update Computer c set c.status = :status where c.id = :id")
                .setParameter("status", status).setParameter("id", computer_id).executeUpdate();
    }

}
