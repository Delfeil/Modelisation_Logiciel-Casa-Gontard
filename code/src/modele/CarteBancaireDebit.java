package modele;

public class CarteBancaireDebit extends CarteBancaire {

	private Float plafond;
	
	public CarteBancaireDebit(Reseau r, Client c, CompteBancaire cb, Float plafond) {
		super(r, c, cb);
		this.plafond = plafond;
	}
	
	//Permet de retirer de l'argent et vérifie si le retrait est possible 
	@Override
	protected Float retirer(Float montant, String pays) {
		if(reseau != null) {
			montant = reseau.ajoutCoutReseau(montant);
		}
		if(validerRetrait(montant)) {
			System.out.println("payement accepté");
			if(reseau != null) {
				reseau.creerPaiement(compte, montant, pays);
			}
			return compte.retrait(montant);
		} else {
			return (float) 0;
		}
	}

	//fonction qui est appelé dans la fonction précédante pour savoir si le retrait est possible
	@Override
	protected boolean validerRetrait(Float montant) {
		if(montant > plafond) {
			System.out.println("Plafond maximum dépassé");
			return false;
		} else {
			return compte.retirable(montant);
		}
	}

}
