package com.kmsoft.memoire.restitution.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoireLoginController {

	 final  Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * Constructor for main controller
	 */
	public MemoireLoginController() {
		super();
	}

//	@RequestMapping(value = "/_login_", method = RequestMethod.POST)
//	public String login(Model model) {
//		model.addAttribute("msg", "KOMOCASH APP");
//		return "accueil";
//
//	}
	@RequestMapping(value = {"/","/accueil"}, method = RequestMethod.GET)
	public String accueil(Model model) {
		model.addAttribute("msg", "KOMOCASH APP");
		logger.info("==Connexion établie==");
		return "accueil";

	}
}
