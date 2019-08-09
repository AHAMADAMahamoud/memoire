package com.kmsoft.memoire.alimentation.dw.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.memoire.alimentation.dw.model.DimArticle;
import com.kmsoft.memoire.alimentation.dw.model.DimCategorie;
import com.kmsoft.memoire.alimentation.dw.model.DimGeographie;
import com.kmsoft.memoire.alimentation.dw.model.DimTemps;
import com.kmsoft.memoire.alimentation.dw.model.FaitVente;
import com.kmsoft.memoire.alimentation.dw.repository.AbstractRepository;

@Service
public class Extractor {
	/**
	 * Moteur d'extraction et de traitement des données sources
	 */

	@Autowired
	private AbstractRepository<DimArticle> articleRepository;
	@Autowired
	private AbstractRepository<DimTemps> tempsRepository;

	@Autowired
	private AbstractRepository<DimGeographie> geographieRepository;
	@Autowired
	private AbstractRepository<DimCategorie> categorieRepository;

	public List<DimTemps> runETLforDimTemps(String dimTempsCsvFile) {
		final File csvDonnees = new File(dimTempsCsvFile);
		final CSVParser parser;
		final List<DimTemps> dimTempsDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvDonnees, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord leslignes : parser) {
				final String[] lescolonnes = leslignes.get(0).split(";");
				if (!lescolonnes[0].startsWith("PK")) {

					DimTemps dimTemps = new DimTemps();
					dimTemps.setId(Traitement.getIntValue(lescolonnes[0]));
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
	public List<DimArticle> runETLforDimArticles(String dimArticleCsvFile) {
		final File csvData = new File(dimArticleCsvFile);
		final CSVParser parser;
		final List<DimArticle> dimArticleDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				final String[] lesLignes = csvRecord.get(0).split(";");
				try {
					if (!lesLignes[0].startsWith("PK")) {
						DimArticle dimArticle = new DimArticle();
						dimArticle.setCodeArt(Traitement.getStringValue(lesLignes[1]));
						dimArticle.setDesignationArt(Traitement.getStringValue(lesLignes[2]));
						dimArticle.setPrixVente(Traitement.getIntValue(lesLignes[3]));
						StringBuilder sb = new StringBuilder();
						sb.append(" where codeart = '").append(dimArticle.getCodeArt().replaceAll("'", "''"))
								.append("'");
						String close = sb.toString();
						if (!articleRepository.ifExist(dimArticle, close))
							dimArticleDataSource.add(dimArticle);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out
							.println("Lignes introuvable : " + lesLignes[0] + " " + lesLignes[2] + "," + lesLignes[3]);

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
			return dimArticleDataSource;
		}
		return dimArticleDataSource;
	}

	public List<DimGeographie> runETLforDimGeographie(String dimGeographieCsvFile) {
		final File csvData = new File(dimGeographieCsvFile);
		final CSVParser parser;
		final List<DimGeographie> dimGeographieDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				final String[] lesLignes = csvRecord.get(0).split(";");
				try {
					if (!lesLignes[0].startsWith("code")) {
						DimGeographie dimGeographie = new DimGeographie();
						dimGeographie.setCodeGeo(Traitement.getStringValue(lesLignes[0]));
						dimGeographie.setIleGeo(Traitement.getStringValue(lesLignes[1]));
						dimGeographie.setVilleGeo(Traitement.getStringValue(lesLignes[2]));
						StringBuilder sb = new StringBuilder();
						sb.append(" where codegeo= '").append(dimGeographie.getCodeGeo()).append("'");
						String close = sb.toString();
						if (!geographieRepository.ifExist(dimGeographie, close))
							dimGeographieDataSource.add(dimGeographie);
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Cette ligne est incorrect, on passe à la ligne suivante");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return dimGeographieDataSource;
		}
		return dimGeographieDataSource;
	}

	public List<DimCategorie> runETLforDimCategorie(String dimCategorieCsvFile) {
		final File csvData = new File(dimCategorieCsvFile);
		final CSVParser parser;
		final List<DimCategorie> dimCategoreiDataSource = new ArrayList<>();
		try {
			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				try {
					final String[] lesLignes = csvRecord.get(0).split(";");
					if (!lesLignes[0].startsWith("PK")) {
						DimCategorie dimCategorie = new DimCategorie();
						dimCategorie.setCodeCat(Traitement.getStringValue(lesLignes[1]));
						dimCategorie.setNomCat(Traitement.getStringValue(lesLignes[2]));
						dimCategorie.setDescriptionCat(Traitement.getStringValue(lesLignes[3]));
						StringBuilder sb = new StringBuilder();
						sb.append(" where codecat = '").append(dimCategorie.getCodeCat().replaceAll("'", "''"))
								.append("'");
						String close = sb.toString();
						if (!categorieRepository.ifExist(dimCategorie, close))
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

	public List<FaitVente> runETLforDimVente(String dimVenetCsvFile) {
		final File csvData = new File(dimVenetCsvFile);
		final CSVParser parser;
		final List<FaitVente> dimVenteDataSource = new ArrayList<>();
		try {

			parser = CSVParser.parse(csvData, StandardCharsets.ISO_8859_1, CSVFormat.EXCEL);
			for (CSVRecord csvRecord : parser) {
				final String[] lesLignes = csvRecord.get(0).split(";");
				if (!lesLignes[0].startsWith("PK")) {
					FaitVente dimVente = new FaitVente();
					int idArt = Traitement.getIntValue(lesLignes[1]);
					int idCat = Traitement.getIntValue(lesLignes[3]);
					int idGeo = Traitement.getIntValue(lesLignes[2]);
					int idTmp = Traitement.getIntValue(lesLignes[4]);

					int pkArt = this.findPK_Art(idArt);
					int pkCat = this.findPK_Cat(idCat);
					int pkGeo = this.findPK_Geo(idGeo);
					int pkTmp = this.findPK_Tmp(idTmp);

					dimVente.setPkArt(pkArt);
					dimVente.setPkCat(pkCat);
					dimVente.setPkGeo(pkGeo);
					dimVente.setPkTmp(pkTmp);
					dimVente.setMontantVente(Traitement.getIntValue(lesLignes[7]));
					dimVenteDataSource.add(dimVente);
				}

			}
		} catch (IOException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return dimVenteDataSource;
		}
		return dimVenteDataSource;
	}

	private int findPK_Art(int idArt) {
		DimArticle art = articleRepository.findByColumn(String.valueOf(idArt), "codeart",  new DimArticle());
		if (art != null)
			return art.getId();
		return 0;
	}

	private int findPK_Cat(int idCat) {
		DimCategorie cat = categorieRepository.findByColumn(String.valueOf(idCat), "codecat", new DimCategorie());
		if (cat != null)
			return cat.getId();
		return 0;
	}

	private int findPK_Geo(int idGeo) {
		DimGeographie geo = geographieRepository.findByColumn(String.valueOf(idGeo), "codegeo", new DimGeographie());
		if (geo != null)
			return geo.getId();
		return 0;
	}

	private int findPK_Tmp(int idTmp) {
		DimTemps tmp = tempsRepository.findOneTmp(idTmp, new DimTemps());//findByColumn(String.valueOf(idTmp), "id", new DimTemps());
		if (tmp != null)
			return tmp.getId();
		return 0;
	}

}
