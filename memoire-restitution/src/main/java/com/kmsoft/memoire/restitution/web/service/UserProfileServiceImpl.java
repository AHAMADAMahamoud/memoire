package com.kmsoft.memoire.restitution.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kmsoft.memoire.restitution.web.model.UsersProfile;
import com.kmsoft.memoire.restitution.web.repository.UserProfileRepository;





@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileRepository dao;
	
	public UsersProfile findById(int id) {
		return dao.findById(id);
	}

	public UsersProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UsersProfile> findAll() {
		return dao.findAll();
	}
}
