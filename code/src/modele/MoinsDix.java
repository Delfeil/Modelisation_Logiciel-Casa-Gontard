package modele;

/**
 * 
 * Permet de g�rer les autorisations pour un client physique �g� de moins de 10 ans
 * Cette classe repr�sente l'�tat moins de 10 ans
 */
public class MoinsDix extends Etat {
	
	/**
	 * Retrait d'argent non accord�
	 */
	public Float retrait(Float montant, CompteBancaire compte) {
		System.out.println("Vous n'�tes pas autoris� � retirer de l'argent, veillez voir avec votre tuteur");
		return (float) 0;
	}
	
	public Float consulterSolde(CompteBancaire compte) {
		return compte.consulterSolde();
	}
	
	public void ajoutArgent(Float montant, CompteBancaire compte) {
		compte.ajoutArgent(montant);
	}
	
	public void definirMontantMax(Float montant, CompteBancaire compte) {
		System.out.println("Vous n'�tes pas autoris� � retirer de l'argent, veillez voir avec votre tuteur");
	}
	@Override
	public Etat etatSuiv() {
		return new Adolescent();
	}

}
