package com.jfsd.springboot.SpringBootMVCSDPProject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.springboot.SpringBootMVCSDPProject.model.Admin;
import com.jfsd.springboot.SpringBootMVCSDPProject.model.Customer;
import com.jfsd.springboot.SpringBootMVCSDPProject.repository.AdminRepository;
import com.jfsd.springboot.SpringBootMVCSDPProject.repository.CustomerRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public List<Customer> viewallCustomers() {
		return customerRepository.findAll();
	}
    // Implement methods from AdminService here

	@Override
	public Admin checkAdminLogin(String uname, String pwd) {
		// TODO Auto-generated method stub
		return adminRepository.checkAdminLogin(uname, pwd);
	}

	@Override
	public long customercount() {
		// TODO Auto-generated method stub
		return customerRepository.count();
	}
}
