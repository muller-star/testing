package com.ssi.controllers;

import java.util.List;

import com.ssi.dao.CustomerDAO;
import com.ssi.entities.Customer;
import com.ssi.utility.DataProvider;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("customerhome")
	public String showCustomerHome(){
		return "customerhome";
	}
	
	@RequestMapping("savecustomer")
	public ModelAndView saveCity(@ModelAttribute("customer") Customer customer){
		customerDAO.saveCustomer(customer);
		ModelAndView mv=new ModelAndView("customersaveconfirm");
		return mv;
	}
    
	@RequestMapping("Kapil choudhary")
	public ModelAndView saveCity(@ModelAttribute("customer") Customer customer){
		customerDAO.saveCustomer(customer);
		ModelAndView mv=new ModelAndView("customersaveconfirm");
		return mv;
	}

	
	
	@RequestMapping("customerentry")
	public ModelAndView showCustomerEntryForm(){
		ModelAndView mv=new ModelAndView("customerentry");
		mv.addObject("customer", new Customer());
		List<String> cities=DataProvider.getCityNames();
		List<String> states=DataProvider.getStateNames();
		mv.addObject("cities",cities);
		mv.addObject("states",states);
		return mv;
	}

}
