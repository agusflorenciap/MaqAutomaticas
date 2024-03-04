import java.util.*;

public class Gaseosa {
	
	private int codUbicacion;
	private String nomb;
	private static int preU;
	private int stock;
	
	public Gaseosa (int c, String n, int s) {
		codUbicacion = c;
		nomb = n;
		stock = s;
	}
	
	public boolean sos (int op)
	{
		return  (op==codUbicacion);
	}
	
	public static int damePreU ()
	{
		return (preU);
	}
	
	public int dameStock ()
	{
		return (stock);
	}
	public static void setPre()
	{
		Scanner scan = new Scanner (System.in);
		System.out.println("Ingrese el precio unitario para las gaseosas");
		preU=scan.nextInt();		
	}
	
	
	public static int getPre ()
	{
		if (preU==0)
			Gaseosa.setPre();
		
		return (preU);
	}

	public boolean verificarStock ()
	{
		return ((stock-1)>=0);
		
	}
	public void descontarStock ()
	{
		stock=stock-1;
	}
	
	public void actualizarStock (int sto)
	{
		stock=stock+sto;
	}
	
	public void info ()
	{
		System.out.println("COD UBICACIÓN: "+codUbicacion+" NOMBRE: "+nomb+" STOCK: "+stock);
	}
	

}
