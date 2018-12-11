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
	
	protected ArrayList<CompteBancaire> comptesBancaire;

	/**
	 * 
	 * @param compte 
	 */
	public void ajoutCompte(CompteBancaire compte) {
		comptesBancaire.add(compte);
	}
}
