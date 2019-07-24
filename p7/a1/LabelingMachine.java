package pk1.p7.a1;

import java.util.GregorianCalendar;

public class LabelingMachine implements Runnable{

	private Conveyor conveyor;
	private int delay;
	
	public LabelingMachine(Conveyor conveyor,int i)
	{
		this.conveyor=conveyor;
		this.delay=i;
	}
	public void run()
	{
		Bottle b;
		while(!Thread.currentThread().isInterrupted())
		{
			synchronized(conveyor){
				while (conveyor.isEmpty()) {
					try {
						conveyor.wait();
						System.out.println("Etikettiermaschine: Warten, da Foerderband leer.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				b = conveyor.withdraw();
				conveyor.notifyAll();
				
				
			}
			b.setLable(new Lable("Bier", GregorianCalendar.getInstance().get(GregorianCalendar.YEAR)+1));
			b.printLable();
			
		}	
			try {
				Thread.sleep(delay);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		
	}
}
