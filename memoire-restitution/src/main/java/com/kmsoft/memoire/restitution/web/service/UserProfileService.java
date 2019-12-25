package com.kmsoft.memoire.restitution.web.service;

import java.util.List;

import com.kmsoft.memoire.restitution.web.model.UsersProfile;



public interface UserProfileService {

	UsersProfile findById(int id);

	UsersProfile findByType(String type);
	
	List<UsersProfile> findAll();
	
}
