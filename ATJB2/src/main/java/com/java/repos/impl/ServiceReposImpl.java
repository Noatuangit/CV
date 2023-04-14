package com.java.repos.impl;

import com.java.model.AddService;
import com.java.repos.IServiceRepos;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ServiceReposImpl implements IServiceRepos {
    Integer max_page = 5;
    SessionFactory sessionFactory;

    public ServiceReposImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List findAllByName(String name, Integer page) {
//        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
//        CriteriaQuery<AddService> cr = cb.createQuery(AddService.class);
//        Root<AddService> serviceRoot = cr.from(AddService.class);
//        cr.select(serviceRoot)
//                .where(cb.like(serviceRoot.get("name"), "%" + name + "%"))
//                .where(cb.equal(serviceRoot.get("status"),"on"))
//                .orderBy(cb.asc(serviceRoot.get("price")));
//        Query serviceQuery = sessionFactory.getCurrentSession().createQuery(cr);
//        return serviceQuery.setFirstResult(page * max_page).setMaxResults(max_page).getResultList();
        return sessionFactory.getCurrentSession().createCriteria(AddService.class)
                .add(Restrictions.like("name", "%" + name + "%"))
                .add(Restrictions.eq("status", "on"))
                .setFirstResult(page * max_page)
                .setMaxResults(max_page)
                .list();
    }

    @SuppressWarnings("deprecation")
    @Override
    public AddService findById(String id) {
//        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
//        CriteriaQuery<AddService> query = builder.createQuery(AddService.class);
//        Root<AddService> root = query.from(AddService.class);
//        query.where(builder.equal(root.get("id"), id));
//        Query serviceQuery = sessionFactory.getCurrentSession().createQuery(query);
//        return (AddService) serviceQuery.getSingleResult();
        return (AddService) sessionFactory.getCurrentSession()
                .createCriteria(AddService.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    @Transactional
    public void save(AddService addService) {
        sessionFactory.getCurrentSession().merge(addService);
    }

    @Override
    @Transactional
    public void removeById(String id) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaDelete<AddService> criteriaDelete = cb.createCriteriaDelete(AddService.class);
        Root<AddService> root = criteriaDelete.from(AddService.class);
        criteriaDelete.where(cb.equal(root.get("id"), id));
        sessionFactory.getCurrentSession().createQuery(criteriaDelete).executeUpdate();
        sessionFactory.getCurrentSession().remove(findById(id));
    }

    @Override
    public int countFindAllByName(String name) {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<AddService> cr = cb.createQuery(AddService.class);
        Root<AddService> serviceRoot = cr.from(AddService.class);
        cr.select(serviceRoot).where(cb.like(serviceRoot.get("name"), "%" + name + "%"));
        Query serviceQuery = sessionFactory.getCurrentSession().createQuery(cr);
        return (int) Math.ceil((float) serviceQuery.getResultList().size() / 5L);
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<AddService> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(AddService.class).list();
    }

    @Override
    public void updateById(String id) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaUpdate<AddService> update = cb.
                createCriteriaUpdate(AddService.class);
        Root<AddService> e = update.from(AddService.class);
        update.set("status", "off");
        update.where(cb.equal(e.get("id"), id));
        sessionFactory.getCurrentSession().createQuery(update).executeUpdate();
    }
}
