package Menues;

import java.util.ArrayList;
import clases.CuentaCorriente;
import clases.Movimiento;
import FinalprogramacionII.MetodosGeneral;

public class MenuCuentaCorriente {
	
	
	//MENU CTA CTE
		public static void menuDatosCtaCte(ArrayList <CuentaCorriente> lista) {
			if(lista != null) {
				System.out.println("Bienvenido al menú de datos de cuenta/s:");
				System.out.println("1 - Datos de una cuenta.");
				System.out.println("2 - Datos de todas las cuentas.");
				System.out.println("3 - Salir.");
				
				CuentaCorriente elemento = null;
				String numAux=null; int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
				}while(num < 1 || num > 3);
				
				switch(num) {
				case 1:
					elemento = menuSelectCtaCte(lista);
					elemento.datosCtaCte(elemento.getMovimiento());
					break;
								
				case 2:
					CuentaCorriente.listarCtaCtes();
					break;
					
				case 3:
					System.out.println("Saliendo...");
					break;
								
				default:
					break;
				}
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			Menu.menusDatos();
		}
				
		public static void menuIngresoCtaCte(ArrayList <CuentaCorriente> lista) {
			System.out.println("Bienvenido al menú de ingreso de datos de cuenta/s:");
			System.out.println("1 - Ingresar una cuenta.");
			System.out.println("2 - Buscar una cuenta por su codigo.");
			System.out.println("3 - Modificar algunos de los datos de una cuenta.");
			System.out.println("4 - Salir.");
		
			CuentaCorriente elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 4);
						
			switch(num) {
			case 1:
				CuentaCorriente.altaCtaCte(MenuMovimiento.menuListaMovimientos(Movimiento.listaMovimiento));
				break;
							
			case 2:
				if(lista != null) {
					elemento = CuentaCorriente.buscarCtaCteCodigo();
					MenuCuentaCorriente.menuCtaCte(elemento, lista);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 3:
				if(lista != null) {
					elemento = menuSelectCtaCte(lista);
					elemento.modificarCtaCte(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
				
			case 4:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
			Menu.menusIngresar();
		}
		
		public static void menuCtaCte(CuentaCorriente ctacte, ArrayList <CuentaCorriente> lista) {
			if(ctacte != null && lista != null) {
				System.out.println("Bienvenido al menú general de cuenta/s:");
				System.out.println("1 - Ver datos.");
				System.out.println("2 - Modificar algún dato.");
				System.out.println("3 - Salir.");
			
				String numAux=null; int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
				}while(num < 1 || num > 3);
							
				switch(num) {
				case 1:
					ctacte.datosCtaCte(ctacte.getMovimiento());
					break;
					
				case 2:
					ctacte.modificarCtaCte(ctacte);
					break;
					
				case 3:
					System.out.println("Saliendo...");
					break;
					
				default:
					break;
				}
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			MenuCuentaCorriente.menuIngresoCtaCte(lista);
		}
		
		public static CuentaCorriente menuSelectCtaCte(ArrayList <CuentaCorriente> lista) {
			if(lista != null) {
				int cont = 1, limit = lista.size();
				for(CuentaCorriente elemento : lista) {
					System.out.println(cont + " - " + elemento.getDetalle());
					cont++;
				}
				
				String numAux=null; int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
				}while(num < 1 || num > limit+1);
				
				return lista.get(num-1);
			}else {
				System.out.println("No se encontraron datos.");
			}
			return null;
		}


}
