import java.sql.SQLException;
import java.util.Scanner;

public class MainModifierMontre {

	static Scanner sc = new Scanner(System.in);
	
	//MODIFIER UN PRODUIT EXISTANT
	public static void main(String[] args) {
		
		System.out.println("Quel produit voulez-vous modifier ?");
		
		int id = sc.nextInt();
		
		MontreDAO c = new MontreDAO();
		Montre m = new Montre();
		
		
		try {
			c.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//AFFICHAGE DES INFOS DU PRODUIT
		MainAfficherMontre.afficherMontreId(c, id);
		//RECUPERATION DES MODIFICATIONS DE L'UTILISATEUR
		m = MainAjouterMontre.getMontreFromUser();
		//SAUVEGARDE DANS LA BDD
		c.save(m, id);
		
		
	
	}
	
}
