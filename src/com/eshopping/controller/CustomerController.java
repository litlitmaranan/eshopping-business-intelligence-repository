package com.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eshopping.jdbc.CustomerJDBC;
import com.eshopping.jdbc.ProductJDBC;
import com.eshopping.properties.CustomerAccessor;
import com.eshopping.properties.ProductAccessor;

@Controller
public class CustomerController {
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST, params = {"addCustomerButton"})
	public ModelAndView registerCustomer(@ModelAttribute("SpringWeb")CustomerAccessor accessor, ModelMap modelMap) {
		try {
			CustomerJDBC customerJDBC = (CustomerJDBC)appContext.getBean("customerBeanJDBC");
			customerJDBC.addCustomer(accessor.getFirstname(), accessor.getLastname(), accessor.getAddress(), accessor.getContact(), accessor.getUsername(), accessor.getPassword());
			//modelMap.addAttribute("successMessage", "Successfully registered");
			return new ModelAndView("registrationPage", "command", new CustomerAccessor());
			
		} catch(Exception e) {
			//modelMap.addAttribute("errorMessage", "Invalid fields.. please complete.");
			return new ModelAndView("loginPage", "command", new CustomerAccessor());
		}
		
	}
	
	@RequestMapping(value = {"/performInventory"}, method = RequestMethod.GET, params = {"viewAll"})
	public ModelAndView viewProducts(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap) {
		ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("inventoryJDBC");
		List<ProductAccessor> productlist = productJDBC.viewProducts();
		
		ModelAndView model = new ModelAndView("viewItems");
		model.addObject("productlist", productlist);
		return model;
	}
	
}
