package modele;

public class MoinsDix extends Etat {

	public Float retrait(Float montant, CompteBancaire compte) {
		System.out.println("Vous n'êtes pas autorisé à retirer de l'argent, veillez voir avec votre tuteur");
	}
	
	public Float consulterSolde(CompteBancaire compte) {
		
	}
	
	public void ajoutArgent(Float montant, CompteBancaire compte) {
		
	}
	
	public void definirMontantMax(Float montant, CompteBancaire compte) {
		System.out.println("Vous n'êtes pas autorisé à retirer de l'argent, veillez voir avec votre tuteur");
	}
	@Override
	public void etatSuiv(Etat suiv) {

	}

}
