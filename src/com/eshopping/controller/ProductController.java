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

import com.eshopping.jdbc.ProductJDBC;
import com.eshopping.properties.ProductAccessor;

@Controller
public class ProductController {

	@Autowired
	private ApplicationContext appContext;

	@RequestMapping(value = {"/guestPrivileges"}, method = RequestMethod.GET, params = {"logOutPageGuest"})
	public ModelAndView backToMenuGuest(ModelMap modelMap, @RequestParam(value = "guest", required = false)String guest) {
		modelMap.addAttribute("guest", guest);
		return new ModelAndView("menuPage", "command", new ProductAccessor());
	}
	
	// TODO
	@RequestMapping(value = {"/backToMenuShop"}, method = RequestMethod.GET, params = {"backPageShop"})
	public ModelAndView backToMenuShop(ModelMap modelMap, @RequestParam(value = "admin", required = false)String admin) {
		modelMap.addAttribute("admin", admin);
		return new ModelAndView("menuPage", "command", new ProductAccessor());
	}
	
	@RequestMapping(value = {"/backToMenuAdmin"}, method = RequestMethod.GET, params = {"backPageAdmin"})
	public ModelAndView backToMenuAdmin(ModelMap modelMap, @RequestParam(value = "admin", required = false)String admin) {
		modelMap.addAttribute("admin", admin);
		return new ModelAndView("menuPage", "command", new ProductAccessor());
	}
	
	// TODO backToMenuCustomer
	@RequestMapping(value = {"/backToMenuCustomer"}, method = RequestMethod.GET, params = {"backPageCustomer"})
	public ModelAndView backToMenuCustomer(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "customer", required = false)String customer) {
		ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
		List<ProductAccessor> productlist = productJDBC.viewProducts();
		modelMap.addAttribute("customer", customer);
		//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
		ModelAndView model = new ModelAndView("eShoppingPage");
		model.addObject("productlist", productlist);
		return model;
	}
	
	@RequestMapping(value = {"/addNewProducts"}, method = RequestMethod.GET, params = {"previousPage"})
	public ModelAndView previousPage(ModelMap modelMap, @RequestParam(value = "admin", required = false)String admin) {
		modelMap.addAttribute("admin", admin);
		return new ModelAndView("menuPage", "command", new ProductAccessor());
	}
	
	@RequestMapping(value = {"/addNewProducts"}, method = RequestMethod.GET, params = {"addProducts"})
	public ModelAndView addProduct(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap){
		try {
			if(productAccessor.getProductbrand().isEmpty() && productAccessor.getProductname().isEmpty()){
				modelMap.addAttribute("errorMessage", "Invalid input fields input again.");
			} else {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.insertProducts(productAccessor.getProductbrand(), productAccessor.getProductname(), 
					productAccessor.getQuantity(),productAccessor.getProductprice());
			modelMap.addAttribute("successMessage", "Successfully registered");
			}
		} catch(Exception e) {
			modelMap.addAttribute("errorMessage", "Invalid input fields");
		}
		return new ModelAndView("addProductPage", "command", new ProductAccessor()); 
	}
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"addProduct"})
	public ModelAndView toAddProductPage() {
		return new ModelAndView("addProductPage", "command", new ProductAccessor());
	}
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"viewAllProductAdmin"})
	public ModelAndView viewProducts(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "admin", required = false)String admin) {
		ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
		List<ProductAccessor> productlist = productJDBC.viewProducts();
		//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
		ModelAndView model = new ModelAndView("adminPage");
		model.addObject("productlist", productlist);
		model.addObject("admin", admin);
		return model;
	}
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"viewAllProductCustomer"})
	public ModelAndView viewProductsCustomer(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "customer", required = false)String customer) {
		ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
		List<ProductAccessor> productlist = productJDBC.viewProducts();
		modelMap.addAttribute("customer", customer);
		//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
		ModelAndView model = new ModelAndView("eShoppingPage");
		model.addObject("productlist", productlist);
		return model;
	}
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"viewAllProduct"})
	public ModelAndView guestViewProducts(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "guest", required = false)String guest) {
		ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
		List<ProductAccessor> productlist = productJDBC.viewProducts();
		modelMap.addAttribute("guest", guest);
		//ModelAndView model = new ModelAndView("adminPage", "command", new ProductAccessor());
		ModelAndView model = new ModelAndView("guestViewProducts");
		model.addObject("productlist", productlist);
		return model;
	}

	// TODO transactions logOut
	
	@RequestMapping(value = {"/adminRights"}, method = RequestMethod.GET, params = {"updateProduct"})
	public ModelAndView toUpdateProducts(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "productid", required = false) int productid) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.getProductForUpdate(productid);
			productAccessor.setProductid(productid);
			productAccessor.setProductbrand("");
			productAccessor.setProductname("");
			productAccessor.setQuantity(0);
			productAccessor.setProductprice(0);
			ProductAccessor productSelect = productJDBC.getProductForUpdate(productid);
			modelMap.addAttribute("productid", productid);
			modelMap.addAttribute("message", "Inventory found");
			return new ModelAndView("updateProductPage", "command", productSelect);
		} catch(Exception e) {
			modelMap.addAttribute("message", "error......");
			return new ModelAndView("updateProductPage", "command", productAccessor);
		}
	}
	
	@RequestMapping(value = {"/editProducts"}, method = RequestMethod.GET, params = {"updateProducts"})
	public ModelAndView updateItem(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "productid", required = false) int productid) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.updateProducts(productid, productAccessor.getProductbrand(), 
					productAccessor.getProductname(), productAccessor.getQuantity(), 
					productAccessor.getProductprice());
			modelMap.addAttribute("message", "Updated sucessfully.");
			List<ProductAccessor> productlist = productJDBC.viewProducts();
			ModelAndView model = new ModelAndView("adminPage");
			model.addObject("productlist", productlist);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "error......");
			return new ModelAndView("updateProductPage", "command", productAccessor);
		}
		
	}
	
	@RequestMapping(value = {"/adminRights"}, method = RequestMethod.GET, params = {"deleteProduct"})
	public ModelAndView deleteItem(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, 
			@RequestParam(value = "productid", required = false) int productid, @RequestParam(value = "guest", required = false)String guest) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.deleteProduct(productid);
			modelMap.addAttribute("message", "Delete successfully..");
			List<ProductAccessor> productlist = productJDBC.viewProducts();
			ModelAndView model = new ModelAndView("adminPage");
			modelMap.addAttribute("guest", guest);
			model.addObject("productlist", productlist);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error in deleting");
			return new ModelAndView("toUpdatePage", "command", productAccessor);
		}
		
	}
}
