package com.mcafee.customer.service;

import com.mcafee.customer.entity.Customer;
import com.mcafee.customer.exception.CustomerServiceException;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer) throws CustomerServiceException;
	
	public boolean updateRank(int custId, int rank) throws CustomerServiceException;

}
