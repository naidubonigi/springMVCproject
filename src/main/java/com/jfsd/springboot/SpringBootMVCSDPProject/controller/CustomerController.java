package com.jfsd.springboot.SpringBootMVCSDPProject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.springboot.SpringBootMVCSDPProject.model.Customer;
import com.jfsd.springboot.SpringBootMVCSDPProject.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("customerreg")
    public ModelAndView customerreg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customerreg");
        return mv;
    }
    @GetMapping("customerprofile")
    public ModelAndView customerprofile() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customerprofile");
        return mv;
    }
    @GetMapping("customerhome")
    public ModelAndView customerhome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customerhome");
        return mv;
    }

    @PostMapping("/insertcustomer")
    public ModelAndView insertcustomer(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        
        // Retrieve data from HTML form fields
        String name = request.getParameter("cname");
        String gender = request.getParameter("cgender");
        String dobString = request.getParameter("cdob"); // Date of birth as a String
        String email = request.getParameter("cemail");
        String location = request.getParameter("clocation");
        String contact = request.getParameter("ccontact");
        String password = request.getParameter("cpassword"); // Ensure password is set

        // Parse date string to Date object
        Date dob = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust format if needed
            dob = sdf.parse(dobString);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle exception or display an error message
        }

        // Create Customer object and set attributes
        Customer customer = new Customer();
        customer.setName(name);
        customer.setGender(gender);
        customer.setDateofbirth(dob); // Set the Date object here
        customer.setEmail(email);
        customer.setLocation(location);
        customer.setContact(contact);
        customer.setPassword(password); // Ensure password is set

        // Register customer and set success message
        String message = customerService.customerRegistration(customer);

        mv.setViewName("regsuccess");
        mv.addObject("message", message);
        return mv;
    }

    @GetMapping("customerlogin")
    public ModelAndView customerlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customerlogin");
        return mv;
    }
    @GetMapping("customerlogout")
    public ModelAndView customerlogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customerlogin");
        return mv;
    }

    @PostMapping("checkcustomerlogin")
    public ModelAndView checkcustomerlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String cmail = request.getParameter("cemail");
        String apwd = request.getParameter("apwd"); // Ensure this matches the input name

        Customer customer = customerService.checkCustomerLogin(cmail, apwd);
        if (customer != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("customer", customer);
            mv.setViewName("customerhome"); // Redirect to customer home
        } else {
            mv.setViewName("customerlogin");
            mv.addObject("message", "Login Failed"); // Display the login failure message
        }
        return mv;
    }
}
