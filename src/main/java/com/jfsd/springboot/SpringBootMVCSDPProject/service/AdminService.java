package com.jfsd.springboot.SpringBootMVCSDPProject.service;

import java.util.List;

import com.jfsd.springboot.SpringBootMVCSDPProject.model.Admin;
import com.jfsd.springboot.SpringBootMVCSDPProject.model.Customer;

public interface AdminService {
	public List<Customer> viewallCustomers();
	public Admin checkAdminLogin(String uname,String pwd);
	public long customercount();

}
