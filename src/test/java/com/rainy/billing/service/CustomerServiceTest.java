package com.rainy.billing.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rainy.billing.entity.Customer;
import com.rainy.billing.model.CustomerVo;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public class CustomerServiceTest extends AbstractServiceTest {
	
	@Autowired
	private CustomerService customerService;
	
	private Customer createCustomer(){
		Customer customer = new Customer();
		customer.setName("test");
		
		customerService.operateCustomer(customer);
		return customer;
	}
	
	@Test
	public void testGetCustomerById(){
		Customer customer = customerService.getCustomerById(createCustomer().getId());
		
		print("testGetCustomerById: customer=" + customer);
	}
	
	@Test
	public void testCreateCustomer(){
		Customer customer = createCustomer();
		
		print("testCreateCustomer: customer=" + customer);
	}
	
	@Test
	public void testUpdateCustomer(){
		Customer customer = createCustomer();
		customer.setTel("122121");
		customerService.updateCustomer(customer);
		
		print("testUpdateCustomer: customer=" + customer);
	}
	
	@Test
	public void testDeleteCustomer(){
		Customer customer = createCustomer();
		customerService.deleteCustomer(customer.getId());
		
		print("testDeleteCustomer: id=" + customer.getId());
	}
	
	@Test
	public void testQueryCustomerByName(){
		Customer customer = createCustomer();
		List<Customer> list = customerService.queryCustomerByName(customer.getName());
		
		print("testQueryCustomerByName: size=" + list.size());
	}
	
	@Test
	public void testPageQueryCustomer(){
		CustomerVo vo = new CustomerVo();
		vo.setName(createCustomer().getName());
		List<Customer> list = customerService.pageQueryCustomer(vo);
		
		print("testPageQueryCustomer: size=" + list.size());
	}
}
