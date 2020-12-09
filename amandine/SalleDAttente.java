package tpSalleDAttente.amandine;
public interface SalleDAttente<TC>
{
	public int getCapacite() ;			// Capacité de la salle
	public int getNbClients() ;			// Nombre de clients dans la salle
	public boolean estVide() ;			// Salle vide ?
	public boolean estPleine() ;		// Salle pleine ?
    public TC getProchain() ;			// Prochain client à servir
    public void sortir() ;				// Sortie de la salle du prochain client à servir
    public void entrer(TC o) ;			// Entrée dans la salle du client c
}