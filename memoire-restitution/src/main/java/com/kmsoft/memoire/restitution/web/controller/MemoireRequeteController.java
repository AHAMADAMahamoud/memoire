package com.kmsoft.memoire.restitution.web.controller;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmsoft.memoire.requete.model.Requete;
import com.kmsoft.memoire.requete.service.RequeteService;
import com.kmsoft.memoire.restitution.web.utils.CodeGenerator;

@Controller
public class MemoireRequeteController {

	@Autowired
	RequeteService requeteServ;

	/**
	 * Constructor for main controller
	 */
	public MemoireRequeteController() {
		super();

	}

	@RequestMapping(value = "/open_accueil_requette", method = RequestMethod.GET)
	public String ouvreAccueilRequette(Model model) {
		model.addAttribute("msg", "Gestion des requêtes");
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");
		return "requete";
	}

	@RequestMapping(value = "/load_default_request", method = RequestMethod.GET)
	public String chargerRequete(Model model) {

		String message = requeteServ.chargerDansLaBase();
		model.addAttribute("msg", "Gestion des requêtes");

		model.addAttribute("class_info", "alert-success");

		model.addAttribute("info", "Bien joué :");
		model.addAttribute("info_suite", message);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "requete";
	}

	@RequestMapping(value = "/ajout_nouveau_request", method = RequestMethod.POST)
	public String ajoutRequete(Model model, @RequestParam(name = "requet") String requet) {
		
		String code=CodeGenerator.next();
		
		String message = requeteServ.ajouterDansLaBase(code, requet);
		
		model.addAttribute("msg", "Gestion des requêtes");

		model.addAttribute("class_info", "alert-success");

		model.addAttribute("info", "Bien joué :");
		model.addAttribute("info_suite", message);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "requete";
	}

	@GetMapping(value = "/modifier_request")
	public String modifierRequete(Model model, @RequestParam(name = "code") String code) {

		Requete req = requeteServ.obtenirRequete(code);
		model.addAttribute("msg", "Gestion des requêtes");
		model.addAttribute("req", req);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "requete";
	}

	@GetMapping(value = "/supprimer_request")
	public String supprimerRequete(Model model, @RequestParam(name = "code") String code) {

		Requete req = requeteServ.supprimerRequette(code);
		model.addAttribute("msg", "Gestion des requêtes");
		
		model.addAttribute("req", req);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "requete";
	}

	
	@RequestMapping(value = "/getRequettes", method = RequestMethod.GET)
	public @ResponseBody List<Requete> getRequettes(@RequestParam(name = "requetteFr") String requetteFr) {

		return rechercheRequetteCorrespondant(requetteFr);

	}

	private List<Requete> rechercheRequetteCorrespondant(String requettecharcter) {

		List<Requete> result = new ArrayList<Requete>();

		// iterate a list and filter by RequetteName
		for (Requete requette : requeteServ.recupererLesRequetteParDefaut()) {
			if (this.containsIgnoreCase(requette.getRequetteFr(), requettecharcter)) {
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
