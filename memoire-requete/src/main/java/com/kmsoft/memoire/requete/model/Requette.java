package com.kmsoft.memoire.requete.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Requette extends AbstractEntity {

	private String codeR;
	private Date dateInsert;
	private Date dateConverti;
	private Date dateExecution;
	private String resultat;
	@Column(length = 500)
	private String requetteSql;
	@Column(length = 500)
	private String requetteFr;
	private String etat;

	public Requette() {
	}

	public Requette(String requetteFr) {
		this.requetteFr = requetteFr;
	}

	public String getCodeR() {
		return codeR;
	}

	public void setCodeR(String string) {
		this.codeR = string;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date date) {
		this.dateInsert = date;
	}

	public Date getDateConverti() {
		return dateConverti;
	}

	public void setDateConverti(Date dateConverti) {
		this.dateConverti = dateConverti;
	}

	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getRequetteSql() {
		return requetteSql;
	}

	public void setRequetteSql(String requetteSql) {
		this.requetteSql = requetteSql;
	}

	public String getRequetteFr() {
		return requetteFr;
	}

	public void setRequetteFr(String requetteFr) {
		this.requetteFr = requetteFr;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Requette [codeR=" + codeR + ", dateInsert=" + dateInsert + ", dateConverti=" + dateConverti
				+ ", dateExecution=" + dateExecution + ", resultat=" + resultat + ", requetteSql=" + requetteSql
				+ ", requetteFr=" + requetteFr + ", etat=" + etat + "]";
	}

}
