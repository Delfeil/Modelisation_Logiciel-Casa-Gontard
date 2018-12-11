package modele;

import java.util.ArrayList;

public class ClientMoral extends Client {
	/**
	 * 
	 */
	private String numSiret;
	
	public String getNumSiret() {
		return numSiret;
	}
	
	public void setNumSiret(String num) {
		this.numSiret = num;
	}
	/**
	 * 
	 */
	public ArrayList<ClientPhysique> respondables;
	
	public ArrayList<ClientPhysique> getRespondables() {
		return respondables;
	}
	
	public void addRespondable(ClientPhysique respondable) {
		this.respondables.add(respondable);
	}
	
	public ClientMoral(String nom, String adressePost, String adressMail, String numTel, String numSiret) {
		super(nom, adressePost, adressMail, numTel);
		this.numSiret = numSiret;
	}

	/**
	 * 
	 * @param compte 
	 */
	public void ajoutCompte(CompteBancaire compte) {
		super.ajoutCompte(compte);
	}
}
