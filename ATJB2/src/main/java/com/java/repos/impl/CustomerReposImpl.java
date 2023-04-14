package com.java.repos.impl;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import com.java.model.Customer;
import com.java.repos.ICustomerRepos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerReposImpl implements ICustomerRepos {
    final int page_max = 5;
    SessionFactory sessionFactory;

    public CustomerReposImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> findAllByNameAndPhone(String name, String phone, String sort, Integer page) {
        String query = "select c from Customer c where c.name like '%" + name + "%' and c.phone like '%" + phone + "%' and c.status = 'on' order by " + sort;
//        String query = "select c from Customer c where c.name like '%" + name + "%' and c.phone like '%" + phone + "%' ORDER BY c.id OFFSET " + page + " ROWS fetch NEXT 2 ROWS ONLY ";
        return sessionFactory
                .getCurrentSession()
                .createQuery(query, Customer.class)
                .setFirstResult(page * page_max)
                .setMaxResults(page_max)
                .getResultList();
    }

    public void save(Customer customer) {
        sessionFactory.getCurrentSession().persist(customer);
    }

    @Override
    public long countQuery(String name, String phone) {
        String query = "select count(c) from Customer c where c.name like '%" + name + "%' and c.phone like '%" + phone + "%'";
        return (long) Math.ceil(((float) ((long) sessionFactory
                .getCurrentSession()
                .createQuery(query)
                .uniqueResult()) / page_max));
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from Customer c where c.email = :email order by c.id", Customer.class)
                .setParameter("email", email)
                .uniqueResultOptional();
    }

    @Override
    public List<Customer> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from Customer  c", Customer.class)
                .getResultList();
    }

    @Modifying
    @Override
    public void updateStatusById(String id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("update Customer c set c.status ='off' where c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Integer removeById(String id) {
        return sessionFactory.getCurrentSession()
                .createQuery("delete from Customer  c where  c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Customer findById(String id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select c from Customer c where c.id = :id", Customer.class)
                .setParameter("id", id)
                .uniqueResultOptional().orElse(null);
    }

    @Override
    public void edit(Customer customer) {
        sessionFactory.getCurrentSession().merge(customer);
    }
}
