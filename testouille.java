package tpSalleDAttente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testouille {
	
	public static void main(String[] args) {
		
		List<Integer> listeEntiers = new ArrayList();
		
		listeEntiers.add(5);
		listeEntiers.add(6);
		listeEntiers.add(0);
		listeEntiers.add(1);
		listeEntiers.add(29);
		listeEntiers.add(4);
		
		
		Collections.sort(listeEntiers);
		
		
		for (Integer i : listeEntiers) {
			System.out.println(""+i);
		}
		
	}

}
