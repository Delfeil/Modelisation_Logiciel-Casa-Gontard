package modele;

public class ReseauMasterCard extends Reseau {
	
	public ReseauMasterCard() {
		this.coutReseau = (float) 0.5;
	}

	/**
	 * Si remboursement avec le réseau MasterCard: remboursement total
	 */
	public Float Remboursement(Paiement p, CompteBancaire c) {
		c.ajoutArgent(p.getMontant());
		return p.getMontant();
	}
}
