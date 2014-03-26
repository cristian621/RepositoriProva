package projecte;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pruebas {
	/**
	 * M�tode per mostrar els casos d'un arraylist, important per provar els nostres m�todes a la classe de proves.
	 */
	public static void mostrarCasos(ArrayList<Cas> llista) {
		for (Cas d: llista){
			if (llista == null) {
				System.out.println("error");
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			System.out.println("Numero cas: "+d.getId_cas());
			System.out.println("Acussat: "+d.getAcussat().getNom());
			System.out.println("Advocat Acusacio: "+d.getAdvocat_Acusacio().getNom());
			System.out.println("Advocat Defensor: "+d.getAdvocat_Defensor().getNom());
			System.out.println("Data inici: "+sdf.format(d.getData_Inici()));
			System.out.println("Data fi: "+sdf.format(d.getData_Fi()));
			System.out.println("Delicte: "+d.getDelicte());
			System.out.println("Jutge: "+d.getJutge().getNom());
			System.out.println("Sala: "+d.getSala().getId_Sala());
			System.out.println("Sentencia: "+d.getSentencia());
			System.out.println();
		}
	}

	public static void main(String[] args) {

		/**--Cream un objecte de cada classe (Jutges, sales, acussats, etc.--*/
		Jutjat jutjat1 = new Jutjat("Instrucci� n�1", "Palma");
		Sala sala1 = new Sala();
		Sala sala2 = new Sala();
		Jutge garzon = new Jutge("5", "41234567D", "Baltasar", "Garz�n",
				"Melchor");
		jutjat1.afegirJutge(garzon);
		Jutge castro = new Jutge("5", "49672405E", "Fidel", "Castro", "Melchor");
		Advocat pepe = new Advocat("49857608T", "Pepe", "Phone", "Estafador");
		Advocat juan = new Advocat("46784523T", "Juan", "Sol", "Justiciero");
		Acussat paca = new Acussat("Paca", "Desconocido", "Desconocido",
				"Mujer", "04/05/1977", "Espa�a", "Son Banya",
				"Prisi�n preventiva");

		/***Cream un nou cas amb els objectes creats anteriorment al constructor*/
		Cas numero1 = new Cas(garzon, paca, pepe, juan, "07/08/2012", sala1,
				"Contrabando");
		
		/**Modificam la sent�ncia*/
		numero1.setSentencia("Condenat a 5 anys de prisi�");
		
		/**Per modificar la data de fi del cas, hem de passar d'una String a Date a una variable:
		Cream un objecte sdf de tipus SimpleDateFormat i anyadim al parametre de format el que volem per dates.*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		/**cream una variable tipus Date i feim sdf.parse(data que volem), click dret i triam el que diu try.
		Ens crea aquest conjunt de l�nies i posam dins el try el setData_Fi amb la variable creada.*/
		try {
	        Date data;
			data = sdf.parse("07/04/2013");
			numero1.setData_Fi(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		/**afegim un cas a la llista de casos del jutjat*/
		jutjat1.afegirCas(numero1);
		/**Cercam el cas per la seva id a la llista de casos dels jutjats*/
		if (jutjat1.trobarCas(1) == null) {
			System.out.println("No s'ha trobat el cas.");
		}
		else {
			System.out.println("El cas s'ha trobat correctament.");
		}
		
		/**Probam el metode de cercar casos per acussat, que crea un arraylist dels casos d'aquest acussat.*/
		ArrayList<Cas> casosPaca=new ArrayList<Cas>();
		casosPaca=jutjat1.cercarCasosAcussat(paca);
		//mostrarCasos(casosPaca);
		
		
		/** Probam el metode per cercar casos per advocat, el qual crea un arraylis dels casos de cada advocat.
		 Hem de introdu�r com a par�metres: el advocat, i un n�mero, que fa refer�ncia a: 1: casos al que ha estat 
		 defensor, 2: casos al que ha estat de l'acusaci� o 3, tots els casos possibles.
		*/
		ArrayList<Cas> casosPepe=new ArrayList<Cas>();
		casosPepe=jutjat1.cercarCasosAdvocat(pepe, 3);
		//mostrarCasos(casosPepe);
		
		
		/**
		 * Probam el m�tode per cercar casos per Jutge, el qual tamb� retorna un ArrayList amb els seus casos.
		 */
		
		ArrayList<Cas> casosGarzon=jutjat1.cercarCasosJutge(garzon);
		//mostrarCasos(casosGarzon);
		
		
		
		 /** Probam el m�tode de cercar <em>Acussats</em>, el qual ens retorna una llista amb tots els acussats que hi ha
		 * als casos del nostre jutjat.*/
		 
		ArrayList<Acussat> acussats = jutjat1.cercarAcussats();
		for (Acussat d: acussats) {
			System.out.println(d.getNom());
		}
		
		
		
		 /** Probam el m�tode de cercar Advocats, el qual ens retorna una llista amb tots els advocats que hi ha
		 * als casos del nostre jutjat.*/
		
		ArrayList<Advocat> advocats = new ArrayList<Advocat>();
		advocats=jutjat1.cercarAdvocats();
		for (Advocat d: advocats) {
			
			System.out.println(d.getNom());
		}
		
		/** Probam el m�tode per cercar els casos en els que el acussat ha resultat culpable o no, ficant un parametre:
		 * si ficam 1 ens tornara un arraylist amb els casos en que els acussats han resultat culpables,
		 * si ficam 2 ens tornara l'arraylist dels casos que NO han resultat culpables.
		 */
		
		/** Abans, modificarem la variable "culpable" del cas numero1.*/
		numero1.setCulpable(true);
		ArrayList<Cas> culpables = jutjat1.culpablesCasos(1);
		for(Cas d: culpables) {
			System.out.println(d.getId_cas());
		}
		/**Ens donar� una llista amb les ID's dels casos als que el acussat ha resultat culpable.*/
	}

}
