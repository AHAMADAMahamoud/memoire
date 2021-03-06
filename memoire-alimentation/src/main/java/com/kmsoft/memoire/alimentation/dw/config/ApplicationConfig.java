package com.kmsoft.memoire.alimentation.dw.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:fichier_des_constants.properties")
@Import(JpaConfig.class)
public class ApplicationConfig {

	@Value("${dossier_fichier_chargement}")
	private String dossier;
	
	@Value("${extension_authorise}")
	private String extensionAuthorise;

	public String getDossier() {
		return dossier;
	}
	
	
	public List<String> getextensionAuthorise() {
		return Arrays.asList(extensionAuthorise.split(","));
	}
	
}