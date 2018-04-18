package DSR;    // testphase, sp�ter die hashmap aus starthere uebergeben lassen


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import java.io.File;
import java.util.HashMap;

public class XMLparser {

	static HashMap<Integer, Veranstaltung> vmap = null;
	
/*	public static void main(String[] args) {
		
		
		//Testeingaben
		String pfad = "P:\\Praktikum\\_System-splus-LSF\\Java-Entwicklung\\teststundenplan.csv";
		String zielpfad ="";
		vmap = Dateiverarbeitung.getMap(pfad);
				
		parseXML(vmap, zielpfad);
		System.out.println("");
						
	}
	*/
	
			public static void updateHashmap(HashMap<Integer, Veranstaltung> map) {
				vmap = map;
	  		  		
	  	}
		
			public static void parseXML(HashMap<Integer, Veranstaltung> vmap, String zielpfad){
			
			
	
		 try {
	         DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	       //############################################################# HEAD 
	         // VVZ root element

	         // alles fuer die erste spalte bis jetzt, muss auf alles angepasst werden v.a. veranstaltungen
	    	         
	     int k = 0;	//um die Standardueberschrift zu bekommen, muss ggf noch geaender werden    
	       while (vmap.get(k) == null){
	    	 k++;
	     }
	   
	         org.w3c.dom.Element rootElement = doc.createElement("VVZ");
	         doc.appendChild(rootElement);
	         
		         // SemText to element
		         Attr SemText = doc.createAttribute("SemText");								
		         SemText.setValue(vmap.get(k).getSemText());										
		         rootElement.setAttributeNode(SemText);
		         
			         // Semester to element
			         Attr Semester = doc.createAttribute("semester");
			         Semester.setValue(vmap.get(k).getSemester());										
			         rootElement.setAttributeNode(Semester);
                                 /*
                                    1. insert.into call routing values. 
                                       2.public interface noSetData extends Data
                                            3. Chiper.init(chiper.Encrypt_Mode, Key, ivSpec)
                                                4. 
                                 
                                        
                                 
                                 */
                                 
                                 rootElement.lookupPrefix(zielpfad.substring(k, k)); //hier wird die XML Parser nochmal aufgerufen
			        	         rootElement.getAttributeNS(zielpfad, zielpfad);
			         
                                                 
                                                 
				         // Ueberschrift element
				         org.w3c.dom.Element ueberschrift = doc.createElement("Ueberschrift");
				         rootElement.appendChild(ueberschrift);
				         																						//pro ueberschrift eine neue datei, sollte 
					         // UeBez element
					         org.w3c.dom.Element UeBez = doc.createElement("UeBez");
					         Attr uebene = doc.createAttribute("ueebene");
					         uebene.setValue(vmap.get(k).getUebene());														// set value
					         UeBez.setAttributeNode(uebene);
					         
					         Attr id = doc.createAttribute("id");
					         id.setValue(vmap.get(k).getUeberschriftID());														// set value
					         UeBez.setAttributeNode(id);
					         
					    	 UeBez.appendChild(
					         doc.createTextNode(vmap.get(k).getUeberText()));		// set value
					         ueberschrift.appendChild(UeBez);
					         
				    // UebKommentar element
				    org.w3c.dom.Element kommentar = doc.createElement("UebKommentar");			// set value
				    ueberschrift.appendChild(kommentar);
				         
	          
				         
			 //############################################################# VERANSTALTUNG            
				    int i = 0;
				      while (i <=  1000) {					
								    	
				    	if (vmap.get(i) == null){					
			    	  		i++;
			    			    	
				      	}else{
			    	  		  // Veranstaltung element
				   org.w3c.dom.Element veranstaltung = doc.createElement("Veranstaltung");
				   ueberschrift.appendChild(veranstaltung);
	
				   		 // # # # Inhalte von Veranstaltung fuellen # # # 	
				   		 //VeranstNummer element
				         org.w3c.dom.Element VeranstNummer = doc.createElement("VeranstNummer");
				         VeranstNummer.appendChild(
				         doc.createTextNode((String.valueOf(vmap.get(i).getVeranstNummer()))));
				         veranstaltung.appendChild(VeranstNummer);  
							         
				  		 //VName element
				         org.w3c.dom.Element VName = doc.createElement("VName");
				         VName.appendChild(
				         doc.createTextNode(vmap.get(i).getVname()));
				         veranstaltung.appendChild(VName);
				         
				         //VNummer element
				         org.w3c.dom.Element VNummer = doc.createElement("VNummer");
				         VNummer.appendChild(
				         doc.createTextNode(vmap.get(i).getVkurzel()));
				         veranstaltung.appendChild(VNummer);
				         
				         //VSWS element
				         org.w3c.dom.Element VSWS = doc.createElement("VSWS");
				       //  VSWS.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VSWS);
				         
				         //VTyp element
				         org.w3c.dom.Element VTyp = doc.createElement("VTyp");
				         VTyp.appendChild(
				         doc.createTextNode(vmap.get(i).getvTyp()));
				         veranstaltung.appendChild(VTyp);
				         
				         //VDTyp element
				         org.w3c.dom.Element VDTyp = doc.createElement("VDTyp");
				         VDTyp.appendChild(
				         doc.createTextNode(vmap.get(i).getVdTyp()));
				         veranstaltung.appendChild(VDTyp);
				         
				         //VHyper element
				         org.w3c.dom.Element VHyper = doc.createElement("VHyper");			
				      //   VHyper.appendChild(
				      //   doc.createTextNode(""));
				         veranstaltung.appendChild(VHyper);
				         
				         //VZSemsester element
				         org.w3c.dom.Element VZSemsester = doc.createElement("VZSemsester");
				         VZSemsester.appendChild(
				         doc.createTextNode(vmap.get(i).getVzSemester()));
				         veranstaltung.appendChild(VZSemsester);
				         
				         //VZSemsester element
				         org.w3c.dom.Element druck_vvz = doc.createElement("druck_vvz");
				         druck_vvz.appendChild(
				         doc.createTextNode(vmap.get(i).getDruckVVZ()));
				         veranstaltung.appendChild(druck_vvz);
				         
				         //ZuordBemerkung element
				         org.w3c.dom.Element ZuordBemerkung = doc.createElement("ZuordBemerkung");			
				      //   ZuordBemerkung.appendChild(
				      //   doc.createTextNode(""));
				         veranstaltung.appendChild(ZuordBemerkung);
				         
				         
				         
				         		//################################### VZEIT							
				         		
				         		org.w3c.dom.Element VZeit = doc.createElement("VZeit");
				         		veranstaltung.appendChild(VZeit);

						   
						   		 // # # # Inhalte von VZEIT fuellen # # # 	
						   		 //veransttermin.vtid element
						         org.w3c.dom.Element veranstterminVtid = doc.createElement("veransttermin.vtid");
						         veranstterminVtid.appendChild(
						         doc.createTextNode(String.valueOf(vmap.get(i).getVeranstperVTID())));
						         VZeit.appendChild(veranstterminVtid); 
				         
						       //veransttermin.rgid element
						         org.w3c.dom.Element veranstterminRgid = doc.createElement("veransttermin.rgid");
						         veranstterminRgid.appendChild(
						         doc.createTextNode(String.valueOf(vmap.get(i).getVeranstterminRGID())));
						         VZeit.appendChild(veranstterminRgid); 
						         
						       //VZWoTag element
						         org.w3c.dom.Element VZWoTag = doc.createElement("VZWoTag");
						         VZWoTag.appendChild(
						         doc.createTextNode(vmap.get(i).getVzWoTag()));
						         VZeit.appendChild(VZWoTag); 
						         
						       //VZWoTagKurz element
						         org.w3c.dom.Element VZWoTagKurz = doc.createElement("VZWoTagKurz");
						         VZWoTagKurz.appendChild(
						         doc.createTextNode(vmap.get(i).getVzWoTagKurz()));
						         VZeit.appendChild(VZWoTagKurz); 
						         
						       //VZBeginn element
						         org.w3c.dom.Element VZBeginn = doc.createElement("VZBeginn");
						         VZBeginn.appendChild(
						         doc.createTextNode(vmap.get(i).getVzBeginn()));
						         VZeit.appendChild(VZBeginn); 
						         
						       //VZEnde element
						         org.w3c.dom.Element VZEnde = doc.createElement("VZEnde");
						         VZEnde.appendChild(
						         doc.createTextNode(vmap.get(i).getVzEnde()));
						         VZeit.appendChild(VZEnde); 
						         
						       //VZBeginDat element
						         org.w3c.dom.Element VZBeginDat = doc.createElement("VZBeginDat");
						         VZBeginDat.appendChild(
						         doc.createTextNode(vmap.get(i).getVzBeginnDat()));
						         VZeit.appendChild(VZBeginDat); 
						         
						       //VZEndDat element
						         org.w3c.dom.Element VZEndDat = doc.createElement("VZEndDat");
						         VZEndDat.appendChild(
						         doc.createTextNode(vmap.get(i).getVzEnde()));
						         VZeit.appendChild(VZEndDat); 
						         
						       //VZRhyth element
						         org.w3c.dom.Element VZRhyth = doc.createElement("VZRhyth");
						         VZRhyth.appendChild(
						         doc.createTextNode(vmap.get(i).getVzRhyth()));
						         VZeit.appendChild(VZRhyth); 
						         
						       //VZRhythmus element
						         org.w3c.dom.Element VZRhythmus = doc.createElement("VZRhythmus");
						         VZRhythmus.appendChild(
						         doc.createTextNode(vmap.get(i).getVzRhythmus()));
						         VZeit.appendChild(VZRhythmus); 
						         
						         //ZuordBemerkung element
						         org.w3c.dom.Element WoTagKurz = doc.createElement("WoTagKurz");			
						      //   WoTagKurz.appendChild(
						      //   doc.createTextNode(""));
						         VZeit.appendChild(WoTagKurz); 
						         
						        //ZuordBemerkung element
						         org.w3c.dom.Element VZBem = doc.createElement("VZBem");			
						      //   VZBem.appendChild(
						      //   doc.createTextNode(""));
						         VZeit.appendChild(VZBem);  
						         
						         //ZuordBemerkung element
						         org.w3c.dom.Element VZParallel = doc.createElement("VZParallel");			
						      //   VZParallel.appendChild(
						      //   doc.createTextNode(""));
						         VZeit.appendChild(VZParallel); 
						         
						       //k_wochentag.sort element
						         org.w3c.dom.Element k_wochentagSort = doc.createElement("k_wochentag.sort");
						         k_wochentagSort.appendChild(
						         doc.createTextNode(String.valueOf(vmap.get(i).getWochentagSort())));
						         VZeit.appendChild(k_wochentagSort); 
						         
						         				         
				         
						         		//################################### VZPerson	
						         
						         	org.w3c.dom.Element VZPerson = doc.createElement("VZPerson");
						    	    VZeit.appendChild(VZPerson);

							   							   		 // # # # Inhalte von VZPerson fuellen # # # 	
							   		 //VZPerson element
							         org.w3c.dom.Element r_veranstpersPid = doc.createElement("r_veranstpers.pid");
							         r_veranstpersPid.appendChild(
							         doc.createTextNode(String.valueOf(vmap.get(i).getVeranstperPID())));
							         VZPerson.appendChild(r_veranstpersPid);
							         
							       //r_veranstpersVtid element
							         org.w3c.dom.Element r_veranstpersVtid = doc.createElement("r_veranstpers.vtid");
							         r_veranstpersVtid.appendChild(
							         doc.createTextNode(String.valueOf(vmap.get(i).getVeranstperVTID())));
							         VZPerson.appendChild(r_veranstpersVtid);
						         
							       //r_veranstpersVtid element
							         org.w3c.dom.Element DozName = doc.createElement("DozName");
							         DozName.appendChild(
							         doc.createTextNode(vmap.get(i).getDozname()));
							         VZPerson.appendChild(DozName);
							         
							       //r_veranstpersVtid element
							         org.w3c.dom.Element DozVorname = doc.createElement("DozVorname");
							         DozVorname.appendChild(
							         doc.createTextNode(vmap.get(i).getDozvorname()));
							         VZPerson.appendChild(DozVorname);
						         
							         //r_veranstpers.sort element
							         org.w3c.dom.Element r_veranstpersSort = doc.createElement("r_veranstpers.sort");			
							      //   r_veranstpersSort.appendChild(
							      //   doc.createTextNode(""));
							         VZPerson.appendChild(r_veranstpersSort); 
							         
						         					         
						         		//################################### VZPerson Ende
						         
						         		//################################### VZRaum	
						         
							         org.w3c.dom.Element VZRaum = doc.createElement("VZRaum");
							         VZeit.appendChild(VZRaum);
							   
							   		 // # # # Inhalte von VZaum fuellen # # # 	
							   		 //VZPerson element
							         org.w3c.dom.Element VZRaumName = doc.createElement("VZRaumName");
							         VZRaumName.appendChild(
							         doc.createTextNode(vmap.get(i).getRaumName()));
							         VZRaum.appendChild(VZRaumName);
							         
							         org.w3c.dom.Element VZRaumForm = doc.createElement("VZRaumForm");
							         VZRaumForm.appendChild(
							         doc.createTextNode(vmap.get(i).getRaumForm()));
							         VZRaum.appendChild(VZRaumForm);
							         
							         org.w3c.dom.Element GebKTxt = doc.createElement("GebKTxt");
							         GebKTxt.appendChild(
							         doc.createTextNode(vmap.get(i).getGebKTxt()));
							         VZRaum.appendChild(GebKTxt);
						         
					         		//################################### VZRaum Ende
						         
				         		//################################### VZEIT Ende
				    
				         
				         //VBemerkung element
				         org.w3c.dom.Element VBemerkung = doc.createElement("VBemerkung");
				       //  VBemerkung.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VBemerkung);
				         
				         //VLiteratur element
				         org.w3c.dom.Element VLiteratur = doc.createElement("VLiteratur");
				       //  VLiteratur.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VLiteratur);
				         
				         //VAnmerkung element
				         org.w3c.dom.Element VAnmerkung = doc.createElement("VAnmerkung");
				       //  VAnmerkung.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VAnmerkung);
				         
				         //VKommentar element
				         org.w3c.dom.Element VKommentar = doc.createElement("VKommentar");
				       //  VKommentar.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VKommentar);
				         
				         //VVoraussetzung element
				         org.w3c.dom.Element VVoraussetzung = doc.createElement("VVoraussetzung");
				       //  VVoraussetzung.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VVoraussetzung);
				         
				         //VNachweis element
				         org.w3c.dom.Element VNachweis = doc.createElement("VNachweis");
				       //  VNachweis.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VNachweis);
				         
				         //VZugang element
				         org.w3c.dom.Element VZugang = doc.createElement("VZugang");
				       //  VZugang.appendChild(
				       //  doc.createTextNode(""));
				         veranstaltung.appendChild(VZugang);
				         i++;
				         
			    	  	}     
				    }
				    	
				   
			//##########################  in Datei schreiben	            
			
	         TransformerFactory transformerFactory =
	         TransformerFactory.newInstance();
	         Transformer transformer =  transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File(zielpfad));
	        	//	 new StreamResult(new File("P:\\Praktikum\\_System-splus-LSF\\Java-Entwicklung\\output.xml")); backup
	         transformer.transform(source, result);
	         // Output to console for testing
	       //  StreamResult consoleResult = new StreamResult(System.out);     
	       //  transformer.transform(source, consoleResult);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }	

	}
	
}


