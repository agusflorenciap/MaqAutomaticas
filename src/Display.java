
public class Display {
	
	public void bienvenidaMaqG (int max) {
		System.out.println("BIENVENIDO");
		System.out.println("Ingrese el dinero. Máximo: $ "+max+" (0 para fin de ingreso)");
	}
	
	public void bienvenidaMaqC (int min, int max) {
		System.out.println("BIENVENIDO");
		System.out.println("Ingrese el billete. Mínimo: $ "+min+". Máximo: $ "+max+" (0 para fin de ingreso)");
	}
	
	public void mostrarSaldo (int din)
	{
		System.out.println("SALDO: $"+din);
		System.out.println();
	}
	
	public void error () {
		
		System.out.println("ERROR: dinero ingresado no válido");
		System.out.println();
	}
	
	public void mensaje1 ()
	{
		System.out.println("SELECCIONE EL NRO DE LA GASEOSA DESEADA");
		System.out.println();
		
	}
	
	public void error2 ()
	{
		System.out.println("ERROR: ubicación inválida");
		System.out.println();
	}
	
	public void exito ()
	{
		System.out.println("COMPRA EXITOSA. RETIRE EL PRODUCTO EN LA BANDEJA DE SALIDA");
		System.out.println();
	}

	public void devolver ()
	{
		System.out.println("RETIRE SU DINERO POR LA CORRESPONDIENTE RANURA");
		System.out.println();
	}
	
	public void gracias ()
	{
		System.out.println("GRACIAS POR SU COMPRA. HASTA LUEGO");
		System.out.println();
	}
	
	public void errorSaldo ()
	{
		System.out.println("ERROR: saldo insuficiente para realizar la compra");
		System.out.println();
	}
	
	public void errorPre ()
	{
		System.out.println("ERROR: los precios no están cargados. Ingrese como administrador para solucionar este problema");
		System.out.println();
	}
	
	public void errorStock ()
	{
		System.out.println("ERROR: stock insuficiente. Perdone las molestias");
		System.out.println();
	}
	
	public void errorMax ()
	{
		System.out.println("ERROR: monto máximo sobrepasado");
		System.out.println();
	}
	
	public void errorMin ()
	{
		System.out.println("ERROR: monto mínimo no alcanzado");
	}
	
	
	
	
	
}

