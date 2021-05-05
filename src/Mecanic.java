
public class Mecanic extends Angajat{

	Mecanic(String nume, String prenume, String dataNastere, String dataAngajare) {
		super(nume, prenume, dataNastere, dataAngajare);

	}
	
	@Override
	public void afisareAngajat() {
		System.out.println(this.idAngajat + " " + this.nume + " " + this.prenume + " " + this.dataNastere + " " + this.dataAngajare + " " + this.coefSalarial+" - Mecanic");
	}

}
