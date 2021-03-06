/**
 * Class initializes data base when application is deployed
 * It creates admin and assign roles to it
 * It also creates blog and item
 */

package com.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@Service
@Transactional
public class InitDbService {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private ItemRepository itemRepository;
	private BlogRepository blogRepository;

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ItemRepository getItemRepository() {
		return itemRepository;
	}

	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public BlogRepository getBlogRepository() {
		return blogRepository;
	}

	@Autowired
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	/**
	 * Method is executed after object is created and perform database
	 * initialization
	 * 
	 * @param void
	 * @return void
	 */
	@PostConstruct
	public void init() {
		// Creating user role
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		// Creating admin role
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		// Creating user admin
		// To encrypt password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEmail("kashyap.rishab@hotmail.com");
		//userAdmin.setLastName("admin Last");
		userAdmin.setEnabled(true);
		// Assigning roles to admin
		List<Role> roles = new ArrayList<>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userAdmin.setPassword(encoder.encode("admin"));
		// Saving user admin to db
		userRepository.save(userAdmin);

		// Creating blog
		Blog javavids = new Blog();
		javavids.setName("Java vids");
		javavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		javavids.setUser(userAdmin);
		blogRepository.save(javavids);

		// Creating Items
		Item item1 = new Item();
		item1.setLink("http://www.javavids.com");
		item1.setBlog(javavids);
		item1.setTitle("First");
		item1.setLink("http://www.javavids.com");
		item1.setDatePublish(new Date());
		itemRepository.save(item1);

		Item item2 = new Item();
		item2.setLink("http://www.javavids.com");
		item2.setBlog(javavids);
		item2.setTitle("Second");
		item2.setLink("http://www.javavids.com");
		item2.setDatePublish(new Date());
		itemRepository.save(item2);

	}

}
