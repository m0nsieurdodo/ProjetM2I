import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
		Montre p;
		try {
			p = c.findById(id);
			System.out.println(p.getMarque().toUpperCase()+ " "+p.getModele()+" - "+p.getDiametre() +"mm - "+p.getPrix() +"€" + " : "+ p.getDescription());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//LISTE DES PRODUITS
	private static void afficherTout(MontreDAO c) {
		
		try {
			List<Montre> mesMontres = c.findAll();
			for(Montre p : mesMontres) {
				System.out.println(p.getMarque().toUpperCase()+ " "+p.getModele()+" - "+p.getDiametre() +"mm - "+p.getPrix() +"€" + " : "+ p.getDescription());
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
