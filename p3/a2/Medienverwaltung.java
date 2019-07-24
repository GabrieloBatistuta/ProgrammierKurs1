package pk1.p3.a2;

import java.util.*;



public class Medienverwaltung {

	private Collection<Medium> liste;

	public Medienverwaltung() 
	{
		liste = new ArrayList<Medium>();
	}

	public void aufnehmen(Medium m) 
	{
		liste.add(m);
	}

	public void zeigeMedien() 
	{

		if (liste.isEmpty())
			System.out.println("Die Liste ist leer");
		else {
			Iterator<Medium> it = liste.iterator();
			while (it.hasNext()) {
			 	it.next().druckeDaten();
			}
		}
	}

	public void sucheNeuesMedium() {
		if (liste.isEmpty()) 
		{
			System.out.println("Es gibt keine gespeicherte Medien");
		} else {

			Iterator<Medium> it = liste.iterator();

			Medium neu =  it.next();

			while (it.hasNext()) {
				Medium temp =  it.next();

				if ((neu.getMedienalter() > (temp).getMedienalter())) {
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

		for (Medium me : liste) {
			d +=  me.getJahr();

		}
		return (d / liste.size());

	}
}
