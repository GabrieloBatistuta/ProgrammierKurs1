package pk1.p3.a2;

public class Test {

	public static void main(String[] args)
	{
		Medienverwaltung m=new Medienverwaltung();
		
		Audio a1=new Audio("Give me Love", 2002, "Lokas", 7783);
		Bild a2=new Bild("Die welt", 2004, "Essen");
		Audio a3=new Audio("The End", 2003, "jostos", 9932);
		Bild a4=new Bild("Computerbild", 2005, "Berlin");
		
		
		m.aufnehmen(a1);
		m.aufnehmen(a2);
		m.aufnehmen(a3);
		m.aufnehmen(a4);
		
		m.zeigeMedien();
		System.out.println();
		m.sucheNeuesMedium();
		
		System.out.println();
		System.out.println("Durchschnitt: "+m.berechneErscheinungsjahr());
		
	}
}
