package modele;

import java.util.Date;

public class ClientPhysique extends Client {
	/**
	 * 
	 */
	protected Date dateNaissance;
	/**
	 * 
	 */
	protected Etat etat;
	/**
	 * 
	 */
	protected Client tuteur;
	
	public ClientPhysique(String nom, String adressePost, String adressMail, String numTel, Date dateNaissance) {
		super(nom, adressePost, adressMail, numTel);
		this.dateNaissance = dateNaissance;
	}

	/**
	 * 
	 * @param compte 
	 */
	public void ajoutCompte(CompteBanquaire compte) {
		super.ajoutCompte(compte);
	}
}
