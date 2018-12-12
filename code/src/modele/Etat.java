package modele;

public abstract class Etat {
	/**
	 * Représente les différentes intéractions plus ou moins controlées qu'un client physique a le droit ou pas de faire 
	 */
	public abstract Float retrait(Float montant, CompteBancaire compte);
	public abstract Float consulterSolde(CompteBancaire compte);
	public abstract void ajoutArgent(Float montant, CompteBancaire compte);
	public abstract void definirMontantMax(Float montant, CompteBancaire compte);
	public abstract Etat etatSuiv();
}
