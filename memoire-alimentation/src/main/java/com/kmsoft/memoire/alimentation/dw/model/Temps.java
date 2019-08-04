package com.kmsoft.memoire.alimentation.dw.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Temps extends AbstractEntity{
	
	
	private Date dateTmp;
	private int anneeTmp;
	private int semestreTmp;
	private int trimestreTmp;
	private int moisTmp;
	private String moisNomTmp;
	private int jourTmp;
	private String jourNomTmp;
	
	public Temps() {
		super();
	}

	

	public Date getDateTmp() {
		return dateTmp;
	}

	public void setDateTmp(Date dateTmp) {
		this.dateTmp = dateTmp;
	}

	public Integer getAnneeTmp() {
		return anneeTmp;
	}

	public void setAnneeTmp(int i) {
		this.anneeTmp = i;
	}

	public int getSemestreTmp() {
		return semestreTmp;
	}

	public void setSemestreTmp(int semestreTmp) {
		this.semestreTmp = semestreTmp;
	}

	public int getTrimestreTmp() {
		return trimestreTmp;
	}

	public void setTrimestreTmp(int trimestreTmp) {
		this.trimestreTmp = trimestreTmp;
	}

	public int getMoisTmp() {
		return moisTmp;
	}

	public void setMoisTmp(int moisTmp) {
		this.moisTmp = moisTmp;
	}

	public String getMoisNomTmp() {
		return moisNomTmp;
	}

	public void setMoisNomTmp(String moisNomTmp) {
		this.moisNomTmp = moisNomTmp;
	}

	public int getJourTmp() {
		return jourTmp;
	}

	public void setJourTmp(int jourTmp) {
		this.jourTmp = jourTmp;
	}

	public String getJourNomTmp() {
		return jourNomTmp;
	}

	public void setJourNomTmp(String jourNomTmp) {
		this.jourNomTmp = jourNomTmp;
	}


	@Override
	public String toString() {
		return "Temps [ dateTmp=" + dateTmp + ", anneeTmp=" + anneeTmp + ", semestreTmp=" + semestreTmp
				+ ", trimestreTmp=" + trimestreTmp + ", moisTmp=" + moisTmp + ", moisNomTmp=" + moisNomTmp
				+ ", jourTmp=" + jourTmp + ", jourNomTmp=" + jourNomTmp + "]";
	}


}
