package com.kmsoft.memoire.restitution.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmsoft.memoire.requete.model.Requete;
import com.kmsoft.memoire.requete.service.RequeteService;
import com.kmsoft.memoire.requete.service.Triple;
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

	@RequestMapping(value = "/ajout_request_traduit", method = RequestMethod.POST)
	public String ajoutRequete(Model model, @RequestParam(name = "code_src") String requetSql,
			@RequestParam(name = "idr") String idr, @RequestParam(name = "resultat_graph") String resultat_graph) {

		Requete req = requeteServ.obtenirRequeteParId(Long.parseLong(idr));
		req.setRequetteSql(requetSql);
		req.setResultatGraphe(resultat_graph);
		Requete reqResult = requeteServ.editerRequete(req);

		model.addAttribute("req", reqResult);
		model.addAttribute("msg", "Administration des requêtes");

		model.addAttribute("class_info", "alert-success");

		model.addAttribute("info", "Bien joué :");
		model.addAttribute("info_suite", "Requete Mise à jour avec succè");
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "admin_requete";
	}
	
	@GetMapping(value = "/tester_request")
	public String testerRequete(Model model, @RequestParam(name = "idr") String idr) {
		//code_src
		Requete req = requeteServ.obtenirRequeteParId(Long.parseLong(idr));
//		req.setRequetteSql(requetteSql);
		Triple<Requete, String, List<Object[]>> resultat_test=requeteServ.testerRequete(req);
		
		model.addAttribute("jsonREsult", "resultat_json_ici");
		model.addAttribute("listObjetREsult", "resultat_json_ici");
		model.addAttribute("msg", "Administration des requêtes");
		model.addAttribute("req", req);
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_req", "active");

		return "admin_requete";
	}

}