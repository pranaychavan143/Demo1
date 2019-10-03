package com.pranay.RestFullApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranay.RestFullApi.model.Customer;
import com.pranay.RestFullApi.repository.CustomerDAO;

@Service
public class CustomerService {
    @Autowired
	private CustomerDAO customerDAO;

	public void save(Customer customer) {
		customerDAO.save(customer);
	}
	
	public List<Customer> findAll()
	{
		return customerDAO.findAll();
		
	}
	
	public Customer findById(Long id)
	{
		return customerDAO.getOne(id);
	}
	
	public void updateNameById(Long id)
	{
		 customerDAO.getOne(id);
		
	}
	
}
