package modele;

import java.util.ArrayList;

public abstract class Client {
	/**
	 * 
	 */
	protected String nom;
	/**
	 * 
	 */
	protected String adressePost;
	/**
	 * 
	 */
	protected String adressMail;
	/**
	 * 
	 */
	protected String numTel;
	/**
	 * 
	 */
	
	public Client(String nom, String adressePost, String adressMail, String numTel) {
		this.nom = nom;
		this.adressePost = adressePost;
		this.adressMail = adressMail;
		this.numTel = numTel;
		this.comptesBancaire = new ArrayList<CompteBancaire>();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getAdressePost() {
		return this.adressePost;
	}
	
	public void setAdressePost(String adressePost) {
		this.adressePost = adressePost;
	}
	
	public String getAdressMail() {
		return this.adressMail;
	}
	
	public void setAdresseMail(String adresseMail) {
		this.adressMail = adresseMail;
	}
	
	public String getNumTel() {
		return this.numTel;
	}
	
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	//liste des comptes bancaires appartenant au client courant
	protected ArrayList<CompteBancaire> comptesBancaire;

	/**
	 * Ajout d'un compte bancaire pour un client
	 * @param compte 
	 */
	public void ajoutCompte(CompteBancaire compte) {
		comptesBancaire.add(compte);
	}
	
	//Surdéfinition de la méthode equals
	@Override
	public boolean equals(Object o) {
		System.out.println("compraison");
		Client c = (Client) o;
		System.out.println("" + c.getNom() + ", " + getNom());
		if (this.nom.equals(c.nom)) {
			return true;
		} else {
			return false;
		}
	}

}
