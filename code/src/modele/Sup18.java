package modele;

public class Sup18 extends Etat {

	public Float retrait(Float montant, CompteBancaire compte) {
		return compte.retrait(montant);
	}
	
	public Float consulterSolde(CompteBancaire compte) {
		
	}
	
	public void ajoutArgent(Float montant, CompteBancaire compte) {
		
	}
	
	public void definirMontantMax(Float montant, CompteBancaire compte) {
		
	}
	
	@Override
	public void etatSuiv(Etat suiv) {

	}

}
