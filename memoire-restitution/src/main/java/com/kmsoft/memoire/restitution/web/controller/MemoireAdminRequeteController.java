package com.kmsoft.memoire.restitution.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmsoft.memoire.requete.model.Requete;
import com.kmsoft.memoire.requete.service.RequeteService;
import com.kmsoft.memoire.restitution.web.utils.CodeGenerator;

@Controller
public class MemoireAdminRequeteController {

	@Autowired
	RequeteService requeteServ;

	/**
	 * Constructor for main controller
	 */
	public MemoireAdminRequeteController() {
		super();

	}
	
	@GetMapping(value = "/admin_requete")
	public String adminRequete(Model model) {
		
		
		model.addAttribute("msg", "Administration des requêtes");
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_param", "active");

		return "admin_requete";
	}
	
	@GetMapping(value = "/editer_request")
	public String modifierRequete(Model model, @RequestParam(name = "code") String code) {

		Requete req = requeteServ.obtenirRequete(code);
		model.addAttribute("msg", "Administration des requêtes");
		model.addAttribute("req", req);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "admin_requete";
	}
	
	@RequestMapping(value = "/traduit_nouveau_request", method = RequestMethod.POST)
	public String ajoutRequete(Model model, @RequestParam(name = "requet") String requet) {
				
		String message = requeteServ.ajouterDansLaBaseSQL(requet);		
		
		model.addAttribute("msg", "Gestion des requêtes");

		model.addAttribute("class_info", "alert-success");

		model.addAttribute("info", "Bien joué :");
		model.addAttribute("info_suite", message);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "admin_requete";
	}

}
