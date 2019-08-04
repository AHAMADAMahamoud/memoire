package com.kmsoft.memoire.restitution.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/**
	 * Constructor for main controller
	 */
	public MainController() {
		super();
	}

	/**
	 * Welcome Page
	 * 
	 * @return model view
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView webUi() {
//		RequetteAnalyseur requeteAnaliseur = new RequetteAnalyseur();
//		List<String> motsSql=requeteAnaliseur.findEquivalanceMots("AFFICHER TOUS LES ARTICLES de l'année 2016");
		String date = (new java.util.Date()).toString();
		final ModelAndView model = new ModelAndView("index", "date", date);
		return model;
	}

}