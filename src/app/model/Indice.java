package app.model;

import java.util.Comparator;

public class Indice implements Comparable<Indice> {

	public void setN(int n) {
		this.n = n;
	}


	private int n,offset;
	private String targa;
	
	 
	public Indice(int n, String targa, int o) {
		super();
		this.n = n;
		this.targa = targa;
		this.offset=o;
	}

	@Override
	public String toString() {
		return "n=" + n + ", targa=" + targa + ", offset=" + offset;
	}



	public int getN() {
		return n;
	}


	public int getOffset() {
		return offset;
	}


	public String getTarga() {
		return targa;
	}

	

	

	@Override
	public int compareTo(Indice o) {
		
		return targa.compareTo(o.getTarga());
	}


	 
}
