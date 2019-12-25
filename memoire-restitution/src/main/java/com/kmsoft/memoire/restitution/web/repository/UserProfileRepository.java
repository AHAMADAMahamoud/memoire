package com.kmsoft.memoire.restitution.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.memoire.restitution.web.model.UserProfile;



@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(Integer id);
}
