package modele;

import java.util.ArrayList;

/**
 * 
 * Compte bancaire
 *
 */
public class CompteBancaire {
	
	private int numCompte;
	
	public int getNumCompte() {
		return this.numCompte;
	}
	
	public void setNumCompte(int num) {
		this.numCompte = num;
	}
	
	private Float solde;
	
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	
	/**
	 * Correspond à getSolde
	 */
	public Float consulterSolde() {
		return solde;
	}
	
	private Float debitMax;
	
	public Float getDebitMax() {
		return this.debitMax;
	}
	
	public void setDebitMax(Float debit) {
		this.debitMax = debit;
	}
	
	private Float montantDecouverMax;
	
	public Float getMontantDecouverMax() {
		return this.montantDecouverMax;
	}
	
	public void setmontantDecouverMax(Float montant) {
		this.montantDecouverMax = montant;
	}
	
	private ArrayList<Client> proprietaires;
	
	public ArrayList<Client> getProprietaires() {
		return proprietaires;
	}
	
	public void addProprietaires(Client c) {
		proprietaires.add(c);
	}
	
	/**
	 * Permet de savoir si un client est propriétaire du compte
	 */
	public boolean clientPresent(Client c) {
		for(int i=0; i<proprietaires.size(); i++) {
			if(c.getNom() == proprietaires.get(i).getNom()) {
				return true;
			}
		}
		return false;
	}
	
	private CarteBancaire carteBancaire;
	
	public CarteBancaire getCarteBancaire() {
		return this.carteBancaire;
	}
	
	/**
	 * Permet d'attribuer à un compte une carte bancaire, et de la créer par la même ocasion, nécessite de choisir au préalable un réseau 
	 */
	public void setCarteBancaire(String type, Reseau r, Client c) {
		CarteFactory cf= new CarteFactory();
		
		if(clientPresent(c)) {
			this.carteBancaire = cf.creerCarte(type, r, this, c);
		} else {
			carteBancaire = null;
		}
	}
	
	private ArrayList<Memento> memento;
	
	private ArrayList<Paiement> paiements;

	public CompteBancaire(int num, Float solde, Float debitMax, Float montantDecouverMax, CarteBancaire carteBancaire) {
		this.numCompte = num;
		this.solde = solde;
		this.debitMax = debitMax;
		this.montantDecouverMax = montantDecouverMax;
		this.carteBancaire = carteBancaire;
		this.memento = new ArrayList<Memento>();
		this.paiements = new ArrayList<Paiement>();
		this.proprietaires = new ArrayList<Client>();
	}
	
	public void ajoutArgent(Float montant) {
		saveState();
		this.solde += montant;
	}

	/**
	 * Permet de retirer de l'argent, en vérifiant que celà est possible
	 */
	public float retrait(Float montant) {
		if(retirable(montant)) {
			saveState();
			solde -=montant;
			return montant;
		} else {
			System.out.println("Retrait non autorisé");
			return (float) 0;
		}
	}
	
	/**
	 * Permet de vérifier si il est possible de retirer un certain montant
	 */
	public Boolean retirable(Float montant) {
		if((debitMax != null) && (montant > debitMax)) {
			return false;
		} else if(solde - montant < -montantDecouverMax) {
			return false;
		} else {
			return true;
		}
	}	

	/**
	 * Sauvegarde de l'état d'un compte dans le memento
	 */
	public void saveState() {
		memento.add(new Memento(solde));
	}

	/**
	 * Permet de rétablir le dernier état
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
	
	/**
	 * Permet d'ajouter un paiement
	 */
	public void ajoutPaiement(Float montant, String pays) {
		this.paiements.add(new Paiement(montant, pays));
	}
	
	/**
	 * Surdéfinition de la méthode equals
	 */
	@Override
	public boolean equals(Object o){
		CompteBancaire cb = (CompteBancaire) o;
		if (this.numCompte==cb.numCompte)
			return true;
		else return false;
		}
}
