// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package modele;

/************************************************************/
/**
 * 
 */
public class CarteFactory {
	/**
	 * 
	 * @param type 
	 * @return 
	 */
	public CarteBancaire creerCarte(String type, Reseau r) {
		if(type == "credit") {
			Float plafond = (float) 3000;
			return new CarteBancaireCredit(r, plafond);
		} else if(type == "debit") {
			Float delais = (float) 3000;
			return new CarteBancaireDebit(r, delais);
		} else {
			return null;
		}
	}
};