package pk1.p8.a1.fachlogik;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Bild extends Medium {

	private String ort;

	public Bild(String titel, int jahr, String ort) {

		super(titel, jahr);
		this.ort = ort;

	}

	public Bild() {

	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public void druckedaten(OutputStream stream) {

		PrintWriter print = new PrintWriter(stream);

		print.printf("ID= %d \"%s\" aufgenommen im jahr %d in %s%n", getId(),
				getTitel(), getJahr(), getOrt());
		print.flush();
	}

	public String toString() {
		return "ID = " + getId() + " \"" + getTitel() + "\" aufgenommen im Jahr"
				+ getJahr() + " in " + getOrt();
	}

}
