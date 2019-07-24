package pk1.p6.a1;


import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Medium implements Comparable<Medium>,Serializable{

	private final int id;
	public static int KONSTANTE=0;
	private String titel;
	private int jahr;
	
	public Medium(String titel,int jahr)
	{
		this.id=KONSTANTE;
		this.titel=titel;
		this.jahr=jahr;
		KONSTANTE++;
	}
	public String getTitel()
	{
		return titel;
	}
	public int getJahr()
	{
		return jahr;
	}
	public int alter()
	{    
	     Calendar c = new GregorianCalendar();
	  	int aktJahr =  c.get(Calendar.YEAR);
	  		return aktJahr -jahr;
	}
	
	public int getId()
	{
		return id;
	}
	public abstract void druckedaten(OutputStream stream);
	
	// das ist wenn es aufsteigend sortiert wird 
	// bei absteigend muss man > umkehren also < und < auch mukehren also >
	public int compareTo(Medium o) {
		if(this.getJahr()>o.getJahr())
			return 1;
		if(this.getJahr()<o.getJahr())
			return -1;
		else
		return 0;
	}
}

