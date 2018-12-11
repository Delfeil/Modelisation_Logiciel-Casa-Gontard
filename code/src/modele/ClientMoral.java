package modele;

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
	public ClientPhysique respondable;
	
	public ClientPhysique getRespondable() {
		return respondable;
	}
	
	public void setRespondable(ClientPhysique respondable) {
		this.respondable = respondable;
	}
	
	public ClientMoral(String nom, String adressePost, String adressMail, String numTel, String numSiret, ClientPhysique resp) {
		super(nom, adressePost, adressMail, numTel);
		this.numSiret = numSiret;
		this.respondable = resp;
	}

	/**
	 * 
	 * @param compte 
	 */
	public void ajoutCompte(CompteBancaire compte) {
		super.ajoutCompte(compte);
	}
}
