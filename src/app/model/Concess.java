package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Concess {
	
	private List<Auto> listaA;
	private List<Indice> listaI;
	
	public Concess() {
		listaA=new ArrayList<>();
		listaI=new ArrayList<>();
	}
	
	public void aggiungiAuto(Auto a ) {
		listaA.add(a);
		Indice i=new Indice(listaA.indexOf(a),a.getTarga(),a.toString().length());
		
		
		listaI.add(i);
		
		try {
			BufferedReader inA=new BufferedReader(new FileReader("auto.txt"));
			FileWriter fA = new FileWriter("auto.txt", true);
			fA.write(a.toString());
			fA.close();
			inA.close();
			
			
			BufferedReader inB=new BufferedReader(new FileReader("indice.txt"));
			FileWriter fI = new FileWriter("indice.txt", true);
			fI.write(i.toString());
			fI.close();
			inB.close();
		}catch(IOException e) {
			System.out.println("file non trovato");
		}
		
		
	}

	public void eliminaAuto(String t) {

		for (int i = 0; i < listaI.size(); i++) {
			if (listaI.get(i).getTarga().equalsIgnoreCase(t)) {
				listaI.get(i).setAttivo(false);
				break;
			}
		}

	}//da modificare quando importerò il file
	
	public void cerca(String t) {
		int n;
		n=0;
		for(int i=0;i<listaI.size();i++) {
			n+=listaI.get(i).getOffset();
			if(listaI.get(i).getTarga().equalsIgnoreCase(t)) {
				if(i==0) {
					
				}
				
			}
		}
	}
	
	public void listaC() {
		for (int i = 0; i < listaI.size(); i++) {
			if (!listaI.get(i).isAttivo()) {
				for(int k=0;k<i;k++) {
					                                               
				}
			}
		}
		
	}


}
