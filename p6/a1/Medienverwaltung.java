package pk1.p6.a1;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Medienverwaltung{

	private List<Medium> liste;

	public Medienverwaltung() {
		liste = new ArrayList<Medium>();
	}

	public void aufnehmen(Medium m) {
		liste.add(m);
	}

	public List<Medium> getListe() {
		return liste;
	}

	public void setListe(List<Medium> l) {
		this.liste = l;
	}

	public void zeigeMedien(OutputStream out) {

		if (liste.isEmpty())
			System.out.println("Es gibt keine gespeicherte Medien");
		else {
			Collections.sort(liste);

			Iterator<Medium> it = liste.iterator();

			while (it.hasNext()) {

				it.next().druckedaten(out);
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
			me.druckedaten(System.out);
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