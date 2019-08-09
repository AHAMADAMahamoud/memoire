package com.kmsoft.memoire.requete.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.kmsoft.memoire.requete.model.Requette;

@Component
public class RequetteLoader {

	private static final String DEFAULT_REQUESTE_PATH_FR = "default_request_fr.properties";
	private static final String DEFAULT_REQUESTE_PATH_SQL = "default_request_sql.properties";
	private ArrayList<String> listeRequetteDefault;
	private Properties properties_fr;
	private Properties properties_sql;

	/**
	 * Constructor
	 */
	public RequetteLoader() {
		super();
		listeRequetteDefault = new ArrayList<>();
	}

	@PostConstruct
	private void init() {
		try (InputStream is = RequetteLoader.class.getClassLoader().getResourceAsStream(DEFAULT_REQUESTE_PATH_FR)) {
			properties_fr = new Properties();
			properties_fr.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (InputStream is = RequetteLoader.class.getClassLoader().getResourceAsStream(DEFAULT_REQUESTE_PATH_SQL)) {
			properties_sql = new Properties();
			properties_sql.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Requette> getDefaultRequest() {
		ArrayList<Requette> data = new ArrayList<>();
		int nombreRequette=properties_fr.stringPropertyNames().size();
		for(int i=1; i<=nombreRequette; i++){
			
			Requette r = new Requette();
			r.setCodeR("requette"+i);
			r.setDateInsert(Calendar.getInstance().getTime());
			r.setRequetteFr(properties_fr.getProperty("requette"+i));
			r.setRequetteSql(properties_sql.getProperty("requette"+i));
		
			data.add(r);
		}

		return data;

	}

}