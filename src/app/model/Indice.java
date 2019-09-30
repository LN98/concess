package app.model;

public class Indice {

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


	 
}
