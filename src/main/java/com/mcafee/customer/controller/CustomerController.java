package com.mcafee.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcafee.customer.entity.Customer;
import com.mcafee.customer.exception.CustomerServiceException;
import com.mcafee.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	/*
	 * This API is used to create a customer
	 */
	@PostMapping("/customer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		ResponseEntity<String> response = null;
		try {
			Customer cust = service.createCustomer(customer);
			response = new ResponseEntity<String>("Customer created with ID : "+ cust.getId(), HttpStatus.CREATED);
		} catch(Exception ex) {
			response = new ResponseEntity<String>("Exception while creating Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	/*
	 * This API is used to update rank
	 */
	@PostMapping("/customer/{customerId}/{rank}")
	public ResponseEntity<String> updateRank(@PathVariable int customerId, @PathVariable int rank){
		ResponseEntity<String> response = null;
		try {
			boolean updated = service.updateRank(customerId, rank);
			if(updated)
				response = new ResponseEntity<String>("Customer updated with rank successfully ", HttpStatus.OK);
		} catch(CustomerServiceException ex) {
			response = new ResponseEntity<String>("Exception while updating Customer", HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
