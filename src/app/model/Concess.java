package app.model;

import java.util.ArrayList;
import java.util.List;

public class Concess {
	
	private List<Auto> listaA;
	private List<Indice> listaI;
	
	public Concess() {
		listaA=new ArrayList<>();
		listaI=new ArrayList<>();
	}
	
	public void aggiungiAuto(Auto a, int o ) {
		listaA.add(a);
		
		listaI.add(new Indice(listaA.indexOf(a),a.getTarga(),o));
		
	}

	public void eliminaAuto(String t) {

		for (int i = 0; i < listaI.size(); i++) {
			if (listaI.get(i).getTarga().equalsIgnoreCase(t)) {
				listaI.get(i).setAttivo(false);
				break;
			}
		}

	}
	
	public void listaC() {
		for (int i = 0; i < listaI.size(); i++) {
			if (!listaI.get(i).isAttivo()) {
				for(int k=0;k<i;k++) {
					
				}
			}
		}
		
	}


}
