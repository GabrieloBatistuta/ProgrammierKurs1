package pk1.p3.a1;

import java.util.*;

public class Medienverwaltung {

	private Collection liste;

	public Medienverwaltung() {
		liste = new ArrayList();
	}

	public void aufnehmen(Medium m) {
		liste.add(m);

	}

	public void zeigeMedien() {

		Iterator it = liste.iterator();

		while (it.hasNext()) {
			((Medium) it.next()).druckeDaten();

		}

	}

	public void sucheNeuesMedium() {
		if (liste.isEmpty()) {
			System.out.println("Es gibt keine gespeicherte Medien");
		} else {

			Iterator it = liste.iterator();

			Medium neu = (Medium) it.next();

			while (it.hasNext()) {
				Medium temp = (Medium) it.next();

				if ((neu.getMedienalter() >  temp.getMedienalter())) {
					neu = temp;
				}
			}

			neu.druckeDaten();

		}
	}

	public double berechneErscheinungsjahr() {
		double d = 0.0;
		if (liste.isEmpty())
			return d;

		for (Object me : liste) {
			d += ((Medium) me).getJahr();

		}

		return (d / liste.size());

	}
}