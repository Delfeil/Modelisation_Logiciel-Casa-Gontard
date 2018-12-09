package modele;

public class Adolescent extends Etat {
	// Entre 10 et 18 ans
	
	public Float retirer(Float montant, CompteBancaire compte) {
		if(compte.retirable(montant)) {
			return compte.retirer(montant);
		} else {
			System.out.println("Vous n'êtes pas autorisé à retirer de l'argent, veillez voir avec votre tuteur");
			return (float) 0;
		}
	}
	
	public Float consulterSolde(CompteBancaire compte) {
		
	}
	
	public void ajoutArgent(Float montant, CompteBancaire compte) {
		
	}
	
	public void definirMontantMax(Float montant, CompteBancaire compte) {
		System.out.println("Vous n'êtes pas autorisé à modifier le montant maximum retirable, veillez voir avec votre tuteur");
	}
	@Override
	public void etatSuiv(Etat suiv) {
		// TODO Auto-generated method stub

	}

}
