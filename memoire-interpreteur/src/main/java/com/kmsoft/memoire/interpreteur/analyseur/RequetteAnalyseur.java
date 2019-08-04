package com.kmsoft.memoire.interpreteur.analyseur;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.kmsoft.memoire.interpreteur.dictionnaire.ChargeDictionnaire;

public class RequetteAnalyseur {

	/**
	 * Permet de decouper une requette
	 * 
	 * @param requetteFr
	 * @return les mot decoupé sous forme tableau
	 */
	public String[] motsRequette(String requetteFr) {
		String[] mots = null;
		if (requetteFr != null) {
			return requetteFr.trim().split(" ");
		}
		return mots;

	}

	public List<String> findEquivalanceMots(String requetteFr) {
		List<String> motsRequette = new ArrayList<>();
		String[] mots=this.motsRequette(requetteFr);
		List<String> lesTables=this.listeDesTables();
		
		
		if (mots.length != 0) {
			ChargeDictionnaire charge = new ChargeDictionnaire();
			List<Pair<String, String>> dictionaire = charge.chargerMots();
			for (String mot : mots) {
				
				for (Pair<String, String> couplemotsDansDico : dictionaire) {
					if (mot.equals(couplemotsDansDico.getRight())) {
						motsRequette.add(couplemotsDansDico.getLeft());
					}
				}
				
			}
			
			for(String mot: mots){
				for(String table:lesTables){
					if(table.equalsIgnoreCase(mot)){
						motsRequette.add(table);
					}else if(mot.charAt(mot.length()-1)=='s'||mot.charAt(mot.length()-1)=='S'){
						if(table.equalsIgnoreCase(mot.substring(0, mot.length()-1))){
							motsRequette.add(table);
						}
					}
				}
			}
		}
		return motsRequette;
	}

	private List<String> listeDesTables(){
		List<String> tables=new ArrayList<>();
		tables.add("article");
		tables.add("categorie");
		tables.add("geographie");
		tables.add("temps");
		tables.add("vente");
		return tables;
		
	}
	public void mettreLesMotsEnordre( List<String> mots) {
		// on aura ici la liste des syntaxes
		// FROM SELECT COUNT

		// select count() from

		// maham//sucre, pain, lait : vendredi
		// ali//couche,pain, lait: vendredi
		// mohamed//lait,vetementbebe, xxxx vendredi

		// omega:ensemble des individus =8~9
		// poid:sucre:1 pain:2 lait:3
		// alpah(sucre)=poidx100/omega =1 * 100 /9
		// alpha(pain)=22.2% (5)=P
		// lait(pain)=33.3% (5)=P
		//
		// String s= new String("salut");
		// string s=changeString(s);
		// system.(s)

		//

		//

	}
}
