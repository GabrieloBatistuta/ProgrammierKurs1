package pk1.p8.a1.fachlogik;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Medium implements Comparable<Medium>, Serializable {

	private final int id;
	public static int anzahl = 0;
	private String titel;
	private int jahr;
	private static int i=0;
	public Medium(String titel, int jahr) {
		this.id = anzahl;
		this.titel = titel;
		this.jahr = jahr;
		anzahl++;
	}
	public Medium() {
		this.id = anzahl;
	}

	public static void setAnzahl(int i){
		anzahl=i;
	}
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public int alter() {
		Calendar c = new GregorianCalendar();
		int aktJahr = c.get(Calendar.YEAR);
		return aktJahr - jahr;
	}

	public int getId() {
		return id;
	}

	public abstract void druckedaten(OutputStream stream);

	public int compareTo(Medium o) {
		if (this.getJahr() > o.getJahr())
			return 1;
		if (this.getJahr() < o.getJahr())
			return -1;
		else
			return 0;
	}
}
