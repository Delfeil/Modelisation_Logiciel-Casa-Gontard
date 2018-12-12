package modele;

//Permet de créer un client juste avec un nom, une adresse postal, une adresse mail, et numero de tel
public abstract class ClientFactory {
	public abstract Client createClient(String nom, String adressePost, String adressMail, String numTel);
}
