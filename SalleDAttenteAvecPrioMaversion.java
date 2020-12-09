package tpSalleDAttente;

import java.util.ArrayList;
import java.util.HashMap;

public class SalleDAttenteAvecPrioMaversion<TC extends AvecPrio> implements SalleDAttente<TC>{

	private int capaciteMax, maxPrio;
	private HashMap<Integer, SalleDAttentePAPS<TC>> salle;
	
	//constructeur
	/**
	 * 
	 * @param taille taille maximale de la salle d'attente
	 * @param Prio  niveau de priorité maximum (donc prio +1 niveaux de prios car ça commence à 0)
	 */
	
	public SalleDAttenteAvecPrioMaversion(int taille, int Prio) {
		capaciteMax = taille;
		maxPrio = Prio;
		salle = new HashMap<Integer, SalleDAttentePAPS<TC>>();
		
		// map initialisation
		
		for (int i=0; i < maxPrio; i++) {
			salle.put(i,new SalleDAttentePAPS<TC>(taille));
		}
	}
	

	@Override
	public int getCapacite() {
		return capaciteMax;
	}

	@Override
	public int getNbClients() {
		// TODO Auto-generated method stub
		int nbClient = 0;
		for (SalleDAttentePAPS<TC> prio: salle.values()) {
			nbClient += prio.getNbClients();
		}
		return nbClient;
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return getNbClients() == 0;
	}

	@Override
	public boolean estPleine() {
		// TODO Auto-generated method stub
		for (SalleDAttentePAPS<TC> psalle: salle.values()) {
			if (psalle.getNbClients() != capaciteMax) {
				return false;
			}
		}
		return true;
	}

	@Override
	public TC getProchain() {
		if (!estVide()) {
			for (int i = maxPrio; i <= 0; i--) {
				if (salle.get(i).getNbClients() != 0) {
					return salle.get(i).getProchain();
				}
			}
		}
		return null;
	}

	@Override
	public void sortir() {
		if (!estVide()) {
			TC next = this.getProchain();
			salle.get(next.getPrio()).sortir();
		}
		
	}

	@Override
	public void entrer(TC client) {
		if (!estPleine()) {
			if (client.getPrio() > maxPrio) {
				salle.get(maxPrio).entrer(client);
			}
			else if (client.getPrio() < 0) {
				salle.get(0).entrer(client);
			}
			else {salle.get(client.getPrio()).entrer(client);}
		}
		
		
	}

}
