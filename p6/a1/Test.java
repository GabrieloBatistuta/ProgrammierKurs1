package pk1.p6.a1;

public class Test {

	public static void main(String[] args)
	{
		Medienverwaltung medien=new Medienverwaltung();
		
		Menu menu=new Menu(medien);
		
		menu.zeigeMenu();
	}

}
