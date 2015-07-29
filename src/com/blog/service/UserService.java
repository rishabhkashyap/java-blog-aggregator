
/**
 * Class pulls all users from database
 */
package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Blog;
import com.blog.entity.Item;
import com.blog.entity.User;
import com.blog.repository.BlogRepository;
import com.blog.repository.ItemRepository;
import com.blog.repository.UserRepository;

@Transactional
@Service
public class UserService {
	
	private UserRepository userRepository;
	private BlogRepository blogRepository;
	private ItemRepository itemRepository;

	//Getters and setters
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	
	@Autowired
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	/**
	 * Method returns all users saved in database
	 * @param void 
	 * @return Return list  containing all users
	 */
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	/**
	 * Method returns all users who have blogs
	 * @param id User id of user
	 * @return object of type User
	 */
	@Transactional
	public User findOneWithBlogs(int id) {
		User user=findOne(id);
		List<Blog>blogs=blogRepository.findByUser(user);
		for(Blog blog:blogs){
			List<Item> items= itemRepository.findByBlog(blog ,new PageRequest(0,10,Direction.DESC,"datePublish"));
			 System.out.println(items);			
		}
		user.setBlogs(blogs);
		return user;
	}


	public void save(User user) {
		userRepository.save(user);
		
	}
	
}
