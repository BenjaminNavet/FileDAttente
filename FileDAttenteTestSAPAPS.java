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
class FileDAttenteTestSAPAPS {
	
	private SalleDAttentePAPS<ClientAvecPrio> sallePAPS;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sallePAPS = new SalleDAttentePAPS<ClientAvecPrio> (30);
	}
	
	@Test
	void testSalleVide() {
		assertTrue("La salle doit être vide", sallePAPS.estVide()); 
	}

	@Test
	void testUnElement() {
        ClientAvecPrio c = new ClientAvecPrio("un client", 1) ;
		testUnElement(sallePAPS, c);
	}
		
	private void testUnElement(SalleDAttente s, ClientAvecPrio c) {
		assertTrue("La salle doit être vide", s.estVide()) ;
		s.entrer(c); ;
		assertTrue("La salle ne doit pas être vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas être pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit être de taille 1") ;
		assertSame(c, s.getProchain(), "Le prochain à sortir doit être le premier entré") ;
		s.sortir();
		assertTrue("La salle doit être vide", s.estVide()) ;	
	}

}
