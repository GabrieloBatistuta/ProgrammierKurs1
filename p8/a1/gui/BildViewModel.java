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
import pk1.p8.a1.fachlogik.StringComparator;

public class BildViewModel extends JFrame implements ActionListener {

	private JButton ok;
	private JTable table;

	public BildViewModel(BildTableModel bild) {
		this.setLocation(450, 150);
		this.setSize(200, 200);
		this.setTitle("Bild-Tabelle");
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel(new BorderLayout());
		table = new JTable(bild);
		table.setAutoCreateRowSorter(true);

		TableRowSorter<TableModel> sortieren;
		sortieren = new TableRowSorter<TableModel>(table.getModel());
		sortieren.setComparator(0, new IntegerComparator());
		sortieren.setComparator(1,new StringComparator());
		sortieren.setComparator(2,new StringComparator());
		sortieren.setComparator(3, new IntegerComparator());
		table.setRowSorter(sortieren);
		
		ok=new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
	
			public void actionPerformed(ActionEvent arg0) {
				BildViewModel.this.dispose();
				
			}
		});
		
		panel.add(new JScrollPane(table));
		this.add(ok , BorderLayout.SOUTH);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == ok){
			this.dispose();
		}
	}

}
