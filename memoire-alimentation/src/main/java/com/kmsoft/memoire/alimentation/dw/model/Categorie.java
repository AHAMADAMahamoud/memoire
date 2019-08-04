package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Entity;

@Entity
public class Categorie extends AbstractEntity{
	
	private String codeCat;
	private String nomCat;
	private String descriptionCat;
	
	public Categorie() {
		super();
	}

	public String getCodeCat() {
		return codeCat;
	}

	public void setCodeCat(String codeCat) {
		this.codeCat = codeCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public String getDescriptionCat() {
		return descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	@Override
	public String toString() {
		return "Categorie [codeCat=" + codeCat + ", nomCat=" + nomCat + ", descriptionCat=" + descriptionCat + "]";
	}

}
