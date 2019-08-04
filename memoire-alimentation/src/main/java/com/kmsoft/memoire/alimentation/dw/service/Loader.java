package com.kmsoft.memoire.alimentation.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.alimentation.dw.model.Article;
import com.kmsoft.memoire.alimentation.dw.model.Categorie;
import com.kmsoft.memoire.alimentation.dw.model.Geographie;
import com.kmsoft.memoire.alimentation.dw.model.Temps;
import com.kmsoft.memoire.alimentation.dw.model.Vente;
import com.kmsoft.memoire.alimentation.dw.repository.AbstractRepository;
import com.kmsoft.memoire.alimentation.dw.repository.IArticleRepository;

@Service
public class Loader {

	@Autowired
	private IArticleRepository articleRepository;
	@Autowired
	private AbstractRepository<Temps> tempsRepository;
	
	
	@Autowired
	private AbstractRepository<Geographie> geographieRepository;
	@Autowired
	private AbstractRepository<Categorie> categorieRepository;
	@Autowired
	private AbstractRepository<Vente> venteRepository;
	
	@Autowired
	Extractor tempsLoader;
	
	public String saveDataforDimTemps(String file) {
		List<Temps> data = tempsLoader.runETLforDimTemps(file);
		return tempsRepository.saveManyByForceID(data);
	}
	
	public String saveDataforDimArticle(String file) {
		List<Article> data = tempsLoader.runETLforDimArticles(file);
		return articleRepository.saveManyArticle(data);
	}

	public String saveDataforDimGeographie(String fichier) {
		List<Geographie> data = tempsLoader.runETLforDimGeographie(fichier);
		return geographieRepository.saveMany(data);
	}

	public String saveDataforDimCategorie(String fichier) {
		List<Categorie> data = tempsLoader.runETLforDimCategorie(fichier);
		return categorieRepository.saveMany(data);
	}

	public String saveDataforDimVente(String fichier){
		List<Vente> data = tempsLoader.runETLforDimVente(fichier);
		return venteRepository.saveMany(data);
	}
	
}
