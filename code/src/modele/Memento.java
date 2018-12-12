package modele;

/**
 * 
 * Permet de sauvegarder l'�tat du solde d'un compte bancaire
 *
 */
public class Memento {
	private Float solde;
	
	public Memento(Float solde) {
		this.solde = solde;
	}
	
	public Float getState() {
		return solde;
		
	}
}
