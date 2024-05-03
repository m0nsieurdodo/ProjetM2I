
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MontreDAO implements GenericDAO<MontreDAO>{
	
	private Connection connection;
	
	public MontreDAO() {
		try {
			connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	@Override
	public MontreDAO findById(Integer id) throws SQLException{
		
		
		Statement requete = connection.createStatement();
		ResultSet montre = requete.executeQuery("SELECT * FROM montre WHERE id ="+id);
		if(montre != null) {
			Montre p = new Montre();
			while(montre.next()) {
				p.setMarque(montre.getString("marque"));
				p.setModele(montre.getString("modele"));
				p.setDiametre(montre.getDouble("diametre"));
				p.setPrix(montre.getDouble("prix"));
				p.setDescription(montre.getString("description"));
		}
			
		return p;
		}
		return null;
		
		
	}

	@Override
	public ArrayList<MontreDAO> findAll() throws SQLException {
		
		System.out.println("Liste des montres : ");
		Statement requete = connection.createStatement();
		ResultSet produits = requete.executeQuery("SELECT * FROM montre");
		ArrayList<MontreDAO> mesMontres = new ArrayList<>();
		
		while(produits.next()) {
			Montre p = new Montre();
			p.setMarque(produits.getString("marque"));
			p.setModele(produits.getString("modele"));
			p.setDiametre(produits.getDouble("diametre"));
			p.setPrix(produits.getDouble("prix"));
			p.setDescription(produits.getString("description"));
			mesMontres.add(p);
		}
		return mesMontres;
	}



	@Override
	public void save(MontreDAO c, Montre montre, int id){
		PreparedStatement ps;
		
		if(id ==-1) {
		
			try {
				ps = connection.prepareStatement("INSERT INTO montre(marque, modele, diametre, prix, description) VALUES (?,?,?,?,?)");
				ps.setString(1, montre.getMarque());
				ps.setString(2, montre.getModele());
				ps.setDouble(3, montre.getDiametre());
				ps.setDouble(4, montre.getPrix());
				ps.setString(5, montre.getDescription());
				ps.executeUpdate();
				System.out.println("Nouveau produit ajouté !");
				
			} catch (SQLException e) {
				System.out.println( e.getSQLState());
				e.printStackTrace();
			}
		}
		else {
			try {
				ps = connection.prepareStatement("UPDATE montre SET marque =?, modele=?, diametre=?, prix=?, description=? WHERE id = ?");
				ps.setString(1, montre.getMarque());
				ps.setString(2, montre.getModele());
				ps.setDouble(3, montre.getDiametre());
				ps.setDouble(4, montre.getPrix());
				ps.setString(5, montre.getDescription());
				ps.setInt(6, id);
				ps.executeUpdate();
				System.out.println("Produit modifié !");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void delete(MontreDAO c, int id) {

		try {
			Statement requete = connection.createStatement();
			boolean montre = requete.execute("DELETE FROM montre WHERE id ="+id);
			if(montre == false) {
				System.out.println("Produit supprimé.");}
			else {
				System.out.println("Ce produit n'a pas pu être supprimé.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	
	
}
