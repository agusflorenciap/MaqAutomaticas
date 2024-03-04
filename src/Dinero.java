
public class Dinero {
	
private int valor;
private String desc;

	public Dinero (int v, String d)
	{
		valor = v;
		desc = d;
	}
	
	public boolean sos (int val)
	{
		return (val==valor);
	}
	
	public int dameVal ()
	{
		return (valor);
	}
	
	
	public void info ()
	{
		System.out.println("DESCRIPCIÓN: "+desc+" VALOR: "+valor);
	}


}