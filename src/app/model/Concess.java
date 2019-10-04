package app.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Concess {
	
	private List<Auto> listaA;
	public HashMap<String,Indice> listaI;
	
	public Concess() {
		listaA=new ArrayList<>();
		listaI=new HashMap<>();
	}
	
	public void aggiungiAuto(Auto a ) {
		listaA.add(a);
		Indice i=new Indice(listaA.indexOf(a),a.getTarga(),a.toString().length());
		
		
		listaI.put(i.getTarga(),i);
		
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

	}// finito

	public String cerca(String t) {
		String n = "targa non trovato";

		try {
			BufferedReader inA = new BufferedReader(new FileReader("auto.txt"));
			for (int k = 0; k < listaI.size(); k++) {
				inA.readLine();
			}
			n = inA.readLine();
			inA.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;

	}// modifiare all'aggiungimento di offset

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
				System.out.println("2");
			}
		}
		listaA=lista;
		
		Indice a;
			

			for(int k=0;k<lista.size();k++) {
				if(!listaI.containsKey(lista.get(k).getTarga())) {
					a=listaI.get(lista.get(k).getTarga());
					listaI.remove(lista.get(k).getTarga());
					for(int j=0;j<lista.size();j++) {
						if(listaI.get(lista.get(j).getTarga()).getN()>a.getN()) {
							listaI.get(lista.get(j).getTarga()).setN((listaI.get(lista.get(j).getTarga()).getN()-1));
						}
					}
				}
			}
		try {
			FileWriter w =new FileWriter("indice.txt");
			w.write("");
			w.close();
			FileWriter w2 = new FileWriter("indice.txt",true);
			Iterator it = listaI.entrySet().iterator();
			while (it.hasNext()) {

				Map.Entry entry = (Map.Entry) it.next();
				System.out.println("1");
//				w2.write(listaI.get(entry.getKey()).toString());
			}
			w2.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void ordinare() {
		
		
		
		
		
	}

}
