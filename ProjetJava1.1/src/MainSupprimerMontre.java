
import java.sql.SQLException;
import java.util.Scanner;

public class MainSupprimerMontre {
static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MontreDAO c = new MontreDAO();
		System.out.println("Id du produit à supprimer : ");
		int id = sc.nextInt();
	
	
		
		
		try {
			c.findById(id);
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
			c.delete(c, id);
			
			
		}else {
			System.out.println("Suppression annulée.");
		}
		// SUPPRESSION	
		
		
		
		
		
	}

}
