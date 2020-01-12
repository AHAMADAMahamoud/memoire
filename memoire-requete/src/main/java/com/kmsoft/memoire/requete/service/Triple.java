package com.kmsoft.memoire.requete.service;

public class Triple<G,M,D> {
	
	private final G requete;
	private final D resultat;
	private final M resultatJSON;
	
	
	public Triple(G requete, M resultatJSON, D resultat) {
		super();
		this.requete = requete;
		this.resultat = resultat;
		this.resultatJSON = resultatJSON;
	}
	public G getRequete() {
		return requete;
	}
	public D getResultat() {
		return resultat;
	}
	public M getResultatJSON() {
		return resultatJSON;
	}

	

}
