package com.aws.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aws.error.CustomerIdNotFoundException;
import com.aws.model.Address;
import com.aws.model.Customer;
import com.aws.model.RequestWrapper;
import com.aws.service.CustomerService;
//import com.aws.service.impl.CustomerServiceImpl;

@Controller
public class CustomerController  {
	
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -2820120827149225418L;
	@Autowired
	private CustomerService customerService;
	
	//mvc view
	@RequestMapping(value= "/getMVCCustomerById/{id}", method= {RequestMethod.GET})
	public String customerIndex(@PathVariable("id") int customerId)
	{
		ModelAndView model = new ModelAndView();
		model.addObject("customer",customerService.getCustomer(customerId));
		
		return "successpage";
	}
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	@ResponseBody
	@RequestMapping(value= "/getCustomerById/{id}", method= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	public Customer getCustomer( @PathVariable("id") int customerId) 
	{
		
		return customerService.getCustomer(customerId);
	}
	@RequestMapping(value= "/getCustomerById", method= {RequestMethod.POST, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	public Customer getCustomerPost( )
	{
		return customerService.getCustomer(1234);
	}
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	//public void addCustomer(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname)
	//public void addCustomer(@RequestBody ArrayList<Customer> customers)
	public void addCustomer(@RequestBody RequestWrapper requestWrappers)
	{
		//requestWrappers.getCustomers().stream().forEach();
		Address address = requestWrappers.getAddress();
		ArrayList<Customer> customers = requestWrappers.getCustomers();
		for(Customer customer: customers)
		{
		//Customer customer = new Customer();
		//customer.setFirstName(firstname);
		//customer.setLastName(lastname);
		
		customerService.addCustomer(customer);
		}
		
	}
	
	@RequestMapping(value="/deleteCustomerById/{customerId}", method = RequestMethod.GET)
	public void deleteCustomer(@PathVariable ("customerId") int customerId)
	{
		customerService.deleteCustomerById(customerId);
		
	}
}
