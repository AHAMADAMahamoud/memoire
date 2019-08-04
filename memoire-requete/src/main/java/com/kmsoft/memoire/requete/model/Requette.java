package com.kmsoft.memoire.requete.model;

import javax.persistence.Entity;

@Entity
public class Requette extends AbstractEntity {

	private String poids;
	private String dateIntro;
	private String dateConverti;
	private String dateExecution;
	private String dateResultat;
	private String formatAffichage;
	private String requetteSql;
	private String requetteFr;
	private String etat;

	public Requette() {
	}

	public Requette(String requetteFr) {
		this.requetteFr = requetteFr;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getDateConverti() {
		return dateConverti;
	}

	public void setDateConverti(String dateConverti) {
		this.dateConverti = dateConverti;
	}

	public String getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(String dateExecution) {
		this.dateExecution = dateExecution;
	}

	public String getDateResultat() {
		return dateResultat;
	}

	public void setDateResultat(String dateResultat) {
		this.dateResultat = dateResultat;
	}

	public String getFormatAffichage() {
		return formatAffichage;
	}

	public void setFormatAffichage(String formatAffichage) {
		this.formatAffichage = formatAffichage;
	}

	public String getDateIntro() {
		return dateIntro;
	}

	public void setDateIntro(String dateIntro) {
		this.dateIntro = dateIntro;
	}

	public String getRequetteFr() {
		return requetteFr;
	}

	public void setRequetteFr(String commande) {
		this.requetteFr = commande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Requette [poids=" + poids + ", dateIntro=" + dateIntro + ", dateConverti=" + dateConverti
				+ ", dateExecution=" + dateExecution + ", dateResultat=" + dateResultat + ", formatAffichage="
				+ formatAffichage + ", requetteSql=" + requetteSql + ", requetteFr=" + requetteFr + ", etat=" + etat
				+ "]";
	}

}
