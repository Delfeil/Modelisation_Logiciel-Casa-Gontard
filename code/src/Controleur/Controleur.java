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
				c.Afficher("Que voulez-vous faire?: 'créer Client',  'Se connecter avec un client' ou 'Quitter'");
				String choix = c.saisie();
				switch (choix) {
					case "créer Client":
						crerClient();
						break;
					case "Se connecter avec un client":
						break;
					case "Quitter":
						return;
					default:
						c.Afficher("Erreur de saisie");
						break;
				}
			}
		}
	}
	
	public void notifier(String s) {
		c.Afficher(s);
	}
	
	public void crerClient() {
		boolean termine = false;
		while(!termine) {
			c.Afficher("Quel type de client voulez-vous créer?: 'moral' ou 'physique'");
			String choix = c.saisie();
			if(choix == "moral" || choix == "physique") {
				c.Afficher("Veuillez Saisir le nom du client");
				String nom = c.saisie();
				c.Afficher("Veuillez Saisir l'adresse du client");
				String adresse = c.saisie();
				c.Afficher("Veuillez Saisir le mail du client");
				String mail = c.saisie();
				c.Afficher("Veuillez Saisir le numerot de téléphode du client");
				String numTel = c.saisie();
				switch (choix) {
					case "moral":
						c.Afficher("Veuillez Saisir le numérot SIRET");
						String siret = c.saisie();
						break;
					case "physique":
						c.Afficher("Veuillez Saisir l'age du client");
						int age = c.saisieInt();
						break;
				}
			} else {
				c.Afficher("Erreur de saisie");
			}
		}
	}
}