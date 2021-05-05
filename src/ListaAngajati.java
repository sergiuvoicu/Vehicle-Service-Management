import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Arrays;


public class ListaAngajati {
	
	private Angajat[] angArr = new Angajat[0];
	
	public void adaugaAngajat() {
		
		try {
						
			BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
			String nume = "";
			String prenume = "";
			String dataNastere = "";
			String dataAngajare = "";
			
			
			int varsta = 0;
			
			while( nume.length() <= 0 || nume.length() >= 30) {
				
				System.out.println("Introduceti numele angajatului:");
				nume = in.readLine();
			
				if( nume.length() <= 0 || nume.length() >= 30 ) 
					System.out.println("Numele introdus este invalid, introduceti un nume cu maxim 30 de caractere");	
			}
			
			while( prenume.length() <= 0 || prenume.length() >= 30) {
				
				System.out.println("Introduceti prenumele angajatului:");
				prenume = in.readLine();
				
				if( prenume.length() <= 0 || prenume.length() >=30 ) 
					System.out.println("Prenumele introdus este invalid, introduceti un prenume cu maxim 30 de caractere");
			}
			

			LocalDate dataCurenta = LocalDate.now();
			
			while ( dataNastere.length() <= 0 || varsta < 18 || !isValidDate(dataNastere)) {
				
				System.out.println("Introduceti data nasterii a angajatului (YYYY-MM-DD):");
				dataNastere = in.readLine();
				if(isValidDate(dataNastere)) {
					LocalDate dataNast  = LocalDate.parse(dataNastere);
					varsta= Period.between(dataNast, dataCurenta).getYears();
				}
				
				if(dataNastere.length() <= 0 || !isValidDate(dataNastere))
					System.out.println("Data introdusa este invalida");
				
				else if( varsta < 18) 
					System.out.println("Persoana introdusa nu a implinit 18 ani");
			}
			
			while ( dataAngajare.length() <= 0  || !isValidDate(dataAngajare) || LocalDate.parse(dataAngajare).compareTo(dataCurenta) > 0) {
				
				System.out.println("Introduceti data angajarii a angajatului (YYYY-MM-DD):");
				dataAngajare = in.readLine();
				
				if( dataAngajare.length() <= 0 || !isValidDate(dataAngajare))
					System.out.println("Data introdusa este invalida");
				else if( LocalDate.parse(dataAngajare).compareTo(dataCurenta) > 0 )
					System.out.println("Data angajarii se afla in viitor");

			}
			
			String tipAngajat = "";
			while( tipAngajat.length() <= 0 || (!tipAngajat.contentEquals("Director") && !tipAngajat.contentEquals("Mecanic") && !tipAngajat.contentEquals("Asistent"))) {
				
				System.out.println("Introduceti tipul de angajat (Director/Mecanic/Asistent)");
				tipAngajat = in.readLine();

				if( tipAngajat.length() <= 0 || (!tipAngajat.contentEquals("Director") && !tipAngajat.contentEquals("Mecanic") && !tipAngajat.contentEquals("Asistent"))) {
					System.out.println("Tipul de angajat introdus este invalid");
				}
			}
			
			Angajat[] newArr = new Angajat[angArr.length+1];
			for( int i = 0 ; i < angArr.length; ++i)
				newArr[i] = angArr[i];
			if(tipAngajat.equals("Director"))
				newArr[newArr.length-1] = new Director(nume,prenume,dataNastere,dataAngajare);
			else if (tipAngajat.equals("Mecanic"))
				newArr[newArr.length-1] = new Mecanic(nume,prenume,dataNastere,dataAngajare);
			else if (tipAngajat.equals("Asistent"))
				newArr[newArr.length-1] = new Asistent(nume,prenume,dataNastere,dataAngajare);
				
			angArr = newArr;
			
		
		} catch (IOException e) {

			e.printStackTrace();
		}
		

		
	}
	private boolean isValidDate( String str ) {
		try {
			LocalDate.parse(str);
			
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	public void stergeAngajat(int id) {
		
		int pos = -1;
		
		for(int i = 0; i < angArr.length ; ++i)
			if(angArr[i].getId() == id)
				pos = i;
			
		if(pos != -1)
		{
			Angajat [] newArr = new Angajat[angArr.length-1];
			
			for(int i = 0; i < pos; ++i)
				newArr[i] = angArr[i];
			for(int i = pos; i < angArr.length-1; ++i)
				newArr[i] = angArr[i+1];
			
			angArr = newArr;			
		}
		else 
			System.out.println("Angajatul cautat nu exista");
	}
	
	public void modificaAngajat( int id ) {
		
		int pos = -1;
	
		
		for(int i = 0; i < angArr.length ; ++i)
			if(angArr[i].getId() == id)
			{
				pos = i;
				try {
					
					BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
					String nume = "";
					String prenume = "";
					String dataNastere = "";
					String dataAngajare = "";
					
					int varsta = 0;
					LocalDate dataCurenta = LocalDate.now();
					
					while( nume.length() <= 0 || nume.length() >= 30) {
						
						System.out.println("Introduceti numele modificat al angajatului:");
						nume = in.readLine();
						
						if( nume.length() <= 0 || nume.length() >= 30 ) 
							System.out.println("Numele introdus este invalid, introduceti un nume cu maxim 30 de caractere");	
					}
					while( prenume.length() <= 0 || prenume.length() >= 30) {
						
						System.out.println("Introduceti prenumele modificat al angajatului:");
						prenume = in.readLine();
						
						if( prenume.length() <= 0 || prenume.length() >=30 ) 
							System.out.println("Prenumele introdus este invalid, introduceti un prenume cu maxim 30 de caractere");
					}
					
					while ( dataNastere.length() <= 0 || varsta < 18 || !isValidDate(dataNastere)) {
						
						System.out.println("Introduceti data nasterii modificata a angajatului (YYYY-MM-DD):");
						dataNastere = in.readLine();
						
						if(isValidDate(dataNastere)) {
							LocalDate dataNast  = LocalDate.parse(dataNastere);
							varsta= Period.between(dataNast, dataCurenta).getYears();
						}
						
						if(dataNastere.length() <= 0 || !isValidDate(dataNastere))
							System.out.println("Data introdusa este invalida");
						
						else if( varsta < 18) 
							System.out.println("Persoana introdusa nu a implinit 18 ani");
					}
					
					while ( dataAngajare.length() <= 0  || !isValidDate(dataAngajare) || LocalDate.parse(dataAngajare).compareTo(dataCurenta) > 0) {
					
						System.out.println("Introduceti data angajarii modificata a angajatului (YYYY-MM-DD):");
						dataAngajare = in.readLine();
						
						if( dataAngajare.length() <= 0 || !isValidDate(dataAngajare))
							System.out.println("Data introdusa este invalida");
						else if( LocalDate.parse(dataAngajare).compareTo(dataCurenta) > 0 )
							System.out.println("Data angajarii se afla in viitor");

					}
					
					angArr[i].modifAngajat(nume, prenume, dataNastere, dataAngajare);
				
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		
		if(pos == -1)
			System.out.println("Angajatul cautat nu exista");
		
	}
	
	public void calculeazaSalariul(int id) {
		
		int pos = -1;
		
		for(int i = 0; i < angArr.length; ++i)
			if(angArr[i].getId() == id)
			{
				pos = i;
				System.out.println(angArr[i].getNume() + " " + angArr[i].getPrenume()+ " are un salariu de "+ angArr[i].getSalariu()+" lei" );
			}
		if(pos == -1)
			System.out.println("Angajatul cautat nu exista");
	}
	public boolean isEmpty() {
		if(angArr.length == 0)
			return true;
		return false;
	}
	
	public void afiseazaAngajati() {
		
		for( Angajat a : angArr )
			a.afisareAngajat();
	}
	public int cautaAngajat(Masina m) {
		
		for(int i = 0; i < angArr.length; ++i)
			if((angArr[i].getNrMasiniCurente() < 3 && m instanceof MasinaStandard && !angArr[i].getIsBusy()) || (angArr[i].getNrMasiniCurente() < 1 &&( m instanceof Autobuz || m instanceof Camion))) {
				return angArr[i].getId();
			}
		
		return -1;
	}
	public void cautaAngajat(int id) {
		for( Angajat a : angArr)
			if(a.getId() == id) {
				if(a.getNrMasiniCurente() > 0) {
					a.decNrMasiniCurente();
					System.out.println(" Angajatul cu id-ul "+a.getId()+" a terminat de lucrat la o masina");
					
					if(a.getNrMasiniCurente() == 0) {
						if(a.getIsBusy())
							a.toggleBusy();
						System.out.println(" Angajatul cu id-ul "+a.getId()+" este liber");	
					}
					
				}
				else System.out.println(" Angajatul nu are masini pe care le repara");
			}
	}
	public String cautaAngajat(int id, Masina m) {
		
		boolean flag = false;
		
		for( Angajat a : angArr ) 
			if(a.getId() == id) {
				
				flag = true;
				
				if(!a.getIsBusy()) {
					
					if((m instanceof Autobuz || m instanceof Camion) && a.getNrMasiniCurente() >= 1 )
						return "Doar masini Standard";
					System.out.println("Angajatul a fost gasit, si masina va fi preluata");
					
					a.incNrMasini();
					a.incBacsis((float) 0.01*m.calculPolita(TipPolita.DISCOUNT));
					a.incValoarePolite(m.calculPolita(TipPolita.STANDARD));
					a.incNrMasiniCurente();
					
					if(m instanceof Autobuz) {
						LocalDate l = LocalDate.now();
						if((l.getYear() - m.getAnFabricatie()) <= 5)
							a.incNrAutobuze();
					}
					System.out.println(a.getNrMasiniCurente());

					if(m instanceof Autobuz || m instanceof Camion || (m instanceof MasinaStandard && a.getNrMasiniCurente() == 3))
						a.toggleBusy();
					return "Found";
				}
				else { 
					System.out.println("Angajatul a fost gasit, dar este ocupat");
					return "Busy";
				}
			}
		
		if(!flag)
			System.out.println("Angajatul nu a fost gasit");
		return "Not Found";
	
	}
	public void incRez(int id) {
		for(Angajat a : angArr)
			if(a.getId() == id)
				a.incNrRezervari();
	}
	public void maxLoad() {
		
		int nrMaxMasini = 0;
		for(Angajat a : angArr)
			if(a.getNrMasini() >= nrMaxMasini)
				nrMaxMasini = a.getNrMasini();
		for(Angajat a: angArr)
			if(a.getNrMasini() == nrMaxMasini)
			System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a reparat "+ nrMaxMasini + " masini");
	}
	
	public void maxPolita() {
		
		float []polite = new float[angArr.length];
		for( int i = 0; i < angArr.length; ++i) {
			polite[i] = angArr[i].getValoarePolite();
		}
		Arrays.sort(polite);
		
		if(polite.length <= 3) {
			for(int i=polite.length-1; i>=0; --i)
				for( Angajat a : angArr)
					if( a.getValoarePolite() == polite[i])
						System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a reparat masini cu polite in valoare de: "+ a.getValoarePolite());
			
		}
		else {
			for(int i=polite.length-1; i>polite.length-4; --i)
				for( Angajat a : angArr)
					if( a.getValoarePolite() == polite[i])
						System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a reparat masini cu polite in valoare de: "+ a.getValoarePolite());
		}
	}
	
	public void maxAuto() {
		int []autobuze = new int[angArr.length];
		for( int i = 0; i < angArr.length; ++i) {
			autobuze[i] = angArr[i].getNrAutobuze();
		}
		Arrays.sort(autobuze);
		
		if(autobuze.length <=3) {
			for(int i=autobuze.length-1; i>=0; --i)
				for( Angajat a : angArr)
					if( a.getNrAutobuze() == autobuze[i])
						System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a reparat "+ a.getNrAutobuze() + " autobuze noi");
		}
		else {
		for(int i=autobuze.length-1; i>autobuze.length-4; --i)
			for( Angajat a : angArr)
				if( a.getNrAutobuze() == autobuze[i])
					System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a reparat "+ a.getNrAutobuze() + " autobuze noi");
		}
		
	}
	public void maxRez() {
		
		int nrMaxRezervari = 0;
		for(Angajat a : angArr)
			if(a.getNrRezervari() >= nrMaxRezervari)
				nrMaxRezervari = a.getNrRezervari();
		for(Angajat a: angArr)
			if(a.getNrRezervari() == nrMaxRezervari)
			System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a avut "+ nrMaxRezervari + " rezervari");
		
	}
	public void getTip() {
		for( Angajat a : angArr)
			System.out.println("Angajatul "+a.getNume()+" "+ a.getPrenume()+ " a primit "+ a.getBacsis() + " lei bacsis");
	}
}
