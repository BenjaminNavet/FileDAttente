package tpSalleDAttente;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalleDAttenteAvecPrioTestFrancois {
	
	private SalleDAttenteAvecPrio<ClientAvecPrio> salle;
	private ClientAvecPrio c;
	private int priomax = 10;

	@BeforeEach
	void setUp() throws Exception {
		
		c=new ClientAvecPrio("Hubert BonnisseurDeLaBatte", 1);
		salle= new SalleDAttenteAvecPrio<ClientAvecPrio>(30,priomax);
		
	}
	
	@Test 
	void ActionUn() {
		assertTrue("La salle doit etre vide",salle.estVide());
	}
	
	@Test
	void ActionDeux() {
		c=new ClientAvecPrio("unClient", 1);
	}
	
	@Test
	void ActionTrois() {
		salle.entrer(c);
		assertFalse("",salle.estVide());
		assertFalse("",salle.estPleine());
		assertTrue("",salle.getNbClients()==1);
		assertTrue("",salle.getProchain()==c);	
	}
	
	@Test
	void ActionQuatre() {
		salle.entrer(c);
		salle.sortir();
		assertTrue("",salle.estVide());
	}
	
	@Test 
	void ActionCinq() {
		ClientAvecPrio client = new ClientAvecPrio("relou",0);
		salle.entrer(client);
		salle.entrer(c);
		assertTrue("",salle.getProchain()==c);
	}
	
	@Test
	void ActionSix() {
		ClientAvecPrio clienttropimportant = new ClientAvecPrio("Enculard",priomax+1);
		salle.entrer(clienttropimportant);
		assertTrue("",salle.getProchain().getPrio()==priomax);
	}
	
	@Test
	void ActionSept() {
		ClientAvecPrio clientOsef = new ClientAvecPrio("Tocard",-1);
		salle.entrer(clientOsef);
		assertTrue("",salle.getProchain().getPrio()==0);
	}
	
	
	

	
}
