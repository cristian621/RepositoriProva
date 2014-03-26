package projecte;


public class Jutge {

	private int id_Jutge;
	private String id_Colegio;
	private String dni;
	private String nom;
	private String cognom1;
	private String cognom2;
	private static int numeroJutges=1;
	
	//GETTERS
	public int getId_Jutge() {
		return id_Jutge;
	}
	public String getId_Colegio() {
		return id_Colegio;
	}
	public String getDNI() {
		return dni;
	}
	public String getNom() {
		return nom;
	}
	public String getCognom1() {
		return cognom1;
	}
	public String getCognom2() {
		return cognom2;
	}

	/**Constructor de Jutge.
	 * 
	 * @param id_Colegio La id del colegi al que pertany
	 * @param dni El DNI del jutge
	 * @param nom El nom del jutge
	 * @param cognom1 El cognom del jutge
	 * @param cognom2 El segon cognom del jutge
	 */
	public Jutge(String id_Colegio, String dni, String nom,
			String cognom1, String cognom2) {
		super();
		this.id_Jutge = numeroJutges++;
		this.id_Colegio = id_Colegio;
		this.dni = dni;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
	}
	
	
}
