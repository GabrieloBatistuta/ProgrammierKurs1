package pk1.p6.a2;

public class Timer implements Runnable{

	private TimerListener t;
	
	private int delay;
	
	public Timer(TimerListener t,int delay) {
		this.t=t;
		this.delay=delay;
	}
	public void run() {
		while(!Thread.currentThread().isInterrupted())
		{
			try{
				Thread.sleep(delay);
				t.signalPerfored();
			}catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
			
		}
	}

}
