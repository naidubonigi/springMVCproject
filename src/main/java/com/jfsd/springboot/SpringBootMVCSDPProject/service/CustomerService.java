package com.jfsd.springboot.SpringBootMVCSDPProject.service;

import com.jfsd.springboot.SpringBootMVCSDPProject.model.Customer;
public interface CustomerService {
	public String customerRegistration(Customer customer);
	public Customer checkCustomerLogin(String email,String password);
}
