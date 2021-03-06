package com.kmsoft.memoire.restitution.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmsoft.memoire.alimentation.dw.config.ApplicationConfig;
import com.kmsoft.memoire.alimentation.dw.service.Loader;

@Controller
public class MemoireAlimentationController {

	@Autowired
	Loader etl;

	@Autowired
	private ApplicationConfig appConfig;

	/**
	 * Constructor for main controller
	 */
	public MemoireAlimentationController() {
		super();
	}

	@RequestMapping(value = "/open_etl_dimension", method = RequestMethod.GET)
	public String openFrmAdd(Model model) {
		model.addAttribute("msg", "Chargement des dimensions");
		String repertoireSource = appConfig.getDossier();
		model.addAttribute("dossier", repertoireSource);
		return "alimentation";
	}

	@RequestMapping(value = "/run_etl", method = RequestMethod.POST)
	public String add(@RequestParam("directory") String repertoireSource, Model model) {
		if (repertoireSource.length() > 5) {
			String message = "";
			List<String> fichierSources = new ArrayList<>();
			try (Stream<Path> paths = Files.walk(Paths.get(repertoireSource))) {
				paths.forEach(filePath -> {
					if (Files.isRegularFile(filePath)) {
						fichierSources.add(filePath.toAbsolutePath().toString());
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
				message = "error";
			}
			if (message.isEmpty()) {
				for (String fichier : fichierSources) {
					if (this.isFileCorrect(fichier)) {
						if (fichier.contains("dim")) {
							if (fichier.contains("art")) {
								message = this.etl.saveDataforDimArticle(fichier);
							}
							if (fichier.contains("geo")) {
								message = this.etl.saveDataforDimGeographie(fichier);
							}
							if (fichier.contains("cat")) {
								message = this.etl.saveDataforDimCategorie(fichier);
							}

							if (fichier.contains("temp")) {
								message = this.etl.saveDataforDimTemps(fichier);
							}
						} else {
							message = this.etl.saveDataforDimVente(fichier);

						}
					} else {
						message = "Erreur: Fichier incorrect";
					}
				}
			}
			String repertoireSource1 = appConfig.getDossier();
			model.addAttribute("dossier", repertoireSource1);
			model.addAttribute("info", message);
		} else

		{
			model.addAttribute("info", "Erreur: Vous devez spécifier un répertoire!");
		}
		model.addAttribute("msg", "Chargement des dimensions");
		return "alimentation";

	}
	//
	// @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	// public String editFrm(Model model, @PathVariable("id") Long id) {
	// model.addAttribute("msg", "Modifier personne");
	// model.addAttribute("personne", this.personneRepository.findOne(id));
	// return "personne_edit";
	// }
	//
	// @RequestMapping(value = "/personne/edit", method = RequestMethod.POST)
	// public String update(@ModelAttribute("personne") Article p) {
	// this.personneRepository.update(p);
	// return "redirect:/personnes";
	//
	// }

	private boolean isFileCorrect(String fichier) {
		if(fichier!=null){
			final List<String> lesExtensions=appConfig.getextensionAuthorise();
			final String ext=fichier.substring(fichier.indexOf('.')+1);
			if(lesExtensions.contains(ext)){
				return true;
			}else{
				return false;
			}
		
		}else{
			return false;
		}
	}
}
