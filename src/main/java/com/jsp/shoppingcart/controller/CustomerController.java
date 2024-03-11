package com.jsp.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dto.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao cdao;
	
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {
		Customer c=new Customer();
		ModelAndView mav=new ModelAndView();
		mav.addObject("customerobj", c);
		mav.setViewName("customerform");
		return mav;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer c) {
		cdao.saveCustomer(c);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "Customer data saved successfully");
		mav.setViewName("customermenu");
		return mav;
	}
	
	@RequestMapping("/customerloginvalidation")
	public ModelAndView loginValidation(ServletRequest request, HttpSession session) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Customer customer=cdao.login(email, password);
		ModelAndView mav=new ModelAndView();
		if(customer!=null) {
			mav.addObject("msg", "Customer LogIn Successful");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo", customer);
			return mav;
		}else {
			mav.addObject("mesg", "Invalid Credentials...Please Try again!");
			mav.setViewName("customerloginform");
			return mav;
		}
	}
}
