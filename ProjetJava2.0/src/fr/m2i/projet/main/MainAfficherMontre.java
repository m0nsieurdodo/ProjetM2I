package fr.m2i.projet.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import fr.m2i.projet.DAO.MontreDAO;
import fr.m2i.projet.entities.Montre;

public class MainAfficherMontre {

	static Scanner sc = new Scanner(System.in);


	public static void main(int i) {
		
		MontreDAO c = new MontreDAO();
		//CHOIX POUR AFFIHCER TOUT OU SELON L'ID	
		if(i == 1) {
			afficherTout(c);
		}
		else if (i ==3) {
			System.out.println("Id du produit recherché : ");
			int id = sc.nextInt();
			afficherMontreId(c, id);
		}
		
		
		
		

	}

	//AFFICHAGE PAR ID
	public static void afficherMontreId(MontreDAO c, int id) {
		MontreDAO p;
		try {
			p = c.findById(id);
		
			if (((Montre) p).getMarque() != null) {
			System.out.println(((Montre) p).getMarque().toUpperCase()+ " "+((Montre) p).getModele()+" - "+((Montre) p).getDiametre() +"mm - "+((Montre) p).getPrix() +"€" + " : "+ ((Montre) p).getDescription());
			}else {
				System.out.println("Aucun produit correspondant.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//LISTE DES PRODUITS
	private static void afficherTout(MontreDAO c) {
		
		try {
			List<Montre> mesMontres = c.findAll();
			if(mesMontres.size()!=0) {
			for(MontreDAO p : mesMontres) {
				System.out.println(((Montre) p).getMarque().toUpperCase()+ " "+((Montre) p).getModele()+" - "+((Montre) p).getDiametre() +"mm - "+((Montre) p).getPrix() +"€" + " : "+ ((Montre) p).getDescription());
			}
			}else {
				System.out.println("Aucun produit.");
				}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
