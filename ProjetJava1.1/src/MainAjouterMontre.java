
import java.util.Scanner;

public class MainAjouterMontre {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MontreDAO c = new MontreDAO();
	
		// SAUVEGARDE D'UNE NOUVELLE MONTRE

		c.save(c, getMontreFromUser(), -1);
		
		
		
	}
	
	public static Montre getMontreFromUser() {
		
		double diam =0;
		Montre m = new Montre();
		try {
			System.out.println("Marque : ");
			m.setMarque(sc.next());
			System.out.println("Modele : ");
			m.setModele(sc.next());
			System.out.println("Diametre (entre 26 et 56mm) : ");
			diam = sc.nextDouble();
			while (26 > diam || diam > 56) {
				System.out.println("Diametre (entre 26 et 56mm) : ");
				diam = sc.nextDouble();
				
			}
			m.setDiametre(diam);
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
