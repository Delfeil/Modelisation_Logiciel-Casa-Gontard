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
	 * Le r�seau permet � un client de se faire rembourser un paiement (varie celon le type de r�seau)
	 */
	public abstract Float Remboursement(Paiement p, CompteBancaire c);
	
	/**
	 * Les reseaux ajoutent leur couts lors de transactions avec une carte bacaire (le cout varie selon letype de r�seau)
	 */
	public Float ajoutCoutReseau(Float montant) {
		Float cout = montant*coutReseau;
		return montant + cout;
	}
	
	/**
	 * Les Reseaux permettent g�rer des paiements qui pouront par la suite �tre rembours�s, ils sont retrouvables dans le compte bancaire
	 */
	public void creerPaiement(CompteBancaire c, Float montant, String pays) {
		c.ajoutPaiement(montant, pays);
	}
}
