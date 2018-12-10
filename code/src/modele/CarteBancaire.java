package modele;


public abstract class CarteBancaire {
	/**
	 * 
	 */
	protected Reseau reseau;
	
	protected Client proprietaire;
	
	protected CompteBancaire compte;
	
	public CarteBancaire(Reseau r, Client c, CompteBancaire cb) {
		this.reseau = r;
		this.compte = cb;
		this.proprietaire = c;
	}

	/**
	 * 
	 * @param montant 
	 * @return 
	 */
	protected abstract Float retirer(Float montant);

	/**
	 * 
	 * @return 
	 */
	protected abstract boolean ValiderRetrait();
}
