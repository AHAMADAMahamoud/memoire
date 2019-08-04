/**
 * 
 */
package com.kmsoft.memoire.requete.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.kmsoft.memoire.requete.model.Requette;

@Component
public class RequetteLoader {

	private static final String DEFAULT_REQUESTE_PATH = "default_request_fr.properties";
	private ArrayList<String> listeRequetteDefault;
	private Properties properties;

	/**
	 * Constructor
	 */
	public RequetteLoader() {
		super();
		listeRequetteDefault=new ArrayList<>();
	}

	@PostConstruct
	private void init() {
		try (InputStream is = RequetteLoader.class.getClassLoader().getResourceAsStream(DEFAULT_REQUESTE_PATH)) {
			properties = new Properties();
			properties.load(is);
			
			for (String key : properties.stringPropertyNames()) {
	            String value = properties.getProperty(key);
	            listeRequetteDefault.add(value);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Requette> getDefaultRequest(){
		ArrayList<Requette> data = new ArrayList<>();
		for (String requetteFr : listeRequetteDefault) {
			data.add(new Requette(requetteFr));
		}
		return data;
		
	}
	
}