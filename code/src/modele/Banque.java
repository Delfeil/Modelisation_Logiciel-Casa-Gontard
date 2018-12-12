package modele;

import java.util.ArrayList;

public class Banque {
	//Classe servant de base de donnée
	
	//liste des clients existants dans la banque
	private ArrayList<Client> clients = new ArrayList<Client>();

	public ArrayList<Client> getClients() {
		return clients;
	}
	
	// Permet d'ajouter un nouveau client à la liste des clients
	public void addClient(Client c) {
		clients.add(c);
	}
	
	
	//Liste des comptes bancaires qui ont été créé dans la banque
	private ArrayList<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
	
	public ArrayList<CompteBancaire> getComptesBancaire() {
		return comptes;
	}
	
	// Permet d'ajouter un nouveau compte à la liste des comptes bancaires
	public void addCompte(CompteBancaire cb) {
		comptes.add(cb);
	}
}
