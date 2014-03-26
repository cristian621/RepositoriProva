/*
 *Practica entorns programació.
 * Cristian Martínez García
 * Jaume Mayol Hervás 
 */

package testsProjecte;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projecte.Acussat;
import projecte.Advocat;
import projecte.Cas;
import projecte.Jutge;
import projecte.Jutjat;
import projecte.Sala;

public class JutjatTest {

	Jutjat jutjat1;
	Sala sala1;
	Sala sala2;
	Jutge garzon;
	Jutge castro;
	Advocat pepe;
	Advocat juan;
	Acussat paca;
	Cas numero1;
	SimpleDateFormat sdf;

	@Before
	public void setUpBeforeClass() throws Exception {
		/** --Cream un objecte de cada classe (Jutges, sales, acussats, etc.-- */
		jutjat1 = new Jutjat("Instrucci� n�1", "Palma");
		sala1 = new Sala();
		sala2 = new Sala();
		garzon = new Jutge("5", "41234567D", "Baltasar", "Garzon", "Melchor");
		castro = new Jutge("5", "49672405E", "Fidel", "Castro", "Melchor");
		pepe = new Advocat("49857608T", "Pepe", "Phone", "Estafador");
		juan = new Advocat("46784523T", "Juan", "Sol", "Justiciero");
		paca = new Acussat("Paca", "Desconocido", "Desconocido", "Mujer",
				"04/05/1977", "Espana", "Son Banya", "Prision preventiva");

		/*** Cream un nou cas amb els objectes creats anteriorment al constructor */
		numero1 = new Cas(garzon, paca, pepe, juan, "07/08/2012", sala1,
				"Contrabando");

		/** Modificam la sent�ncia */
		numero1.setSentencia("Condemnat a 5 anys de pressó");

		/**
		 * Per modificar la data de fi del cas, hem de passar d'una String a
		 * Date a una variable: Cream un objecte sdf de tipus SimpleDateFormat i
		 * anyadim al parametre de format el que volem per dates.
		 */
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		/**
		 * cream una variable tipus Date i feim sdf.parse(data que volem), click
		 * dret i triam el que diu try. Ens crea aquest conjunt de l�nies i
		 * posam dins el try el setData_Fi amb la variable creada.
		 */
		try {
			Date data;
			data = sdf.parse("07/04/2013");
			numero1.setData_Fi(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Test
	public void testAfegirJutge() {
		/**Afegim el jutge*/
		jutjat1.afegirJutge(garzon);
		/**Declarem variable booleana per comparar el resultat*/
		boolean resultat = false;
		/**Cream una nova llista d'array on emmatgazemar el jutge nou*/
		ArrayList<Jutge> llista = jutjat1.getLlistaJutges();
		/**Recorrem la llista per confirmar que s'ha afegit*/
		for (Jutge d: llista) {
			/**Comprovar que el nom és a la llista. Si és, s'ha pogut afegir.*/
			if(d.getNom()==garzon.getNom()){
				resultat = true;
			} else {
				System.out.println("No s'ha pogut afegir");
			}
			/**Torna la comparació*/
		assertEquals(true, resultat);
	}
	}

	@Test
	public void testAfegirSala() {
		/**Afegim la sala*/
		jutjat1.afegirSala(sala1);
		/**Declarem variable booleana per comparar el resultat*/
		boolean resultat = false;
		/**Cream una nova llista d'array on emmatgazemar la sala*/
		ArrayList<Sala> llista = jutjat1.getLlistaSales();
		/**Recorrem la llista per confirmar que s'ha afegit*/
		for (Sala d: llista){
			/**Comprovar que el nom és a la llista. Si és, s'ha pogut afegir.*/
			if(d.getId_Sala()==sala1.getId_Sala()){
				resultat = true;
			}else {
				System.out.println("No s'ha pogut afegir");
			}
		}
		/**Torna la comparació*/
		assertEquals(true, resultat);
	}

	@Test
	public void testAfegirCas() {
		/**Afegim el cas*/
		jutjat1.afegirCas(numero1);
		/**Declarem variable booleana per comparar el resultat*/
		boolean resultat = false;
		/**Cream una nova llista d'array on emmatgazemar la sala*/
		ArrayList<Cas> llista = jutjat1.getLlistaCasos();
		/**Recorrem la llista per confirmar que s'ha afegit*/
		for (Cas d: llista){
			/**Comprovar que el nom és a la llista. Si és, s'ha pogut afegir.*/
			if(d.getId_cas()==numero1.getId_cas()){
				resultat = true;
			}else {
				System.out.println("No s'ha pogut afegir");
			}
		}
		/**Torna la comparació*/
		assertEquals(true, resultat);
	}

	@Test
	public void testTrobarCas() {
		/**Afegim el Cas a la llista*/
		jutjat1.afegirCas(numero1);
		
		/**obtenim la ID del cas amb el seu getter*/
		int numero=numero1.getId_cas();
		
		/**Ficam el resultat de trobar cas dins un cas nou*/
		Cas prova=jutjat1.trobarCas(numero);
		
		/**ara obtenim la id del cas que ens ha retornat el "trobarCas" amb el seu getter*/
		int numero2=prova.getId_cas();
		
		/**Amb el assertEquals comprovam que totes dues ID's son iguales*/
		assertEquals(numero,numero2);
	}

	@Test
	/**
	 * - Cream un arraylist de casos i afegim el cas numero1.
	 * - Cream una variable booleana i una de tipus sencer.
	 * - Afegim el cas numero1 al jutjat.
	 * - Cream un arraylist de casos i ficam l'arraylist que retorna el mètode
	 * - Comparam el contingut dels dos arraylist amb un for dins un altre for i incrementam el contador
	 * per cada coincidencia.
	 * - Comprovam que el valor de contador es el mateix que la longitud del primer arraylist.
	 * - AssertEquals del resultat.
	 */
	public void testCercarCasosAcussat() {
		ArrayList<Cas> casos= new ArrayList<Cas>();
		casos.add(numero1);
		boolean resultat=false;
		int contador=0;
		jutjat1.afegirCas(numero1);
		ArrayList<Cas> casosAcussat=jutjat1.cercarCasosAcussat(paca);
		for (Cas d: casos){
			for(Cas x: casosAcussat){
				if(d==x){
					contador++;
				}
			}
		}
		if(contador==casos.size()){
			resultat=true;
		}
		assertEquals(true, resultat);
	}

	@Test
	/**
	 * - Cream un arraylist de casos i afegim el cas numero1.
	 * - Cream una variable booleana i una de tipus sencer.
	 * - Afegim el cas numero1 al jutjat.
	 * - Cream un arraylist de casos i ficam l'arraylist que retorna el mètode
	 * - Comparam el contingut dels dos arraylist amb un for dins un altre for i incrementam el contador
	 * per cada coincidencia.
	 * - Comprovam que el valor de contador es el mateix que la longitud del primer arraylist.
	 * - AssertEquals del resultat.
	 */
	public void testCercarCasosAdvocat() {
		ArrayList<Cas> casos= new ArrayList<Cas>();
		casos.add(numero1);
		boolean resultat=false;
		int contador=0;
		jutjat1.afegirCas(numero1);
		ArrayList<Cas> casosAdvocat=jutjat1.cercarCasosAdvocat(pepe, 3);
		for (Cas d: casos){
			for(Cas x: casosAdvocat){
				if(d==x){
					contador++;
				}
			}
		}
		if(contador==casos.size()){
			resultat=true;
		}
		assertEquals(true, resultat);
		
	}

	@Test
	public void testCercarCasosJutge() {
		
			/**Creem nou ArrayList*/
			ArrayList<Cas> casos= new ArrayList<Cas>();
			
			/**Afegim el cas numero 1 al nou array creat*/
			casos.add(numero1);
			
			/**Declarem booleà per la posterior comprovació*/
			boolean resultat=false;
			
			/**Comptador per comparar*/
			int contador=0;
			
			/**afegir el cas a l'ArrayList de Jutjat 1. Si no, el mètode cercarCasosJutge
			 * no trobarà el cas*/
			jutjat1.afegirCas(numero1);
			
			/**Nou array que agafa l'ArrayList de cercarAcussats*/
			ArrayList<Cas> casosJutge=jutjat1.cercarCasosJutge(garzon);
			
			/**Estructura for per recorrer la llista array inicial
			 * i comparar-la amb la llista array de cercarAcussats*/
			for (Cas d: casos){
				for(Cas x: casosJutge){
					/**Si se troba en les dues llistes, incrementem comptador*/
					if(d==x){
						contador++;
					}
				}
			}
			
			/**En haver comparat el tamany si s'han trobat els mateixos acussats
			 * és que apareixen tots els acussats enregistrats, si no, error*/
			if(contador==casos.size()){
				resultat=true;
			}
			assertEquals(true, resultat);
			
		}

	@Test
	public void testCercarAcussats() {
		
		/**Creem nou ArrayList*/
		ArrayList<Acussat> acussats= new ArrayList<Acussat>();
		
		/**Afegim l'acussada*/
		acussats.add(paca);
		
		/**Declarem booleà per la posterior comprovació*/
		boolean resultat=false;
		
		/**Comptador per comparar*/
		int contador=0;
		
		/**Afegim el cas que contindrà l'acussada paca*/
		jutjat1.afegirCas(numero1);
		
		/**Nou array que agafa la llista array de cercarAcussats*/
		ArrayList<Acussat> llista =jutjat1.cercarAcussats();
		
		/**Estructura for per recorrer la llista array inicial
		 * i comparar-la amb la llista array de cercarAcussats*/
		for (Acussat d: acussats){
			for(Acussat x: llista){
				/**Si se troba en les dues llistes, incrementem comptador*/
				if(d==x){
					contador++;
				}
			}
		}
		
		/**En haver comparat el tamany si s'han trobat els mateixos acussats
		 * és que apareixen tots els acussats enregistrats, si no, error*/
		if(contador==acussats.size()){
			resultat=true;
		}
		assertEquals(true, resultat);
		
	}


	@Test
	public void testCercarAdvocats() {
		/**Afegim el cas a la llista de casos del jutjat*/
		jutjat1.afegirCas(numero1);
		
		/**Cream un nou arraylist d'advocats*/
		ArrayList<Advocat> advocats=new ArrayList<Advocat>();
		
		/**Afegim els dos advocats que tenim a la llista previament creada*/
		advocats.add(pepe);
		advocats.add(juan);
		
		/**cream un nou arraylist "llista" i ficam dins l'arraylist d'advocats que retorna el mètode "CercarAdvocats"*/
		ArrayList<Advocat> llista=jutjat1.cercarAdvocats();
		
		/**Inicialitzam el contador a 0 per poder comprovar que ambdúes llistes són iguals*/
		int contador=0;
		
		/**Inicialitzam la variable booleana que ens servirá al final per l'assertEquals*/
		boolean resultat=false;
		
		/**Ara cream un for que recorri la primera llista creada, i dins d'aquest, cream un altre for que recorri
		 * la llista que varem crear ficant la llista que retorna el mètode "cercarAdvocats".
		 * Seguidament, dins del darrer ficarem un if que comprovara que els advocats que hi ha a les dues llistes
		 * són els mateixos, i sumará un al contador per cada coincidència.
		 */
		for(Advocat d: advocats){
			for (Advocat x: llista) {
				if(d==x) {
					contador++;
				}
			}
		}
		
		/**Finalment, hem de comprovar que el contador té el mateix número que la longitud de la primera llista creada,
		 * que es la que té la llista correcta. Si el contador és igual, posam la variable booleana resultat com a true
		 * i l'assertEquals sortirá correcte. En cas de que no hagi trobat tots els advocats de la primera llista a la
		 * segona, deixará la variable booleana a false i l'assertEquals no sortirá correctament.
		 */
		if (contador==advocats.size()){
			resultat=true;
		}
		assertEquals(true, resultat);
	}

	@Test
	public void testCulpablesCasos() {
		/**Afegim el cas a la llista de casos del jutjat*/
		jutjat1.afegirCas(numero1);
		
		/**Posam la variable culpable del cas com a true*/
		numero1.setCulpable(true);
		
		/**Cream un arraylist de cas nou i ficam dins l'arraylist de cas que retorna el mètode "culpablescasos",
		 * que són els casos als que l'acussat ha resultat culpable. */
		ArrayList<Cas> casos=jutjat1.culpablesCasos(1);
		
		/**Finalment, cream una variable tipus int amb el nom de "numero", i ficam dins la longitud de l'arraylist
		 * creat anteriorment. Comprovam a l'asertEquals que aquest numero és igual al numero de casos que 
		 * l'acussat és culpable, que en el nostre cas nomes es un, el que hem posat true a culpable ("numero1").
		 */
		int numero=casos.size();
		assertEquals(1, numero);
	}

}
