
package pk1.p8.a1.datenhaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import pk1.p8.a1.fachlogik.Medienverwaltung;
import pk1.p8.a1.fachlogik.Medium;

public class SerialisierungDAO implements IMvDAO {

	public SerialisierungDAO() {

	}

	public void speichern(List<Medium> liste, File file)
			throws PersistenzException {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(liste);
		} catch (IOException e) {
			throw new PersistenzException("Fehler bei der Serialisierung");
//			System.out.println("Fehler bei der Serialisierung");
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Medium> laden(File file) throws PersistenzException {
		
		List<Medium> result = null;
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			result = (List<Medium>) ois.readObject();
			
		} catch (IOException e) {
			throw new PersistenzException("Fehler");
//			System.out.println("Fehler bei der Deserialisierung");
		} catch (ClassNotFoundException e) {
			// TODO !
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
