package com.mcafee.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcafee.customer.entity.Customer;
import com.mcafee.customer.exception.CustomerDataException;
import com.mcafee.customer.exception.CustomerServiceException;
import com.mcafee.customer.repository.CustomerRepository;
import com.mcafee.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerServiceException {
		Customer cust = null;
		try {
			cust = repository.save(customer);
			
		} catch(Exception ex) {
			throw new CustomerServiceException("Customer creation exception ", 100);
		}
		return cust;
	}

	@Override
	public boolean updateRank(int custId, int rank) throws CustomerServiceException {
		Customer cust = null;
		boolean update = false;
		try {
			cust = repository.findCustomerById(custId);
			cust.setRank(rank);
			repository.save(cust);
			update = true;
		} catch (CustomerDataException ex) {
			throw new CustomerServiceException("Customer Not found with id " + custId, 404);
		}
		return update;
	}

}
