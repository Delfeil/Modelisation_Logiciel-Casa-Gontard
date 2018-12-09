package modele;

public abstract class Etat {
	/**
	 * 
	 */
	public abstract Float retirer(Float montant, CompteBancaire compte);
	public abstract Float consulterSolde(CompteBancaire compte);
	public abstract void ajoutArgent(Float montant, CompteBancaire compte);
	public abstract void definirMontantMax(Float montant, CompteBancaire compte);
	public abstract void etatSuiv(Etat suiv);
}
