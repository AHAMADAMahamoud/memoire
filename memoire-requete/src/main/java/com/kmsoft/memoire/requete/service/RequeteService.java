package com.kmsoft.memoire.requete.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.requete.repository.AbstractRepository;
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

	private List<Object[]> execute(Requete req) {
		@SuppressWarnings("unchecked")
		List<Object[]> o = (List<Object[]>) this.em.createNativeQuery(req.getRequetteSql()).getResultList();

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
			}else {
				Requete r_up=obtenirRequete(r.getCodeReq());
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
	return	requeteDao.findByColumn(code, "code_req", new Requete());

	}

}
