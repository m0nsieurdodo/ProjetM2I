

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnexionDB {

	private static Scanner sc = new Scanner(System.in);
	private static final String URL ="jdbc:mysql://localhost:3306/GIP?useSSL=false&serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String PSW = "root";
	
	
	//CONNEXION À LA BDD
	public static Connection connexion() {
		try {
			Connection connexion = DriverManager.getConnection(URL, LOGIN, PSW);
			
			System.out.println("Connecté à la base de données ! ");
			return connexion;}
			
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	//INSERER UN PRODUIT
	public static void ajouterProduit(Connection connexion, Produit produit) {
		
		PreparedStatement ps;
		
		try {
			ps = connexion.prepareStatement("INSERT INTO montre(marque, modele, diametre, prix, description) VALUES (?,?,?,?,?)");
			ps.setString(1, produit.getMarque());
			ps.setString(2, produit.getModele());
			ps.setDouble(3, produit.getDiametre());
			ps.setDouble(4, produit.getPrix());
			ps.setString(5, produit.getDescription());
			int nbLignesAffectees = ps.executeUpdate();
			System.out.println(nbLignesAffectees + " lignes affectées par l'insertion");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//LISTE DES PRODUITS
	public static void selectAll(Connection connexion) {
		
		try {
		
			Statement requete = connexion.createStatement();
			ResultSet produits = requete.executeQuery("SELECT * FROM montre");
			ArrayList<Produit> mesProduits = new ArrayList<>();
			
			while(produits.next()) {
				Produit p = new Produit();
				p.setMarque(produits.getString("marque"));
				p.setModele(produits.getString("modele"));
				p.setDiametre(produits.getDouble("diametre"));
				p.setPrix(produits.getDouble("prix"));
				p.setDescription(produits.getString("description"));
				mesProduits.add(p);
			}
			
			//AFFICHER LES INFOS DES PRODUITS DE LA BDD
			
			for(Produit p : mesProduits) {
				System.out.println(p.getMarque()+ " "+p.getModele()+" - "+p.getDiametre() +"mm - "+p.getPrix() +"€" + " : "+ p.getDescription());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}





	
}