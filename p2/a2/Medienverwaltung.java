package pk1.p2.a2;

public class Medienverwaltung {

	private Medium[] me;
	private int zaehler = 0;

	public Medienverwaltung(int n) {
		me = new Medium[n];
	}

	public void aufnehmen(Medium m) {
		if (me[me.length - 1] != null) {

			System.out.println("Das Medium wird nicht aufgenommen");

		} else {
			me[zaehler++] = m;
//			zaehler++;
		}
	}

	public void zeigeMedien() {
		for (int i = 0; i < zaehler; i++)
			me[i].druckeDaten();
	}

	public void sucheNeuesMedium() {
		if (me[0] == null) {
			System.out.println("Es gibt keine gespeicherte Medien");
		} else {
			int e = 0;
			for (int i = 1; i < zaehler; i++) {
				if (me[e].getJahr() <= me[i].getJahr()) {
					e = i;
				}
			}
			System.out.print("Das aktuellste ist: ");
			me[e].druckeDaten();
		}
	}

	public double berechneErscheinungsjahr() {
	 double er = 0.0;
		
		if (me[0] == null) {
			return er;
		} else {
			for (int i = 0; i <zaehler; i++) {
					er += me[i].getJahr();
			}

		}
		return (er / zaehler);
	}

}
