package com.aws.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aws.error.CustomerIdNotFoundException;
import com.aws.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	/*@PersistenceContext
	  private EntityManager entityManager;
	*/
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public Customer getCustomer(int customerId) {
		
		
		Session session =  sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer  = session.get(Customer.class, customerId);
		if(null == customer)
		{
			try {
				throw new CustomerIdNotFoundException("Id not found from dao");
			} catch (CustomerIdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customer;
	}

	
	public void createCustomer(Customer customer) {
		
		
	}

	
	@Transactional
	public void addCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
		
		
	}

	
	@Transactional
	public void deleteCustomer(int customerId) {
		Session session =  sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
		tx.commit();
		
	}

}
