
import java.time.LocalDate;
import java.time.Period;


public class Angajat {
	private static int idCurent = 0;
	protected int idAngajat;
	protected String nume;
	protected String prenume;
	protected String dataNastere;
	protected String dataAngajare;
	protected double coefSalarial = 1.5;
	private boolean isBusy = false;
	private int nrMasini = 0;
	private float valoarePolite = 0;
	private int nrAutobuze = 0;
	private int nrRezervari = 0;
	private float bacsis = 0;
	private int nrMasiniCurente = 0;
	
	
	Angajat(String nume, String prenume, String dataNastere, String dataAngajare){
		
		idCurent += 1;
		this.idAngajat = idCurent;
		modifAngajat(nume, prenume, dataNastere, dataAngajare);
	}
	
	
	public void modifAngajat(String nume, String prenume, String dataNastere, String dataAngajare) {
		
		this.nume = nume;
		this.prenume = prenume;
		this.dataNastere = dataNastere;
		this.dataAngajare = dataAngajare;
		
	}
	
	public double getSalariu() {
		
		LocalDate dataCurenta = LocalDate.now();
		LocalDate dataAng  = LocalDate.parse(this.dataAngajare);
		
		int aniVechime = Period.between(dataAng, dataCurenta).getYears();

		return aniVechime*coefSalarial*1000;
	}
	public String getNume() {
		return this.nume;
	}
	public String getPrenume() {
		return this.prenume;
	}
	
	public int getId() {
		return this.idAngajat;
	}
	public boolean getIsBusy() {
		return this.isBusy;
	}
	public void toggleBusy() {

		if(this.isBusy)
			this.isBusy = false;
		else this.isBusy = true;
	}
	public void incNrMasini() {
		this.nrMasini += 1;
	}
	public int getNrMasini() {
		return this.nrMasini;
	}
	public void incNrAutobuze() {
		this.nrAutobuze += 1;
	}
	public int getNrAutobuze() {
		return this.nrAutobuze;
	}
	public void incNrRezervari() {
		this.nrRezervari += 1;
	}
	public int getNrRezervari() {
		return this.nrRezervari;
	}
	public void incBacsis(float tip) {
		this.bacsis += tip;
	}
	public float getBacsis() {
		return this.bacsis;
	}
	public void incValoarePolite(float polita) {
		this.valoarePolite += polita;
	}
	public float getValoarePolite() {
		return this.valoarePolite;
	}
	public void incNrMasiniCurente() {
		this.nrMasiniCurente += 1;
	}
	public void decNrMasiniCurente() {
		this.nrMasiniCurente -= 1;
	}
	public int getNrMasiniCurente() {
		return this.nrMasiniCurente;
	}

	public void afisareAngajat() {
		System.out.println(this.idAngajat + " " + this.nume + " " + this.prenume + " " + this.dataNastere + " " + this.dataAngajare + " " + this.coefSalarial);
	}

}
