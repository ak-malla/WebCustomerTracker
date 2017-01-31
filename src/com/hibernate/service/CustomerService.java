package com.hibernate.service;

import java.util.List;

import com.hibernate.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int ID);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int Id);
}
