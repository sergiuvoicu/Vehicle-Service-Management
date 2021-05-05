
public class Director extends Angajat {
	
	Director(String nume, String prenume, String dataNastere, String dataAngajare) {
		super(nume, prenume, dataNastere, dataAngajare);
		this.coefSalarial = 2;
	}
	
	@Override
	public void afisareAngajat() {
		System.out.println(this.idAngajat + " " + this.nume + " " + this.prenume + " " + this.dataNastere + " " + this.dataAngajare + " " + this.coefSalarial+" - Director");
	}

}
