import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Bienvenue sur le Gestionnaire d'Inventaire de produits !");
		Connection connexion = ConnexionDB.connexion();
		
		
		afficherMenu(connexion);
		/*while(true) {
			afficherMenu(connexion);
		}*/
		
	
	}

	private static void afficherMenu(Connection c) {
		System.out.println("****************");
		System.out.printf("Que voulez-vous faire ? %n"
				+ "1. Voir la liste des produits %n"
				+ "2. Ajouter un produit %n");
		System.out.print("Votre choix : ");
		int choix = sc.nextInt();
		System.out.println(choix);
		
		if(choix == 1) {
			voirMontre(c);
		}else if(choix ==2) {
			Produit p =  getProduitFromUser();
			ConnexionDB.ajouterProduit(c,p);
		}else {
			System.out.println("Veuillez choisir un chiffre");
		}
		
	}

	private static void voirMontre(Connection connexion) {
		
		ConnexionDB.selectAll(connexion);
		
	}
	private static Produit getProduitFromUser() {
		Produit produit = new Produit();
		try {
			System.out.println("Marque : ");
			produit.setMarque(sc.next());
			System.out.println("Modele : ");
			produit.setModele(sc.next());
			System.out.println("Diametre (en mm) : ");
			produit.setDiametre(sc.nextDouble());
			System.out.println("Prix : ");
			produit.setPrix(sc.nextDouble());
			System.out.println("Description : ");
			produit.setDescription(sc.next());
	
		}
		catch(RuntimeException e){
			System.out.println("Saisissez à nouveau ");
		}
		return produit;
		
		
	}
	
	

}
