package Controleur;

import java.util.ArrayList;

import modele.*;

import Vue.*;

public class Controleur {
	private Console c = new Console();
	private Banque b = new Banque();
	private Client clientCourant;
	private CompteBancaire compteCourant;
	
	//Choix que l'utilisateur peut faire lors de la connexion
	
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
	
	//Fonction qui permet � l'utilisateur de ce connecter � un compte client d�j� existant
	
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

	
	//Une fois le client connecter il a d'autres choix de fonction 
	
	private void clientConnected() {
		boolean clientConnected =true;
		while(clientConnected) {
			c.Afficher("Que voulez-vous faire?: 'cr�er un compte', 'se connecter � un compte',  'afficher infos client', 'd�connexion'");
			String choix = c.saisie();
			switch (choix) {
				case "cr�er un compte":
					crerCompte();
					break;
				case "afficher infos client":
					if(b.getClients().size() == 0) {
						c.Afficher("Aucun client cr��");
						break;
					}
					connectClient();
					break;
				case "d�connexion":
					this.clientCourant = null;
					return;
				default:
					c.Afficher("Erreur de saisie");
					break;
			}
		}
	}

	//Choix solde lors de la cr�ation du compte
	private void crerCompte() {
		c.Afficher("Combien d'argent voulez-vous y mettre");
		float choixSolde = c.saisieInt();
	}

	public void notifier(String s) {
		c.Afficher(s);
	}
	
	//Permet d'afficher la liste des clients qui ont un compte dans la banque
	
	public void afficheTable(ArrayList<Client> tc) {
		for(int i=0; i< tc.size(); i++) {
			c.Afficher(tc.get(i).getNom());
			c.Afficher("-------");
		}
	}
	
	//Fonction qui permet de cr�er un compte client physique majeur/mineur ou moral
	
	public Client crerClient() {
		boolean termine = false;
		while(!termine) {
			c.Afficher("Quel type de client voulez-vous cr�er?: 'moral' ou 'physique'");
			String choix = c.saisie();
			if(choix.equals("moral") || choix.equals("physique")) {
				c.Afficher("Veuillez saisir le nom du client");
				String nom = c.saisie();
				c.Afficher("Veuillez saisir l'adresse du client");
				String adresse = c.saisie();
				c.Afficher("Veuillez saisir le mail du client");
				String mail = c.saisie();
				c.Afficher("Veuillez saisir le num�ro de t�l�phone du client");
				String numTel = c.saisie();
				switch (choix) {
					case "moral":
						c.Afficher("Veuillez saisir le num�ro SIRET");
						String siret = c.saisie();
						ClientFactory cmf = new ClientMoralFactory();
						Client clientTmp = cmf.createClient(nom, adresse, mail, numTel);
						((ClientMoral) clientTmp).setNumSiret(siret);
						
						boolean finResponsable = false;
						
						while(!finResponsable) {
							c.Afficher("Veuillez saisir le nom du client responsable");
							String nomResp = c.saisie();
							ClientFactory cf = new ClientPhysiqueFactory();
							Client tmpClientPhysique = cf.createClient(nomResp, null, null, null);
							
							ArrayList<Client> listeClients = b.getClients();
							int index;
							if(listeClients != null && listeClients.size()>0) {
								index = listeClients.indexOf(tmpClientPhysique);
								
							} else {
								index = -1;
							}
							Client resp = null;
							if(index!=-1) {
								resp = listeClients.get(index);
							} else {
								c.Afficher("Voulez-vous choisir un autre responsable, ou cr�er un client? 'cr�er', 'autre responsable'");
								String choixResp = c.saisie();
								switch(choixResp) {
									case "cr�er":
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
						c.Afficher("Veuillez saisir l'�ge du client");
						int age = c.saisieInt();
						ClientFactory cff = new ClientPhysiqueFactory();
						Client clientPhysiqueTmp = ((ClientPhysiqueFactory)cff).createClient(nom, adresse, mail, numTel);
						((ClientPhysique)clientPhysiqueTmp).setAge(age);
						if(age<18) {
							boolean finTuteur = false;
							
							while(!finTuteur) {
								c.Afficher("Veuillez saisir le nom du client tuteur");
								String nomTut = c.saisie();
								ClientFactory cf = new ClientPhysiqueFactory();
								Client tmpClientPhysique = cf.createClient(nomTut, null, null, null);
								ArrayList<Client> listeClients = b.getClients();
								int index = listeClients.indexOf(tmpClientPhysique);
								Client tut = null;
								if(index!=-1) {
									tut = listeClients.get(index);
								} else {
									c.Afficher("Voulez-vous choisir un autre tuteur, ou cr�er un client? 'cr�er', 'autre tuteur'");
									String choixTut = c.saisie();
									switch(choixTut) {
										case "cr�er":
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
									c.Afficher("Veuillez saisir le nom du client tuteur");
									String nomTut = c.saisie();
									ClientFactory cf = new ClientPhysiqueFactory();
									Client tmpClientPhysique = cf.createClient(nomTut, null, null, null);
									ArrayList<Client> listeClients = b.getClients();
									int index = listeClients.indexOf(tmpClientPhysique);
									Client tut = null;
									if(index!=-1) {
										tut = listeClients.get(index);
									} else {
										c.Afficher("Voulez-vous choisir un autre tuteur, ou cr�er un client? 'cr�er', 'autre tuteur'");
										String choixTut = c.saisie();
										switch(choixTut) {
											case "cr�er":
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