package com.kmsoft.memoire.alimentation.dw.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.memoire.alimentation.dw.model.UserPersistentLogin;

@Repository
public interface PersistentLoginRepository extends JpaRepository<UserPersistentLogin, String>{

	Integer deleteByUsername(String username);
}

