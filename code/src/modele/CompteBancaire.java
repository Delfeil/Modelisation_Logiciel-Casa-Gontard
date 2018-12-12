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
	 * Correspond � getSolde
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
	 * Permet de savoir si un client est propri�taire du compte
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
	 * Permet d'attribuer � un compte une carte bancaire, et de la cr�er par la m�me ocasion, n�cessite de choisir au pr�alable un r�seau 
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
	 * Permet de retirer de l'argent, en v�rifiant que cel� est possible
	 */
	public float retrait(Float montant) {
		if(retirable(montant)) {
			saveState();
			solde -=montant;
			return montant;
		} else {
			System.out.println("Retrait non autoris�");
			return (float) 0;
		}
	}
	
	/**
	 * Permet de v�rifier si il est possible de retirer un certain montant
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
	 * Sauvegarde de l'�tat d'un compte dans le memento
	 */
	public void saveState() {
		memento.add(new Memento(solde));
	}

	/**
	 * Permet de r�tablir le dernier �tat
	 */
	public void getState() {
		if(memento.size()>0) {
			Memento save = memento.get(memento.size()-1);
			solde = save.getState();
			memento.remove(memento.size()-1);
		} else {
			System.out.println("Erreur aucunes sauvegardes pr�c�dantes n'as �t� faites.");
		}
	}
	
	/**
	 * Permet d'ajouter un paiement
	 */
	public void ajoutPaiement(Float montant, String pays) {
		this.paiements.add(new Paiement(montant, pays));
	}
	
	/**
	 * Surd�finition de la m�thode equals
	 */
	@Override
	public boolean equals(Object o){
		CompteBancaire cb = (CompteBancaire) o;
		if (this.numCompte==cb.numCompte)
			return true;
		else return false;
		}
}
