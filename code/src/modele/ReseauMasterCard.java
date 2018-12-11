package modele;

public class ReseauMasterCard extends Reseau {
	
	public ReseauMasterCard() {
		this.coutReseau = (float) 0.5;
	}

	/**
	 * 
	 * @return 
	 */
	public Float Remboursement(Paiement p, CompteBancaire c) {
		c.ajoutArgent(p.getMontant());
		return p.getMontant();
	}
}
