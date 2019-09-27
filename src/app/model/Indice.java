package app.model;

public class Indice {

	private int n,offset;
	private String targa;
	private boolean attivo;
	
	 
	public Indice(int n, String targa, int o) {
		super();
		this.n = n;
		this.targa = targa;
		this.offset=o;
		attivo=true;
	}

	@Override
	public String toString() {
		return "n=" + n + ", targa=" + targa + ", offset=" + offset + " attivo=" + attivo+"\n";
	}


	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
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


	public boolean isAttivo() {
		return attivo;
	}
	 
	 
}
