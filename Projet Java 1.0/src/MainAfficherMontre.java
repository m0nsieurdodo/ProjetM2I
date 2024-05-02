import java.sql.SQLException;
import java.util.List;

public class MainAfficherMontre {



	public static void main(String[] args) {
		
		MontreDAO c = new MontreDAO();
		
		//afficherTout(c);
		
		afficherMontreId(c);
		
		

	}

	private static void afficherMontreId(MontreDAO c) {
		Montre p;
		try {
			p = c.findById(1);
			System.out.println(p.getMarque()+ " "+p.getModele()+" - "+p.getDiametre() +"mm - "+p.getPrix() +"€" + " : "+ p.getDescription());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void afficherTout(MontreDAO c) {
		
		try {
			List<Montre> mesMontres = c.findAll();
			for(Montre p : mesMontres) {
				System.out.println(p.getMarque()+ " "+p.getModele()+" - "+p.getDiametre() +"mm - "+p.getPrix() +"€" + " : "+ p.getDescription());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
