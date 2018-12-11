package modele;

import java.util.ArrayList;

public class Banque {
	//Classe servant de base de donnée
	private ArrayList<Client> clients;
	
	public ArrayList<Client> getClients() {
		return clients;
	}
	
	public void addClient(Client c) {
		clients.add(c);
	}
	
	private ArrayList<CompteBancaire> comptes;
	
	public ArrayList<CompteBancaire> getComptesBancaire() {
		return comptes;
	}
	
	public void addCompte(CompteBancaire cb) {
		comptes.add(cb);
	}
}
