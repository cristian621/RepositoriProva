package projecte;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cas {

	private int id_cas;
	private Jutge jutge;
	private Acussat acussat;
	private Advocat advocat_Defensor;
	private Advocat advocat_Acusacio;
	private Date data_Inici;
	private Date data_Fi;
	private String sentencia;
	private Sala sala;
	private String delicte;
	private Boolean culpable;
	private static int numeroCasos=1;
	
	// ---GETTERS I SETTERS ---
	public Advocat getAdvocat_Defensor() {
		return advocat_Defensor;
	}
	public void setAdvocat_Defensor(Advocat advocat_Defensor) {
		this.advocat_Defensor = advocat_Defensor;
	}
	public Advocat getAdvocat_Acusacio() {
		return advocat_Acusacio;
	}
	public void setAdvocat_Acusacio(Advocat advocat_Acusacio) {
		this.advocat_Acusacio = advocat_Acusacio;
	}
	public Date getData_Fi() {
		return data_Fi;
	}
	public void setData_Fi(Date data_Fi) {
		this.data_Fi = data_Fi;
	}
	public String getSentencia() {
		return sentencia;
	}
	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Boolean getCulpable() {
		return culpable;
	}
	public void setCulpable(Boolean culpable) {
		this.culpable = culpable;
	}
	public int getId_cas() {
		return id_cas;
	}
	public Jutge getJutge() {
		return jutge;
	}
	public Acussat getAcussat() {
		return acussat;
	}
	public Date getData_Inici() {
		return data_Inici;
	}
	public String getDelicte() {
		return delicte;
	}
	
	/**
	 * Constructor d'un cas.
	 * Serveix per crear un cas amb les seves característiques específiques.
	 * @param jutge Tipus Jutge, ficam "l'objecte" de jutge sencer.
	 * @param acussat Tipus acussat, aquí ficam l'acussat.
	 * @param advocat_Defensor Tipus advocat, aquí ficam l'advocat defensor del cas.
	 * @param advocat_Acusacio Tipus advocat, aquí ficam l'advocat d'acusació del cas.
	 * @param data_Inici String amb la data d'inici del cas.
	 * @param sala Tipus Sala, ficarem la sala assignada al cas.
	 * @param delicte Un String amb el delicte fet per l'acussat del cas.
	 */
	public Cas(Jutge jutge, Acussat acussat,
			Advocat advocat_Defensor, Advocat advocat_Acusacio,
			String data_Inici, Sala sala, String delicte) {
		super();
		this.id_cas = numeroCasos++;
		this.jutge = jutge;
		this.acussat = acussat;
		this.advocat_Defensor = advocat_Defensor;
		this.advocat_Acusacio = advocat_Acusacio;
		 String format = "dd/MM/yyyy";
         SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
			this.data_Inici = sdf.parse(data_Inici);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sala = sala;
		this.delicte = delicte;
	}
	
	
	
	
	
	
	
	
}
