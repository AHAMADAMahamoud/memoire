package com.kmsoft.memoire.requete.model;

import javax.persistence.Entity;

@Entity
public class Profile extends AbstractEntity {

	private String pseudo;
	private String mpasse;
	private String role;
	
	public Profile() {
		super();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMpasse() {
		return mpasse;
	}

	public void setMpasse(String mpasse) {
		this.mpasse = mpasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Profile [ pseudo=" + pseudo + ", mpasse=" + mpasse + ", role=" + role + "]";
	}

}
