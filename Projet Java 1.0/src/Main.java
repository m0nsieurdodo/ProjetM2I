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
				+ "1. Liste des produits %n"
				+ "2. Ajouter un produit %n"
				+ "3. Trouvez un produit %n"
				+ "4. Modifier un produit %n"
				+ "5. Supprimer un produit %n"
				+ "*************************** %n"
				+ "Votre choix : ");
		
		int res = sc.nextInt();
		System.out.println();
		if(res == 1) {
			MainAfficherMontre.main(1);
		}
		else if (res ==2) {
			MainAjouterMontre.main(null);
		}
		else if( res ==3) {
			
			MainAfficherMontre.main(3);
		}
		else if (res == 4) {
			MainModifierMontre.main(null);
		}
		else if (res == 5) {
			MainSupprimerMontre.main(null);
		}
		
	}
}
