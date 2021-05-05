import java.time.LocalDate;

public class MasinaStandard extends Masina {
	
	private Transmisie transmisie;
	
	MasinaStandard(){}
	
	MasinaStandard(long nrKm, int an, boolean isDiesel, Transmisie t) {
		super(nrKm, an, isDiesel);
		this.transmisie = t;
	}

	@Override
	public float calculPolita(TipPolita mod) {
		
		LocalDate dataCurenta = LocalDate.now();
		int vechime = dataCurenta.getYear() - this.anFabricatie;
		float sum = vechime*100;
		
		if(this.isDiesel)
			sum += 500;
		if(this.nrKm >= 200000)
			sum += 500;
		
		if(mod == TipPolita.DISCOUNT)
			sum -= 0.05*sum;

		
		return sum;
		
	}
	
	@Override
	public void afisareMasina() {
		String combustibil = this.isDiesel? "Diesel" : "Benzina";
		System.out.println("Masina Standard- "+ this.idMasina+" "+ this.nrKm+"km "+this.anFabricatie+" "+ combustibil+" "+ transmisie );
	}
	


}
