package modele;

public abstract class Etat {
	/**
	 * Repr�sente les diff�rentes int�ractions plus ou moins control�es qu'un client physique a le droit ou pas de faire 
	 */
	public abstract Float retrait(Float montant, CompteBancaire compte);
	public abstract Float consulterSolde(CompteBancaire compte);
	public abstract void ajoutArgent(Float montant, CompteBancaire compte);
	public abstract void definirMontantMax(Float montant, CompteBancaire compte);
	public abstract Etat etatSuiv();
}
