package Controleur;

import java.util.ArrayList;

import modele.*;

import Vue.*;

public class Controleur {
	private Console c = new Console();
	private Banque b = new Banque();
	private Client clientCourant;
	private CompteBancaire compteCourant;
	
	public void scenario() {
		while(true) {
			if(clientCourant == null) {
				c.Afficher("Que voulez-vous faire?: 'cr�er Client',  'Se connecter avec un client', 'afficher les clients' ou 'Quitter'");
				String choix = c.saisie();
				switch (choix) {
					case "cr�er Client":
						crerClient();
						break;
					case "Se connecter avec un client":
						if(b.getClients().size() == 0) {
							c.Afficher("Aucun client cr�es");
							break;
						}
						connectClient();
						break;
					case "Quitter":
						return;
					case "afficher les clients":
						afficheTable(b.getClients());
						break;
					default:
						c.Afficher("Erreur de saisie");
						break;
				}
			}
		}
	}
	
	private void connectClient() {
		c.Afficher("Saisissez le nom du client");
		String choix = c.saisie();
		ClientFactory cf = new ClientPhysiqueFactory();
		Client tmpClientPhysique = cf.createClient(choix, null, null, null);
		
		ArrayList<Client> listeClients = b.getClients();
		afficheTable(listeClients);
		int index;
		if(listeClients != null && listeClients.size()>0) {
			index = listeClients.indexOf(tmpClientPhysique);
		} else {
			index = -1;
		}
		Client client = null;
		if(index==-1) {
			c.Afficher("erreur client non pr�sent");
			return;
		}
		client = listeClients.get(index);
		this.clientCourant = client;
		if(client instanceof ClientPhysique) {
			c.Afficher("Client physique");
		} else if(client instanceof ClientMoral) {
			c.Afficher("Client Moral");
		} else {
			c.Afficher("Client, " + client.getClass());
		}
		clientConnected();
	}

	private void clientConnected() {
		c.Afficher("Que voulez-vous faire?: 'cr�er un compte',  'afficher infos client', 'd�connexion'");
		String choix = c.saisie();
	}

	public void notifier(String s) {
		c.Afficher(s);
	}
	
	public void afficheTable(ArrayList<Client> tc) {
		for(int i=0; i< tc.size(); i++) {
			c.Afficher(tc.get(i).getNom());
			c.Afficher("-------");
		}
	}
	
	public Client crerClient() {
		boolean termine = false;
		while(!termine) {
			c.Afficher("Quel type de client voulez-vous cr�er?: 'moral' ou 'physique'");
			String choix = c.saisie();
			if(choix.equals("moral") || choix.equals("physique")) {
				c.Afficher("Veuillez Saisir le nom du client");
				String nom = c.saisie();
				c.Afficher("Veuillez Saisir l'adresse du client");
				String adresse = c.saisie();
				c.Afficher("Veuillez Saisir le mail du client");
				String mail = c.saisie();
				c.Afficher("Veuillez Saisir le numerot de t�l�phode du client");
				String numTel = c.saisie();
				switch (choix) {
					case "moral":
						c.Afficher("Veuillez Saisir le num�rot SIRET");
						String siret = c.saisie();
						ClientFactory cmf = new ClientMoralFactory();
						Client clientTmp = cmf.createClient(nom, adresse, mail, numTel);
						((ClientMoral) clientTmp).setNumSiret(siret);
						
						boolean finResponsable = false;
						
						while(!finResponsable) {
							c.Afficher("Veuillez Saisir le nom du client responsable");
							String nomResp = c.saisie();
							ClientFactory cf = new ClientPhysiqueFactory();
							Client tmpClientPhysique = cf.createClient(nomResp, null, null, null);
							
							ArrayList<Client> listeClients = b.getClients();
							afficheTable(listeClients);
							int index;
							if(listeClients != null && listeClients.size()>0) {
								System.out.println("ICI");
								index = listeClients.indexOf(tmpClientPhysique);
								
							} else {
								index = -1;
							}
							System.out.println("l�");
							Client resp = null;
							if(index!=-1) {
								resp = listeClients.get(index);
							} else {
								c.Afficher("Voulez-vous choisir un autre responsable, ou cr�er un compte? 'creer', 'autre responsable'");
								String choixResp = c.saisie();
								switch(choixResp) {
									case "creer":
										resp = crerClient();
										break;
									case "autre responsable":
										break;
								}
							}
							if(resp != null) {
								((ClientMoral)clientTmp).addRespondable((ClientPhysique) resp);
								c.Afficher("Voulez-vous ajouter un autre responsable? 'oui', 'non'");
								String choixContinuer = c.saisie();
								switch(choixContinuer) {
									case "oui":
										break;
									case "non":
										finResponsable = true;
										break;
								}
							}
						}
						if(clientTmp != null) {
							b.addClient(clientTmp);
						}
						return clientTmp;
					case "physique":
						c.Afficher("Veuillez Saisir l'age du client");
						int age = c.saisieInt();
						ClientFactory cff = new ClientPhysiqueFactory();
						Client clientPhysiqueTmp = ((ClientPhysiqueFactory)cff).createClient(nom, adresse, mail, numTel);
						((ClientPhysique)clientPhysiqueTmp).setAge(age);
						if(age<18) {
							boolean finTuteur = false;
							
							while(!finTuteur) {
								c.Afficher("Veuillez Saisir le nom du client tuteur");
								String nomTut = c.saisie();
								ClientFactory cf = new ClientPhysiqueFactory();
								Client tmpClientPhysique = cf.createClient(nomTut, null, null, null);
								ArrayList<Client> listeClients = b.getClients();
								int index = listeClients.indexOf(tmpClientPhysique);
								Client tut = null;
								if(index!=-1) {
									tut = listeClients.get(index);
								} else {
									c.Afficher("Voulez-vous choisir un autre tuteur, ou cr�er un compte? 'creer', 'autre tuteur'");
									String choixTut = c.saisie();
									switch(choixTut) {
										case "creer":
											tut = crerClient();
											break;
										case "autre tuteur":
											break;
									}
								}
								if(tut != null) {
									((ClientPhysique)clientPhysiqueTmp).setTuteur(tut);
									finTuteur = true;
								}
							}
						} else {
							c.Afficher("Voulez vous ajouter un tuteur");
							String choixTut18 = c.saisie();
							if(choixTut18.equals("oui")) {
								boolean finTuteur = false;
								
								while(!finTuteur) {
									c.Afficher("Veuillez Saisir le nom du client tuteur");
									String nomTut = c.saisie();
									ClientFactory cf = new ClientPhysiqueFactory();
									Client tmpClientPhysique = cf.createClient(nomTut, null, null, null);
									ArrayList<Client> listeClients = b.getClients();
									int index = listeClients.indexOf(tmpClientPhysique);
									Client tut = null;
									if(index!=-1) {
										tut = listeClients.get(index);
									} else {
										c.Afficher("Voulez-vous choisir un autre tuteur, ou cr�er un compte? 'creer', 'autre tuteur'");
										String choixTut = c.saisie();
										switch(choixTut) {
											case "creer":
												tut = crerClient();
												break;
											case "autre tuteur":
												break;
										}
									}
									if(tut != null) {
										((ClientPhysique)clientPhysiqueTmp).setTuteur(tut);
										finTuteur = true;
									}
								}
							}
						}
						if(clientPhysiqueTmp != null) {
							b.addClient(clientPhysiqueTmp);
						}
						return clientPhysiqueTmp;
				}
			} else {
				c.Afficher("Erreur de saisie");
			}
		}
		return null;
	}
}