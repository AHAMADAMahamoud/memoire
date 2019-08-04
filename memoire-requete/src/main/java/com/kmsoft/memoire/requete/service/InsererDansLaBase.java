//package com.kmsoft.memoire.requete.service;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class InsererDansLaBase {
//
//	Connection conn = null;
//
//	
//	public InsererDansLaBase() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	/** on cree la requete */
//
//		String insertString = "select CODEPRET FROM prets";
//		Statement stmt = conn.createStatement();
//		ResultSet rset = stmt.executeQuery(insertString);
//
//		
//		
////		if (rset.next()) {
////
////			while (rset.next()) {
////				/** on insere dans la ComboBox */
////			//	jComboBox1.addItem(rset.getString("CODEPRET"));
////			}
////		}
////	
//	/** on ferme la connexion */
////	conn.close();
//}
