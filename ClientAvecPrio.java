package tpSalleDAttente;


import tpSalleDAttente.AvecPrio;

public class ClientAvecPrio extends Client implements AvecPrio
{
	private int prio ;
	
	public ClientAvecPrio(String nom, int prio)
	{
		super(nom);
		this.prio = prio;
	}

	@Override
	public int getPrio()
	{	return prio;	}


	@Override
	public String toString()
	{	return super.toString() + " (priorité " + this.getPrio() + ")" ;  }

	@Override
	public void setPrio(int prio) {
		this.prio = prio;
	}
}
