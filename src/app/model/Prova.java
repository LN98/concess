package app.model;

import java.util.ArrayList;

public class Prova {
	
	public static void main(String[] args) {
		
		Concess concessionario=new Concess();
		
		Auto a=new Auto("ciao","hello","world",828,889484);
		
		concessionario.aggiungiAuto(a);
		System.out.println("fine");
		
		ArrayList<String> b =new ArrayList<>();
		b.add("ciao");
		System.out.println(b.indexOf("ciao"));
		
		
	
	}
}
