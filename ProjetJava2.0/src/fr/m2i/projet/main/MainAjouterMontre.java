package fr.m2i.projet.main;

import java.util.Scanner;

import fr.m2i.projet.DAO.MontreDAO;
import fr.m2i.projet.entities.Montre;

public class MainAjouterMontre {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MontreDAO c = new MontreDAO();
	
		// SAUVEGARDE D'UNE NOUVELLE MONTRE

		c.save(getMontreFromUser(), -1);
		
		
		
	}
	
	public static Montre getMontreFromUser() {
		
		double diam =0;
		String marque;
		String modele;

		double prix;
		String description;
		
		Montre m = new Montre();
		
		
		try {
			//FORMULAIRE UTILISATEUR
			System.out.println("Marque : ");
			marque = sc.nextLine();
			
			System.out.println("Modele : ");
			modele = sc.nextLine();
			
			System.out.println("Diametre (entre 26 et 56mm) : ");
			diam = sc.nextDouble();
			while (26 > diam || diam > 56) {
				System.out.println("Diametre (entre 26 et 56mm) : ");
				diam = sc.nextDouble();
				
			}
	
			System.out.println("Prix : ");
			prix = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Description : ");
			description = sc.nextLine();
			
			//SETTING DE L'OBJET
			m.setMarque(marque);
			m.setModele(modele);
			m.setDiametre(diam);
			m.setPrix(prix);
			m.setDescription(description);
	
		}
		catch(RuntimeException e){
			System.out.println("Saisissez à nouveau ");
		}
		return m;
		
		
	}

}
