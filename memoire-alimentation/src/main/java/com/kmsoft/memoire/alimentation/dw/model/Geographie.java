package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Entity;

@Entity
public class Geographie extends AbstractEntity{
	
	private String ileGeo;
	private String villeGeo;
	private int prixVente;
	
	public Geographie() {
		super();
	}

	public String getIleGeo() {
		return ileGeo;
	}

	public void setIleGeo(String ileGeo) {
		this.ileGeo = ileGeo;
	}

	public String getVilleGeo() {
		return villeGeo;
	}

	public void setVilleGeo(String villeGeo) {
		this.villeGeo = villeGeo;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	@Override
	public String toString() {
		return "Geographie [ileGeo=" + ileGeo + ", villeGeo=" + villeGeo + ", prixVente=" + prixVente + "]";
	}

	

}
