package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int Id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);
}
