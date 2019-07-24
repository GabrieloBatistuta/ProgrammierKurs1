package pk1.p6.a2;

import javax.swing.JOptionPane;

public class Zeitansage implements TimerListener {
	private int i;

	public Zeitansage() {
		i = 0;
	}

	public void signalPerfored() {
		System.out.println(i++ +" Sekunde seit start");
	}

	public void start() {
		Thread a = new Thread(new Timer(this, 1000));
		a.start();
		JOptionPane.showMessageDialog(null, "Zum Stopen OK drucken");
		a.interrupt();
	}

}
