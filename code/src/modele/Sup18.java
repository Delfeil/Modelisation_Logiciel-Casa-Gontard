package modele;

public class Sup18 extends Etat {
	// pratiquement tous les droits sont accordés aux clients majeurs

	public Float retrait(Float montant, CompteBancaire compte) {
		return compte.retrait(montant);
	}
	
	public Float consulterSolde(CompteBancaire compte) {
		return compte.consulterSolde();
	}
	
	public void ajoutArgent(Float montant, CompteBancaire compte) {
		compte.ajoutArgent(montant);
	}
	
	public void definirMontantMax(Float montant, CompteBancaire compte) {
		compte.setDebitMax(montant);
	}
	
	@Override
	public Etat etatSuiv() {
		System.out.println("Changement d'état impossible, vous ne pouvez pas échaper à vos responsabilitées");
		return null;
	}

}
