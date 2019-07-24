package pk1.p7.a1;

public class BottlingPlant implements Runnable {

	private Conveyor conveyor;
	private int delay;

	public BottlingPlant(Conveyor conveyor, int i) {

		this.conveyor = conveyor;
		this.delay = i;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (conveyor) {
				while (conveyor.isOverloaded()) {
					try {
						System.out.println("Förderband ist voll");
						conveyor.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				conveyor.load(new Bottle());
				System.out.println("Abfüllanlage: Neue Flasche abgefüll%n");
				conveyor.notifyAll();
			}
			
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
