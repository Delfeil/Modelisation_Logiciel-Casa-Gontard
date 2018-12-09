package modele;


public class CompteBancaire {
	/**
	 * 
	 */
	private String numCompte;
	/**
	 * 
	 */
	private Float solde;
	/**
	 * 
	 */
	private Float debitMax;
	/**
	 * 
	 */
	private Float montantDecouver;
	/**
	 * 
	 */
	private CarteBancaire cartebancaire;
	/**
	 * 
	 */
	private Memento memento;

	/**
	 * 
	 * @param montant 
	 */
	public void ajoutArgent(Float montant) {
		this.solde += montant;
	}

	/**
	 * 
	 * @param montant 
	 */
	public Float retrait(Float montant) {
	}

	/**
	 * 
	 * @return 
	 */
	public Float consulterSolde() {
	}

	/**
	 * 
	 */
	public void saveState() {
	}

	/**
	 * 
	 * @return 
	 */
	public Memento getState() {
	}
}
