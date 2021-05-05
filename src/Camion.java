import java.time.LocalDate;

public class Camion extends Masina {
	
	private double tonaj;

	Camion(long nrKm, int an, boolean isDiesel, double tonaj) {
		super(nrKm, an, isDiesel);
		this.tonaj = tonaj;
	}

	@Override
	public float calculPolita(TipPolita mod) {
		
		LocalDate dataCurenta = LocalDate.now();
		int vechime = dataCurenta.getYear() - this.anFabricatie;
		float sum = vechime*300;
		
		if(this.nrKm >= 800000)
			sum += 700;
		
		if( mod == TipPolita.DISCOUNT)
			sum -= 0.15*sum;
		
		return sum;
	}
	

	@Override
	public void afisareMasina() {
		String combustibil = this.isDiesel? "Diesel" : "Benzina";
		System.out.println("Camion- "+ this.idMasina+" "+ this.nrKm+"km "+this.anFabricatie+" "+ combustibil+" "+ tonaj+ " tone" );
	}
	

}
