package pk1.p8.a1.fachlogik;

import pk1.p8.a1.datenhaltung.IMvDAO;
import pk1.p8.a1.datenhaltung.SerialisierungDAO;
import pk1.p8.a1.gui.HauptF;

public class MMain {
	public static void main(String[] args){
		
		Medienverwaltung v = new Medienverwaltung();
	

		
		HauptF fenster = new HauptF(v);
	}
}
