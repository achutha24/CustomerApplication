package com.mcafee.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcafee.customer.entity.Customer;
import com.mcafee.customer.exception.CustomerDataException;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findCustomerById(int custId) throws CustomerDataException;

}
