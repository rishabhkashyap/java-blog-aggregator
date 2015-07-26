package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.blog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
