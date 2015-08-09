package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String doLogin(Model model){
		return "login";
	}
	
	//Logout 
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String doLogout(Model model){
		
		return "login";
		
	}

}
