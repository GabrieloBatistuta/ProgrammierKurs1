package pk1.p8.a1.gui;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pk1.p8.a1.datenhaltung.IMvDAO;
import pk1.p8.a1.datenhaltung.PersistenzException;
import pk1.p8.a1.datenhaltung.SerialisierungDAO;
import pk1.p8.a1.fachlogik.Medienverwaltung;
import pk1.p8.a1.fachlogik.Medium;

public class HauptF extends JFrame implements ListSelectionListener,
		ActionListener {

	private Medienverwaltung medienverwaltung;
	private JList<Medium> liste;
	private JListModel listemodel;

	public HauptF(Medienverwaltung m) {
		this.setSize(270, 190);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Hauptmenü");
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.medienverwaltung = m;

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		listemodel = new JListModel();
		liste = new JList<Medium>(listemodel);
		liste.addListSelectionListener(this);
		JScrollPane scroll = new JScrollPane(liste);
		panel.add(scroll);

		Border rahmen = BorderFactory.createEtchedBorder();
		Border rahmenTitel = BorderFactory.createTitledBorder(rahmen,
				"Medienliste");

		this.add(panel, BorderLayout.CENTER);
		this.menuErstellen();
		this.setVisible(true);
	}

	public void menuErstellen() {

		JMenuBar menu = new JMenuBar();
		JMenu menu1 = new JMenu("Datei");
		JMenu menu2 = new JMenu("Medium");
		JMenu menu3 = new JMenu("Anzeige");

		JMenuItem laden = new JMenuItem("Laden");
		JMenuItem speichern = new JMenuItem("Speichern");
		JMenuItem medienlist = new JMenuItem("Medienlist in Datei schreiben");
		JMenuItem beenden = new JMenuItem("Beenden");
		JMenuItem audioAnlegen = new JMenuItem("Audio anlegen");
		JMenuItem bildAnlegen = new JMenuItem("Bild anlegen");
		JMenuItem erscheinungsjahr = new JMenuItem("Erscheinungsjahr anzeigen");
		JMenuItem neuesMedium = new JMenuItem("Neustes Medium anzeigen");
		JMenuItem alleBilder = new JMenuItem("Alle Bilder anzeigen");
		JMenuItem alleAudio = new JMenuItem("Alle Audio anzeigen");

		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);

		
		menu1.add(laden);
		menu1.add(speichern);
		menu1.add(medienlist);
		menu1.add(beenden);
		menu2.add(audioAnlegen);
		menu2.add(bildAnlegen);
		menu3.add(erscheinungsjahr);
		menu3.add(neuesMedium);
		menu3.add(alleBilder);
		menu3.add(alleAudio);

		
		laden.setActionCommand("Laden");
		speichern.setActionCommand("Speichern");
		medienlist.setActionCommand("Medienlist in Datei schreiben");
		beenden.setActionCommand("Beenden");
		audioAnlegen.setActionCommand("Audio anlegen");
		bildAnlegen.setActionCommand("Bild anlegen");
		erscheinungsjahr.setActionCommand("Erscheinungsjahr anzeigen");
		neuesMedium.setActionCommand("Neustes Medium anzeigen");
		alleBilder.setActionCommand("Alle Bilder anzeigen");
		alleAudio.setActionCommand("Alle Audio anzeigen");

		this.setJMenuBar(menu);
		
		

		laden.addActionListener(this);
		speichern.addActionListener(this);
		medienlist.addActionListener(this);
		beenden.addActionListener(this);
		audioAnlegen.addActionListener(this);
		bildAnlegen.addActionListener(this);
		erscheinungsjahr.addActionListener(this);
		neuesMedium.addActionListener(this);
		alleBilder.addActionListener(this);
		alleAudio.addActionListener(this);

	}

	public void valueChanged(ListSelectionEvent event) {

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Laden")) {
			FileDialog fileOeffnen = new FileDialog(this, "ï¿½ffnen");
			fileOeffnen.setFile(".txt");
			fileOeffnen.setDirectory(null);
			fileOeffnen.setVisible(true);
			String fileName = fileOeffnen.getDirectory() + fileOeffnen.getFile();

			if (fileName != null) {
				fileOeffnen.dispose();
				
				try {
					medienverwaltung.laden(new File(fileName));
				} catch (PersistenzException e) {
					e.printStackTrace();
				}

				for (int i = 0; i < medienverwaltung.getListe().size(); i++) {
					listemodel.addElement(medienverwaltung.getListe().get(i));
				}
			}

		} else if (event.getActionCommand().equals("Speichern")) {
			FileDialog fileSpeichern = new FileDialog(this, "Speichern");
			fileSpeichern.setMode(FileDialog.SAVE);
			fileSpeichern.setDirectory(null);
			fileSpeichern.setFile(".txt");
			fileSpeichern.setVisible(true);

			String fileName = fileSpeichern.getDirectory() + fileSpeichern.getFile();
			try {
				medienverwaltung.speichern(new File(fileName));
			} catch (PersistenzException e) {
				e.printStackTrace();
			}

			fileSpeichern.dispose();
		} else if (event.getActionCommand().equals(
				"Medienlist in Datei schreiben")) {
			FileDialog filedia = new FileDialog(this, "Speichern");
			filedia.setMode(FileDialog.SAVE);
			filedia.setDirectory(null);
			filedia.setFile("*.txt");
			filedia.setVisible(true);

			String filename = filedia.getDirectory() + filedia.getFile();
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(new File(filename));
				medienverwaltung.schreibeMedien(out);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			filedia.dispose();

		} else if (event.getActionCommand().equals("Beenden")) {
			System.exit(0);
		} else if (event.getActionCommand().equals("Audio anlegen")) {
			new ErfassungAudio(medienverwaltung, listemodel);
		} else if (event.getActionCommand().equals("Bild anlegen")) {
			new ErfassungBild(medienverwaltung, listemodel);
		} else if (event.getActionCommand().equals("Erscheinungsjahr anzeigen")) {
			new ErscheinungsjahrF(medienverwaltung);
		} else if (event.getActionCommand().equals("Neustes Medium anzeigen")) {
			try {
				new NeusteMediumF(medienverwaltung);
			} catch (NullPointerException ex) {
				new FeldFehler("Keine Medien Vorhanden", "Fehler");
			}
		} else if (event.getActionCommand().equals("Alle Bilder anzeigen")) {
			new BildViewModel(new BildTableModel(
					medienverwaltung.getBild()));
		} else if (event.getActionCommand().equals("Alle Audio anzeigen")) {
			new AudioViewTable(new AudioTableModel(
					medienverwaltung.getAudio()));
		}

	}

}
