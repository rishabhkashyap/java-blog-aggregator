package com.blog.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Blog;
import com.blog.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	//Method to find all items associated with a blog
	List<Item> findByBlog (Blog blog,Pageable page);

}
