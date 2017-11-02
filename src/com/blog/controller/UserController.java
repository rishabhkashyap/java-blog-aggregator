/**
 * Controller class handles all requests that are related to users
 */
package com.blog.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	@RequestMapping("/account")
	public String showAccount(Model model, Principal principal,
			@ModelAttribute("user") User user) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name));
		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(@Valid @ModelAttribute("blog") Blog blog,
			Principal principal, @ModelAttribute("user") User user,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			return showAccount(model, principal, user);
		} else {
			String name = principal.getName();
			blogService.save(blog, name);

		}

		return "redirect:/account";
	}

	// @RequestMapping("/")
	// public String getIndex(@ModelAttribute("user") User user){
	// return "index";
	// }

	// Handles request to remove a blog
	// It redirects to page where user can delete blogs

	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account";

	}

}
