package pk1.p8.a1.gui;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import pk1.p8.a1.fachlogik.Medium;

public class JListModel extends AbstractListModel {

	private ArrayList<Medium> liste;

	public JListModel() {
		liste = new ArrayList<Medium>();
	}

	public Medium getElementAt(int i) {

		return liste.get(i);
	}

	public int getSize() {

		return liste.size();
	}
	public Object getIndex(Medium m){
		return liste.indexOf(m);
	}
	public void setElement(Medium m,int i){
		liste.set(i, m);
		update(0,this.getSize());
	}
	public void addElement(Medium m){
		liste.add(m);
		update(this.getSize()-1,this.getSize());
	}
	public void setListe(ArrayList<Medium> liste){
		this.liste=liste;
	}
	public void loeschenElement(int i){
		liste.remove(i);
		update(0,this.getSize());
	}
	// update
	public void update(int von,int bis){
		fireIntervalAdded(this,von,bis);
	}
	public void loescheAlle(){
		liste.remove(liste);
	}
}
