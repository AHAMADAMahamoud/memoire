package com.kmsoft.memoire.restitution.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemoireLoginController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Constructor for main controller
	 */
	public MemoireLoginController() {
		super();
	}

	@RequestMapping(value = { "/accueil_login" }, method = RequestMethod.GET)
	public String accueil(Model model) {
		model.addAttribute("msg", "KOMOCASH APP");
		logger.info("==Connexion établie==");
		return "accueil";

	}

	@RequestMapping(value = { "/accueil_login" }, method = RequestMethod.POST)
	public String accueil(Model model, 
			@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		model.addAttribute("username", username);
		logger.info("==Connexion établie==");
		return "accueil";

	}
}
