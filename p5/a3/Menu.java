package pk1.p5.a3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class Menu {

	private Medienverwaltung medienverwaltung;

	private Scanner sc;

	public Menu(Medienverwaltung m) {

		this.medienverwaltung = m;

		sc = new Scanner(System.in);
	}

	public void zeigeMenu() {

		while (true) {

			System.out
					.println("Medienverwaltung\n1. Audio aufnehmen\n2. Bild aufnehmen\n"
							+ "3. Zeige alle Medien\n4. Medienliste in Datei schreiben\n5. Zeige neues Medium\n"
							+ "6. Berechne durchschnittliches Erscheinungsjahr\n7. Beenden\n\nBitte Menuepunkt waehlen:");

			String eingabe = sc.next();

			try {
				int i = Integer.parseInt(eingabe);

				switch (i) {

				case 1:
					audioAufnehmen();
					break;
				case 2:
					bildAufnehmen();
					break;
				case 3:
					medienverwaltung.zeigeMedien(System.out);
					break;
				case 4:
					medienliste();
					break;
				case 5:
					medienverwaltung.sucheNeuesMedium();
					break;
				case 6:
					System.out.println(medienverwaltung
							.berechneErscheinungsjahr());
					break;
				case 7:
					return;
				default:

					JOptionPane.showMessageDialog(null,
							"Geben Sie eine gültige Zahl ein !!!");
				}

			} catch (NumberFormatException e) {
				JOptionPane
						.showMessageDialog(null, "Keine Buchstaben eingeben");
			}
			System.out.println("***********************");
		}
	}

	public void audioAufnehmen() {

		String titel = JOptionPane.showInputDialog(null, "Titel");

		int jahr = 0;

		do {

			try {
				jahr = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Jahr"));
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "Keine Buchstaben eingeben");
			}
		} while (jahr == 0);

		String interpret = JOptionPane.showInputDialog(null, "Interpret");

		int dauer = 0;
		do {

			try {
				dauer = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Dauer"));

			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "Keine Buchstaben eingeben");
			}

		} while (dauer == 0);

		Audio audio = new Audio(titel, jahr, interpret, dauer);

		medienverwaltung.aufnehmen(audio);

	}

	public void bildAufnehmen() {
		String title = JOptionPane.showInputDialog(null, "Title");
		int jahr = 0;
		do {
			try {
				jahr = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Jahr"));
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "Keine Buchstaben eingeben");
			}

		} while (jahr == 0);

		String ort = JOptionPane.showInputDialog(null, "Ort");

		Bild bild = new Bild(title, jahr, ort);
		medienverwaltung.aufnehmen(bild);

	}

	public void medienliste() {
		File f = null;
		FileOutputStream fos = null;
		boolean richtigeEingabe = false;
		do {
			try {
				String name = JOptionPane.showInputDialog("Name der File");

				if (name != null && !name.isEmpty()) {
					f = new File(name);
					richtigeEingabe = true;
				} else
					throw new EmptyFilenameException();

			} catch (EmptyFilenameException e) {
				JOptionPane.showMessageDialog(null,
						"Geben Sie einen gültigen Namen ein !!!");
			}

		} while (!richtigeEingabe);

		try {
			fos = new FileOutputStream(f);
			medienverwaltung.zeigeMedien(fos);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			
			try {
				fos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
