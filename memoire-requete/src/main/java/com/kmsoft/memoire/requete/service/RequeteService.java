package com.kmsoft.memoire.requete.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.alimentation.dw.repository.AbstractRepository;
import com.kmsoft.memoire.requete.model.Requette;

@Service
public class RequeteService {

	@Autowired
	private AbstractRepository<Requette> requeteDao;

	@Autowired
	private RequetteLoader requetteLoader;

	public String introduireRequete(Requette req) {
		String message = "";
		try {
			message = requeteDao.save(req);
		} catch (Exception e) {

		}
		return message;
	}

	public Requette editerRequete(Requette req) {
		return requeteDao.update(req);

	}

	public List<Requette> listerRequete() {
		return requeteDao.findAll(new Requette());

	}

	public boolean validerRequet(List<Requette> listeRequet) {

		for (Requette requeteSQL : listeRequet) {
			if (requeteSQL != null && requeteSQL.getEtat() != null && !requeteSQL.getEtat().isEmpty()) {
				if (requeteSQL.equals(updateRequete(requeteSQL)))
					return false;
			}
		}

		return true;
	}

	private Requette updateRequete(Requette requeteSQL) {

		return requeteDao.update(requeteSQL);

	}

	public void AfficherResultat(Requette requete) {
		if (requete != null && requete.getRequetteFr() != null && !requete.getRequetteFr().isEmpty()) {
			executerRequete(requete);

		}
	}

	/**
	 * afficher les montant de vente depuis 2003 jusqu'a aujourd'hui Select
	 * montant from FactVent where date.year>2003 and date.year<datenow
	 * 
	 * @param requete
	 */
	private void executerRequete(Requette requete) {

		// TODO finir la partie des mot clé et des conversoion des requette fr
		// en sql d'abord
	}

	public ArrayList<Requette> recupererLesRequetteParDefaut() {
		return requetteLoader.getDefaultRequest();

	}
}
