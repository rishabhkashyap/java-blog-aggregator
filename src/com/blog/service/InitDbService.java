package com.blog.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Blog;
import com.blog.entity.Item;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.repository.BlogRepository;
import com.blog.repository.ItemRepository;
import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;

//This class initializes database when application is deployed 
@Transactional
@Service
public class InitDbService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	//Getters and Setters
	
//	
//	public RoleRepository getRoleRepository() {
//		return roleRepository;
//	}
//	
//	@Autowired
//	public void setRoleRepository(RoleRepository roleRepository) {
//		this.roleRepository = roleRepository;
//	}
//	public BlogRepository getBlogRepository() {
//		return blogRepository;
//	}
//	@Autowired
//	public void setBlogRepository(BlogRepository blogRepository) {
//		this.blogRepository = blogRepository;
//	}
//	public UserRepository getUserRepository() {
//		return userRepository;
//	}
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//	public ItemRepository getItemRepository() {
//		return itemRepository;
//	}
//	@Autowired
//	public void setItemRepository(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}
	
	//This method initializes db when application is deployed
	//Return type void
	//Parameter void 
	/**
	 * Method initializes  db when application is deployed on server
	 * @param void
	 * @return void
	  */
	
	@PostConstruct
	public void init(){
		
		//Creating user role
		Role roleUser =new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		//Creating admin role
		Role roleAdmin =new Role();
		roleUser.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		//Create Admin user
		User userAdmin=new User();
		userAdmin.setName("admin");
		List<Role>roles=new ArrayList<>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		//Creating blog
		Blog blog=new Blog();
		blog.setName("Javavids");
		blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blog.setUser(userAdmin);
		blogRepository.save(blog);
		
		//Create item
		
		Item item1=new Item();
		item1.setBlog(blog);
		item1.setDescription("First");
		item1.setLink("http://www.javavids.com");
		item1.setDatePublish(new Date());
		
		Item item2=new Item();
		item2.setBlog(blog);
		item2.setDescription("Second");
		item2.setLink("http://www.javavids.com");
		item2.setDatePublish(new Date());
	}
	
	
	
	

}
