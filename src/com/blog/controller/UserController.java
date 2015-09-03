/**
 * Controller class handles all requests that are related to users
 */
package com.blog.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.entity.Blog;
import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.UserService;

/**
 * @author Rishabh Kashyap
 *
 */
@Controller
public class UserController {
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

	// Method to bind blog entity
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}

	/**
	 * Handles request from user page
	 * 
	 * @param model
	 *            use it to display details
	 * 
	 * @return name of jsp page
	 */
	@RequestMapping("/users")
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
	@RequestMapping("/users/{id}")
	public String getUsersById(Model model, @PathVariable int id) {
		User user = userService.findOneWithBlogs(id);
		model.addAttribute("user", user);
		return "user-detail";
	}

	// Controller to register new user

	@RequestMapping("/register")
	public String registerNewUser(Model model) {
		return "user-register";
	}

	// To register user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/register?success=true";
	}

	@RequestMapping("/account")
	public String showAccount(Model model, Principal principal,
			@ModelAttribute("user") User user) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "user-detail";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(@ModelAttribute("blog") Blog blog,
			Principal principal, @ModelAttribute("user") User user) {
		String name = principal.getName();
		blogService.save(blog, name);

		return "redirect:/account";
	}
	// @RequestMapping("/")
	// public String getIndex(@ModelAttribute("user") User user){
	// return "index";
	// }

	
	// Handles request to remove a blog
	// It redirects to page where user can delete blogs
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id){
		blogService.delete(id);
		return "redirect:/account";
		
		
	}
	
	//Handles request to delete user 
	
	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable int id){
		userService.delete(id);
		return "redirect:/users";
	}
	
}
