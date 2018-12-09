package modele;


public abstract class CarteBancaire {
	/**
	 * 
	 */
	protected Reseau reseau;
	
	public CarteBancaire(Reseau r) {
		this.reseau = r;
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
