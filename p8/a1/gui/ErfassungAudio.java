package pk1.p8.a1.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pk1.p8.a1.fachlogik.Medienverwaltung;

public class ErfassungAudio extends JFrame implements ActionListener {

	private Medienverwaltung medienverwaltung;
	private JListModel lm;

	private JLabel titelL;
	private JLabel interpretL;
	private JLabel jahrL;
	private JLabel dauerL;

	private JTextField titelT;
	private JTextField interpretT;
	private JTextField jahrT;
	private JTextField dauerT;

	private JButton neu;
	private JButton abbrechen;

	public ErfassungAudio(Medienverwaltung mv, JListModel lm) {
		this.setLocation(350,200);
		this.setSize(200, 150);
		this.setTitle("Audio-Erraßen");
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.medienverwaltung = mv;
		this.lm = lm;

		titelL = new JLabel("Titel:");
		interpretL = new JLabel("Interpret:");
		jahrL = new JLabel("Jahr:");
		dauerL = new JLabel("Dauer:");

		titelT = new JTextField();
		interpretT = new JTextField();
		jahrT = new JTextField();
		dauerT = new JTextField();

		neu = new JButton("Neu");
		abbrechen = new JButton("Abbrechen");

		neu.addActionListener(this);
		abbrechen.addActionListener(this);

		JPanel panel = new JPanel();
		// wie viele Zeile und Spalten
		panel.setLayout(new GridLayout(4, 1));
		panel.add(titelL);
		panel.add(titelT);
		panel.add(interpretL);
		panel.add(interpretT);
		panel.add(dauerL);
		panel.add(dauerT);
		panel.add(jahrL);
		panel.add(jahrT);
		this.add(panel, BorderLayout.CENTER);

		JPanel bp = new JPanel();
		bp.setLayout(new GridLayout(1, 1));
		bp.add(neu);
		bp.add(abbrechen);
		this.add(bp, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public JTextField getTitel() {
		return titelT;
	}

	public JTextField getInterpret() {
		return interpretT;
	}

	public JTextField getDauer() {
		return dauerT;
	}

	public JTextField getJahr() {
		return jahrT;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == neu) {
			if (!getJahr().getText().isEmpty()
					&& !getDauer().getText().isEmpty()
					&& !getInterpret().getText().isEmpty()
					&& !getTitel().getText().isEmpty()) {

				medienverwaltung.audioAufnehmen(getTitel().getText(),
						getInterpret().getText(),Integer.parseInt( getDauer().getText()),
						Integer.parseInt(getJahr().getText()));
				
				lm.addElement(medienverwaltung.getListe().get(medienverwaltung.getListe().size()-1));
				
				this.getTitel().setText(null);
				this.getInterpret().setText(null);
				this.getDauer().setText(null);
				this.getJahr().setText(null);
			}else{
				new FeldFehler("Füllen Sie Bitte die leere Felder !!!","Fehler");
			}
		}
		if(event.getSource() == abbrechen){
			this.dispose();
		}
	}
}
