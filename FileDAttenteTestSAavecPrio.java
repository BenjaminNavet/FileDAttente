/**
 * 
 */
package tpSalleDAttente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jean_hubert
 *
 */
class FileDAttenteTestSAavecPrio {
	
	private SalleDAttenteAvecPrio<ClientAvecPrio> sallePrio;
	private ClientAvecPrio c1,c2,c3,c4,c5;
	private int priomax = 5;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sallePrio = new SalleDAttenteAvecPrio<ClientAvecPrio>(30,priomax);
        c1 = new ClientAvecPrio("un client", 1) ;
        c2 = new ClientAvecPrio("un client 2", 2) ;
        c3 = new ClientAvecPrio("un client 3", 0) ;
        c4 = new ClientAvecPrio("un client 4", 0) ;
        c5 = new ClientAvecPrio("un client 5", 4) ;
	}
	

	@Test
	void testSalleVide() {
		assertTrue("La salle doit être vide à l'initialisation", sallePrio.estVide()) ;
        entrerClients(sallePrio, c1, c2, c3, c4, c5) ;
		assertTrue("La salle ne doit pas être vide après avoir fait entrer des clients", ! sallePrio.estVide()) ;
		sallePrio.sortir();
		sallePrio.sortir();
		sallePrio.sortir();
		sallePrio.sortir();
		sallePrio.sortir();
		assertTrue("La salle doit être vide quand tous sont sortis", sallePrio.estVide()) ;	
	}
	
	@Test
	void testTailleDeLaSalle() {
        entrerClients(sallePrio, c1, c2, c3, c4, c5) ;
		assertTrue("La salle ne doit pas être pleine", ! sallePrio.estPleine()) ;
		assertEquals(5, sallePrio.getNbClients(), "La salle doit être de taille 5") ;
	}
	
	@Test
	void testProchainASortir() {
        entrerClients(sallePrio, c1, c2, c3, c4, c5) ;
		assertSame(c5, sallePrio.getProchain(), "Le prochain à sortir doit être le client avec la priorité la plus élevée") ;
	}
	
	@Test	
	void testPrioSupMax() {
		ClientAvecPrio client = new ClientAvecPrio("Je m'impose", 9);
		sallePrio.entrer(client);
		assertTrue("",sallePrio.getProchain().getPrio()==priomax-1);
	}
	
	@Test	
	void testPrioInfZero() {
		ClientAvecPrio clientOsef = new ClientAvecPrio("Tocard",-1);
		sallePrio.entrer(clientOsef);
		assertTrue("",sallePrio.getProchain().getPrio()==0);		
	}
	
	private void entrerClients(SalleDAttenteAvecPrio<ClientAvecPrio> s, ClientAvecPrio... c) {
		s.entrer(c[0]);
		s.entrer(c[1]);
		s.entrer(c[2]);
		s.entrer(c[3]);
		s.entrer(c[4]);
	}

}
