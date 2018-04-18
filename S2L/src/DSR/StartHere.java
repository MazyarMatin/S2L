package DSR;  


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import DSR.JFreeCHart.PieRenderer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;
import java.awt.Window;

//#########################################################################
	// G U I  - > S t a r t H e r e - >  JFrame
//#########################################################################

public class StartHere extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
		
	HashMap<Integer, Veranstaltung> vmap = null;				
	Color farbe =  null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					StartHere frame = new StartHere();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
			
	}

	  public void setHashMap(HashMap<Integer, Veranstaltung> vmap) {
	  		this.vmap = vmap;
	  		  		
	  	}
	
	public StartHere() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartHere.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png"))); 
		//#########################################################################
		// JFrame
		//#########################################################################
			
		setTitle("DSR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1600, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);			
		contentPane.setLayout(null);
			 		
		 JScrollPane scrollPane = new JScrollPane(table);
		 getContentPane().add(scrollPane);		 	    
	      
	      JScrollPane scrollPane_1 = new JScrollPane();
	      scrollPane_1.setBounds(0, 281, 1584, 480);
	      contentPane.add(scrollPane_1);
	     	      	     
	      
	    //#########################################################################
	  	// M E N U B A R :  set
	    //#########################################################################  
	     
	      JMenuBar menuBar = new JMenuBar();
	      menuBar.setForeground(Color.BLACK);
	      menuBar.setBounds(0, 0, 1594, 21);
	      contentPane.add(menuBar);
	      	      
	      //#########################################################################
		  // J T A B L E
		  //######################################################################### 
	     	
	       String[] tabellenuerbschrift = {"Semester", "ID", "Stud-gang", "VerNr", "VName",  "Kurz",  "VTyp", "VZSem",  "VTid", "RGid",
					"TagK", "Beginn", "Ende", "DatB", "DatE",  "Rhyth",  "Pid", "VTid", "DozN", "DozV",
					"RaumN", "RaumF", "GebT", "Nr.", "del"};
	      
	       int anzahlSpalten = tabellenuerbschrift.length;
		   
		      Object[][] tabelleninhalte =  new Object[500][100];
	  			
		      
		      
		      
		      
		   //#########################################################################
		   // C H E C K B O X 
		  //#########################################################################
		       JTable table_1;
		      
		      DefaultTableModel model = new DefaultTableModel(tabelleninhalte, tabellenuerbschrift);
		      table_1 = new JTable(model) {

	            private static final long serialVersionUID = 1L;

	            @Override
	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	            	     if(columnIndex == 23 || rowIndex == 24) return false;			 
	                     else return true;
	        
	            }
	              
	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
	            @Override
	            public Class getColumnClass(int column) {									
	                switch (column) {
	                    case 24:
	                    	return Boolean.class;
	                    default:
	                    	return String.class;
	                }
	            }
	        };
	        table_1.setBackground(new Color(239, 246, 250));
		
			table_1.setRowSelectionAllowed(false);
	      scrollPane_1.setViewportView(table_1);
	      table_1.setColumnSelectionAllowed(true);
	      table_1.setCellSelectionEnabled(true);
	      table_1.setPreferredScrollableViewportSize(new Dimension(200, 60));
	      table_1.setFillsViewportHeight(true);
	      
	 	      
	      
	      
	      
	    //#########################################################################
		  // J F R E E C H A R T 
	   //#########################################################################
	    		
	      int cWidth = 300;
			int cHeight = 300;
			int minWidth = 350;
			int minHeight = 350;
			int maxWidth = 450;
			int maxHeight = 450; 
	     			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(625, 21, 300, 260);
			contentPane.add(panel);
			
			DefaultPieDataset pieDataset = getPieDataset(-1,-1 );	// mit minuswerten unsichtabr machen	
			JFreeChart pieChart2D = ChartFactory.createPieChart("", pieDataset, false, true, true);
			
			ChartPanel pieChartPanel2D = new ChartPanel(pieChart2D, cWidth, cHeight, minWidth, 	minHeight, maxWidth, maxHeight,	false, 	false, 	false, 	false, 	false, 	false);
			panel.add(pieChartPanel2D);
			pieChartPanel2D.setBackground(Color.WHITE);
			
			//
			PiePlot plot = (PiePlot)pieChart2D.getPlot(); 
			Color[] colors = {(new Color(128, 205, 221)), new Color(255, 150, 150)}; 
	        PieRenderer renderer = new PieRenderer(colors); 
	        renderer.setColor(plot, pieDataset);
			plot.setBackgroundAlpha(0);					//transparenter hintergrund
			plot.setOutlineVisible(false);				// no border
	        
			    
			
			
			
	      
			//#########################################################################
			  // B U T T O N s - > File chooser:  I M P O R T  
			//#########################################################################   
	  
	      
	      JFileChooser fc = new JFileChooser();
	      
	      
	      JButton btnImportCSV = new JButton("  Import CSV");
	      btnImportCSV.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Outdent-rtl.png")));
	      btnImportCSV.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		
	      	
	      		fc.showOpenDialog(StartHere.this);
	      		File file = fc.getSelectedFile();
	     		String pfad = file.getPath();
	      		      		
	     		if( pfad.contains( ".csv" )){		
	     		
	      		if( pfad.contains( "\\" ) )
	      		{
	      		 pfad = pfad.replace("\\", "\\\\");
	      		
	      		
	      		 Veranstaltung.setLasttabellennr(0);		
	      		 
	      		clearTable(table_1, vmap, anzahlSpalten);   
	 
	      		setHashMap(Dateiverarbeitung.getMap(pfad));
	    	      	
	      		
	      		setTableInhalt(table_1, vmap);
	      		
	      		
	      		int roteFelder = getFehlerFelderAnzahl(vmap, table_1);
	      		int gfelder = (vmap.size()*23);
	      		int differenz = gfelder - roteFelder;
	     		
	  //    		setChart( panel, pieChart2D, getPieDataset(differenz, roteFelder),pieChartPanel2D );
	      		
	      		
	      		}
	      		
	    }  	
	      	}
	      });
	      btnImportCSV.setBounds(46, 27, 135, 23);
	      
	      contentPane.add(btnImportCSV);
	      
	      
	      
	      
	      
	    //#########################################################################
		  // B U T T O N s - > L O E S C H E N  
		//######################################################################### 
	      
	      JButton btnDel = new JButton("loeschen");
	      btnDel.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		
	       Object on = true;  
	      	if (vmap != null){    
	      	  for (int i =0; i< 500; i++){
	      		
	      		
	      		if(table_1.getValueAt(i, anzahlSpalten-1) == on && table_1.getValueAt(i, anzahlSpalten-2) != null){
	      			
	      			
	      			int loeschen = Integer.parseInt( table_1.getValueAt(i, anzahlSpalten-2).toString() );
	      			vmap.remove(loeschen);
	      			table_1.setValueAt((boolean) false, i, anzahlSpalten-1);
	      			      
	      		}else{
	  			
	      		
	      			//do nothing
	      		}
	      		
	      	  }
	       	clearTable(table_1, vmap, anzahlSpalten); 
  			setTableInhalt(table_1, vmap);
  			XMLparser.updateHashmap(vmap);

  			int roteFelder = getFehlerFelderAnzahl(vmap, table_1);
      		int gfelder = (vmap.size()*23);
      		int differenz = gfelder - roteFelder;
     		
   //   		setChart( panel, pieChart2D, getPieDataset(differenz, roteFelder),pieChartPanel2D );
      		
	      	
      		
	      	}
	  	      		
	      
	      	}
	      });
	      btnDel.setBounds(1491, 247, 93, 23);
	      contentPane.add(btnDel);
	      
	      
	      
	      
	    //#########################################################################
		  // B U T T O N s - > File chooser:  E X P O R T   
		//#########################################################################
	      
	      JButton btnExportXML = new JButton("  Export XML");
	      btnExportXML.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
	      btnExportXML.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		
	      if (vmap == null){
	    	  
	    	  System.out.println("nix zu exportieren");    // als jframe pop up
	      }else{
	      		
	      		
	      		String xml =".xml";
	      		fc.showSaveDialog(StartHere.this);
	      		File file = fc.getSelectedFile();
	     		String pfad = file.getPath();
	     		if( pfad.contains( "\\" ) )
	      		{
	      		 pfad = pfad.replace("\\", "\\\\");
	      		}
	     		
	     		if(pfad.contains(".xml"))
	    		{
	     				    			
	    		}else{
	    			pfad = pfad.concat(xml);
	 	   		}
	     		
	     	    		
	     		
	     		XMLparser.parseXML(vmap, pfad);
	      		
	      		}
	      		
	      	}
	      });
	      btnExportXML.setBounds(201, 27, 135, 23);
	      contentPane.add(btnExportXML);
	      
	      JLabel lblNewLabel = new JLabel("New label");
	      lblNewLabel.setIcon(new ImageIcon(StartHere.class.getResource("/img/logo.jpg")));					
	      lblNewLabel.setBounds(0, 11, 251, 283);
	      contentPane.add(lblNewLabel);
	      
	      	      
	    //#########################################################################
		  // B U T T O N s - > A E N D E R N   
		//#########################################################################
	      
	      
	      JButton btnndern = new JButton("\u00C4ndern");
	      btnndern.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	 
	    	      		
	 		  int k = 0;
		      for (int i = 0; i< 500; i++){	    
			      
		    table_1.setValueAt((boolean) false, i, 24);   
		    	  	if (vmap.get(i) == null){
		    	  		//do nothing  aber wird uebersprungen
		    	  		
		    	  	}else{
		    	
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setSemester( table_1.getValueAt(k, 0).toString());		
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setUeberschriftID( table_1.getValueAt(k, 1).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setUeberText( table_1.getValueAt(k, 2).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVeranstNummer(table_1.getValueAt(k, 3).toString());		
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVname( table_1.getValueAt(k, 4).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVkurzel( table_1.getValueAt(k, 5).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setvTyp( table_1.getValueAt(k, 6).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzSemester( table_1.getValueAt(k, 7).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVeranstterminVTID( table_1.getValueAt(k, 8).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVeranstterminRGID( table_1.getValueAt(k, 9).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzWoTagKurz( table_1.getValueAt(k, 10).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzBeginn( table_1.getValueAt(k, 11).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzEnde( table_1.getValueAt(k, 12).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzBeginnDat( table_1.getValueAt(k, 13).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzEndeDat( table_1.getValueAt(k, 14).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVzRhyth( table_1.getValueAt(k, 15).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVeranstperPID( table_1.getValueAt(k, 16).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setVeranstperVTID( table_1.getValueAt(k, 17).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setDozname( table_1.getValueAt(k, 18).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setDozvorname( table_1.getValueAt(k, 19).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setRaumName( table_1.getValueAt(k, 20).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setRaumForm( table_1.getValueAt(k, 21).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setGebKTxt( table_1.getValueAt(k, 22).toString());
		    	vmap.get((int) ( table_1.getValueAt(k, 23))).setTabellennr( (int)table_1.getValueAt(k, 23));
		    	table_1.setValueAt((boolean) false, k, 24); 
		   	      k++;
		    	  	}
		    	  	
		    	  
		      }
	      		
		      
		      	int roteFelder = getFehlerFelderAnzahl(vmap, table_1);
	      		int gfelder = (vmap.size()*23);
	      		int differenz = gfelder - roteFelder;
	      		
	      		
//	      		setChart( panel, pieChart2D, getPieDataset(differenz, roteFelder),pieChartPanel2D );  // chart aktualisieren
	   
	      		
	      		
	      		
	      	//#########################################################################
				  // T E S T A U S G A B E : aller Objekte 
	      	//#########################################################################
		      
		     
		/*    
		      int g = 0;
		      for (int i = 0; i< 500; i++){	    // groesse der hashmap UND einlesen der daten aus der CSV, daten aus datei abfragen
			      
		   	  	if (vmap.get(i) == null){
		    	  		//do nothing  aber wird uebersprungen
		    	  		
		    	  	}else{														// nur bis k wird eingelesen, also wo vmap != null
		    	  		System.out.println("");
		    System.out.print(vmap.get(i).getSemester()+" "+vmap.get(i).getUeberschriftID()+" "+ vmap.get(i).getUeberText()+ " "+ vmap.get(i).getVeranstNummer()+" "+vmap.get(i).getVname() + " " +
		    		vmap.get(i).getVkurzel()+ " "+vmap.get(i).getvTyp()+ " "+vmap.get(i).getVzSemester()+" "+vmap.get(i).getVeranstterminVTID() + " "+vmap.get(i).getVeranstterminRGID() +
		    		" "+ vmap.get(i).getVzWoTagKurz()+" "+vmap.get(i).getVzBeginn()+" " +vmap.get(i).getVzEnde()+ " "+vmap.get(i).getVzBeginnDat()+ " "+vmap.get(i).getVzEndeDat()+" "+
		    		vmap.get(i).getVzRhyth()+ " "+ vmap.get(i).getVeranstperPID()+ " "+vmap.get(i).getVeranstperVTID()+ " "+ vmap.get(i).getDozname()+ " "+ vmap.get(i).getDozvorname()+ 
		    		" " + vmap.get(i).getRaumName()+ " " +vmap.get(i).getRaumForm() + " " +vmap.get(i).getGebKTxt() + " " +vmap.get(i).getTabellennr());	  		
		 
		     
		      k++;
		    	  	}
		      }
		    //testausgabe
		      
		      
	      		
	      		
		  */    
		      
		      
	      	}
	      });
	      btnndern.setBounds(1392, 247, 89, 23);
	      contentPane.add(btnndern);
	      
	      
	      
	    //#########################################################################
		  // M E N U E B A R : Inhalt  
		//#########################################################################     
	   	      
	      JMenu mnDatei = new JMenu("Datei");
	      menuBar.add(mnDatei);
	      
	      JMenuItem mntmNeu = new JMenuItem("Neu");
	      mntmNeu.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		clearTable(table_1, vmap, anzahlSpalten); 
	      		if (vmap != null){
	      		setColotDefault(vmap, table_1);
//	      		setChart( panel, pieChart2D, getPieDataset(-1, -1),pieChartPanel2D );
	      		}
	      	}
	      });
	      mntmNeu.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
	      mnDatei.add(mntmNeu);
	      
	      JMenuItem mntmImportCsv = new JMenuItem("Import CSV..");
	      mntmImportCsv.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		fc.showOpenDialog(StartHere.this);
	      		File file = fc.getSelectedFile();
	     		String pfad = file.getPath();
	     		if( pfad.contains( ".csv" )){   		
	      		if( pfad.contains( "\\" ) )
	      		{
	      		 pfad = pfad.replace("\\", "\\\\");
	      		 Veranstaltung.setLasttabellennr(0);
	      		clearTable(table_1, vmap, anzahlSpalten);   //damit tabelle erst gelert wird
	      		 setHashMap(Dateiverarbeitung.getMap(pfad));
	    	      		
	      		setTableInhalt(table_1, vmap);
	      		int roteFelder = getFehlerFelderAnzahl(vmap, table_1);
	      		int gfelder = (vmap.size()*23);
	      		int differenz = gfelder - roteFelder;
	     		
//	      		setChart( panel, pieChart2D, getPieDataset(differenz, roteFelder),pieChartPanel2D );
	      		  // chart aktualisieren
	      		
	      		}
	      		
	     		}
	      	}
	      });
	      mntmImportCsv.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Indent.png")));
	      mnDatei.add(mntmImportCsv);
	      
	      JMenuItem mntmSpeichernUnter = new JMenuItem("Speichern unter..");
	      mntmSpeichernUnter.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
	      mnDatei.add(mntmSpeichernUnter);
	      
	      JMenuItem mntmExportXml = new JMenuItem("Export XML..");
	      mntmExportXml.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      	   if (vmap == null){
	 	    	  }else{
	 	      		String xml =".xml";
	 	      		fc.showSaveDialog(StartHere.this);
	 	      		File file = fc.getSelectedFile();
	 	     		String pfad = file.getPath();
	 	     		if( pfad.contains( "\\" ) )
	 	      		{
	 	      		 pfad = pfad.replace("\\", "\\\\");
	 	      		}
	 	     		
	 	     		if(pfad.contains(".xml"))
	 	    		{
	 	     				    			
	 	    		}else{
	 	    			pfad = pfad.concat(xml);
	 	 	   		}
	 	     		XMLparser.parseXML(vmap, pfad);
	 	      		}
	      	}
	      });
	      mntmExportXml.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
	      mnDatei.add(mntmExportXml);
	      
	      JMenuItem mntmBeenden = new JMenuItem("Beenden");
	      mntmBeenden.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		dispose();
	      	}
	      });
	      mntmBeenden.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeLeaf.gif")));
	      mnDatei.add(mntmBeenden);
	      
	      JMenu menu = new JMenu("?");
	      menuBar.add(menu);
	      
	      JMenuItem mntmber = new JMenuItem("\u00FCber");
	      mntmber.setIcon(new ImageIcon(StartHere.class.getResource("/com/sun/java/swing/plaf/windows/icons/ListView.gif")));
	      menu.add(mntmber);
	      
	      
	    //#########################################################################
		  // D R A G & D R O P   
		//#########################################################################      
	      JPanel DragnDrobObjekt = new JPanel();
	      DragnDrobObjekt.setBorder(BorderFactory.createEmptyBorder(-2, -2 ,-2 , -2 ));
	     // DragnDrobObjekt.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY)); //backup
	      DragnDrobObjekt.setBounds(1162, 59, 232, 143);
	      contentPane.add(DragnDrobObjekt);
	      DragnDrobObjekt.setLayout(new BorderLayout(0, 0));
	      DragnDrobObjekt.setSize(300, 180);
	      DragDrobObj dragDrobObj = new DragDrobObj();
	      dragDrobObj.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	      dragDrobObj.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      DragnDrobObjekt.add(dragDrobObj, BorderLayout.CENTER);
	      
	      JLabel label = new JLabel("");
	      label.setIcon(new ImageIcon(StartHere.class.getResource("/img/drag.jpg")));
	      label.setBounds(1461, 79, 161, 119);
	      contentPane.add(label);
	      
	      JButton DBschreiben = new JButton("Schreibe in DB");
	      DBschreiben.setIcon(new ImageIcon(StartHere.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
	      DBschreiben.setBounds(359, 27, 148, 23);
	      contentPane.add(DBschreiben);
	      
	     	  	 
	    
		}

	//#########################################################################
	  // S T A R T H E R E: Classe Ende  
	//#########################################################################
	
	
	
	
	
	//#########################################################################
	  // T A B L E M O D E L: + entspr. Methoden get/set Inhalt  
	//#########################################################################
	
	
		public void setTableInhalt(JTable table_1, HashMap<Integer, Veranstaltung> vmap){
		
		
		  int k = 0;
	      for (int i = 0; i< 500; i++){	    
		      
	    table_1.setValueAt((boolean) false, i, 24);   
	    	  	if (vmap.get(i) == null){
	    	  		//do nothing  aber wird uebersprungen
	    	  		
	    	  	}else{														
	    	  	    	  
	      table_1.setValueAt(vmap.get(i).getSemester(), k, 0);				
	      table_1.setValueAt(vmap.get(i).getUeberschriftID(), k, 1);
	      table_1.setValueAt(vmap.get(i).getUeberText(), k, 2);
	      table_1.setValueAt(vmap.get(i).getVeranstNummer(), k, 3);
	      table_1.setValueAt(vmap.get(i).getVname(), k, 4);
	      table_1.setValueAt(vmap.get(i).getVkurzel(), k, 5);
	      table_1.setValueAt(vmap.get(i).getvTyp(), k, 6);
	      table_1.setValueAt(vmap.get(i).getVzSemester(), k, 7);
	      table_1.setValueAt(vmap.get(i).getVeranstterminVTID(), k, 8);
	      table_1.setValueAt(vmap.get(i).getVeranstterminRGID(), k, 9);
	      table_1.setValueAt(vmap.get(i).getVzWoTagKurz(), k, 10);
	      table_1.setValueAt(vmap.get(i).getVzBeginn(), k, 11);
	      table_1.setValueAt(vmap.get(i).getVzEnde(), k, 12);
	      table_1.setValueAt(vmap.get(i).getVzBeginnDat(), k, 13);
	      table_1.setValueAt(vmap.get(i).getVzEndeDat(), k, 14);
	      table_1.setValueAt(vmap.get(i).getVzRhyth(), k, 15);
	      table_1.setValueAt(vmap.get(i).getVeranstperPID(), k, 16);
	      table_1.setValueAt(vmap.get(i).getVeranstperVTID(), k, 17);
	      table_1.setValueAt(vmap.get(i).getDozname(), k, 18);
	      table_1.setValueAt(vmap.get(i).getDozvorname(), k, 19);
	      table_1.setValueAt(vmap.get(i).getRaumName(), k, 20);
	      table_1.setValueAt(vmap.get(i).getRaumForm(), k, 21);
	      table_1.setValueAt(vmap.get(i).getGebKTxt(), k, 22);
	      table_1.setValueAt(vmap.get(i).getTabellennr(), k, 23);  
	      table_1.setValueAt((boolean) false, k, 24); 
	      k++;
	    	  	}
	    	  	
	         }
	          
	      //Farbe je Zelle Methode
	      setCellColor(vmap, table_1);
	          
	      
	}
	
		
	
	public void clearTable(JTable table_1, HashMap<Integer, Veranstaltung> vmap, int anzahlSpalten){
		      
			      for (int i = 0; i < 500; i++) {					
						for (int p = 0; p < anzahlSpalten-1; p++) {
							table_1.setValueAt("",i,p);						
							}
						
					}
			     
		table_1.repaint();
	}
	
			
	// methode zum faerben der einzelnen Zellen

	   public void setCellColor(HashMap<Integer, Veranstaltung> vmap, JTable table_1){				
		   		      table_1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		   		    		private static final long serialVersionUID = 1L;

					@Override
		            public Component getTableCellRendererComponent(JTable table,
		                    Object value, boolean isSelected, boolean hasFocus,
		                    int row, int column) {
		 
		                Component c = super.getTableCellRendererComponent(table, value,
		                        isSelected, hasFocus, row, column);
		 
		                
		          for (int h = 0; h < vmap.size(); h++) {
		    				for (int p = 0; p < 24; p++) {
		    					if (table_1.getValueAt(h, p).equals("") || table_1.getValueAt(h, p).equals("0")){
		                
		    					if (row == h && column == p) {
		                   			setBackground(new Color(255, 150, 150));
		                   	}
		    				
		                } else if (row == h && column == p){ 
		                      setBackground(new Color(239, 246, 250));
		                }
		    					
		    						    					
		    				}}	
		                return this;
		               
		            }
		        });
		   		      
		      }	
	 
	   public void setColotDefault(HashMap<Integer, Veranstaltung> vmap, JTable table_1){			
		      table_1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		    		private static final long serialVersionUID = 1L;

			@Override
         public Component getTableCellRendererComponent(JTable table,
                 Object value, boolean isSelected, boolean hasFocus,
                 int row, int column) {

             Component c = super.getTableCellRendererComponent(table, value,
                     isSelected, hasFocus, row, column);

             
       for (int h = 0; h < vmap.size(); h++) {
 				for (int p = 0; p < 23; p++) {
 					if (table_1.getValueAt(h, p).equals("") || table_1.getValueAt(h, p).equals("0")){
             
 					if (row == h && column == p) {
                			setBackground(new Color(239, 246, 250));
                	}
 				
             } else if (row == h && column == p){ 
                   setBackground(new Color(239, 246, 250));
             }
 					
 						    					
 				}}	
             return this;
            
         }
     });
		      
   }	
	// # # # # # # # #####################    
	   
	
	// Anzahl der fehlerhaften felder in der Matrix
	   public int getFehlerFelderAnzahl(HashMap<Integer, Veranstaltung> vmap, JTable table_1){
		   
		      // Anzahl der roten felder
		     int fehlerfelder =0;
		      for (int h = 0; h < vmap.size(); h++) {
					for (int p = 0; p < 23; p++) {
						if (table_1.getValueAt(h, p).equals("") || table_1.getValueAt(h, p).equals("0")){
							fehlerfelder++;
		           	}else{}
					
	          } 
	      }
			
		   return fehlerfelder;
		    
	   }
	   
	 //#########################################################################
		  // J F R E E C H A R T  - > Erstellen des Tortendiagramm 
	//#########################################################################
	   
		 public void setChart(JPanel panel, JFreeChart pieChart2D, DefaultPieDataset dataset, ChartPanel chartPafnel){
			
					 
			 int cWidth = 300;
				int cHeight = 300;
				int minWidth = 350;
				int minHeight = 350;
				int maxWidth = 450;
				int maxHeight = 450; 
			 panel.removeAll();
			 panel.revalidate(); 
			
			 pieChart2D = ChartFactory.createPieChart("", dataset, false, true, true);
			 pieChart2D.removeLegend(); 
			 
			
			    ChartPanel chartPanel = new ChartPanel(pieChart2D, cWidth, cHeight, minWidth, 	minHeight, maxWidth, maxHeight,	false, 	false, 	false, 	false, 	false, 	false); 
			    chartPanel.setBackground(Color.WHITE);
			    panel.setLayout(new BorderLayout()); 
			    panel.add(chartPanel); 
			  	panel.repaint(); 
			    PiePlot plot = (PiePlot)pieChart2D.getPlot(); 
				Color[] colors = {getColor(),(new Color(255, 150, 150))}; 	
																							 backup Color[] colors = {(new Color(128, 205, 221)), new Color(255, 150, 150)}; 	//backup
		        PieRenderer renderer = new PieRenderer(colors); 
		        renderer.setColor(plot, dataset);
				plot.setBackgroundAlpha(0);					//transparenter hintergrund
				plot.setOutlineVisible(false);
			}

		
				 private DefaultPieDataset getPieDataset(int x, int y)  //  jfreechart Dataset
				    {
					 setColor(y);
				      String ok = "OK"; 
				      String fehler = y+" Fehler";
					 	if (y == 0){
					 		y = -1;
					 		ok = "100 % OK";
					 	}
					 	
					 	if (x == 0){
					 		x = -1;
					 		fehler = "Fehler!";
					 	}
					 	
					 	
					 	DefaultPieDataset dataset = new DefaultPieDataset();
				        dataset.setValue(ok, x);
				        dataset.setValue(fehler, y);
				            	 
				        return dataset;
				
				    }

				 
				   eigene Farbe
				 public static class PieRenderer 		//gehort zu jfreechart
				    { 
				        private Color[] color; 
				        
				        public PieRenderer(Color[] color) 
				        { 
				            this.color = color; 
				        }        
				        
				        public void setColor(PiePlot plot, DefaultPieDataset dataset) 
				        { 
				            List <Comparable> keys = dataset.getKeys(); 
				            int aInt; 
				            
				            for (int i = 0; i < keys.size(); i++) 
				            { 
				                aInt = i % this.color.length; 
				                plot.setSectionPaint(keys.get(i), this.color[aInt]); 
				                   
				                
				            } 
				 
				        }
				        
				        
				    }
	 				 
				 festlegen der Diagrammfarbe
				 public Color getColor (){
					 return farbe;
				 }
				 
				 public void setColor (int y){
					if (y == 0){	
					  farbe =  new Color(90, 190, 110);
					}else {
						farbe =  new Color(128, 205, 221);
					}
					
										 
					 }
}

