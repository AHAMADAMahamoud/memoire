package com.kmsoft.memoire.restitution.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmsoft.memoire.requete.model.Requete;
import com.kmsoft.memoire.requete.service.RequeteService;

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


}
