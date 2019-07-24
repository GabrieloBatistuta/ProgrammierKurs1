package pk1.p3.a3;

public class Audio extends Medium {

	private String interpret;
	private int dauer;
	
	public Audio(String titel,int jahr,String interpret,int dauer)
	{
		super(titel,jahr);
		this.dauer=dauer;
		this.interpret=interpret;
	}
	public String getInterpert()
	{
		return interpret;
	}
	public int getDauer()
	{
		return dauer;
	}
	public void druckeDaten()
	{
		
		System.out.println("ID= "+getId()+" \""+getTitel()+"\" von "
		+getInterpert()+" aus "+getJahr()+" Spieldauer: "+getDauer()+" sek.");
	}
	
	
}
