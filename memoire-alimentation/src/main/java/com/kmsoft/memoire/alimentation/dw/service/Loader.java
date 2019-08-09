package com.kmsoft.memoire.alimentation.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.alimentation.dw.model.DimArticle;
import com.kmsoft.memoire.alimentation.dw.model.DimCategorie;
import com.kmsoft.memoire.alimentation.dw.model.DimGeographie;
import com.kmsoft.memoire.alimentation.dw.model.DimTemps;
import com.kmsoft.memoire.alimentation.dw.model.FaitVente;
import com.kmsoft.memoire.alimentation.dw.repository.AbstractRepository;

@Service
public class Loader {
	@Autowired
	private AbstractRepository<DimTemps> tempsRepository;

	@Autowired
	private AbstractRepository<DimGeographie> geographieRepository;
	@Autowired
	private AbstractRepository<DimCategorie> categorieRepository;
	@Autowired
	private AbstractRepository<FaitVente> venteRepository;

	@Autowired
	private AbstractRepository<DimArticle> articleRepository;

	@Autowired
	Extractor tempsLoader;

	public String saveDataforDimTemps(String file) {
		List<DimTemps> data = tempsLoader.runETLforDimTemps(file);
		return tempsRepository.saveMany(data);
	}

	public String saveDataforDimArticle(String file) {
		List<DimArticle> data = tempsLoader.runETLforDimArticles(file);
		return articleRepository.saveMany(data);
	}

	public String saveDataforDimGeographie(String fichier) {
		List<DimGeographie> data = tempsLoader.runETLforDimGeographie(fichier);
		return geographieRepository.saveMany(data);
	}

	public String saveDataforDimCategorie(String fichier) {
		List<DimCategorie> data = tempsLoader.runETLforDimCategorie(fichier);
		return categorieRepository.saveMany(data);
	}

	public String saveDataforDimVente(String fichier) {
		List<FaitVente> data = tempsLoader.runETLforDimVente(fichier);
		return venteRepository.saveMany(data);
	}

}
