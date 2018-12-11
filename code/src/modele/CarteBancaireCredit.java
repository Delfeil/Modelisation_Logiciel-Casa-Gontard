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

	@Override
	protected boolean validerRetrait(Float montant) {
		Float futurTot = montantTot + montant;
		return compte.retirable(futurTot);
	}
	
	public void finPediode() {
		compte.retrait(montantTot);
		montantTot = (float) 0;
	}

}
