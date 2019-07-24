package pk1.p5.a3;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Bild extends Medium {

	private String ort;

	public Bild(String titel, int jahr, String ort) {

		super(titel, jahr);
		this.ort = ort;

	}

	public String getOrt() {
		return ort;
	}

	public void druckedaten(OutputStream stream) {
		
		PrintWriter print=new PrintWriter(stream);
		
//		System.out.println("ID= " + getId() + " \"" + getTitel()
//				+ "\" aufgenommen im Jahr " + getJahr() + " in " + getOrt());
	
		print.printf("ID= %d \"%s\" aufgenommen im jahr %d in %s%n",getId(),getTitel(),getJahr(),getOrt());
		print.flush();
	}

}
