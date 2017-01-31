package com.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.dao.CustomerDAO;
import com.hibernate.entity.Customer;

/*
 * Service is implementation of the Service Facade Design Pattern
 * Which helps us in choosing between different services of DAO factories implemented 
 * */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int Id) {
		return customerDAO.getCustomer(Id);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int Id) {
		customerDAO.deleteCustomer(Id);
	}

}
