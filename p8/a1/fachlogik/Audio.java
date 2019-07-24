package pk1.p8.a1.fachlogik;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Audio extends Medium {

	private String interpert;
	private int dauer;

	public Audio() {
	
	}

	public Audio(String titel, int jahr, String interpert, int dauer) {
		super(titel, jahr);
		this.dauer = dauer;
		this.interpert = interpert;
	}

	public String getInterpert() {
		return interpert;
	}

	public void setInterpert(String interpert) {
		this.interpert = interpert;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public String getTitel() {
		return super.getTitel();
	}

	public int getJahr() {
		return super.getJahr();
	}

	public void druckedaten(OutputStream stream) {

		PrintWriter print = new PrintWriter(stream);

		print.printf("ID= %d %s von %s aus %d Spieldauer: %d%n", getId(),
				getTitel(), getInterpert(), getJahr(), getDauer());
		print.flush();

	}

	public String toString() {
		return "ID = " + getId() + " \"" + getTitel() + "\" von "
				+ getInterpert() + " aus " + getJahr() + " Spieldauer: "
				+ getDauer() + " sek.";
	}

}
