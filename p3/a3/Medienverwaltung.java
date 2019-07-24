package pk1.p3.a3;

import java.util.*;

public class Medienverwaltung {

	private List<Medium> liste;

	public Medienverwaltung() {
		liste = new ArrayList<Medium>();
	}

	public void aufnehmen(Medium m) {
		liste.add(m);
	}

	public void zeigeMedien() {

		if (liste.isEmpty())
			System.out.println("Die Liste ist leer");
		else {
			Collections.sort(liste);

			Iterator<Medium> it = liste.iterator();

			while (it.hasNext()) {

				it.next().druckeDaten();
			}
		}
	}

	public void sucheNeuesMedium() {
		if (liste.isEmpty()) {
			System.out.println("Es gibt keine gespeicherte Medien");
		} else {

			Medium me = liste.get(0);

			for (Medium aa : liste) {
				if (me.getJahr() <= aa.getJahr())
					me = aa;
			}
			me.druckeDaten();
		}

	}

	public double berechneErscheinungsjahr() {
		double d = 0.0;

		if (liste.isEmpty()) {
			return d;
		} else {
			for (Medium me : liste) {
				d += me.getJahr();
			}
			return (d / liste.size());

		}
	}
}