package com.kmsoft.memoire.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kmsoft.memoire.alimentation.dw.config.ApplicationConfig;
import com.kmsoft.memoire.alimentation.dw.model.Article;
import com.kmsoft.memoire.alimentation.dw.model.Categorie;
import com.kmsoft.memoire.alimentation.dw.model.Geographie;
import com.kmsoft.memoire.alimentation.dw.model.Temps;
import com.kmsoft.memoire.alimentation.dw.model.Vente;
import com.kmsoft.memoire.alimentation.dw.repository.AbstractRepository;

public class ApplicationTest extends AbstractDaoTest {
	@Autowired
	private ApplicationConfig appConf;

	@Autowired
	private AbstractRepository<Article> articleRepository;
	@Autowired
	private AbstractRepository<Temps> tempsRepository;

	@Autowired
	private AbstractRepository<Geographie> geographieRepository;
	@Autowired
	private AbstractRepository<Categorie> categorieRepository;
	@Autowired
	private AbstractRepository<Vente> venteRepository;

	@Test
	public void dbConfigTest() {
		Assert.assertTrue(appConf != null);
	}

	@Test
	public void validTestDimTemps() { 
		System.out.println("test");
//		int tailleCharger=tempsRepository.findAll(new Temps()).size();
//		Assert.assertTrue(tailleCharger==2649);
	}

}
