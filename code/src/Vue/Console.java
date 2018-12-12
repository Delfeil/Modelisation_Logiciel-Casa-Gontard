package Vue;

import java.util.Scanner;

public class Console {
	public void Afficher(String s) {
		System.out.println(s);
	}
	
	public String saisie() {
		Scanner read = new Scanner(System.in);
		String saisie = read.nextLine();
//		read.close();
		return saisie;
	}
	
	public int saisieInt() {
		Scanner read = new Scanner(System.in);
		int saisie = read.nextInt();
//		read.close();
		return saisie;
	}
}
