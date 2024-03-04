import java.util.*;

public class MaqGaseosas {
	
	private Monedero monedero;
	private LectorDinero lectorDinero;
	private ArrayList <Gaseosa> gaseosas;
	private Display display;
	
	public MaqGaseosas ()
	{
		monedero = new Monedero ();
		lectorDinero = new LectorDinero ();
		gaseosas = new ArrayList <Gaseosa> ();
		display = new Display ();
	}
	

	
	public Gaseosa buscarG (int op)
	{
		int i=0;
		
		while (i<gaseosas.size() && !(gaseosas.get(i).sos(op)))
			i++;
		
		if (i==gaseosas.size())
			return (null);
		else
			return (gaseosas.get(i));
	}
	
	public void comprar ()
	{
		
		Scanner scan = new Scanner (System.in);
		int max=50; //máxima suma de dinero que acepta la máquina
		int sum=0, val, op;
		Dinero d;
		display.bienvenidaMaqG(max);
		do
		{
			val=scan.nextInt();
			if (val!=0)
			{
				d = lectorDinero.verificar(val);
				if (d!=null)
					{
						if ((sum+val)<=max)
						{
							monedero.almacenar(d);
							sum=sum+val;
							display.mostrarSaldo(sum);
						}
						else
							display.errorMax();
						
					}
					else
						display.error();
			}
			
		}while ((val!=0) && (sum<max)); //se ingresará dinero mientras no sea 0 lo ingresado y la suma sea menor al máximo

		int pre = Gaseosa.damePreU();
		
		if (sum!=0)
		{
			if (pre!=0)
			{
				if (sum>=pre)
				{
					this.listarG();
					display.mensaje1();
					op=scan.nextInt();
					Gaseosa g = this.buscarG(op);
					
					if (g==null)
					{
						display.error2();
						monedero.devolverDinIngresado(sum);
						display.devolver();
					}
					else
					{
						if (g.verificarStock())
						{
							display.exito();
							g.descontarStock();
							int monto=sum-pre;
							display.mostrarSaldo(monto);
							if (monto!=0)
							{
								monedero.darCambio(monto);
								display.devolver();
							}
							display.gracias();
							
						}
						else
						{
							display.errorStock();
							monedero.devolverDinIngresado(sum);
							display.devolver();
						}
						
					}
					
				}
				else
				{
					display.errorSaldo();
					monedero.devolverDinIngresado(sum);
					display.devolver();
				}
					
			}
			else
			{
				display.errorPre();
				monedero.devolverDinIngresado(sum);
				display.devolver();
			}
			
		}
	}
	
	public void agregarG (Gaseosa g)
	{
		gaseosas.add(g);
		
	}
	
	public void eliminarG (Gaseosa g)
	{
		gaseosas.remove(g);
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
	
	
	public void recargarMon (int val, int cant)
	{
		Dinero d = lectorDinero.verificar(val);
		
		if (d==null)
			System.out.println("ERROR: valor de dinero no válido");
		else
			monedero.agregarDinPropio(d,cant);
	}
	
	
	public void cargaGaseosas()
	{
		
		Gaseosa a = new Gaseosa (1,"Coca-Cola",20);
		gaseosas.add(a);
		Gaseosa b = new Gaseosa (2,"Sprite",20);
		gaseosas.add(b);
		Gaseosa c = new Gaseosa (3,"Pepsi",20);
		gaseosas.add(c);
		Gaseosa d = new Gaseosa (4,"Fanta",20);
		gaseosas.add(d);
		Gaseosa e = new Gaseosa (5,"Agua sin gas",20);
		gaseosas.add(e);
		Gaseosa f = new Gaseosa (6,"Paso de los toros",20);
		gaseosas.add(f);
	}
	
	public void cargaDineroValidoYMonedero()
	{
		Dinero a = new Dinero (1,"Moneda");
		lectorDinero.agValidos(a);
		monedero.agregarDinPropio(a,30);
		
		Dinero b = new Dinero (2,"Moneda");
		lectorDinero.agValidos(b);
		monedero.agregarDinPropio(b,30);
		
		Dinero c = new Dinero (5,"Billete");
		lectorDinero.agValidos(c);
		monedero.agregarDinPropio(c,30);
		
		Dinero d = new Dinero (10,"Billete");
		lectorDinero.agValidos(d);
		monedero.agregarDinPropio(d,30);
		
		Dinero e = new Dinero (20,"Billete");
		lectorDinero.agValidos(e);
		monedero.agregarDinPropio(e,30);
		
		Dinero f = new Dinero (50,"Billete");
		lectorDinero.agValidos(f);
	}	
	
	public void listarG ()
	{
		System.out.println("PRECIO GENERAL: $ "+Gaseosa.getPre());
		for (Gaseosa g:gaseosas)
			g.info();
	}
	
	public void listarV ()
	{
		lectorDinero.listar();
		
	}
	
	public void listarM ()
	{
		monedero.listar();
		
	}
	
	
	public void retirar()
	{
		monedero.retirarDineroRecaudado();
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
