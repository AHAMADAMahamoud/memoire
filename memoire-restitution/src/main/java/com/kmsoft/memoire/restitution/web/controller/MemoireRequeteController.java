package com.kmsoft.memoire.restitution.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmsoft.memoire.requete.model.Requette;
import com.kmsoft.memoire.requete.service.RequeteService;

@Controller
public class MemoireRequeteController {

	@Autowired
	RequeteService requeteServ;
	private List<Requette> data = new ArrayList<>();

	/**
	 * Constructor for main controller
	 */
	public MemoireRequeteController() {
		super();

	}

	@RequestMapping(value = "/open_accueil_requette", method = RequestMethod.GET)
	public String ouvreAccueilRequette(Model model) {
		model.addAttribute("msg", "Gestion des requêtes");
		return "requete";
	}

	@RequestMapping(value = "/getRequettes", method = RequestMethod.GET)
	public @ResponseBody List<Requette> getRequettes(@RequestParam(name = "requetteFr") String requetteFr) {

		return rechercheRequetteCorrespondant(requetteFr);

	}

	private List<Requette> rechercheRequetteCorrespondant(String requettecharcter) {

		List<Requette> result = new ArrayList<Requette>();

		// iterate a list and filter by RequetteName
		for (Requette requette : requeteServ.recupererLesRequetteParDefaut()) {
			if ( this.containsIgnoreCase(requette.getRequetteFr(),requettecharcter)) {
				result.add(requette);
			}
		}

		return result;
	}

	private boolean containsIgnoreCase(String requetteFr, String requettecharcter) {
		
		if (requetteFr.toLowerCase().contains(requettecharcter.toLowerCase())) {
			return true;
		}
		return false;
	}

}
