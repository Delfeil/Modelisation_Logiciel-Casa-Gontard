package modele;

public class Paiement {
	private Float montant;
	private String pays;
	
	public Paiement(Float m, String p) {
		this.pays = p;
		this.montant = m;
	}
	
	public Float getMontant() {
		return this.montant;
	}
	
	public void setMontant(Float m) {
		this.montant = m;
	}
	
	public void setPays(String p) {
		this.pays = p;
	}
	
	public String getPays() {
		return this.pays;
	}
}
