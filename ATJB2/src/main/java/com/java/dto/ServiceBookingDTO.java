package com.java.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class ServiceBookingDTO implements Validator {

	String customer_id;

	String service_id;

	String date_begin;

	String time_begin;

	String amount;

	public ServiceBookingDTO() {
	}

	public ServiceBookingDTO(String customer_id, String service_id, String date_begin, String time_begin,
			String amount) {
		this.customer_id = customer_id;
		this.service_id = service_id;
		this.date_begin = date_begin;
		this.time_begin = time_begin;
		this.amount = amount;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getDate_begin() {
		return date_begin;
	}

	public void setDate_begin(String date_begin) {
		this.date_begin = date_begin;
	}

	public String getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(String time_begin) {
		this.time_begin = time_begin;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public String toString() {
		return "ServiceBookingDTO{" + "computer_id='" + customer_id + '\'' + ", service_id='" + service_id + '\''
				+ ", date_begin='" + date_begin + '\'' + ", time_begin='" + time_begin + '\'' + ", amount='" + amount
				+ '\'' + '}';
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer_id", "customer_id", " not null");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "service_id", "service_id", " not null");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date_begin", "date_begin", " not null");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "time_begin", "time_begin", " not null");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "amount", " not null");
		ServiceBookingDTO dto = (ServiceBookingDTO) target;
		if (!"".equals(dto.getDate_begin()) && LocalDate.parse(dto.getDate_begin()).isBefore(LocalDate.now())) {
			errors.rejectValue("date_begin", "date_begin", " not is past.");
		}
		if (!"".equals(dto.getAmount()) && Integer.parseInt(dto.amount) < 1) {
			errors.rejectValue("amount", "amount", " must bigger 1.");
		}
	}
}
