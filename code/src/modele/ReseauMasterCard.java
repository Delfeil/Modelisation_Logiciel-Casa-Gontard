package modele;

public class ReseauMasterCard extends Reseau {
	/**
	 * 
	 */
	protected Float coutReseau;
	
	public ReseauMasterCard() {
		this.coutReseau = (float) 0.5;
	}

	/**
	 * 
	 * @return 
	 */
	public Float Remboursement() {
		return null;
	}

	/**
	 * 
	 */
	public void effectuerTransaction() {
	}
}
