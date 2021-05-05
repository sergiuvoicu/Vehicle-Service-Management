import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.LinkedList;


public class Atelier {

	public static void main(String[] args) throws IOException {
		


		ListaAngajati l = new ListaAngajati();
		LinkedList<Masina> coada = new LinkedList<Masina>();
		
		String comanda = "";
		BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
		while( !comanda.equals("E")) {
		
		System.out.println("Atelier Auto");
		System.out.println(" Introduceti A pentru operatii cu angajatii");
		System.out.println(" Introduceti M pentru operatii cu masinile");
		System.out.println(" Introduceti R pentru rapoarte despre angajati");
		System.out.println(" Introduceti E pentru a iesi");
		
		comanda = new String(in.readLine());
		
			switch(comanda) {
				case "A": String comandaAng = "";
						 
						  while( !comandaAng.equals("Back")) {
							  
							  System.out.println(" Introduceti Add pentru a adauga un angajat");
						      System.out.println(" Introduceti Mod pentru a modifica un angajat");
							  System.out.println(" Introduceti Del pentru a sterge un angajat");
							  System.out.println(" Introduceti Sal pentru a calcula salariul unui angajat");
							  System.out.println(" Introduceti Afs pentru a afisa toti angajatii");
							  System.out.println(" Introduceti Back pentru a merge inapoi in meniul principal");
							  System.out.println(" Introduceti E pentru a iesi");
							  
							  comandaAng = new String(in.readLine());
							  switch(comandaAng) {
							  
							  case "Add": l.adaugaAngajat();
								  		  break;
								  		  
							  case "Mod": System.out.println(" Introduceti id-ul angajatului pe care doriti sa-l modificati");
								  		  l.modificaAngajat(Integer.parseInt(in.readLine()));
							  			  break;
							  			  
							  case "Del": System.out.println(" Introduceti id-ul angajatului pe care doriti sa-l stergeti");
								  		  l.stergeAngajat(Integer.parseInt(in.readLine()));
								          break;
							  case "Sal": System.out.println(" Introduceti id-ul angajatului al carui salariu doriti sa-l stiti");
					  		  			  l.calculeazaSalariul(Integer.parseInt(in.readLine()));
								          break;
							  case "Afs": l.afiseazaAngajati();
								  		  break;

							  case "Back": break;
							  case "E": System.out.println("Terminare program");
							  			clrscr();
							  			System.exit(1);
							  
							  default: System.out.println("Comanda invalida");
							  }
						  
						  }
						  break;
						  
				case "M":   if(l.isEmpty()) 
								System.out.println("Atelierul nu contine angajati, mai intai introduceti angajati");
							else {
								String comandaMsn = "";
								while( !comandaMsn.equals("Back")) {
									  
									  System.out.println(" Introduceti Add pentru a adauga o noua masina in service");
									  System.out.println(" Introduceti Chk pentru a verifica daca este vreun angajat liber, pentru a prelua prima masina din coada");
									  System.out.println(" Introduceti Fin pentru a finaliza reparatia unei masini de catre un angajat");
									  System.out.println(" Introduceti Afs pentru a afisa toate masinile din coada");
									  System.out.println(" Introduceti Back pentru a merge inapoi in meniul principal");
									  System.out.println(" Introduceti E pentru a iesi");
									  
									  comandaMsn = new String(in.readLine());
									  switch(comandaMsn) {
									  
									  case "Add": long nrKm = -1;
										  		  while(nrKm < 0) {
											  		  System.out.println(" Introduceti numarul de kilometri ai masinii");
											  		  try {
											  			nrKm = Long.parseLong(in.readLine());
											  			if(nrKm < 0) System.out.println(" Numarul este negativ");
											  		  }catch(NumberFormatException e){
											  			  System.out.println(" Nu ati introdus un numar");
											  			  nrKm = -1;
											  		  }
											  		  
									  			  }
										  		  int anFabricatie = -1;
										  		  while(anFabricatie < 1800 || anFabricatie > LocalDate.now().getYear()) {
										  			
										  			  System.out.println(" Introduceti anul de fabricatie al masinii");
										  			  try {
										  				  anFabricatie = Integer.parseInt(in.readLine());
										  				  if(anFabricatie < 1800 || anFabricatie > LocalDate.now().getYear())
											  				   System.out.println(" Anul introdus este invalid");
										  			  }catch(NumberFormatException e) {
										  				  System.out.println(" Nu ati introdus un numar");
										  				  anFabricatie = -1;
										  			  }
										  		  }
										  		  
										  		  boolean isDiesel = false;
										  		  System.out.println(" Introduceti daca masina este pe Diesel (true/false)");
										  		  isDiesel = Boolean.parseBoolean(in.readLine());

										  		  
										  		  String tipMasina = "";
										  		  while(tipMasina.length() < 0 || (!tipMasina.equals("Standard") && !tipMasina.equals("Autobuz") && !tipMasina.equals("Camion"))) {
										  			  System.out.println(" Introduceti tipul de masina (Standard/Autobuz/Camion)");
										  			  tipMasina = in.readLine();
										  			  if(tipMasina.length() < 0 || (!tipMasina.equals("Standard") && !tipMasina.equals("Autobuz") && !tipMasina.equals("Camion")))
										  				  System.out.println("Nu ati introdus un tip de masina disponibil ");
										  		  }
									  			  
									  			  Transmisie tipTransmisie = Transmisie.MANUALA;
									  			  int nrLocuri = -1;
									  			  double tonaj = -1;
									  			  
									  			  Masina ms1 = new MasinaStandard();
									  			  
									  			  if(tipMasina.equals("Standard")) {
									  				  System.out.println(" Introduceti tipul de transmisie (Manuala/Automata)");
									  				  String type = in.readLine();
									  				  if(type.equals("Manuala"))
									  					  tipTransmisie = Transmisie.MANUALA;
									  				  else if(type.equals("Automata"))
									  					  tipTransmisie = Transmisie.AUTOMATA;
									  				  ms1 = new MasinaStandard(nrKm,anFabricatie,isDiesel,tipTransmisie);
									  			  }
									  			  
									  			  else if(tipMasina.equals("Autobuz")) {
									  				  while(nrLocuri <= 0) {
										  				System.out.println(" Introduceti numarul de locuri");
										  				try {
										  					nrLocuri = Integer.parseInt(in.readLine());
										  					if(nrLocuri <= 20)
										  						System.out.println(" Numarul este invalid");
										  					
										  				}catch(Exception e) {
										  					System.out.println(" Nu ati introdus un numar");
										  				}
										  				ms1 = new Autobuz(nrKm,anFabricatie,isDiesel,nrLocuri);
									  				  }
									  				
									  			  }
									  			  else if(tipMasina.equals("Camion")) {
									  				  while(tonaj <= 3.5) {
										  				System.out.println(" Introduceti tonajul (in tone)");
										  				try {
										  					tonaj = Double.parseDouble(in.readLine());
										  					if(tonaj <= 3.5) {
										  						System.out.println(" Numarul este invalid");
										  					}
										  				}catch(Exception e) {
										  					System.out.println(" Nu ati introdus un numar");
										  				}
										  				ms1 = new Camion(nrKm,anFabricatie,isDiesel,tonaj);
									  				  }
									  			  }
									  			  ms1.afisareMasina();
									  			  
									  			 System.out.println("Doriti sa trimiteti masina la un anumit angajat? (Y/N)");
									  			 String ans = in.readLine();
									  			 
									  			 if(ans.equals("Y")) {
									  				 System.out.println("Introduceti id-ul angajatului la care vreti sa trimiteti masina");
									  			 	 int id = Integer.parseInt(in.readLine());
									  			 	 String message = l.cautaAngajat(id, ms1);
									  			 	 if(message.equals("Busy") || message.equals("Doar masini Standard")) {
									  			 		 System.out.println("Angajatul nu poate prelua comanda, doriti sa asteptati? (Y/N)");
									  			 		 System.out.println("Coada este:");
									  			 		 
									  			 		 for(int i = 0; i < coada.size(); ++i)
									  			 			 coada.get(i).afisareMasina();
									  			 		 
									  			 		 String answer = in.readLine();
									  			 		 
									  			 		 if(answer.equals("Y")) {
									  			 			 l.incRez(id);
									  			 			 System.out.println("Ati fost adaugat in lista de asteptare");
									  			 			 coada.add(ms1);
									  			 			 
									  			 			 for(int i = 0; i < coada.size(); ++i)
										  			 			 coada.get(i).afisareMasina();
									  			 			 }
									  			 		 else if( answer.equals("N")) {
									  			 			 System.out.println("Doriti sa fiti alocat altui angajat? (Y/N)");
									  			 			 if(in.readLine().equals("Y"))
									  			 				 if(l.cautaAngajat(ms1) != -1) 
									  			 					 l.cautaAngajat(l.cautaAngajat(ms1), ms1);
									  			 				 else {
									  			 					 System.out.println("Toti angajatii sunt ocupati, doriti sa asteptati? (Y/N)");
									  			 					 
									  			 					 for(int i = 0; i < coada.size(); ++i)
												  			 			 coada.get(i).afisareMasina();
									  			 					 
									  			 					 if(in.readLine().equals("Y"))
									  			 						 coada.add(ms1);
									  			 					 for(int i = 0; i < coada.size(); ++i)
												  			 			 coada.get(i).afisareMasina();
									  			 				 }
									  			 			 
									  			 		 }
									  			 		 	
									  			 	 }
									  			 }
									  			 
									  			 else if(ans.equals("N")) {
									  				 System.out.println("Doriti sa fiti alocat altui angajat? (Y/N)");
									  				 if(in.readLine().equals("Y")) {
										  				 if(l.cautaAngajat(ms1) != -1) {
										  					 l.cautaAngajat(l.cautaAngajat(ms1),ms1);
										  				 }
										  				 else {
										  					 
										  					System.out.println("Toti angajatii sunt ocupati, doriti sa asteptati? (Y/N)");
							  			 					 
							  			 					 for(int i = 0; i < coada.size(); ++i)
										  			 			 coada.get(i).afisareMasina();
							  			 					 
							  			 					 if(in.readLine().equals("Y"))
							  			 						 coada.add(ms1);
							  			 					 for(int i = 0; i < coada.size(); ++i)
										  			 			 coada.get(i).afisareMasina();
										  					 
										  				 }
									  				 }
									  			 }
									  			  	  
										  		  break;
									  case "Chk": if(coada.isEmpty())
										  			System.out.println("Nu este nicio masina in coada");
									  			  else if(l.cautaAngajat(coada.peek()) != -1 ) {
									  				  	System.out.println("A fost atribuita prima masina din coada");
										  				l.cautaAngajat(l.cautaAngajat(coada.peek()),coada.poll());
									  			  }
									  			  else 
									  				  System.out.println("Nu a fost gasit niciun angajat liber");
										  		  break;
										  		  
									  case "Fin": System.out.println(" Introduceti id-ul angajatului care termina de lucrat la o masina");
						  			  			  l.cautaAngajat(Integer.parseInt(in.readLine()));
						  			  			  break;  		  
						  			  			  
									  case "Afs": if(coada.isEmpty())
										  			System.out.println("Coada de asteptare este goala");
									  			  else
									  				for(int i = 0; i < coada.size(); ++i)
									  					coada.get(i).afisareMasina();
										  		  break;
									  case "Back": break;
									  case "E": System.out.println("Terminare program"); 
									  			clrscr();
									  			System.exit(1);
									  
									  default: System.out.println("Comanda invalida");
									  }
								  
								  }
							}
						  break;
						  
				case "R": if(l.isEmpty())
						 	System.out.println("Nu exista angajati");
						  else {
							  String comandaRap = "";
							  
									  while(!comandaRap.equals("Back"))
									  {
										  System.out.println(" Introduceti Inc pentru angajatul cu cea mai mare incarcatura");
										  System.out.println(" Introduceti Top3P pentru angajatii care au reparat masinile cu cele mai mari polite");
										  System.out.println(" Introduceti Top3AN pentru angajatii care au reparat cele mai multe autobuze noi");
										  System.out.println(" Introduceti Pref pentru angajatii pentru care s-au facut rezervari");
										  System.out.println(" Introduceti Tip pentru bacsisul angajatilor");
										  System.out.println(" Introduceti Back pentru a merge inapoi in meniul principal");
										  System.out.println(" Introduceti E pentru a iesi");
										  comandaRap = in.readLine();
										  switch(comandaRap) {
											  case "Inc": l.maxLoad();
												  		  break;
											  case "Top3P": l.maxPolita();
												            break;
											  case "Top3AN": l.maxAuto();
												  			 break;
											  case "Pref":  l.maxRez();
												  			break;
											  case "Tip":  l.getTip();
												  			break;
											  case "Back": break;
											  case "E": System.out.println("Terminare program"); 
												  		clrscr();
											  			System.exit(1);
											  default: System.out.println("Comanda invalida");
											  		   break;
											  
										  }
									  }
						  }
						  break;
						  
				case "E": 
						  System.out.println("Terminare program"); 
						  clrscr();
						  System.exit(1);
						  
				default: System.out.println("Comanda invalida");
						 break;
			}
		}

	}
	
	public static void clrscr(){
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}

}
