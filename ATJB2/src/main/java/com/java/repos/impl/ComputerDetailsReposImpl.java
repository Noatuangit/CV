package com.java.repos.impl;

import com.java.dto.ComDetailsDTO;
import com.java.model.ComputerDetails;
import com.java.repos.IComputerDetailsRepos;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ComputerDetailsReposImpl implements IComputerDetailsRepos {
	private SessionFactory sessionFactory;
	private final Integer max_page = 5;

	public ComputerDetailsReposImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ComputerDetails> findAll(Integer page) {
		return sessionFactory.getCurrentSession().createQuery("select c from ComputerDetails c", ComputerDetails.class)
				.setFirstResult(page * max_page).setMaxResults(max_page)
				.getResultList();
	}

	@Override
	public long countQuery() {
		String sql = "select count(c) from ComputerDetails c";
		return (long) Math
				.ceil(((float) ((long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult()) / max_page));
	}

	@Override
	public ComputerDetails save(ComputerDetails computerDetails) {
		sessionFactory.getCurrentSession().persist(computerDetails);
		return computerDetails;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void removeByCustomerId(String customer_id) {
		sessionFactory.getCurrentSession().createSQLQuery("delete from computer_detail  where customer_id = :cus_id")
				.setParameter("cus_id", customer_id).executeUpdate();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void removeByComputerID(String computer_id) {
		sessionFactory.getCurrentSession().createSQLQuery("delete from computer_detail  where computer_id = :com_id")
				.setParameter("com_id", computer_id).executeUpdate();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void remove(ComDetailsDTO computerDetails) {
		String sql = "delete from computer_detail where customer_id = :cus_id and computer_id = :com_id and date_begin = :date and  time_begin = :time ";
		sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("com_id", computerDetails.getComputer_id())
				.setParameter("cus_id", computerDetails.getCustomer_id())
				.setParameter("date", computerDetails.getDate_begin())
				.setParameter("time", computerDetails.getTime_begin()).executeUpdate();
	}

	@SuppressWarnings("deprecation")
	public List findAllServicePresent(Integer page) {
		String sql = "select cus.id customerId, cus.name customerName,com.id computerId,position,com.status,cd.date_begin dateComputer,cd.time_begin timeComputer,cd.time_use timeUseComputer ,s.name serviceName, sd.date_use dateService,sd.time_begin timeService,sd.amount, sd.amount* s.price total "
				+ "from computer_detail cd "
				+ "full join service_detail sd on sd.customer_id = cd.customer_id "
				+ "left join service s on s.id = sd.service_id "
				+ "left join computer com on com.id = cd.computer_id "
 				+ "left join customer cus on cus.id = sd.customer_id or cus.id = cd.customer_id "
				+ "order by cus.id" + " OFFSET "
				+ page * max_page + " ROWS " + "FETCH NEXT " + max_page + " ROWS ONLY ";
		return sessionFactory.getCurrentSession().createSQLQuery(sql).getResultList();
	}

	@SuppressWarnings("deprecation")
	@Override
	public int countTotalService() {
		String sql = "select count (*) from service_detail sd full join computer_detail cd on cd.customer_id = sd.customer_id ";
		return (int) sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult();
	}
}
