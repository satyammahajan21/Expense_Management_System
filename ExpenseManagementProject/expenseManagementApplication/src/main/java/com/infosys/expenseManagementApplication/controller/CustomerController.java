package com.infosys.expenseManagementApplication.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.expenseManagementApplication.bean.Customer;
import com.infosys.expenseManagementApplication.dao.CustomerDao;
import com.infosys.expenseManagementApplication.service.ExpenseUserService;

@RestController
@RequestMapping("/exp-mng/")
@CrossOrigin(origins = "http://localhost:5656")
public class CustomerController {
	

	    @Autowired
	    private CustomerDao customerDao;
	    @Autowired
	    private ExpenseUserService service;

	    @GetMapping("/customer")
	    public List<Customer> getAllCustomers() {
	        return customerDao.getAllCustomers();
	    }

	  
	    @GetMapping("/customer/{id}")
	    public Customer getCustomerById(@PathVariable String id) {
	        return customerDao.getCustomerById(id);
	    }

	    @PostMapping("/customer")
	    public void saveCustomer(@RequestBody Customer customer) {
	    	String username=service.getUserId();
	    	String email=service.getEmail();
	    	customer.setUsername(username);
	    	customer.setEmail(email);
	    	customer.setStatus("true");
	        customerDao.save(customer);
	    }
	    
	    @PutMapping("/customer")
	    public void updateCustomer(@RequestBody Customer customer) {
	    	customerDao.save(customer);
	    }


		@GetMapping("/customer-id")
	    public String generateCustomerId() {
	        return customerDao.generateCustomerId();
	    }

	    @GetMapping("/customer-other")
	    public List<Customer> getCurrentCustomers() {
	        return customerDao.getCurrentCustomers();
	    }
	    
	    
	    @GetMapping("/customer-status")
	    public String getCustomerStatusByUsername() {
	    	String username=service.getUserId();
	    	return customerDao.getCustomerStatusByUsername(username);
	    }
	    
	    @GetMapping("/customer-me")
	    public Customer getCustomerByUsername() {
	    	String username=service.getUserId();
	    	
	    	Customer c=customerDao.getCustomerByUsername(username);
	    	System.out.println(c);
	    	return c;
	    	
	    }
	}



