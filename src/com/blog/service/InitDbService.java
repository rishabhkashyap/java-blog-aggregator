package com.blog.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Role;
import com.blog.repository.RoleRepository;
@Service
@Transactional
public class InitDbService {
	
	private RoleRepository roleRepository;
	
	
	
	public RoleRepository getRoleRepository() {
		return roleRepository;
	}


	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}



	@PostConstruct
	public void init(){
		Role roleUser =new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
	}

}
