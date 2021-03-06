package com.kmsoft.memoire.interpreteur.dictionnaire;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang3.tuple.Pair;

public class ChargeDictionnaire {

	private static String CHEMIN_DICTIONNAIRE = "dictionnaire_mots.properties";
	private Properties properties;

	public ChargeDictionnaire() {
		super();
		this.properties = new Properties();
	}

	/**
	 * Charger les dictionnaire de mysql dans une liste
	 * paire de SQL:FR
	 * @return liste de paire 
	 */
	public List<Pair<String, String>> chargerMots() {
		List<Pair<String, String>> listeDesMots = new ArrayList<>();
		try (InputStream is = ChargeDictionnaire.class.getClassLoader().getResourceAsStream(CHEMIN_DICTIONNAIRE)) {

			properties.load(is);
			for (Entry<Object, Object> entry : this.properties.entrySet()) {
				listeDesMots.add(Pair.of(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeDesMots;
	}
}
