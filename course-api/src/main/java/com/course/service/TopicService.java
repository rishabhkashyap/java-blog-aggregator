package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.entity.Topic;

@Service
public class TopicService {
	private List<Topic> topics;

	public TopicService() {		
		this.topics = new ArrayList<>();
	}
	
	public List<Topic>getAllTopics(){
		topics.add(new Topic("101","Spring","Spring Core"));
		topics.add(new Topic("102","Java","Java Fundamental"));
		topics.add(new Topic("103","JavaScript","JS fundamental"));
		topics.add(new Topic("104","Angular","Angular fundamental"));
		return topics;
	}
	
	public boolean addTopic(Topic topic){
		return topics.add(topic);
	}
	
	public void updateTopic(String id,Topic topic){
		for(int i=0;i<topics.size();i++){
			if(topics.get(i).getId().equals(id)){
				topics.set(i, topic);
				break;
			}
		}
		
	}

}
