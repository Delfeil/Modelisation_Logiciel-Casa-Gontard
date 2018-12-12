package modele;

public class CarteBancaireCredit extends CarteBancaire {

	
	private Float periodeDebit;
	
	public Float getPerideDebit() {
		return periodeDebit;
	}
	
	public void setPediodeDebit(Float periodeDebit) {
		this.periodeDebit = periodeDebit;
	}
	
	private Float montantTot;
	
	public Float getMontantTot() {
		return montantTot;
	}
	
	public void setMontantTot(Float montantTot) {
		this.montantTot = montantTot;
	}
	
	public CarteBancaireCredit(Reseau r, Client c, CompteBancaire cb, Float periodeDebit) {
		super(r, c, cb);
		this.periodeDebit = periodeDebit;
		
	}
	
	//Permet de retirer de l'argent et vérifie si le retrait est possible 
	@Override
	protected Float retirer(Float montant, String pays) {
		if(reseau != null) {
			montant = reseau.ajoutCoutReseau(montant);
		}
		if(validerRetrait(montant)) {
			montantTot += montant;
			if(reseau != null) {
				reseau.creerPaiement(compte, montant, pays);
			}
			return montant;
		} else {
			return (float) 0;
		}
	}

	//fonction qui est appelé dans la fonction précédante pour savoir si le retrait est possible
	@Override
	protected boolean validerRetrait(Float montant) {
		Float futurTot = montantTot + montant;
		return compte.retirable(futurTot);
	}
	
	//Fait le retrait de tous les credit accumulés lors de la période
	public void finPediode() {
		compte.retrait(montantTot);
		montantTot = (float) 0;
	}

}
