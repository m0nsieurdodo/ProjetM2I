
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.printf("Bienvenue sur le Gestionnaire d'Inventaire de Produit ! %n %n");
		
		while(true) {
			menu();
		}
		
	}

	private static void menu() {
		System.out.printf("*************************** %n"
				+ "Que voulez-vous faire ? %n"
				+ "1. Voir la liste des produits %n"
				+ "2. Ajouter un produit %n"
				+ "3. Trouver un produit à partir de l'id %n"
				+ "4. Modifier un produit %n"
				+ "5. Supprimer un produit %n"
				+ "*************************** %n"
				+ "Votre choix : ");
		
		int res = sc.nextInt();
		System.out.println();
		
		switch(res) {
		case 1 :
			MainAfficherMontre.main(1);
			break;
		case 2 :
			MainAjouterMontre.main(null);
			break;
		case 3 :
			MainAfficherMontre.main(3);
			break;
		case 4 :
			MainModifierMontre.main(null);
			break;
		case 5 :
			MainSupprimerMontre.main(null);
			break;
		default :
			System.out.println("Choix incorrect.");
		}
	
		
	}
}
