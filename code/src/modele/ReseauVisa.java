package modele;

public class ReseauVisa extends Reseau {
	
	public ReseauVisa() {
		this.coutReseau = (float) 0.25;
	}

	/**
	 * Celon le pays ou a été fait le paiement, 
	 * utilisation de l'objet RemboursementVisa correspondant pour effectuer le remboursement
	 */
	public Float Remboursement(Paiement p, CompteBancaire c) {
		RemboursementVisa rV;
		switch (p.getPays()) {
			case "France":
				rV = new RemboursementVisaFrance();
				break;
			case "Espagne":
				rV = new RemboursementVisaEspagne();
				break;
			case "Etats-Unis":
				rV = new RemboursementVisaEtatsUnis();
				break;
			case "Portugal":
				rV = new RemboursementVisaPortugal();
				break;
			case "Royaume-Unis":
				rV = new RemboursementVisaRoyaumeUnis();
				break;
			default:
				rV = new RemboursementVisaResteMonde();
				break;
		}
		c.ajoutArgent(rV.remoursement(p.getMontant()));
		return rV.remoursement(p.getMontant());
	}
}
