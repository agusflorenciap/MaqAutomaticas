import java.util.*;

public class LectorDinero {
	
	private ArrayList <Dinero> dineroV;
	
	public LectorDinero ()
	{
		dineroV = new ArrayList <Dinero>();
	}
	
	public Dinero verificar (int val)
	{
		int i=0;
		
		while (i<dineroV.size() && !(dineroV.get(i).sos(val)))
			i++;
		
		if (i==dineroV.size())
			return (null);
		else
			return (dineroV.get(i));
	}
	
	
	public void agValidos (Dinero d)
	{
		dineroV.add(d);
	}
	
	public void elimValidos (Dinero d)
	{
		dineroV.remove(d);
	}
	
	public void listar ()
	{
		for (Dinero d : dineroV)
			d.info();
	}
	
}
