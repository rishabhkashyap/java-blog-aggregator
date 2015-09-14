package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.blog.entity.Blog;
import com.blog.entity.User;
import com.blog.repository.BlogRepository;
import com.blog.repository.UserRepository;

@Service
public class BlogService {
	private BlogRepository blogRepository;
	private UserRepository userRepository;
	
	//Setter methods
	


	public void save(Blog blog,String name) {
		// TODO Auto-generated method stub
		User user=userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
		
	}
	
	@Autowired
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PreAuthorize("#blog.user.name==authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog")Blog blog) {
		// TODO Auto-generated method stub
		blogRepository.delete(blog);
		
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
		
	}

}
