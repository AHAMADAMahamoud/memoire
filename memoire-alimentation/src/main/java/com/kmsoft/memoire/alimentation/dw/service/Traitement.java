package com.kmsoft.memoire.alimentation.dw.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Traitement {

	public static Date getDateValue(String dateString) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {

		}
		return date;
	}

	public static String getStringValue(String unknownType) {
		String stringValue = "inconnu";
		if (unknownType != null && !"".equals(unknownType)) {
			stringValue = unknownType;
		}

		return stringValue;
	}

	public static int getIntValue(String unknownType) {
		if (unknownType != null && !"".equals(unknownType)) {
			try {
				return Integer.parseInt(unknownType);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
		return 0;
	}

	public static long getLongValue(String unknownType) {
		if (unknownType != null && !"".equals(unknownType)) {
			try {
				return Long.parseLong(unknownType);
			} catch (NumberFormatException e) {
				return 0;
			}
		}
		return 0;
	}

	public static String replaceChar(String strOrigine, String chToReplace, String chUsed) {
		//String stringOK="";
		// chaine en entrée donc pas besoin de l'initialisé
		// attend
		// on parcour la chaine original
//		for (int i = 0; i < strOrigine.length(); i++) {
//			// on verifie si il ya un carracter dans la chaine qui est egal à
//			// chtoreplace
//
//			if (strOrigine.charAt(i) == chToReplace) {
//				stringOK= strOrigine.substring(0, i) + "." + strOrigine.substring(i + 1);
//			}
//		}
//		return stringOK;
		//ça c'est une premièer methode basé sur l'algo ancien de DER
		//avec le decalaghe hhhhhà gauche et à droite par i+1
		
		//mais il ya plus simple et propre que ça en un seul ligne
		
		return strOrigine.replace(chToReplace, chUsed);
	}
}
