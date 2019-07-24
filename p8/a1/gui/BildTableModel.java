package pk1.p8.a1.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pk1.p8.a1.fachlogik.Audio;
import pk1.p8.a1.fachlogik.Bild;

public class BildTableModel extends AbstractTableModel {

	private static final String[] COLHEADING = { "Id", "Titel", "Ort",
			"Aufnahmejahr" };
	private final List<Bild> bild;

	public BildTableModel(final List<Bild> liste) {
		this.bild = liste;
	}

	public int getColumnCount() {
		return COLHEADING.length;
	}

	public int getRowCount() {

		return bild.size();
	}

	public String getColumenName(final int index) {
		return COLHEADING[index];
	}

	public Object getValueAt(final int row, final int col) {
		Bild b = bild.get(row);

		if (col == 0) {
			return b.getId();
		} else if (col == 1) {
			return b.getTitel();
		} else if (col == 2) {
			return b.getOrt();
		} else if (col == 3) {
			return b.getJahr();
		}
		throw new IllegalArgumentException("ungültiger Index col = " + col);
	}
}
