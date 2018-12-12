package modele;

public class Adolescent extends Etat {
	//Classe représentant l'etat d'une personne physique age entre 10 et 18 ans
	
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
		System.out.println("Vous n'êtes pas autorisé à modifier le montant maximum retirable, veillez voir avec votre tuteur");
	}
	
	@Override
	public Etat etatSuiv() {
		// TODO Auto-generated method stub
		return new Sup18();
	}
}
