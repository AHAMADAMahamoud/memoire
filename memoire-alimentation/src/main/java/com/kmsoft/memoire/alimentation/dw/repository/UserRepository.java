package com.kmsoft.memoire.alimentation.dw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.memoire.alimentation.dw.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findById(Integer id);
	
	User findBySsoId(String sso);
	
	
	void deleteBySsoId(String sso);

}

