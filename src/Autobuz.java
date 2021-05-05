import java.time.LocalDate;

public class Autobuz extends Masina {
	
	private int nrLocuri;

	Autobuz(long nrKm, int an, boolean isDiesel, int nrLocuri) {
		super(nrKm, an, isDiesel);
		this.nrLocuri = nrLocuri;
	}


	@Override
	public float calculPolita(TipPolita mod) {
		
		LocalDate dataCurenta = LocalDate.now();
		int vechime = dataCurenta.getYear() - this.anFabricatie;
		float sum = vechime*200;
		
		if(this.isDiesel)
			sum += 1000;
		if(this.nrKm >= 200000)
			sum += 1000;
		else if( this.nrKm >= 100000)
			sum += 500;
		
		if(mod == TipPolita.DISCOUNT)
			sum -= 0.1*sum;
		
		return sum;
	}
	
	@Override
	public void afisareMasina() {
		String combustibil = this.isDiesel? "Diesel" : "Benzina";
		System.out.println("Autobuz- "+ this.idMasina+" "+ this.nrKm+"km "+this.anFabricatie+" "+ combustibil+" "+ nrLocuri+ " locuri" );
	}

}
