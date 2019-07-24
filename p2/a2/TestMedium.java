package pk1.p2.a2;

public class TestMedium {

	public static void main(String[] args)
	{
	
	Medienverwaltung m=new Medienverwaltung(4);
	
	Audio a=new Audio("The real love",3,"Lokas",234);
	Bild b=new Bild("Liebe",3,"Dortmund");
	Audio c=new Audio("Ther is your love",3,"Marko",990);
	Bild d=new Bild("Berge",20,"Hagen");
	Audio e=new Audio("Give me Love",3,"Michal",6998);
	
	m.aufnehmen(a);
	m.aufnehmen(b);
	m.aufnehmen(c);
	m.aufnehmen(d);
	m.aufnehmen(e);
	System.out.println();
	
	m.zeigeMedien();
	System.out.println("''''''''''''''''''");
	m.sucheNeuesMedium();
	System.out.println("##############");
	System.out.println(m.berechneErscheinungsjahr());
	
	
	
	
  }
}