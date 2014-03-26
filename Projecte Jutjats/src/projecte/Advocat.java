package projecte;

public class Advocat {

	private int id_advocat;
	private String dni;
	private String nom;
	private String cognom1;
	private String cognom2;
	private static int numeroAdvocats=1;
	
	// -- GETTERS I SETTERS --
	
	public int getId_advocat() {
		return id_advocat;
	}

	public String getDni() {
		return dni;
	}

	public String getNom() {
		return nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public String getConom2() {
		return cognom2;
	}

	
	/**
	 * Constructor d'Advocat.
	 * Serveix per crear un advocat amb les seves característiques específiques.
	 * @param dni String amb el DNI de l'advocat
	 * @param nom String amb el nom de l'advocat
	 * @param cognom1 String amb el cognom de l'advocat
	 * @param cognom2 String amb el cognom de l'advocat
	 */
	
	public Advocat(String dni, String nom, String cognom1,
			String cognom2) {
		super();
		this.id_advocat = numeroAdvocats++;
		this.dni = dni;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
	}
	
	
}
