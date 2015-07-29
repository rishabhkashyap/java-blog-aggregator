package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Blog;
import com.blog.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	/**
	 * Returns  all blogs associated with user
	 * @param user Objcet of class user 
	 * @return Returns a list of blog
	 */
	List<Blog>findByUser(User user);

}
