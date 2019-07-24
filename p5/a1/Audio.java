



package pk1.p5.a1;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Audio extends Medium {

	private String interpert;
	private int dauer;
	
	
	public Audio(String titel,int jahr,String interpert,int dauer)
	{
		super(titel,jahr);
		this.dauer=dauer;
		this.interpert=interpert;
	}
	public String getInterpert()
	{
		return interpert;
	}
	public int getDaer()
	{
		return dauer;
	}
	public void druckedaten(OutputStream stream)
	{
	
		PrintWriter print=new PrintWriter(stream);
	
		print.printf("ID= %d %s von %s aus %d Spieldauer: %d%n",getId(),getTitel(),getInterpert(),getJahr(),getDaer());
		print.flush();
	
	}
	
	
}
