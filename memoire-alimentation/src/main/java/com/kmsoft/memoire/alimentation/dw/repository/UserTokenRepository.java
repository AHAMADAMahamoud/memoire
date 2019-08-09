package com.kmsoft.memoire.alimentation.dw.repository;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kmsoft.memoire.alimentation.dw.model.UserPersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class UserTokenRepository implements PersistentTokenRepository {

	static final Logger logger = LoggerFactory.getLogger(UserTokenRepository.class);

	@Autowired
	private PersistentLoginRepository persistentLoginRepo;

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		logger.info("Creating Token for user : {}", token.getUsername());
		UserPersistentLogin persistentLogin = new UserPersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		persistentLoginRepo.save(persistentLogin);

	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		logger.info("Fetch Token if any for seriesId : {}", seriesId);
		try {

			UserPersistentLogin persistentLogin = persistentLoginRepo.findOne(seriesId);

			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLast_used());
		} catch (Exception e) {
			logger.info("Token not found...");
			return null;
		}
	}

	@Override
	public void removeUserTokens(String username) {
		logger.info("Removing Token if any for user : {}", username);
		persistentLoginRepo.deleteByUsername(username);
		logger.info("rememberMe was selected");
	}

	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
		UserPersistentLogin persistentLogin = new UserPersistentLogin();
		persistentLogin.setSeries(seriesId);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		persistentLoginRepo.save(persistentLogin);
	}

}
