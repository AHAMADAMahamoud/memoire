package com.kmsoft.memoire.alimentation.dw.service;

import java.util.List;

import com.kmsoft.memoire.alimentation.dw.model.UserProfile;



public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
