package modele;


public abstract class Reseau {
	/**
	 * 
	 */
	protected Float coutReseau;
	
	public Float getCoutReseau() {
		return coutReseau;
	}
	
	public void setCoutReseau(Float cout) {
		this.coutReseau = cout;
	}
	
	/**
	 * 
	 * @return 
	 */
	public abstract Float Remboursement(Paiement p, CompteBancaire c);
	
	public Float ajoutCoutReseau(Float montant) {
		Float cout = montant*coutReseau;
		return montant + cout;
	}
	
	public void creerPaiement(CompteBancaire c, Float montant, String pays) {
		c.ajoutPaiement(montant, pays);
	}
}
