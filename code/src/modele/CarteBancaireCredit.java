package modele;

public class CarteBancaireCredit extends CarteBancaire {

	private Float plafond;
	
	public CarteBancaireCredit(Reseau r, Float plafond) {
		super(r);
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
