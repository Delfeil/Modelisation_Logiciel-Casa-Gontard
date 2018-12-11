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
	
	public ClientPhysique(String nom, String adressePost, String adressMail, String numTel, int age) {
		super(nom, adressePost, adressMail, numTel);
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
	 * @param compte 
	 */
	public void ajoutCompte(CompteBancaire compte) {
		super.ajoutCompte(compte);
	}
	
	public void EtatSuiv() {
		Etat suiv = this.etat.etatSuiv();
		if(suiv != null) {
			this.etat = suiv;
		}
	}
}
