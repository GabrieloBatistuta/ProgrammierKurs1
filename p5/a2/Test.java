package pk1.p5.a2;

public class Test {

	public static void main(String[] args)
	{
		Medienverwaltung medien=new Medienverwaltung();
		
		Menu menu=new Menu(medien);
		
		menu.zeigeMenu();
	}

}
