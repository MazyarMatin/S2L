package DSR;
//aktuell, testinput war doppelt
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
//import java.lang.System.in;
import java.util.Iterator;
public class Dateiverarbeitung {

	public static HashMap<Integer, Veranstaltung> getMap(String pfad){
		
		
		//achtung die beiden file file backups wiedr aktivieren
		// welche fileBackup?
                
		File file = new File(pfad);		//uebergabe
		FileReader fr = null;
		BufferedReader br = null;

		// Exestiert Datei �berhaubt
		try {
			// Wenn dann Filereader Objekt erzeugen
			fr = new FileReader(file);
			try {
				br = new BufferedReader(fr);
				String liste[][] = null; // eigentlich nicht als array
												// liste, sonder ggf map!! machen - siehe stimmbetirk.java

				
                                String in = null;
				int countZeilen = 0;
				int countSpalten = 0;
				int maxSpalten =0;
				int countJeSpalte[] = new int [1000];

				int z = 0;  // zaehler f�r einzelne Spalten
				String line = null;
				while ((line = in.readLine()) != null) {
					String[] teil = line.split(";"); 
											
					countZeilen++;
					countSpalten = teil.length;
					countJeSpalte[z] = teil.length;     // breite jeder spalte
					z++;
					
					if(countSpalten >= maxSpalten ){    //damit die lengste spalte und nicht die letzte gespeichert wird
						maxSpalten = countSpalten;
						} 
				}	
				in.close();
				
			
				
					
	//###############################			
				// Fuellen des zweideminionalen arrays 		
				
				if (maxSpalten < 14){						
					maxSpalten = 14;  
				}
				 
				
				
				liste = new String [countZeilen][maxSpalten];
				String zeile;
				int i = 0;
				//try fuer arrayoutofbounce beginn		
	try{		
				while ((zeile = br.readLine()) != null) {
					String[] part = zeile.split(";"); 
										
					if (countJeSpalte[i] < maxSpalten){				
					for (int g = 0; g < countJeSpalte[i]; g++){			
						
						liste[i][g] = part[g];						
						}
										
					}
                                        
					
					else{
					for (int g = 0; g < maxSpalten; g++){			
					
						
						liste[i][g] = part[g];						
						}
					}
					i++;
				}

			
	//##################################
				
				// mit String "leer" auff�llen
					
				for (int h = 0; h < countZeilen; h++) {
					for (int p = 0; p < maxSpalten; p++) {
						if (liste[h][p] == null){
							
							liste[h][p] = "0";
						}
									
					}
			
				}
				

			//##################################
	/*			// Gibt alle Namen im Array aus auf konsole
				for (int h = 0; h < countZeilen; h++) {
					for (int p = 0; p < maxSpalten; p++) {
					System.out.print(liste[h][p]+";");
				}
				System.out.println(" ");
				}
		
																			
		*/		
				
			//##############################################
				// fuellen einer hashmap mit integer und versanstaltungsbjekten
				// konstruktor der streams entgegennimmt
				
				HashMap<Integer,Veranstaltung> verMap = new HashMap<Integer,Veranstaltung>();	
							
				int nr = 0;									// als key  listennummer
				String reihe []= null;
				reihe = new String [1000];
				int listnr  = 0;	
				
				for (int h = 0; h < countZeilen; h++) {
					for (int p = 0; p < maxSpalten; p++) {
					
						if (reihe[h] == null){					// sonst ist das erste feld =null
							reihe[h] = liste[h][p]+";";
						
						}else{
						reihe[h] = reihe[h]+liste[h][p]+";";
						}
						listnr = nr;
									
					}
					nr++;
					verMap.put(listnr,new Veranstaltung(reihe[h]));			//f�gt Veranstaltung in hashmap
				
					//	System.out.println(reihe[h]);
					
				}
			//	System.out.println("test:" +verMap.get(1).getWochentagSort()+" "+ verMap.get(2).getDozname());
				
				return verMap;
				
			//############################################	
				
					//catch fuer arrayoutofbounce ende				
		} catch(ArrayIndexOutOfBoundsException ex)
    {
    
    }	
				br.close();
				fr.close();

                        } catch (IOException io) {
				System.out.println("IO-Fehler.");

			}
			// Falls Datei nicht exestiert
		} catch (FileNotFoundException fnf) {
			System.out.println("Datei nicht gefunden");
		}
		return null;
	

	}

}
