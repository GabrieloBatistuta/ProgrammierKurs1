package pk1.p8.a1.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pk1.p8.a1.fachlogik.Medienverwaltung;

public class NeusteMediumF extends JFrame implements ActionListener{

	private Medienverwaltung medienverwaltung;
	private JLabel label;
	private JButton button;
	
	public NeusteMediumF(Medienverwaltung m){
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		this.setTitle("Neues Medium");
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		this.medienverwaltung=m;
		
		label = new JLabel(medienverwaltung.sucheNeuesMedium().toString());
		
		button=new JButton("OK");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				NeusteMediumF.this.dispose();
				
			}
		});
		add(label,BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		this.dispose();
		
	}
}
