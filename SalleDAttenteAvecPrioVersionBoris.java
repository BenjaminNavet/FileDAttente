package tpSalleDAttente;

import java.util.ArrayList;
import java.util.HashMap;

public class SalleDAttenteAvecPrioVersionBoris<TC extends AvecPrio> implements SalleDAttente<TC>{

	private int capaciteMax, maxPrio;
	private HashMap<Integer, ArrayList<TC>> salle;
	
	//constructeur
	/**
	 * 
	 * @param taille taille maximale de la salle d'attente
	 * @param Prio  niveau de priorité maximum (donc prio +1 niveaux de prios car ça commence à 0)
	 */
	
	public SalleDAttenteAvecPrioVersionBoris(int taille, int Prio) {
		capaciteMax = taille;
		maxPrio = Prio;
		salle = new HashMap<Integer, ArrayList<TC>>();
		
		// map initialisation
		
		for (int i=0; i < maxPrio; i++) {
			salle.put(i,new ArrayList<TC>());
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
		for (ArrayList<TC> prio: salle.values()) {
			nbClient += prio.size();
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
		return salle.size()==capaciteMax;
	}

	@Override
	public TC getProchain() {
		if (!estVide()) {
			for (int i = maxPrio; i <= 0; i--) {
				if (salle.get(i).size() != 0) {
					return salle.get(i).get(0);
				}
			}
		}
		return null;
	}

	@Override
	public void sortir() {
		if (!estVide()) {
			TC next = getProchain();
			salle.get(next.getPrio()).remove(next);
		}
		
	}

	@Override
	public void entrer(TC client) {
		if (!estPleine()) {
			if (client.getPrio() > maxPrio) {
				salle.get(maxPrio).add(client);
			}
			else if (client.getPrio() < 0) {
				salle.get(0).add(client);
			}
			else {salle.get(client.getPrio()).add(client);}
		}
		
		
	}

}
