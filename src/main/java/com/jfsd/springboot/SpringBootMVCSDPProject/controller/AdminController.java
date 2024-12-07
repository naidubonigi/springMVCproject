package com.jfsd.springboot.SpringBootMVCSDPProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.springboot.SpringBootMVCSDPProject.model.Admin;
import com.jfsd.springboot.SpringBootMVCSDPProject.model.Customer;
import com.jfsd.springboot.SpringBootMVCSDPProject.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("adminlogin")
    public ModelAndView adminlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminlogin");
        return mv;
    }

    @GetMapping("adminhome")
    public ModelAndView adminhome() {
        ModelAndView mv = new ModelAndView("adminhome");
        
        long count = adminService.customercount();
        mv.addObject("count", count);
        return mv;
    }

    @PostMapping("checkadminlogin")
    public ModelAndView checkadminlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String auname = request.getParameter("auname");
        String apwd = request.getParameter("apwd");
        
        Admin admin = adminService.checkAdminLogin(auname, apwd);
        long count = adminService.customercount(); // Move this line outside the if-else block

        if (admin != null) {
            mv.setViewName("adminhome"); // login success
            mv.addObject("count", count); // Add count to model
        } else {
            mv.setViewName("adminloginfail");
            mv.addObject("message", "Login Failed");
            mv.addObject("count", count); // Add count to model even on failure
        }
        
        return mv;
    }

    @GetMapping("viewallcustomers")
    public ModelAndView viewallcustomers() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("viewallcustomers");
        
        long count = adminService.customercount();
        mv.addObject("count", count);
        
        List<Customer> customers = adminService.viewallCustomers();
        mv.addObject("customerslist", customers);
        return mv;
    }
}
