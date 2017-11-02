package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import com.course.entity.Course;
import com.course.entity.Topic;
import com.course.repository.CourseRepository;
import com.course.repository.TopicRepository;


@Service
public class CourseService {
	@Autowired
    private CourseRepository courseRepository;
	
	private TopicRepository topicRepository;
    
	public CourseService() {	}
	
	public List<Course>getAllcourses(String topicId){
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
						.forEach(courses::add);
		return courses;
	}
	
	public Course addcourse(Course course,String id){
		course.setTopicId(id);		
		return courseRepository.save(course);
	}
	
	public void updatecourse(Course course){
		courseRepository.save(course);
		
	}
	
	public Course getcourse(String id){
		return courseRepository.findOne(id);
	}
	
	public void delete(String id){
		courseRepository.delete(id);
	}

}
