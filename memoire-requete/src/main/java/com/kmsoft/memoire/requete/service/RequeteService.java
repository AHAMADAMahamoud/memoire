package com.kmsoft.memoire.requete.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.requete.repository.AbstractRepository;
import com.zaxxer.hikari.util.SuspendResumeLock;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.kmsoft.memoire.requete.model.Requete;

@Service
public class RequeteService {

	@Autowired
	private AbstractRepository<Requete> requeteDao;

	@Autowired
	private RequetteLoader requetteLoader;
	@PersistenceContext
	public EntityManager em;

	public String introduireRequete(Requete req) {
		String message = "";
		try {
			message = requeteDao.save(req);
		} catch (Exception e) {

		}
		return message;
	}

	public String introduirePluisieursRequete(ArrayList<Requete> listRequet) {
		String message = "";
		ArrayList<Requete> listRequetToSave = new ArrayList<>();
		for (int i = 0; i < listRequet.size(); i++) {
			Requete r = listRequet.get(i);
			if (!requeteDao.ifExist(r, "where code_req='" + r.getCodeReq() + "'")) {
				listRequetToSave.add(r);
			}
		}
		try {
			message = requeteDao.saveMany(listRequetToSave);
		} catch (Exception e) {
			message = "Erreur inconnu";
			e.printStackTrace();
		}
		return message;
	}
	@Transactional(rollbackOn = Exception.class)
	public Requete editerRequete(Requete req) {
		return requeteDao.update(req);

	}

	public List<Requete> listerRequete() {
		return requeteDao.findAll(new Requete());

	}

	public boolean validerRequet(List<Requete> listeRequet) {

		for (Requete requeteSQL : listeRequet) {
			if (requeteSQL != null && requeteSQL.getEtatReq() != null && !requeteSQL.getEtatReq().isEmpty()) {
				if (requeteSQL.equals(updateRequete(requeteSQL)))
					return false;
			}
		}

		return true;
	}

	private Requete updateRequete(Requete requeteSQL) {

		return requeteDao.update(requeteSQL);

	}

	public ArrayList<Requete> recupererLesRequetteParDefaut() {
		return requetteLoader.getDefaultRequest();

	}

	public String chargerDansLaBase() {
		return this.introduirePluisieursRequete(this.recupererLesRequetteParDefaut());
	}

	public Pair<Requete, List<Object[]>> obtenirResultatRequette(long reqId) {
		return this.executeRequette(reqId);

	}

	private Pair<Requete, List<Object[]>> executeRequette(long reqId) {
		Requete req = this.requeteDao.findOne(reqId, new Requete());
		List<Object[]> ol = null;
		if (req != null) {
			ol = this.execute(req);
		}
		return new Pair<Requete, List<Object[]>>(req, ol);

	}

	@SuppressWarnings("unchecked")
	private List<Object[]> execute(Requete req) {
		Query exec = this.em.createNativeQuery(req.getRequetteSql());
		List<Object[]> o = new ArrayList<>();
		if (exec != null) {
			o = (List<Object[]>) exec.getResultList();
		}


		
		return o;
	}

	@Transactional(rollbackOn = Exception.class)
	public String ajouterDansLaBase(String code, String requet) {
		String message = "";
		Requete r = new Requete(requet);
		r.setCodeReq(code);
		try {
			if (!requeteDao.ifExist(r, "where code_req='" + r.getCodeReq() + "'")) {
				requeteDao.save(r);
			} else {
				Requete r_up = obtenirRequete(r.getCodeReq());
				r_up.setRequetteFr(r.getRequetteFr());
				requeteDao.update(r_up);
			}

		} catch (Exception e) {
			message = "Erreur inconnu";
			e.printStackTrace();
		}
		return message;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public String ajouterDansLaBaseSQL(String requet) {
		String message = "";
		Requete r = new Requete(requet);
	//	r.setCodeReq(code);
		try {
			if (!requeteDao.ifExist(r, "where code_req='" + r.getCodeReq() + "'")) {
				requeteDao.save(r);
			} else {
				Requete r_up = obtenirRequete(r.getCodeReq());
				r_up.setRequetteFr(r.getRequetteFr());
				requeteDao.update(r_up);
			}

		} catch (Exception e) {
			message = "Erreur inconnu";
			e.printStackTrace();
		}
		return message;
	}

	public Requete obtenirRequete(String code) {
		return requeteDao.findByColumn(code, "code_req", new Requete());

	}
	public Requete obtenirRequeteParId(long id) {
		return requeteDao.findOne(id, new Requete());

	}

	@Transactional(rollbackOn = Exception.class)
	public Requete supprimerRequette(String code) {
		Requete r = obtenirRequete(code);
		if (r != null)
			requeteDao.delete(r.getId(), r);

		return r;
	}

	public List<Map<String, String>> preparData(JsonNode nodParent, String[] col) {
		List<Map<String, String>> listAppParent = new ArrayList<>();

		for (int i = 0; i < nodParent.size(); i++) {

			System.err.println(nodParent.get(i));
			
			Map<String, String> appParantMap = new HashMap<>();
			for(int j=0; j<col.length; j++) {
				JsonNode value=nodParent.get(i);
				appParantMap.put(col[j], value.get(j).asText());
			}
//				appParantMap.put("appName", appName.replace("\"", ""));
//				appParantMap.put("appCountry", country);
//				appParantMap.put("appStoreRating", storeRating);
//				appParantMap.put("appReviewCount", reviewCount);
//				appParantMap.put("appLastUpdate", lastUpdate);
//				appParantMap.put("appMonitoringDate", monitoringDate);
//				appParantMap.put("action", btAction);

			listAppParent.add(appParantMap);
		}
		return listAppParent;

	}

	public List<Object[]> obtenirResultat() {
		Requete req = new Requete("afficher tous les ventes");
		req.setCodeReq("TESTRQ");
		req.setRequetteSql("select * from fait_vente");
		return this.execute(req);
	}

}
