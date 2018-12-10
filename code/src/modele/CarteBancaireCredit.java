package modele;

public class CarteBancaireCredit extends CarteBancaire {

	private Float plafond;
	
	public CarteBancaireCredit(Reseau r, Client c, CompteBancaire cb, Float plafond) {
		super(r, c, cb);
		this.plafond = plafond;
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
