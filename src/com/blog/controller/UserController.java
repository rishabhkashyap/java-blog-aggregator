/**
 * Controller class handles all requests that are related to users
 */
package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.entity.User;
import com.blog.service.UserService;

/**
 * @author Rishabh Kashyap
 *
 */
@Controller
public class UserController {
	private UserService userService;

	// Setter method for userService
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	/**
	 * Handles request from user page
	 * 
	 * @param model
	 *            use it to display details
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
		return "user-register";
	}
}
