package modele;

public abstract class BuilderCompteBancaire {
	public abstract CompteBancaire buildCompteBancaire(Client c, float montantDecouvert, int num, float solde);
}
