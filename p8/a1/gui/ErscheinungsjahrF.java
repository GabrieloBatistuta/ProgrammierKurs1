package pk1.p8.a1.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pk1.p8.a1.fachlogik.Medienverwaltung;

public class ErscheinungsjahrF extends JFrame implements ActionListener {

	private Medienverwaltung medienverwaltung;
	private JLabel label;
	private JButton button;

	public ErscheinungsjahrF(Medienverwaltung m) {
		this.setSize(200, 200);
		this.setLocationRelativeTo(null);
		this.setTitle("Erscheinungsjahr");
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.medienverwaltung = m;

		label = new JLabel("Erscheinungsjahr ist: "+ medienverwaltung.berechneErscheinungsjahr());

		button=new JButton("OK");
		button.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				ErscheinungsjahrF.this.dispose();
				
			}
		});
		
		this.add(label, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
		
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		this.dispose();

	}

}
