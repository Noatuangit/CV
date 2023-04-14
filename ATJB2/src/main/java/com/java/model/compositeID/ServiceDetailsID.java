package com.java.model.compositeID;

import com.java.dto.ServiceBookingDTO;
import com.java.model.AddService;
import com.java.model.Customer;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Embeddable
public class ServiceDetailsID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne 
	@JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
	Customer customer;
 
	@ManyToOne 
	@JoinColumn(name = "service_id", nullable = false, referencedColumnName = "id")
	AddService service;

	Date date_use;
	Time time_begin;

	public ServiceDetailsID() {
	}

	public ServiceDetailsID(Customer customer, AddService service, Date date_use, Time time_begin) {
		this.customer = customer;
		this.service = service;
		this.date_use = date_use;
		this.time_begin = time_begin;
	}

	public ServiceDetailsID(ServiceBookingDTO serviceBookingDTO) {
		this.date_use = Date.valueOf(serviceBookingDTO.getDate_begin());
		this.time_begin = Time.valueOf(serviceBookingDTO.getTime_begin().concat(":00"));
		this.customer = new Customer(serviceBookingDTO.getCustomer_id());
		this.service = new AddService(serviceBookingDTO.getService_id());
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddService getService() {
		return service;
	}

	public void setService(AddService service) {
		this.service = service;
	}

	public Date getDate_use() {
		return date_use;
	}

	public void setDate_use(Date date_use) {
		this.date_use = date_use;
	}

	public Time getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(Time time_begin) {
		this.time_begin = time_begin;
	}
}
