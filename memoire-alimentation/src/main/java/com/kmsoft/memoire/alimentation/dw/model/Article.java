package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Entity;


@Entity(name="article")
public class Article extends AbstractEntity{
	
	private String codeArt;
	private String designationArt;
	private int prixVente;
	
	public Article() {
		super();
	}

	public String getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(String codeArt) {
		this.codeArt = codeArt;
	}

	public String getDesignationArt() {
		return designationArt;
	}

	public void setDesignationArt(String designationArt) {
		this.designationArt = designationArt;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	@Override
	public String toString() {
		return "Article [codeArt=" + codeArt + ", designationArt=" + designationArt + ", prixVente=" + prixVente
				+ "]";
	}



}
