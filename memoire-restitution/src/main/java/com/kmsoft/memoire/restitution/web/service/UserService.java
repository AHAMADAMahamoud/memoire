package com.kmsoft.memoire.restitution.web.service;

import java.util.List;

import com.kmsoft.memoire.restitution.web.model.Users;



public interface UserService {
	
	Users findById(int id);
	
	Users findBySSO(String sso);
	
	void saveUser(Users user);
	
	void updateUser(Users user);
	
	void deleteUserBySSO(String sso);

	List<Users> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);

}