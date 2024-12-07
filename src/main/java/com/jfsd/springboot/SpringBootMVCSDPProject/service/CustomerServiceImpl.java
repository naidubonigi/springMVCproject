package com.jfsd.springboot.SpringBootMVCSDPProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jfsd.springboot.SpringBootMVCSDPProject.model.Customer;
import com.jfsd.springboot.SpringBootMVCSDPProject.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String customerRegistration(Customer customer) {
        customerRepository.save(customer); 
        return "Customer registered successfully!";
    }

	@Override
	public Customer checkCustomerLogin(String email, String password) {
		// TODO Auto-generated method stub
		return customerRepository.checkCustomerLogin(email, password);
	}


}
