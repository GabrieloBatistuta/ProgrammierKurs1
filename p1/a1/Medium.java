package pk1.p1.a1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Medium {

	private final int id;
	private static int KONSTANTE = 0;
	private String titel;
	private int jahr;

	public Medium(String titel, int jahr) {
		this.id = KONSTANTE;
		this.titel = titel;
		this.jahr = jahr;
		KONSTANTE++;
	}

	public String getTitel() {
		return titel;
	}

	public int getJahr() {
		return jahr;
	}

	public int getMedienalter() {
		Calendar c = new GregorianCalendar();
		int aktJahr = c.get(Calendar.YEAR);
		return aktJahr - jahr;
	}

	public int getId() {
		return id;
	}

	public abstract void druckeDaten();
}
