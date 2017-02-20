package com.aws.dao;

import com.aws.model.Customer;

public interface CustomerDao {

	public Customer getCustomer(int customerId);
	public void createCustomer(Customer customer);
	public void addCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	
	
}
