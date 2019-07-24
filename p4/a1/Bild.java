package pk1.p4.a1;

public class Bild extends Medium {

	private String ort;

	public Bild(String titel, int jahr, String ort) {

		super(titel, jahr);
		this.ort = ort;

	}

	public String getOrt() {
		return ort;
	}

	public void druckeDaten() {
		System.out.println("ID= " + getId() + " \"" + getTitel()
				+ "\" aufgenommen im Jahr " + getJahr() + " in " + getOrt());
	}

}
