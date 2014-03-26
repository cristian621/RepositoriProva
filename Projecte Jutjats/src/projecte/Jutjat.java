/*
 * Projecte de Programació.
 * Cristian Martínez García
 * Jaume Mayol Hervás
 * 
 * Inclou el javadoc completament comentat i explicat.
 */

package projecte;

import java.util.ArrayList;

public class Jutjat {

	private int id_Jutjat;
	private String nom;
	private String poblacio;
	private ArrayList<Jutge> llistaJutges;
	private ArrayList<Sala> llistaSales;
	private ArrayList<Cas> llistaCasos;
	private static int numeroJutjats = 1;

	// -- GETTERS I SETTERS --
	public int getId_Jutjat() {
		return id_Jutjat;
	}

	public String getNom() {
		return nom;
	}

	public String getPoblacio() {
		return poblacio;
	}

	// ---GETTERS PER OBTENIR LES LLISTES DEL JUTJAT, JUTGES, SALES I CASOS.
	public ArrayList<Jutge> getLlistaJutges() {
		return llistaJutges;
	}

	public ArrayList<Sala> getLlistaSales() {
		return llistaSales;
	}

	public ArrayList<Cas> getLlistaCasos() {
		return llistaCasos;
	}

	/**Constructor per crear un jutjat
	 * 
	 * @param nom Nom del jutjat
	 * @param poblacio Població on es troba el jutjat
	 */
	public Jutjat(String nom, String poblacio) {
		super();
		this.id_Jutjat = numeroJutjats++;
		this.nom = nom;
		this.poblacio = poblacio;
		llistaJutges = new ArrayList<Jutge>();
		llistaSales = new ArrayList<Sala>();
		llistaCasos = new ArrayList<Cas>();

	}

	/** Mètodes per afegir Jutjes, Sales i Casos a les llistes corresponents.*/
	public void afegirJutge(Jutge jutge) {
		llistaJutges.add(jutge);
	}

	public void afegirSala(Sala sala) {
		llistaSales.add(sala);
	}

	public void afegirCas(Cas cas) {
		llistaCasos.add(cas);
	}

	/** Cercam un cas per la seva ID i ens retorna el cas sencer*/
	public Cas trobarCas(int id) {
		for (Cas d : llistaCasos) {
			if (d.getId_cas() == id) {
				return d;
			}
		}
		return null;

	}

	/** Cercar casos d'acussats.
	 * Cercam els casos d'un acussat i retornam un arraylist amb tots els casos
	 d'aquest*/
	public ArrayList<Cas> cercarCasosAcussat(Acussat acussat) {
		ArrayList<Cas> casosAcussat = new ArrayList<Cas>();
		for (Cas d : llistaCasos) {
			if (d.getAcussat() == acussat) {
				casosAcussat.add(d);
			}
		}
		return casosAcussat;
	}

	/** Cercar casos d'advocats.
	 * Cercam els casos d'un advocat filtram amb un sencer com a parametre, si
	 * es 1 es torna un arraylist amb els casos que ha estat defensor, si es 2
	 * els casos que ha estat d'acusació, i si es 3 tots els casos en els que ha
	 * participat. Ens retorna l'arraylist segons el parametre triat.
	 */
	public ArrayList<Cas> cercarCasosAdvocat(Advocat advocat, int opcio) {
		ArrayList<Cas> casosAdvocat = new ArrayList<Cas>();
		switch (opcio) {
		case 1: {
			for (Cas d : llistaCasos) {
				if (d.getAdvocat_Defensor() == advocat) {
					casosAdvocat.add(d);
				}
			}
			break;
		}

		case 2: {
			for (Cas d : llistaCasos) {
				if (d.getAdvocat_Acusacio() == advocat) {
					casosAdvocat.add(d);
				}
				
			}
			break;
		}

		case 3: {
			for (Cas d : llistaCasos) {
	
				if (d.getAdvocat_Defensor() == advocat){
					casosAdvocat.add(d);
				}
				else if (d.getAdvocat_Acusacio() == advocat) {
					casosAdvocat.add(d);
				}
				
			}
			break;
		}
		default: {
			return null;
		}
		}
		return casosAdvocat;

	}

	/** Metode per cercar els casos als que participa un jutge.
	 * 
	 * @param jutge Pasam per paràmetre el jutge del que volem cercar els casos.
	 * @return llista Retorna una llista amb els casos de la resolució.
	 */
	public ArrayList<Cas> cercarCasosJutge(Jutge jutge) {
		ArrayList<Cas> casosJutge = new ArrayList<Cas>();
		for (Cas d : llistaCasos) {
			if (d.getJutge() == jutge) {
				casosJutge.add(d);
			}
		}
		return casosJutge;
	}

	/** Llista d'acussats.
	 * Metode per cercar tots els acussats que tenim als casos, sense duplicats.*/
	public ArrayList<Acussat> cercarAcussats() {
		ArrayList<Acussat> llistaAcussats = new ArrayList<Acussat>();
		
		for (Cas d : llistaCasos) {
			boolean trobat=false;
			Acussat nuevo = d.getAcussat();
			for (Acussat p : llistaAcussats) {
				if (p == nuevo) {
					trobat=true;
				}
			}
			if (!trobat) {
				llistaAcussats.add(nuevo);
			}
		}
		return llistaAcussats;
	}

	/** Llista d'advocats.
	 * Metode per cercar tots els advocats que tenim als casos, sense duplicats.*/
	public ArrayList<Advocat> cercarAdvocats() {
		ArrayList<Advocat> llistaAdvocats = new ArrayList<Advocat>();
		for (Cas d : llistaCasos) {
			boolean trobat1=false;
			boolean trobat2=false;
			Advocat nuevo1 = d.getAdvocat_Acusacio();
			Advocat nuevo2 = d.getAdvocat_Defensor();
			for (Advocat p : llistaAdvocats) {
				if (p == nuevo1) {
					trobat1=true;
				}
				if (p == nuevo2) {
					trobat2=true;
				}
			}
			if (!trobat1){
				llistaAdvocats.add(nuevo1);
			}
			if(!trobat2){
				llistaAdvocats.add(nuevo2);
			}
		}
		return llistaAdvocats;
	}

	/** Casos amb resolució "culpable".
	 * Metode per cercar els casos en que el acussat ha resultat culpable o inocent, al parametre
	 * si ficam 1 ens tornara un arraylist amb els casos en que els acussats han resultat culpables,
	 * si ficam 2 ens tornara l'arraylist dels casos que NO han resultat culpables.
	 */

	public ArrayList<Cas> culpablesCasos(int opcio) {
		ArrayList<Cas> casos = new ArrayList<Cas>();
		switch (opcio) {
		case 1: {
			for (Cas d: llistaCasos) {
				if(d.getCulpable()){
					casos.add(d);
				}
			}
		}
		case 2: {
			for (Cas d: llistaCasos) {
				if (!d.getCulpable()){
					casos.add(d);
				}
			}
			
		}
		}
		return casos;
	}
}
