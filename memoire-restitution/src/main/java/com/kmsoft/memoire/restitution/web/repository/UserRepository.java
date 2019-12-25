package com.kmsoft.memoire.restitution.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.memoire.restitution.web.model.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Users findById(Integer id);
	
	Users findBySsoId(String sso);
	
	
	void deleteBySsoId(String sso);

}

