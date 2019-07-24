package pk1.p1.a2;

public class Test {

	public static void main(String[] args)
	{
		Audio a=new Audio("It Means Nothing",2007,"Stereophnics",229);
		a.druckeDaten();
		Bild b=new Bild("Gebaeude FB Informatik",2014,"Dortmund");
		b.druckeDaten();
		
		
		System.out.println();
		System.out.println("\""+a.getTitel()+"\""+" ist "+a.getMedienalter()+" Jahre alt");
	    
	}
}
