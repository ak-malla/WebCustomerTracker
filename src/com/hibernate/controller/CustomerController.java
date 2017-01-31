package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hibernate.entity.Customer;
import com.hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	/*
	 * @GetMapping and @PostMapping are two newly introduced annotations,
	 * instead of
	 * 
	 * @RequestMapping("/list" , method = RequestMethod.GET), the later has
	 * support for consume attribute e.g., consume = "text/plain" ,etc.,
	 */
	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		List<Customer> list = service.getCustomers();

		theModel.addAttribute("customers", list);

		return "listCustomers";
	}

	@GetMapping("/showFormForAdd")
	public String listCustomers(Model model) {

		Customer customer = new Customer();

		model.addAttribute(customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		service.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String getCustomer(@RequestParam("customerID") int Id, Model theModel) {

		Customer customer = service.getCustomer(Id);

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {

		service.updateCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForDelete")
	public String deleteCustomer(@RequestParam("customerID") int Id) {

		service.deleteCustomer(Id);

		return "redirect:/customer/list";
	}

}
