package com.kmsoft.memoire.requete.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity
public class Requete extends AbstractEntity {

	@Column(name = "code_req")
	private String codeReq;
	
	@Column(name = "date_insert")
	private Date dateInsert;
	
	@Column(name = "date_converti")
	private Date dateConverti;
	
	@Column(name = "date_execution")
	private Date dateExecution;
	
	
    @Column(name = "resultat", columnDefinition = "jsonb")
	private String resultat;
	
	@Column(name="requette_sql", length = 500)
	private String requetteSql;
	
	@Column(name="requette_fr",length = 500)
	private String requetteFr;
	
	@Column(name = "etat_req")
	private String etatReq;

	public Requete() {
	}

	public Requete(String requetteFr) {
		this.requetteFr = requetteFr;
	}

	public String getCodeReq() {
		return codeReq;
	}

	public void setCodeReq(String codeReq) {
		this.codeReq = codeReq;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
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

	public String getEtatReq() {
		return etatReq;
	}

	public void setEtatReq(String etatReq) {
		this.etatReq = etatReq;
	}

	@Override
	public String toString() {
		return "Requete [codeReq=" + codeReq + ", dateInsert=" + dateInsert + ", dateConverti=" + dateConverti
				+ ", dateExecution=" + dateExecution + ", resultat=" + resultat + ", requetteSql=" + requetteSql
				+ ", requetteFr=" + requetteFr + ", etatReq=" + etatReq + "]";
	}

	

}
