package com.aws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.dao.CustomerDao;
import com.aws.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	public Customer getCustomer(int customerId) {
		
		return customerDao.getCustomer(customerId);
	}
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public void deleteCustomerById(int customerId) {
		customerDao.deleteCustomer(customerId);
		
	}

}
