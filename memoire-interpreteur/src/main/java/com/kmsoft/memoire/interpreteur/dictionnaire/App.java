package com.kmsoft.memoire.interpreteur.dictionnaire;

import java.util.List;

import com.kmsoft.memoire.interpreteur.analyseur.RequetteAnalyseur;


public class App {
	public static void main(String[] args) {
		RequetteAnalyseur cDico = new RequetteAnalyseur();
		List<String> list = cDico.findEquivalanceMots("Afficher le chiffre d'affaire de l'année précédente");	
		System.out.println(cDico.getRequest(list));
	}
}
