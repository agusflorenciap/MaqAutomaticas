import java.util.Scanner;

public class MaqCambio {
	
	private Monedero monedero;
	private LectorDinero lectorDinero;
	private Display display;
	
	public MaqCambio ()
	{
		monedero = new Monedero ();
		lectorDinero = new LectorDinero();
		display = new Display();
	}
	
	public void darCambio ()
	{
		Scanner scan = new Scanner (System.in);
		int max=1000; //máximo valor de dinero que acepta la máquina
		int min=50;   //mínimo  "     "   "     "    "     "    " 
		int val, op;

		do
		{
			display.bienvenidaMaqC(min,max);
			val=scan.nextInt();
			
		}while ((val!=0) && ((val<min) || (val>max)));
		
		if (val!=0)
		{
			Dinero d;
			d = lectorDinero.verificar(val);
			
			if (d==null)
			{
				display.error();
				display.devolver();
			}
			else
			{
				monedero.almacenar(d);
				monedero.darCambio(val);
				display.devolver();
			}
		}
			
	}
	
	public void recargarMon (int val, int cant)
	{
		Dinero d = lectorDinero.verificar(val);
		
		if (d==null)
			System.out.println("ERROR: valor de dinero no válido");
		else
			monedero.agregarDinPropio(d,cant);
	}
	
	public void retirar()
	{
		monedero.retirarDineroRecaudado();
	}
	
	public void agregarDin (int val, String desc)
	{
		Dinero d = lectorDinero.verificar(val);
		
		if (d==null)
		{
			d = new Dinero (val,desc);
			lectorDinero.agValidos(d);
		}
		else
			System.out.println("ERROR: dinero ya registrado");
	}
	
	public void eliminarDin (int val)
	{
		Dinero d = lectorDinero.verificar(val);
		
		if (d==null)
			System.out.println("ERROR: dinero no existente");
		else
			lectorDinero.elimValidos(d);
	}
	
	public void listarV ()
	{
		lectorDinero.listar();
		
	}
	
	public void listarM ()
	{
		monedero.listar();
		
	}
	
	public void cargaDineroValidoYMonedero()
	{
		Dinero a = new Dinero (10,"Billete");
		lectorDinero.agValidos(a);
		monedero.agregarDinPropio(a,30); 
	
		Dinero b = new Dinero (50,"Billete");
		lectorDinero.agValidos(b);
		monedero.agregarDinPropio(b,30);
		
		Dinero c = new Dinero (100,"Billete");
		lectorDinero.agValidos(c);
		monedero.agregarDinPropio(c,30);
		
		Dinero d = new Dinero (200,"Billete");
		lectorDinero.agValidos(d);
		monedero.agregarDinPropio(d,30);
		
		Dinero e = new Dinero (500,"Billete");
		lectorDinero.agValidos(e);
		monedero.agregarDinPropio(e,30);
		
		Dinero f = new Dinero (1000,"Billete");
		lectorDinero.agValidos(f);
	}
	

}
