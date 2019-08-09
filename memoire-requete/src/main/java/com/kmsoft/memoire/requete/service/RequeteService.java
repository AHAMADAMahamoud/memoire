package com.kmsoft.memoire.requete.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	@PersistenceContext
	public EntityManager em;

	public String introduireRequete(Requette req) {
		String message = "";
		try {
			message = requeteDao.save(req);
		} catch (Exception e) {

		}
		return message;
	}

	public String introduirePluisieursRequete(ArrayList<Requette> listRequet) {
		String message = "";
		ArrayList<Requette> listRequetToSave = new ArrayList<>();
		for (int i = 0; i < listRequet.size(); i++) {
			Requette r = listRequet.get(i);
			if (!requeteDao.ifExist(r, "where coder='" + r.getCodeR() + "'")) {
				listRequetToSave.add(r);
			}
		}
		try {
			message = requeteDao.saveMany(listRequetToSave);
		} catch (Exception e) {
			message = e.getMessage();
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

	public ArrayList<Requette> recupererLesRequetteParDefaut() {
		return requetteLoader.getDefaultRequest();

	}

	public String chargerDansLaBase() {
		return this.introduirePluisieursRequete(this.recupererLesRequetteParDefaut());
	}

	public Pair<Requette, List<Object[]>> obtenirResultatRequette(long reqId) {
		return this.executeRequette(reqId);

	}

	private Pair<Requette, List<Object[]>> executeRequette(long reqId) {
		Requette req = this.requeteDao.findOne(reqId, new Requette());
		List<Object[]> ol = null;
		if (req != null) {
			ol= this.execute(req);
		}
		return new Pair<Requette, List<Object[]>>(req, ol);

	}

	private List<Object[]> execute(Requette req) {
		@SuppressWarnings("unchecked")
		List<Object[]> o = (List<Object[]>)this.em.createNativeQuery(req.getRequetteSql()).getResultList();
		
		return o;
	}

}
