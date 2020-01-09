package com.kmsoft.memoire.restitution.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.memoire.requete.model.Requete;
import com.kmsoft.memoire.requete.service.Pair;
import com.kmsoft.memoire.requete.service.RequeteService;

@Controller
public class MemoireRestitutionController {
	@Autowired
	RequeteService requeteServ;

	/**
	 * Constructor for main controller
	 */
	public MemoireRestitutionController() {
		super();
	}

	@RequestMapping(value = "/open_accueil_restitution", method = RequestMethod.GET)
	public String openRapprotTable(Model model) {
		model.addAttribute("msg", "Gestion des rapports");
		model.addAttribute("listrequete", this.requeteServ.listerRequete());
		model.addAttribute("active_rest", "active");
		return "restitution";
	}

	@RequestMapping(value = "/open_restitution", method = RequestMethod.GET)
	public String openRapport(@RequestParam("req_id") long reqId, Model model) {

		model.addAttribute("msg", "Gestion des export");
		Pair<Requete, List<Object[]>> o = this.requeteServ.obtenirResultatRequette(reqId);
		int ncolonne = 0;

		if (o.getResultat().size() < 2) {
			ncolonne = 2;
		} else {
			ncolonne = o.getResultat().get(0).length;
		}

		String rFr = o.getRequete().getRequetteFr();
		model.addAttribute("info_req", rFr.startsWith("Aff") ? rFr.replace("Afficher ", "") : rFr);
		model.addAttribute("culumn_size", ncolonne);
		model.addAttribute("listresultat", o.getResultat());
		model.addAttribute("graphe", "chartplace");
		model.addAttribute("active_rest", "active");
		return "rapport";
	}
	
//	@RequestMapping(value = "/request", method = RequestMethod.GET)
//	public String launch(Model model) {
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonInString = null;
//		List<Object[]> objs=this.requeteServ.obtenirResultat();
//		String[] col= {"col1","col2","col3","col4"};
//		try {
//			List<Map<String, String>> response = requeteServ.preparData(mapper.convertValue(objs, JsonNode.class), col);
//
//			jsonInString = mapper.writeValueAsString(response);
//		} catch (IOException e) {
//			
//		}
//
//		model.addAttribute("apps", jsonInString);
//		model.addAttribute("col", col);
//		
//		return "dashboard";
//	}

	@RequestMapping(value = "/open_parametre", method = RequestMethod.GET)
	public String openParametre(Model model) {
		model.addAttribute("msg", "Gestion des requetes");
		model.addAttribute("active_param", "active");
		return "parametre";
	}

	@RequestMapping(value = "/open_chiffredaffaire", method = RequestMethod.GET)
	public String openChiffreAffaire(Model modelca) {
		modelca.addAttribute("msg", "Affiche du Chiffre d'affaire");
		modelca.addAttribute("active_rest", "active");

		return "ca";
	}

	@RequestMapping(value = "/open_produits", method = RequestMethod.GET)
	public String openProduits(Model modelPro) {
		
		modelPro.addAttribute("msg", "Affiche des différents produits");
		modelPro.addAttribute("active_rest", "active");
		return "produit";
	}

	@RequestMapping(value = "/open_ventes", method = RequestMethod.GET)
	public String openVente(Model modelVente) {
		modelVente.addAttribute("msg", "Affiche des différents ventes");
		return "vente";
	}

	@RequestMapping(value = "/open_recettes", method = RequestMethod.GET)
	public String openRecette(Model modelRecet) {
		modelRecet.addAttribute("msg", "Affiche des différents recettes");
		return "recette";
	}
	
	@RequestMapping(value = "/open_restitution_Excel", method = RequestMethod.GET)
	public String openRestitutionExcel(Model modelRecet) {
		modelRecet.addAttribute("msg", "Affiche des différents recettes");
		return "recette";
	}

}
