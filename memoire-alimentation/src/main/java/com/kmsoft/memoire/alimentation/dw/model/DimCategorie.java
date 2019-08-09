package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="dim_categorie")
public class DimCategorie {

	@Id
	@SequenceGenerator(name = "seq_id_dim_categorie", sequenceName = "seq_id_dim_categorie", allocationSize = 1)
	@GeneratedValue(generator = "seq_id_dim_categorie", strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	private String codeCat;
	private String nomCat;
	private String descriptionCat;
	
	public DimCategorie() {
		super();
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
