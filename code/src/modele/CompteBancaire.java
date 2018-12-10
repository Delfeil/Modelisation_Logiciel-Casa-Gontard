package modele;

import java.util.ArrayList;

public class CompteBancaire {
	/**
	 * 
	 */
	private String numCompte;
	/**
	 * 
	 */
	private Float solde;
	/**
	 * 
	 */
	private Float debitMax;
	/**
	 * 
	 */
	private Float montantDecouver;
	/**
	 * 
	 */
	private CarteBancaire cartebancaire;
	/**
	 * 
	 */
	private ArrayList<Memento> memento;
	
	private ArrayList<Paiement> paiements;

	/**
	 * 
	 * @param montant 
	 */
	public void ajoutArgent(Float montant) {
		this.solde += montant;
	}

	/**
	 * 
	 * @param montant 
	 */
	public Float retrait(Float montant) {
	}

	/**
	 * 
	 * @return 
	 */
	public Float consulterSolde() {
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
}
