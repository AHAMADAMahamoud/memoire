package com.kmsoft.memoire.restitution.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.memoire.restitution.web.model.UsersProfile;



@Repository
public interface UserProfileRepository extends JpaRepository<UsersProfile, Long>{

	List<UsersProfile> findAll();
	
	UsersProfile findByType(String type);
	
	UsersProfile findById(Integer id);
}
