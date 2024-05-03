package fr.m2i.projet.export;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.m2i.projet.DAO.MontreDAO;
import fr.m2i.projet.entities.Montre;

public class MainExporterCSV {
	private static String url = "/Users/marierouge/Documents/Formation Cyber Sécurité/10-TP Développer un projet en java/Projet Java 2.0/bin/fr/m2i/projet/export/montres.csv";
			
	public static void main(String[] args) {
		
		
		List<Montre> mesMontres = new ArrayList<>();
		MontreDAO m = new MontreDAO();
		try {
			 mesMontres = m.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		ExporterCSV.exporterProduits(url, mesMontres);
		
		
	}
	
	
}
