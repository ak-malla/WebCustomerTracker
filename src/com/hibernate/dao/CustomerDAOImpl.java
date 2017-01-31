package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Injecting the Session Factory from xml file
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// @Transactional Commented this out since the implementation is given in
	// Service layer
	// This Annotation helps with no creation of
	// begingTransaction and Committing a transaction
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> list = theQuery.getResultList();

		return list;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int Id) {

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, Id);

		return customer;

	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();

		// Remember the Hidden field in the customer-form JSP, this below line
		// will only work in the presence of that hidden id filed if not the
		// below line will simply save a new object which will create a new
		// entry with new Id
		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where ID=:customerID");

		query.setParameter("customerID", id);

		query.executeUpdate();
	}

}
