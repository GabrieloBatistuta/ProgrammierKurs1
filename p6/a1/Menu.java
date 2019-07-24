
package pk1.p6.a1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.JOptionPane;

public class Menu {

	private static final Exception EmptyFile = null;

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
							+ "6. Berechne durchschnittliches Erscheinungsjahr\n7. Spreichern\n8. Laden\n"
							+ "9. Beenden\n\nBitte Menuepunkt waehlen:");

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
					speichern();
					break;
				case 8:
					laden();
					break;
				case 9:
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
					throw EmptyFile;

			} catch (Exception e) {
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

	public void speichern() {

		String name = null;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			name = JOptionPane.showInputDialog(null,"Geben Sie den Name ein!!!");
			
			File f = new File(name);
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);

			// Diese Methode sirialisiert ein kompletes Objekt
			oos.writeObject(medienverwaltung.getListe());

			// Diese Methode sirialisiert ein Attribut(also statische Attribute)
			oos.writeInt(Medium.KONSTANTE);

		} catch (IOException e) {
			System.out.println("Fehler bei der Serialisierung");
		} finally {
			try {
				if (oos != null)
					oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void laden() {

		String name = null;
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			name = JOptionPane.showInputDialog(null,
					"Geben Sie den Name ein!!!");
			File f = new File(name);
			fis = new FileInputStream(f);
			// wenn hier ein Problem auftaucht dann wird
			// ObjecInputStream = null weil es eh kein Object erzeugt wurde
			ois = new ObjectInputStream(fis);

			List<Medium> liste;
			liste = new ArrayList<Medium>();

			try {

				liste = (ArrayList<Medium>) ois.readObject();

				medienverwaltung.setListe(liste);
				Medium.KONSTANTE = ois.readInt();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			System.out.println("Fehler bei der Serialisierung");
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
