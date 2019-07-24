package pk1.p7.a1;

import java.util.ArrayList;

public class Conveyor {

	private ArrayList<Bottle> liste;

	public Conveyor() {
		liste = new ArrayList<Bottle>();
	}

	public void load(Bottle b) {
		if (isOverloaded() == false) {
			liste.add(b);

		}
	}

	public Bottle withdraw() {
		return liste.remove(0);

	}

	public boolean isOverloaded() {
		return (liste.size() >= 50);
	}

	public boolean isEmpty() {
		return liste.isEmpty();
	}
}
