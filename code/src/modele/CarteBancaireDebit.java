package modele;

public class CarteBancaireDebit extends CarteBancaire {

	private Float periodeDebit;
	
	public CarteBancaireDebit(Reseau r, Float periodeDebit) {
		super(r);
		this.periodeDebit = periodeDebit;
	}
	@Override
	protected Float retirer(Float montant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean ValiderRetrait() {
		// TODO Auto-generated method stub
		return false;
	}

}
