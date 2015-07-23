package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
