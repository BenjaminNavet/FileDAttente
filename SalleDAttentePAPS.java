package tpSalleDAttente;

import java.util.ArrayList;


public class SalleDAttentePAPS<TC> implements SalleDAttente<TC>{
	
	private int capacite;
	private ArrayList<TC> arlist;
	
	public SalleDAttentePAPS(int max) {
		this.capacite=max;
		arlist = new ArrayList<TC>();
	}

	@Override
	public int getCapacite() {
		return capacite;
	}

	@Override
	public int getNbClients() {
		return arlist.size();
	}

	@Override
	public boolean estVide() {
		return arlist.isEmpty();
	}

	@Override
	public boolean estPleine() {
		return getNbClients()==getCapacite();
	}

	@Override
	public TC getProchain() {
		if (!(this.estVide())) {
			return arlist.get(0);
		}
	else {return null;}
	}

	@Override
	public void sortir() {
		if (!(this.estVide())) {
			arlist.remove(this.getProchain());
		}
	}

	@Override
	public void entrer(TC client) {
		if (!(this.estPleine())) {
		arlist.add(client);
	}

}
}
