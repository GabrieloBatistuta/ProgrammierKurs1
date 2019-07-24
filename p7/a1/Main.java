package pk1.p7.a1;

public class Main {

	public static void main(String[] args)
	{
		Conveyor c=new Conveyor();
		
		Thread a=new Thread(new BottlingPlant(c, 50));
		Thread b=new Thread(new LabelingMachine(c, 100));
		
		a.start();
		b.start();
	}
}
