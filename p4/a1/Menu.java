package pk1.p4.a1;

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
							+ "3. Zeige alle Medien\n4. Zeige neues Medium\n"
							+ "5. Berechne durchschnittliches Erscheinungsjahr\n6. Beenden\n\nBitte Menuepunkt waehlen:");

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
					medienverwaltung.zeigeMedien();
					break;
				case 4:
					medienverwaltung.sucheNeuesMedium();
					break;
				case 5:
					System.out.println(medienverwaltung
							.berechneErscheinungsjahr());
					break;
				case 6:
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
}
