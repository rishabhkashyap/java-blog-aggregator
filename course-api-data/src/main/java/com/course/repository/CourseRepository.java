package com.course.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.course.entity.Course;

public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Course> findByTopicId(String topicId);

}
