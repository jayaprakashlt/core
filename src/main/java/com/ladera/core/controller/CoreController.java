package com.ladera.core.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.core.configurations.CustomerData;
import com.ladera.core.configurations.PropsConfigs;

@RestController
@RefreshScope
public class CoreController {

	@Value("${custom.data.value}")
	public String msg;

	@Autowired
	private CustomerData customer;

	@GetMapping("/get")
	public String getMsg() {
		return msg;

	}

	@GetMapping("/get-customer")
	public CustomerData getCustomer() {
		CustomerData customerData = new CustomerData();
		
		BeanUtils.copyProperties(customer, customerData);
		return customerData;
	}

}
