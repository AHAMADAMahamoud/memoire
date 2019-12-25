package com.kmsoft.memoire.restitution.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kmsoft.memoire.restitution.web.model.Users;
import com.kmsoft.memoire.restitution.web.repository.UserRepository;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Users findById(int id) {
		return dao.findById(id);
	}

	public Users findBySSO(String sso) {
		Users user = dao.findBySsoId(sso);
		return user;
	}

	public void saveUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(Users user) {
		Users entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		dao.deleteBySsoId(sso);
	}

	public List<Users> findAllUsers() {
		return dao.findAll();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		Users user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
