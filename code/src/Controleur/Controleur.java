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
				c.Afficher("Que voulez-vous faire?: 'créer Client',  'Se connecter avec un client', 'afficher les clients' ou 'Quitter'");
				String choix = c.saisie();
				switch (choix) {
					case "créer Client":
						crerClient();
						break;
					case "Se connecter avec un client":
						if(b.getClients().size() == 0) {
							c.Afficher("Aucun client crées");
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
	
	//Fonction qui permet à l'utilisateur de ce connecter à un compte client déjà existant
	
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
			c.Afficher("erreur client non présent");
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
			c.Afficher("Que voulez-vous faire?: 'créer un compte', 'se connecter à un compte',  'afficher infos client', 'déconnexion'");
			String choix = c.saisie();
			switch (choix) {
				case "créer un compte":
					crerCompte();
					break;
				case "afficher infos client":
					if(b.getClients().size() == 0) {
						c.Afficher("Aucun client créé");
						break;
					}
					connectClient();
					break;
				case "déconnexion":
					this.clientCourant = null;
					return;
				default:
					c.Afficher("Erreur de saisie");
					break;
			}
		}
	}

	//Choix solde lors de la création du compte
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
	
	//Fonction qui permet de créer un compte client physique majeur/mineur ou moral
	
	public Client crerClient() {
		boolean termine = false;
		while(!termine) {
			c.Afficher("Quel type de client voulez-vous créer?: 'moral' ou 'physique'");
			String choix = c.saisie();
			if(choix.equals("moral") || choix.equals("physique")) {
				c.Afficher("Veuillez saisir le nom du client");
				String nom = c.saisie();
				c.Afficher("Veuillez saisir l'adresse du client");
				String adresse = c.saisie();
				c.Afficher("Veuillez saisir le mail du client");
				String mail = c.saisie();
				c.Afficher("Veuillez saisir le numéro de téléphone du client");
				String numTel = c.saisie();
				switch (choix) {
					case "moral":
						c.Afficher("Veuillez saisir le numéro SIRET");
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
								c.Afficher("Voulez-vous choisir un autre responsable, ou créer un client? 'créer', 'autre responsable'");
								String choixResp = c.saisie();
								switch(choixResp) {
									case "créer":
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
						c.Afficher("Veuillez saisir l'âge du client");
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
									c.Afficher("Voulez-vous choisir un autre tuteur, ou créer un client? 'créer', 'autre tuteur'");
									String choixTut = c.saisie();
									switch(choixTut) {
										case "créer":
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
										c.Afficher("Voulez-vous choisir un autre tuteur, ou créer un client? 'créer', 'autre tuteur'");
										String choixTut = c.saisie();
										switch(choixTut) {
											case "créer":
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