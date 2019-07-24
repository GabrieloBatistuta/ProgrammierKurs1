package pk1.p8.a1.fachlogik;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

	// null wenn return 0
	// eins wenn e1 großer als e2
	//minus eins wenn e1 kleiner als e2
	
	public int compare(final Integer e1, final Integer e2) {
		return (int) Math.signum(e1 - e2);
	}
}
