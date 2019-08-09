package com.kmsoft.memoire.requete.service;

public class Pair<L, R> {

	private final L requete;
	private final R resultat;

	public Pair(L requete, R resultat) {
		this.requete = requete;
		this.resultat = resultat;
	}

	public L getRequete() {
		return requete;
	}

	public R getResultat() {
		return resultat;
	}

	@Override
	public int hashCode() {
		return requete.hashCode() ^ resultat.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair))
			return false;
		Pair pairo = (Pair) o;
		return this.requete.equals(pairo.getRequete()) && this.resultat.equals(pairo.getResultat());
	}
}