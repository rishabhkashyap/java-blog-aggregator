package com.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private UserService userService;
	private BlogService blogService;

	// Setter method for userService
		@Autowired
		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		@Autowired
		public void setBlogService(BlogService blogService) {
			this.blogService = blogService;
		}

		// Method to bind user entity
		@ModelAttribute("user")
		public User constructUser() {
			return new User();
		}
	
	// Controller to register new user
		@RequestMapping( method = RequestMethod.GET)
		public String registerNewUser(Model model) {
			return "user-register";
		}

		// To register user
		//Handles request coming from new user registration page
		
		@RequestMapping( method = RequestMethod.POST)
		public String doRegister(@Valid @ModelAttribute("user") User user,BindingResult result) {
			if(result.hasErrors()){
				return "user-register";
			}else{
				userService.save(user);
				return "redirect:/register?success=true";
			}
			
		}



}
