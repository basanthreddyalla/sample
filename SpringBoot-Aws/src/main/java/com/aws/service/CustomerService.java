package com.aws.service;

import com.aws.model.Customer;

public interface CustomerService {
	
	public Customer getCustomer(int customerId);
	public void addCustomer(Customer customer);
	public void deleteCustomerById(int customerId);

}
