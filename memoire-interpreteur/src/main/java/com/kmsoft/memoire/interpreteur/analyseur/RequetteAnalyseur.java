package com.kmsoft.memoire.interpreteur.analyseur;

import java.util.ArrayList;
import java.util.Arrays;
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
		String[] mots=this.motsRequette(netoyerRequete(requetteFr));
		List<String> lesTables=this.listeDesTables();
		
		
		if (mots.length != 0) {
			ChargeDictionnaire charge = new ChargeDictionnaire();
			List<Pair<String, String>> dictionaire = charge.chargerMots();
			for (String mot : mots) {
				
				for (Pair<String, String> couplemotsDansDico : dictionaire) {
					if (mot.equalsIgnoreCase(couplemotsDansDico.getRight())) {
						motsRequette.add(couplemotsDansDico.getLeft());
						break;
					}
				}
				
			}
			
			for(String mot: mots){
				for(String table:lesTables){
					if(mot.toLowerCase().contains(table.toLowerCase())){
						
						motsRequette.add(new StringBuilder("FROM ").append(table).toString());
						break;
					}
				}
			}
		}
		return motsRequette;
	}

	private String netoyerRequete(String requetteFr) {
		for(String mot:requetteFr.split(" ")) {
			if(getMotsNonUtiliser().contains(mot)) {
				return new String(requetteFr.replaceFirst(mot, "").replace("  ", " "));
			}
		}
		return requetteFr;
		
	}

	private List<String> getMotsNonUtiliser() {
		String[] mots= {"le", "la", "les","de", "des"};
		return Arrays.asList(mots);
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

	public String getRequest(List<String> list) {
		StringBuilder request = new StringBuilder();
		for (String mot : list) {
			request.append(mot).append(" ");
		}
		request = new StringBuilder(request.toString().trim()).append(";");
		return request.toString();
		
	}
}
