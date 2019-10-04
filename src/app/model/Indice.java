package app.model;

import java.util.Comparator;

public class Indice implements Comparable<Indice> {



	private int n;
	//offset
	private String targa;
	
	
	 
	public Indice(int n, String targa, int o) {
		super();
		this.n = n;
		this.targa = targa;
	}

	@Override
	public String toString() {
		return "n=" + n + ", targa=" + targa+"\n";
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getN() {
		return n;
	}



	public String getTarga() {
		return targa;
	}

	//public int getOffset(){
//		return offset;
//	}

	

	@Override
	public int compareTo(Indice o) {
		
		return targa.compareTo(o.getTarga());
	}


	 
}
