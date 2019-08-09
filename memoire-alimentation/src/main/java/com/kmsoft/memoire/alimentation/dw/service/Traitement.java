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
		return strOrigine.replace(chToReplace, chUsed);
	}
}
