import java.util.Scanner;

public class MainAjouterMontre {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MontreDAO c = new MontreDAO();
	
		// SAUVEGARDE D'UNE NOUVELLE MONTRE
		c.save(getMontreFromUser(), -1);
		
		
		
	}
	
	public static Montre getMontreFromUser() {
		
		Montre m = new Montre();
		try {
			System.out.println("Marque : ");
			m.setMarque(sc.next());
			System.out.println("Modele : ");
			m.setModele(sc.next());
			System.out.println("Diametre (entre 26 et 56mm) : ");
			m.setDiametre(sc.nextDouble());
			System.out.println("Prix : ");
			m.setPrix(sc.nextDouble());
			System.out.println("Description : ");
			m.setDescription(sc.next());
	
		}
		catch(RuntimeException e){
			System.out.println("Saisissez à nouveau ");
		}
		return m;
		
		
	}

}
