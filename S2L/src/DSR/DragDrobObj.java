package DSR;

import java.util.*;
import java.io.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DragDrobObj extends JScrollPane implements DropTargetListener {

	// Klasse in StartHere integriert
	HashMap<Integer, Veranstaltung> vmap = null;
	private JTextArea target = null;

	public static void main(String[] args) {
		JFrame f = new JFrame("Drag  Drop Beispiel");
		f.getContentPane().setLayout(new BorderLayout());
		f.setSize(600, 400);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		f.getContentPane().add(new DragDrobObj(), BorderLayout.CENTER);
		f.setVisible(true);
	}

	public DragDrobObj() {
		target = new JTextArea(20, 60);
		getViewport().add(target);
		DropTarget dt = new DropTarget();
		dt.setComponent(target);
		try {
			dt.addDropTargetListener(this);
		} catch (TooManyListenersException e) {
			System.out.println("");
		}
	}

	public void dragEnter(DropTargetDragEvent dEvent) {

	}

	public void dragOver(DropTargetDragEvent dEvent) {
	}

	public void dragExit(DropTargetEvent dEvent) {
	}

	public void dropActionChanged(DropTargetDragEvent dEvent) {
	}

	public void drop(DropTargetDropEvent dEvent) {

		// vorbereitung - get Path

		String pfad = null;

		boolean ready = false;
		if ((dEvent.getSourceActions() & DnDConstants.ACTION_COPY) == 0)

			dEvent.rejectDrop();
		else {
			dEvent.acceptDrop(DnDConstants.ACTION_COPY);
			Transferable trans = dEvent.getTransferable();
			DataFlavor[] currentFlavors = dEvent.getCurrentDataFlavors();
			DataFlavor selectedFlavor = null;
			for (int i = 0; i < currentFlavors.length; i++) {
				if (DataFlavor.javaFileListFlavor.equals(currentFlavors[i])) {
					selectedFlavor = currentFlavors[i];
					break;
				}
			}
			if (selectedFlavor != null) {
				try {
					Iterator dateien = ((java.util.List) trans.getTransferData(selectedFlavor)).iterator();
					while (dateien.hasNext()) {
						File datei = (File) dateien.next();
						pfad = datei.getPath();
						target.append(datei.getPath());
						target.append("\n");
					}
					ready = true;
				} catch (Exception e) {
					System.out.println("Es ist ein Fehler aufgetreten: " + e);
				}
			}
		}

		// ##### import der Datei als Objekte

		if (pfad.contains(".csv")) {

			if (pfad.contains("\\")) {
				pfad = pfad.replace("\\", "\\\\");

				Veranstaltung.setLasttabellennr(0);

				vmap = Dateiverarbeitung.getMap(pfad);

			}
		} else {

			target.append(" - - Fehler: - -  \nKeine gültige CSV Datei !");
			target.append("\n");
		}

		// ###### Export als XML

		if (vmap == null) {

			System.out.println("nix zu exportieren!"); // als jframe pop up
		} else {

			if (pfad.contains(".csv")) {
				pfad = pfad.replace(".csv", ".xml");
			}
			/*
			 * String xml =".xml";
			 * 
			 * if(pfad.contains(".xml")) {
			 * 
			 * }else{ pfad = pfad.concat(xml); }
			 */
			XMLparser.parseXML(vmap, pfad);
			target.append("XML Erfolgreich exportiert  \n");
			target.append("\n");

		}


	}

}
