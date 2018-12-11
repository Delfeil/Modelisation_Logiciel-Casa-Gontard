package modele;

import java.util.ArrayList;

public class CompteBancaire {
	/**
	 * 
	 */
	private String numCompte;
	
	public String getNumCompte() {
		return this.numCompte;
	}
	
	public void setNumCompte(String num) {
		this.numCompte = num;
	}
	/**
	 * 
	 */
	private Float solde;
	
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	
	public Float consulterSolde() {
		//Correspond à getSolde
		return solde;
	}
	/**
	 * 
	 */
	private Float debitMax;
	
	public Float getDebitMax() {
		return this.debitMax;
	}
	
	public void setDebitMax(Float debit) {
		this.debitMax = debit;
	}
	/**
	 * 
	 */
	private Float montantDecouverMax;
	
	public Float getMontantDecouverMax() {
		return this.montantDecouverMax;
	}
	
	public void setmontantDecouverMax(Float montant) {
		this.montantDecouverMax = montant;
	}
	/**
	 * 
	 */
	private CarteBancaire carteBancaire;
	/**
	 * 
	 */
	private ArrayList<Memento> memento;
	
	private ArrayList<Paiement> paiements;

	public CompteBancaire(String num, Float solde, Float debitMax, Float montantDecouverMax, CarteBancaire carteBancaire) {
		this.numCompte = num;
		this.solde = solde;
		this.debitMax = debitMax;
		this.montantDecouverMax = montantDecouverMax;
		this.carteBancaire = carteBancaire;
	}
	
	public void ajoutArgent(Float montant) {
		this.solde += montant;
	}

	/**
	 * 
	 * @param montant 
	 */
	public float retrait(Float montant) {
		if(retirable(montant)) {
			solde -=montant;
			return montant;
		} else {
			System.out.println("Retrait non autorisé");
			return (float) 0;
		}
	}
	
	public Boolean retirable(Float montant) {
		if(montant > debitMax) {
			return false;
		} else if(solde - montant < -montantDecouverMax) {
			return false;
		} else {
			return true;
		}
	}	

	/**
	 * 
	 */
	public void saveState() {
		memento.add(new Memento(solde));
	}

	/**
	 * 
	 * @return 
	 */
	public void getState() {
		if(memento.size()>0) {
			Memento save = memento.get(memento.size()-1);
			solde = save.getState();
			memento.remove(memento.size()-1);
		} else {
			System.out.println("Erreur aucunes sauvegardes précédantes n'as été faites.");
		}
	}
	
	public void ajoutPaiement(Float montant, String pays) {
		this.paiements.add(new Paiement(montant, pays));
	}
}
