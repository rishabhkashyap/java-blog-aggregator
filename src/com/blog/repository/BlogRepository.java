/**
 * 
 */
package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Blog;

/**
 * @author Rishabh Kashyap
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
