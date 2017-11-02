package com.course.controller;

import java.util.List;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Course;
import com.course.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllcourses(topicId);
	}

	@RequestMapping(value = "/courses/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
		Course course = null;
		course = courseService.getcourse(courseId);
		if (course != null) {
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/topics/{id}/course", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addCourse(@PathVariable String id, @RequestBody Course course) {
		Course courseAdded = courseService.addcourse(course, id);
		if (courseAdded != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/course",method=RequestMethod.PUT)
	public void  updateCourse(@RequestBody Course course){
		courseService.updatecourse(course);
		
	}
	
	@RequestMapping(value="/course/{CourseId}",method=RequestMethod.DELETE)
	public void  deleteCourse(@PathVariable String courseId,@RequestBody Course course){
		courseService.delete(courseId);
		
	}
	
	

}
