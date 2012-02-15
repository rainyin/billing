package com.rainy.billing.service;

import java.util.List;

import com.rainy.billing.entity.Customer;
import com.rainy.billing.model.CustomerVo;

public interface CustomerService {
	
	Customer getCustomerById(Long id);
	
	void operateCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Long... id);
	
	List<Customer> queryCustomerByName(String name);
	
	List<Customer> pageQueryCustomer(CustomerVo vo);

}
