package pk1.p3.a1;


public class Test {

	public static void main(String[] args)
	{
	Medienverwaltung m = new Medienverwaltung();
	
	Medium a = new Audio("Give me Love", 1999, "Michale pilo", 698);
	
	Bild b =new Bild("The Sun", 1998,"NY");
	
    m.aufnehmen(a);
    m.aufnehmen(b);
    
    
    m.zeigeMedien();
    System.out.println();
    m.sucheNeuesMedium();
    System.out.println();
    System.out.println(m.berechneErscheinungsjahr());
	
	
 }
}