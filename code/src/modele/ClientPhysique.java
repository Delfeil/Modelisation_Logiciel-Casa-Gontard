package modele;

public class ClientPhysique extends Client {
	/**
	 * 
	 */
	protected int age;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
		this.age = age;
		if(age<10) {
			this.etat = new MoinsDix();
		} else if(age>=10 && age<18) {
			this.etat = new Adolescent();
 		} else {
 			this.etat = new Sup18();
 		}
	}
	/**
	 * 
	 */
	protected Etat etat;
	
	public Etat getEtat() {
		return etat;
	}
	
	public void setEtat(Etat e) {
		this.etat = e;
	}
	/**
	 * 
	 */
	protected Client tuteur;
	
	public Client getTuteur() {
		return tuteur;
	}
	
	public void setTuteur(Client tuteur) {
		this.tuteur = tuteur;
	}
	
	public ClientPhysique(String nom, String adressePost, String adressMail, String numTel) {
		super(nom, adressePost, adressMail, numTel);
	}

	/**
	 * 
	 * Ajouter un compte à un client moral
	 * Si celui-ci a un tuteur, on ajoute le compte au tuteur
	 * On ajoute le client et son tuteur (si il en a un) comme prorpiétaires du compte bancaire
	 */
	public void ajoutCompte(CompteBancaire compte) {
		super.ajoutCompte(compte);
		compte.addProprietaires(this);
		if(age <18 && tuteur != null) {
			tuteur.ajoutCompte(compte);
			compte.addProprietaires(tuteur);
		}
	}
	
	public void EtatSuiv() {
		Etat suiv = this.etat.etatSuiv();
		if(suiv != null) {
			this.etat = suiv;
		}
	}
	
//	@Override
//	public boolean equals(Object o){
//		ClientPhysique cp = (ClientPhysique) o;
//		if (this.nom==cp.nom)
//			return true;
//		else return false;
//	}
}
