package com.course.repository;

import org.springframework.data.repository.CrudRepository;

import com.course.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
