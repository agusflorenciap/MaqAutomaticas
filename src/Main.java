import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		MaqGaseosas maqG = new MaqGaseosas ();
		MaqCambio maqC = new MaqCambio ();
		
		
		
		
		maqG.cargaGaseosas(); 						//harcodeado para pruebas más rápidas
		maqG.cargaDineroValidoYMonedero();

		maqC.cargaDineroValidoYMonedero();
		
		int opG, opM, opS, cod, codAdmin=2301;
		int sto, codU, op, val, cant;
		String nomb, resp, desc;
		

		do{
			System.out.println("MENÚ GENERAL");
			System.out.println("SELECCIONE CON QUÉ MÁQUINA DESEA OPERAR: 1 - M. GASEOSAS, 2 - M. CAMBIO, 0 - SALIR");
			opG=scan.nextInt();
			
			switch (opG)
			{
				case 1:
				{
					do{
						System.out.println();
						System.out.println("MENÚ MÁQUINA DE GASEOSAS");
						System.out.println("SELECCIONE DE QUÉ MANERA OPERARÁ: 1 - USUARIO, 2 - ADMINISTRADOR, 0 - ATRÁS");
						opM=scan.nextInt();
						
						switch (opM)
						{
							case 1:
							{
								do
								{
									System.out.println("1 - Comprar una gaseosa");
									System.out.println("0 - Atrás");
									opS=scan.nextInt();
									switch (opS)
									{
									case 1:
										maqG.comprar();
										break;
									}
								}while (opS!=0);
							}
							 break;
							 
							case 2:
							{	
								System.out.println("Ingrese su código de Administrador");
								cod=scan.nextInt();
								if (cod==codAdmin)
								{
									do
									{
										System.out.println();
										System.out.println("1 - Agregar nueva gaseosa a la venta");
										System.out.println("2 - Eliminar una gaseosa a la venta");
										System.out.println("3 - Reponer stock de una gaseosa");
										System.out.println("4 - Recargar el monedero");
										System.out.println("5 - Retirar dinero recaudado");
										System.out.println("6 - Actualizar valores de dinero válidos");
										System.out.println("7 - Actualizar precio de las gaseosas");
										System.out.println("8 - Listado informativo de gaseosas en venta");
										System.out.println("9 - Listado de valores de dinero válidos existentes ");
										System.out.println("10 - Listado del monedero");
										System.out.println("0 - Atrás");
										opS=scan.nextInt();
										
										switch (opS)
										{
											case 1:
											{
												System.out.println("Indique el código (ubicación de la misma)");
												codU=scan.nextInt();
												System.out.println("Indique el nombre de la bebida");
												nomb = scan.next();
												System.out.println("Indique el stock");
												sto = scan.nextInt();
												
												Gaseosa g = maqG.buscarG(codU);
												if (g==null)
												{
													g = new Gaseosa (codU,nomb,sto);
													maqG.agregarG(g);
												}
												else
												{
													System.out.println("Esta gaseosa ya existe. Desea actualizar su stock? (s/n)");
													resp=scan.next();
													if (resp.equalsIgnoreCase("s"))
													{
														g.actualizarStock(sto);
														System.out.println("STOCK ACTUALIZADO, CANTIDAD ACTUAL: "+g.dameStock());
														
													}		
												}
											}
												break;
											case 2:
											{
												System.out.println("Indique el código (ubicación de la misma)");
												codU=scan.nextInt();
												Gaseosa g = maqG.buscarG(codU);
												if (g==null)
													System.out.println("ERROR: no existe la bebida indicada");
												else
												{
													maqG.eliminarG(g);
													System.out.println("BEBIDA ELIMINADA");
												}
											}
												break;
											case 3:
											{
												System.out.println("Indique el código (ubicación de la misma)");
												codU=scan.nextInt();
												Gaseosa g = maqG.buscarG(codU);
												if (g==null)
													System.out.println("ERROR: no existe la bebida indicada");
												else
												{
													System.out.println("Indique la cantidad a agregar");
													sto =scan.nextInt();
													g.actualizarStock(sto);
													System.out.println("STOCK ACTUALIZADO, CANTIDAD ACTUAL: "+g.dameStock());
												}
											}
												break;
											case 4:
											{
												System.out.println("Indique el valor del dinero que desea recargar");
												val= scan.nextInt();
												System.out.println("Ingrese la cantidad de billetes");
												cant = scan.nextInt();
												maqG.recargarMon(val, cant);
											}
												break;
											case 5:
												maqG.retirar();
												break;
											case 6:
											{
												do
												{
													System.out.println("1 - AGREGAR NUEVO DINERO VÁLIDO, 2 - ELIMINAR DINERO VÁLIDO EXISTENTE, 0 - SALIR");
													op=scan.nextInt();
													switch (op)
													{
														case 1:
														{
															System.out.println("Indique su valor");
															val =scan.nextInt();
															System.out.println("Ingrese una descripción (ej, billete/moneda)");
															desc = scan.next();
															maqG.agregarDin(val,desc);
														}
															break;
														case 2:
														{
															System.out.println("Indique su valor");
															val =scan.nextInt();
															maqG.eliminarDin(val);
														}
															break;
													}
													
												}while (op!=0);
												
											}
												break;
											case 7:
													Gaseosa.setPre();
												break;
											case 8:
												maqG.listarG();
												break;
											case 9:
												maqG.listarV();
												break;
											case 10:
												maqG.listarM();
												break;
										}
									}while (opS!=0);
								}
								else
									System.out.println("ERROR: código inválido");
								
							}
							 break;
						}
						
					}while (opM!=0);
				}
					break;
				
				case 2:
				{
					do
					{
						
					
						System.out.println("MENÚ MÁQUINA DE CAMBIO");
						System.out.println("SELECCIONE DE QUÉ MANERA OPERARÁ: 1 - USUARIO, 2 - ADMINISTRADOR, 0 - ATRÁS");
						opM=scan.nextInt();
						
						switch (opM)
						{
							case 1:
							{
								do
								{
									System.out.println("1 - Obtener cambio");
									System.out.println("0 - Atrás");
									opS=scan.nextInt();
									switch (opS)
									{
										case 1:
											maqC.darCambio();
											break;
									}
								}while (opS!=0);
							}
							break;
							case 2:
							{	
								System.out.println("Ingrese su código de Administrador");
								cod=scan.nextInt();
								if (cod==codAdmin)
								{
									do
									{
										System.out.println();
										System.out.println("1 - Recargar el monedero");
										System.out.println("2 - Retirar dinero recaudado");
										System.out.println("3 - Actualizar valores de dinero válidos");
										System.out.println("4 - Listado de valores de dinero válidos existentes ");
										System.out.println("5 - Listado del monedero");
										System.out.println("0 - Atrás");
										opS=scan.nextInt();
										
										switch (opS)
										{
											case 1:
											{
												System.out.println("Indique el valor del dinero que desea recargar");
												val= scan.nextInt();
												System.out.println("Ingrese la cantidad de billetes");
												cant = scan.nextInt();
												maqC.recargarMon(val, cant);
											}
												break;
											case 2:
												maqC.retirar();
												break;
											case 3:
											{
												do
												{
													System.out.println("1 - AGREGAR NUEVO DINERO VÁLIDO, 2 - ELIMINAR DINERO VÁLIDO EXISTENTE, 0 - SALIR");
													op=scan.nextInt();
													switch (op)
													{
														case 1:
														{
															System.out.println("Indique su valor");
															val =scan.nextInt();
															System.out.println("Ingrese una descripción (ej, billete)");
															desc = scan.next();
															maqC.agregarDin(val,desc);
														}
															break;
														case 2:
														{
															System.out.println("Indique su valor");
															val =scan.nextInt();
															maqC.eliminarDin(val);
														}
															break;
													}
													
												}while (op!=0);
												
											}
												break;
											case 4:
												maqC.listarV();
												break;
											case 5:
												maqC.listarM();
												break;
												
										}
									}while (opS!=0);
	
								}
								else
									System.out.println("ERROR: código inválido");
						} 
						break;
					}
						
				} while(opM!=0);	
			}
					break;
					
				
		}
	}while (opG!=0);
		
	}

}
