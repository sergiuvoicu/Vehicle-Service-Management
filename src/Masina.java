
public abstract class Masina {
	
	private static int idCurent = 0;
	protected int idMasina;
	protected long nrKm;
	protected int anFabricatie;
	protected boolean isDiesel;
	
	Masina(){}
	
	Masina( long nrKm, int an, boolean isDiesel){
		
		idCurent += 1;
		this.idMasina = idCurent;
		this.nrKm = nrKm;
		this.anFabricatie = an;
		this.isDiesel = isDiesel;
	}
	
	public int getAnFabricatie() {
		return this.anFabricatie;
	}
	
	abstract public float calculPolita(TipPolita mod);
	abstract public void afisareMasina();

}
