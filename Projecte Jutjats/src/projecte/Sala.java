package projecte;
import java.util.ArrayList;
import java.util.Date;

public class Sala {

	private int id_Sala;
	private ArrayList<Date> llistaDatesOcupada;
	private static int numeroSales=1;
	
	// ---GETTERS I SETTERS---
	public int getId_Sala() {
		return id_Sala;
	}

	/**Constructor per crear una sala.
	 * 
	 */
	public Sala() {
		super();
		this.id_Sala = numeroSales++;
		llistaDatesOcupada= new ArrayList<Date>();
		
		
	}
	
	/**--- METODE PER AFEGIR DATES EN QUE ESTARÁ OCUPADA LA SALA---*/
	
	public ArrayList<Date> getLlistaDatesOcupada() {
		return llistaDatesOcupada;
	}

	/**Mètode per afegir una data en la que estará ocupada aquesta sala.
	 * 
	 * @param data Data que afegim com a ocupada a la llista.
	 */
	public void afegirDataOcupada(Date data) {
		llistaDatesOcupada.add(data);
	}
	
	
}
