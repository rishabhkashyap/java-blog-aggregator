package com.course.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Topic {
	@Id 	
	private String id;
	private String topicName;
	private String topicDescription;
	

	public Topic() {}

	public Topic(String id, String topicName, String topicDescription) {
		super();
		this.id = id;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

		

}
