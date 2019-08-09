package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "dim_article")
public class DimArticle {

	@Id
	@SequenceGenerator(name = "seq_id_dim_article", sequenceName = "seq_id_dim_article", allocationSize = 1)
	@GeneratedValue(generator = "seq_id_dim_article", strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;

	private String codeArt;
	private String designationArt;
	private int prixVente;

	public DimArticle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Article [codeArt=" + codeArt + ", designationArt=" + designationArt + ", prixVente=" + prixVente + "]";
	}

	public boolean equals(DimArticle article) {
		return this.getCodeArt().equals(article.getCodeArt())
				&& this.getDesignationArt().equals(article.getDesignationArt());
	}

}
