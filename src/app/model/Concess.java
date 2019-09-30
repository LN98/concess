package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
			
			
			BufferedReader inI=new BufferedReader(new FileReader("indice.txt"));
			FileWriter fI = new FileWriter("indice.txt", true);
			fI.write(i.toString());
			fI.close();
			inI.close();
		}catch(IOException e) {
			System.out.println("file non trovato");
		}
		
		
	}//finito

	public void eliminaAuto(String t) {

		for (int i = 0; i < listaI.size(); i++) {
			if (listaA.get(i).getTarga().equalsIgnoreCase(t)) {
				listaA.get(i).setAttivo(false);
				break;
			}
		}

	}// da modificare quando importer� il file
	
	public void ripristinaAuto(String t) {

		for (int i = 0; i < listaA.size(); i++) {
			if (listaA.get(i).getTarga().equalsIgnoreCase(t)) {
				listaA.get(i).setAttivo(true);
				break;
			}
		}

	}// da modificare quando importer� il file
	
	

	public String cerca(String t) {
		String n="targa non trovato";
		for (int i = 0; i < listaI.size(); i++) {
			if (listaI.get(i).getTarga().equalsIgnoreCase(t)) {
				try {
					BufferedReader inA=new BufferedReader(new FileReader("auto.txt"));
					for(int k=0;k<listaI.get(i).getN();k++ ) {
						inA.readLine();
					}
					n=inA.readLine();
					inA.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}break;
			}

		}
		return n;
		
		
	}//finito

	public ArrayList<String> listaC() {
		ArrayList<String> lista = new ArrayList<>();
	
			for (int i = 0; i < listaA.size(); i++) {
				if (!listaA.get(i).isAttivo()) {

					lista.add(listaA.get(i).toString());
				}
			} 
		return lista;

	}// finito 
	
	public void compattazione() {
		for(int i=0;i<listaI.size();i++) {
			for(int k=i+1;i<listaI.size();k++) {
				listaI.get(i).getTarga().compareTo(listaI.get(k).getTarga());
			}
		}
	}

}
