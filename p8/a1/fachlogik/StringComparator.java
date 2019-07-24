package pk1.p8.a1.fachlogik;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

	//wenn s1 länger als s2 dann return 1 
	//wenn s2 länger als s1 dann return -1
	//sonst return 0
	public int compare(final String s1, final String s2) {
		if (s1.length() > s2.length()) {
			return 1;
		} else if (s1.length() < s2.length()) {
			return -1;
		}
		return 0;
	}
}
