package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="fait_vente")
public class FaitVente  {

	@Id
	@SequenceGenerator(name = "seq_id_fait_vente", sequenceName = "seq_id_fait_vente", allocationSize = 1)
	@GeneratedValue(generator = "seq_id_fait_vente", strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	private int pkArt;
	private int pkCat;
	private int pkGeo;
	private int pkTmp;
	private int montantVente;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPkArt() {
		return pkArt;
	}
	public void setPkArt(int pkArt) {
		this.pkArt = pkArt;
	}
	public int getPkCat() {
		return pkCat;
	}
	public void setPkCat(int pkCat) {
		this.pkCat = pkCat;
	}
	
	public int getPkGeo() {
		return pkGeo;
	}
	public void setPkGeo(int pkGeo) {
		this.pkGeo = pkGeo;
	}
	public int getPkTmp() {
		return pkTmp;
	}
	public void setPkTmp(int pkTmp) {
		this.pkTmp = pkTmp;
	}
	
	public int getMontantVente() {
		return montantVente;
	}
	public void setMontantVente(int montantVente) {
		this.montantVente = montantVente;
	}
	
}
