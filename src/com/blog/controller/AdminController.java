package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	
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
		
	
	/**
	 * Handles request from user page
	 * 
	 * @param model
	 *            use it to display details
	 * 
	 * @return name of jsp page
	 * 
	 */	
	@RequestMapping
	public String getUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "users";

	}

	/**
	 * 
	 * @param model
	 *            delegates rendering of response
	 * @param int takes user id to identify user
	 * @return Return name of jsp page as string
	 */
	@RequestMapping("/{id}")
	public String getUsersById(Model model, @PathVariable int id) {
		User user = userService.findOneWithBlogs(id);
		model.addAttribute("user", user);
		return "user-detail";
	}
	
	//Handles request to delete user 
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users";
	}
	


}
