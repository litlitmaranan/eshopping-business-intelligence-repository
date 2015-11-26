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
	
	@RequestMapping(value = {"/shopping"}, method = RequestMethod.POST, params = {"backPage"})
	public ModelAndView backToMenu() {
		return new ModelAndView("menuPage", "command", new ProductAccessor());
	}
	
	@RequestMapping(value = {"/addNewProducts"}, method = RequestMethod.GET, params = {"previousPage"})
	public ModelAndView previousPage() {
		return new ModelAndView("menuPage", "command", new ProductAccessor());
	}
	
	@RequestMapping(value = {"/addNewProducts"}, method = RequestMethod.GET, params = {"addProducts"})
	public ModelAndView addProduct(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap){
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.insertProducts(productAccessor.getProductbrand(), productAccessor.getProductname(), productAccessor.getQuantity(),productAccessor.getProductprice());
			modelMap.addAttribute("message", "product successfully added.");
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error occured during adding product.");
		}
		return new ModelAndView("addProductPage", "command", new ProductAccessor()); 
	}
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"addProduct"})
	public ModelAndView toAddProductPage() {
		return new ModelAndView("addProductPage", "command", new ProductAccessor());
	}
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"viewAllProduct"})
	public ModelAndView viewItems(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap) {
		ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
		List<ProductAccessor> productlist = productJDBC.viewProducts();
		
		ModelAndView model = new ModelAndView("eshoppingPage");
		model.addObject("productlist", productlist);
		return model;
	}

	
	@RequestMapping(value = {"/adminRights"}, method = RequestMethod.GET, params = {"updateProduct"})
	public ModelAndView toUpdateProducts(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, @RequestParam(value = "productid", required = false) int productid) {
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
	public ModelAndView updateItem(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, @RequestParam(value = "productid", required = false) int productid) {
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.updateProducts(productid, productAccessor.getProductbrand(), productAccessor.getProductname(), productAccessor.getQuantity(), productAccessor.getProductprice());
			modelMap.addAttribute("message", "Updated sucessfully.");
			List<ProductAccessor> productlist = productJDBC.viewProducts();
			ModelAndView model = new ModelAndView("eshoppingPage");
			model.addObject("productlist", productlist);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "error......");
			return new ModelAndView("updateProductPage", "command", productAccessor);
		}
		
	}
	
	@RequestMapping(value = {"/adminRights"}, method = RequestMethod.GET, params = {"deleteProduct"})
	public ModelAndView deleteItem(@ModelAttribute("SpringWeb")ProductAccessor productAccessor, ModelMap modelMap, @RequestParam(value = "productid", required = false) int productid) {
		
		try {
			ProductJDBC productJDBC = (ProductJDBC)appContext.getBean("productBeanJDBC");
			productJDBC.deleteProduct(productid);
			modelMap.addAttribute("message", "Delete successfully..");
			List<ProductAccessor> productlist = productJDBC.viewProducts();
			ModelAndView model = new ModelAndView("eshoppingPage");
			model.addObject("productlist", productlist);
			return model;
		} catch(Exception e) {
			modelMap.addAttribute("message", "Error in deleting");
			return new ModelAndView("toUpdatePage", "command", productAccessor);
		}
		
	}
}
