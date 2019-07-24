package pk1.p8.a1.fachlogik;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import pk1.p8.a1.datenhaltung.PersistenzException;
import pk1.p8.a1.datenhaltung.SerialisierungDAO;

public class Medienverwaltung {

	private List<Medium> liste;
	private SerialisierungDAO serialisierung;

	public Medienverwaltung() {
		liste = new ArrayList<Medium>();
		serialisierung = new SerialisierungDAO();
	}
	public void audioAufnehmen(String titel,String interpret,int dauer,int jahr){
		liste.add(new Audio(titel,jahr,interpret,dauer));
	}
	public void bildAufnehmen(String titel,int jahr,String ort){
		liste.add(new Bild(titel,jahr,ort));
	}
	public void aufnehmen(Medium m) {
		liste.add(m);
	}

	public List<Medium> getListe() {
		return liste;
	}

	public void setListe(List<Medium> liste) {
		this.liste = liste;
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

	public String sucheNeuesMedium() {
		if (liste.isEmpty()) {
			return "";
		} else {

			Medium me = liste.get(0);

			for (Medium aa : liste) {
				if (me.getJahr() <= aa.getJahr())
					me = aa;
			}
			
			return me.toString();
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

	public void speichern(File file) throws PersistenzException {
		serialisierung.speichern(liste, file);
	}

	public void laden(File file) throws PersistenzException {
		getListe().clear();
		liste = serialisierung.laden(file);
		Medium.setAnzahl(getListe().size());
	}
	public void schreibeMedien(FileOutputStream out) {
		Collections.sort(liste);
		for (Medium m : liste) {
			m.druckedaten(out);
		}
	}

	public Iterator<Medium> iterator() {

		Iterator<Medium> it = liste.iterator();

		return it;
	}
	public List<Audio> getAudio() {

		List<Audio> audio = new ArrayList<Audio>();

		if (this.liste.size() == 0) {
			System.out.println("Medien Liste ist leer");
			return null;
		}

		try {
			for (int i = 0; i < this.liste.size(); i++) {

				if (this.liste.get(i) instanceof Audio) {

					audio.add((Audio) this.liste.get(i));
				}
			}
		} catch (Exception e) {
			System.out.println("Fehler beim erstellen der AudioListe");
			e.printStackTrace();
		}

		return audio;
	}

	public List<Bild> getBild() {

		List<Bild> bild = new ArrayList<Bild>();

		if (this.liste.size() == 0) {
			System.out.println("Medien Liste ist leer");
			return null;
		}

		try {
			for (int i = 0; i < this.liste.size(); i++) {

				if (this.liste.get(i) instanceof Bild) {

					bild.add((Bild) this.liste.get(i));
				}
			}
		} catch (Exception e) {
			System.out.println("Fehler beim erstellen der BildList");
			e.printStackTrace();
		}

		return bild;
	}
}