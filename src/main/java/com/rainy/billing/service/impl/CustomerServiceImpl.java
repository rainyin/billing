package com.rainy.billing.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainy.billing.dao.CustomerDao;
import com.rainy.billing.entity.Customer;
import com.rainy.billing.model.CustomerVo;
import com.rainy.billing.service.CustomerService;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project: billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 * 
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void deleteCustomer(Long... id) {
		if (id != null && id.length == 1) {
			customerDao.deleteEntityById(id[0]);
		} else if(id != null){
			customerDao.deleteEntityBatch(id);
		} else {
			log.warn("delete customer by null id");
		}
		log.debug("delete customer success: id = " + id);
	}

	@Override
	public Customer getCustomerById(Long id) {
		if (id != null) {
			return customerDao.getEntityById(id);
		}
		log.warn("get customer by null id");
		return null;
	}

	@Override
	public List<Customer> queryCustomerByName(String name) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		
		return customerDao.queryEntity(param);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateEntity(customer);
		log.debug("update customer success: id=" + customer.getId());
	}

	@Override
	public void operateCustomer(Customer customer) {
		if(customer.getPager().isToUpdate()) {
			customerDao.updateEntity(customer);
			log.debug("update customer success: id=" + customer.getId());
		} else if(customer.getPager().isToCreate()){
			customerDao.createEntity(customer);
			log.debug("create customer success: id=" + customer.getId());
		} else {
			customerDao.deleteEntityById(customer.getId());
			log.debug("delete customer success: id=" + customer.getId());
		}
	}

	@Override
	public List<Customer> pageQueryCustomer(CustomerVo vo) {
		return customerDao.pageQueryEntity(vo);
	}
}
