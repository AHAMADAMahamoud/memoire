package com.kmsoft.memoire.restitution.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.memoire.restitution.web.model.UsersPersistentLogin;

@Repository
public interface PersistentLoginRepository extends JpaRepository<UsersPersistentLogin, String>{

	Integer deleteByUsername(String username);
}

