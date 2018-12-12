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
	 * Fonction qui permet de retirer de l'argent nous retenons le montant et le pays 
	 * @param montant 
	 * @return 
	 */
	protected abstract Float retirer(Float montant, String pays);

	/**
	 * Cette fonction permet de valider le montant en fonction du solde actuel que l'on a sur notre compte
	 * @return 
	 */
	protected abstract boolean validerRetrait(Float montant);
}
