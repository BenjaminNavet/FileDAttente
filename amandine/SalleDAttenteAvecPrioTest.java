package tpSalleDAttente.amandine;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/*
 *  @ author : DENIEL Amandine
 */

class SalleDAttenteAvecPrioTest {

	private ClientAvecPrio c;
	private SalleDAttenteAvecPrio<AvecPrio> salleDAP;
	private int prioMax = 5;
	
	@BeforeEach
	void setUp() throws Exception {
		salleDAP= new SalleDAttenteAvecPrio<> (30, prioMax);
	}
	
	@Test	
    void testSalleVide() {
        assertTrue("La salle doit �tre vide", salleDAP.estVide()); 
    }
	
	@Test
	void creerClient () {
		c= new ClientAvecPrio ("Jean", 3);
	}
	
	@Test
	public void testEntrer()
	{
		ClientAvecPrio c1 = new ClientAvecPrio("un client", 1) ;
		testEntrer(salleDAP, c1) ;
	}
	
	private void testEntrer(SalleDAttenteAvecPrio s, ClientAvecPrio c){
		assertTrue("La salle doit �tre vide", s.estVide());	
		s.entrer(c);
		assertTrue("La salle ne doit pas �tre vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas �tre pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit �tre de taille 1") ;
		assertSame(c, s.getProchain(), "Le prochain � sortir doit �tre le premier entr�") ;
		s.sortir();
		assertTrue("La salle doit �tre vide", s.estVide()) ;		
	}		
	
	@Test
	public void testEntrerPrioDiff()
	{
		ClientAvecPrio c1 = new ClientAvecPrio("un client 1", 1) ;
		ClientAvecPrio c2 = new ClientAvecPrio("un client 2", 3) ;
		testEntrerPrioDiff(salleDAP, c1, c2) ;
	}
	
	private void testEntrerPrioDiff(SalleDAttenteAvecPrio s, ClientAvecPrio c1, ClientAvecPrio c2){
		assertTrue("La salle doit �tre vide", s.estVide());	
		s.entrer(c1);
		s.entrer(c2);
		assertTrue("Le client 2 doit�tre le prochain � acc�der au RDV", s.getProchain()==c2);		
	}
	
	@Test
	void testMaxPrio() {
        ClientAvecPrio VIP = new ClientAvecPrio("Relou",7);
        salleDAP.entrer(VIP);
        assertTrue("La priorit� doit �tre de 4",salleDAP.getProchain().getPrio()==prioMax-1);
    }
	
	@Test
    void testMoins() {
        ClientAvecPrio clientOsef = new ClientAvecPrio("Tocard",-1);
        salleDAP.entrer(clientOsef);
        assertTrue("La prioirit� doit �tre de 0",salleDAP.getProchain().getPrio()==0);
    }
	
	@Test
	public void testSallePleine()
	{
		ClientAvecPrio c1 = new ClientAvecPrio("un client", 1) ;
		ClientAvecPrio c2 = new ClientAvecPrio("un client 2", 1) ;
		ClientAvecPrio c3 = new ClientAvecPrio("un client 3", 1) ;
		ClientAvecPrio c4 = new ClientAvecPrio("un client 4", 1) ;
		ClientAvecPrio c5 = new ClientAvecPrio("un client 5", 1) ;
		SalleDAttenteAvecPrio<AvecPrio> salleDAP5= new SalleDAttenteAvecPrio<> (5, prioMax);
		testSallePleine(salleDAP5, c1, c2, c3, c4, c5) ;
	}

	private void testSallePleine (SalleDAttenteAvecPrio s, ClientAvecPrio c1, ClientAvecPrio c2, ClientAvecPrio c3, ClientAvecPrio c4, ClientAvecPrio c5) 
	{
		assertTrue("La salle doit �tre vide", s.estVide()) ;
		s.entrer(c1); 
		assertTrue("La salle ne doit pas �tre vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas �tre pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit �tre de taille 1") ;
		s.entrer(c2);
		assertTrue("La salle ne doit pas �tre vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas �tre pleine", ! s.estPleine()) ;
		assertEquals(2, s.getNbClients(), "La salle doit �tre de taille 2") ;
		s.entrer(c3);
		s.entrer(c4);
		s.entrer(c5);
		assertTrue("La salle ne doit pas �tre vide", ! s.estVide()) ;
		assertTrue("La salle doit �tre pleine", s.estPleine()) ;
		assertEquals(5, s.getNbClients(), "La salle doit �tre de taille 5") ;
		assertSame(c1, s.getProchain(), "Le prochain � sortir doit �tre le premier entr�") ;
		s.sortir();
		assertEquals(4, s.getNbClients(), "La salle doit contenir 4 clients") ;
	}
	
	@Test
	public void testExtraPersonnes()
	{
		ClientAvecPrio c1 = new ClientAvecPrio("un client", 1) ;
		ClientAvecPrio c2 = new ClientAvecPrio("un client 2", 1) ;
		ClientAvecPrio c3 = new ClientAvecPrio("un client 3", 1) ;
		ClientAvecPrio c4 = new ClientAvecPrio("un client 4", 1) ;
		ClientAvecPrio c5 = new ClientAvecPrio("un client 5", 1) ;
		ClientAvecPrio c6 = new ClientAvecPrio("un client 6", 1) ;
		SalleDAttenteAvecPrio<AvecPrio> salleDAP5= new SalleDAttenteAvecPrio<> (5, prioMax);
		testExtraPersonne(salleDAP5, c1, c2, c3, c4, c5, c6) ;
	}

	private void testExtraPersonne (SalleDAttenteAvecPrio s, ClientAvecPrio c1, ClientAvecPrio c2, ClientAvecPrio c3, ClientAvecPrio c4, ClientAvecPrio c5, ClientAvecPrio c6) 
	{
		assertTrue("La salle doit �tre vide", s.estVide()) ;
		s.entrer(c1); 
		assertTrue("La salle ne doit pas �tre vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas �tre pleine", ! s.estPleine()) ;
		assertEquals(1, s.getNbClients(), "La salle doit �tre de taille 1") ;
		s.entrer(c2);
		assertTrue("La salle ne doit pas �tre vide", ! s.estVide()) ;
		assertTrue("La salle ne doit pas �tre pleine", ! s.estPleine()) ;
		assertEquals(2, s.getNbClients(), "La salle doit �tre de taille 2") ;
		s.entrer(c3);
		s.entrer(c4);
		s.entrer(c5);
		assertTrue("La salle doit �tre pleine", s.estPleine()) ;
		assertEquals(5, s.getNbClients(), "La salle doit �tre de taille 5") ;
		s.entrer(c6);
		assertTrue("Le client n'a pas pu rentrer", s.estPleine());
		assertSame(c1, s.getProchain(), "Le prochain � sortir doit �tre le premier entr�") ;
		s.sortir();
		assertEquals(4, s.getNbClients(), "La salle doit contenir 4 clients") ;
	}

}
