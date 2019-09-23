package app.model;

public class Auto {
	
	private String targa,descr,anno;
	private long km,prezzo;
	
	public Auto(String targa, String descr, String anno, long km, long prezzo) {
		super();
		this.targa = targa;
		this.descr = descr;
		this.anno = anno;
		this.km = km;
		this.prezzo = prezzo;
	}

	public String getTarga() {
		return targa;
	}

	public String getDescr() {
		return descr;
	}

	public String getAnno() {
		return anno;
	}

	public long getKm() {
		return km;
	}

	public long getPrezzo() {
		return prezzo;
	}
	
	

}
