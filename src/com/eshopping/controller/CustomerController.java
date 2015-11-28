package com.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshopping.jdbc.CustomerJDBC;
import com.eshopping.jdbc.ProductJDBC;
import com.eshopping.properties.CustomerAccessor;
import com.eshopping.properties.ProductAccessor;

@Controller
public class CustomerController {
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST, params = {"registerButton"})
	public ModelAndView registrationPage() {
		return new ModelAndView("registrationPage", "command", new CustomerAccessor());
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST, params = {"addCustomerButton"})
	public ModelAndView registerCustomer(@ModelAttribute("SpringWeb")CustomerAccessor customerAccessor, ModelMap modelMap) {
		try {
			CustomerJDBC customerJDBC = (CustomerJDBC)appContext.getBean("customerBeanJDBC");
			if(customerAccessor.getFirstname().isEmpty() && customerAccessor.getLastname().isEmpty() && 
				customerAccessor.getAddress().isEmpty() && customerAccessor.getContact().isEmpty() && 
				customerAccessor.getUsername().isEmpty() && customerAccessor.getPassword().isEmpty()) {
				modelMap.addAttribute("errorMessage", "please input all fields.");
			}
			customerJDBC.addCustomer(customerAccessor.getFirstname(), customerAccessor.getLastname(), customerAccessor.getAddress(), customerAccessor.getContact(), customerAccessor.getUsername(), customerAccessor.getPassword());
			customerJDBC.addCustomerRights(customerAccessor.getUsername(), customerAccessor.getPassword());
			modelMap.addAttribute("successMessage", "Successfully registered");
		} catch(Exception e) {
			modelMap.addAttribute("errorMessage", "Invalid input fields");
		}
		return new ModelAndView("registrationPage", "command", new CustomerAccessor());
	}
	@RequestMapping(value = {"/shopping"}, method = RequestMethod.GET, params = {"addToCart"})
	public ModelAndView addToCart(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "productid", required = false) int productid, 
			@RequestParam(value = "customer", required = false)String customer) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.insertProductsInCart(productAccessor.getProductbrand(), productAccessor.getProductname(), 
					productAccessor.getQuantity(),productAccessor.getProductprice());
			List<ProductAccessor> productlist = productJDBC.viewProducts();
			modelMap.addAttribute("customer", customer);
			//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
			ModelAndView model = new ModelAndView("eShoppingPage");
			model.addObject("productlist", productlist);
			modelMap.addAttribute("message", "product successfully added.");
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error occured during adding product.");
			return new ModelAndView("menuPage", "command", new ProductAccessor()); 
		}
		
	}
	
	//TODO goToCart
	@RequestMapping(value = {"/temporaryStorage"}, method = RequestMethod.GET, params = {"addToCart"})
	public ModelAndView goToCart(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "customer", required = false)String customer,
			@RequestParam(value = "productbrand", required = false)String productbrand,
			@RequestParam(value = "productname", required = false)String productname,
			@RequestParam(value = "quantity", required = false)int quantity,
			@RequestParam(value = "productprice", required = false)int productprice,
			@RequestParam(value = "productid", required = false)int productid) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.insertProductsInCart(productbrand, productname, 
					quantity,productprice);
			List<ProductAccessor> productlist = productJDBC.viewProducts();
			modelMap.addAttribute("customer", customer);
			modelMap.addAttribute("productid", productid);
			//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
			ModelAndView model = new ModelAndView("eShoppingPage");
			model.addObject("productlist", productlist);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error occured during adding product.");
			return new ModelAndView("menuPage", "command", new ProductAccessor()); 
		}
		
	}
	@RequestMapping(value = {"/goToCart"}, method = RequestMethod.GET, params = {"showCart"})
	public ModelAndView viewProductFromCart(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "customer", required = false)String customer) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			List<ProductAccessor> productlist = productJDBC.viewProductsCart();
			//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
			ModelAndView model = new ModelAndView("cartPage");
			model.addObject("productlist", productlist);
			model.addObject("customer", customer);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error occured during adding product.");
			return new ModelAndView("menuPage", "command", new ProductAccessor()); 
		}
		
	}
	
	@RequestMapping(value = {"/accessToUser"}, method = RequestMethod.GET, params = {"buyButton"})
	public ModelAndView buyProduct(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "customer", required = false)String customer,
			@RequestParam(value = "productid", required = false)int productid) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.insertProductsInOwn(productAccessor.getProductbrand(), productAccessor.getProductname(), 
					productAccessor.getQuantity(),productAccessor.getProductprice());
			productJDBC.deleteProductInCart(productid);
			List<ProductAccessor> productlistOwn = productJDBC.viewProductsOwn();
			modelMap.addAttribute("customer", customer);
			//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
			ModelAndView model = new ModelAndView("menuPage");
			model.addObject("productlistOwn", productlistOwn);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error occured during adding product.");
			return new ModelAndView("menuPage", "command", new ProductAccessor()); 
		}
		
	}
	
	@RequestMapping(value = {"/accessToUser"}, method = RequestMethod.GET, params = {"deleteFromCart"})
	public ModelAndView removeProductFromCart(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "customer", required = false)String customer,
			@RequestParam(value = "productid", required = false)int productid) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.insertProductsInOwn(productAccessor.getProductbrand(), productAccessor.getProductname(), 
					productAccessor.getQuantity(),productAccessor.getProductprice());
			productJDBC.deleteProductInCart(productid);
			List<ProductAccessor> productlist = productJDBC.viewProductsCart();
			modelMap.addAttribute("customer", customer);
			//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
			ModelAndView model = new ModelAndView("cartPage");
			model.addObject("productlist", productlist);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error occured during adding product.");
			return new ModelAndView("menuPage", "command", new ProductAccessor()); 
		}
		
	}
}
