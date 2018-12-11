package modele;

public class ConcreteCompteBancaireBuilder extends BuilderCompteBancaire {

	@Override
	public CompteBancaire buildCompteBancaire(Client c, float montantDecouvert, int num, float solde) {
		return new CompteBancaire(num, solde, null, montantDecouvert, null);
	}
	
}
