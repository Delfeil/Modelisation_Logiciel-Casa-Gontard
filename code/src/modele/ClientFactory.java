package modele;

public abstract class ClientFactory {
	public abstract Client createClient(String nom, String adressePost, String adressMail, String numTel);
}
