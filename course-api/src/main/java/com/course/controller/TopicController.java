package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Topic;
import com.course.service.TopicService;



@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topics",method=RequestMethod.GET)
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	@RequestMapping(value="/topic/{id}",method=RequestMethod.GET)
	public ResponseEntity<Topic> getTopic(@PathVariable String id){
		Topic topic=null;
		List<Topic>topics=topicService.getAllTopics();
		topic=topics.stream()
				.filter(t->t.getId().equals(id))
				.findFirst().get();		
		if(topic!=null){
			return new ResponseEntity<>(topic,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
				
		
	}
	
	@RequestMapping(value="/topic",method=RequestMethod.POST)
	public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
		  boolean added=topicService.addTopic(topic);
		  if(added){
			  return new ResponseEntity(HttpStatus.OK);
		  }else{
			  return new ResponseEntity(HttpStatus.BAD_REQUEST);
		  }
		
	}
	
	@RequestMapping(value="/topic/{id}",method=RequestMethod.PUT)
	public void updateTopic(@PathVariable("id")String id,@RequestBody Topic topic){
		topicService.updateTopic(id,topic);
	}

}
