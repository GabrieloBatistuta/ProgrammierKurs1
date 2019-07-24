package pk1.p8.a1.datenhaltung;

import java.io.File;
import java.util.List;

import pk1.p8.a1.fachlogik.Medium;

public interface IMvDAO {

	 void speichern(List<Medium> liste, File f)
			throws PersistenzException;

	 List<Medium> laden(File f) throws PersistenzException;
}
