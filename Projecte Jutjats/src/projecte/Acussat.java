package projecte;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Acussat {

	private int id_Acussat;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String genere;
	private Date edat;
	private String nacionalitat;
	private String empadronament;
	private String estat;
	private static int numeroAcussats=1;

	public int getId_Acussat() {
		return id_Acussat;
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

	public String getGenere() {
		return genere;
	}

	public Date getEdat() {
		return edat;
	}

	public String getNacionalitat() {
		return nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) {
		this.nacionalitat = nacionalitat;
	}

	public String getEmpadronament() {
		return empadronament;
	}

	public void setEmpadronament(String empadronament) {
		this.empadronament = empadronament;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	/**
	 * Constructor d'Acussat.
	 * Serveix per crear un acussat amb les seves característiques específiques.
	 * @param nom String amb el nom de l'acussat.
	 * @param cognom1 String amb el cognom de l'acussat.
	 * @param cognom2 String amb el cognom de l'acussat.
	 * @param genere String amb el genere de l'acussat.
	 * @param edat String amb la edat de l'acussat.
	 * @param nacionalitat String amb la nacionalitat de l'acussat.
	 * @param empadronament String amb el lloc d'empadronament de l'acussat.
	 * @param estat String amb l'estat de l'acussat. Pot ser en llibertat, libertat condicional, a pressó, etc.
	 */

	public Acussat(String nom, String cognom1, String cognom2,
			String genere, String edat, String nacionalitat,
			String empadronament, String estat) {
		super();
		this.id_Acussat = numeroAcussats++;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.genere = genere;
		this.nacionalitat = nacionalitat;
		this.empadronament = empadronament;
		this.estat = estat;
		 String format = "dd/MM/yyyy";
         SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
			this.edat = sdf.parse(edat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
