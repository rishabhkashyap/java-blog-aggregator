package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.entity.Topic;
import com.course.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
    private TopicRepository topicRepository;
    
	public TopicService() {	}
	
	public List<Topic>getAllTopics(){
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll()
						.forEach(topics::add);
		return topics;
	}
	
	public Topic addTopic(Topic topic){
		return topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic){
		topicRepository.save(topic);
		
	}
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}
	
	public void delete(String id){
		topicRepository.delete(id);
	}

}
