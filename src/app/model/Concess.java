package app.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concess {
	
	private List<Auto> listaA;
	public List<Indice> listaI;
	
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

	}// finito
	
	public void ripristinaAuto(String t) {

		for (int i = 0; i < listaA.size(); i++) {
			if (listaA.get(i).getTarga().equalsIgnoreCase(t)) {
				listaA.get(i).setAttivo(true);
				break;
			}
		}

	}//finito
	
	

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

	public ArrayList<Auto> listaC() {
		ArrayList<Auto> lista = new ArrayList<>();
	
			for (int i = 0; i < listaA.size(); i++) {
				if (!listaA.get(i).isAttivo()) {

					lista.add(listaA.get(i));
				}
			} 
		return lista;

	}// finito 
	
	public void compattazione() {
		ArrayList<Auto> lista = new ArrayList<>();
		for(int i=0;i<listaA.size();i++) {
			if(listaA.get(i).isAttivo()) {
				lista.add(listaA.get(i));
			}
		}
		listaA=lista;
		
		Indice a;
		for(int i=0;i<lista.size();i++) {
			for(int k=0;k<listaI.size();k++) {
				if(lista.get(i).getTarga().equalsIgnoreCase(listaI.get(k).getTarga())) {
					a=listaI.get(k);
					listaI.remove(a);
					for(int j=0;j<listaI.size();j++) {
						if(listaI.get(j).getN()>a.getN()) {
							listaI.get(j).setN(listaI.get(j).getN()-1);
						}
					}
				}
			}
		}
		
	}
	
	public void ordinare() {
		
	}

}
