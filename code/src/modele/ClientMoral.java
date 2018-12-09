package modele;

import java.util.Date;

public class ClientMoral extends Client {
	/**
	 * 
	 */
	private String numSiret;
	/**
	 * 
	 */
	public ClientPhysique clientphysique;
	
	public ClientMoral(String nom, String adressePost, String adressMail, String numTel, String numSiret, ClientPhysique resp) {
		super(nom, adressePost, adressMail, numTel);
		this.numSiret = numSiret;
		this.clientphysique = resp;
	}

	/**
	 * 
	 * @param compte 
	 */
	public void ajoutCompte(CompteBanquaire compte) {
		super.ajoutCompte(compte);
	}
}
