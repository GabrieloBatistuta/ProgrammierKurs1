package pk1.p8.a1.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pk1.p8.a1.fachlogik.Audio;
import pk1.p8.a1.fachlogik.Medium;

public class AudioTableModel extends AbstractTableModel {

	private static final String[] COLHEADING = { "Id", "Titel", "Interpret",
			"Aufnahmejahr", "Spieldauer" };
	private final List<Audio> audio;

	public AudioTableModel(final List<Audio> liste) {
		this.audio = liste;
	}

	// Returns the number of columns in the model.
	public int getColumnCount() {
		return COLHEADING.length;
	}

	// Returns the number of rows in the model.
	public int getRowCount() {
		return audio.size();
	}

	public String getColumenName(final int index) {
		return COLHEADING[index];
	}

	// Returns the value for the cell at columnIndex and rowIndex
	public Object getValueAt(final int row, final int col) {
		Audio a = audio.get(row);

		if (col == 0) {
			return a.getId();
		} else if (col == 1) {
			return a.getTitel();
		} else if (col == 2) {
			return a.getInterpert();
		} else if (col == 3) {
			return a.getJahr();
		} else if (col == 4) {
			return a.getDauer();
		}
		throw new IllegalArgumentException("ungültiger Index col = " + col);
	}
}
