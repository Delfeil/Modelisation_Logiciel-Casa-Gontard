package modele;

import java.util.Scanner;

public class ClientPhysiqueFactory extends ClientFactory {

	@Override
	public Client createClient(String nom, String adressePost, String adressMail, String numTel) {
		return new ClientPhysique(nom, adressePost, adressMail, numTel);
	}

}
