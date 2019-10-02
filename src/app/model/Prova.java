package app.model;

import java.io.IOException;
import java.util.ArrayList;

public class Prova {
	
	public static void main(String[] args) throws IOException {
		
		Concess concessionario=new Concess();
		
		Auto a=new Auto("ciao","hello","world",828,889484);
		Auto b =new Auto("aciao","ss","dd",5525,999);
		Auto c =new Auto("ccsono io","ss","dd",5525,999);
		
		
		concessionario.aggiungiAuto(a);
		concessionario.aggiungiAuto(b);
		concessionario.aggiungiAuto(c);
		
		concessionario.eliminaAuto("ccsono io");
		
		concessionario.listaC();
		
		
		System.out.println(concessionario.listaI.get(0).compareTo(concessionario.listaI.get(1)));
	
		
		
//		try {
//			RandomAccessFile raf = new RandomAccessFile("auto.txt", "rw");
//			
//			System.out.println(raf.length());
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	
	}
}
