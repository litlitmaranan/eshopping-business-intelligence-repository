package com.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshopping.jdbc.LoginJDBC;
import com.eshopping.properties.CustomerAccessor;
import com.eshopping.properties.LoginAccessor;

@Controller
public class LoginController {

	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView startUpPage() {
		return new ModelAndView("loginPage", "command", new LoginAccessor());
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST, params = {"backButton"})
	public ModelAndView backToLogin() {
		return new ModelAndView("loginPage", "command", new LoginAccessor());
	}
	
	
	
	@RequestMapping(value = {"/transactions"}, method = RequestMethod.GET, params = {"logOut"})
	public ModelAndView LogOut() {
		return new ModelAndView("loginPage", "command", new LoginAccessor());
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST, params = {"loginAsGuest"})
	public ModelAndView guestPage(ModelMap modelMap, @RequestParam(value = "guest", required = false)String guest) {
		modelMap.addAttribute("guest", guest);
		return new ModelAndView("menuPage");
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST, params = {"loginButton"})
	public ModelAndView loginSecurity(@ModelAttribute("SpringWeb")LoginAccessor loginAccessor, ModelMap modelMap) {
		try {
			LoginJDBC loginJDBC = (LoginJDBC)appContext.getBean("loginBeanJDBC");
			loginJDBC.login(loginAccessor.getUsername(), loginAccessor.getPassword());
			modelMap.addAttribute("admin", loginAccessor.getUsername());
			modelMap.addAttribute("successMessage", "Your login successfully");
			return new ModelAndView("menuPage", "command", new CustomerAccessor());
		} catch(Exception e) {
			loginAccessor.setPassword("");
			modelMap.addAttribute("errorMessage", "Invalid username and password");
			return new ModelAndView("loginPage", "command", loginAccessor);
		}
	}
	
}
