package modele;

import java.util.Scanner;

public class ClientMoralFactory extends ClientFactory {

	@Override
	public Client createClient(String nom, String adressePost, String adressMail, String numTel) {
//		Scanner read = new Scanner(System.in);
//		String numSiret = read.nextLine();
//		read.close();
		return new ClientMoral(nom, adressePost, adressMail, numTel, null);
	}

}
