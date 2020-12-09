package tpSalleDAttente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalleDAttenteAvecPrio<TC extends AvecPrio> extends HashMap<Integer,ArrayList<TC>> implements SalleDAttente<TC>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int capaciteMax, maxPrio;
	private Map<Integer, ArrayList<TC>> salle;
	
	//constructeur
	/**
	 * 
	 * @param taille taille maximale de la salle d'attente
	 * @param Prio  niveau de priorité maximum (donc prio +1 niveaux de prios car ça commence à 0)
	 */
	
	public SalleDAttenteAvecPrio(int taille, int Prio) {
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
			for (int i = maxPrio-1; i >= 0; i--) {
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
				salle.get(client.getPrio()).add(client);
			}
			else if (client.getPrio() < 0) {
				salle.get(client.getPrio()).add(client);
			}
			else {salle.get(client.getPrio()).add(client);}
		}
		
		
	}
	
	public static void main(String[] args) {
		SalleDAttenteAvecPrio s = new SalleDAttenteAvecPrio(15, 5);
		ClientAvecPrio c1 = new ClientAvecPrio("un client", 1) ;
		ClientAvecPrio c2 = new ClientAvecPrio("un client 2", 2) ;
		ClientAvecPrio c3 = new ClientAvecPrio("un client 3", 0) ;
		ClientAvecPrio c4 = new ClientAvecPrio("un client 4", 0) ;
		ClientAvecPrio c5 = new ClientAvecPrio("un client 5", 4) ;
		s.entrer(c1);
		s.entrer(c2);
		s.entrer(c3);
		s.entrer(c5);
		AvecPrio e = s.getProchain();
		System.out.println(""+e);
		System.out.println(""+s.getNbClients());
		System.out.println(""+s.get(1));
		System.out.println(""+s.get(2));
		System.out.println(""+s.get(3));
		System.out.println(""+s);

	}
}
