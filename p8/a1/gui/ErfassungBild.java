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

public class ErfassungBild extends JFrame implements ActionListener {

	public Medienverwaltung medienverwaltung;
	private JListModel lm;

	private JLabel titelL;
	private JLabel ortL;
	private JLabel jahrL;

	private JTextField titelT;
	private JTextField ortT;
	private JTextField jahrT;

	private JButton neu;
	private JButton abbrechen;

	public ErfassungBild(Medienverwaltung m, JListModel l) {
		this.setLocation(350, 200);
		this.setSize(200, 150);
		this.setTitle("Bild-Erfaßen");
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		this.medienverwaltung = m;
		this.lm = l;

		titelL = new JLabel("Titel: ");
		ortL = new JLabel("Ort: ");
		jahrL = new JLabel("Jahr: ");

		titelT = new JTextField();
		ortT = new JTextField();
		jahrT = new JTextField();

		neu = new JButton("OK");
		abbrechen = new JButton("Abbrechen");

		neu.addActionListener(this);
		abbrechen.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(titelL);
		panel.add(titelT);
		panel.add(ortL);
		panel.add(ortT);
		panel.add(jahrL);
		panel.add(jahrT);
		this.add(panel, BorderLayout.CENTER);

		JPanel buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(1, 1));
		buttonP.add(neu);
		buttonP.add(abbrechen);
		this.add(buttonP, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public JTextField getTitel() {
		return titelT;
	}

	public JTextField getOrt() {
		return ortT;
	}

	public JTextField getJahr() {
		return jahrT;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == neu) {
			if (!this.getTitel().getText().isEmpty()
					&& !this.getOrt().getText().isEmpty()
					&& !this.getJahr().getText().isEmpty()) {
				
				medienverwaltung.bildAufnehmen(getTitel().getText(), Integer
						.parseInt(getJahr().getText()), getOrt().getText());

				lm.addElement(medienverwaltung.getListe().get(
						medienverwaltung.getListe().size()-1));

				this.getTitel().setText(null);
				this.getOrt().setText(null);
				this.getJahr().setText(null);

			} else {
				new FeldFehler("Füllen Sie Bitte die leere Felder !!!",
						"Fehler");
			}
		}
		if(event.getSource() == abbrechen){
			this.dispose();
		}
	}

}
