package com.kmsoft.memoire.alimentation.dw.model;

import javax.persistence.Entity;

@Entity
public class Vente extends AbstractEntity {

	private int pkArt;
	private int pkCat;
	private int pkGeo;
	private int pkTmp;
	private int prixVenteUt;
	private int quantiteVent;
	private int montantVente;
	
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
	public int getPrixVenteUt() {
		return prixVenteUt;
	}
	public void setPrixVenteUt(int prixVenteUt) {
		this.prixVenteUt = prixVenteUt;
	}
	public int getQuantiteVent() {
		return quantiteVent;
	}
	public void setQuantiteVent(int quantiteVent) {
		this.quantiteVent = quantiteVent;
	}
	public int getMontantVente() {
		return montantVente;
	}
	public void setMontantVente(int montantVente) {
		this.montantVente = montantVente;
	}
	
}
