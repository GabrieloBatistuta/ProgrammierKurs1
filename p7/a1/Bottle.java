package pk1.p7.a1;

public class Bottle {

	private Lable lable;

	public Bottle() {
	}

	public void setLable(Lable l) {
		this.lable = l;
	}

	public void printLable() {
//		System.out.println(lable.getType() + lable.getBestBefore());
	System.out.printf("%s mindestens halbar bis %d%n",lable.getType(),lable.getBestBefore());
	}
}
