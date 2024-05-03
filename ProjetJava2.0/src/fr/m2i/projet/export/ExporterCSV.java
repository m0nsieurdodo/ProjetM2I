package fr.m2i.projet.export;

import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVWriter;

import fr.m2i.projet.DAO.MontreDAO;
import fr.m2i.projet.entities.Montre;


public class ExporterCSV {
	
	
	public static void exporterProduits(String url, List<Montre> montres) {
		  // create FileWriter object with file as parameter 
        FileWriter outputfile;
		try {
			outputfile = new FileWriter(url);
			
			CSVWriter writer = new CSVWriter(outputfile); 
			  
	        // adding header to csv 
	        String[] header = { "Marque", "Modele", "Diametre", "Prix", "Description" }; 
	        writer.writeNext(header);
	      
	  
	        // closing writer 
				
				

				
	        ArrayList<String> list = new ArrayList<>();
	       int i = 0;
	       
				for(Montre m : montres) {
					String[] montre= {};
					System.out.println(m.getMarque());
					 list.add(m.getMarque());
					 list.add(m.getModele());
					 list.add(Double.toString(m.getDiametre()));
					 list.add(Double.toString(m.getPrix()));
					 list.add(m.getDescription());
					 
					 
					//montre.add(m.getMarque());
					//montre[0]=m.getMarque();
					montre[1]=m.getModele();
					montre[2]=m.getDiametre()+"";
					montre[3]=Double.toString(m.getPrix());
					montre[4]=m.getDescription();
					String[] newArray = list.toArray(new String[i]);
					writer.writeNext(montre); 
					i++;
					
				}
				writer.close();
				System.out.println("Fichier créé avec les données nécessaires ...");
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
  
        // create CSVWriter object filewriter object as parameter 
        
			//dos.writeAll(list);
			
			

				
		
	}
	
	
}
