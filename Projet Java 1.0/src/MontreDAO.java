import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public Montre findById(Integer id) throws SQLException{
		
		
		Statement requete = connection.createStatement();
		ResultSet montre = requete.executeQuery("SELECT * FROM montre WHERE id ="+id);
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

	@Override
	public ArrayList<Montre> findAll() throws SQLException {
		System.out.println("Liste des montres : ");
		Statement requete = connection.createStatement();
		ResultSet produits = requete.executeQuery("SELECT * FROM montre");
		ArrayList<Montre> mesMontres = new ArrayList<>();
		
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
	public void save(Montre montre, int id) {
		PreparedStatement ps;
		
		if(id ==-1) {
		
			try {
				ps = connection.prepareStatement("INSERT INTO montre(marque, modele, diametre, prix, description) VALUES (?,?,?,?,?)");
				ps.setString(1, montre.getMarque());
				ps.setString(2, montre.getModele());
				ps.setDouble(3, montre.getDiametre());
				ps.setDouble(4, montre.getPrix());
				ps.setString(5, montre.getDescription());
				System.out.println("Nouveau produit ajouté !");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
				System.out.println("Produit modifié !");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void delete(MontreDAO entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(MontreDAO entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Montre montre) {
		// TODO Auto-generated method stub
		
	};
	
	
}
