package modele;

public class Adolescent extends Etat {
	// Entre 10 et 18 ans
	
	public Float retirer(Float montant, CompteBancaire compte) {
		return compte.retrait(montant);
	}
	
	public Float consulterSolde(CompteBancaire compte) {
		
	}
	
	public void ajoutArgent(Float montant, CompteBancaire compte) {
		
	}
	
	public void definirMontantMax(Float montant, CompteBancaire compte) {
		System.out.println("Vous n'�tes pas autoris� � modifier le montant maximum retirable, veillez voir avec votre tuteur");
	}
	@Override
	public void etatSuiv(Etat suiv) {
		// TODO Auto-generated method stub

	}

}