package modele;

public class Memento {
	private Float solde;
	
	public Memento(Float solde) {
		this.solde = solde;
	}
	
	public Float getState() {
		return solde;
		
	}
}
