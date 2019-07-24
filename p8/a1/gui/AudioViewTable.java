package pk1.p8.a1.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import pk1.p8.a1.fachlogik.IntegerComparator;
import pk1.p8.a1.fachlogik.Medienverwaltung;
import pk1.p8.a1.fachlogik.StringComparator;

public class AudioViewTable extends JFrame implements ActionListener {

	private JTable table;
	private JButton ok;

	public AudioViewTable(AudioTableModel audio) {
		this.setLocation(450, 150);
		this.setSize(200, 200);
		this.setTitle("Audio-Tabelle");
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel(new BorderLayout());
		table = new JTable(audio);
		table.setAutoCreateRowSorter(true);

		TableRowSorter<TableModel> sortieren;
		// getModel: the TableModel that provides the data displayed by this
		// JTable
		sortieren = new TableRowSorter<TableModel>(table.getModel());
		sortieren.setComparator(0, new IntegerComparator());
		sortieren.setComparator(1, new StringComparator());
		sortieren.setComparator(2, new StringComparator());
		sortieren.setComparator(3, new IntegerComparator());
		sortieren.setComparator(4, new IntegerComparator());
		table.setRowSorter(sortieren);

		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AudioViewTable.this.dispose();

			}
		});

		panel.add(new JScrollPane(table));
		this.add(ok, BorderLayout.SOUTH);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ok) {
			this.dispose();
		}
	}
}
