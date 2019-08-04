package com.kmsoft.memoire.restitution.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoireRestitutionController {

//	@Autowired
//	Loader etl;

	/**
	 * Constructor for main controller
	 */
	public MemoireRestitutionController() {
		super();
	}

	@RequestMapping(value = "/open_accueil_restitution", method = RequestMethod.GET)
	public String openFrmAdd(Model model) {
		model.addAttribute("msg", "Gestion des exports");
		return "restitution";
	}

	
}
