package Vue;

import java.util.Scanner;

// Classe gérant la vue invitée de commande
public class Console {
	public void Afficher(String s) {
		// Affichage
		System.out.println(s);
	}
	
	// Saisie utilisateur
	public String saisie() {
		Scanner read = new Scanner(System.in);
		String saisie = read.nextLine();
		return saisie;
	}
	
	public int saisieInt() {
		Scanner read = new Scanner(System.in);
		int saisie = read.nextInt();
		return saisie;
	}
}
