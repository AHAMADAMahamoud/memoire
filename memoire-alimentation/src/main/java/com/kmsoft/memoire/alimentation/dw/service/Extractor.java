package com.kmsoft.memoire.alimentation.dw.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.alimentation.dw.model.Article;
import com.kmsoft.memoire.alimentation.dw.model.Categorie;
import com.kmsoft.memoire.alimentation.dw.model.Geographie;
import com.kmsoft.memoire.alimentation.dw.model.Temps;
import com.kmsoft.memoire.alimentation.dw.model.Vente;

@Service
public class Extractor {
	/**
	 * Moteur d'extraction et de traitement des données sources
	 */
	public List<Temps> runETLforDimTemps(String dimTempsCsvFile) {
		final File csvDonnees = new File(dimTempsCsvFile);
		final CSVParser parser;
		final List<Temps> dimTempsDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvDonnees, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord leslignes : parser) {
				final String[] lescolonnes = leslignes.get(0).split(";");
				if (!lescolonnes[0].startsWith("PK")) {

					Temps dimTemps = new Temps();
					dimTemps.setId(Traitement.getLongValue(lescolonnes[0]));
					dimTemps.setDateTmp(Traitement.getDateValue(lescolonnes[1]));
					dimTemps.setAnneeTmp(Traitement.getIntValue(lescolonnes[2]));
					dimTemps.setSemestreTmp(Traitement.getIntValue(lescolonnes[3]));
					dimTemps.setTrimestreTmp(Traitement.getIntValue(lescolonnes[4]));
					dimTemps.setMoisTmp(Traitement.getIntValue(lescolonnes[5]));
					dimTemps.setMoisNomTmp(Traitement.getStringValue(lescolonnes[6]));
					dimTemps.setJourTmp(Traitement.getIntValue(lescolonnes[7]));
					dimTemps.setJourNomTmp(Traitement.getStringValue(lescolonnes[8]));
					dimTempsDataSource.add(dimTemps);
				}

			}
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return dimTempsDataSource;
		}
		return dimTempsDataSource;
	}

	/**
	 * Extract Traitment and LoadData dimArticle data from Csv file
	 */
	public List<Article> runETLforDimArticles(String dimArticleCsvFile) {
		final File csvData = new File(dimArticleCsvFile);
		final CSVParser parser;
		final List<Article> dimArticleDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				final String[] lesLignes = csvRecord.get(0).split(";");
				try {
					if (!lesLignes[0].startsWith("PK")) {
						Article dimArticle = new Article();
						dimArticle.setId(Traitement.getLongValue(lesLignes[0]));
						dimArticle.setCodeArt(Traitement.getStringValue(lesLignes[1]));
						dimArticle.setDesignationArt(Traitement.getStringValue(lesLignes[2]));
						dimArticle.setPrixVente(Traitement.getIntValue(lesLignes[3]));
						dimArticleDataSource.add(dimArticle);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Lignes introuvable : " + lesLignes[0]+ " "+lesLignes[2]+","+lesLignes[3]);
					
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return dimArticleDataSource;
		}
		return dimArticleDataSource;
	}

	public List<Geographie> runETLforDimGeographie(String dimGeographieCsvFile) {
		final File csvData = new File(dimGeographieCsvFile);
		final CSVParser parser;
		final List<Geographie> dimGeographieDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				final String[] lesLignes = csvRecord.get(0).split(";");
				try {
					if (!lesLignes[0].startsWith("PK")) {
						Geographie dimGeographie = new Geographie();
						dimGeographie.setId(Traitement.getLongValue(csvRecord.get(0)));
						dimGeographie.setIleGeo(Traitement.getStringValue(csvRecord.get(1)));
						dimGeographie.setVilleGeo(Traitement.getStringValue(csvRecord.get(2)));
						dimGeographie.setPrixVente(Traitement.getIntValue(csvRecord.get(3)));
						dimGeographieDataSource.add(dimGeographie);
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("CEtte ligne est incorrect, on passe à la ligne suivante");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return dimGeographieDataSource;
		}
		return dimGeographieDataSource;
	}

	public List<Categorie> runETLforDimCategorie(String dimCategorieCsvFile) {
		final File csvData = new File(dimCategorieCsvFile);
		final CSVParser parser;
		final List<Categorie> dimCategoreiDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				try {
					final String[] lesLignes = csvRecord.get(0).split(";");
					if (!lesLignes[0].startsWith("PK")) {
						Categorie dimCategorie = new Categorie();
						dimCategorie.setId(Traitement.getLongValue(lesLignes[0]));
						dimCategorie.setCodeCat(Traitement.getStringValue(lesLignes[1]));
						dimCategorie.setNomCat(Traitement.getStringValue(lesLignes[2]));
						dimCategorie.setDescriptionCat(Traitement.getStringValue(lesLignes[3]));
						dimCategoreiDataSource.add(dimCategorie);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("ligne defaillant");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return dimCategoreiDataSource;
		}
		return dimCategoreiDataSource;
	}

	public List<Vente> runETLforDimVente(String dimVenetCsvFile){
		final File csvData = new File(dimVenetCsvFile);
		final CSVParser parser;
		final List<Vente> dimVenteDataSource = new ArrayList<>();
		try {
			
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				final String[] lesLignes = csvRecord.get(0).split(";");
				if (!lesLignes[0].startsWith("PK")) {
					Vente dimVente = new Vente();
					dimVente.setId(Traitement.getLongValue(lesLignes[0]));
					dimVente.setPkArt(Traitement.getIntValue(lesLignes[1]));
					dimVente.setPkCat(Traitement.getIntValue(lesLignes[2]));
					dimVente.setPkGeo(Traitement.getIntValue(lesLignes[3]));
					dimVente.setPkTmp(Traitement.getIntValue(lesLignes[4]));
					dimVente.setPrixVenteUt(Traitement.getIntValue(lesLignes[5]));
					dimVente.setQuantiteVent(Traitement.getIntValue(lesLignes[6]));
					dimVente.setMontantVente(Traitement.getIntValue(lesLignes[7]));
					dimVenteDataSource.add(dimVente);
				}

			}
		} catch (IOException  e) {
			e.printStackTrace();
			return dimVenteDataSource;
		}
		return dimVenteDataSource;
	}
}
