import java.util.*;
public class Monedero {
	
	private Hashtable <Dinero,Integer> dineroPropio;
	private Hashtable <Dinero,Integer> dineroRecibido;


	public Monedero ()
	{
		dineroPropio = new Hashtable <Dinero,Integer> ();
		dineroRecibido = new Hashtable <Dinero,Integer> ();
	}
	
	public void almacenar (Dinero d)
	{
		int cant=1;
		
		if (dineroRecibido.containsKey(d))
			cant=cant+dineroRecibido.get(d);
		
		dineroRecibido.put(d, cant);
	}
	
	public void devolverDinIngresado (int sum)
	{
		Enumeration <Dinero> ed = dineroRecibido.keys();
		Dinero d;
		int cantBillete;
		
		while ((ed.hasMoreElements() && (sum!=0)))
		{
			d= ed.nextElement();
			cantBillete = sum/d.dameVal();
			
			if ((cantBillete) <= (dineroRecibido.get(d))) //debe haber cantidad de billetes suficiente
					{
						if (cantBillete!=0)
						{
							sum=sum-(d.dameVal()*cantBillete);
							System.out.println("VALOR MONEDA/BILLETE DEVUELTO: $ "+d.dameVal()+" CANTIDAD: "+cantBillete);
							cantBillete=dineroRecibido.get(d)-cantBillete; //actualizo cantidad de billetes de la hash
							dineroRecibido.put(d, cantBillete);
						}
					}
		}

	}
	
	
	public void darCambio (int monto)
	{

			Enumeration <Dinero> ed = dineroPropio.keys();
			Dinero d;
			int cantBillete;
			
			
			while ((ed.hasMoreElements() && (monto!=0)))
			{
				d = ed.nextElement();
				
				cantBillete = monto/d.dameVal();
				
				if ((cantBillete) <= (dineroPropio.get(d))) //debe haber cantidad de billetes suficiente
				{
					
						if (cantBillete>0 && (d.dameVal()<monto)) //la segunda condición es para que no devuelva con el mismo billete (caso de la máquina de cambio)
						{
							
								monto=monto-(d.dameVal()*cantBillete);
								System.out.println("VALOR MONEDA/BILLETE DEVUELTO: $ "+d.dameVal()+" CANTIDAD: "+cantBillete);
								cantBillete=dineroPropio.get(d)-cantBillete; 
								dineroPropio.put(d, cantBillete);
						
						}	
				
				}
				

			}
			if (monto!=0)
				System.out.println("ERROR: billetes insuficientes para devolver");		
	}
	
	
	public void agregarDinPropio (Dinero d, int cant)
	{
		if (dineroPropio.containsKey(d))
			cant=cant+dineroPropio.get(d);
		
		dineroPropio.put(d, cant);
	}
	
	public void listar ()
	{
		Enumeration <Dinero> ed = dineroPropio.keys();
		Dinero d;
		
		System.out.println("LISTADO DINERO PROPIO");
		while (ed.hasMoreElements())
		{
			d = ed.nextElement();
			if (dineroPropio.get(d)!=0)
			{
				d.info();
				System.out.println("CANTIDAD DISPONIBLE: "+dineroPropio.get(d));
			}
			
		}
		
		System.out.println();
		
		Enumeration <Dinero> ed2 = dineroRecibido.keys();
		System.out.println("LISTADO DINERO RECIBIDO (RECAUDADO)");
		while (ed2.hasMoreElements())
		{
			d= ed2.nextElement();
			if (dineroRecibido.get(d)!=0)
			{
				d.info();
				System.out.println("CANTIDAD DISPONIBLE: "+dineroRecibido.get(d));
			}
		}
	}
	
	
	public void retirarDineroRecaudado ()
	{	
		int sum=0;
		Enumeration <Dinero> ed = dineroRecibido.keys();
		Dinero d;
		
		while (ed.hasMoreElements())
		{
			d = ed.nextElement();
			sum=sum+d.dameVal()*dineroRecibido.get(d);
			dineroRecibido.remove(d);
		}
		
		System.out.println("MONTO RETIRADO: $ "+sum);
	}
	
}
