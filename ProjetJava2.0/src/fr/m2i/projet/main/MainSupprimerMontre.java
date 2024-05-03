package fr.m2i.projet.main;

import java.sql.SQLException;
import java.util.Scanner;

import fr.m2i.projet.DAO.MontreDAO;
import fr.m2i.projet.entities.Montre;

public class MainSupprimerMontre {
static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MontreDAO c = new MontreDAO();
		System.out.println("Id du produit à supprimer : ");
		int id = sc.nextInt();
	
	
		Montre m = new Montre();
		
		try {
			m = c.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//AFFICHAGE DES INFOS DU PRODUIT
		MainAfficherMontre.afficherMontreId(c, id);
		//CONFIRMATION
		System.out.println("Etes-vous sûr de vouloir supprimer ce produit ? (Oui/Non)");
		String res = sc.next();
		System.out.println(res);
	
		if(res.equals("oui") || res.equals("Oui")) {
			c.delete(m, id);
			
		// SUPPRESSION	
		}else {
			System.out.println("Suppression annulée.");
		}
		
		
		
		
		
		
	}

}
